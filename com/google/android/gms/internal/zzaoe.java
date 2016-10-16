package com.google.android.gms.internal;

public final class zzaoe implements zzanl {
    private final zzans beb;

    public zzaoe(zzans com_google_android_gms_internal_zzans) {
        this.beb = com_google_android_gms_internal_zzans;
    }

    static zzank<?> zza(zzans com_google_android_gms_internal_zzans, zzams com_google_android_gms_internal_zzams, zzaoo<?> com_google_android_gms_internal_zzaoo_, zzanm com_google_android_gms_internal_zzanm) {
        Class value = com_google_android_gms_internal_zzanm.value();
        if (zzank.class.isAssignableFrom(value)) {
            return (zzank) com_google_android_gms_internal_zzans.zzb(zzaoo.zzr(value)).m16a();
        }
        if (zzanl.class.isAssignableFrom(value)) {
            return ((zzanl) com_google_android_gms_internal_zzans.zzb(zzaoo.zzr(value)).m16a()).zza(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzaoo_);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        zzanm com_google_android_gms_internal_zzanm = (zzanm) com_google_android_gms_internal_zzaoo_T.m18s().getAnnotation(zzanm.class);
        return com_google_android_gms_internal_zzanm == null ? null : zza(this.beb, com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzaoo_T, com_google_android_gms_internal_zzanm);
    }
}
