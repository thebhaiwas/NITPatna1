package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzab;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Locale;
import xyz.purush.nitp.nitpatna.BuildConfig;

class zzt extends zzaa {
    static final Pair<String, Long> alt;
    private SharedPreferences al;
    private String alA;
    private boolean alB;
    private long alC;
    private SecureRandom alD;
    public final zzb alE;
    public final zzb alF;
    public final zza alG;
    public final zzb alH;
    public final zzb alI;
    public boolean alJ;
    public final zzc alu;
    public final zzb alv;
    public final zzb alw;
    public final zzb alx;
    public final zzb aly;
    public final zzb alz;

    public final class zza {
        private final boolean alK;
        private boolean alL;
        final /* synthetic */ zzt alM;
        private boolean rD;
        private final String zzaxn;

        public zza(zzt com_google_android_gms_measurement_internal_zzt, String str, boolean z) {
            this.alM = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhs(str);
            this.zzaxn = str;
            this.alK = z;
        }

        @WorkerThread
        private void zzbui() {
            if (!this.alL) {
                this.alL = true;
                this.rD = this.alM.al.getBoolean(this.zzaxn, this.alK);
            }
        }

        @WorkerThread
        public boolean get() {
            zzbui();
            return this.rD;
        }

        @WorkerThread
        public void set(boolean z) {
            Editor edit = this.alM.al.edit();
            edit.putBoolean(this.zzaxn, z);
            edit.apply();
            this.rD = z;
        }
    }

    public final class zzb {
        private boolean alL;
        final /* synthetic */ zzt alM;
        private final long alN;
        private final String zzaxn;
        private long zzcvh;

        public zzb(zzt com_google_android_gms_measurement_internal_zzt, String str, long j) {
            this.alM = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhs(str);
            this.zzaxn = str;
            this.alN = j;
        }

        @WorkerThread
        private void zzbui() {
            if (!this.alL) {
                this.alL = true;
                this.zzcvh = this.alM.al.getLong(this.zzaxn, this.alN);
            }
        }

        @WorkerThread
        public long get() {
            zzbui();
            return this.zzcvh;
        }

        @WorkerThread
        public void set(long j) {
            Editor edit = this.alM.al.edit();
            edit.putLong(this.zzaxn, j);
            edit.apply();
            this.zzcvh = j;
        }
    }

    public final class zzc {
        final /* synthetic */ zzt alM;
        final String alO;
        private final String alP;
        private final String alQ;
        private final long ap;

        private zzc(zzt com_google_android_gms_measurement_internal_zzt, String str, long j) {
            this.alM = com_google_android_gms_measurement_internal_zzt;
            zzab.zzhs(str);
            zzab.zzbn(j > 0);
            this.alO = String.valueOf(str).concat(":start");
            this.alP = String.valueOf(str).concat(":count");
            this.alQ = String.valueOf(str).concat(":value");
            this.ap = j;
        }

        @WorkerThread
        private void zzadt() {
            this.alM.zzwu();
            long currentTimeMillis = this.alM.zzyw().currentTimeMillis();
            Editor edit = this.alM.al.edit();
            edit.remove(this.alP);
            edit.remove(this.alQ);
            edit.putLong(this.alO, currentTimeMillis);
            edit.apply();
        }

        @WorkerThread
        private long zzadu() {
            this.alM.zzwu();
            long zzadw = zzadw();
            if (zzadw != 0) {
                return Math.abs(zzadw - this.alM.zzyw().currentTimeMillis());
            }
            zzadt();
            return 0;
        }

        @WorkerThread
        private long zzadw() {
            return this.alM.zzbud().getLong(this.alO, 0);
        }

        @WorkerThread
        public Pair<String, Long> zzadv() {
            this.alM.zzwu();
            long zzadu = zzadu();
            if (zzadu < this.ap) {
                return null;
            }
            if (zzadu > this.ap * 2) {
                zzadt();
                return null;
            }
            String string = this.alM.zzbud().getString(this.alQ, null);
            zzadu = this.alM.zzbud().getLong(this.alP, 0);
            zzadt();
            return (string == null || zzadu <= 0) ? zzt.alt : new Pair(string, Long.valueOf(zzadu));
        }

        @WorkerThread
        public void zzew(String str) {
            zzg(str, 1);
        }

