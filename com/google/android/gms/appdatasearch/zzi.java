package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zza(parcel, 2, registerSectionInfo.bk, false);
        zzb.zza(parcel, 3, registerSectionInfo.bl);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.bm);
        zzb.zza(parcel, 6, registerSectionInfo.bn, false);
        zzb.zza(parcel, 7, registerSectionInfo.bo, i, false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, registerSectionInfo.mVersionCode);
        zzb.zza(parcel, 8, registerSectionInfo.bp, false);
        zzb.zza(parcel, 11, registerSectionInfo.bq, false);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaa(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcg(i);
    }

    public RegisterSectionInfo zzaa(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    z = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.NETWORK_ERROR /*7*/:
                    featureArr = (Feature[]) zza.zzb(parcel, zzck, Feature.CREATOR);
                    break;
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    iArr = zza.zzw(parcel, zzck);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    str = zza.zzq(parcel, zzck);
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
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public RegisterSectionInfo[] zzcg(int i) {
        return new RegisterSectionInfo[i];
    }
}
