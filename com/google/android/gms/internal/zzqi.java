package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zzpr.zza;

public class zzqi<O extends ApiOptions> extends zzpz {
    private final zzc<O> uP;

    public zzqi(zzc<O> com_google_android_gms_common_api_zzc_O) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.uP = com_google_android_gms_common_api_zzc_O;
    }

    public Looper getLooper() {
        return this.uP.getLooper();
    }

    public void zza(zzrc com_google_android_gms_internal_zzrc) {
        this.uP.zzanu();
    }

    public void zzb(zzrc com_google_android_gms_internal_zzrc) {
        this.uP.zzanv();
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(@NonNull T t) {
        return this.uP.zza((zza) t);
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(@NonNull T t) {
        return this.uP.zzb((zza) t);
    }
}
