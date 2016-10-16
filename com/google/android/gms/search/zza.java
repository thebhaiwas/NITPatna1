package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GoogleNowAuthState> {
    static void zza(GoogleNowAuthState googleNowAuthState, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, googleNowAuthState.getAuthCode(), false);
        zzb.zza(parcel, 2, googleNowAuthState.getAccessToken(), false);
        zzb.zza(parcel, 3, googleNowAuthState.getNextAllowedTimeMillis());
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, googleNowAuthState.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzql(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzxp(i);
    }

    public GoogleNowAuthState zzql(Parcel parcel) {
        String str = null;
        int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = com.google.android.gms.common.internal.safeparcel.zza.zzck(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzck);
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
            return new GoogleNowAuthState(i, str2, str, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public GoogleNowAuthState[] zzxp(int i) {
        return new GoogleNowAuthState[i];
    }
}
