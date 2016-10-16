package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class GetRecentContextCall {

    public static class Request extends AbstractSafeParcelable {
        public static final zzf CREATOR;
        public final Account ba;
        public final boolean bb;
        public final boolean bc;
        public final boolean bd;
        public final String be;
        final int mVersionCode;

        static {
            CREATOR = new zzf();
        }

        public Request() {
            this(null, false, false, false, null);
        }

        Request(int i, Account account, boolean z, boolean z2, boolean z3, String str) {
            this.mVersionCode = i;
            this.ba = account;
            this.bb = z;
            this.bc = z2;
            this.bd = z3;
            this.be = str;
        }

        public Request(Account account, boolean z, boolean z2, boolean z3, String str) {
            this(1, account, z, z2, z3, str);
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzf com_google_android_gms_appdatasearch_zzf = CREATOR;
            zzf.zza(this, parcel, i);
        }
    }

    public static class Response extends AbstractSafeParcelable implements Result {
        public static final zzg CREATOR;
        public Status bf;
        public List<UsageInfo> bg;
        @Deprecated
        public String[] bh;
        final int mVersionCode;

        static {
            CREATOR = new zzg();
        }

        public Response() {
            this.mVersionCode = 1;
        }

        Response(int i, Status status, List<UsageInfo> list, String[] strArr) {
            this.mVersionCode = i;
            this.bf = status;
            this.bg = list;
            this.bh = strArr;
        }

        public Status getStatus() {
            return this.bf;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzg com_google_android_gms_appdatasearch_zzg = CREATOR;
            zzg.zza(this, parcel, i);
        }
    }
}
