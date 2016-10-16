package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzank<T> {
    public abstract void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException;

    public abstract T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException;

    public final zzamy zzcl(T t) {
        try {
            zzaor com_google_android_gms_internal_zzaog = new zzaog();
            zza(com_google_android_gms_internal_zzaog, t);
            return com_google_android_gms_internal_zzaog.m80l();
        } catch (Throwable e) {
            throw new zzamz(e);
        }
    }
}
