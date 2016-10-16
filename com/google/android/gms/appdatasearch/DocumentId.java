package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DocumentId extends AbstractSafeParcelable {
    public static final zzc CREATOR;
    final String aQ;
    final String aR;
    final String aS;
    final int mVersionCode;

    static {
        CREATOR = new zzc();
    }

    DocumentId(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aQ = str;
        this.aR = str2;
        this.aS = str3;
    }

    public DocumentId(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.aQ, this.aR, this.aS});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }
}
