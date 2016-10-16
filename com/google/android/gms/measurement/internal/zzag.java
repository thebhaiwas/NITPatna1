package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class zzag {
    final boolean als;
    final int anL;
    final boolean anM;
    final String anN;
    final List<String> anO;
    final String anP;

    public zzag(zzf com_google_android_gms_internal_zzun_zzf) {
        boolean z;
        boolean z2 = false;
        zzab.zzaa(com_google_android_gms_internal_zzun_zzf);
        if (com_google_android_gms_internal_zzun_zzf.aos == null || com_google_android_gms_internal_zzun_zzf.aos.intValue() == 0) {
            z = false;
        } else {
            if (com_google_android_gms_internal_zzun_zzf.aos.intValue() == 6) {
                if (com_google_android_gms_internal_zzun_zzf.aov == null || com_google_android_gms_internal_zzun_zzf.aov.length == 0) {
                    z = false;
                }
            } else if (com_google_android_gms_internal_zzun_zzf.aot == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.anL = com_google_android_gms_internal_zzun_zzf.aos.intValue();
            if (com_google_android_gms_internal_zzun_zzf.aou != null && com_google_android_gms_internal_zzun_zzf.aou.booleanValue()) {
                z2 = true;
            }
            this.anM = z2;
            if (this.anM || this.anL == 1 || this.anL == 6) {
                this.anN = com_google_android_gms_internal_zzun_zzf.aot;
            } else {
                this.anN = com_google_android_gms_internal_zzun_zzf.aot.toUpperCase(Locale.ENGLISH);
            }
            this.anO = com_google_android_gms_internal_zzun_zzf.aov == null ? null : zza(com_google_android_gms_internal_zzun_zzf.aov, this.anM);
            if (this.anL == 1) {
                this.anP = this.anN;
            } else {
                this.anP = null;
            }
        } else {
            this.anL = 0;
            this.anM = false;
            this.anN = null;
            this.anO = null;
            this.anP = null;
        }
        this.als = z;
    }

    private List<String> zza(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzmj(String str) {
        if (!this.als || str == null) {
            return null;
        }
        if (!(this.anM || this.anL == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.anL) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return Boolean.valueOf(Pattern.compile(this.anP, this.anM ? 0 : 66).matcher(str).matches());
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return Boolean.valueOf(str.startsWith(this.anN));
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return Boolean.valueOf(str.endsWith(this.anN));
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return Boolean.valueOf(str.contains(this.anN));
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                return Boolean.valueOf(str.equals(this.anN));
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                return Boolean.valueOf(this.anO.contains(str));
            default:
                return null;
        }
    }
}
