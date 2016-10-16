package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class zzqh implements Callback {
    private static zzqh uw;
    private static final Object zzamp;
    private final Context mContext;
    private final Handler mHandler;
    private final GoogleApiAvailability rX;
    private long tU;
    private long tV;
    private final Map<zzpo<?>, zzc<?>> uA;
    private zzpw uB;
    private final Set<zzpo<?>> uC;
    private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> uD;
    private final SparseArray<zza> uE;
    private zzb uF;
    private long uv;
    private int ux;
    private final AtomicInteger uy;
    private final SparseArray<zzc<?>> uz;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzc<?>> {
        private final int sn;
        final /* synthetic */ zzqh uG;

        public zza(zzqh com_google_android_gms_internal_zzqh, com.google.android.gms.common.api.zzc com_google_android_gms_common_api_zzc, int i, ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue) {
            this.uG = com_google_android_gms_internal_zzqh;
            super(com_google_android_gms_common_api_zzc, referenceQueue);
            this.sn = i;
        }

        public void zzaqd() {
            this.uG.mHandler.sendMessage(this.uG.mHandler.obtainMessage(2, this.sn, 2));
        }
    }

    private static final class zzb extends Thread {
        private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> uD;
        private final SparseArray<zza> uE;
        private final AtomicBoolean uH;

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.uH = new AtomicBoolean();
            this.uD = referenceQueue;
            this.uE = sparseArray;
        }

        public void run() {
            this.uH.set(true);
            Process.setThreadPriority(10);
            while (this.uH.get()) {
                try {
                    zza com_google_android_gms_internal_zzqh_zza = (zza) this.uD.remove();
                    this.uE.remove(com_google_android_gms_internal_zzqh_zza.sn);
                    com_google_android_gms_internal_zzqh_zza.zzaqd();
                } catch (InterruptedException e) {
                } finally {
                    this.uH.set(false);
                }
            }
        }
    }

    private class zzc<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener {
        private final zzpo<O> rG;
        private boolean tT;
        final /* synthetic */ zzqh uG;
        private final Queue<zzpn> uI;
        private final zze uJ;
        private final com.google.android.gms.common.api.Api.zzb uK;
        private final SparseArray<zzrd> uL;
        private final Set<zzpq> uM;
        private final SparseArray<Map<Object, com.google.android.gms.internal.zzpr.zza>> uN;
        private ConnectionResult uO;

        @WorkerThread
        public zzc(zzqh com_google_android_gms_internal_zzqh, com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O) {
            this.uG = com_google_android_gms_internal_zzqh;
            this.uI = new LinkedList();
            this.uL = new SparseArray();
            this.uM = new HashSet();
            this.uN = new SparseArray();
            this.uO = null;
            this.uJ = zzb((com.google.android.gms.common.api.zzc) com_google_android_gms_common_api_zzc_O);
            if (this.uJ instanceof zzah) {
                this.uK = ((zzah) this.uJ).zzatj();
            } else {
                this.uK = this.uJ;
            }
            this.rG = com_google_android_gms_common_api_zzc_O.zzany();
        }

        @WorkerThread
        private void connect() {
            if (!this.uJ.isConnected() && !this.uJ.isConnecting()) {
                if (this.uJ.zzanr() && this.uG.ux != 0) {
                    this.uG.ux = this.uG.rX.isGooglePlayServicesAvailable(this.uG.mContext);
                    if (this.uG.ux != 0) {
                        onConnectionFailed(new ConnectionResult(this.uG.ux, null));
                        return;
                    }
                }
                this.uJ.zza(new zzd(this.uG, this.uJ, this.rG));
            }
        }

        @WorkerThread
        private void resume() {
            if (this.tT) {
                connect();
            }
        }

        @WorkerThread
        private void zzab(Status status) {
            for (zzpn zzx : this.uI) {
                zzx.zzx(status);
            }
            this.uI.clear();
        }

        @WorkerThread
        private void zzapr() {
            if (this.tT) {
                zzaqh();
                zzab(this.uG.rX.isGooglePlayServicesAvailable(this.uG.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.uJ.disconnect();
            }
        }

        @WorkerThread
        private void zzaqh() {
            if (this.tT) {
                this.uG.mHandler.removeMessages(9, this.rG);
                this.uG.mHandler.removeMessages(8, this.rG);
                this.tT = false;
            }
        }

        private void zzaqi() {
            this.uG.mHandler.removeMessages(10, this.rG);
            this.uG.mHandler.sendMessageDelayed(this.uG.mHandler.obtainMessage(10, this.rG), this.uG.uv);
        }

        private void zzaqj() {
            if (this.uJ.isConnected() && this.uN.size() == 0) {
                for (int i = 0; i < this.uL.size(); i++) {
                    if (((zzrd) this.uL.get(this.uL.keyAt(i))).zzaqw()) {
                        zzaqi();
                        return;
                    }
                }
                this.uJ.disconnect();
            }
        }

        @WorkerThread
        private zze zzb(com.google.android.gms.common.api.zzc com_google_android_gms_common_api_zzc) {
            Api zzanw = com_google_android_gms_common_api_zzc.zzanw();
            if (!zzanw.zzanq()) {
                return com_google_android_gms_common_api_zzc.zzanw().zzann().zza(com_google_android_gms_common_api_zzc.getApplicationContext(), this.uG.mHandler.getLooper(), zzg.zzcd(com_google_android_gms_common_api_zzc.getApplicationContext()), com_google_android_gms_common_api_zzc.zzanx(), this, this);
            }
            zzh zzano = zzanw.zzano();
            return new zzah(com_google_android_gms_common_api_zzc.getApplicationContext(), this.uG.mHandler.getLooper(), zzano.zzant(), this, this, zzg.zzcd(com_google_android_gms_common_api_zzc.getApplicationContext()), zzano.zzs(com_google_android_gms_common_api_zzc.zzanx()));
        }

        @WorkerThread
        private void zzc(zzpn com_google_android_gms_internal_zzpn) {
            com_google_android_gms_internal_zzpn.zza(this.uL);
            Map map;
            if (com_google_android_gms_internal_zzpn.it == 3) {
                try {
                    Map map2;
                    map = (Map) this.uN.get(com_google_android_gms_internal_zzpn.sn);
                    if (map == null) {
                        ArrayMap arrayMap = new ArrayMap(1);
                        this.uN.put(com_google_android_gms_internal_zzpn.sn, arrayMap);
                        map2 = arrayMap;
                    } else {
                        map2 = map;
                    }
                    com.google.android.gms.internal.zzpr.zza com_google_android_gms_internal_zzpr_zza = ((com.google.android.gms.internal.zzpn.zza) com_google_android_gms_internal_zzpn).so;
                    map2.put(((zzqr) com_google_android_gms_internal_zzpr_zza).zzaqq(), com_google_android_gms_internal_zzpr_zza);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (com_google_android_gms_internal_zzpn.it == 4) {
                try {
                    map = (Map) this.uN.get(com_google_android_gms_internal_zzpn.sn);
                    zzqr com_google_android_gms_internal_zzqr = (zzqr) ((com.google.android.gms.internal.zzpn.zza) com_google_android_gms_internal_zzpn).so;
                    if (map != null) {
                        map.remove(com_google_android_gms_internal_zzqr.zzaqq());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                com_google_android_gms_internal_zzpn.zzb(this.uK);
            } catch (DeadObjectException e3) {
                this.uJ.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzpq zza : this.uM) {
                zza.zza(this.rG, connectionResult);
            }
            this.uM.clear();
        }

        boolean isConnected() {
            return this.uJ.isConnected();
        }

        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzaqf();
            zzj(ConnectionResult.qR);
            zzaqh();
            for (int i = 0; i < this.uN.size(); i++) {
                for (com.google.android.gms.internal.zzpr.zza zzb : ((Map) this.uN.get(this.uN.keyAt(i))).values()) {
                    try {
                        zzb.zzb(this.uK);
                    } catch (DeadObjectException e) {
                        this.uJ.disconnect();
                        onConnectionSuspended(1);
                    }
                }
            }
            zzaqe();
            zzaqi();
        }

        @WorkerThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzaqf();
            this.uG.ux = -1;
            zzj(connectionResult);
            int keyAt = this.uL.keyAt(0);
            if (this.uI.isEmpty()) {
                this.uO = connectionResult;
                return;
            }
            synchronized (zzqh.zzamp) {
                if (null == null || !this.uG.uC.contains(this.rG)) {
                    if (!this.uG.zzc(connectionResult, keyAt)) {
                        if (connectionResult.getErrorCode() == 18) {
                            this.tT = true;
                        }
                        if (this.tT) {
                            this.uG.mHandler.sendMessageDelayed(Message.obtain(this.uG.mHandler, 8, this.rG), this.uG.tV);
                            return;
                        }
                        String valueOf = String.valueOf(this.rG.zzaok());
                        zzab(new Status(17, new StringBuilder(String.valueOf(valueOf).length() + 38).append("API: ").append(valueOf).append(" is not available on this device.").toString()));
                        return;
                    }
                    return;
                }
                null.zzb(connectionResult, keyAt);
            }
        }

        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzaqf();
            this.tT = true;
            this.uG.mHandler.sendMessageDelayed(Message.obtain(this.uG.mHandler, 8, this.rG), this.uG.tV);
            this.uG.mHandler.sendMessageDelayed(Message.obtain(this.uG.mHandler, 9, this.rG), this.uG.tU);
            this.uG.ux = -1;
        }

        @WorkerThread
        public void zzaqe() {
            while (this.uJ.isConnected() && !this.uI.isEmpty()) {
                zzc((zzpn) this.uI.remove());
            }
        }

        @WorkerThread
        public void zzaqf() {
            this.uO = null;
        }

        ConnectionResult zzaqg() {
            return this.uO;
        }

        @WorkerThread
        public void zzb(zzpn com_google_android_gms_internal_zzpn) {
            if (this.uJ.isConnected()) {
                zzc(com_google_android_gms_internal_zzpn);
                zzaqi();
                return;
            }
            this.uI.add(com_google_android_gms_internal_zzpn);
            if (this.uO == null || !this.uO.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.uO);
            }
        }

        @WorkerThread
        public void zzb(zzpq com_google_android_gms_internal_zzpq) {
            this.uM.add(com_google_android_gms_internal_zzpq);
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator it = this.uI.iterator();
            while (it.hasNext()) {
                zzpn com_google_android_gms_internal_zzpn = (zzpn) it.next();
                if (com_google_android_gms_internal_zzpn.sn == i && com_google_android_gms_internal_zzpn.it != 1 && com_google_android_gms_internal_zzpn.cancel()) {
                    it.remove();
                }
            }
            ((zzrd) this.uL.get(i)).release();
            this.uN.delete(i);
            if (!z) {
                this.uL.remove(i);
                this.uG.uE.remove(i);
                if (this.uL.size() == 0 && this.uI.isEmpty()) {
                    zzaqh();
                    this.uJ.disconnect();
                    this.uG.uA.remove(this.rG);
                    synchronized (zzqh.zzamp) {
                        this.uG.uC.remove(this.rG);
                    }
                }
            }
        }

        @WorkerThread
        public void zzfk(int i) {
            this.uL.put(i, new zzrd(this.rG.zzanp(), this.uJ));
        }
    }

    private class zzd implements zzf {
        private final zzpo<?> rG;
        final /* synthetic */ zzqh uG;
        private final zze uJ;

        public zzd(zzqh com_google_android_gms_internal_zzqh, zze com_google_android_gms_common_api_Api_zze, zzpo<?> com_google_android_gms_internal_zzpo_) {
            this.uG = com_google_android_gms_internal_zzqh;
            this.uJ = com_google_android_gms_common_api_Api_zze;
            this.rG = com_google_android_gms_internal_zzpo_;
        }

        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.uJ.zza(null, Collections.emptySet());
            } else {
                ((zzc) this.uG.uA.get(this.rG)).onConnectionFailed(connectionResult);
            }
        }
    }

    static {
        zzamp = new Object();
    }

    private zzqh(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqh(Context context, GoogleApiAvailability googleApiAvailability) {
        this.tV = 5000;
        this.tU = 120000;
        this.uv = 10000;
        this.ux = -1;
        this.uy = new AtomicInteger(1);
        this.uz = new SparseArray();
        this.uA = new ConcurrentHashMap(5, 0.75f, 1);
        this.uB = null;
        this.uC = new com.google.android.gms.common.util.zza();
        this.uD = new ReferenceQueue();
        this.uE = new SparseArray();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.rX = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_) {
        int andIncrement = this.uy.getAndIncrement();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, andIncrement, 0, com_google_android_gms_common_api_zzc_));
        return andIncrement;
    }

    public static Pair<zzqh, Integer> zza(Context context, com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_) {
        Pair<zzqh, Integer> create;
        synchronized (zzamp) {
            if (uw == null) {
                uw = new zzqh(context.getApplicationContext());
            }
            create = Pair.create(uw, Integer.valueOf(uw.zza((com.google.android.gms.common.api.zzc) com_google_android_gms_common_api_zzc_)));
        }
        return create;
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_, int i) {
        zzpo zzany = com_google_android_gms_common_api_zzc_.zzany();
        if (!this.uA.containsKey(zzany)) {
            this.uA.put(zzany, new zzc(this, com_google_android_gms_common_api_zzc_));
        }
        zzc com_google_android_gms_internal_zzqh_zzc = (zzc) this.uA.get(zzany);
        com_google_android_gms_internal_zzqh_zzc.zzfk(i);
        this.uz.put(i, com_google_android_gms_internal_zzqh_zzc);
        com_google_android_gms_internal_zzqh_zzc.connect();
        this.uE.put(i, new zza(this, com_google_android_gms_common_api_zzc_, i, this.uD));
        if (this.uF == null || !this.uF.uH.get()) {
            this.uF = new zzb(this.uD, this.uE);
            this.uF.start();
        }
    }

    @WorkerThread
    private void zza(zzpn com_google_android_gms_internal_zzpn) {
        ((zzc) this.uz.get(com_google_android_gms_internal_zzpn.sn)).zzb(com_google_android_gms_internal_zzpn);
    }

    public static zzqh zzaqa() {
        zzqh com_google_android_gms_internal_zzqh;
        synchronized (zzamp) {
            com_google_android_gms_internal_zzqh = uw;
        }
        return com_google_android_gms_internal_zzqh;
    }

    @WorkerThread
    private void zzaqb() {
        for (zzc com_google_android_gms_internal_zzqh_zzc : this.uA.values()) {
            com_google_android_gms_internal_zzqh_zzc.zzaqf();
            com_google_android_gms_internal_zzqh_zzc.connect();
        }
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc com_google_android_gms_internal_zzqh_zzc = (zzc) this.uz.get(i);
        if (com_google_android_gms_internal_zzqh_zzc != null) {
            if (!z) {
                this.uz.delete(i);
            }
            com_google_android_gms_internal_zzqh_zzc.zzf(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                zza((zzpq) message.obj);
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
            case ConnectionResult.NETWORK_ERROR /*7*/:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                zze(i, z);
                break;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                zzaqb();
                break;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                zza((zzpn) message.obj);
                break;
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                if (this.uz.get(message.arg1) != null) {
                    ((zzc) this.uz.get(message.arg1)).zzab(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                zza((com.google.android.gms.common.api.zzc) message.obj, message.arg1);
                break;
            case ConnectionResult.INTERNAL_ERROR /*8*/:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).resume();
                    break;
                }
                break;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).zzapr();
                    break;
                }
                break;
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                if (this.uA.containsKey(message.obj)) {
                    ((zzc) this.uA.get(message.obj)).zzaqj();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0));
        }
    }

    public <O extends ApiOptions> void zza(com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O, int i, com.google.android.gms.internal.zzpr.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new com.google.android.gms.internal.zzpn.zza(com_google_android_gms_common_api_zzc_O.getInstanceId(), i, com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb)));
    }

    public <O extends ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O, int i, zzrb<com.google.android.gms.common.api.Api.zzb, TResult> com_google_android_gms_internal_zzrb_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new com.google.android.gms.internal.zzpn.zzb(com_google_android_gms_common_api_zzc_O.getInstanceId(), i, com_google_android_gms_internal_zzrb_com_google_android_gms_common_api_Api_zzb__TResult, taskCompletionSource)));
    }

    @WorkerThread
    public void zza(zzpq com_google_android_gms_internal_zzpq) {
        for (zzpo com_google_android_gms_internal_zzpo : com_google_android_gms_internal_zzpq.zzaon()) {
            zzc com_google_android_gms_internal_zzqh_zzc = (zzc) this.uA.get(com_google_android_gms_internal_zzpo);
            if (com_google_android_gms_internal_zzqh_zzc == null) {
                com_google_android_gms_internal_zzpq.cancel();
                return;
            } else if (com_google_android_gms_internal_zzqh_zzc.isConnected()) {
                com_google_android_gms_internal_zzpq.zza(com_google_android_gms_internal_zzpo, ConnectionResult.qR);
            } else if (com_google_android_gms_internal_zzqh_zzc.zzaqg() != null) {
                com_google_android_gms_internal_zzpq.zza(com_google_android_gms_internal_zzpo, com_google_android_gms_internal_zzqh_zzc.zzaqg());
            } else {
                com_google_android_gms_internal_zzqh_zzc.zzb(com_google_android_gms_internal_zzpq);
            }
        }
    }

    public void zza(zzpw com_google_android_gms_internal_zzpw) {
        synchronized (zzamp) {
            if (com_google_android_gms_internal_zzpw == null) {
                this.uB = null;
                this.uC.clear();
            }
        }
    }

    public void zzaol() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    boolean zzc(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.rX.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.rX.zza(this.mContext, connectionResult, i);
        return true;
    }

    public void zzd(int i, boolean z) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i, z ? 1 : 2));
    }
}
