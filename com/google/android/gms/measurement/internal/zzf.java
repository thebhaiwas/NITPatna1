package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

abstract class zzf {
    private static volatile Handler zzczj;
    private boolean ajR;
    private final zzx aja;
    private volatile long zzczk;
    private final Runnable zzw;

    /* renamed from: com.google.android.gms.measurement.internal.zzf.1 */
    class C02781 implements Runnable {
        final /* synthetic */ zzf ajS;

        C02781(zzf com_google_android_gms_measurement_internal_zzf) {
            this.ajS = com_google_android_gms_measurement_internal_zzf;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.ajS.aja.zzbsy().zzl(this);
                return;
            }
            boolean zzfc = this.ajS.zzfc();
            this.ajS.zzczk = 0;
            if (zzfc && this.ajS.ajR) {
                this.ajS.run();
            }
        }
    }

    zzf(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzx);
        this.aja = com_google_android_gms_measurement_internal_zzx;
        this.ajR = true;
        this.zzw = new C02781(this);
    }

    private Handler getHandler() {
        if (zzczj != null) {
            return zzczj;
        }
        Handler handler;
        synchronized (zzf.class) {
            if (zzczj == null) {
                zzczj = new Handler(this.aja.getContext().getMainLooper());
            }
            handler = zzczj;
        }
        return handler;
    }

    public void cancel() {
        this.zzczk = 0;
        getHandler().removeCallbacks(this.zzw);
    }

    public abstract void run();

    public boolean zzfc() {
        return this.zzczk != 0;
    }

    public void zzv(long j) {
        cancel();
        if (j >= 0) {
            this.zzczk = this.aja.zzyw().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzw, j)) {
                this.aja.zzbsz().zzbtr().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
