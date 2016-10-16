package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public class DocumentSection extends AbstractSafeParcelable {
    public static final zzd CREATOR;
    public static final int aT;
    private static final RegisterSectionInfo aU;
    public final String aV;
    final RegisterSectionInfo aW;
    public final int aX;
    public final byte[] aY;
    final int mVersionCode;

    static {
        aT = Integer.parseInt("-1");
        CREATOR = new zzd();
        aU = new zza("SsbContext").zzav(true).zzfh("blob").zzaeq();
    }

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        boolean z = i2 == aT || zzh.zzce(i2) != null;
        zzab.zzb(z, "Invalid section type " + i2);
        this.mVersionCode = i;
        this.aV = str;
        this.aW = registerSectionInfo;
        this.aX = i2;
        this.aY = bArr;
        String zzaeo = zzaeo();
        if (zzaeo != null) {
            throw new IllegalArgumentException(zzaeo);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, aT, null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.zzfg(str2), null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, null, registerSectionInfo, aT, bArr);
    }

    public static DocumentSection zzk(byte[] bArr) {
        return new DocumentSection(bArr, aU);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public String zzaeo() {
        if (this.aX == aT || zzh.zzce(this.aX) != null) {
            return (this.aV == null || this.aY == null) ? null : "Both content and blobContent set";
        } else {
            return "Invalid section type " + this.aX;
        }
    }
}
