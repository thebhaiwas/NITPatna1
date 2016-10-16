package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzd;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzrd {
    private static final com.google.android.gms.internal.zzpr.zza<?, ?>[] vt;
    private final Map<zzc<?>, zze> tY;
    final Set<com.google.android.gms.internal.zzpr.zza<?, ?>> vu;
    private final zzb vv;

    interface zzb {
        void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> com_google_android_gms_internal_zzpr_zza___);
    }

    /* renamed from: com.google.android.gms.internal.zzrd.1 */
    class C04961 implements zzb {
        final /* synthetic */ zzrd vw;

        C04961(zzrd com_google_android_gms_internal_zzrd) {
            this.vw = com_google_android_gms_internal_zzrd;
        }

        public void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> com_google_android_gms_internal_zzpr_zza___) {
            this.vw.vu.remove(com_google_android_gms_internal_zzpr_zza___);
            if (com_google_android_gms_internal_zzpr_zza___.zzaog() != null && null != null) {
                null.remove(com_google_android_gms_internal_zzpr_zza___.zzaog().intValue());
            }
        }
    }

    private static class zza implements DeathRecipient, zzb {
        private final WeakReference<com.google.android.gms.internal.zzpr.zza<?, ?>> vx;
        private final WeakReference<zzd> vy;
        private final WeakReference<IBinder> vz;

        private zza(com.google.android.gms.internal.zzpr.zza<?, ?> com_google_android_gms_internal_zzpr_zza___, zzd com_google_android_gms_common_api_zzd, IBinder iBinder) {
            this.vy = new WeakReference(com_google_android_gms_common_api_zzd);
            this.vx = new WeakReference(com_google_android_gms_internal_zzpr_zza___);
            this.vz = new WeakReference(iBinder);
        }

        private void zzaqd() {
            com.google.android.gms.internal.zzpr.zza com_google_android_gms_internal_zzpr_zza = (com.google.android.gms.internal.zzpr.zza) this.vx.get();
            zzd com_google_android_gms_common_api_zzd = (zzd) this.vy.get();
            if (!(com_google_android_gms_common_api_zzd == null || com_google_android_gms_internal_zzpr_zza == null)) {
                com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpr_zza.zzaog().intValue());
            }
            IBinder iBinder = (IBinder) this.vz.get();
            if (this.vz != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzaqd();
        }

        public void zzh(com.google.android.gms.internal.zzpr.zza<?, ?> com_google_android_gms_internal_zzpr_zza___) {
            zzaqd();
        }
    }

    static {
        vt = new com.google.android.gms.internal.zzpr.zza[0];
    }

    public zzrd(zzc<?> com_google_android_gms_common_api_Api_zzc_, zze com_google_android_gms_common_api_Api_zze) {
        this.vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.vv = new C04961(this);
        this.tY = new ArrayMap();
        this.tY.put(com_google_android_gms_common_api_Api_zzc_, com_google_android_gms_common_api_Api_zze);
    }

    public zzrd(Map<zzc<?>, zze> map) {
        this.vu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.vv = new C04961(this);
        this.tY = map;
    }

    private static void zza(com.google.android.gms.internal.zzpr.zza<?, ?> com_google_android_gms_internal_zzpr_zza___, zzd com_google_android_gms_common_api_zzd, IBinder iBinder) {
        if (com_google_android_gms_internal_zzpr_zza___.isReady()) {
            com_google_android_gms_internal_zzpr_zza___.zza(new zza(com_google_android_gms_common_api_zzd, iBinder, null));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_google_android_gms_internal_zzpr_zza___.zza(null);
            com_google_android_gms_internal_zzpr_zza___.cancel();
            com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpr_zza___.zzaog().intValue());
        } else {
            zzb com_google_android_gms_internal_zzrd_zza = new zza(com_google_android_gms_common_api_zzd, iBinder, null);
            com_google_android_gms_internal_zzpr_zza___.zza(com_google_android_gms_internal_zzrd_zza);
            try {
                iBinder.linkToDeath(com_google_android_gms_internal_zzrd_zza, 0);
            } catch (RemoteException e) {
                com_google_android_gms_internal_zzpr_zza___.cancel();
                com_google_android_gms_common_api_zzd.remove(com_google_android_gms_internal_zzpr_zza___.zzaog().intValue());
            }
        }
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.vu.size());
    }

    public void release() {
        for (com.google.android.gms.internal.zzpr.zza com_google_android_gms_internal_zzpr_zza : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            com_google_android_gms_internal_zzpr_zza.zza(null);
            if (com_google_android_gms_internal_zzpr_zza.zzaog() != null) {
                com_google_android_gms_internal_zzpr_zza.zzaoo();
                zza(com_google_android_gms_internal_zzpr_zza, null, ((zze) this.tY.get(com_google_android_gms_internal_zzpr_zza.zzanp())).zzans());
                this.vu.remove(com_google_android_gms_internal_zzpr_zza);
            } else if (com_google_android_gms_internal_zzpr_zza.zzaos()) {
                this.vu.remove(com_google_android_gms_internal_zzpr_zza);
            }
        }
    }

    public void zzaqv() {
        for (com.google.android.gms.internal.zzpr.zza zzaa : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            zzaa.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzaqw() {
        for (com.google.android.gms.internal.zzpr.zza isReady : (com.google.android.gms.internal.zzpr.zza[]) this.vu.toArray(vt)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }

    <A extends com.google.android.gms.common.api.Api.zzb> void zzg(com.google.android.gms.internal.zzpr.zza<? extends Result, A> com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A) {
        this.vu.add(com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A);
        com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A.zza(this.vv);
    }
}
