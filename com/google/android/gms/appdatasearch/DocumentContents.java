package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class DocumentContents extends AbstractSafeParcelable {
    public static final zzb CREATOR;
    final DocumentSection[] aJ;
    public final String aK;
    public final boolean aL;
    public final Account account;
    final int mVersionCode;

    public static class zza {
        private List<DocumentSection> aM;
        private String aN;
        private boolean aO;
        private Account aP;

        public zza zza(DocumentSection documentSection) {
            if (this.aM == null && documentSection != null) {
                this.aM = new ArrayList();
            }
            if (documentSection != null) {
                this.aM.add(documentSection);
            }
            return this;
        }

        public DocumentContents zzaen() {
            return new DocumentContents(this.aN, this.aO, this.aP, this.aM != null ? (DocumentSection[]) this.aM.toArray(new DocumentSection[this.aM.size()]) : null);
        }

        public zza zzau(boolean z) {
            this.aO = z;
            return this;
        }

        public zza zzb(Account account) {
            this.aP = account;
            return this;
        }

        public zza zzff(String str) {
            this.aN = str;
            return this;
        }
    }

    static {
        CREATOR = new zzb();
    }

    DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account) {
        this.mVersionCode = i;
        this.aJ = documentSectionArr;
        this.aK = str;
        this.aL = z;
        this.account = account;
    }

    DocumentContents(String str, boolean z, Account account, DocumentSection... documentSectionArr) {
        this(1, documentSectionArr, str, z, account);
        if (documentSectionArr != null) {
            BitSet bitSet = new BitSet(zzh.zzaep());
            for (DocumentSection documentSection : documentSectionArr) {
                int i = documentSection.aX;
                if (i != -1) {
                    if (bitSet.get(i)) {
                        String str2 = "Duplicate global search section type ";
                        String valueOf = String.valueOf(zzh.zzce(i));
                        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    }
                    bitSet.set(i);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DocumentContents)) {
            return false;
        }
        DocumentContents documentContents = (DocumentContents) obj;
        return zzaa.equal(this.aK, documentContents.aK) && zzaa.equal(Boolean.valueOf(this.aL), Boolean.valueOf(documentContents.aL)) && zzaa.equal(this.account, documentContents.account) && Arrays.equals(zzaem(), documentContents.zzaem());
    }

    public int hashCode() {
        return zzaa.hashCode(this.aK, Boolean.valueOf(this.aL), this.account, Integer.valueOf(Arrays.hashCode(this.aJ)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb com_google_android_gms_appdatasearch_zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public DocumentSection[] zzaem() {
        return this.aJ;
    }
}
