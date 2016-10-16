package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import xyz.purush.nitp.nitpatna.BuildConfig;

public final class zzqd extends GoogleApiClient implements com.google.android.gms.internal.zzqm.zza {
    private final Context mContext;
    private final int rV;
    private final GoogleApiAvailability rX;
    final com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> rY;
    final zzg tD;
    final Map<Api<?>, Integer> tE;
    private final zzl tQ;
    private zzqm tR;
    final Queue<com.google.android.gms.internal.zzpr.zza<?, ?>> tS;
    private volatile boolean tT;
    private long tU;
    private long tV;
    private final zza tW;
    zzqj tX;
    final Map<zzc<?>, zze> tY;
    Set<Scope> tZ;
    private final Lock th;
    private final zzqt ua;
    private final ArrayList<zzpu> ub;
    private Integer uc;
    Set<zzrc> ud;
    final zzrd ue;
    private final com.google.android.gms.common.internal.zzl.zza uf;
    private final Looper zzahv;

    final class zza extends Handler {
        final /* synthetic */ zzqd ug;

        zza(zzqd com_google_android_gms_internal_zzqd, Looper looper) {
            this.ug = com_google_android_gms_internal_zzqd;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    this.ug.zzapr();
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    this.ug.resume();
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqd.1 */
    class C04921 implements com.google.android.gms.common.internal.zzl.zza {
        final /* synthetic */ zzqd ug;

        C04921(zzqd com_google_android_gms_internal_zzqd) {
            this.ug = com_google_android_gms_internal_zzqd;
        }

        public boolean isConnected() {
            return this.ug.isConnected();
        }

        public Bundle zzamc() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqd.2 */
    class C04932 implements ConnectionCallbacks {
        final /* synthetic */ zzqd ug;
        final /* synthetic */ AtomicReference uh;
        final /* synthetic */ zzqz ui;

        C04932(zzqd com_google_android_gms_internal_zzqd, AtomicReference atomicReference, zzqz com_google_android_gms_internal_zzqz) {
            this.ug = com_google_android_gms_internal_zzqd;
            this.uh = atomicReference;
            this.ui = com_google_android_gms_internal_zzqz;
        }

        public void onConnected(Bundle bundle) {
            this.ug.zza((GoogleApiClient) this.uh.get(), this.ui, true);
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqd.3 */
    class C04943 implements OnConnectionFailedListener {
        final /* synthetic */ zzqd ug;
        final /* synthetic */ zzqz ui;

        C04943(zzqd com_google_android_gms_internal_zzqd, zzqz com_google_android_gms_internal_zzqz) {
            this.ug = com_google_android_gms_internal_zzqd;
            this.ui = com_google_android_gms_internal_zzqz;
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            this.ui.zzc(new Status(8));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqd.4 */
    class C04954 implements ResultCallback<Status> {
        final /* synthetic */ GoogleApiClient iD;
        final /* synthetic */ zzqd ug;
        final /* synthetic */ zzqz ui;
        final /* synthetic */ boolean uj;

        C04954(zzqd com_google_android_gms_internal_zzqd, zzqz com_google_android_gms_internal_zzqz, boolean z, GoogleApiClient googleApiClient) {
            this.ug = com_google_android_gms_internal_zzqd;
            this.ui = com_google_android_gms_internal_zzqz;
            this.uj = z;
            this.iD = googleApiClient;
        }

        public /* synthetic */ void onResult(@NonNull Result result) {
            zzp((Status) result);
        }

        public void zzp(@NonNull Status status) {
            zzk.zzbc(this.ug.mContext).zzagl();
            if (status.isSuccess() && this.ug.isConnected()) {
                this.ug.reconnect();
            }
            this.ui.zzc((Result) status);
            if (this.uj) {
                this.iD.disconnect();
            }
        }
    }

    static class zzb extends com.google.android.gms.internal.zzqj.zza {
        private WeakReference<zzqd> uk;

        zzb(zzqd com_google_android_gms_internal_zzqd) {
            this.uk = new WeakReference(com_google_android_gms_internal_zzqd);
        }

        public void zzaor() {
            zzqd com_google_android_gms_internal_zzqd = (zzqd) this.uk.get();
            if (com_google_android_gms_internal_zzqd != null) {
                com_google_android_gms_internal_zzqd.resume();
            }
        }
    }

    public zzqd(Context context, Lock lock, Looper looper, zzg com_google_android_gms_common_internal_zzg, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zze> map2, int i, int i2, ArrayList<zzpu> arrayList) {
        this.tR = null;
        this.tS = new LinkedList();
        this.tU = 120000;
        this.tV = 5000;
        this.tZ = new HashSet();
        this.ua = new zzqt();
        this.uc = null;
        this.ud = null;
        this.uf = new C04921(this);
        this.mContext = context;
        this.th = lock;
        this.tQ = new zzl(looper, this.uf);
        this.zzahv = looper;
        this.tW = new zza(this, looper);
        this.rX = googleApiAvailability;
        this.rV = i;
        if (this.rV >= 0) {
            this.uc = Integer.valueOf(i2);
        }
        this.tE = map;
        this.tY = map2;
        this.ub = arrayList;
        this.ue = new zzrd(this.tY);
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.tQ.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.tQ.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.tD = com_google_android_gms_common_internal_zzg;
        this.rY = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy;
    }

    private void resume() {
        this.th.lock();
        try {
            if (isResuming()) {
                zzapq();
            }
            this.th.unlock();
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    public static int zza(Iterable<zze> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (zze com_google_android_gms_common_api_Api_zze : iterable) {
            if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                i2 = 1;
            }
            i = com_google_android_gms_common_api_Api_zze.zzafz() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private void zza(GoogleApiClient googleApiClient, zzqz com_google_android_gms_internal_zzqz, boolean z) {
        zzrj.zh.zzg(googleApiClient).setResultCallback(new C04954(this, com_google_android_gms_internal_zzqz, z, googleApiClient));
    }

    private void zzapq() {
        this.tQ.zzast();
        this.tR.connect();
    }

    private void zzapr() {
        this.th.lock();
        try {
            if (zzapt()) {
                zzapq();
            }
            this.th.unlock();
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    private void zzb(@NonNull zzqn com_google_android_gms_internal_zzqn) {
        if (this.rV >= 0) {
            zzpp.zza(com_google_android_gms_internal_zzqn).zzff(this.rV);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    private void zzfi(int i) {
        if (this.uc == null) {
            this.uc = Integer.valueOf(i);
        } else if (this.uc.intValue() != i) {
            String valueOf = String.valueOf(zzfj(i));
            String valueOf2 = String.valueOf(zzfj(this.uc.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.tR == null) {
            Object obj = null;
            Object obj2 = null;
            for (zze com_google_android_gms_common_api_Api_zze : this.tY.values()) {
                if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                    obj2 = 1;
                }
                obj = com_google_android_gms_common_api_Api_zze.zzafz() ? 1 : obj;
            }
            switch (this.uc.intValue()) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    if (obj2 != null) {
                        this.tR = zzpv.zza(this.mContext, this, this.th, this.zzahv, this.rX, this.tY, this.tD, this.tE, this.rY, this.ub);
                        return;
                    }
                    break;
            }
            this.tR = new zzqf(this.mContext, this, this.th, this.zzahv, this.rX, this.tY, this.tD, this.tE, this.rY, this.ub, this);
        }
    }

    static String zzfj(int i) {
        switch (i) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return "SIGN_IN_MODE_REQUIRED";
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return "SIGN_IN_MODE_OPTIONAL";
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.th.lock();
        try {
            if (this.rV >= 0) {
                if (this.uc == null) {
                    z = false;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.uc == null) {
                this.uc = Integer.valueOf(zza(this.tY.values(), false));
            } else if (this.uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzfi(this.uc.intValue());
            this.tQ.zzast();
            ConnectionResult blockingConnect = this.tR.blockingConnect();
            return blockingConnect;
        } finally {
            this.th.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzab.zzb((Object) timeUnit, (Object) "TimeUnit must not be null");
        this.th.lock();
        try {
            if (this.uc == null) {
                this.uc = Integer.valueOf(zza(this.tY.values(), false));
            } else if (this.uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzfi(this.uc.intValue());
            this.tQ.zzast();
            ConnectionResult blockingConnect = this.tR.blockingConnect(j, timeUnit);
            return blockingConnect;
        } finally {
            this.th.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzab.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzab.zza(this.uc.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        PendingResult com_google_android_gms_internal_zzqz = new zzqz((GoogleApiClient) this);
        if (this.tY.containsKey(zzrj.bN)) {
            zza(this, com_google_android_gms_internal_zzqz, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new Builder(this.mContext).addApi(zzrj.API).addConnectionCallbacks(new C04932(this, atomicReference, com_google_android_gms_internal_zzqz)).addOnConnectionFailedListener(new C04943(this, com_google_android_gms_internal_zzqz)).setHandler(this.tW).build();
            atomicReference.set(build);
            build.connect();
        }
        return com_google_android_gms_internal_zzqz;
    }

    public void connect() {
        boolean z = false;
        this.th.lock();
        try {
            if (this.rV >= 0) {
                if (this.uc != null) {
                    z = true;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.uc == null) {
                this.uc = Integer.valueOf(zza(this.tY.values(), false));
            } else if (this.uc.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.uc.intValue());
        } finally {
            this.th.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.th.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzab.zzb(z, "Illegal sign-in mode: " + i);
            zzfi(i);
            zzapq();
        } finally {
            this.th.unlock();
        }
    }

    public void disconnect() {
        this.th.lock();
        try {
            this.ue.release();
            if (this.tR != null) {
                this.tR.disconnect();
            }
            this.ua.release();
            for (com.google.android.gms.internal.zzpr.zza com_google_android_gms_internal_zzpr_zza : this.tS) {
                com_google_android_gms_internal_zzpr_zza.zza(null);
                com_google_android_gms_internal_zzpr_zza.cancel();
            }
            this.tS.clear();
            if (this.tR != null) {
                zzapt();
                this.tQ.zzass();
                this.th.unlock();
            }
        } finally {
            this.th.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.tT);
        printWriter.append(" mWorkQueue.size()=").print(this.tS.size());
        this.ue.dump(printWriter);
        if (this.tR != null) {
            this.tR.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.th.lock();
        try {
            if (!isConnected() && !isResuming()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.tY.containsKey(api.zzanp())) {
                ConnectionResult connectionResult = this.tR.getConnectionResult(api);
                if (connectionResult != null) {
                    this.th.unlock();
                } else if (isResuming()) {
                    connectionResult = ConnectionResult.qR;
                } else {
                    Log.i("GoogleApiClientImpl", zzapv());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.th.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.th.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzahv;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        zze com_google_android_gms_common_api_Api_zze = (zze) this.tY.get(api.zzanp());
        return com_google_android_gms_common_api_Api_zze != null && com_google_android_gms_common_api_Api_zze.isConnected();
    }

    public boolean isConnected() {
        return this.tR != null && this.tR.isConnected();
    }

    public boolean isConnecting() {
        return this.tR != null && this.tR.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
        return this.tQ.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        return this.tQ.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    boolean isResuming() {
        return this.tT;
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.tQ.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.tQ.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzb(new zzqn(fragmentActivity));
    }

    public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        this.tQ.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this.tQ.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public <C extends zze> C zza(@NonNull zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (zze) this.tY.get(com_google_android_gms_common_api_Api_zzc_C);
        zzab.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void zza(zzrc com_google_android_gms_internal_zzrc) {
        this.th.lock();
        try {
            if (this.ud == null) {
                this.ud = new HashSet();
            }
            this.ud.add(com_google_android_gms_internal_zzrc);
        } finally {
            this.th.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.tY.containsKey(api.zzanp());
    }

    public boolean zza(zzqy com_google_android_gms_internal_zzqy) {
        return this.tR != null && this.tR.zza(com_google_android_gms_internal_zzqy);
    }

    public void zzaoc() {
        if (this.tR != null) {
            this.tR.zzaoc();
        }
    }

    void zzaps() {
        if (!isResuming()) {
            this.tT = true;
            if (this.tX == null) {
                this.tX = this.rX.zza(this.mContext.getApplicationContext(), new zzb(this));
            }
            this.tW.sendMessageDelayed(this.tW.obtainMessage(1), this.tU);
            this.tW.sendMessageDelayed(this.tW.obtainMessage(2), this.tV);
        }
    }

    boolean zzapt() {
        if (!isResuming()) {
            return false;
        }
        this.tT = false;
        this.tW.removeMessages(2);
        this.tW.removeMessages(1);
        if (this.tX != null) {
            this.tX.unregister();
            this.tX = null;
        }
        return true;
    }

    boolean zzapu() {
        boolean z = false;
        this.th.lock();
        try {
            if (this.ud != null) {
                if (!this.ud.isEmpty()) {
                    z = true;
                }
                this.th.unlock();
            }
            return z;
        } finally {
            this.th.unlock();
        }
    }

    String zzapv() {
        Writer stringWriter = new StringWriter();
        dump(BuildConfig.FLAVOR, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    <C extends zze> C zzb(zzc<?> com_google_android_gms_common_api_Api_zzc_) {
        Object obj = (zze) this.tY.get(com_google_android_gms_common_api_Api_zzc_);
        zzab.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void zzb(zzrc com_google_android_gms_internal_zzrc) {
        this.th.lock();
        try {
            if (this.ud == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.ud.remove(com_google_android_gms_internal_zzrc)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzapu()) {
                this.tR.zzaoy();
            }
            this.th.unlock();
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpr.zza<R, A>> T zzc(@NonNull T t) {
        zzab.zzb(t.zzanp() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.tY.containsKey(t.zzanp());
        String name = t.zzanw() != null ? t.zzanw().getName() : "the API";
        zzab.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.th.lock();
        try {
            if (this.tR == null) {
                this.tS.add(t);
            } else {
                t = this.tR.zzc(t);
                this.th.unlock();
            }
            return t;
        } finally {
            this.th.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzaps();
        }
        this.ue.zzaqv();
        this.tQ.zzgb(i);
        this.tQ.zzass();
        if (i == 2) {
            zzapq();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        zzab.zzb(t.zzanp() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.tY.containsKey(t.zzanp());
        String name = t.zzanw() != null ? t.zzanw().getName() : "the API";
        zzab.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.th.lock();
        try {
            if (this.tR == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (isResuming()) {
                this.tS.add(t);
                while (!this.tS.isEmpty()) {
                    com.google.android.gms.internal.zzpr.zza com_google_android_gms_internal_zzpr_zza = (com.google.android.gms.internal.zzpr.zza) this.tS.remove();
                    this.ue.zzg(com_google_android_gms_internal_zzpr_zza);
                    com_google_android_gms_internal_zzpr_zza.zzz(Status.si);
                }
            } else {
                t = this.tR.zzd(t);
                this.th.unlock();
            }
            return t;
        } finally {
            this.th.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.rX.zzc(this.mContext, connectionResult.getErrorCode())) {
            zzapt();
        }
        if (!isResuming()) {
            this.tQ.zzm(connectionResult);
            this.tQ.zzass();
        }
    }

    public void zzm(Bundle bundle) {
        while (!this.tS.isEmpty()) {
            zzd((com.google.android.gms.internal.zzpr.zza) this.tS.remove());
        }
        this.tQ.zzo(bundle);
    }

    public <L> zzqs<L> zzt(@NonNull L l) {
        this.th.lock();
        try {
            zzqs<L> zzb = this.ua.zzb(l, this.zzahv);
            return zzb;
        } finally {
            this.th.unlock();
        }
    }
}
