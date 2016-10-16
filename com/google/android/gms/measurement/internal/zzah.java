package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

class zzah {
    private final zze zzaoa;
    private long zzboy;

    public zzah(zze com_google_android_gms_common_util_zze) {
        zzab.zzaa(com_google_android_gms_common_util_zze);
        this.zzaoa = com_google_android_gms_common_util_zze;
    }

    public void clear() {
        this.zzboy = 0;
    }

    public void start() {
        this.zzboy = this.zzaoa.elapsedRealtime();
    }

    public boolean zzx(long j) {
        return this.zzboy == 0 || this.zzaoa.elapsedRealtime() - this.zzboy >= j;
    }
}
