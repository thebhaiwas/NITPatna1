package com.google.android.gms.measurement.internal;

abstract class zzaa extends zzz {
    private boolean zzcwt;

    zzaa(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.aja.zzb(this);
    }

    public final void initialize() {
        if (this.zzcwt) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzwv();
        this.aja.zzbvc();
        this.zzcwt = true;
    }

    boolean isInitialized() {
        return this.zzcwt;
    }

    boolean zzbvh() {
        return false;
    }

    protected abstract void zzwv();

    protected void zzzg() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
