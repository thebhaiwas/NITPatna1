package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

public abstract class zzpn {
    public final int it;
    public final int sn;

    public static final class zza extends zzpn {
        public final com.google.android.gms.internal.zzpr.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> so;

        public zza(int i, int i2, com.google.android.gms.internal.zzpr.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb) {
            super(i, i2);
            this.so = com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb;
        }

        public boolean cancel() {
            return this.so.zzaos();
        }

        public void zza(SparseArray<zzrd> sparseArray) {
            zzrd com_google_android_gms_internal_zzrd = (zzrd) sparseArray.get(this.sn);
            if (com_google_android_gms_internal_zzrd != null) {
                com_google_android_gms_internal_zzrd.zzg(this.so);
            }
        }

        public void zzb(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) throws DeadObjectException {
            this.so.zzb(com_google_android_gms_common_api_Api_zzb);
        }

        public void zzx(@NonNull Status status) {
            this.so.zzz(status);
        }
    }

    public static final class zzb<TResult> extends zzpn {
        private static final Status sr;
        private final zzrb<com.google.android.gms.common.api.Api.zzb, TResult> sp;
        private final TaskCompletionSource<TResult> sq;

        static {
            sr = new Status(8, "Connection to Google Play services was lost while executing the API call.");
        }

        public zzb(int i, int i2, zzrb<com.google.android.gms.common.api.Api.zzb, TResult> com_google_android_gms_internal_zzrb_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource) {
            super(i, i2);
            this.sq = taskCompletionSource;
            this.sp = com_google_android_gms_internal_zzrb_com_google_android_gms_common_api_Api_zzb__TResult;
        }

        public void zzb(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) throws DeadObjectException {
            try {
                this.sp.zza(com_google_android_gms_common_api_Api_zzb, this.sq);
            } catch (DeadObjectException e) {
                zzx(sr);
                throw e;
            } catch (RemoteException e2) {
                zzx(sr);
            }
        }

        public void zzx(@NonNull Status status) {
            if (status.getStatusCode() == 8) {
                this.sq.setException(new FirebaseException(status.getStatusMessage()));
            } else {
                this.sq.setException(new FirebaseApiNotAvailableException(status.getStatusMessage()));
            }
        }
    }

    public zzpn(int i, int i2) {
        this.sn = i;
        this.it = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray<zzrd> sparseArray) {
    }

    public abstract void zzb(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) throws DeadObjectException;

    public abstract void zzx(@NonNull Status status);
}
