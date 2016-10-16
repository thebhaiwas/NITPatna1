package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmm.zza;
import com.google.android.gms.internal.zzpr.zzb;

public abstract class zzmn<T> extends zza {
    protected zzb<T> bF;

    public zzmn(zzb<T> com_google_android_gms_internal_zzpr_zzb_T) {
        this.bF = com_google_android_gms_internal_zzpr_zzb_T;
    }

    public void zza(Response response) {
    }

    public void zza(Status status) {
    }

    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    public void zza(Status status, boolean z) {
    }
}
