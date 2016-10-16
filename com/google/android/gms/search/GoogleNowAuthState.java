package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GoogleNowAuthState extends AbstractSafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR;
    String atW;
    String atX;
    long atY;
    final int mVersionCode;

    static {
        CREATOR = new zza();
    }

    GoogleNowAuthState(int i, String str, String str2, long j) {
        this.mVersionCode = i;
        this.atW = str;
        this.atX = str2;
        this.atY = j;
    }

    public String getAccessToken() {
        return this.atX;
    }

    public String getAuthCode() {
        return this.atW;
    }

    public long getNextAllowedTimeMillis() {
        return this.atY;
    }

    public String toString() {
        String str = this.atW;
        String str2 = this.atX;
        return new StringBuilder((String.valueOf(str).length() + 74) + String.valueOf(str2).length()).append("mAuthCode = ").append(str).append("\nmAccessToken = ").append(str2).append("\nmNextAllowedTimeMillis = ").append(this.atY).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
