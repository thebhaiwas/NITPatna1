package com.google.android.gms.internal;

import java.io.IOException;

public final class zzapf {
    public static final int[] bim;
    public static final long[] bin;
    public static final float[] bio;
    public static final double[] bip;
    public static final boolean[] biq;
    public static final String[] bir;
    public static final byte[][] bis;
    public static final byte[] bit;

    static {
        bim = new int[0];
        bin = new long[0];
        bio = new float[0];
        bip = new double[0];
        biq = new boolean[0];
        bir = new String[0];
        bis = new byte[0][];
        bit = new byte[0];
    }

    static int zzaez(int i) {
        return i & 7;
    }

    public static int zzafa(int i) {
        return i >>> 3;
    }

    public static int zzaj(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzaou com_google_android_gms_internal_zzaou, int i) throws IOException {
        return com_google_android_gms_internal_zzaou.zzaeg(i);
    }

    public static final int zzc(zzaou com_google_android_gms_internal_zzaou, int i) throws IOException {
        int i2 = 1;
        int position = com_google_android_gms_internal_zzaou.getPosition();
        com_google_android_gms_internal_zzaou.zzaeg(i);
        while (com_google_android_gms_internal_zzaou.m42J() == i) {
            com_google_android_gms_internal_zzaou.zzaeg(i);
            i2++;
        }
        com_google_android_gms_internal_zzaou.zzaek(position);
        return i2;
    }
}
