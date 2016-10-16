package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ActionImpl extends AbstractSafeParcelable {
    public static final Creator<ActionImpl> CREATOR;
    private final String aMY;
    private final String aMZ;
    private final String aNa;
    private final String aNb;
    private final MetadataImpl aNc;
    private final String aNd;
    public final int mVersionCode;

    public static class MetadataImpl extends AbstractSafeParcelable {
        public static final Creator<MetadataImpl> CREATOR;
        private final boolean aNe;
        private final String aNf;
        private final byte[] aNg;
        private final boolean aNh;
        private int bE;
        private final String cf;
        public final int mVersionCode;

        static {
            CREATOR = new zzb();
        }

        MetadataImpl(int i, int i2, boolean z, String str, String str2, byte[] bArr, boolean z2) {
            this.bE = 0;
            this.mVersionCode = i;
            this.bE = i2;
            this.aNe = z;
            this.aNf = str;
            this.cf = str2;
            this.aNg = bArr;
            this.aNh = z2;
        }

        public String getAccountName() {
            return this.cf;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MetadataImpl { ");
            stringBuilder.append("{ eventStatus: '").append(this.bE).append("' } ");
            stringBuilder.append("{ uploadable: '").append(this.aNe).append("' } ");
            if (this.aNf != null) {
                stringBuilder.append("{ completionToken: '").append(this.aNf).append("' } ");
            }
            if (this.cf != null) {
                stringBuilder.append("{ accountName: '").append(this.cf).append("' } ");
            }
            if (this.aNg != null) {
                stringBuilder.append("{ ssbContext: [ ");
                for (byte toHexString : this.aNg) {
                    stringBuilder.append("0x").append(Integer.toHexString(toHexString)).append(" ");
                }
                stringBuilder.append("] } ");
            }
            stringBuilder.append("{ contextOnly: '").append(this.aNh).append("' } ");
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb.zza(this, parcel, i);
        }

        public int zzckk() {
            return this.bE;
        }

        public boolean zzckl() {
            return this.aNe;
        }

        public String zzckm() {
            return this.aNf;
        }

        public byte[] zzckn() {
            return this.aNg;
        }

        public boolean zzcko() {
            return this.aNh;
        }
    }

    static {
        CREATOR = new zza();
    }

    ActionImpl(int i, String str, String str2, String str3, String str4, MetadataImpl metadataImpl, String str5) {
        this.mVersionCode = i;
        this.aMY = str;
        this.aMZ = str2;
        this.aNa = str3;
        this.aNb = str4;
        this.aNc = metadataImpl;
        this.aNd = str5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionImpl { ");
        stringBuilder.append("{ actionType: '").append(this.aMY).append("' } ");
        stringBuilder.append("{ objectName: '").append(this.aMZ).append("' } ");
        stringBuilder.append("{ objectUrl: '").append(this.aNa).append("' } ");
        if (this.aNb != null) {
            stringBuilder.append("{ objectSameAs: '").append(this.aNb).append("' } ");
        }
        if (this.aNc != null) {
            stringBuilder.append("{ metadata: '").append(this.aNc.toString()).append("' } ");
        }
        if (this.aNd != null) {
            stringBuilder.append("{ actionStatus: '").append(this.aNd).append("' } ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzcke() {
        return this.aMY;
    }

    public String zzckf() {
        return this.aMZ;
    }

    public String zzckg() {
        return this.aNa;
    }

    public String zzckh() {
        return this.aNb;
    }

    public MetadataImpl zzcki() {
        return this.aNc;
    }

    public String zzckj() {
        return this.aNd;
    }
}
