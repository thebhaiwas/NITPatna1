package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<RecordConsentRequest> {
    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzcm = zzb.zzcm(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.mVersionCode);
        zzb.zza(parcel, 2, recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, recordConsentRequest.zzbzs(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzafu(), false);
        zzb.zzaj(parcel, zzcm);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzqo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzxt(i);
    }

    public RecordConsentRequest zzqo(Parcel parcel) {
        String str = null;
        int zzcl = zza.zzcl(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        Account account = null;
        while (parcel.dataPosition() < zzcl) {
            Scope[] scopeArr2;
            Account account2;
            int zzg;
            String str2;
            int zzck = zza.zzck(parcel);
            String str3;
            switch (zza.zzgi(zzck)) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    str3 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    zzg = zza.zzg(parcel, zzck);
                    str2 = str3;
                    break;
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    zzg = i;
                    Scope[] scopeArr3 = scopeArr;
                    account2 = (Account) zza.zza(parcel, zzck, Account.CREATOR);
                    str2 = str;
                    scopeArr2 = scopeArr3;
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                    account2 = account;
                    zzg = i;
                    str3 = str;
                    scopeArr2 = (Scope[]) zza.zzb(parcel, zzck, Scope.CREATOR);
                    str2 = str3;
                    break;
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    str2 = zza.zzq(parcel, zzck);
                    scopeArr2 = scopeArr;
                    account2 = account;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzck);
                    str2 = str;
                    scopeArr2 = scopeArr;
                    account2 = account;
                    zzg = i;
                    break;
            }
            i = zzg;
            account = account2;
            scopeArr = scopeArr2;
            str = str2;
        }
        if (parcel.dataPosition() == zzcl) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcl, parcel);
    }

    public RecordConsentRequest[] zzxt(int i) {
        return new RecordConsentRequest[i];
    }
}
