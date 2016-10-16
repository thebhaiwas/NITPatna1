package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzuo.zza;
import com.google.android.gms.internal.zzuo.zzb;
import com.google.android.gms.internal.zzuo.zzc;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;

public class zzv extends zzaa {
    private final Map<String, Map<String, String>> alR;
    private final Map<String, Map<String, Boolean>> alS;
    private final Map<String, Map<String, Boolean>> alT;
    private final Map<String, zzb> alU;
    private final Map<String, String> alV;

    zzv(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.alR = new ArrayMap();
        this.alS = new ArrayMap();
        this.alT = new ArrayMap();
        this.alU = new ArrayMap();
        this.alV = new ArrayMap();
    }

    private Map<String, String> zza(zzb com_google_android_gms_internal_zzuo_zzb) {
        Map<String, String> arrayMap = new ArrayMap();
        if (!(com_google_android_gms_internal_zzuo_zzb == null || com_google_android_gms_internal_zzuo_zzb.aoB == null)) {
            for (zzc com_google_android_gms_internal_zzuo_zzc : com_google_android_gms_internal_zzuo_zzb.aoB) {
                if (com_google_android_gms_internal_zzuo_zzc != null) {
                    arrayMap.put(com_google_android_gms_internal_zzuo_zzc.zzcb, com_google_android_gms_internal_zzuo_zzc.value);
                }
            }
        }
        return arrayMap;
    }

    private void zza(String str, zzb com_google_android_gms_internal_zzuo_zzb) {
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        if (!(com_google_android_gms_internal_zzuo_zzb == null || com_google_android_gms_internal_zzuo_zzb.aoC == null)) {
            for (zza com_google_android_gms_internal_zzuo_zza : com_google_android_gms_internal_zzuo_zzb.aoC) {
                if (com_google_android_gms_internal_zzuo_zza != null) {
                    String str2 = (String) AppMeasurement.zza.ajb.get(com_google_android_gms_internal_zzuo_zza.name);
                    if (str2 != null) {
                        com_google_android_gms_internal_zzuo_zza.name = str2;
                    }
                    arrayMap.put(com_google_android_gms_internal_zzuo_zza.name, com_google_android_gms_internal_zzuo_zza.aox);
                    arrayMap2.put(com_google_android_gms_internal_zzuo_zza.name, com_google_android_gms_internal_zzuo_zza.aoy);
                }
            }
        }
        this.alS.put(str, arrayMap);
        this.alT.put(str, arrayMap2);
    }

    @WorkerThread
    private zzb zze(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzb();
        }
        zzaou zzaz = zzaou.zzaz(bArr);
        zzb com_google_android_gms_internal_zzuo_zzb = new zzb();
        try {
            zzb com_google_android_gms_internal_zzuo_zzb2 = (zzb) com_google_android_gms_internal_zzuo_zzb.zzb(zzaz);
            zzbsz().zzbty().zze("Parsed config. version, gmp_app_id", com_google_android_gms_internal_zzuo_zzb.aoz, com_google_android_gms_internal_zzuo_zzb.ajz);
            return com_google_android_gms_internal_zzuo_zzb;
        } catch (IOException e) {
            zzbsz().zzbtt().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    @WorkerThread
    private void zzmb(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        if (!this.alU.containsKey(str)) {
            byte[] zzlq = zzbsu().zzlq(str);
            if (zzlq == null) {
                this.alR.put(str, null);
                this.alS.put(str, null);
                this.alT.put(str, null);
                this.alU.put(str, null);
                this.alV.put(str, null);
                return;
            }
            zzb zze = zze(str, zzlq);
            this.alR.put(str, zza(zze));
            zza(str, zze);
            this.alU.put(str, zze);
            this.alV.put(str, null);
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    String zzaw(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alR.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    @WorkerThread
    boolean zzax(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alS.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    boolean zzay(String str, String str2) {
        zzwu();
        zzmb(str);
        Map map = (Map) this.alT.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    @WorkerThread
    protected boolean zzb(String str, byte[] bArr, String str2) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzb zze = zze(str, bArr);
        if (zze == null) {
            return false;
        }
        zza(str, zze);
        this.alU.put(str, zze);
        this.alV.put(str, str2);
        this.alR.put(str, zza(zze));
        zzbsp().zza(str, zze.aoD);
        try {
            zze.aoD = null;
            byte[] bArr2 = new byte[zze.ao()];
            zze.zza(zzaov.zzba(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzbsz().zzbtt().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzbsu().zzd(str, bArr);
        return true;
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

    @WorkerThread
    protected zzb zzmc(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzmb(str);
        return (zzb) this.alU.get(str);
    }

    @WorkerThread
    protected String zzmd(String str) {
        zzwu();
        return (String) this.alV.get(str);
    }

    @WorkerThread
    protected void zzme(String str) {
        zzwu();
        this.alV.put(str, null);
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
