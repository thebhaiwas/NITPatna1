package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;

public final class zzaou {
    private int bhR;
    private int bhS;
    private int bhT;
    private int bhU;
    private int bhV;
    private int bhW;
    private int bhX;
    private int bhY;
    private int bhZ;
    private final byte[] buffer;

    private zzaou(byte[] bArr, int i, int i2) {
        this.bhW = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.bhY = 64;
        this.bhZ = 67108864;
        this.buffer = bArr;
        this.bhR = i;
        this.bhS = i + i2;
        this.bhU = i;
    }

    private void m41W() {
        this.bhS += this.bhT;
        int i = this.bhS;
        if (i > this.bhW) {
            this.bhT = i - this.bhW;
            this.bhS -= this.bhT;
            return;
        }
        this.bhT = 0;
    }

    public static int zzaeh(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static zzaou zzaz(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzaou zzb(byte[] bArr, int i, int i2) {
        return new zzaou(bArr, i, i2);
    }

    public static long zzcq(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public int m42J() throws IOException {
        if (m56Y()) {
            this.bhV = 0;
            return 0;
        }
        this.bhV = m51S();
        if (this.bhV != 0) {
            return this.bhV;
        }
        throw zzapb.aj();
    }

    public void m43K() throws IOException {
        int J;
        do {
            J = m42J();
            if (J == 0) {
                return;
            }
        } while (zzaeg(J));
    }

    public long m44L() throws IOException {
        return m52T();
    }

    public long m45M() throws IOException {
        return m52T();
    }

    public int m46N() throws IOException {
        return m51S();
    }

    public long m47O() throws IOException {
        return m54V();
    }

    public boolean m48P() throws IOException {
        return m51S() != 0;
    }

    public int m49Q() throws IOException {
        return zzaeh(m51S());
    }

    public long m50R() throws IOException {
        return zzcq(m52T());
    }

    public int m51S() throws IOException {
        byte Z = m57Z();
        if (Z >= null) {
            return Z;
        }
        int i = Z & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte Z2 = m57Z();
        if (Z2 >= null) {
            return i | (Z2 << 7);
        }
        i |= (Z2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        Z2 = m57Z();
        if (Z2 >= null) {
            return i | (Z2 << 14);
        }
        i |= (Z2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        Z2 = m57Z();
        if (Z2 >= null) {
            return i | (Z2 << 21);
        }
        i |= (Z2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        Z2 = m57Z();
        i |= Z2 << 28;
        if (Z2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m57Z() >= null) {
                return i;
            }
        }
        throw zzapb.ai();
    }

    public long m52T() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte Z = m57Z();
            j |= ((long) (Z & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((Z & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
                return j;
            }
        }
        throw zzapb.ai();
    }

    public int m53U() throws IOException {
        return (((m57Z() & MotionEventCompat.ACTION_MASK) | ((m57Z() & MotionEventCompat.ACTION_MASK) << 8)) | ((m57Z() & MotionEventCompat.ACTION_MASK) << 16)) | ((m57Z() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long m54V() throws IOException {
        byte Z = m57Z();
        byte Z2 = m57Z();
        return ((((((((((long) Z2) & 255) << 8) | (((long) Z) & 255)) | ((((long) m57Z()) & 255) << 16)) | ((((long) m57Z()) & 255) << 24)) | ((((long) m57Z()) & 255) << 32)) | ((((long) m57Z()) & 255) << 40)) | ((((long) m57Z()) & 255) << 48)) | ((((long) m57Z()) & 255) << 56);
    }

    public int m55X() {
        if (this.bhW == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.bhW - this.bhU;
    }

    public boolean m56Y() {
        return this.bhU == this.bhS;
    }

    public byte m57Z() throws IOException {
        if (this.bhU == this.bhS) {
            throw zzapb.ag();
        }
        byte[] bArr = this.buffer;
        int i = this.bhU;
        this.bhU = i + 1;
        return bArr[i];
    }

    public int getPosition() {
        return this.bhU - this.bhR;
    }

    public byte[] readBytes() throws IOException {
        int S = m51S();
        if (S < 0) {
            throw zzapb.ah();
        } else if (S == 0) {
            return zzapf.bit;
        } else {
            if (S > this.bhS - this.bhU) {
                throw zzapb.ag();
            }
            Object obj = new byte[S];
            System.arraycopy(this.buffer, this.bhU, obj, 0, S);
            this.bhU = S + this.bhU;
            return obj;
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(m54V());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(m53U());
    }

    public String readString() throws IOException {
        int S = m51S();
        if (S < 0) {
            throw zzapb.ah();
        } else if (S > this.bhS - this.bhU) {
            throw zzapb.ag();
        } else {
            String str = new String(this.buffer, this.bhU, S, zzapa.UTF_8);
            this.bhU = S + this.bhU;
            return str;
        }
    }

    public void zza(zzapc com_google_android_gms_internal_zzapc) throws IOException {
        int S = m51S();
        if (this.bhX >= this.bhY) {
            throw zzapb.am();
        }
        S = zzaei(S);
        this.bhX++;
        com_google_android_gms_internal_zzapc.zzb(this);
        zzaef(0);
        this.bhX--;
        zzaej(S);
    }

    public void zza(zzapc com_google_android_gms_internal_zzapc, int i) throws IOException {
        if (this.bhX >= this.bhY) {
            throw zzapb.am();
        }
        this.bhX++;
        com_google_android_gms_internal_zzapc.zzb(this);
        zzaef(zzapf.zzaj(i, 4));
        this.bhX--;
    }

    public byte[] zzad(int i, int i2) {
        if (i2 == 0) {
            return zzapf.bit;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.bhR + i, obj, 0, i2);
        return obj;
    }

    public void zzaef(int i) throws zzapb {
        if (this.bhV != i) {
            throw zzapb.ak();
        }
    }

    public boolean zzaeg(int i) throws IOException {
        switch (zzapf.zzaez(i)) {
            case ConnectionResult.SUCCESS /*0*/:
                m46N();
                return true;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                m54V();
                return true;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                zzael(m51S());
                return true;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                m43K();
                zzaef(zzapf.zzaj(zzapf.zzafa(i), 4));
                return true;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return false;
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                m53U();
                return true;
            default:
                throw zzapb.al();
        }
    }

    public int zzaei(int i) throws zzapb {
        if (i < 0) {
            throw zzapb.ah();
        }
        int i2 = this.bhU + i;
        int i3 = this.bhW;
        if (i2 > i3) {
            throw zzapb.ag();
        }
        this.bhW = i2;
        m41W();
        return i3;
    }

    public void zzaej(int i) {
        this.bhW = i;
        m41W();
    }

    public void zzaek(int i) {
        if (i > this.bhU - this.bhR) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bhU - this.bhR));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bhU = this.bhR + i;
        }
    }

    public void zzael(int i) throws IOException {
        if (i < 0) {
            throw zzapb.ah();
        } else if (this.bhU + i > this.bhW) {
            zzael(this.bhW - this.bhU);
            throw zzapb.ag();
        } else if (i <= this.bhS - this.bhU) {
            this.bhU += i;
        } else {
            throw zzapb.ag();
        }
    }
}
