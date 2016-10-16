package com.google.android.gms.internal;

public final class zzuh {
    private static zzuh Qr;
    private final zzue Qs;
    private final zzuf Qt;

    static {
        zza(new zzuh());
    }

    private zzuh() {
        this.Qs = new zzue();
        this.Qt = new zzuf();
    }

    protected static void zza(zzuh com_google_android_gms_internal_zzuh) {
        synchronized (zzuh.class) {
            Qr = com_google_android_gms_internal_zzuh;
        }
    }

    private static zzuh zzbfq() {
        zzuh com_google_android_gms_internal_zzuh;
        synchronized (zzuh.class) {
            com_google_android_gms_internal_zzuh = Qr;
        }
        return com_google_android_gms_internal_zzuh;
    }

    public static zzue zzbfr() {
        return zzbfq().Qs;
    }

    public static zzuf zzbfs() {
        return zzbfq().Qt;
    }
}
