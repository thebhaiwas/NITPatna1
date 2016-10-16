package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<UsageInfo> {
    static void zza(UsageInfo usageInfo, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, usageInfo.by, i, false);
        zzb.zza(parcel, 2, usageInfo.bz);
        zzb.zzc(parcel, 3, usageInfo.bA);
        zzb.zza(parcel, 4, usageInfo.zzaxj, false);
        zzb.zza(parcel, 5, usageInfo.bB, i, false);
        zzb.zza(parcel, 6, usageInfo.bC);
        zzb.zzc(parcel, 7, usageInfo.bD);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, usageInfo.mVersionCode);
        zzb.zzc(parcel, 8, usageInfo.bE);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzab(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcj(i);
    }

    public UsageInfo zzab(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int zzcl = zza.zzcl(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    documentId = (DocumentId) zza.zza(parcel, zzck, DocumentId.CREATOR);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    j = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    i3 = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    documentContents = (DocumentContents) zza.zza(parcel, zzck, DocumentContents.CREATOR);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    z = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.NETWORK_ERROR /*7*/:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS /*1000*/:
                    i4 = zza.zzg(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public UsageInfo[] zzcj(int i) {
        return new UsageInfo[i];
    }
}