        @WorkerThread
        public void zzg(String str, long j) {
            this.alM.zzwu();
            if (zzadw() == 0) {
                zzadt();
            }
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            long j2 = this.alM.al.getLong(this.alP, 0);
            if (j2 <= 0) {
                Editor edit = this.alM.al.edit();
                edit.putString(this.alQ, str);
                edit.putLong(this.alP, j);
                edit.apply();
                return;
            }
            Object obj = (this.alM.zzbua().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j ? 1 : null;
            Editor edit2 = this.alM.al.edit();
            if (obj != null) {
                edit2.putString(this.alQ, str);
            }
            edit2.putLong(this.alP, j2 + j);
            edit2.apply();
        }
    }

    static {
        alt = new Pair(BuildConfig.FLAVOR, Long.valueOf(0));
    }

    zzt(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.alu = new zzc("health_monitor", zzbtb().zzaci(), null);
        this.alv = new zzb(this, "last_upload", 0);
        this.alw = new zzb(this, "last_upload_attempt", 0);
        this.alx = new zzb(this, "backoff", 0);
        this.aly = new zzb(this, "last_delete_stale", 0);
        this.alE = new zzb(this, "time_before_start", 10000);
        this.alF = new zzb(this, "session_timeout", 1800000);
        this.alG = new zza(this, "start_new_session", true);
        this.alH = new zzb(this, "last_pause_time", 0);
        this.alI = new zzb(this, "time_active", 0);
        this.alz = new zzb(this, "midnight_offset", 0);
    }

    @WorkerThread
    private SecureRandom zzbua() {
        zzwu();
        if (this.alD == null) {
            this.alD = new SecureRandom();
        }
        return this.alD;
    }

    @WorkerThread
    private SharedPreferences zzbud() {
        zzwu();
        zzzg();
        return this.al;
    }

    @WorkerThread
    void setMeasurementEnabled(boolean z) {
        zzwu();
        zzbsz().zzbty().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        Editor edit = zzbud().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    @WorkerThread
    String zzbqq() {
        zzwu();
        return com.google.firebase.iid.zzc.zzcwt().getId();
    }

    @WorkerThread
    String zzbub() {
        zzbua().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    @WorkerThread
    long zzbuc() {
        zzzg();
        zzwu();
        long j = this.alz.get();
        if (j != 0) {
            return j;
        }
        j = (long) (zzbua().nextInt(86400000) + 1);
        this.alz.set(j);
        return j;
    }

    @WorkerThread
    String zzbue() {
        zzwu();
        return zzbud().getString("gmp_app_id", null);
    }

    @WorkerThread
    Boolean zzbuf() {
        zzwu();
        return !zzbud().contains("use_service") ? null : Boolean.valueOf(zzbud().getBoolean("use_service", false));
    }

    @WorkerThread
    void zzbug() {
        boolean z = true;
        zzwu();
        zzbsz().zzbty().log("Clearing collection preferences.");
        boolean contains = zzbud().contains("measurement_enabled");
        if (contains) {
            z = zzcb(true);
        }
        Editor edit = zzbud().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    @WorkerThread
    protected String zzbuh() {
        zzwu();
        String string = zzbud().getString("previous_os_version", null);
        String zzbtk = zzbss().zzbtk();
        if (!(TextUtils.isEmpty(zzbtk) || zzbtk.equals(string))) {
            Editor edit = zzbud().edit();
            edit.putString("previous_os_version", zzbtk);
            edit.apply();
        }
        return string;
    }

    @WorkerThread
    void zzca(boolean z) {
        zzwu();
        zzbsz().zzbty().zzj("Setting useService", Boolean.valueOf(z));
        Editor edit = zzbud().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    @WorkerThread
    boolean zzcb(boolean z) {
        zzwu();
        return zzbud().getBoolean("measurement_enabled", z);
    }

    @WorkerThread
    @NonNull
    Pair<String, Boolean> zzly(String str) {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.alA != null && elapsedRealtime < this.alC) {
            return new Pair(this.alA, Boolean.valueOf(this.alB));
        }
        this.alC = elapsedRealtime + zzbtb().zzlh(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.alA = advertisingIdInfo.getId();
            if (this.alA == null) {
                this.alA = BuildConfig.FLAVOR;
            }
            this.alB = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzbsz().zzbtx().zzj("Unable to get advertising id", th);
            this.alA = BuildConfig.FLAVOR;
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.alA, Boolean.valueOf(this.alB));
    }

    String zzlz(String str) {
        String str2 = (String) zzly(str).first;
        if (zzal.zzfb("MD5") == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzal.zzfb("MD5").digest(str2.getBytes()))});
    }

    @WorkerThread
    void zzma(String str) {
        zzwu();
        Editor edit = zzbud().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    protected void zzwv() {
        this.al = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.alJ = this.al.getBoolean("has_been_opened", false);
        if (!this.alJ) {
            Editor edit = this.al.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
}
