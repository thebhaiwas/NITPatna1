package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;

class zza {
    private String By;
    private final zzx aja;
    private String ajg;
    private String ajh;
    private String aji;
    private long ajj;
    private long ajk;
    private long ajl;
    private long ajm;
    private String ajn;
    private long ajo;
    private long ajp;
    private boolean ajq;
    private long ajr;
    private long ajs;
    private long ajt;
    private long aju;
    private long ajv;
    private boolean ajw;
    private long ajx;
    private long ajy;
    private final String zzcjj;
    private String zzcuq;

    @WorkerThread
    zza(zzx com_google_android_gms_measurement_internal_zzx, String str) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzx);
        zzab.zzhs(str);
        this.aja = com_google_android_gms_measurement_internal_zzx;
        this.zzcjj = str;
        this.aja.zzwu();
    }

    @WorkerThread
    public void setAppVersion(String str) {
        this.aja.zzwu();
        this.ajw = (!zzal.zzbb(this.zzcuq, str) ? 1 : 0) | this.ajw;
        this.zzcuq = str;
    }

    @WorkerThread
    public void setMeasurementEnabled(boolean z) {
        this.aja.zzwu();
        this.ajw = (this.ajq != z ? 1 : 0) | this.ajw;
        this.ajq = z;
    }

    @WorkerThread
    public void zzat(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajk != j ? 1 : 0) | this.ajw;
        this.ajk = j;
    }

    @WorkerThread
    public void zzau(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajl != j ? 1 : 0) | this.ajw;
        this.ajl = j;
    }

    @WorkerThread
    public void zzav(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajm != j ? 1 : 0) | this.ajw;
        this.ajm = j;
    }

    @WorkerThread
    public void zzaw(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajo != j ? 1 : 0) | this.ajw;
        this.ajo = j;
    }

    @WorkerThread
    public String zzawj() {
        this.aja.zzwu();
        return this.By;
    }

    @WorkerThread
    public void zzax(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajp != j ? 1 : 0) | this.ajw;
        this.ajp = j;
    }

    @WorkerThread
    public void zzay(long j) {
        int i = 1;
        zzab.zzbn(j >= 0);
        this.aja.zzwu();
        boolean z = this.ajw;
        if (this.ajj == j) {
            i = 0;
        }
        this.ajw = z | i;
        this.ajj = j;
    }

    @WorkerThread
    public void zzaz(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajx != j ? 1 : 0) | this.ajw;
        this.ajx = j;
    }

    @WorkerThread
    public void zzba(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajy != j ? 1 : 0) | this.ajw;
        this.ajy = j;
    }

    @WorkerThread
    public void zzbb(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajr != j ? 1 : 0) | this.ajw;
        this.ajr = j;
    }

    @WorkerThread
    public void zzbc(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajs != j ? 1 : 0) | this.ajw;
        this.ajs = j;
    }

    @WorkerThread
    public void zzbd(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajt != j ? 1 : 0) | this.ajw;
        this.ajt = j;
    }

    @WorkerThread
    public void zzbe(long j) {
        this.aja.zzwu();
        this.ajw = (this.aju != j ? 1 : 0) | this.ajw;
        this.aju = j;
    }

    @WorkerThread
    public void zzbf(long j) {
        this.aja.zzwu();
        this.ajw = (this.ajv != j ? 1 : 0) | this.ajw;
        this.ajv = j;
    }

    @WorkerThread
    public void zzbqn() {
        this.aja.zzwu();
        this.ajw = false;
    }

    @WorkerThread
    public String zzbqo() {
        this.aja.zzwu();
        return this.ajg;
    }

    @WorkerThread
    public String zzbqp() {
        this.aja.zzwu();
        return this.ajh;
    }

    @WorkerThread
    public String zzbqq() {
        this.aja.zzwu();
        return this.aji;
    }

    @WorkerThread
    public long zzbqr() {
        this.aja.zzwu();
        return this.ajk;
    }

    @WorkerThread
    public long zzbqs() {
        this.aja.zzwu();
        return this.ajl;
    }

    @WorkerThread
    public long zzbqt() {
        this.aja.zzwu();
        return this.ajm;
    }

    @WorkerThread
    public String zzbqu() {
        this.aja.zzwu();
        return this.ajn;
    }

    @WorkerThread
    public long zzbqv() {
        this.aja.zzwu();
        return this.ajo;
    }

    @WorkerThread
    public long zzbqw() {
        this.aja.zzwu();
        return this.ajp;
    }

    @WorkerThread
    public boolean zzbqx() {
        this.aja.zzwu();
        return this.ajq;
    }

    @WorkerThread
    public long zzbqy() {
        this.aja.zzwu();
        return this.ajj;
    }

    @WorkerThread
    public long zzbqz() {
        this.aja.zzwu();
        return this.ajx;
    }

    @WorkerThread
    public long zzbra() {
        this.aja.zzwu();
        return this.ajy;
    }

    @WorkerThread
    public void zzbrb() {
        this.aja.zzwu();
        long j = this.ajj + 1;
        if (j > 2147483647L) {
            this.aja.zzbsz().zzbtt().log("Bundle index overflow");
            j = 0;
        }
        this.ajw = true;
        this.ajj = j;
    }

    @WorkerThread
    public long zzbrc() {
        this.aja.zzwu();
        return this.ajr;
    }

    @WorkerThread
    public long zzbrd() {
        this.aja.zzwu();
        return this.ajs;
    }

    @WorkerThread
    public long zzbre() {
        this.aja.zzwu();
        return this.ajt;
    }

    @WorkerThread
    public long zzbrf() {
        this.aja.zzwu();
        return this.aju;
    }

    @WorkerThread
    public long zzbrg() {
        this.aja.zzwu();
        return this.ajv;
    }

    @WorkerThread
    public void zzkz(String str) {
        this.aja.zzwu();
        this.ajw = (!zzal.zzbb(this.By, str) ? 1 : 0) | this.ajw;
        this.By = str;
    }

    @WorkerThread
    public void zzla(String str) {
        this.aja.zzwu();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.ajw = (!zzal.zzbb(this.ajg, str) ? 1 : 0) | this.ajw;
        this.ajg = str;
    }

    @WorkerThread
    public void zzlb(String str) {
        this.aja.zzwu();
        this.ajw = (!zzal.zzbb(this.ajh, str) ? 1 : 0) | this.ajw;
        this.ajh = str;
    }

    @WorkerThread
    public void zzlc(String str) {
        this.aja.zzwu();
        this.ajw = (!zzal.zzbb(this.aji, str) ? 1 : 0) | this.ajw;
        this.aji = str;
    }

    @WorkerThread
    public void zzld(String str) {
        this.aja.zzwu();
        this.ajw = (!zzal.zzbb(this.ajn, str) ? 1 : 0) | this.ajw;
        this.ajn = str;
    }

    @WorkerThread
    public String zzsi() {
        this.aja.zzwu();
        return this.zzcjj;
    }

    @WorkerThread
    public String zzxc() {
        this.aja.zzwu();
        return this.zzcuq;
    }
}
