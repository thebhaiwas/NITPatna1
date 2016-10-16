package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<EventParcel> {
    static void zza(EventParcel eventParcel, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, eventParcel.versionCode);
        zzb.zza(parcel, 2, eventParcel.name, false);
        zzb.zza(parcel, 3, eventParcel.akf, i, false);
        zzb.zza(parcel, 4, eventParcel.akg, false);
        zzb.zza(parcel, 5, eventParcel.akh);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzoo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvg(i);
    }

    public EventParcel zzoo(Parcel parcel) {
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    eventParams = (EventParams) zza.zza(parcel, zzck, EventParams.CREATOR);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    j = zza.zzi(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public EventParcel[] zzvg(int i) {
        return new EventParcel[i];
    }
}
