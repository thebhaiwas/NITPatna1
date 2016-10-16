package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class UserAttributeParcel extends AbstractSafeParcelable {
    public static final zzaj CREATOR;
    public final String akg;
    public final long anQ;
    public final Long anR;
    public final Float anS;
    public final Double anT;
    public final String name;
    public final int versionCode;
    public final String zr;

    static {
        CREATOR = new zzaj();
    }

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.anQ = j;
        this.anR = l;
        this.anS = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.anT = d2;
        } else {
            this.anT = d;
        }
        this.zr = str2;
        this.akg = str3;
    }

    UserAttributeParcel(zzak com_google_android_gms_measurement_internal_zzak) {
        this(com_google_android_gms_measurement_internal_zzak.mName, com_google_android_gms_measurement_internal_zzak.anU, com_google_android_gms_measurement_internal_zzak.zzcnr, com_google_android_gms_measurement_internal_zzak.zzcjj);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        zzab.zzhs(str);
        this.versionCode = 2;
        this.name = str;
        this.anQ = j;
        this.akg = str2;
        if (obj == null) {
            this.anR = null;
            this.anS = null;
            this.anT = null;
            this.zr = null;
        } else if (obj instanceof Long) {
            this.anR = (Long) obj;
            this.anS = null;
            this.anT = null;
            this.zr = null;
        } else if (obj instanceof String) {
            this.anR = null;
            this.anS = null;
            this.anT = null;
            this.zr = (String) obj;
        } else if (obj instanceof Double) {
            this.anR = null;
            this.anS = null;
            this.anT = (Double) obj;
            this.zr = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object getValue() {
        return this.anR != null ? this.anR : this.anT != null ? this.anT : this.zr != null ? this.zr : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }
}
