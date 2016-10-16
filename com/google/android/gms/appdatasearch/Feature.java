package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public class Feature extends AbstractSafeParcelable {
    public static final zze CREATOR;
    final Bundle aZ;
    public final int id;
    final int mVersionCode;

    static {
        CREATOR = new zze();
    }

    Feature(int i, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.id = i2;
        this.aZ = bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        return zzaa.equal(Integer.valueOf(feature.id), Integer.valueOf(this.id)) && zzaa.equal(feature.aZ, this.aZ);
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.id), this.aZ);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze com_google_android_gms_appdatasearch_zze = CREATOR;
        zze.zza(this, parcel, i);
    }
}
