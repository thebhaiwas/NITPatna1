package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, feature.id);
        zzb.zza(parcel, 2, feature.aZ, false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, feature.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcb(i);
    }

    public Feature[] zzcb(int i) {
        return new Feature[i];
    }

    public Feature zzx(Parcel parcel) {
        int i = 0;
        int zzcl = zza.zzcl(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    bundle = zza.zzs(parcel, zzck);
                    break;
                case ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS /*1000*/:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new Feature(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
