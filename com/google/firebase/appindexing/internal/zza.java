package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.firebase.appindexing.internal.ActionImpl.MetadataImpl;

public class zza implements Creator<ActionImpl> {
    static void zza(ActionImpl actionImpl, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, actionImpl.zzcke(), false);
        zzb.zza(parcel, 2, actionImpl.zzckf(), false);
        zzb.zza(parcel, 3, actionImpl.zzckg(), false);
        zzb.zza(parcel, 4, actionImpl.zzckh(), false);
        zzb.zza(parcel, 5, actionImpl.zzcki(), i, false);
        zzb.zza(parcel, 6, actionImpl.zzckj(), false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, actionImpl.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzun(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzacu(i);
    }

    public ActionImpl[] zzacu(int i) {
        return new ActionImpl[i];
    }

    public ActionImpl zzun(Parcel parcel) {
        String str = null;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int i = 0;
        MetadataImpl metadataImpl = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    metadataImpl = (MetadataImpl) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzck, MetadataImpl.CREATOR);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzck);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new ActionImpl(i, str5, str4, str3, str2, metadataImpl, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
