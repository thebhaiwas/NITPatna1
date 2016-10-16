package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<Response> {
    static void zza(Response response, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zza(parcel, 1, response.bf, i, false);
        zzb.zzc(parcel, 2, response.bg, false);
        zzb.zza(parcel, 3, response.bh, false);
        zzb.zzc(parcel, ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS, response.mVersionCode);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzcd(i);
    }

    public Response[] zzcd(int i) {
        return new Response[i];
    }

    public Response zzz(Parcel parcel) {
        String[] strArr = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        List list = null;
        Status status = null;
        while (parcel.dataPosition() < zzcl) {
            int i2;
            Status status2;
            String[] strArr2;
            List list2;
            int zzck = zza.zzck(parcel);
            String[] strArr3;
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i2 = i;
                    List list3 = list;
                    status2 = (Status) zza.zza(parcel, zzck, Status.CREATOR);
                    strArr2 = strArr;
                    list2 = list3;
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    status2 = status;
                    i2 = i;
                    strArr3 = strArr;
                    Object zzc = zza.zzc(parcel, zzck, UsageInfo.CREATOR);
                    strArr2 = strArr3;
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    strArr2 = zza.zzac(parcel, zzck);
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
                case ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS /*1000*/:
                    strArr3 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzck);
                    strArr2 = strArr3;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    strArr2 = strArr;
                    list2 = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            list = list2;
            strArr = strArr2;
        }
        if (parcel.dataPosition() == zzcl) {
            return new Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }
}
