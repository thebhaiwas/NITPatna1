package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zzc;
import com.google.android.gms.internal.zzun.zzd;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzun.zzf;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zza;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import xyz.purush.nitp.nitpatna.BuildConfig;

public class zzal extends zzz {
    zzal(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Float ? Double.valueOf(((Float) obj).doubleValue()) : ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? zza(String.valueOf(obj), i, z) : null;
        } else {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
    }

    public static String zza(zzb com_google_android_gms_internal_zzun_zzb) {
        int i = 0;
        if (com_google_android_gms_internal_zzun_zzb == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nevent_filter {\n");
        zza(stringBuilder, 0, "filter_id", com_google_android_gms_internal_zzun_zzb.aoa);
        zza(stringBuilder, 0, "event_name", com_google_android_gms_internal_zzun_zzb.aob);
        zza(stringBuilder, 1, "event_count_filter", com_google_android_gms_internal_zzun_zzb.aoe);
        stringBuilder.append("  filters {\n");
        zzc[] com_google_android_gms_internal_zzun_zzcArr = com_google_android_gms_internal_zzun_zzb.aoc;
        int length = com_google_android_gms_internal_zzun_zzcArr.length;
        while (i < length) {
            zza(stringBuilder, 2, com_google_android_gms_internal_zzun_zzcArr[i]);
            i++;
        }
        zza(stringBuilder, 1);
        stringBuilder.append("}\n}\n");
        return stringBuilder.toString();
    }

    public static String zza(zze com_google_android_gms_internal_zzun_zze) {
        if (com_google_android_gms_internal_zzun_zze == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nproperty_filter {\n");
        zza(stringBuilder, 0, "filter_id", com_google_android_gms_internal_zzun_zze.aoa);
        zza(stringBuilder, 0, "property_name", com_google_android_gms_internal_zzun_zze.aoq);
        zza(stringBuilder, 1, com_google_android_gms_internal_zzun_zze.aor);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    private static void zza(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zzc com_google_android_gms_internal_zzun_zzc) {
        if (com_google_android_gms_internal_zzun_zzc != null) {
            zza(stringBuilder, i);
            stringBuilder.append("filter {\n");
            zza(stringBuilder, i, "complement", com_google_android_gms_internal_zzun_zzc.aoi);
            zza(stringBuilder, i, "param_name", com_google_android_gms_internal_zzun_zzc.aoj);
            zza(stringBuilder, i + 1, "string_filter", com_google_android_gms_internal_zzun_zzc.aog);
            zza(stringBuilder, i + 1, "number_filter", com_google_android_gms_internal_zzun_zzc.aoh);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zzup.zze com_google_android_gms_internal_zzup_zze) {
        if (com_google_android_gms_internal_zzup_zze != null) {
            zza(stringBuilder, i);
            stringBuilder.append("bundle {\n");
            zza(stringBuilder, i, "protocol_version", com_google_android_gms_internal_zzup_zze.aoR);
            zza(stringBuilder, i, "platform", com_google_android_gms_internal_zzup_zze.aoZ);
            zza(stringBuilder, i, "gmp_version", com_google_android_gms_internal_zzup_zze.apd);
            zza(stringBuilder, i, "uploading_gmp_version", com_google_android_gms_internal_zzup_zze.ape);
            zza(stringBuilder, i, "gmp_app_id", com_google_android_gms_internal_zzup_zze.ajz);
            zza(stringBuilder, i, "app_id", com_google_android_gms_internal_zzup_zze.zzck);
            zza(stringBuilder, i, "app_version", com_google_android_gms_internal_zzup_zze.abU);
            zza(stringBuilder, i, "app_version_major", com_google_android_gms_internal_zzup_zze.apm);
            zza(stringBuilder, i, "firebase_instance_id", com_google_android_gms_internal_zzup_zze.ajH);
            zza(stringBuilder, i, "dev_cert_hash", com_google_android_gms_internal_zzup_zze.api);
            zza(stringBuilder, i, "app_store", com_google_android_gms_internal_zzup_zze.ajA);
            zza(stringBuilder, i, "upload_timestamp_millis", com_google_android_gms_internal_zzup_zze.aoU);
            zza(stringBuilder, i, "start_timestamp_millis", com_google_android_gms_internal_zzup_zze.aoV);
            zza(stringBuilder, i, "end_timestamp_millis", com_google_android_gms_internal_zzup_zze.aoW);
            zza(stringBuilder, i, "previous_bundle_start_timestamp_millis", com_google_android_gms_internal_zzup_zze.aoX);
            zza(stringBuilder, i, "previous_bundle_end_timestamp_millis", com_google_android_gms_internal_zzup_zze.aoY);
            zza(stringBuilder, i, "app_instance_id", com_google_android_gms_internal_zzup_zze.aph);
            zza(stringBuilder, i, "resettable_device_id", com_google_android_gms_internal_zzup_zze.apf);
            zza(stringBuilder, i, "device_id", com_google_android_gms_internal_zzup_zze.app);
            zza(stringBuilder, i, "limited_ad_tracking", com_google_android_gms_internal_zzup_zze.apg);
            zza(stringBuilder, i, "os_version", com_google_android_gms_internal_zzup_zze.zzct);
            zza(stringBuilder, i, "device_model", com_google_android_gms_internal_zzup_zze.apa);
            zza(stringBuilder, i, "user_default_language", com_google_android_gms_internal_zzup_zze.apb);
            zza(stringBuilder, i, "time_zone_offset_minutes", com_google_android_gms_internal_zzup_zze.apc);
            zza(stringBuilder, i, "bundle_sequential_index", com_google_android_gms_internal_zzup_zze.apj);
            zza(stringBuilder, i, "service_upload", com_google_android_gms_internal_zzup_zze.apk);
            zza(stringBuilder, i, "health_monitor", com_google_android_gms_internal_zzup_zze.ajD);
            zza(stringBuilder, i, com_google_android_gms_internal_zzup_zze.aoT);
            zza(stringBuilder, i, com_google_android_gms_internal_zzup_zze.apl);
            zza(stringBuilder, i, com_google_android_gms_internal_zzup_zze.aoS);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, zzd com_google_android_gms_internal_zzun_zzd) {
        if (com_google_android_gms_internal_zzun_zzd != null) {
            zza(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_google_android_gms_internal_zzun_zzd.aok != null) {
                Object obj = "UNKNOWN_COMPARISON_TYPE";
                switch (com_google_android_gms_internal_zzun_zzd.aok.intValue()) {
                    case ConnectionResult.SERVICE_MISSING /*1*/:
                        obj = "LESS_THAN";
                        break;
                    case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                        obj = "GREATER_THAN";
                        break;
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        obj = "EQUAL";
                        break;
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        obj = "BETWEEN";
                        break;
                }
                zza(stringBuilder, i, "comparison_type", obj);
            }
            zza(stringBuilder, i, "match_as_float", com_google_android_gms_internal_zzun_zzd.aol);
            zza(stringBuilder, i, "comparison_value", com_google_android_gms_internal_zzun_zzd.aom);
            zza(stringBuilder, i, "min_comparison_value", com_google_android_gms_internal_zzun_zzd.aon);
            zza(stringBuilder, i, "max_comparison_value", com_google_android_gms_internal_zzun_zzd.aoo);
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, zzf com_google_android_gms_internal_zzun_zzf) {
        if (com_google_android_gms_internal_zzun_zzf != null) {
            zza(stringBuilder, i);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_google_android_gms_internal_zzun_zzf.aos != null) {
                Object obj = "UNKNOWN_MATCH_TYPE";
                switch (com_google_android_gms_internal_zzun_zzf.aos.intValue()) {
                    case ConnectionResult.SERVICE_MISSING /*1*/:
                        obj = "REGEXP";
                        break;
                    case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                        obj = "BEGINS_WITH";
                        break;
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        obj = "ENDS_WITH";
                        break;
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        obj = "PARTIAL";
                        break;
                    case ConnectionResult.INVALID_ACCOUNT /*5*/:
                        obj = "EXACT";
                        break;
                    case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                        obj = "IN_LIST";
                        break;
                }
                zza(stringBuilder, i, "match_type", obj);
            }
            zza(stringBuilder, i, "expression", com_google_android_gms_internal_zzun_zzf.aot);
            zza(stringBuilder, i, "case_sensitive", com_google_android_gms_internal_zzun_zzf.aou);
            if (com_google_android_gms_internal_zzun_zzf.aov.length > 0) {
                zza(stringBuilder, i + 1);
                stringBuilder.append("expression_list {\n");
                for (String str2 : com_google_android_gms_internal_zzun_zzf.aov) {
                    zza(stringBuilder, i + 2);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                }
                stringBuilder.append("}\n");
            }
            zza(stringBuilder, i);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, zzup.zzf com_google_android_gms_internal_zzup_zzf) {
        int i2 = 0;
        if (com_google_android_gms_internal_zzup_zzf != null) {
            int i3;
            int i4;
            int i5 = i + 1;
            zza(stringBuilder, i5);
            stringBuilder.append(str);
            stringBuilder.append(" {\n");
            if (com_google_android_gms_internal_zzup_zzf.apr != null) {
                zza(stringBuilder, i5 + 1);
                stringBuilder.append("results: ");
                long[] jArr = com_google_android_gms_internal_zzup_zzf.apr;
                int length = jArr.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i6 = i4 + 1;
                    if (i4 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf);
                    i3++;
                    i4 = i6;
                }
                stringBuilder.append('\n');
            }
            if (com_google_android_gms_internal_zzup_zzf.apq != null) {
                zza(stringBuilder, i5 + 1);
                stringBuilder.append("status: ");
                long[] jArr2 = com_google_android_gms_internal_zzup_zzf.apq;
                int length2 = jArr2.length;
                i3 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    i4 = i3 + 1;
                    if (i3 != 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(valueOf2);
                    i2++;
                    i3 = i4;
                }
                stringBuilder.append('\n');
            }
            zza(stringBuilder, i5);
            stringBuilder.append("}\n");
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, String str, Object obj) {
        if (obj != null) {
            zza(stringBuilder, i + 1);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            stringBuilder.append('\n');
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zza[] com_google_android_gms_internal_zzup_zzaArr) {
        if (com_google_android_gms_internal_zzup_zzaArr != null) {
            int i2 = i + 1;
            for (zza com_google_android_gms_internal_zzup_zza : com_google_android_gms_internal_zzup_zzaArr) {
                if (com_google_android_gms_internal_zzup_zza != null) {
                    zza(stringBuilder, i2);
                    stringBuilder.append("audience_membership {\n");
                    zza(stringBuilder, i2, "audience_id", com_google_android_gms_internal_zzup_zza.anW);
                    zza(stringBuilder, i2, "new_audience", com_google_android_gms_internal_zzup_zza.aoI);
                    zza(stringBuilder, i2, "current_data", com_google_android_gms_internal_zzup_zza.aoG);
                    zza(stringBuilder, i2, "previous_data", com_google_android_gms_internal_zzup_zza.aoH);
                    zza(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zzup.zzb[] com_google_android_gms_internal_zzup_zzbArr) {
        if (com_google_android_gms_internal_zzup_zzbArr != null) {
            int i2 = i + 1;
            for (zzup.zzb com_google_android_gms_internal_zzup_zzb : com_google_android_gms_internal_zzup_zzbArr) {
                if (com_google_android_gms_internal_zzup_zzb != null) {
                    zza(stringBuilder, i2);
                    stringBuilder.append("event {\n");
                    zza(stringBuilder, i2, "name", com_google_android_gms_internal_zzup_zzb.name);
                    zza(stringBuilder, i2, "timestamp_millis", com_google_android_gms_internal_zzup_zzb.aoL);
                    zza(stringBuilder, i2, "previous_timestamp_millis", com_google_android_gms_internal_zzup_zzb.aoM);
                    zza(stringBuilder, i2, "count", com_google_android_gms_internal_zzup_zzb.count);
                    zza(stringBuilder, i2, com_google_android_gms_internal_zzup_zzb.aoK);
                    zza(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zzup.zzc[] com_google_android_gms_internal_zzup_zzcArr) {
        if (com_google_android_gms_internal_zzup_zzcArr != null) {
            int i2 = i + 1;
            for (zzup.zzc com_google_android_gms_internal_zzup_zzc : com_google_android_gms_internal_zzup_zzcArr) {
                if (com_google_android_gms_internal_zzup_zzc != null) {
                    zza(stringBuilder, i2);
                    stringBuilder.append("param {\n");
                    zza(stringBuilder, i2, "name", com_google_android_gms_internal_zzup_zzc.name);
                    zza(stringBuilder, i2, "string_value", com_google_android_gms_internal_zzup_zzc.zr);
                    zza(stringBuilder, i2, "int_value", com_google_android_gms_internal_zzup_zzc.aoO);
                    zza(stringBuilder, i2, "double_value", com_google_android_gms_internal_zzup_zzc.anT);
                    zza(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder stringBuilder, int i, zzg[] com_google_android_gms_internal_zzup_zzgArr) {
        if (com_google_android_gms_internal_zzup_zzgArr != null) {
            int i2 = i + 1;
            for (zzg com_google_android_gms_internal_zzup_zzg : com_google_android_gms_internal_zzup_zzgArr) {
                if (com_google_android_gms_internal_zzup_zzg != null) {
                    zza(stringBuilder, i2);
                    stringBuilder.append("user_property {\n");
                    zza(stringBuilder, i2, "set_timestamp_millis", com_google_android_gms_internal_zzup_zzg.apt);
                    zza(stringBuilder, i2, "name", com_google_android_gms_internal_zzup_zzg.name);
                    zza(stringBuilder, i2, "string_value", com_google_android_gms_internal_zzup_zzg.zr);
                    zza(stringBuilder, i2, "int_value", com_google_android_gms_internal_zzup_zzg.aoO);
                    zza(stringBuilder, i2, "double_value", com_google_android_gms_internal_zzup_zzg.anT);
                    zza(stringBuilder, i2);
                    stringBuilder.append("}\n");
                }
            }
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    static long zzac(byte[] bArr) {
        long j = null;
        zzab.zzaa(bArr);
        zzab.zzbm(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static boolean zzam(Bundle bundle) {
        return bundle.getLong("_c") == 1;
    }

    public static String zzb(zzup.zzd com_google_android_gms_internal_zzup_zzd) {
        if (com_google_android_gms_internal_zzup_zzd == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nbatch {\n");
        if (com_google_android_gms_internal_zzup_zzd.aoP != null) {
            for (zzup.zze com_google_android_gms_internal_zzup_zze : com_google_android_gms_internal_zzup_zzd.aoP) {
                if (com_google_android_gms_internal_zzup_zze != null) {
                    zza(stringBuilder, 1, com_google_android_gms_internal_zzup_zze);
                }
            }
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    public static boolean zzb(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zzbb(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static MessageDigest zzfb(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static boolean zzk(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    static boolean zzmk(String str) {
        zzab.zzhs(str);
        return str.charAt(0) != '_';
    }

    private int zzmt(String str) {
        return "_ldl".equals(str) ? zzbtb().zzbrp() : zzbtb().zzbro();
    }

    public static boolean zzmu(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzbri = zzbtb().zzbri();
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int zzmp;
            if (list == null || !list.contains(str2)) {
                zzmp = z ? zzmp(str2) : 0;
                if (zzmp == 0) {
                    zzmp = zzmq(str2);
                }
            } else {
                zzmp = 0;
            }
            if (zzmp != 0) {
                if (zzd(bundle2, zzmp)) {
                    bundle2.putString("_ev", zza(str2, zzbtb().zzbrl(), true));
                }
                bundle2.remove(str2);
            } else if (zzk(str2, bundle.get(str2)) || "_ev".equals(str2)) {
                if (zzmk(str2)) {
                    i++;
                    if (i > zzbri) {
                        zzbsz().zzbtr().zze("Event can't contain more then " + zzbri + " params", str, bundle);
                        zzd(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
                i = i;
            } else {
                if (zzd(bundle2, 4)) {
                    bundle2.putString("_ev", zza(str2, zzbtb().zzbrl(), true));
                }
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String zza(String str, int i, boolean z) {
        return str.length() > i ? z ? String.valueOf(str.substring(0, i)).concat("...") : null : str;
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzbsz().zzbtv().zze("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void zza(zzup.zzc com_google_android_gms_internal_zzup_zzc, Object obj) {
        zzab.zzaa(obj);
        com_google_android_gms_internal_zzup_zzc.zr = null;
        com_google_android_gms_internal_zzup_zzc.aoO = null;
        com_google_android_gms_internal_zzup_zzc.anT = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzup_zzc.zr = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzup_zzc.aoO = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzup_zzc.anT = (Double) obj;
        } else {
            zzbsz().zzbtr().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzg com_google_android_gms_internal_zzup_zzg, Object obj) {
        zzab.zzaa(obj);
        com_google_android_gms_internal_zzup_zzg.zr = null;
        com_google_android_gms_internal_zzup_zzg.aoO = null;
        com_google_android_gms_internal_zzup_zzg.anT = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzup_zzg.zr = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzup_zzg.aoO = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzup_zzg.anT = (Double) obj;
        } else {
            zzbsz().zzbtr().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    boolean zza(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        zzbsz().zzbtt().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    public byte[] zza(zzup.zzd com_google_android_gms_internal_zzup_zzd) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzup_zzd.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzup_zzd.zza(zzba);
            zzba.ab();
            return bArr;
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public byte[] zzab(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public long zzad(byte[] bArr) {
        zzab.zzaa(bArr);
        MessageDigest zzfb = zzfb("MD5");
        if (zzfb != null) {
            return zzac(zzfb.digest(bArr));
        }
        zzbsz().zzbtr().log("Failed to get MD5");
        return 0;
    }

    boolean zzaz(String str, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else if (Character.isLetter(str2.charAt(0))) {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    zzbsz().zzbtr().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        } else {
            zzbsz().zzbtr().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    boolean zzba(String str, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbsz().zzbtr().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzbsz().zzbtr().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
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

    boolean zzc(String str, int i, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            zzbsz().zzbtr().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    boolean zzc(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            zzbsz().zzbtr().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            zzbsz().zzbtr().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            zzbsz().zzbtr().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public boolean zzd(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public void zze(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        this.aja.zzbsq().zze("auto", "_err", bundle);
    }

    @WorkerThread
    public boolean zzep(String str) {
        zzwu();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzbsz().zzbtx().zzj("Permission not granted", str);
        return false;
    }

    public boolean zzg(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzyw().currentTimeMillis() - j) > j2;
    }

    public byte[] zzj(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public boolean zzk(String str, Object obj) {
        return zzmu(str) ? zza("param", str, zzbtb().zzbrn(), obj) : zza("param", str, zzbtb().zzbrm(), obj);
    }

    public Object zzl(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(zzbtb().zzbrn(), obj, true);
        }
        return zza(zzmu(str) ? zzbtb().zzbrn() : zzbtb().zzbrm(), obj, false);
    }

    public int zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzmt(str), obj) : zza("user property", str, zzmt(str), obj) ? 0 : 7;
    }

    public int zzml(String str) {
        return !zzaz(NotificationCompatApi21.CATEGORY_EVENT, str) ? 2 : !zzc(NotificationCompatApi21.CATEGORY_EVENT, AppMeasurement.zza.ajb, str) ? 13 : zzc(NotificationCompatApi21.CATEGORY_EVENT, zzbtb().zzbrj(), str) ? 0 : 2;
    }

    public int zzmm(String str) {
        return !zzba(NotificationCompatApi21.CATEGORY_EVENT, str) ? 2 : !zzc(NotificationCompatApi21.CATEGORY_EVENT, AppMeasurement.zza.ajb, str) ? 13 : zzc(NotificationCompatApi21.CATEGORY_EVENT, zzbtb().zzbrj(), str) ? 0 : 2;
    }

    public int zzmn(String str) {
        return !zzaz("user property", str) ? 6 : !zzc("user property", AppMeasurement.zze.ajd, str) ? 15 : zzc("user property", zzbtb().zzbrk(), str) ? 0 : 6;
    }

    public int zzmo(String str) {
        return !zzba("user property", str) ? 6 : !zzc("user property", AppMeasurement.zze.ajd, str) ? 15 : zzc("user property", zzbtb().zzbrk(), str) ? 0 : 6;
    }

    public int zzmp(String str) {
        return !zzaz("event param", str) ? 3 : !zzc("event param", null, str) ? 14 : zzc("event param", zzbtb().zzbrl(), str) ? 0 : 3;
    }

    public int zzmq(String str) {
        return !zzba("event param", str) ? 3 : !zzc("event param", null, str) ? 14 : zzc("event param", zzbtb().zzbrl(), str) ? 0 : 3;
    }

    public boolean zzmr(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbsz().zzbtr().log("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            zzbsz().zzbtt().zzj("Measurement Service called with unknown id version", str);
            return true;
        } else if (zzms(str)) {
            return true;
        } else {
            zzbsz().zzbtr().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    boolean zzms(String str) {
        zzab.zzaa(str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public Object zzn(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzmt(str), obj, true) : zza(zzmt(str), obj, false);
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ com.google.android.gms.common.util.zze zzyw() {
        return super.zzyw();
    }
}
