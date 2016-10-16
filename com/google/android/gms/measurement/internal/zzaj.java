package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaj implements Creator<UserAttributeParcel> {
    static void zza(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, userAttributeParcel.versionCode);
        zzb.zza(parcel, 2, userAttributeParcel.name, false);
        zzb.zza(parcel, 3, userAttributeParcel.anQ);
        zzb.zza(parcel, 4, userAttributeParcel.anR, false);
        zzb.zza(parcel, 5, userAttributeParcel.anS, false);
        zzb.zza(parcel, 6, userAttributeParcel.zr, false);
        zzb.zza(parcel, 7, userAttributeParcel.akg, false);
        zzb.zza(parcel, 8, userAttributeParcel.anT, false);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzop(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvh(i);
    }

    public UserAttributeParcel zzop(Parcel parcel) {
        Double d = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    j = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    l = zza.zzj(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    f = zza.zzm(parcel, zzck);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.NETWORK_ERROR /*7*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    d = zza.zzo(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public UserAttributeParcel[] zzvh(int i) {
        return new UserAttributeParcel[i];
    }
}
