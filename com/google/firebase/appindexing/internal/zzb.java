package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.firebase.appindexing.internal.ActionImpl.MetadataImpl;

public class zzb implements Creator<MetadataImpl> {
    static void zza(MetadataImpl metadataImpl, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, metadataImpl.zzckk());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, metadataImpl.zzckl());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, metadataImpl.zzckm(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, metadataImpl.getAccountName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, metadataImpl.zzckn(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, metadataImpl.zzcko());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, metadataImpl.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzuo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzacv(i);
    }

    public MetadataImpl[] zzacv(int i) {
        return new MetadataImpl[i];
    }

    public MetadataImpl zzuo(Parcel parcel) {
        byte[] bArr = null;
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    bArr = zza.zzt(parcel, zzck);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    z = zza.zzc(parcel, zzck);
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
            return new MetadataImpl(i2, i, z2, str2, str, bArr, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
