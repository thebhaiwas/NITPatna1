package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import xyz.purush.nitp.nitpatna.C0337R;

public class zzb implements Creator<AppMetadata> {
    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appMetadata.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, appMetadata.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, appMetadata.ajz, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, appMetadata.abU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, appMetadata.ajA, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, appMetadata.ajB);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, appMetadata.ajC);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, appMetadata.ajD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, appMetadata.ajE);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, appMetadata.ajF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, appMetadata.ajG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, appMetadata.ajH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzom(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzve(i);
    }

    public AppMetadata zzom(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        String str5 = null;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        String str6 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    j = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.NETWORK_ERROR /*7*/:
                    j2 = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    str5 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    z2 = zza.zzc(parcel, zzck);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    j3 = zza.zzi(parcel, zzck);
                    break;
                case C0337R.styleable.Toolbar_titleMargins /*12*/:
                    str6 = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new AppMetadata(i, str, str2, str3, str4, j, j2, str5, z, z2, j3, str6);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public AppMetadata[] zzve(int i) {
        return new AppMetadata[i];
    }
}
