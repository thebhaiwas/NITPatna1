package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Request> {
    static void zza(Request request, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, request.ba, i, false);
        zzb.zza(parcel, 2, request.bb);
        zzb.zza(parcel, 3, request.bc);
        zzb.zza(parcel, 4, request.bd);
        zzb.zza(parcel, 5, request.be, false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, request.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcc(i);
    }

    public Request[] zzcc(int i) {
        return new Request[i];
    }

    public Request zzy(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcl = zza.zzcl(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    account = (Account) zza.zza(parcel, zzck, Account.CREATOR);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    z3 = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    z = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    str = zza.zzq(parcel, zzck);
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
            return new Request(i, account, z3, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
