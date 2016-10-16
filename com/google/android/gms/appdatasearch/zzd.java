package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DocumentSection> {
    static void zza(DocumentSection documentSection, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, documentSection.aV, false);
        zzb.zza(parcel, 3, documentSection.aW, i, false);
        zzb.zzc(parcel, 4, documentSection.aX);
        zzb.zza(parcel, 5, documentSection.aY, false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, documentSection.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzw(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzca(i);
    }

    public DocumentSection[] zzca(int i) {
        return new DocumentSection[i];
    }

    public DocumentSection zzw(Parcel parcel) {
        byte[] bArr = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        int i2 = -1;
        RegisterSectionInfo registerSectionInfo = null;
        String str = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    registerSectionInfo = (RegisterSectionInfo) zza.zza(parcel, zzck, RegisterSectionInfo.CREATOR);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    bArr = zza.zzt(parcel, zzck);
                    break;
                case ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS /*1000*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new DocumentSection(i, str, registerSectionInfo, i2, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
