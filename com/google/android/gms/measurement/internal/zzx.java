package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzuo;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zzb;
import com.google.android.gms.internal.zzup.zzc;
import com.google.android.gms.internal.zzup.zzd;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzx {
    private static volatile zzx amm;
    private final zzn amA;
    private final zzr amB;
    private final zzai amC;
    private final zzc amD;
    public final FirebaseAnalytics amE;
    private boolean amF;
    private Boolean amG;
    private FileLock amH;
    private FileChannel amI;
    private List<Long> amJ;
    private int amK;
    private int amL;
    private final zzd amn;
    private final zzt amo;
    private final zzp amp;
    private final zzw amq;
    private final zzaf amr;
    private final zzv ams;
    private final AppMeasurement amt;
    private final zzal amu;
    private final zze amv;
    private final zzq amw;
    private final zzad amx;
    private final zzg amy;
    private final zzac amz;
    private final Context mContext;
    private final zze zzaoa;
    private final boolean zzcwt;

    /* renamed from: com.google.android.gms.measurement.internal.zzx.1 */
    class C02831 implements Runnable {
        final /* synthetic */ zzx amM;

        C02831(zzx com_google_android_gms_measurement_internal_zzx) {
            this.amM = com_google_android_gms_measurement_internal_zzx;
        }

        public void run() {
            this.amM.start();
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzx.2 */
    class C05132 implements zza {
        final /* synthetic */ zzx amM;

        C05132(zzx com_google_android_gms_measurement_internal_zzx) {
            this.amM = com_google_android_gms_measurement_internal_zzx;
        }

        public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.amM.zza(i, th, bArr);
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzx.3 */
    class C05143 implements zza {
        final /* synthetic */ zzx amM;

        C05143(zzx com_google_android_gms_measurement_internal_zzx) {
            this.amM = com_google_android_gms_measurement_internal_zzx;
        }

        public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.amM.zzb(str, i, th, bArr, map);
        }
    }

    private class zza implements zzb {
        final /* synthetic */ zzx amM;
        zzup.zze amN;
        List<Long> amO;
        long amP;
        List<zzb> zzala;

        private zza(zzx com_google_android_gms_measurement_internal_zzx) {
            this.amM = com_google_android_gms_measurement_internal_zzx;
        }

        private long zza(zzb com_google_android_gms_internal_zzup_zzb) {
            return ((com_google_android_gms_internal_zzup_zzb.aoL.longValue() / 1000) / 60) / 60;
        }

        boolean isEmpty() {
            return this.zzala == null || this.zzala.isEmpty();
        }

        public boolean zza(long j, zzb com_google_android_gms_internal_zzup_zzb) {
            zzab.zzaa(com_google_android_gms_internal_zzup_zzb);
            if (this.zzala == null) {
                this.zzala = new ArrayList();
            }
            if (this.amO == null) {
                this.amO = new ArrayList();
            }
            if (this.zzala.size() > 0 && zza((zzb) this.zzala.get(0)) != zza(com_google_android_gms_internal_zzup_zzb)) {
                return false;
            }
            long ao = this.amP + ((long) com_google_android_gms_internal_zzup_zzb.ao());
            if (ao >= ((long) this.amM.zzbtb().zzbse())) {
                return false;
            }
            this.amP = ao;
            this.zzala.add(com_google_android_gms_internal_zzup_zzb);
            this.amO.add(Long.valueOf(j));
            return this.zzala.size() < this.amM.zzbtb().zzbsf();
        }

        public void zzc(zzup.zze com_google_android_gms_internal_zzup_zze) {
            zzab.zzaa(com_google_android_gms_internal_zzup_zze);
            this.amN = com_google_android_gms_internal_zzup_zze;
        }
    }

    zzx(zzab com_google_android_gms_measurement_internal_zzab) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzab);
        this.mContext = com_google_android_gms_measurement_internal_zzab.mContext;
        this.zzaoa = com_google_android_gms_measurement_internal_zzab.zzl(this);
        this.amn = com_google_android_gms_measurement_internal_zzab.zza(this);
        zzt zzb = com_google_android_gms_measurement_internal_zzab.zzb(this);
        zzb.initialize();
        this.amo = zzb;
        zzp zzc = com_google_android_gms_measurement_internal_zzab.zzc(this);
        zzc.initialize();
        this.amp = zzc;
        zzbsz().zzbtw().zzj("App measurement is starting up, version", Long.valueOf(zzbtb().zzbqv()));
        zzbsz().zzbtw().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzbsz().zzbtx().log("Debug logging enabled");
        zzbsz().zzbtx().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.amu = com_google_android_gms_measurement_internal_zzab.zzi(this);
        zzg zzn = com_google_android_gms_measurement_internal_zzab.zzn(this);
        zzn.initialize();
        this.amy = zzn;
        zzn zzo = com_google_android_gms_measurement_internal_zzab.zzo(this);
        zzo.initialize();
        this.amA = zzo;
        zze zzj = com_google_android_gms_measurement_internal_zzab.zzj(this);
        zzj.initialize();
        this.amv = zzj;
        zzc zzr = com_google_android_gms_measurement_internal_zzab.zzr(this);
        zzr.initialize();
        this.amD = zzr;
        zzq zzk = com_google_android_gms_measurement_internal_zzab.zzk(this);
        zzk.initialize();
        this.amw = zzk;
        zzad zzm = com_google_android_gms_measurement_internal_zzab.zzm(this);
        zzm.initialize();
        this.amx = zzm;
        zzac zzh = com_google_android_gms_measurement_internal_zzab.zzh(this);
        zzh.initialize();
        this.amz = zzh;
        zzai zzq = com_google_android_gms_measurement_internal_zzab.zzq(this);
        zzq.initialize();
        this.amC = zzq;
        this.amB = com_google_android_gms_measurement_internal_zzab.zzp(this);
        this.amt = com_google_android_gms_measurement_internal_zzab.zzg(this);
        this.amE = new FirebaseAnalytics(this);
        zzaf zze = com_google_android_gms_measurement_internal_zzab.zze(this);
        zze.initialize();
        this.amr = zze;
        zzv zzf = com_google_android_gms_measurement_internal_zzab.zzf(this);
        zzf.initialize();
        this.ams = zzf;
        zzw zzd = com_google_android_gms_measurement_internal_zzab.zzd(this);
        zzd.initialize();
        this.amq = zzd;
        if (this.amK != this.amL) {
            zzbsz().zzbtr().zze("Not all components initialized", Integer.valueOf(this.amK), Integer.valueOf(this.amL));
        }
        this.zzcwt = true;
        if (!(this.amn.zzabc() || zzbuu())) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzbsz().zzbtt().log("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                zzbsq().zzbvj();
            } else {
                zzbsz().zzbtx().log("Not tracking deep linking pre-ICS");
            }
        }
        this.amq.zzl(new C02831(this));
    }

    @WorkerThread
    private void zza(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        zzwu();
        zzzg();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.amJ;
        this.amJ = null;
        if ((i == Callback.DEFAULT_DRAG_ANIMATION_DURATION || i == 204) && th == null) {
            zzbta().alv.set(zzyw().currentTimeMillis());
            zzbta().alw.set(0);
            zzbva();
            zzbsz().zzbty().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzbsu().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzbsu().zzbg(longValue.longValue());
                }
                zzbsu().setTransactionSuccessful();
                if (zzbuo().zzadj() && zzbuz()) {
                    zzbuy();
                } else {
                    zzbva();
                }
            } finally {
                zzbsu().endTransaction();
            }
        } else {
            zzbsz().zzbty().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzbta().alw.set(zzyw().currentTimeMillis());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                zzbta().alx.set(zzyw().currentTimeMillis());
            }
            zzbva();
        }
    }

    private void zza(zzaa com_google_android_gms_measurement_internal_zzaa) {
        if (com_google_android_gms_measurement_internal_zzaa == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_measurement_internal_zzaa.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void zza(zzz com_google_android_gms_measurement_internal_zzz) {
        if (com_google_android_gms_measurement_internal_zzz == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private com.google.android.gms.internal.zzup.zza[] zza(String str, zzg[] com_google_android_gms_internal_zzup_zzgArr, zzb[] com_google_android_gms_internal_zzup_zzbArr) {
        zzab.zzhs(str);
        return zzbsp().zza(str, com_google_android_gms_internal_zzup_zzbArr, com_google_android_gms_internal_zzup_zzgArr);
    }

    private void zzad(List<Long> list) {
        zzab.zzbn(!list.isEmpty());
        if (this.amJ != null) {
            zzbsz().zzbtr().log("Set uploading progress before finishing the previous upload");
        } else {
            this.amJ = new ArrayList(list);
        }
    }

    @WorkerThread
    private boolean zzbux() {
        zzwu();
        return this.amJ != null;
    }

    private boolean zzbuz() {
        zzwu();
        zzzg();
        return zzbsu().zzbth() || !TextUtils.isEmpty(zzbsu().zzbtc());
    }

    @WorkerThread
    private void zzbva() {
        zzwu();
        zzzg();
        if (!zzbve()) {
            return;
        }
        if (zzbuk() && zzbuz()) {
            long zzbvb = zzbvb();
            if (zzbvb == 0) {
                zzbup().unregister();
                zzbuq().cancel();
                return;
            } else if (zzbuo().zzadj()) {
                long j = zzbta().alx.get();
                long zzbsi = zzbtb().zzbsi();
                if (!zzbsv().zzg(j, zzbsi)) {
                    zzbvb = Math.max(zzbvb, j + zzbsi);
                }
                zzbup().unregister();
                zzbvb -= zzyw().currentTimeMillis();
                if (zzbvb <= 0) {
                    zzbuq().zzv(1);
                    return;
                }
                zzbsz().zzbty().zzj("Upload scheduled in approximately ms", Long.valueOf(zzbvb));
                zzbuq().zzv(zzbvb);
                return;
            } else {
                zzbup().zzadg();
                zzbuq().cancel();
                return;
            }
        }
        zzbup().unregister();
        zzbuq().cancel();
    }

    private long zzbvb() {
        long currentTimeMillis = zzyw().currentTimeMillis();
        long zzbsl = zzbtb().zzbsl();
        long zzbsj = zzbtb().zzbsj();
        long j = zzbta().alv.get();
        long j2 = zzbta().alw.get();
        long max = Math.max(zzbsu().zzbtf(), zzbsu().zzbtg());
        if (max == 0) {
            return 0;
        }
        max = currentTimeMillis - Math.abs(max - currentTimeMillis);
        j2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        currentTimeMillis = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), j2);
        zzbsl += max;
        if (!zzbsv().zzg(currentTimeMillis, zzbsj)) {
            zzbsl = currentTimeMillis + zzbsj;
        }
        if (j2 == 0 || j2 < max) {
            return zzbsl;
        }
        for (int i = 0; i < zzbtb().zzbsn(); i++) {
            zzbsl += ((long) (1 << i)) * zzbtb().zzbsm();
            if (zzbsl > j2) {
                return zzbsl;
            }
        }
        return 0;
    }

    public static zzx zzdo(Context context) {
        zzab.zzaa(context);
        zzab.zzaa(context.getApplicationContext());
        if (amm == null) {
            synchronized (zzx.class) {
                if (amm == null) {
                    amm = new zzab(context).zzbvi();
                }
            }
        }
        return amm;
    }

    @WorkerThread
    private void zze(AppMetadata appMetadata) {
        Object obj = 1;
        zzwu();
        zzzg();
        zzab.zzaa(appMetadata);
        zzab.zzhs(appMetadata.packageName);
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        String zzlz = zzbta().zzlz(appMetadata.packageName);
        Object obj2 = null;
        if (zzlo == null) {
            zza com_google_android_gms_measurement_internal_zza = new zza(this, appMetadata.packageName);
            com_google_android_gms_measurement_internal_zza.zzkz(zzbta().zzbub());
            com_google_android_gms_measurement_internal_zza.zzlb(zzlz);
            zzlo = com_google_android_gms_measurement_internal_zza;
            obj2 = 1;
        } else if (!zzlz.equals(zzlo.zzbqp())) {
            zzlo.zzlb(zzlz);
            zzlo.zzkz(zzbta().zzbub());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.ajz) || appMetadata.ajz.equals(zzlo.zzbqo()))) {
            zzlo.zzla(appMetadata.ajz);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.ajH) || appMetadata.ajH.equals(zzlo.zzbqq()))) {
            zzlo.zzlc(appMetadata.ajH);
            obj2 = 1;
        }
        if (!(appMetadata.ajB == 0 || appMetadata.ajB == zzlo.zzbqv())) {
            zzlo.zzaw(appMetadata.ajB);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.abU) || appMetadata.abU.equals(zzlo.zzxc()))) {
            zzlo.setAppVersion(appMetadata.abU);
            obj2 = 1;
        }
        if (appMetadata.ajG != zzlo.zzbqt()) {
            zzlo.zzav(appMetadata.ajG);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.ajA) || appMetadata.ajA.equals(zzlo.zzbqu()))) {
            zzlo.zzld(appMetadata.ajA);
            obj2 = 1;
        }
        if (appMetadata.ajC != zzlo.zzbqw()) {
            zzlo.zzax(appMetadata.ajC);
            obj2 = 1;
        }
        if (appMetadata.ajE != zzlo.zzbqx()) {
            zzlo.setMeasurementEnabled(appMetadata.ajE);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            zzbsu().zza(zzlo);
        }
    }

    private boolean zzh(String str, long j) {
        zzbsu().beginTransaction();
        try {
            zzx com_google_android_gms_measurement_internal_zzx = this;
            zzb com_google_android_gms_measurement_internal_zzx_zza = new zza();
            zzbsu().zza(str, j, com_google_android_gms_measurement_internal_zzx_zza);
            if (com_google_android_gms_measurement_internal_zzx_zza.isEmpty()) {
                zzbsu().setTransactionSuccessful();
                zzbsu().endTransaction();
                return false;
            }
            int i;
            zzup.zze com_google_android_gms_internal_zzup_zze = com_google_android_gms_measurement_internal_zzx_zza.amN;
            com_google_android_gms_internal_zzup_zze.aoS = new zzb[com_google_android_gms_measurement_internal_zzx_zza.zzala.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < com_google_android_gms_measurement_internal_zzx_zza.zzala.size()) {
                if (zzbsw().zzax(com_google_android_gms_measurement_internal_zzx_zza.amN.zzck, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name)) {
                    zzbsz().zzbtt().zzj("Dropping blacklisted raw event", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name);
                    zzbsv().zze(11, "_ev", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name);
                    i = i2;
                } else {
                    int i4;
                    if (zzbsw().zzay(com_google_android_gms_measurement_internal_zzx_zza.amN.zzck, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name)) {
                        int i5;
                        Object obj;
                        zzc com_google_android_gms_internal_zzup_zzc;
                        if (((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK == null) {
                            ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK = new zzc[0];
                        }
                        for (zzc com_google_android_gms_internal_zzup_zzc2 : ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK) {
                            if ("_c".equals(com_google_android_gms_internal_zzup_zzc2.name)) {
                                com_google_android_gms_internal_zzup_zzc2.aoO = Long.valueOf(1);
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            zzbsz().zzbty().zzj("Marking event as conversion", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name);
                            zzc[] com_google_android_gms_internal_zzup_zzcArr = (zzc[]) Arrays.copyOf(((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK.length + 1);
                            com_google_android_gms_internal_zzup_zzc = new zzc();
                            com_google_android_gms_internal_zzup_zzc.name = "_c";
                            com_google_android_gms_internal_zzup_zzc.aoO = Long.valueOf(1);
                            com_google_android_gms_internal_zzup_zzcArr[com_google_android_gms_internal_zzup_zzcArr.length - 1] = com_google_android_gms_internal_zzup_zzc;
                            ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK = com_google_android_gms_internal_zzup_zzcArr;
                        }
                        boolean zzmk = zzal.zzmk(((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).name);
                        if (zzmk && zzbsu().zza(zzbuv(), com_google_android_gms_measurement_internal_zzx_zza.amN.zzck, false, zzmk, false).ajO - ((long) zzbtb().zzlg(com_google_android_gms_measurement_internal_zzx_zza.amN.zzck)) > 0) {
                            zzbsz().zzbtt().log("Too many conversions. Not logging as conversion.");
                            zzb com_google_android_gms_internal_zzup_zzb = (zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3);
                            Object obj2 = null;
                            zzc com_google_android_gms_internal_zzup_zzc3 = null;
                            zzc[] com_google_android_gms_internal_zzup_zzcArr2 = ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK;
                            int length = com_google_android_gms_internal_zzup_zzcArr2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                Object obj3;
                                com_google_android_gms_internal_zzup_zzc = com_google_android_gms_internal_zzup_zzcArr2[i6];
                                if ("_c".equals(com_google_android_gms_internal_zzup_zzc.name)) {
                                    obj3 = obj2;
                                } else if ("_err".equals(com_google_android_gms_internal_zzup_zzc.name)) {
                                    zzc com_google_android_gms_internal_zzup_zzc4 = com_google_android_gms_internal_zzup_zzc3;
                                    int i7 = 1;
                                    com_google_android_gms_internal_zzup_zzc = com_google_android_gms_internal_zzup_zzc4;
                                } else {
                                    com_google_android_gms_internal_zzup_zzc = com_google_android_gms_internal_zzup_zzc3;
                                    obj3 = obj2;
                                }
                                i6++;
                                obj2 = obj3;
                                com_google_android_gms_internal_zzup_zzc3 = com_google_android_gms_internal_zzup_zzc;
                            }
                            if (obj2 != null && com_google_android_gms_internal_zzup_zzc3 != null) {
                                zzc[] com_google_android_gms_internal_zzup_zzcArr3 = new zzc[(com_google_android_gms_internal_zzup_zzb.aoK.length - 1)];
                                i4 = 0;
                                com_google_android_gms_internal_zzup_zzcArr2 = com_google_android_gms_internal_zzup_zzb.aoK;
                                length = com_google_android_gms_internal_zzup_zzcArr2.length;
                                i5 = 0;
                                while (i5 < length) {
                                    zzc com_google_android_gms_internal_zzup_zzc5 = com_google_android_gms_internal_zzup_zzcArr2[i5];
                                    if (com_google_android_gms_internal_zzup_zzc5 != com_google_android_gms_internal_zzup_zzc3) {
                                        i = i4 + 1;
                                        com_google_android_gms_internal_zzup_zzcArr3[i4] = com_google_android_gms_internal_zzup_zzc5;
                                    } else {
                                        i = i4;
                                    }
                                    i5++;
                                    i4 = i;
                                }
                                ((zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3)).aoK = com_google_android_gms_internal_zzup_zzcArr3;
                            } else if (com_google_android_gms_internal_zzup_zzc3 != null) {
                                com_google_android_gms_internal_zzup_zzc3.name = "_err";
                                com_google_android_gms_internal_zzup_zzc3.aoO = Long.valueOf(10);
                            } else {
                                zzbsz().zzbtr().log("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    i4 = i2 + 1;
                    com_google_android_gms_internal_zzup_zze.aoS[i2] = (zzb) com_google_android_gms_measurement_internal_zzx_zza.zzala.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < com_google_android_gms_measurement_internal_zzx_zza.zzala.size()) {
                com_google_android_gms_internal_zzup_zze.aoS = (zzb[]) Arrays.copyOf(com_google_android_gms_internal_zzup_zze.aoS, i2);
            }
            com_google_android_gms_internal_zzup_zze.apl = zza(com_google_android_gms_measurement_internal_zzx_zza.amN.zzck, com_google_android_gms_measurement_internal_zzx_zza.amN.aoT, com_google_android_gms_internal_zzup_zze.aoS);
            com_google_android_gms_internal_zzup_zze.aoV = com_google_android_gms_internal_zzup_zze.aoS[0].aoL;
            com_google_android_gms_internal_zzup_zze.aoW = com_google_android_gms_internal_zzup_zze.aoS[0].aoL;
            for (i = 1; i < com_google_android_gms_internal_zzup_zze.aoS.length; i++) {
                zzb com_google_android_gms_internal_zzup_zzb2 = com_google_android_gms_internal_zzup_zze.aoS[i];
                if (com_google_android_gms_internal_zzup_zzb2.aoL.longValue() < com_google_android_gms_internal_zzup_zze.aoV.longValue()) {
                    com_google_android_gms_internal_zzup_zze.aoV = com_google_android_gms_internal_zzup_zzb2.aoL;
                }
                if (com_google_android_gms_internal_zzup_zzb2.aoL.longValue() > com_google_android_gms_internal_zzup_zze.aoW.longValue()) {
                    com_google_android_gms_internal_zzup_zze.aoW = com_google_android_gms_internal_zzup_zzb2.aoL;
                }
            }
            String str2 = com_google_android_gms_measurement_internal_zzx_zza.amN.zzck;
            zza zzlo = zzbsu().zzlo(str2);
            if (zzlo == null) {
                zzbsz().zzbtr().log("Bundling raw events w/o app info");
            } else {
                long zzbqs = zzlo.zzbqs();
                com_google_android_gms_internal_zzup_zze.aoY = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                long zzbqr = zzlo.zzbqr();
                if (zzbqr != 0) {
                    zzbqs = zzbqr;
                }
                com_google_android_gms_internal_zzup_zze.aoX = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                zzlo.zzbrb();
                com_google_android_gms_internal_zzup_zze.apj = Integer.valueOf((int) zzlo.zzbqy());
                zzlo.zzat(com_google_android_gms_internal_zzup_zze.aoV.longValue());
                zzlo.zzau(com_google_android_gms_internal_zzup_zze.aoW.longValue());
                zzbsu().zza(zzlo);
            }
            com_google_android_gms_internal_zzup_zze.ajD = zzbsz().zzbtz();
            zzbsu().zza(com_google_android_gms_internal_zzup_zze);
            zzbsu().zzac(com_google_android_gms_measurement_internal_zzx_zza.amO);
            zzbsu().zzlu(str2);
            zzbsu().setTransactionSuccessful();
            return true;
        } finally {
            zzbsu().endTransaction();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public boolean isEnabled() {
        boolean z = false;
        zzwu();
        zzzg();
        if (zzbtb().zzbrz()) {
            return false;
        }
        Boolean zzbsa = zzbtb().zzbsa();
        if (zzbsa != null) {
            z = zzbsa.booleanValue();
        } else if (!zzbtb().zzaql()) {
            z = true;
        }
        return zzbta().zzcb(z);
    }

    @WorkerThread
    protected void start() {
        zzwu();
        if (!zzbuu() || (this.amq.isInitialized() && !this.amq.zzbvh())) {
            zzbsu().zzbtd();
            if (zzbuk()) {
                if (!(zzbtb().zzabc() || TextUtils.isEmpty(zzbsr().zzbqo()))) {
                    String zzbue = zzbta().zzbue();
                    if (zzbue == null) {
                        zzbta().zzma(zzbsr().zzbqo());
                    } else if (!zzbue.equals(zzbsr().zzbqo())) {
                        zzbsz().zzbtw().log("Rechecking which service to use due to a GMP App Id change");
                        zzbta().zzbug();
                        this.amx.disconnect();
                        this.amx.zzaai();
                        zzbta().zzma(zzbsr().zzbqo());
                    }
                }
                if (!(zzbtb().zzabc() || zzbuu() || TextUtils.isEmpty(zzbsr().zzbqo()))) {
                    zzbsq().zzbvk();
                }
            } else if (isEnabled()) {
                if (!zzbsv().zzep("android.permission.INTERNET")) {
                    zzbsz().zzbtr().log("App is missing INTERNET permission");
                }
                if (!zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE")) {
                    zzbsz().zzbtr().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzu.zzav(getContext())) {
                    zzbsz().zzbtr().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzae.zzaw(getContext())) {
                    zzbsz().zzbtr().log("AppMeasurementService not registered/enabled");
                }
                zzbsz().zzbtr().log("Uploading is not possible. App measurement disabled");
            }
            zzbva();
            return;
        }
        zzbsz().zzbtr().log("Scheduler shutting down before Scion.start() called");
    }

    @WorkerThread
    int zza(FileChannel fileChannel) {
        int i = 0;
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsz().zzbtr().log("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    zzbsz().zzbtt().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                }
            } catch (IOException e) {
                zzbsz().zzbtr().zzj("Failed to read from channel", e);
            }
        }
        return i;
    }

    @WorkerThread
    void zza(AppMetadata appMetadata, long j) {
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        if (!(zzlo == null || zzlo.zzbqo() == null || zzlo.zzbqo().equals(appMetadata.ajz))) {
            zzbsz().zzbtt().log("New GMP App Id passed in. Removing cached database data.");
            zzbsu().zzlt(zzlo.zzsi());
            zzlo = null;
        }
        if (zzlo != null && zzlo.zzxc() != null && !zzlo.zzxc().equals(appMetadata.abU)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", zzlo.zzxc());
            zzb(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void zza(zzh com_google_android_gms_measurement_internal_zzh, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzaa(com_google_android_gms_measurement_internal_zzh);
        zzab.zzaa(appMetadata);
        zzab.zzhs(com_google_android_gms_measurement_internal_zzh.zzcjj);
        zzab.zzbn(com_google_android_gms_measurement_internal_zzh.zzcjj.equals(appMetadata.packageName));
        zzup.zze com_google_android_gms_internal_zzup_zze = new zzup.zze();
        com_google_android_gms_internal_zzup_zze.aoR = Integer.valueOf(1);
        com_google_android_gms_internal_zzup_zze.aoZ = "android";
        com_google_android_gms_internal_zzup_zze.zzck = appMetadata.packageName;
        com_google_android_gms_internal_zzup_zze.ajA = appMetadata.ajA;
        com_google_android_gms_internal_zzup_zze.abU = appMetadata.abU;
        com_google_android_gms_internal_zzup_zze.apm = Integer.valueOf((int) appMetadata.ajG);
        com_google_android_gms_internal_zzup_zze.apd = Long.valueOf(appMetadata.ajB);
        com_google_android_gms_internal_zzup_zze.ajz = appMetadata.ajz;
        com_google_android_gms_internal_zzup_zze.api = appMetadata.ajC == 0 ? null : Long.valueOf(appMetadata.ajC);
        Pair zzly = zzbta().zzly(appMetadata.packageName);
        if (zzly != null && !TextUtils.isEmpty((CharSequence) zzly.first)) {
            com_google_android_gms_internal_zzup_zze.apf = (String) zzly.first;
            com_google_android_gms_internal_zzup_zze.apg = (Boolean) zzly.second;
        } else if (!zzbss().zzdn(this.mContext)) {
            String string = Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (string == null) {
                zzbsz().zzbtt().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzbsz().zzbtt().log("empty secure ID");
            }
            com_google_android_gms_internal_zzup_zze.app = string;
        }
        com_google_android_gms_internal_zzup_zze.apa = zzbss().zzth();
        com_google_android_gms_internal_zzup_zze.zzct = zzbss().zzbtk();
        com_google_android_gms_internal_zzup_zze.apc = Integer.valueOf((int) zzbss().zzbtl());
        com_google_android_gms_internal_zzup_zze.apb = zzbss().zzbtm();
        com_google_android_gms_internal_zzup_zze.ape = null;
        com_google_android_gms_internal_zzup_zze.aoU = null;
        com_google_android_gms_internal_zzup_zze.aoV = null;
        com_google_android_gms_internal_zzup_zze.aoW = null;
        zza zzlo = zzbsu().zzlo(appMetadata.packageName);
        if (zzlo == null) {
            zzlo = new zza(this, appMetadata.packageName);
            zzlo.zzkz(zzbta().zzbub());
            zzlo.zzlc(appMetadata.ajH);
            zzlo.zzla(appMetadata.ajz);
            zzlo.zzlb(zzbta().zzlz(appMetadata.packageName));
            zzlo.zzay(0);
            zzlo.zzat(0);
            zzlo.zzau(0);
            zzlo.setAppVersion(appMetadata.abU);
            zzlo.zzav(appMetadata.ajG);
            zzlo.zzld(appMetadata.ajA);
            zzlo.zzaw(appMetadata.ajB);
            zzlo.zzax(appMetadata.ajC);
            zzlo.setMeasurementEnabled(appMetadata.ajE);
            zzbsu().zza(zzlo);
        }
        com_google_android_gms_internal_zzup_zze.aph = zzlo.zzawj();
        com_google_android_gms_internal_zzup_zze.ajH = zzlo.zzbqq();
        List zzln = zzbsu().zzln(appMetadata.packageName);
        com_google_android_gms_internal_zzup_zze.aoT = new zzg[zzln.size()];
        for (int i = 0; i < zzln.size(); i++) {
            zzg com_google_android_gms_internal_zzup_zzg = new zzg();
            com_google_android_gms_internal_zzup_zze.aoT[i] = com_google_android_gms_internal_zzup_zzg;
            com_google_android_gms_internal_zzup_zzg.name = ((zzak) zzln.get(i)).mName;
            com_google_android_gms_internal_zzup_zzg.apt = Long.valueOf(((zzak) zzln.get(i)).anU);
            zzbsv().zza(com_google_android_gms_internal_zzup_zzg, ((zzak) zzln.get(i)).zzcnr);
        }
        try {
            zzbsu().zza(com_google_android_gms_measurement_internal_zzh, zzbsu().zzb(com_google_android_gms_internal_zzup_zze));
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Data loss. Failed to insert raw event metadata", e);
        }
    }

    @WorkerThread
    boolean zza(int i, FileChannel fileChannel) {
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsz().zzbtr().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzbsz().zzbtr().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzbsz().zzbtr().zzj("Failed to write to channel", e);
            return false;
        }
    }

    @WorkerThread
    public byte[] zza(@NonNull EventParcel eventParcel, @Size(min = 1) String str) {
        zzzg();
        zzwu();
        zzbuw();
        zzab.zzaa(eventParcel);
        zzab.zzhs(str);
        zzd com_google_android_gms_internal_zzup_zzd = new zzd();
        zzbsu().beginTransaction();
        try {
            zza zzlo = zzbsu().zzlo(str);
            byte[] bArr;
            if (zzlo == null) {
                zzbsz().zzbtx().zzj("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (zzlo.zzbqx()) {
                long j;
                zzup.zze com_google_android_gms_internal_zzup_zze = new zzup.zze();
                com_google_android_gms_internal_zzup_zzd.aoP = new zzup.zze[]{com_google_android_gms_internal_zzup_zze};
                com_google_android_gms_internal_zzup_zze.aoR = Integer.valueOf(1);
                com_google_android_gms_internal_zzup_zze.aoZ = "android";
                com_google_android_gms_internal_zzup_zze.zzck = zzlo.zzsi();
                com_google_android_gms_internal_zzup_zze.ajA = zzlo.zzbqu();
                com_google_android_gms_internal_zzup_zze.abU = zzlo.zzxc();
                com_google_android_gms_internal_zzup_zze.apm = Integer.valueOf((int) zzlo.zzbqt());
                com_google_android_gms_internal_zzup_zze.apd = Long.valueOf(zzlo.zzbqv());
                com_google_android_gms_internal_zzup_zze.ajz = zzlo.zzbqo();
                com_google_android_gms_internal_zzup_zze.api = Long.valueOf(zzlo.zzbqw());
                Pair zzly = zzbta().zzly(zzlo.zzsi());
                if (!(zzly == null || TextUtils.isEmpty((CharSequence) zzly.first))) {
                    com_google_android_gms_internal_zzup_zze.apf = (String) zzly.first;
                    com_google_android_gms_internal_zzup_zze.apg = (Boolean) zzly.second;
                }
                com_google_android_gms_internal_zzup_zze.apa = zzbss().zzth();
                com_google_android_gms_internal_zzup_zze.zzct = zzbss().zzbtk();
                com_google_android_gms_internal_zzup_zze.apc = Integer.valueOf((int) zzbss().zzbtl());
                com_google_android_gms_internal_zzup_zze.apb = zzbss().zzbtm();
                com_google_android_gms_internal_zzup_zze.aph = zzlo.zzawj();
                com_google_android_gms_internal_zzup_zze.ajH = zzlo.zzbqq();
                List zzln = zzbsu().zzln(zzlo.zzsi());
                com_google_android_gms_internal_zzup_zze.aoT = new zzg[zzln.size()];
                for (int i = 0; i < zzln.size(); i++) {
                    zzg com_google_android_gms_internal_zzup_zzg = new zzg();
                    com_google_android_gms_internal_zzup_zze.aoT[i] = com_google_android_gms_internal_zzup_zzg;
                    com_google_android_gms_internal_zzup_zzg.name = ((zzak) zzln.get(i)).mName;
                    com_google_android_gms_internal_zzup_zzg.apt = Long.valueOf(((zzak) zzln.get(i)).anU);
                    zzbsv().zza(com_google_android_gms_internal_zzup_zzg, ((zzak) zzln.get(i)).zzcnr);
                }
                Bundle zzbto = eventParcel.akf.zzbto();
                if ("_iap".equals(eventParcel.name)) {
                    zzbto.putLong("_c", 1);
                }
                zzbto.putString("_o", eventParcel.akg);
                zzi zzaq = zzbsu().zzaq(str, eventParcel.name);
                if (zzaq == null) {
                    zzbsu().zza(new zzi(str, eventParcel.name, 1, 0, eventParcel.akh));
                    j = 0;
                } else {
                    j = zzaq.akb;
                    zzbsu().zza(zzaq.zzbi(eventParcel.akh).zzbtn());
                }
                zzh com_google_android_gms_measurement_internal_zzh = new zzh(this, eventParcel.akg, str, eventParcel.name, eventParcel.akh, j, zzbto);
                zzb com_google_android_gms_internal_zzup_zzb = new zzb();
                com_google_android_gms_internal_zzup_zze.aoS = new zzb[]{com_google_android_gms_internal_zzup_zzb};
                com_google_android_gms_internal_zzup_zzb.aoL = Long.valueOf(com_google_android_gms_measurement_internal_zzh.pz);
                com_google_android_gms_internal_zzup_zzb.name = com_google_android_gms_measurement_internal_zzh.mName;
                com_google_android_gms_internal_zzup_zzb.aoM = Long.valueOf(com_google_android_gms_measurement_internal_zzh.ajX);
                com_google_android_gms_internal_zzup_zzb.aoK = new zzc[com_google_android_gms_measurement_internal_zzh.ajY.size()];
                Iterator it = com_google_android_gms_measurement_internal_zzh.ajY.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    zzc com_google_android_gms_internal_zzup_zzc = new zzc();
                    int i3 = i2 + 1;
                    com_google_android_gms_internal_zzup_zzb.aoK[i2] = com_google_android_gms_internal_zzup_zzc;
                    com_google_android_gms_internal_zzup_zzc.name = str2;
                    zzbsv().zza(com_google_android_gms_internal_zzup_zzc, com_google_android_gms_measurement_internal_zzh.ajY.get(str2));
                    i2 = i3;
                }
                com_google_android_gms_internal_zzup_zze.apl = zza(zzlo.zzsi(), com_google_android_gms_internal_zzup_zze.aoT, com_google_android_gms_internal_zzup_zze.aoS);
                com_google_android_gms_internal_zzup_zze.aoV = com_google_android_gms_internal_zzup_zzb.aoL;
                com_google_android_gms_internal_zzup_zze.aoW = com_google_android_gms_internal_zzup_zzb.aoL;
                long zzbqs = zzlo.zzbqs();
                com_google_android_gms_internal_zzup_zze.aoY = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                long zzbqr = zzlo.zzbqr();
                if (zzbqr != 0) {
                    zzbqs = zzbqr;
                }
                com_google_android_gms_internal_zzup_zze.aoX = zzbqs != 0 ? Long.valueOf(zzbqs) : null;
                zzlo.zzbrb();
                com_google_android_gms_internal_zzup_zze.apj = Integer.valueOf((int) zzlo.zzbqy());
                com_google_android_gms_internal_zzup_zze.ape = Long.valueOf(zzbtb().zzbqv());
                com_google_android_gms_internal_zzup_zze.aoU = Long.valueOf(zzyw().currentTimeMillis());
                com_google_android_gms_internal_zzup_zze.apk = Boolean.TRUE;
                zzlo.zzat(com_google_android_gms_internal_zzup_zze.aoV.longValue());
                zzlo.zzau(com_google_android_gms_internal_zzup_zze.aoW.longValue());
                zzbsu().zza(zzlo);
                zzbsu().setTransactionSuccessful();
                zzbsu().endTransaction();
                try {
                    bArr = new byte[com_google_android_gms_internal_zzup_zzd.ao()];
                    zzaov zzba = zzaov.zzba(bArr);
                    com_google_android_gms_internal_zzup_zzd.zza(zzba);
                    zzba.ab();
                    return zzbsv().zzj(bArr);
                } catch (IOException e) {
                    zzbsz().zzbtr().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                zzbsz().zzbtx().zzj("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                zzbsu().endTransaction();
                return bArr;
            }
        } finally {
            zzbsu().endTransaction();
        }
    }

    public void zzas(boolean z) {
        zzbva();
    }

    @WorkerThread
    void zzb(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        zzb(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    @WorkerThread
    void zzb(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        zzwu();
        zzzg();
        String str = appMetadata.packageName;
        zzab.zzhs(str);
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (!appMetadata.ajE) {
                zze(appMetadata);
            } else if (zzbsw().zzax(str, eventParcel.name)) {
                zzbsz().zzbtt().zzj("Dropping blacklisted event", eventParcel.name);
                zzbsv().zze(11, "_ev", eventParcel.name);
            } else {
                if (zzbsz().zzaz(2)) {
                    zzbsz().zzbty().zzj("Logging event", eventParcel);
                }
                zzbsu().beginTransaction();
                try {
                    Bundle zzbto = eventParcel.akf.zzbto();
                    zze(appMetadata);
                    if ("_iap".equals(eventParcel.name) || Event.ECOMMERCE_PURCHASE.equals(eventParcel.name)) {
                        long round;
                        Object string = zzbto.getString(Param.CURRENCY);
                        if (Event.ECOMMERCE_PURCHASE.equals(eventParcel.name)) {
                            double d = zzbto.getDouble(Param.VALUE) * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) zzbto.getLong(Param.VALUE)) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                zzbsz().zzbtt().zzj("Data lost. Currency value is too big", Double.valueOf(d));
                                zzbsu().setTransactionSuccessful();
                                zzbsu().endTransaction();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = zzbto.getLong(Param.VALUE);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                zzak com_google_android_gms_measurement_internal_zzak;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                zzak zzas = zzbsu().zzas(str, concat);
                                if (zzas == null || !(zzas.zzcnr instanceof Long)) {
                                    zzbsu().zzy(str, zzbtb().zzli(str) - 1);
                                    com_google_android_gms_measurement_internal_zzak = new zzak(str, concat, zzyw().currentTimeMillis(), Long.valueOf(round));
                                } else {
                                    com_google_android_gms_measurement_internal_zzak = new zzak(str, concat, zzyw().currentTimeMillis(), Long.valueOf(round + ((Long) zzas.zzcnr).longValue()));
                                }
                                if (!zzbsu().zza(com_google_android_gms_measurement_internal_zzak)) {
                                    zzbsz().zzbtr().zze("Too many unique user properties are set. Ignoring user property.", com_google_android_gms_measurement_internal_zzak.mName, com_google_android_gms_measurement_internal_zzak.zzcnr);
                                    zzbsv().zze(9, null, null);
                                }
                            }
                        }
                    }
                    boolean zzmk = zzal.zzmk(eventParcel.name);
                    zzal.zzam(zzbto);
                    boolean equals = "_err".equals(eventParcel.name);
                    com.google.android.gms.measurement.internal.zze.zza zza = zzbsu().zza(zzbuv(), str, zzmk, false, equals);
                    long zzbrr = zza.ajN - zzbtb().zzbrr();
                    if (zzbrr > 0) {
                        if (zzbrr % 1000 == 1) {
                            zzbsz().zzbtr().zzj("Data loss. Too many events logged. count", Long.valueOf(zza.ajN));
                        }
                        zzbsv().zze(16, "_ev", eventParcel.name);
                        zzbsu().setTransactionSuccessful();
                        return;
                    }
                    zzi zzbi;
                    if (zzmk) {
                        zzbrr = zza.ajM - zzbtb().zzbrs();
                        if (zzbrr > 0) {
                            if (zzbrr % 1000 == 1) {
                                zzbsz().zzbtr().zzj("Data loss. Too many public events logged. count", Long.valueOf(zza.ajM));
                            }
                            zzbsv().zze(16, "_ev", eventParcel.name);
                            zzbsu().setTransactionSuccessful();
                            zzbsu().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        zzbrr = zza.ajP - zzbtb().zzbrt();
                        if (zzbrr > 0) {
                            if (zzbrr == 1) {
                                zzbsz().zzbtr().zzj("Too many error events logged. count", Long.valueOf(zza.ajP));
                            }
                            zzbsu().setTransactionSuccessful();
                            zzbsu().endTransaction();
                            return;
                        }
                    }
                    zzbsv().zza(zzbto, "_o", eventParcel.akg);
                    long zzlp = zzbsu().zzlp(str);
                    if (zzlp > 0) {
                        zzbsz().zzbtt().zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(zzlp));
                    }
                    zzh com_google_android_gms_measurement_internal_zzh = new zzh(this, eventParcel.akg, str, eventParcel.name, eventParcel.akh, 0, zzbto);
                    zzi zzaq = zzbsu().zzaq(str, com_google_android_gms_measurement_internal_zzh.mName);
                    if (zzaq != null) {
                        com_google_android_gms_measurement_internal_zzh = com_google_android_gms_measurement_internal_zzh.zza(this, zzaq.akb);
                        zzbi = zzaq.zzbi(com_google_android_gms_measurement_internal_zzh.pz);
                    } else if (zzbsu().zzlv(str) >= ((long) zzbtb().zzbrq())) {
                        zzbsz().zzbtr().zze("Too many event names used, ignoring event. name, supported count", com_google_android_gms_measurement_internal_zzh.mName, Integer.valueOf(zzbtb().zzbrq()));
                        zzbsv().zze(8, null, null);
                        zzbsu().endTransaction();
                        return;
                    } else {
                        zzbi = new zzi(str, com_google_android_gms_measurement_internal_zzh.mName, 0, 0, com_google_android_gms_measurement_internal_zzh.pz);
                    }
                    zzbsu().zza(zzbi);
                    zza(com_google_android_gms_measurement_internal_zzh, appMetadata);
                    zzbsu().setTransactionSuccessful();
                    if (zzbsz().zzaz(2)) {
                        zzbsz().zzbty().zzj("Event recorded", com_google_android_gms_measurement_internal_zzh);
                    }
                    zzbsu().endTransaction();
                    zzbva();
                    zzbsz().zzbty().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    zzbsu().endTransaction();
                }
            }
        }
    }

    @WorkerThread
    void zzb(EventParcel eventParcel, String str) {
        zza zzlo = zzbsu().zzlo(str);
        if (zzlo == null || TextUtils.isEmpty(zzlo.zzxc())) {
            zzbsz().zzbtx().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(zzlo.zzxc() == null || zzlo.zzxc().equals(str2))) {
                zzbsz().zzbtt().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzbsz().zzbtt().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        zzb(eventParcel2, new AppMetadata(str, zzlo.zzbqo(), zzlo.zzxc(), zzlo.zzbqt(), zzlo.zzbqu(), zzlo.zzbqv(), zzlo.zzbqw(), null, zzlo.zzbqx(), false, zzlo.zzbqq()));
    }

    @WorkerThread
    void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (appMetadata.ajE) {
                int zzmo = zzbsv().zzmo(userAttributeParcel.name);
                if (zzmo != 0) {
                    zzbsv().zze(zzmo, "_ev", zzbsv().zza(userAttributeParcel.name, zzbtb().zzbrk(), true));
                    return;
                }
                zzmo = zzbsv().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
                if (zzmo != 0) {
                    zzbsv().zze(zzmo, "_ev", zzbsv().zza(userAttributeParcel.name, zzbtb().zzbrk(), true));
                    return;
                }
                Object zzn = zzbsv().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
                if (zzn != null) {
                    zzak com_google_android_gms_measurement_internal_zzak = new zzak(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.anQ, zzn);
                    zzbsz().zzbtx().zze("Setting user property", com_google_android_gms_measurement_internal_zzak.mName, zzn);
                    zzbsu().beginTransaction();
                    try {
                        zze(appMetadata);
                        boolean zza = zzbsu().zza(com_google_android_gms_measurement_internal_zzak);
                        zzbsu().setTransactionSuccessful();
                        if (zza) {
                            zzbsz().zzbtx().zze("User property set", com_google_android_gms_measurement_internal_zzak.mName, com_google_android_gms_measurement_internal_zzak.zzcnr);
                        } else {
                            zzbsz().zzbtr().zze("Too many unique user properties are set. Ignoring user property.", com_google_android_gms_measurement_internal_zzak.mName, com_google_android_gms_measurement_internal_zzak.zzcnr);
                            zzbsv().zze(9, null, null);
                        }
                        zzbsu().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzbsu().endTransaction();
                    }
                } else {
                    return;
                }
            }
            zze(appMetadata);
        }
    }

    void zzb(zzaa com_google_android_gms_measurement_internal_zzaa) {
        this.amK++;
    }

    @WorkerThread
    void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        zzwu();
        zzzg();
        zzab.zzhs(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzbsu().beginTransaction();
        try {
            zza zzlo = zzbsu().zzlo(str);
            int i3 = ((i == Callback.DEFAULT_DRAG_ANIMATION_DURATION || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (zzlo == null) {
                zzbsz().zzbtt().zzj("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzbsw().zzmc(str) == null && !zzbsw().zzb(str, null, null)) {
                        zzbsu().endTransaction();
                        return;
                    }
                } else if (!zzbsw().zzb(str, bArr, str2)) {
                    zzbsu().endTransaction();
                    return;
                }
                zzlo.zzaz(zzyw().currentTimeMillis());
                zzbsu().zza(zzlo);
                if (i == 404) {
                    zzbsz().zzbtt().log("Config not found. Using empty config");
                } else {
                    zzbsz().zzbty().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzbuo().zzadj() && zzbuz()) {
                    zzbuy();
                } else {
                    zzbva();
                }
            } else {
                zzlo.zzba(zzyw().currentTimeMillis());
                zzbsu().zza(zzlo);
                zzbsz().zzbty().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzbsw().zzme(str);
                zzbta().alw.set(zzyw().currentTimeMillis());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    zzbta().alx.set(zzyw().currentTimeMillis());
                }
                zzbva();
            }
            zzbsu().setTransactionSuccessful();
        } finally {
            zzbsu().endTransaction();
        }
    }

    boolean zzbk(long j) {
        return zzh(null, j);
    }

    public zzc zzbsp() {
        zza(this.amD);
        return this.amD;
    }

    public zzac zzbsq() {
        zza(this.amz);
        return this.amz;
    }

    public zzn zzbsr() {
        zza(this.amA);
        return this.amA;
    }

    public zzg zzbss() {
        zza(this.amy);
        return this.amy;
    }

    public zzad zzbst() {
        zza(this.amx);
        return this.amx;
    }

    public zze zzbsu() {
        zza(this.amv);
        return this.amv;
    }

    public zzal zzbsv() {
        zza(this.amu);
        return this.amu;
    }

    public zzv zzbsw() {
        zza(this.ams);
        return this.ams;
    }

    public zzaf zzbsx() {
        zza(this.amr);
        return this.amr;
    }

    public zzw zzbsy() {
        zza(this.amq);
        return this.amq;
    }

    public zzp zzbsz() {
        zza(this.amp);
        return this.amp;
    }

    public zzt zzbta() {
        zza(this.amo);
        return this.amo;
    }

    public zzd zzbtb() {
        return this.amn;
    }

    @WorkerThread
    protected boolean zzbuk() {
        zzzg();
        zzwu();
        if (this.amG == null) {
            boolean z = zzbsv().zzep("android.permission.INTERNET") && zzbsv().zzep("android.permission.ACCESS_NETWORK_STATE") && zzu.zzav(getContext()) && zzae.zzaw(getContext());
            this.amG = Boolean.valueOf(z);
            if (this.amG.booleanValue() && !zzbtb().zzabc()) {
                this.amG = Boolean.valueOf(zzbsv().zzmr(zzbsr().zzbqo()));
            }
        }
        return this.amG.booleanValue();
    }

    public zzp zzbul() {
        return (this.amp == null || !this.amp.isInitialized()) ? null : this.amp;
    }

    zzw zzbum() {
        return this.amq;
    }

    public AppMeasurement zzbun() {
        return this.amt;
    }

    public zzq zzbuo() {
        zza(this.amw);
        return this.amw;
    }

    public zzr zzbup() {
        if (this.amB != null) {
            return this.amB;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzbuq() {
        zza(this.amC);
        return this.amC;
    }

    FileChannel zzbur() {
        return this.amI;
    }

    @WorkerThread
    void zzbus() {
        zzwu();
        zzzg();
        if (zzbve() && zzbut()) {
            zzu(zza(zzbur()), zzbsr().zzbtp());
        }
    }

    @WorkerThread
    boolean zzbut() {
        zzwu();
        try {
            this.amI = new RandomAccessFile(new File(getContext().getFilesDir(), this.amv.zzaab()), "rw").getChannel();
            this.amH = this.amI.tryLock();
            if (this.amH != null) {
                zzbsz().zzbty().log("Storage concurrent access okay");
                return true;
            }
            zzbsz().zzbtr().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzbsz().zzbtr().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Failed to access storage lock file", e2);
        }
    }

    protected boolean zzbuu() {
        return false;
    }

    long zzbuv() {
        return ((((zzyw().currentTimeMillis() + zzbta().zzbuc()) / 1000) / 60) / 60) / 24;
    }

    void zzbuw() {
        if (!zzbtb().zzabc()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    @WorkerThread
    public void zzbuy() {
        Map map = null;
        int i = 0;
        zzwu();
        zzzg();
        if (!zzbtb().zzabc()) {
            Boolean zzbuf = zzbta().zzbuf();
            if (zzbuf == null) {
                zzbsz().zzbtt().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (zzbuf.booleanValue()) {
                zzbsz().zzbtr().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzbux()) {
            zzbsz().zzbtt().log("Uploading requested multiple times");
        } else if (zzbuo().zzadj()) {
            long currentTimeMillis = zzyw().currentTimeMillis();
            zzbk(currentTimeMillis - zzbtb().zzbsh());
            long j = zzbta().alv.get();
            if (j != 0) {
                zzbsz().zzbtx().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String zzbtc = zzbsu().zzbtc();
            if (TextUtils.isEmpty(zzbtc)) {
                String zzbh = zzbsu().zzbh(currentTimeMillis - zzbtb().zzbsh());
                if (!TextUtils.isEmpty(zzbh)) {
                    zza zzlo = zzbsu().zzlo(zzbh);
                    if (zzlo != null) {
                        String zzap = zzbtb().zzap(zzlo.zzbqo(), zzlo.zzawj());
                        try {
                            URL url = new URL(zzap);
                            zzbsz().zzbty().zzj("Fetching remote configuration", zzlo.zzsi());
                            zzuo.zzb zzmc = zzbsw().zzmc(zzlo.zzsi());
                            CharSequence zzmd = zzbsw().zzmd(zzlo.zzsi());
                            if (!(zzmc == null || TextUtils.isEmpty(zzmd))) {
                                map = new ArrayMap();
                                map.put("If-Modified-Since", zzmd);
                            }
                            zzbuo().zza(zzbh, url, map, new C05143(this));
                            return;
                        } catch (MalformedURLException e) {
                            zzbsz().zzbtr().zzj("Failed to parse config URL. Not fetching", zzap);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> zzn = zzbsu().zzn(zzbtc, zzbtb().zzlk(zzbtc), zzbtb().zzll(zzbtc));
            if (!zzn.isEmpty()) {
                zzup.zze com_google_android_gms_internal_zzup_zze;
                Object obj;
                List subList;
                for (Pair pair : zzn) {
                    com_google_android_gms_internal_zzup_zze = (zzup.zze) pair.first;
                    if (!TextUtils.isEmpty(com_google_android_gms_internal_zzup_zze.apf)) {
                        obj = com_google_android_gms_internal_zzup_zze.apf;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i2 = 0; i2 < zzn.size(); i2++) {
                        com_google_android_gms_internal_zzup_zze = (zzup.zze) ((Pair) zzn.get(i2)).first;
                        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzup_zze.apf) && !com_google_android_gms_internal_zzup_zze.apf.equals(obj)) {
                            subList = zzn.subList(0, i2);
                            break;
                        }
                    }
                }
                subList = zzn;
                zzd com_google_android_gms_internal_zzup_zzd = new zzd();
                com_google_android_gms_internal_zzup_zzd.aoP = new zzup.zze[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < com_google_android_gms_internal_zzup_zzd.aoP.length) {
                    com_google_android_gms_internal_zzup_zzd.aoP[i] = (zzup.zze) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    com_google_android_gms_internal_zzup_zzd.aoP[i].ape = Long.valueOf(zzbtb().zzbqv());
                    com_google_android_gms_internal_zzup_zzd.aoP[i].aoU = Long.valueOf(currentTimeMillis);
                    com_google_android_gms_internal_zzup_zzd.aoP[i].apk = Boolean.valueOf(zzbtb().zzabc());
                    i++;
                }
                Object zzb = zzbsz().zzaz(2) ? zzal.zzb(com_google_android_gms_internal_zzup_zzd) : null;
                byte[] zza = zzbsv().zza(com_google_android_gms_internal_zzup_zzd);
                String zzbsg = zzbtb().zzbsg();
                try {
                    URL url2 = new URL(zzbsg);
                    zzad(arrayList);
                    zzbta().alw.set(currentTimeMillis);
                    Object obj2 = "?";
                    if (com_google_android_gms_internal_zzup_zzd.aoP.length > 0) {
                        obj2 = com_google_android_gms_internal_zzup_zzd.aoP[0].zzck;
                    }
                    zzbsz().zzbty().zzd("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(zza.length), zzb);
                    zzbuo().zza(zzbtc, url2, zza, null, new C05132(this));
                } catch (MalformedURLException e2) {
                    zzbsz().zzbtr().zzj("Failed to parse upload URL. Not uploading", zzbsg);
                }
            }
        } else {
            zzbsz().zzbtt().log("Network not connected, ignoring upload request");
            zzbva();
        }
    }

    void zzbvc() {
        this.amL++;
    }

    @WorkerThread
    void zzbvd() {
        zzwu();
        zzzg();
        if (!this.amF) {
            zzbsz().zzbtw().log("This instance being marked as an uploader");
            zzbus();
        }
        this.amF = true;
    }

    @WorkerThread
    boolean zzbve() {
        zzwu();
        zzzg();
        return this.amF || zzbuu();
    }

    void zzc(AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzhs(appMetadata.packageName);
        zze(appMetadata);
    }

    @WorkerThread
    void zzc(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        zzb(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    @WorkerThread
    void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        zzzg();
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (appMetadata.ajE) {
                zzbsz().zzbtx().zzj("Removing user property", userAttributeParcel.name);
                zzbsu().beginTransaction();
                try {
                    zze(appMetadata);
                    zzbsu().zzar(appMetadata.packageName, userAttributeParcel.name);
                    zzbsu().setTransactionSuccessful();
                    zzbsz().zzbtx().zzj("User property removed", userAttributeParcel.name);
                } finally {
                    zzbsu().endTransaction();
                }
            } else {
                zze(appMetadata);
            }
        }
    }

    @WorkerThread
    public void zzd(AppMetadata appMetadata) {
        zzwu();
        zzzg();
        zzab.zzaa(appMetadata);
        zzab.zzhs(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.ajz)) {
            if (appMetadata.ajE) {
                long currentTimeMillis = zzyw().currentTimeMillis();
                zzbsu().beginTransaction();
                try {
                    zza(appMetadata, currentTimeMillis);
                    zze(appMetadata);
                    if (zzbsu().zzaq(appMetadata.packageName, "_f") == null) {
                        zzb(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                        zzb(appMetadata, currentTimeMillis);
                        zzc(appMetadata, currentTimeMillis);
                    } else if (appMetadata.ajF) {
                        zzd(appMetadata, currentTimeMillis);
                    }
                    zzbsu().setTransactionSuccessful();
                } finally {
                    zzbsu().endTransaction();
                }
            } else {
                zze(appMetadata);
            }
        }
    }

    @WorkerThread
    void zzd(AppMetadata appMetadata, long j) {
        zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    @WorkerThread
    boolean zzu(int i, int i2) {
        zzwu();
        if (i > i2) {
            zzbsz().zzbtr().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (zza(i2, zzbur())) {
                zzbsz().zzbty().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzbsz().zzbtr().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    public void zzwu() {
        zzbsy().zzwu();
    }

    void zzyv() {
        if (zzbtb().zzabc()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public zze zzyw() {
        return this.zzaoa;
    }

    void zzzg() {
        if (!this.zzcwt) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }
}
