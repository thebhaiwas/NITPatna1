package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zzd;

class zzs {
    final boolean alk;
    final int all;
    long alm;
    double aln;
    long alo;
    double alp;
    long alq;
    double alr;
    final boolean als;

    public zzs(zzd com_google_android_gms_internal_zzun_zzd) {
        boolean z;
        boolean z2 = true;
        zzab.zzaa(com_google_android_gms_internal_zzun_zzd);
        if (com_google_android_gms_internal_zzun_zzd.aok == null || com_google_android_gms_internal_zzun_zzd.aok.intValue() == 0) {
            z = false;
        } else {
            if (com_google_android_gms_internal_zzun_zzd.aok.intValue() != 4) {
                if (com_google_android_gms_internal_zzun_zzd.aom == null) {
                    z = false;
                }
            } else if (com_google_android_gms_internal_zzun_zzd.aon == null || com_google_android_gms_internal_zzun_zzd.aoo == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.all = com_google_android_gms_internal_zzun_zzd.aok.intValue();
            if (com_google_android_gms_internal_zzun_zzd.aol == null || !com_google_android_gms_internal_zzun_zzd.aol.booleanValue()) {
                z2 = false;
            }
            this.alk = z2;
            if (com_google_android_gms_internal_zzun_zzd.aok.intValue() == 4) {
                if (this.alk) {
                    this.alp = Double.parseDouble(com_google_android_gms_internal_zzun_zzd.aon);
                    this.alr = Double.parseDouble(com_google_android_gms_internal_zzun_zzd.aoo);
                } else {
                    this.alo = Long.parseLong(com_google_android_gms_internal_zzun_zzd.aon);
                    this.alq = Long.parseLong(com_google_android_gms_internal_zzun_zzd.aoo);
                }
            } else if (this.alk) {
                this.aln = Double.parseDouble(com_google_android_gms_internal_zzun_zzd.aom);
            } else {
                this.alm = Long.parseLong(com_google_android_gms_internal_zzun_zzd.aom);
            }
        } else {
            this.all = 0;
            this.alk = false;
        }
        this.als = z;
    }

    public Boolean zzbj(long j) {
        boolean z = true;
        if (!this.als) {
            return null;
        }
        if (this.alk) {
            return null;
        }
        switch (this.all) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                if (j >= this.alm) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                if (j <= this.alm) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                if (j != this.alm) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                if (j < this.alo || j > this.alq) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean zzj(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.als) {
            return null;
        }
        if (!this.alk) {
            return null;
        }
        switch (this.all) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                if (d >= this.aln) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                if (d <= this.aln) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                if (d == this.aln || Math.abs(d - this.aln) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.aln))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                if (d < this.alp || d > this.alr) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
