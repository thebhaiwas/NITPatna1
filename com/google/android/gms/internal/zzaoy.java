package com.google.android.gms.internal;

public final class zzaoy implements Cloneable {
    private static final zzaoz bid;
    private boolean bie;
    private int[] bif;
    private zzaoz[] big;
    private int mSize;

    static {
        bid = new zzaoz();
    }

    zzaoy() {
        this(10);
    }

    zzaoy(int i) {
        this.bie = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.bif = new int[idealIntArraySize];
        this.big = new zzaoz[idealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzaoz[] com_google_android_gms_internal_zzaozArr, zzaoz[] com_google_android_gms_internal_zzaozArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_google_android_gms_internal_zzaozArr[i2].equals(com_google_android_gms_internal_zzaozArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzaey(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bif[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final zzaoy ae() {
        int size = size();
        zzaoy com_google_android_gms_internal_zzaoy = new zzaoy(size);
        System.arraycopy(this.bif, 0, com_google_android_gms_internal_zzaoy.bif, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.big[i] != null) {
                com_google_android_gms_internal_zzaoy.big[i] = (zzaoz) this.big[i].clone();
            }
        }
        com_google_android_gms_internal_zzaoy.mSize = size;
        return com_google_android_gms_internal_zzaoy;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return ae();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoy)) {
            return false;
        }
        zzaoy com_google_android_gms_internal_zzaoy = (zzaoy) obj;
        return size() != com_google_android_gms_internal_zzaoy.size() ? false : zza(this.bif, com_google_android_gms_internal_zzaoy.bif, this.mSize) && zza(this.big, com_google_android_gms_internal_zzaoy.big, this.mSize);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.bif[i2]) * 31) + this.big[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        return this.mSize;
    }

    void zza(int i, zzaoz com_google_android_gms_internal_zzaoz) {
        int zzaey = zzaey(i);
        if (zzaey >= 0) {
            this.big[zzaey] = com_google_android_gms_internal_zzaoz;
            return;
        }
        zzaey ^= -1;
        if (zzaey >= this.mSize || this.big[zzaey] != bid) {
            if (this.mSize >= this.bif.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzaoz[idealIntArraySize];
                System.arraycopy(this.bif, 0, obj, 0, this.bif.length);
                System.arraycopy(this.big, 0, obj2, 0, this.big.length);
                this.bif = obj;
                this.big = obj2;
            }
            if (this.mSize - zzaey != 0) {
                System.arraycopy(this.bif, zzaey, this.bif, zzaey + 1, this.mSize - zzaey);
                System.arraycopy(this.big, zzaey, this.big, zzaey + 1, this.mSize - zzaey);
            }
            this.bif[zzaey] = i;
            this.big[zzaey] = com_google_android_gms_internal_zzaoz;
            this.mSize++;
            return;
        }
        this.bif[zzaey] = i;
        this.big[zzaey] = com_google_android_gms_internal_zzaoz;
    }

    zzaoz zzaew(int i) {
        int zzaey = zzaey(i);
        return (zzaey < 0 || this.big[zzaey] == bid) ? null : this.big[zzaey];
    }

    zzaoz zzaex(int i) {
        return this.big[i];
    }
}
