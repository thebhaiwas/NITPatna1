package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpr.zzb;

public final class zzrl implements zzrk {

    private static class zza extends zzri {
        private final zzb<Status> zj;

        public zza(zzb<Status> com_google_android_gms_internal_zzpr_zzb_com_google_android_gms_common_api_Status) {
            this.zj = com_google_android_gms_internal_zzpr_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzgj(int i) throws RemoteException {
            this.zj.setResult(new Status(i));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrl.1 */
    class C06001 extends zza {
        final /* synthetic */ zzrl zi;

        C06001(zzrl com_google_android_gms_internal_zzrl, GoogleApiClient googleApiClient) {
            this.zi = com_google_android_gms_internal_zzrl;
            super(googleApiClient);
        }

        protected void zza(zzrn com_google_android_gms_internal_zzrn) throws RemoteException {
            ((zzrp) com_google_android_gms_internal_zzrn.zzarw()).zza(new zza(this));
        }
    }

    public PendingResult<Status> zzg(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new C06001(this, googleApiClient));
    }
}
