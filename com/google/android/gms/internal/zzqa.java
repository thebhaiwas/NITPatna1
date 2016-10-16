package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.zzpr.zza;

public class zzqa implements zzqe {
    private final zzqf tm;
    private boolean tn;

    /* renamed from: com.google.android.gms.internal.zzqa.1 */
    class C04871 extends zza {
        final /* synthetic */ zzqa to;

        C04871(zzqa com_google_android_gms_internal_zzqa, zzqe com_google_android_gms_internal_zzqe) {
            this.to = com_google_android_gms_internal_zzqa;
            super(com_google_android_gms_internal_zzqe);
        }

        public void zzapi() {
            this.to.onConnectionSuspended(1);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqa.2 */
    class C04882 extends zza {
        final /* synthetic */ zzqa to;

        C04882(zzqa com_google_android_gms_internal_zzqa, zzqe com_google_android_gms_internal_zzqe) {
            this.to = com_google_android_gms_internal_zzqa;
            super(com_google_android_gms_internal_zzqe);
        }

        public void zzapi() {
            this.to.tm.ur.zzm(null);
        }
    }

    public zzqa(zzqf com_google_android_gms_internal_zzqf) {
        this.tn = false;
        this.tm = com_google_android_gms_internal_zzqf;
    }

    private <A extends zzb> void zzf(zza<? extends Result, A> com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A) throws DeadObjectException {
        this.tm.sX.ue.zzg(com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A);
        zzb zzb = this.tm.sX.zzb(com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A.zzanp());
        if (zzb.isConnected() || !this.tm.un.containsKey(com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A.zzanp())) {
            if (zzb instanceof zzah) {
                zzb = ((zzah) zzb).zzatj();
            }
            com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A.zzb(zzb);
            return;
        }
        com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__A.zzz(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.tn) {
            this.tn = false;
            this.tm.zza(new C04882(this, this));
        }
    }

    public boolean disconnect() {
        if (this.tn) {
            return false;
        }
        if (this.tm.sX.zzapu()) {
            this.tn = true;
            for (zzrc zzaqt : this.tm.sX.ud) {
                zzaqt.zzaqt();
            }
            return false;
        }
        this.tm.zzi(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.tm.zzi(null);
        this.tm.ur.zzc(i, this.tn);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    void zzaph() {
        if (this.tn) {
            this.tn = false;
            this.tm.sX.ue.release();
            disconnect();
        }
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        return zzd(t);
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException e) {
            this.tm.zza(new C04871(this, this));
        }
        return t;
    }
}
