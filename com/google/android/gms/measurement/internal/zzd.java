package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri.Builder;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.text.TextUtils;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.measurement.internal.zzl.zza;

public class zzd extends zzz {
    static final String ajI;
    private Boolean zzczf;

    static {
        ajI = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    }

    zzd(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    @Nullable
    private Boolean zzlj(@Size(min = 1) String str) {
        Boolean bool = null;
        zzab.zzhs(str);
        try {
            PackageManager packageManager = getContext().getPackageManager();
            if (packageManager == null) {
                zzbsz().zzbtr().log("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getContext().getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT);
                if (applicationInfo == null) {
                    zzbsz().zzbtr().log("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    zzbsz().zzbtr().log("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            zzbsz().zzbtr().zzj("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public long zza(String str, zza<Long> com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long) {
        if (str == null) {
            return ((Long) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long.get()).longValue();
        }
        Object zzaw = zzbsw().zzaw(str, com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return ((Long) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long.get()).longValue();
        }
        try {
            return ((Long) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long.get(Long.valueOf(Long.valueOf(zzaw).longValue()))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Long.get()).longValue();
        }
    }

    public boolean zzabc() {
        return false;
    }

    public boolean zzabd() {
        if (this.zzczf == null) {
            synchronized (this) {
                if (this.zzczf == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzavv = zzt.zzavv();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzavv);
                        this.zzczf = Boolean.valueOf(z);
                    }
                    if (this.zzczf == null) {
                        this.zzczf = Boolean.TRUE;
                        zzbsz().zzbtr().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzczf.booleanValue();
    }

    long zzabx() {
        return ((Long) zzl.akI.get()).longValue();
    }

    public String zzacc() {
        return "google_app_measurement.db";
    }

    public String zzacd() {
        return "google_app_measurement2.db";
    }

    public long zzaci() {
        return Math.max(0, ((Long) zzl.akm.get()).longValue());
    }

    public String zzap(String str, String str2) {
        Builder builder = new Builder();
        Builder encodedAuthority = builder.scheme((String) zzl.ako.get()).encodedAuthority((String) zzl.akp.get());
        String str3 = "config/app/";
        String valueOf = String.valueOf(str);
        encodedAuthority.path(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).appendQueryParameter("app_instance_id", str2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzbqv()));
        return builder.build().toString();
    }

    public boolean zzaql() {
        return zzqk.zzaql();
    }

    public int zzb(String str, zza<Integer> com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer) {
        if (str == null) {
            return ((Integer) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer.get()).intValue();
        }
        Object zzaw = zzbsw().zzaw(str, com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer.getKey());
        if (TextUtils.isEmpty(zzaw)) {
            return ((Integer) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer.get()).intValue();
        }
        try {
            return ((Integer) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer.get(Integer.valueOf(Integer.valueOf(zzaw).intValue()))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) com_google_android_gms_measurement_internal_zzl_zza_java_lang_Integer.get()).intValue();
        }
    }

    public long zzbqv() {
        return 9256;
    }

    String zzbrh() {
        return (String) zzl.akk.get();
    }

    public int zzbri() {
        return 25;
    }

    public int zzbrj() {
        return 32;
    }

    public int zzbrk() {
        return 24;
    }

    int zzbrl() {
        return 24;
    }

    int zzbrm() {
        return 36;
    }

    int zzbrn() {
        return AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    }

    public int zzbro() {
        return 36;
    }

    public int zzbrp() {
        return ItemAnimator.FLAG_MOVED;
    }

    int zzbrq() {
        return 500;
    }

    public long zzbrr() {
        return (long) ((Integer) zzl.aku.get()).intValue();
    }

    public long zzbrs() {
        return (long) ((Integer) zzl.akv.get()).intValue();
    }

    public long zzbrt() {
        return 1000;
    }

    int zzbru() {
        return 25;
    }

    int zzbrv() {
        return 50;
    }

    long zzbrw() {
        return 3600000;
    }

    long zzbrx() {
        return 60000;
    }

    long zzbry() {
        return 61000;
    }

    public boolean zzbrz() {
        if (zzabc()) {
            return false;
        }
        Boolean zzlj = zzlj("firebase_analytics_collection_deactivated");
        return (zzlj == null || zzlj.booleanValue()) ? false : true;
    }

    public Boolean zzbsa() {
        return zzabc() ? null : zzlj("firebase_analytics_collection_enabled");
    }

    public long zzbsb() {
        return ((Long) zzl.akG.get()).longValue();
    }

    public long zzbsc() {
        return ((Long) zzl.akC.get()).longValue();
    }

    public long zzbsd() {
        return 1000;
    }

    public int zzbse() {
        return Math.max(0, ((Integer) zzl.aks.get()).intValue());
    }

    public int zzbsf() {
        return Math.max(1, ((Integer) zzl.akt.get()).intValue());
    }

    public String zzbsg() {
        return (String) zzl.aky.get();
    }

    public long zzbsh() {
        return ((Long) zzl.akn.get()).longValue();
    }

    public long zzbsi() {
        return Math.max(0, ((Long) zzl.akz.get()).longValue());
    }

    public long zzbsj() {
        return Math.max(0, ((Long) zzl.akB.get()).longValue());
    }

    public long zzbsk() {
        return ((Long) zzl.akA.get()).longValue();
    }

    public long zzbsl() {
        return Math.max(0, ((Long) zzl.akD.get()).longValue());
    }

    public long zzbsm() {
        return Math.max(0, ((Long) zzl.akE.get()).longValue());
    }

    public int zzbsn() {
        return Math.min(20, Math.max(0, ((Integer) zzl.akF.get()).intValue()));
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

    public int zzlg(@Size(min = 1) String str) {
        return zzb(str, zzl.akw);
    }

    long zzlh(String str) {
        return zza(str, zzl.akl);
    }

    int zzli(String str) {
        return zzb(str, zzl.akH);
    }

    public int zzlk(String str) {
        return zzb(str, zzl.akq);
    }

    public int zzll(String str) {
        return Math.max(0, zzb(str, zzl.akr));
    }

    public int zzlm(String str) {
        return Math.max(0, Math.min(1000000, zzb(str, zzl.akx)));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
