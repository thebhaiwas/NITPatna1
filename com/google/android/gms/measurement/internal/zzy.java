package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.support.annotation.BinderThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.measurement.internal.zzm.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzy extends zza {
    private final zzx aja;
    private final boolean amQ;

    /* renamed from: com.google.android.gms.measurement.internal.zzy.1 */
    class C02841 implements Runnable {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;

        C02841(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amR.ajD);
            this.amS.aja.zzc(this.amR);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.2 */
    class C02852 implements Runnable {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;
        final /* synthetic */ EventParcel amT;

        C02852(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata, EventParcel eventParcel) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
            this.amT = eventParcel;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amR.ajD);
            this.amS.aja.zzb(this.amT, this.amR);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.3 */
    class C02863 implements Runnable {
        final /* synthetic */ String aee;
        final /* synthetic */ zzy amS;
        final /* synthetic */ EventParcel amT;
        final /* synthetic */ String amU;

        C02863(zzy com_google_android_gms_measurement_internal_zzy, String str, EventParcel eventParcel, String str2) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amU = str;
            this.amT = eventParcel;
            this.aee = str2;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amU);
            this.amS.aja.zzb(this.amT, this.aee);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.4 */
    class C02874 implements Callable<byte[]> {
        final /* synthetic */ String aee;
        final /* synthetic */ zzy amS;
        final /* synthetic */ EventParcel amT;

        C02874(zzy com_google_android_gms_measurement_internal_zzy, EventParcel eventParcel, String str) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amT = eventParcel;
            this.aee = str;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbvf();
        }

        public byte[] zzbvf() throws Exception {
            this.amS.aja.zzbvd();
            return this.amS.aja.zza(this.amT, this.aee);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.5 */
    class C02885 implements Runnable {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;
        final /* synthetic */ UserAttributeParcel amV;

        C02885(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
            this.amV = userAttributeParcel;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amR.ajD);
            this.amS.aja.zzc(this.amV, this.amR);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.6 */
    class C02896 implements Runnable {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;
        final /* synthetic */ UserAttributeParcel amV;

        C02896(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
            this.amV = userAttributeParcel;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amR.ajD);
            this.amS.aja.zzb(this.amV, this.amR);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.7 */
    class C02907 implements Callable<List<zzak>> {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;

        C02907(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbvg();
        }

        public List<zzak> zzbvg() throws Exception {
            this.amS.aja.zzbvd();
            return this.amS.aja.zzbsu().zzln(this.amR.packageName);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzy.8 */
    class C02918 implements Runnable {
        final /* synthetic */ AppMetadata amR;
        final /* synthetic */ zzy amS;

        C02918(zzy com_google_android_gms_measurement_internal_zzy, AppMetadata appMetadata) {
            this.amS = com_google_android_gms_measurement_internal_zzy;
            this.amR = appMetadata;
        }

        public void run() {
            this.amS.aja.zzbvd();
            this.amS.zzmf(this.amR.ajD);
            this.amS.aja.zzd(this.amR);
        }
    }

    public zzy(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzx);
        this.aja = com_google_android_gms_measurement_internal_zzx;
        this.amQ = false;
    }

    public zzy(zzx com_google_android_gms_measurement_internal_zzx, boolean z) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzx);
        this.aja = com_google_android_gms_measurement_internal_zzx;
        this.amQ = z;
    }

    @BinderThread
    private void zzf(AppMetadata appMetadata) {
        zzab.zzaa(appMetadata);
        zzmg(appMetadata.packageName);
        this.aja.zzbsv().zzmr(appMetadata.ajz);
    }

    @BinderThread
    private void zzmg(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.aja.zzbsz().zzbtr().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzmh(str);
        } catch (SecurityException e) {
            this.aja.zzbsz().zzbtr().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    @BinderThread
    public List<UserAttributeParcel> zza(AppMetadata appMetadata, boolean z) {
        Object e;
        zzf(appMetadata);
        try {
            List<zzak> list = (List) this.aja.zzbsy().zzd(new C02907(this, appMetadata)).get();
            List<UserAttributeParcel> arrayList = new ArrayList(list.size());
            for (zzak com_google_android_gms_measurement_internal_zzak : list) {
                if (z || !zzal.zzmu(com_google_android_gms_measurement_internal_zzak.mName)) {
                    arrayList.add(new UserAttributeParcel(com_google_android_gms_measurement_internal_zzak));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.aja.zzbsz().zzbtr().zzj("Failed to get user attributes", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.aja.zzbsz().zzbtr().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    @BinderThread
    public void zza(AppMetadata appMetadata) {
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new C02918(this, appMetadata));
    }

    @BinderThread
    public void zza(EventParcel eventParcel, AppMetadata appMetadata) {
        zzab.zzaa(eventParcel);
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new C02852(this, appMetadata, eventParcel));
    }

    @BinderThread
    public void zza(EventParcel eventParcel, String str, String str2) {
        zzab.zzaa(eventParcel);
        zzab.zzhs(str);
        zzmg(str);
        this.aja.zzbsy().zzl(new C02863(this, str2, eventParcel, str));
    }

    @BinderThread
    public void zza(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzab.zzaa(userAttributeParcel);
        zzf(appMetadata);
        if (userAttributeParcel.getValue() == null) {
            this.aja.zzbsy().zzl(new C02885(this, appMetadata, userAttributeParcel));
        } else {
            this.aja.zzbsy().zzl(new C02896(this, appMetadata, userAttributeParcel));
        }
    }

    @BinderThread
    public byte[] zza(EventParcel eventParcel, String str) {
        Object e;
        zzab.zzhs(str);
        zzab.zzaa(eventParcel);
        zzmg(str);
        this.aja.zzbsz().zzbtx().zzj("Log and bundle. event", eventParcel.name);
        long nanoTime = this.aja.zzyw().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.aja.zzbsy().zze(new C02874(this, eventParcel, str)).get();
            if (bArr == null) {
                this.aja.zzbsz().zzbtr().log("Log and bundle returned null");
                bArr = new byte[0];
            }
            this.aja.zzbsz().zzbtx().zzd("Log and bundle processed. event, size, time_ms", eventParcel.name, Integer.valueOf(bArr.length), Long.valueOf((this.aja.zzyw().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.aja.zzbsz().zzbtr().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.aja.zzbsz().zzbtr().zze("Failed to log and bundle. event, error", eventParcel.name, e);
            return null;
        }
    }

    @BinderThread
    public void zzb(AppMetadata appMetadata) {
        zzf(appMetadata);
        this.aja.zzbsy().zzl(new C02841(this, appMetadata));
    }

    @WorkerThread
    void zzmf(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":", 2);
            if (split.length == 2) {
                try {
                    long longValue = Long.valueOf(split[0]).longValue();
                    if (longValue > 0) {
                        this.aja.zzbta().alu.zzg(split[1], longValue);
                    } else {
                        this.aja.zzbsz().zzbtt().zzj("Combining sample with a non-positive weight", Long.valueOf(longValue));
                    }
                } catch (NumberFormatException e) {
                    this.aja.zzbsz().zzbtt().zzj("Combining sample with a non-number weight", split[0]);
                }
            }
        }
    }

    protected void zzmh(String str) throws SecurityException {
        int myUid = this.amQ ? Process.myUid() : Binder.getCallingUid();
        if (!com.google.android.gms.common.util.zzy.zzb(this.aja.getContext(), myUid, str)) {
            if (!com.google.android.gms.common.util.zzy.zze(this.aja.getContext(), myUid) || this.aja.zzbuu()) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
        }
    }
}
