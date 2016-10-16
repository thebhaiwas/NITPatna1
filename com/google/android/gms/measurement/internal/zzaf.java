package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zze;

public class zzaf extends zzaa {
    private long anE;
    private final Runnable anF;
    private final zzf anG;
    private final zzf anH;
    private Handler mHandler;

    /* renamed from: com.google.android.gms.measurement.internal.zzaf.1 */
    class C02751 implements Runnable {
        final /* synthetic */ zzaf anI;

        /* renamed from: com.google.android.gms.measurement.internal.zzaf.1.1 */
        class C02741 implements Runnable {
            final /* synthetic */ C02751 anJ;

            C02741(C02751 c02751) {
                this.anJ = c02751;
            }

            public void run() {
                this.anJ.anI.zzbvw();
            }
        }

        C02751(zzaf com_google_android_gms_measurement_internal_zzaf) {
            this.anI = com_google_android_gms_measurement_internal_zzaf;
        }

        @MainThread
        public void run() {
            this.anI.zzbsy().zzl(new C02741(this));
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzaf.4 */
    class C02764 implements Runnable {
        final /* synthetic */ zzaf anI;
        final /* synthetic */ long anK;

        C02764(zzaf com_google_android_gms_measurement_internal_zzaf, long j) {
            this.anI = com_google_android_gms_measurement_internal_zzaf;
            this.anK = j;
        }

        public void run() {
            this.anI.zzbl(this.anK);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzaf.5 */
    class C02775 implements Runnable {
        final /* synthetic */ zzaf anI;
        final /* synthetic */ long anK;

        C02775(zzaf com_google_android_gms_measurement_internal_zzaf, long j) {
            this.anI = com_google_android_gms_measurement_internal_zzaf;
            this.anK = j;
        }

        public void run() {
            this.anI.zzbm(this.anK);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzaf.2 */
    class C05112 extends zzf {
        final /* synthetic */ zzaf anI;

        C05112(zzaf com_google_android_gms_measurement_internal_zzaf, zzx com_google_android_gms_measurement_internal_zzx) {
            this.anI = com_google_android_gms_measurement_internal_zzaf;
            super(com_google_android_gms_measurement_internal_zzx);
        }

        @WorkerThread
        public void run() {
            this.anI.zzbvx();
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzaf.3 */
    class C05123 extends zzf {
        final /* synthetic */ zzaf anI;

        C05123(zzaf com_google_android_gms_measurement_internal_zzaf, zzx com_google_android_gms_measurement_internal_zzx) {
            this.anI = com_google_android_gms_measurement_internal_zzaf;
            super(com_google_android_gms_measurement_internal_zzx);
        }

        @WorkerThread
        public void run() {
            this.anI.zzbvy();
        }
    }

    zzaf(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.anF = new C02751(this);
        this.anG = new C05112(this, this.aja);
        this.anH = new C05123(this, this.aja);
    }

    @WorkerThread
    private void zzbl(long j) {
        zzwu();
        zzbvu();
        this.anG.cancel();
        this.anH.cancel();
        zzbsz().zzbty().zzj("Activity resumed, time", Long.valueOf(j));
        this.anE = j;
        if (zzyw().currentTimeMillis() - zzbta().alF.get() > zzbta().alH.get()) {
            zzbta().alG.set(true);
            zzbta().alI.set(0);
        }
        if (zzbta().alG.get()) {
            this.anG.zzv(Math.max(0, zzbta().alE.get() - zzbta().alI.get()));
        } else {
            this.anH.zzv(Math.max(0, 3600000 - zzbta().alI.get()));
        }
    }

    @WorkerThread
    private void zzbm(long j) {
        zzwu();
        zzbvu();
        this.anG.cancel();
        this.anH.cancel();
        zzbsz().zzbty().zzj("Activity paused, time", Long.valueOf(j));
        if (this.anE != 0) {
            zzbta().alI.set(zzbta().alI.get() + (j - this.anE));
        }
        zzbta().alH.set(zzyw().currentTimeMillis());
        synchronized (this) {
            if (!zzbta().alG.get()) {
                this.mHandler.postDelayed(this.anF, 1000);
            }
        }
    }

    private void zzbvu() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        }
    }

    @WorkerThread
    private void zzbvx() {
        zzwu();
        zzbsz().zzbty().zzj("Session started, time", Long.valueOf(zzyw().elapsedRealtime()));
        zzbta().alG.set(false);
        zzbsq().zze("auto", "_s", new Bundle());
    }

    @WorkerThread
    private void zzbvy() {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.anE == 0) {
            this.anE = elapsedRealtime - 3600000;
        }
        long j = zzbta().alI.get() + (elapsedRealtime - this.anE);
        zzbta().alI.set(j);
        zzbsz().zzbty().zzj("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzbsq().zze("auto", "_e", bundle);
        zzbta().alI.set(0);
        this.anE = elapsedRealtime;
        this.anH.zzv(Math.max(0, 3600000 - zzbta().alI.get()));
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    @MainThread
    protected void zzbvt() {
        synchronized (this) {
            zzbvu();
            this.mHandler.removeCallbacks(this.anF);
        }
        zzbsy().zzl(new C02764(this, zzyw().elapsedRealtime()));
    }

    @MainThread
    protected void zzbvv() {
        zzbsy().zzl(new C02775(this, zzyw().elapsedRealtime()));
    }

    @WorkerThread
    public void zzbvw() {
        zzwu();
        zzbsz().zzbtx().log("Application backgrounded. Logging engagement");
        long j = zzbta().alI.get();
        if (j > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzbsq().zze("auto", "_e", bundle);
            zzbta().alI.set(0);
            return;
        }
        zzbsz().zzbtt().zzj("Not logging non-positive engagement time", Long.valueOf(j));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    protected void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
