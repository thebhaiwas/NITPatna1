package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo extends AbstractSafeParcelable {
    public static final zzi CREATOR;
    public final String bk;
    public final boolean bl;
    public final boolean bm;
    public final String bn;
    public final Feature[] bo;
    final int[] bp;
    public final String bq;
    final int mVersionCode;
    public final String name;
    public final int weight;

    public static final class zza {
        private String br;
        private boolean bs;
        private int bt;
        private boolean bu;
        private final List<Feature> bv;
        private BitSet bw;
        private String bx;
        private final String mName;

        public zza(String str) {
            this.mName = str;
            this.bt = 1;
            this.bv = new ArrayList();
        }

        public RegisterSectionInfo zzaeq() {
            int[] iArr;
            int i = 0;
            if (this.bw != null) {
                iArr = new int[this.bw.cardinality()];
                int nextSetBit = this.bw.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.bw.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            } else {
                iArr = null;
            }
            return new RegisterSectionInfo(this.mName, this.br, this.bs, this.bt, this.bu, null, (Feature[]) this.bv.toArray(new Feature[this.bv.size()]), iArr, this.bx);
        }

        public zza zzav(boolean z) {
            this.bs = z;
            return this;
        }

        public zza zzaw(boolean z) {
            this.bu = z;
            return this;
        }

        public zza zzcf(int i) {
            if (this.bw == null) {
                this.bw = new BitSet();
            }
            this.bw.set(i);
            return this;
        }

        public zza zzfh(String str) {
            this.br = str;
            return this;
        }

        public zza zzfi(String str) {
            this.bx = str;
            return this;
        }
    }

    static {
        CREATOR = new zzi();
    }

    RegisterSectionInfo(int i, String str, String str2, boolean z, int i2, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this.mVersionCode = i;
        this.name = str;
        this.bk = str2;
        this.bl = z;
        this.weight = i2;
        this.bm = z2;
        this.bn = str3;
        this.bo = featureArr;
        this.bp = iArr;
        this.bq = str4;
    }

    RegisterSectionInfo(String str, String str2, boolean z, int i, boolean z2, String str3, Feature[] featureArr, int[] iArr, String str4) {
        this(2, str, str2, z, i, z2, str3, featureArr, iArr, str4);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi com_google_android_gms_appdatasearch_zzi = CREATOR;
        zzi.zza(this, parcel, i);
    }
}
