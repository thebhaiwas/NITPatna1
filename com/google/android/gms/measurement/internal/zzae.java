package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvz;

public final class zzae {
    private static Boolean zzcsb;
    private final zza anz;
    private final Context mContext;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.measurement.internal.zzae.1 */
    class C02731 implements Runnable {
        final /* synthetic */ zzx anA;
        final /* synthetic */ zzp anB;
        final /* synthetic */ zzae anC;
        final /* synthetic */ int zzcsd;

        /* renamed from: com.google.android.gms.measurement.internal.zzae.1.1 */
        class C02721 implements Runnable {
            final /* synthetic */ C02731 anD;

            C02721(C02731 c02731) {
                this.anD = c02731;
            }

            public void run() {
                if (!this.anD.anC.anz.callServiceStopSelfResult(this.anD.zzcsd)) {
                    return;
                }
                if (this.anD.anA.zzbtb().zzabc()) {
                    this.anD.anB.zzbty().log("Device AppMeasurementService processed last upload request");
                } else {
                    this.anD.anB.zzbty().log("Local AppMeasurementService processed last upload request");
                }
            }
        }

        C02731(zzae com_google_android_gms_measurement_internal_zzae, zzx com_google_android_gms_measurement_internal_zzx, int i, zzp com_google_android_gms_measurement_internal_zzp) {
            this.anC = com_google_android_gms_measurement_internal_zzae;
            this.anA = com_google_android_gms_measurement_internal_zzx;
            this.zzcsd = i;
            this.anB = com_google_android_gms_measurement_internal_zzp;
        }

        public void run() {
            this.anA.zzbvd();
            this.anA.zzbuy();
            this.anC.mHandler.post(new C02721(this));
        }
    }

    public interface zza {
        boolean callServiceStopSelfResult(int i);

        Context getContext();
    }

    public zzae(zza com_google_android_gms_measurement_internal_zzae_zza) {
        this.mContext = com_google_android_gms_measurement_internal_zzae_zza.getContext();
        zzab.zzaa(this.mContext);
        this.anz = com_google_android_gms_measurement_internal_zzae_zza;
        this.mHandler = new Handler();
    }

    public static boolean zzaw(Context context) {
        zzab.zzaa(context);
        if (zzcsb != null) {
            return zzcsb.booleanValue();
        }
        boolean zzk = zzal.zzk(context, "com.google.android.gms.measurement.AppMeasurementService");
        zzcsb = Boolean.valueOf(zzk);
        return zzk;
    }

    private zzp zzbsz() {
        return zzx.zzdo(this.mContext).zzbsz();
    }

    private void zzvw() {
        try {
            synchronized (zzu.zzamp) {
                zzvz com_google_android_gms_internal_zzvz = zzu.zzcrz;
                if (com_google_android_gms_internal_zzvz != null && com_google_android_gms_internal_zzvz.isHeld()) {
                    com_google_android_gms_internal_zzvz.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @MainThread
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzy(zzx.zzdo(this.mContext));
        }
        zzbsz().zzbtt().zzj("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public void onCreate() {
        zzx zzdo = zzx.zzdo(this.mContext);
        zzp zzbsz = zzdo.zzbsz();
        if (zzdo.zzbtb().zzabc()) {
            zzbsz.zzbty().log("Device AppMeasurementService is starting up");
        } else {
            zzbsz.zzbty().log("Local AppMeasurementService is starting up");
        }
    }

    @MainThread
    public void onDestroy() {
        zzx zzdo = zzx.zzdo(this.mContext);
        zzp zzbsz = zzdo.zzbsz();
        if (zzdo.zzbtb().zzabc()) {
            zzbsz.zzbty().log("Device AppMeasurementService is shutting down");
        } else {
            zzbsz.zzbty().log("Local AppMeasurementService is shutting down");
        }
    }

    @MainThread
    public void onRebind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onRebind called with null intent");
            return;
        }
        zzbsz().zzbty().zzj("onRebind called. action", intent.getAction());
    }

    @MainThread
    public int onStartCommand(Intent intent, int i, int i2) {
        zzvw();
        zzx zzdo = zzx.zzdo(this.mContext);
        zzp zzbsz = zzdo.zzbsz();
        if (intent == null) {
            zzbsz.zzbtt().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (zzdo.zzbtb().zzabc()) {
                zzbsz.zzbty().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                zzbsz.zzbty().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzdo.zzbsy().zzl(new C02731(this, zzdo, i2, zzbsz));
            }
        }
        return 2;
    }

    @MainThread
    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzbsz().zzbtr().log("onUnbind called with null intent");
        } else {
            zzbsz().zzbty().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
