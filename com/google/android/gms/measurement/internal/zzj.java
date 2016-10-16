package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<EventParams> {
    static void zza(EventParams eventParams, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, eventParams.versionCode);
        zzb.zza(parcel, 2, eventParams.zzbto(), false);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzon(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvf(i);
    }

    public EventParams zzon(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    bundle = zza.zzs(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new EventParams(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public EventParams[] zzvf(int i) {
        return new EventParams[i];
    }
}
