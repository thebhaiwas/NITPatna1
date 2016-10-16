package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;
import xyz.purush.nitp.nitpatna.C0337R;

public class zzg implements Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, wakeLockEvent.mVersionCode);
        zzb.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzb.zza(parcel, 4, wakeLockEvent.zzauv(), false);
        zzb.zzc(parcel, 5, wakeLockEvent.zzauy());
        zzb.zzb(parcel, 6, wakeLockEvent.zzauz(), false);
        zzb.zza(parcel, 8, wakeLockEvent.zzaur());
        zzb.zza(parcel, 10, wakeLockEvent.zzauw(), false);
        zzb.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzb.zza(parcel, 12, wakeLockEvent.zzauo(), false);
        zzb.zza(parcel, 13, wakeLockEvent.zzavb(), false);
        zzb.zzc(parcel, 14, wakeLockEvent.zzava());
        zzb.zza(parcel, 15, wakeLockEvent.zzavc());
        zzb.zza(parcel, 16, wakeLockEvent.zzavd());
        zzb.zza(parcel, 17, wakeLockEvent.zzaux(), false);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgu(i);
    }

    public WakeLockEvent zzcx(Parcel parcel) {
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        String str5 = null;
        while (parcel.dataPosition() < zzcl) {
            int zzck = zza.zzck(parcel);
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    i = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    j = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    i3 = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                    list = zza.zzae(parcel, zzck);
                    break;
                case ConnectionResult.INTERNAL_ERROR /*8*/:
                    j2 = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    str3 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    i2 = zza.zzg(parcel, zzck);
                    break;
                case C0337R.styleable.Toolbar_titleMargins /*12*/:
                    str2 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.CANCELED /*13*/:
                    str4 = zza.zzq(parcel, zzck);
                    break;
                case ConnectionResult.TIMEOUT /*14*/:
                    i4 = zza.zzg(parcel, zzck);
                    break;
                case ConnectionResult.INTERRUPTED /*15*/:
                    f = zza.zzl(parcel, zzck);
                    break;
                case ConnectionResult.API_UNAVAILABLE /*16*/:
                    j3 = zza.zzi(parcel, zzck);
                    break;
                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                    str5 = zza.zzq(parcel, zzck);
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcl) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3, str5);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public WakeLockEvent[] zzgu(int i) {
        return new WakeLockEvent[i];
    }
}
