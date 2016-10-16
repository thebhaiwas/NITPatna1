package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.measurement.AppMeasurement.zzb;
import com.google.android.gms.measurement.AppMeasurement.zzc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzac extends zzaa {
    private zza amW;
    private zzb amX;
    private final Set<zzc> amY;
    private boolean amZ;

    /* renamed from: com.google.android.gms.measurement.internal.zzac.1 */
    class C02571 implements Runnable {
        final /* synthetic */ zzac ana;
        final /* synthetic */ boolean cz;

        C02571(zzac com_google_android_gms_measurement_internal_zzac, boolean z) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.cz = z;
        }

        public void run() {
            this.ana.zzcc(this.cz);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzac.2 */
    class C02582 implements Runnable {
        final /* synthetic */ zzac ana;
        final /* synthetic */ long anb;

        C02582(zzac com_google_android_gms_measurement_internal_zzac, long j) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.anb = j;
        }

        public void run() {
            this.ana.zzbta().alE.set(this.anb);
            this.ana.zzbsz().zzbtx().zzj("Minimum session duration set", Long.valueOf(this.anb));
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzac.3 */
    class C02593 implements Runnable {
        final /* synthetic */ zzac ana;
        final /* synthetic */ long anb;

        C02593(zzac com_google_android_gms_measurement_internal_zzac, long j) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.anb = j;
        }

        public void run() {
            this.ana.zzbta().alF.set(this.anb);
            this.ana.zzbsz().zzbtx().zzj("Session timeout duration set", Long.valueOf(this.anb));
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzac.4 */
    class C02604 implements Runnable {
        final /* synthetic */ String aee;
        final /* synthetic */ zzac ana;
        final /* synthetic */ String anc;
        final /* synthetic */ long and;
        final /* synthetic */ Bundle ane;
        final /* synthetic */ boolean anf;
        final /* synthetic */ boolean ang;
        final /* synthetic */ boolean anh;
        final /* synthetic */ String val$name;

        C02604(zzac com_google_android_gms_measurement_internal_zzac, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.anc = str;
            this.val$name = str2;
            this.and = j;
            this.ane = bundle;
            this.anf = z;
            this.ang = z2;
            this.anh = z3;
            this.aee = str3;
        }

        public void run() {
            this.ana.zzb(this.anc, this.val$name, this.and, this.ane, this.anf, this.ang, this.anh, this.aee);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzac.5 */
    class C02615 implements Runnable {
        final /* synthetic */ zzac ana;
        final /* synthetic */ String anc;
        final /* synthetic */ long and;
        final /* synthetic */ Object ani;
        final /* synthetic */ String val$name;

        C02615(zzac com_google_android_gms_measurement_internal_zzac, String str, String str2, Object obj, long j) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.anc = str;
            this.val$name = str2;
            this.ani = obj;
            this.and = j;
        }

        public void run() {
            this.ana.zza(this.anc, this.val$name, this.ani, this.and);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzac.6 */
    class C02626 implements Runnable {
        final /* synthetic */ zzac ana;
        final /* synthetic */ AtomicReference anj;
        final /* synthetic */ boolean ank;

        C02626(zzac com_google_android_gms_measurement_internal_zzac, AtomicReference atomicReference, boolean z) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
            this.anj = atomicReference;
            this.ank = z;
        }

        public void run() {
            this.ana.zzbst().zza(this.anj, this.ank);
        }
    }

    @MainThread
    @TargetApi(14)
    private class zza implements ActivityLifecycleCallbacks {
        final /* synthetic */ zzac ana;

        private zza(zzac com_google_android_gms_measurement_internal_zzac) {
            this.ana = com_google_android_gms_measurement_internal_zzac;
        }

        private boolean zzmi(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.ana.zzd("auto", "_ldl", str);
            return true;
        }

        private boolean zzs(Uri uri) {
            Object queryParameter = uri.getQueryParameter("utm_campaign");
            Object queryParameter2 = uri.getQueryParameter("utm_source");
            Object queryParameter3 = uri.getQueryParameter("utm_medium");
            Object queryParameter4 = uri.getQueryParameter("gclid");
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
                return false;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("content", queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            queryParameter = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("anid", queryParameter);
            }
            this.ana.zze("auto", "_cmp", bundle);
            return true;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                this.ana.zzbsz().zzbty().log("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Uri data = intent.getData();
                    if (data != null && data.isHierarchical()) {
                        if (bundle == null) {
                            zzs(data);
                        }
                        String queryParameter = data.getQueryParameter("referrer");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            if (queryParameter.contains("gclid")) {
                                this.ana.zzbsz().zzbtx().zzj("Activity created with referrer", queryParameter);
                                zzmi(queryParameter);
                                return;
                            }
                            this.ana.zzbsz().zzbtx().log("Activity created with data 'referrer' param without gclid");
                        }
                    }
                }
            } catch (Throwable th) {
                this.ana.zzbsz().zzbtr().zzj("Throwable caught in onActivityCreated", th);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        @MainThread
        public void onActivityPaused(Activity activity) {
            this.ana.zzbsx().zzbvv();
        }

        @MainThread
        public void onActivityResumed(Activity activity) {
            this.ana.zzbsx().zzbvt();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    protected zzac(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.amY = new HashSet();
    }

    private void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzyw().currentTimeMillis(), bundle, z, z2, z3, str3);
    }

    @WorkerThread
    private void zza(String str, String str2, Object obj, long j) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzyv();
        zzzg();
        if (!this.aja.isEnabled()) {
            zzbsz().zzbtx().log("User property not set since app measurement is disabled");
        } else if (this.aja.zzbuk()) {
            zzbsz().zzbtx().zze("Setting user property (FE)", str2, obj);
            zzbst().zza(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    @WorkerThread
    private void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzab.zzaa(bundle);
        zzwu();
        zzzg();
        if (this.aja.isEnabled()) {
            if (!this.amZ) {
                this.amZ = true;
                zzbvl();
            }
            boolean zzmu = zzal.zzmu(str2);
            if (z && this.amX != null && !zzmu) {
                zzbsz().zzbtx().zze("Passing event to registered event handler (FE)", str2, bundle);
                this.amX.zzb(str, str2, bundle, j);
                return;
            } else if (this.aja.zzbuk()) {
                int zzmm = zzbsv().zzmm(str2);
                if (zzmm != 0) {
                    this.aja.zzbsv().zze(zzmm, "_ev", zzbsv().zza(str2, zzbtb().zzbrj(), true));
                    return;
                }
                bundle.putString("_o", str);
                Bundle zza = zzbsv().zza(str2, bundle, zzf.zzab("_o"), z3);
                Bundle zzal = z2 ? zzal(zza) : zza;
                zzbsz().zzbtx().zze("Logging event (FE)", str2, zzal);
                zzbst().zzc(new EventParcel(str2, new EventParams(zzal), str, j), str3);
                for (zzc zzc : this.amY) {
                    zzc.zzc(str, str2, zzal, j);
                }
                return;
            } else {
                return;
            }
        }
        zzbsz().zzbtx().log("Event not sent since app measurement is disabled");
    }

    @WorkerThread
    private void zzbvl() {
        try {
            zzg(Class.forName(zzbvm()));
        } catch (ClassNotFoundException e) {
            zzbsz().zzbtw().log("Tag Manager is not found and thus will not be used");
        }
    }

    private String zzbvm() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    @WorkerThread
    private void zzcc(boolean z) {
        zzwu();
        zzyv();
        zzzg();
        zzbsz().zzbtx().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzbta().setMeasurementEnabled(z);
        zzbst().zzbvn();
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void setMeasurementEnabled(boolean z) {
        zzzg();
        zzyv();
        zzbsy().zzl(new C02571(this, z));
    }

    public void setMinimumSessionDuration(long j) {
        zzyv();
        zzbsy().zzl(new C02582(this, j));
    }

    public void setSessionTimeoutDuration(long j) {
        zzyv();
        zzbsy().zzl(new C02593(this, j));
    }

    @WorkerThread
    public void zza(zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        zzwu();
        zzyv();
        zzzg();
        if (!(com_google_android_gms_measurement_AppMeasurement_zzb == null || com_google_android_gms_measurement_AppMeasurement_zzb == this.amX)) {
            zzab.zza(this.amX == null, (Object) "EventInterceptor already set.");
        }
        this.amX = com_google_android_gms_measurement_AppMeasurement_zzb;
    }

    @WorkerThread
    public void zza(zzc com_google_android_gms_measurement_AppMeasurement_zzc) {
        zzwu();
        zzyv();
        zzzg();
        zzab.zzaa(com_google_android_gms_measurement_AppMeasurement_zzc);
        if (this.amY.contains(com_google_android_gms_measurement_AppMeasurement_zzc)) {
            throw new IllegalStateException("OnEventListener already registered.");
        }
        this.amY.add(com_google_android_gms_measurement_AppMeasurement_zzc);
    }

    protected void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzbsy().zzl(new C02604(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void zza(String str, String str2, long j, Object obj) {
        zzbsy().zzl(new C02615(this, str, str2, obj, j));
    }

    public void zza(String str, String str2, Bundle bundle, boolean z) {
        zzyv();
        boolean z2 = this.amX == null || zzal.zzmu(str2);
        zza(str, str2, bundle, true, z2, z, null);
    }

    Bundle zzal(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzl = zzbsv().zzl(str, bundle.get(str));
                if (zzl == null) {
                    zzbsz().zzbtt().zzj("Param value can't be null", str);
                } else if ((!(zzl instanceof String) && !(zzl instanceof Character) && !(zzl instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(zzl))) {
                    zzbsv().zza(bundle2, str, zzl);
                }
            }
        }
        return bundle2;
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

    @TargetApi(14)
    public void zzbvj() {
        if (getContext().getApplicationContext() instanceof Application) {
            Application application = (Application) getContext().getApplicationContext();
            if (this.amW == null) {
                this.amW = new zza();
            }
            application.unregisterActivityLifecycleCallbacks(this.amW);
            application.registerActivityLifecycleCallbacks(this.amW);
            zzbsz().zzbty().log("Registered activity lifecycle callback");
        }
    }

    @WorkerThread
    public void zzbvk() {
        zzwu();
        zzyv();
        zzzg();
        if (this.aja.zzbuk()) {
            zzbst().zzbvk();
            String zzbuh = zzbta().zzbuh();
            if (!TextUtils.isEmpty(zzbuh) && !zzbuh.equals(zzbss().zzbtk())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", zzbuh);
                zze("auto", "_ou", bundle);
            }
        }
    }

    @Nullable
    @WorkerThread
    public List<UserAttributeParcel> zzcd(boolean z) {
        zzyv();
        zzzg();
        zzbsz().zzbtx().log("Fetching user attributes (FE)");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            zzbsz().zzbtt().log("getUserProperties called from main thread.");
            return null;
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.aja.zzbsy().zzl(new C02626(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzbsz().zzbtt().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<UserAttributeParcel> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzbsz().zzbtt().log("Timed out waiting for get user properties");
        return null;
    }

    public void zzd(String str, String str2, Bundle bundle, long j) {
        zzyv();
        zza(str, str2, j, bundle, false, true, true, null);
    }

    public void zzd(String str, String str2, Object obj) {
        zzab.zzhs(str);
        long currentTimeMillis = zzyw().currentTimeMillis();
        int zzmo = zzbsv().zzmo(str2);
        if (zzmo != 0) {
            this.aja.zzbsv().zze(zzmo, "_ev", zzbsv().zza(str2, zzbtb().zzbrk(), true));
        } else if (obj != null) {
            zzmo = zzbsv().zzm(str2, obj);
            if (zzmo != 0) {
                this.aja.zzbsv().zze(zzmo, "_ev", zzbsv().zza(str2, zzbtb().zzbrk(), true));
                return;
            }
            Object zzn = zzbsv().zzn(str2, obj);
            if (zzn != null) {
                zza(str, str2, currentTimeMillis, zzn);
            }
        } else {
            zza(str, str2, currentTimeMillis, null);
        }
    }

    public void zze(String str, String str2, Bundle bundle) {
        zzyv();
        boolean z = this.amX == null || zzal.zzmu(str2);
        zza(str, str2, bundle, true, z, false, null);
    }

    @WorkerThread
    public void zzg(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
        } catch (Exception e) {
            zzbsz().zzbtt().zzj("Failed to invoke Tag Manager's initialize() method", e);
        }
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
