package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzuo {

    public static final class zza extends zzapc {
        private static volatile zza[] aow;
        public Boolean aox;
        public Boolean aoy;
        public String name;

        public zza() {
            zzbwk();
        }

        public static zza[] zzbwj() {
            if (aow == null) {
                synchronized (zzapa.bij) {
                    if (aow == null) {
                        aow = new zza[0];
                    }
                }
            }
            return aow;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzuo_zza = (zza) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzuo_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzuo_zza.name)) {
                return false;
            }
            if (this.aox == null) {
                if (com_google_android_gms_internal_zzuo_zza.aox != null) {
                    return false;
                }
            } else if (!this.aox.equals(com_google_android_gms_internal_zzuo_zza.aox)) {
                return false;
            }
            return this.aoy == null ? com_google_android_gms_internal_zzuo_zza.aoy == null : this.aoy.equals(com_google_android_gms_internal_zzuo_zza.aoy);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aox == null ? 0 : this.aox.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.aoy != null) {
                i = this.aoy.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.name != null) {
                com_google_android_gms_internal_zzaov.zzr(1, this.name);
            }
            if (this.aox != null) {
                com_google_android_gms_internal_zzaov.zzj(2, this.aox.booleanValue());
            }
            if (this.aoy != null) {
                com_google_android_gms_internal_zzaov.zzj(3, this.aoy.booleanValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbj(com_google_android_gms_internal_zzaou);
        }

        public zza zzbj(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.aox = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.aoy = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    default:
                        if (!zzapf.zzb(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzbwk() {
            this.name = null;
            this.aox = null;
            this.aoy = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.aox != null) {
                zzy += zzaov.zzk(2, this.aox.booleanValue());
            }
            return this.aoy != null ? zzy + zzaov.zzk(3, this.aoy.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzapc {
        public String ajz;
        public Integer aoA;
        public zzc[] aoB;
        public zza[] aoC;
        public com.google.android.gms.internal.zzun.zza[] aoD;
        public Long aoz;

        public zzb() {
            zzbwl();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzuo_zzb = (zzb) obj;
            if (this.aoz == null) {
                if (com_google_android_gms_internal_zzuo_zzb.aoz != null) {
                    return false;
                }
            } else if (!this.aoz.equals(com_google_android_gms_internal_zzuo_zzb.aoz)) {
                return false;
            }
            if (this.ajz == null) {
                if (com_google_android_gms_internal_zzuo_zzb.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(com_google_android_gms_internal_zzuo_zzb.ajz)) {
                return false;
            }
            if (this.aoA == null) {
                if (com_google_android_gms_internal_zzuo_zzb.aoA != null) {
                    return false;
                }
            } else if (!this.aoA.equals(com_google_android_gms_internal_zzuo_zzb.aoA)) {
                return false;
            }
            return !zzapa.equals(this.aoB, com_google_android_gms_internal_zzuo_zzb.aoB) ? false : !zzapa.equals(this.aoC, com_google_android_gms_internal_zzuo_zzb.aoC) ? false : zzapa.equals(this.aoD, com_google_android_gms_internal_zzuo_zzb.aoD);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.aoz == null ? 0 : this.aoz.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.aoA != null) {
                i = this.aoA.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzapa.hashCode(this.aoB)) * 31) + zzapa.hashCode(this.aoC)) * 31) + zzapa.hashCode(this.aoD);
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.aoz != null) {
                com_google_android_gms_internal_zzaov.zzb(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.ajz);
            }
            if (this.aoA != null) {
                com_google_android_gms_internal_zzaov.zzae(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoB) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(4, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.aoC != null && this.aoC.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2 : this.aoC) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        com_google_android_gms_internal_zzaov.zza(5, com_google_android_gms_internal_zzapc2);
                    }
                }
            }
            if (this.aoD != null && this.aoD.length > 0) {
                while (i < this.aoD.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.aoD[i];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        com_google_android_gms_internal_zzaov.zza(6, com_google_android_gms_internal_zzapc3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbk(com_google_android_gms_internal_zzaou);
        }

        public zzb zzbk(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.aoz = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.ajz = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.aoA = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 34);
                        J = this.aoB == null ? 0 : this.aoB.length;
                        obj = new zzc[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoB, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzc();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzc();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoB = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 42);
                        J = this.aoC == null ? 0 : this.aoC.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoC, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoC = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarStyle /*50*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 50);
                        J = this.aoD == null ? 0 : this.aoD.length;
                        obj = new com.google.android.gms.internal.zzun.zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoD, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new com.google.android.gms.internal.zzun.zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new com.google.android.gms.internal.zzun.zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoD = obj;
                        continue;
                    default:
                        if (!zzapf.zzb(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzbwl() {
            this.aoz = null;
            this.ajz = null;
            this.aoA = null;
            this.aoB = zzc.zzbwm();
            this.aoC = zza.zzbwj();
            this.aoD = com.google.android.gms.internal.zzun.zza.zzbvz();
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int i;
            int i2 = 0;
            int zzy = super.zzy();
            if (this.aoz != null) {
                zzy += zzaov.zze(1, this.aoz.longValue());
            }
            if (this.ajz != null) {
                zzy += zzaov.zzs(2, this.ajz);
            }
            if (this.aoA != null) {
                zzy += zzaov.zzag(3, this.aoA.intValue());
            }
            if (this.aoB != null && this.aoB.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc : this.aoB) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i += zzaov.zzc(4, com_google_android_gms_internal_zzapc);
                    }
                }
                zzy = i;
            }
            if (this.aoC != null && this.aoC.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc2 : this.aoC) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        i += zzaov.zzc(5, com_google_android_gms_internal_zzapc2);
                    }
                }
                zzy = i;
            }
            if (this.aoD != null && this.aoD.length > 0) {
                while (i2 < this.aoD.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.aoD[i2];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        zzy += zzaov.zzc(6, com_google_android_gms_internal_zzapc3);
                    }
                    i2++;
                }
            }
            return zzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoE;
        public String value;
        public String zzcb;

        public zzc() {
            zzbwn();
        }

        public static zzc[] zzbwm() {
            if (aoE == null) {
                synchronized (zzapa.bij) {
                    if (aoE == null) {
                        aoE = new zzc[0];
                    }
                }
            }
            return aoE;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzuo_zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (com_google_android_gms_internal_zzuo_zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(com_google_android_gms_internal_zzuo_zzc.zzcb)) {
                return false;
            }
            return this.value == null ? com_google_android_gms_internal_zzuo_zzc.value == null : this.value.equals(com_google_android_gms_internal_zzuo_zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzcb != null) {
                com_google_android_gms_internal_zzaov.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.value);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbl(com_google_android_gms_internal_zzaou);
        }

        public zzc zzbl(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzcb = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.value = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    default:
                        if (!zzapf.zzb(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzc zzbwn() {
            this.zzcb = null;
            this.value = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.zzcb != null) {
                zzy += zzaov.zzs(1, this.zzcb);
            }
            return this.value != null ? zzy + zzaov.zzs(2, this.value) : zzy;
        }
    }
}
