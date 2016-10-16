package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzaoz implements Cloneable {
    private Object aQx;
    private zzaox<?, ?> bih;
    private List<zzape> bii;

    zzaoz() {
        this.bii = new ArrayList();
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        zza(zzaov.zzba(bArr));
        return bArr;
    }

    public final zzaoz af() {
        zzaoz com_google_android_gms_internal_zzaoz = new zzaoz();
        try {
            com_google_android_gms_internal_zzaoz.bih = this.bih;
            if (this.bii == null) {
                com_google_android_gms_internal_zzaoz.bii = null;
            } else {
                com_google_android_gms_internal_zzaoz.bii.addAll(this.bii);
            }
            if (this.aQx != null) {
                if (this.aQx instanceof zzapc) {
                    com_google_android_gms_internal_zzaoz.aQx = (zzapc) ((zzapc) this.aQx).clone();
                } else if (this.aQx instanceof byte[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((byte[]) this.aQx).clone();
                } else if (this.aQx instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.aQx;
                    r4 = new byte[bArr.length][];
                    com_google_android_gms_internal_zzaoz.aQx = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.aQx instanceof boolean[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((boolean[]) this.aQx).clone();
                } else if (this.aQx instanceof int[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((int[]) this.aQx).clone();
                } else if (this.aQx instanceof long[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((long[]) this.aQx).clone();
                } else if (this.aQx instanceof float[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((float[]) this.aQx).clone();
                } else if (this.aQx instanceof double[]) {
                    com_google_android_gms_internal_zzaoz.aQx = ((double[]) this.aQx).clone();
                } else if (this.aQx instanceof zzapc[]) {
                    zzapc[] com_google_android_gms_internal_zzapcArr = (zzapc[]) this.aQx;
                    r4 = new zzapc[com_google_android_gms_internal_zzapcArr.length];
                    com_google_android_gms_internal_zzaoz.aQx = r4;
                    for (r2 = 0; r2 < com_google_android_gms_internal_zzapcArr.length; r2++) {
                        r4[r2] = (zzapc) com_google_android_gms_internal_zzapcArr[r2].clone();
                    }
                }
            }
            return com_google_android_gms_internal_zzaoz;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return af();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaoz)) {
            return false;
        }
        zzaoz com_google_android_gms_internal_zzaoz = (zzaoz) obj;
        if (this.aQx != null && com_google_android_gms_internal_zzaoz.aQx != null) {
            return this.bih == com_google_android_gms_internal_zzaoz.bih ? !this.bih.bau.isArray() ? this.aQx.equals(com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof byte[] ? Arrays.equals((byte[]) this.aQx, (byte[]) com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof int[] ? Arrays.equals((int[]) this.aQx, (int[]) com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof long[] ? Arrays.equals((long[]) this.aQx, (long[]) com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof float[] ? Arrays.equals((float[]) this.aQx, (float[]) com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof double[] ? Arrays.equals((double[]) this.aQx, (double[]) com_google_android_gms_internal_zzaoz.aQx) : this.aQx instanceof boolean[] ? Arrays.equals((boolean[]) this.aQx, (boolean[]) com_google_android_gms_internal_zzaoz.aQx) : Arrays.deepEquals((Object[]) this.aQx, (Object[]) com_google_android_gms_internal_zzaoz.aQx) : false;
        } else {
            if (this.bii != null && com_google_android_gms_internal_zzaoz.bii != null) {
                return this.bii.equals(com_google_android_gms_internal_zzaoz.bii);
            }
            try {
                return Arrays.equals(toByteArray(), com_google_android_gms_internal_zzaoz.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
        if (this.aQx != null) {
            this.bih.zza(this.aQx, com_google_android_gms_internal_zzaov);
            return;
        }
        for (zzape zza : this.bii) {
            zza.zza(com_google_android_gms_internal_zzaov);
        }
    }

    void zza(zzape com_google_android_gms_internal_zzape) {
        this.bii.add(com_google_android_gms_internal_zzape);
    }

    <T> T zzb(zzaox<?, T> com_google_android_gms_internal_zzaox___T) {
        if (this.aQx == null) {
            this.bih = com_google_android_gms_internal_zzaox___T;
            this.aQx = com_google_android_gms_internal_zzaox___T.zzav(this.bii);
            this.bii = null;
        } else if (!this.bih.equals(com_google_android_gms_internal_zzaox___T)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.aQx;
    }

    int zzy() {
        if (this.aQx != null) {
            return this.bih.zzcr(this.aQx);
        }
        int i = 0;
        for (zzape zzy : this.bii) {
            i = zzy.zzy() + i;
        }
        return i;
    }
}
