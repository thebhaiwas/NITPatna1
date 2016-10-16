package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.BuildConfig;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzuj {

    public static final class zza extends zzaow<zza> {
        public zza[] abn;

        public static final class zza extends zzaow<zza> {
            private static volatile zza[] abo;
            public String abp;
            public String abq;
            public int viewId;

            public zza() {
                zzbml();
            }

            public static zza[] zzbmk() {
                if (abo == null) {
                    synchronized (zzapa.bij) {
                        if (abo == null) {
                            abo = new zza[0];
                        }
                    }
                }
                return abo;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzuj_zza_zza = (zza) obj;
                if (this.abp == null) {
                    if (com_google_android_gms_internal_zzuj_zza_zza.abp != null) {
                        return false;
                    }
                } else if (!this.abp.equals(com_google_android_gms_internal_zzuj_zza_zza.abp)) {
                    return false;
                }
                if (this.abq == null) {
                    if (com_google_android_gms_internal_zzuj_zza_zza.abq != null) {
                        return false;
                    }
                } else if (!this.abq.equals(com_google_android_gms_internal_zzuj_zza_zza.abq)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zzuj_zza_zza.viewId ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzuj_zza_zza.bib == null || com_google_android_gms_internal_zzuj_zza_zza.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzuj_zza_zza.bib) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.abq == null ? 0 : this.abq.hashCode()) + (((this.abp == null ? 0 : this.abp.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (!(this.bib == null || this.bib.isEmpty())) {
                    i = this.bib.hashCode();
                }
                return hashCode + i;
            }

            public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
                if (!this.abp.equals(BuildConfig.FLAVOR)) {
                    com_google_android_gms_internal_zzaov.zzr(1, this.abp);
                }
                if (!this.abq.equals(BuildConfig.FLAVOR)) {
                    com_google_android_gms_internal_zzaov.zzr(2, this.abq);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzaov.zzae(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzaov);
            }

            public zza zzaz(zzaou com_google_android_gms_internal_zzaou) throws IOException {
                while (true) {
                    int J = com_google_android_gms_internal_zzaou.m42J();
                    switch (J) {
                        case ConnectionResult.SUCCESS /*0*/:
                            break;
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                            this.abp = com_google_android_gms_internal_zzaou.readString();
                            continue;
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            this.abq = com_google_android_gms_internal_zzaou.readString();
                            continue;
                        case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                            this.viewId = com_google_android_gms_internal_zzaou.m46N();
                            continue;
                        default:
                            if (!super.zza(com_google_android_gms_internal_zzaou, J)) {
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
                return zzaz(com_google_android_gms_internal_zzaou);
            }

            public zza zzbml() {
                this.abp = BuildConfig.FLAVOR;
                this.abq = BuildConfig.FLAVOR;
                this.viewId = 0;
                this.bib = null;
                this.bik = -1;
                return this;
            }

            protected int zzy() {
                int zzy = super.zzy();
                if (!this.abp.equals(BuildConfig.FLAVOR)) {
                    zzy += zzaov.zzs(1, this.abp);
                }
                if (!this.abq.equals(BuildConfig.FLAVOR)) {
                    zzy += zzaov.zzs(2, this.abq);
                }
                return this.viewId != 0 ? zzy + zzaov.zzag(3, this.viewId) : zzy;
            }
        }

        public zza() {
            zzbmj();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzuj_zza = (zza) obj;
            return zzapa.equals(this.abn, com_google_android_gms_internal_zzuj_zza.abn) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzuj_zza.bib == null || com_google_android_gms_internal_zzuj_zza.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzuj_zza.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.abn)) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.abn != null && this.abn.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.abn) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zza zzay(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.abn == null ? 0 : this.abn.length;
                        Object obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.abn, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.abn = obj;
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzay(com_google_android_gms_internal_zzaou);
        }

        public zza zzbmj() {
            this.abn = zza.zzbmk();
            this.bib = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.abn != null && this.abn.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.abn) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        zzy += zzaov.zzc(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        private static volatile zzb[] abr;
        public zzd abs;
        public String name;

        public zzb() {
            zzbmn();
        }

        public static zzb[] zzbmm() {
            if (abr == null) {
                synchronized (zzapa.bij) {
                    if (abr == null) {
                        abr = new zzb[0];
                    }
                }
            }
            return abr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzuj_zzb = (zzb) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzuj_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzuj_zzb.name)) {
                return false;
            }
            if (this.abs == null) {
                if (com_google_android_gms_internal_zzuj_zzb.abs != null) {
                    return false;
                }
            } else if (!this.abs.equals(com_google_android_gms_internal_zzuj_zzb.abs)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzuj_zzb.bib == null || com_google_android_gms_internal_zzuj_zzb.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzuj_zzb.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.abs == null ? 0 : this.abs.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(1, this.name);
            }
            if (this.abs != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.abs);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzba(com_google_android_gms_internal_zzaou);
        }

        public zzb zzba(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.abs == null) {
                            this.abs = new zzd();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.abs);
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzbmn() {
            this.name = BuildConfig.FLAVOR;
            this.abs = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(1, this.name);
            }
            return this.abs != null ? zzy + zzaov.zzc(2, this.abs) : zzy;
        }
    }

    public static final class zzc extends zzaow<zzc> {
        public zzb[] abt;
        public String type;

        public zzc() {
            zzbmo();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzuj_zzc = (zzc) obj;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzuj_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzuj_zzc.type)) {
                return false;
            }
            return zzapa.equals(this.abt, com_google_android_gms_internal_zzuj_zzc.abt) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzuj_zzc.bib == null || com_google_android_gms_internal_zzuj_zzc.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzuj_zzc.bib) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapa.hashCode(this.abt)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (!this.type.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(1, this.type);
            }
            if (this.abt != null && this.abt.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.abt) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(2, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbb(com_google_android_gms_internal_zzaou);
        }

        public zzc zzbb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.type = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 18);
                        J = this.abt == null ? 0 : this.abt.length;
                        Object obj = new zzb[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.abt, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzb();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzb();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.abt = obj;
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzc zzbmo() {
            this.type = BuildConfig.FLAVOR;
            this.abt = zzb.zzbmm();
            this.bib = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (!this.type.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(1, this.type);
            }
            if (this.abt == null || this.abt.length <= 0) {
                return zzy;
            }
            int i = zzy;
            for (zzapc com_google_android_gms_internal_zzapc : this.abt) {
                if (com_google_android_gms_internal_zzapc != null) {
                    i += zzaov.zzc(2, com_google_android_gms_internal_zzapc);
                }
            }
            return i;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public boolean abu;
        public long abv;
        public double abw;
        public zzc abx;
        public String zr;

        public zzd() {
            zzbmp();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzuj_zzd = (zzd) obj;
            if (this.abu != com_google_android_gms_internal_zzuj_zzd.abu) {
                return false;
            }
            if (this.zr == null) {
                if (com_google_android_gms_internal_zzuj_zzd.zr != null) {
                    return false;
                }
            } else if (!this.zr.equals(com_google_android_gms_internal_zzuj_zzd.zr)) {
                return false;
            }
            if (this.abv != com_google_android_gms_internal_zzuj_zzd.abv || Double.doubleToLongBits(this.abw) != Double.doubleToLongBits(com_google_android_gms_internal_zzuj_zzd.abw)) {
                return false;
            }
            if (this.abx == null) {
                if (com_google_android_gms_internal_zzuj_zzd.abx != null) {
                    return false;
                }
            } else if (!this.abx.equals(com_google_android_gms_internal_zzuj_zzd.abx)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzuj_zzd.bib == null || com_google_android_gms_internal_zzuj_zzd.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzuj_zzd.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zr == null ? 0 : this.zr.hashCode()) + (((this.abu ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.abv ^ (this.abv >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.abw);
            hashCode = ((this.abx == null ? 0 : this.abx.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.abu) {
                com_google_android_gms_internal_zzaov.zzj(1, this.abu);
            }
            if (!this.zr.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(2, this.zr);
            }
            if (this.abv != 0) {
                com_google_android_gms_internal_zzaov.zzb(3, this.abv);
            }
            if (Double.doubleToLongBits(this.abw) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzaov.zza(4, this.abw);
            }
            if (this.abx != null) {
                com_google_android_gms_internal_zzaov.zza(5, this.abx);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbc(com_google_android_gms_internal_zzaou);
        }

        public zzd zzbc(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.abu = com_google_android_gms_internal_zzaou.m48P();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zr = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.abv = com_google_android_gms_internal_zzaou.m45M();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                        this.abw = com_google_android_gms_internal_zzaou.readDouble();
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        if (this.abx == null) {
                            this.abx = new zzc();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.abx);
                        continue;
                    default:
                        if (!super.zza(com_google_android_gms_internal_zzaou, J)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzd zzbmp() {
            this.abu = false;
            this.zr = BuildConfig.FLAVOR;
            this.abv = 0;
            this.abw = 0.0d;
            this.abx = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.abu) {
                zzy += zzaov.zzk(1, this.abu);
            }
            if (!this.zr.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(2, this.zr);
            }
            if (this.abv != 0) {
                zzy += zzaov.zze(3, this.abv);
            }
            if (Double.doubleToLongBits(this.abw) != Double.doubleToLongBits(0.0d)) {
                zzy += zzaov.zzb(4, this.abw);
            }
            return this.abx != null ? zzy + zzaov.zzc(5, this.abx) : zzy;
        }
    }
}
