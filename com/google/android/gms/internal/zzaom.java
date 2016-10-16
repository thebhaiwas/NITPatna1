package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaoj.zza;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class zzaom<T> extends zzank<T> {
    private final zzank<T> bej;
    private final zzams bgf;
    private final Type bgg;

    zzaom(zzams com_google_android_gms_internal_zzams, zzank<T> com_google_android_gms_internal_zzank_T, Type type) {
        this.bgf = com_google_android_gms_internal_zzams;
        this.bej = com_google_android_gms_internal_zzank_T;
        this.bgg = type;
    }

    private Type zzb(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
        zzank com_google_android_gms_internal_zzank = this.bej;
        Type zzb = zzb(this.bgg, t);
        if (zzb != this.bgg) {
            com_google_android_gms_internal_zzank = this.bgf.zza(zzaoo.zzl(zzb));
            if ((com_google_android_gms_internal_zzank instanceof zza) && !(this.bej instanceof zza)) {
                com_google_android_gms_internal_zzank = this.bej;
            }
        }
        com_google_android_gms_internal_zzank.zza(com_google_android_gms_internal_zzaor, t);
    }

    public T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        return this.bej.zzb(com_google_android_gms_internal_zzaop);
    }
}
