package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;
import xyz.purush.nitp.nitpatna.BuildConfig;

public class zzp extends zzaa {
    private final long ajo;
    private final char akM;
    private final zza akN;
    private final zza akO;
    private final zza akP;
    private final zza akQ;
    private final zza akR;
    private final zza akS;
    private final zza akT;
    private final zza akU;
    private final zza akV;
    private final String yQ;

    /* renamed from: com.google.android.gms.measurement.internal.zzp.1 */
    class C02791 implements Runnable {
        final /* synthetic */ String akW;
        final /* synthetic */ zzp akX;

        C02791(zzp com_google_android_gms_measurement_internal_zzp, String str) {
            this.akX = com_google_android_gms_measurement_internal_zzp;
            this.akW = str;
        }

        public void run() {
            zzt zzbta = this.akX.aja.zzbta();
            if (!zzbta.isInitialized() || zzbta.zzbvh()) {
                this.akX.zzo(6, "Persisted config not initialized . Not logging error/warn.");
            } else {
                zzbta.alu.zzew(this.akW);
            }
        }
    }

    public class zza {
        final /* synthetic */ zzp akX;
        private final boolean akY;
        private final boolean akZ;
        private final int mPriority;

        zza(zzp com_google_android_gms_measurement_internal_zzp, int i, boolean z, boolean z2) {
            this.akX = com_google_android_gms_measurement_internal_zzp;
            this.mPriority = i;
            this.akY = z;
            this.akZ = z2;
        }

        public void log(String str) {
            this.akX.zza(this.mPriority, this.akY, this.akZ, str, null, null, null);
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            this.akX.zza(this.mPriority, this.akY, this.akZ, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            this.akX.zza(this.mPriority, this.akY, this.akZ, str, obj, obj2, null);
        }

        public void zzj(String str, Object obj) {
            this.akX.zza(this.mPriority, this.akY, this.akZ, str, obj, null, null);
        }
    }

    zzp(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.yQ = zzbtb().zzbrh();
        this.ajo = zzbtb().zzbqv();
        if (zzbtb().zzabd()) {
            this.akM = zzbtb().zzabc() ? 'P' : 'C';
        } else {
            this.akM = zzbtb().zzabc() ? 'p' : 'c';
        }
        this.akN = new zza(this, 6, false, false);
        this.akO = new zza(this, 6, true, false);
        this.akP = new zza(this, 6, false, true);
        this.akQ = new zza(this, 5, false, false);
        this.akR = new zza(this, 5, true, false);
        this.akS = new zza(this, 5, false, true);
        this.akT = new zza(this, 4, false, false);
        this.akU = new zza(this, 3, false, false);
        this.akV = new zza(this, 2, false, false);
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = BuildConfig.FLAVOR;
        }
        Object zzc = zzc(z, obj);
        Object zzc2 = zzc(z, obj2);
        Object zzc3 = zzc(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = BuildConfig.FLAVOR;
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzc)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzc3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzc3);
        }
        return stringBuilder.toString();
    }

    static String zzc(boolean z, Object obj) {
        if (obj == null) {
            return BuildConfig.FLAVOR;
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : BuildConfig.FLAVOR;
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzlx = zzlx(AppMeasurement.class.getCanonicalName());
                String zzlx2 = zzlx(zzx.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = zzlx(className);
                            if (className.equals(zzlx) || className.equals(zzlx2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    private static String zzlx(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    protected void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && zzaz(i)) {
            zzo(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    protected boolean zzaz(int i) {
        return Log.isLoggable(this.yQ, i);
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzab.zzaa(str);
        zzw zzbum = this.aja.zzbum();
        if (zzbum == null) {
            zzo(6, "Scheduler not set. Not logging error/warn.");
        } else if (!zzbum.isInitialized()) {
            zzo(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (zzbum.zzbvh()) {
            zzo(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf("1");
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.akM;
            long j = this.ajo;
            String valueOf2 = String.valueOf(zza(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
                valueOf = str.substring(0, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
            }
            zzbum.zzl(new C02791(this, valueOf));
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

    public zza zzbtr() {
        return this.akN;
    }

    public zza zzbts() {
        return this.akO;
    }

    public zza zzbtt() {
        return this.akQ;
    }

    public zza zzbtu() {
        return this.akR;
    }

    public zza zzbtv() {
        return this.akS;
    }

    public zza zzbtw() {
        return this.akT;
    }

    public zza zzbtx() {
        return this.akU;
    }

    public zza zzbty() {
        return this.akV;
    }

    public String zzbtz() {
        Pair zzadv = zzbta().alu.zzadv();
        if (zzadv == null || zzadv == zzt.alt) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(zzadv.second));
        String str = (String) zzadv.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    protected void zzo(int i, String str) {
        Log.println(i, this.yQ, str);
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
