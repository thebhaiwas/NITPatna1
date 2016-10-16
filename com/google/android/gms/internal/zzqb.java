package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzqb implements zzqe {
    private final Context mContext;
    private final com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> rY;
    private zzq tA;
    private boolean tB;
    private boolean tC;
    private final zzg tD;
    private final Map<Api<?>, Integer> tE;
    private ArrayList<Future<?>> tF;
    private final Lock th;
    private final zzqf tm;
    private final com.google.android.gms.common.zzc tp;
    private ConnectionResult tq;
    private int tr;
    private int ts;
    private int tt;
    private final Bundle tu;
    private final Set<com.google.android.gms.common.api.Api.zzc> tv;
    private zzvx tw;
    private int tx;
    private boolean ty;
    private boolean tz;

    /* renamed from: com.google.android.gms.internal.zzqb.1 */
    class C02471 implements Runnable {
        final /* synthetic */ zzqb tG;

        C02471(zzqb com_google_android_gms_internal_zzqb) {
            this.tG = com_google_android_gms_internal_zzqb;
        }

        public void run() {
            this.tG.tp.zzbp(this.tG.mContext);
        }
    }

    private abstract class zzf implements Runnable {
        final /* synthetic */ zzqb tG;

        private zzf(zzqb com_google_android_gms_internal_zzqb) {
            this.tG = com_google_android_gms_internal_zzqb;
        }

        @WorkerThread
        public void run() {
            this.tG.th.lock();
            try {
                if (!Thread.interrupted()) {
                    zzapi();
                    this.tG.th.unlock();
                }
            } catch (RuntimeException e) {
                this.tG.tm.zza(e);
            } finally {
                this.tG.th.unlock();
            }
        }

        @WorkerThread
        protected abstract void zzapi();
    }

    private static class zza implements com.google.android.gms.common.internal.zzd.zzf {
        private final Api<?> pD;
        private final int sV;
        private final WeakReference<zzqb> tH;

        public zza(zzqb com_google_android_gms_internal_zzqb, Api<?> api, int i) {
            this.tH = new WeakReference(com_google_android_gms_internal_zzqb);
            this.pD = api;
            this.sV = i;
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzqb com_google_android_gms_internal_zzqb = (zzqb) this.tH.get();
            if (com_google_android_gms_internal_zzqb != null) {
                if (Looper.myLooper() == com_google_android_gms_internal_zzqb.tm.sX.getLooper()) {
                    z = true;
                }
                zzab.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzqb.th.lock();
                try {
                    if (com_google_android_gms_internal_zzqb.zzfg(0)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_internal_zzqb.zzb(connectionResult, this.pD, this.sV);
                        }
                        if (com_google_android_gms_internal_zzqb.zzapj()) {
                            com_google_android_gms_internal_zzqb.zzapk();
                        }
                        com_google_android_gms_internal_zzqb.th.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzqb.th.unlock();
                }
            }
        }
    }

    private class zzb extends zzf {
        final /* synthetic */ zzqb tG;
        private final Map<com.google.android.gms.common.api.Api.zze, zza> tI;

        /* renamed from: com.google.android.gms.internal.zzqb.zzb.1 */
        class C04891 extends zza {
            final /* synthetic */ ConnectionResult tJ;
            final /* synthetic */ zzb tK;

            C04891(zzb com_google_android_gms_internal_zzqb_zzb, zzqe com_google_android_gms_internal_zzqe, ConnectionResult connectionResult) {
                this.tK = com_google_android_gms_internal_zzqb_zzb;
                this.tJ = connectionResult;
                super(com_google_android_gms_internal_zzqe);
            }

            public void zzapi() {
                this.tK.tG.zzg(this.tJ);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzqb.zzb.2 */
        class C04902 extends zza {
            final /* synthetic */ zzb tK;
            final /* synthetic */ com.google.android.gms.common.internal.zzd.zzf tL;

            C04902(zzb com_google_android_gms_internal_zzqb_zzb, zzqe com_google_android_gms_internal_zzqe, com.google.android.gms.common.internal.zzd.zzf com_google_android_gms_common_internal_zzd_zzf) {
                this.tK = com_google_android_gms_internal_zzqb_zzb;
                this.tL = com_google_android_gms_common_internal_zzd_zzf;
                super(com_google_android_gms_internal_zzqe);
            }

            public void zzapi() {
                this.tL.zzh(new ConnectionResult(16, null));
            }
        }

        public zzb(zzqb com_google_android_gms_internal_zzqb, Map<com.google.android.gms.common.api.Api.zze, zza> map) {
            this.tG = com_google_android_gms_internal_zzqb;
            super(null);
            this.tI = map;
        }

        @WorkerThread
        public void zzapi() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze : this.tI.keySet()) {
                if (!com_google_android_gms_common_api_Api_zze.zzanr()) {
                    i = 0;
                    i4 = i5;
                } else if (((zza) this.tI.get(com_google_android_gms_common_api_Api_zze)).sV == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.tG.tp.isGooglePlayServicesAvailable(this.tG.mContext);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.tG.ty) {
                    this.tG.tw.connect();
                }
                for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze2 : this.tI.keySet()) {
                    com.google.android.gms.common.internal.zzd.zzf com_google_android_gms_common_internal_zzd_zzf = (com.google.android.gms.common.internal.zzd.zzf) this.tI.get(com_google_android_gms_common_api_Api_zze2);
                    if (!com_google_android_gms_common_api_Api_zze2.zzanr() || i3 == 0) {
                        com_google_android_gms_common_api_Api_zze2.zza(com_google_android_gms_common_internal_zzd_zzf);
                    } else {
                        this.tG.tm.zza(new C04902(this, this.tG, com_google_android_gms_common_internal_zzd_zzf));
                    }
                }
                return;
            }
            this.tG.tm.zza(new C04891(this, this.tG, new ConnectionResult(i3, null)));
        }
    }

    private class zzc extends zzf {
        final /* synthetic */ zzqb tG;
        private final ArrayList<com.google.android.gms.common.api.Api.zze> tM;

        public zzc(zzqb com_google_android_gms_internal_zzqb, ArrayList<com.google.android.gms.common.api.Api.zze> arrayList) {
            this.tG = com_google_android_gms_internal_zzqb;
            super(null);
            this.tM = arrayList;
        }

        @WorkerThread
        public void zzapi() {
            this.tG.tm.sX.tZ = this.tG.zzapp();
            Iterator it = this.tM.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zze) it.next()).zza(this.tG.tA, this.tG.tm.sX.tZ);
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzqb tG;

        private zze(zzqb com_google_android_gms_internal_zzqb) {
            this.tG = com_google_android_gms_internal_zzqb;
        }

        public void onConnected(Bundle bundle) {
            this.tG.tw.zza(new zzd(this.tG));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            this.tG.th.lock();
            try {
                if (this.tG.zzf(connectionResult)) {
                    this.tG.zzapn();
                    this.tG.zzapk();
                } else {
                    this.tG.zzg(connectionResult);
                }
                this.tG.th.unlock();
            } catch (Throwable th) {
                this.tG.th.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzqb> tH;

        /* renamed from: com.google.android.gms.internal.zzqb.zzd.1 */
        class C04911 extends zza {
            final /* synthetic */ zzqb tN;
            final /* synthetic */ SignInResponse tO;
            final /* synthetic */ zzd tP;

            C04911(zzd com_google_android_gms_internal_zzqb_zzd, zzqe com_google_android_gms_internal_zzqe, zzqb com_google_android_gms_internal_zzqb, SignInResponse signInResponse) {
                this.tP = com_google_android_gms_internal_zzqb_zzd;
                this.tN = com_google_android_gms_internal_zzqb;
                this.tO = signInResponse;
                super(com_google_android_gms_internal_zzqe);
            }

            public void zzapi() {
                this.tN.zza(this.tO);
            }
        }

        zzd(zzqb com_google_android_gms_internal_zzqb) {
            this.tH = new WeakReference(com_google_android_gms_internal_zzqb);
        }

        @BinderThread
        public void zzb(SignInResponse signInResponse) {
            zzqb com_google_android_gms_internal_zzqb = (zzqb) this.tH.get();
            if (com_google_android_gms_internal_zzqb != null) {
                com_google_android_gms_internal_zzqb.tm.zza(new C04911(this, com_google_android_gms_internal_zzqb, com_google_android_gms_internal_zzqb, signInResponse));
            }
        }
    }

    public zzqb(zzqf com_google_android_gms_internal_zzqf, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, Lock lock, Context context) {
        this.ts = 0;
        this.tu = new Bundle();
        this.tv = new HashSet();
        this.tF = new ArrayList();
        this.tm = com_google_android_gms_internal_zzqf;
        this.tD = com_google_android_gms_common_internal_zzg;
        this.tE = map;
        this.tp = com_google_android_gms_common_zzc;
        this.rY = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy;
        this.th = lock;
        this.mContext = context;
    }

    private void zza(SignInResponse signInResponse) {
        if (zzfg(0)) {
            ConnectionResult zzatd = signInResponse.zzatd();
            if (zzatd.isSuccess()) {
                ResolveAccountResponse zzbzv = signInResponse.zzbzv();
                ConnectionResult zzatd2 = zzbzv.zzatd();
                if (zzatd2.isSuccess()) {
                    this.tz = true;
                    this.tA = zzbzv.zzatc();
                    this.tB = zzbzv.zzate();
                    this.tC = zzbzv.zzatf();
                    zzapk();
                    return;
                }
                String valueOf = String.valueOf(zzatd2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                zzg(zzatd2);
            } else if (zzf(zzatd)) {
                zzapn();
                zzapk();
            } else {
                zzg(zzatd);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || zze(connectionResult)) ? this.tq == null || i < this.tr : false;
    }

    private boolean zzapj() {
        this.tt--;
        if (this.tt > 0) {
            return false;
        }
        if (this.tt < 0) {
            Log.i("GoogleApiClientConnecting", this.tm.sX.zzapv());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        } else if (this.tq == null) {
            return true;
        } else {
            this.tm.uq = this.tr;
            zzg(this.tq);
            return false;
        }
    }

    private void zzapk() {
        if (this.tt == 0) {
            if (!this.ty || this.tz) {
                zzapl();
            }
        }
    }

    private void zzapl() {
        ArrayList arrayList = new ArrayList();
        this.ts = 1;
        this.tt = this.tm.tY.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.tm.tY.keySet()) {
            if (!this.tm.un.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add((com.google.android.gms.common.api.Api.zze) this.tm.tY.get(com_google_android_gms_common_api_Api_zzc));
            } else if (zzapj()) {
                zzapm();
            }
        }
        if (!arrayList.isEmpty()) {
            this.tF.add(zzqg.zzapz().submit(new zzc(this, arrayList)));
        }
    }

    private void zzapm() {
        this.tm.zzapx();
        zzqg.zzapz().execute(new C02471(this));
        if (this.tw != null) {
            if (this.tB) {
                this.tw.zza(this.tA, this.tC);
            }
            zzbl(false);
        }
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.tm.un.keySet()) {
            ((com.google.android.gms.common.api.Api.zze) this.tm.tY.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.tm.ur.zzm(this.tu.isEmpty() ? null : this.tu);
    }

    private void zzapn() {
        this.ty = false;
        this.tm.sX.tZ = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.tv) {
            if (!this.tm.un.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.tm.un.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void zzapo() {
        Iterator it = this.tF.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.tF.clear();
    }

    private Set<Scope> zzapp() {
        if (this.tD == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.tD.zzasf());
        Map zzash = this.tD.zzash();
        for (Api api : zzash.keySet()) {
            if (!this.tm.un.containsKey(api.zzanp())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzg.zza) zzash.get(api)).dY);
            }
        }
        return hashSet;
    }

    private void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzanm().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.tq = connectionResult;
                this.tr = priority;
            }
        }
        this.tm.un.put(api.zzanp(), connectionResult);
    }

    private void zzbl(boolean z) {
        if (this.tw != null) {
            if (this.tw.isConnected() && z) {
                this.tw.zzbzk();
            }
            this.tw.disconnect();
            this.tA = null;
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.tp.zzfa(connectionResult.getErrorCode()) != null;
    }

    private boolean zzf(ConnectionResult connectionResult) {
        return this.tx != 2 ? this.tx == 1 && !connectionResult.hasResolution() : true;
    }

    private boolean zzfg(int i) {
        if (this.ts == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.tm.sX.zzapv());
        String valueOf = String.valueOf(this);
        Log.i("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.i("GoogleApiClientConnecting", "mRemainingConnections=" + this.tt);
        valueOf = String.valueOf(zzfh(this.ts));
        String valueOf2 = String.valueOf(zzfh(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        zzg(new ConnectionResult(8, null));
        return false;
    }

    private String zzfh(int i) {
        switch (i) {
            case ConnectionResult.SUCCESS /*0*/:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzg(ConnectionResult connectionResult) {
        zzapo();
        zzbl(!connectionResult.hasResolution());
        this.tm.zzi(connectionResult);
        this.tm.ur.zzd(connectionResult);
    }

    public void begin() {
        this.tm.un.clear();
        this.ty = false;
        this.tq = null;
        this.ts = 0;
        this.tx = 2;
        this.tz = false;
        this.tB = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.tE.keySet()) {
            com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze = (com.google.android.gms.common.api.Api.zze) this.tm.tY.get(api.zzanp());
            int intValue = ((Integer) this.tE.get(api)).intValue();
            int i2 = (api.zzanm().getPriority() == 1 ? 1 : 0) | i;
            if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                this.ty = true;
                if (intValue < this.tx) {
                    this.tx = intValue;
                }
                if (intValue != 0) {
                    this.tv.add(api.zzanp());
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zze, new zza(this, api, intValue));
            i = i2;
        }
        if (i != 0) {
            this.ty = false;
        }
        if (this.ty) {
            this.tD.zzc(Integer.valueOf(this.tm.sX.getSessionId()));
            ConnectionCallbacks com_google_android_gms_internal_zzqb_zze = new zze();
            this.tw = (zzvx) this.rY.zza(this.mContext, this.tm.sX.getLooper(), this.tD, this.tD.zzasl(), com_google_android_gms_internal_zzqb_zze, com_google_android_gms_internal_zzqb_zze);
        }
        this.tt = this.tm.tY.size();
        this.tF.add(zzqg.zzapz().submit(new zzb(this, hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzapo();
        zzbl(true);
        this.tm.zzi(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (zzfg(1)) {
            if (bundle != null) {
                this.tu.putAll(bundle);
            }
            if (zzapj()) {
                zzapm();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, null));
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzfg(1)) {
            zzb(connectionResult, api, i);
            if (zzapj()) {
                zzapm();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpr.zza<R, A>> T zzc(T t) {
        this.tm.sX.tS.add(t);
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpr.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
