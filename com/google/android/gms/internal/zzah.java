package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.BuildConfig;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzah {

    public static final class zza extends zzaow<zza> {
        public int level;
        public int zzum;
        public int zzun;

        public zza() {
            zzab();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzah_zza = (zza) obj;
            return (this.level == com_google_android_gms_internal_zzah_zza.level && this.zzum == com_google_android_gms_internal_zzah_zza.zzum && this.zzun == com_google_android_gms_internal_zzah_zza.zzun) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zza.bib == null || com_google_android_gms_internal_zzah_zza.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zza.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzum) * 31) + this.zzun) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.level != 1) {
                com_google_android_gms_internal_zzaov.zzae(1, this.level);
            }
            if (this.zzum != 0) {
                com_google_android_gms_internal_zzaov.zzae(2, this.zzum);
            }
            if (this.zzun != 0) {
                com_google_android_gms_internal_zzaov.zzae(3, this.zzun);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zza zzab() {
            this.level = 1;
            this.zzum = 0;
            this.zzun = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzj(com_google_android_gms_internal_zzaou);
        }

        public zza zzj(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        J = com_google_android_gms_internal_zzaou.m46N();
                        switch (J) {
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                            case ConnectionResult.SERVICE_DISABLED /*3*/:
                                this.level = J;
                                break;
                            default:
                                continue;
                        }
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.zzum = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.zzun = com_google_android_gms_internal_zzaou.m46N();
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

        protected int zzy() {
            int zzy = super.zzy();
            if (this.level != 1) {
                zzy += zzaov.zzag(1, this.level);
            }
            if (this.zzum != 0) {
                zzy += zzaov.zzag(2, this.zzum);
            }
            return this.zzun != 0 ? zzy + zzaov.zzag(3, this.zzun) : zzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        private static volatile zzb[] zzuo;
        public int name;
        public int[] zzup;
        public int zzuq;
        public boolean zzur;
        public boolean zzus;

        public zzb() {
            zzad();
        }

        public static zzb[] zzac() {
            if (zzuo == null) {
                synchronized (zzapa.bij) {
                    if (zzuo == null) {
                        zzuo = new zzb[0];
                    }
                }
            }
            return zzuo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzah_zzb = (zzb) obj;
            return (zzapa.equals(this.zzup, com_google_android_gms_internal_zzah_zzb.zzup) && this.zzuq == com_google_android_gms_internal_zzah_zzb.zzuq && this.name == com_google_android_gms_internal_zzah_zzb.name && this.zzur == com_google_android_gms_internal_zzah_zzb.zzur && this.zzus == com_google_android_gms_internal_zzah_zzb.zzus) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzb.bib == null || com_google_android_gms_internal_zzah_zzb.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzb.bib) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzur ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzup)) * 31) + this.zzuq) * 31) + this.name) * 31)) * 31;
            if (!this.zzus) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzus) {
                com_google_android_gms_internal_zzaov.zzj(1, this.zzus);
            }
            com_google_android_gms_internal_zzaov.zzae(2, this.zzuq);
            if (this.zzup != null && this.zzup.length > 0) {
                for (int zzae : this.zzup) {
                    com_google_android_gms_internal_zzaov.zzae(3, zzae);
                }
            }
            if (this.name != 0) {
                com_google_android_gms_internal_zzaov.zzae(4, this.name);
            }
            if (this.zzur) {
                com_google_android_gms_internal_zzaov.zzj(6, this.zzur);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzb zzad() {
            this.zzup = zzapf.bim;
            this.zzuq = 0;
            this.name = 0;
            this.zzur = false;
            this.zzus = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzk(com_google_android_gms_internal_zzaou);
        }

        public zzb zzk(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.zzus = com_google_android_gms_internal_zzaou.m48P();
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.zzuq = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 24);
                        J = this.zzup == null ? 0 : this.zzup.length;
                        Object obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzup, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzup = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        int zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzup == null ? 0 : this.zzup.length;
                        Object obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzup, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzup = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.name = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zzur = com_google_android_gms_internal_zzaou.m48P();
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

        protected int zzy() {
            int i = 0;
            int zzy = super.zzy();
            if (this.zzus) {
                zzy += zzaov.zzk(1, this.zzus);
            }
            int zzag = zzaov.zzag(2, this.zzuq) + zzy;
            if (this.zzup == null || this.zzup.length <= 0) {
                zzy = zzag;
            } else {
                for (int zzaeo : this.zzup) {
                    i += zzaov.zzaeo(zzaeo);
                }
                zzy = (zzag + i) + (this.zzup.length * 1);
            }
            if (this.name != 0) {
                zzy += zzaov.zzag(4, this.name);
            }
            return this.zzur ? zzy + zzaov.zzk(6, this.zzur) : zzy;
        }
    }

    public static final class zzc extends zzaow<zzc> {
        private static volatile zzc[] zzut;
        public String zzcb;
        public long zzuu;
        public long zzuv;
        public boolean zzuw;
        public long zzux;

        public zzc() {
            zzaf();
        }

        public static zzc[] zzae() {
            if (zzut == null) {
                synchronized (zzapa.bij) {
                    if (zzut == null) {
                        zzut = new zzc[0];
                    }
                }
            }
            return zzut;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzah_zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (com_google_android_gms_internal_zzah_zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(com_google_android_gms_internal_zzah_zzc.zzcb)) {
                return false;
            }
            return (this.zzuu == com_google_android_gms_internal_zzah_zzc.zzuu && this.zzuv == com_google_android_gms_internal_zzah_zzc.zzuv && this.zzuw == com_google_android_gms_internal_zzah_zzc.zzuw && this.zzux == com_google_android_gms_internal_zzah_zzc.zzux) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzc.bib == null || com_google_android_gms_internal_zzah_zzc.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzc.bib) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzuw ? 1231 : 1237) + (((((((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzuu ^ (this.zzuu >>> 32)))) * 31) + ((int) (this.zzuv ^ (this.zzuv >>> 32)))) * 31)) * 31) + ((int) (this.zzux ^ (this.zzux >>> 32)))) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (!this.zzcb.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(1, this.zzcb);
            }
            if (this.zzuu != 0) {
                com_google_android_gms_internal_zzaov.zzb(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                com_google_android_gms_internal_zzaov.zzb(3, this.zzuv);
            }
            if (this.zzuw) {
                com_google_android_gms_internal_zzaov.zzj(4, this.zzuw);
            }
            if (this.zzux != 0) {
                com_google_android_gms_internal_zzaov.zzb(5, this.zzux);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzc zzaf() {
            this.zzcb = BuildConfig.FLAVOR;
            this.zzuu = 0;
            this.zzuv = 2147483647L;
            this.zzuw = false;
            this.zzux = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzl(com_google_android_gms_internal_zzaou);
        }

        public zzc zzl(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzcb = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.zzuu = com_google_android_gms_internal_zzaou.m45M();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.zzuv = com_google_android_gms_internal_zzaou.m45M();
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.zzuw = com_google_android_gms_internal_zzaou.m48P();
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.zzux = com_google_android_gms_internal_zzaou.m45M();
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

        protected int zzy() {
            int zzy = super.zzy();
            if (!this.zzcb.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(1, this.zzcb);
            }
            if (this.zzuu != 0) {
                zzy += zzaov.zze(2, this.zzuu);
            }
            if (this.zzuv != 2147483647L) {
                zzy += zzaov.zze(3, this.zzuv);
            }
            if (this.zzuw) {
                zzy += zzaov.zzk(4, this.zzuw);
            }
            return this.zzux != 0 ? zzy + zzaov.zze(5, this.zzux) : zzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public com.google.android.gms.internal.zzai.zza[] zzuy;
        public com.google.android.gms.internal.zzai.zza[] zzuz;
        public zzc[] zzva;

        public zzd() {
            zzag();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzah_zzd = (zzd) obj;
            return (zzapa.equals(this.zzuy, com_google_android_gms_internal_zzah_zzd.zzuy) && zzapa.equals(this.zzuz, com_google_android_gms_internal_zzah_zzd.zzuz) && zzapa.equals(this.zzva, com_google_android_gms_internal_zzah_zzd.zzva)) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzd.bib == null || com_google_android_gms_internal_zzah_zzd.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzd.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzuy)) * 31) + zzapa.hashCode(this.zzuz)) * 31) + zzapa.hashCode(this.zzva)) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.zzuy != null && this.zzuy.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzuy) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzuz) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        com_google_android_gms_internal_zzaov.zza(2, com_google_android_gms_internal_zzapc2);
                    }
                }
            }
            if (this.zzva != null && this.zzva.length > 0) {
                while (i < this.zzva.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.zzva[i];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        com_google_android_gms_internal_zzaov.zza(3, com_google_android_gms_internal_zzapc3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzd zzag() {
            this.zzuy = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzuz = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzva = zzc.zzae();
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzm(com_google_android_gms_internal_zzaou);
        }

        public zzd zzm(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.zzuy == null ? 0 : this.zzuy.length;
                        obj = new com.google.android.gms.internal.zzai.zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzuy, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new com.google.android.gms.internal.zzai.zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new com.google.android.gms.internal.zzai.zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzuy = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 18);
                        J = this.zzuz == null ? 0 : this.zzuz.length;
                        obj = new com.google.android.gms.internal.zzai.zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzuz, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new com.google.android.gms.internal.zzai.zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new com.google.android.gms.internal.zzai.zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzuz = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 26);
                        J = this.zzva == null ? 0 : this.zzva.length;
                        obj = new zzc[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzva, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzc();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzc();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzva = obj;
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

        protected int zzy() {
            int i;
            int i2 = 0;
            int zzy = super.zzy();
            if (this.zzuy != null && this.zzuy.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc : this.zzuy) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i += zzaov.zzc(1, com_google_android_gms_internal_zzapc);
                    }
                }
                zzy = i;
            }
            if (this.zzuz != null && this.zzuz.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzuz) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        i += zzaov.zzc(2, com_google_android_gms_internal_zzapc2);
                    }
                }
                zzy = i;
            }
            if (this.zzva != null && this.zzva.length > 0) {
                while (i2 < this.zzva.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.zzva[i2];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        zzy += zzaov.zzc(3, com_google_android_gms_internal_zzapc3);
                    }
                    i2++;
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        private static volatile zze[] zzvb;
        public int key;
        public int value;

        public zze() {
            zzai();
        }

        public static zze[] zzah() {
            if (zzvb == null) {
                synchronized (zzapa.bij) {
                    if (zzvb == null) {
                        zzvb = new zze[0];
                    }
                }
            }
            return zzvb;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzah_zze = (zze) obj;
            return (this.key == com_google_android_gms_internal_zzah_zze.key && this.value == com_google_android_gms_internal_zzah_zze.value) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zze.bib == null || com_google_android_gms_internal_zzah_zze.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zze.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            com_google_android_gms_internal_zzaov.zzae(1, this.key);
            com_google_android_gms_internal_zzaov.zzae(2, this.value);
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zze zzai() {
            this.key = 0;
            this.value = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzn(com_google_android_gms_internal_zzaou);
        }

        public zze zzn(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.key = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.value = com_google_android_gms_internal_zzaou.m46N();
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

        protected int zzy() {
            return (super.zzy() + zzaov.zzag(1, this.key)) + zzaov.zzag(2, this.value);
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public String version;
        public String[] zzvc;
        public String[] zzvd;
        public com.google.android.gms.internal.zzai.zza[] zzve;
        public zze[] zzvf;
        public zzb[] zzvg;
        public zzb[] zzvh;
        public zzb[] zzvi;
        public zzg[] zzvj;
        public String zzvk;
        public String zzvl;
        public String zzvm;
        public zza zzvn;
        public float zzvo;
        public boolean zzvp;
        public String[] zzvq;
        public int zzvr;

        public zzf() {
            zzaj();
        }

        public static zzf zze(byte[] bArr) throws zzapb {
            return (zzf) zzapc.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzah_zzf = (zzf) obj;
            if (!zzapa.equals(this.zzvc, com_google_android_gms_internal_zzah_zzf.zzvc) || !zzapa.equals(this.zzvd, com_google_android_gms_internal_zzah_zzf.zzvd) || !zzapa.equals(this.zzve, com_google_android_gms_internal_zzah_zzf.zzve) || !zzapa.equals(this.zzvf, com_google_android_gms_internal_zzah_zzf.zzvf) || !zzapa.equals(this.zzvg, com_google_android_gms_internal_zzah_zzf.zzvg) || !zzapa.equals(this.zzvh, com_google_android_gms_internal_zzah_zzf.zzvh) || !zzapa.equals(this.zzvi, com_google_android_gms_internal_zzah_zzf.zzvi) || !zzapa.equals(this.zzvj, com_google_android_gms_internal_zzah_zzf.zzvj)) {
                return false;
            }
            if (this.zzvk == null) {
                if (com_google_android_gms_internal_zzah_zzf.zzvk != null) {
                    return false;
                }
            } else if (!this.zzvk.equals(com_google_android_gms_internal_zzah_zzf.zzvk)) {
                return false;
            }
            if (this.zzvl == null) {
                if (com_google_android_gms_internal_zzah_zzf.zzvl != null) {
                    return false;
                }
            } else if (!this.zzvl.equals(com_google_android_gms_internal_zzah_zzf.zzvl)) {
                return false;
            }
            if (this.zzvm == null) {
                if (com_google_android_gms_internal_zzah_zzf.zzvm != null) {
                    return false;
                }
            } else if (!this.zzvm.equals(com_google_android_gms_internal_zzah_zzf.zzvm)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzah_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzah_zzf.version)) {
                return false;
            }
            if (this.zzvn == null) {
                if (com_google_android_gms_internal_zzah_zzf.zzvn != null) {
                    return false;
                }
            } else if (!this.zzvn.equals(com_google_android_gms_internal_zzah_zzf.zzvn)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzvo) == Float.floatToIntBits(com_google_android_gms_internal_zzah_zzf.zzvo) && this.zzvp == com_google_android_gms_internal_zzah_zzf.zzvp && zzapa.equals(this.zzvq, com_google_android_gms_internal_zzah_zzf.zzvq) && this.zzvr == com_google_android_gms_internal_zzah_zzf.zzvr) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzf.bib == null || com_google_android_gms_internal_zzah_zzf.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzf.bib) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zzvp ? 1231 : 1237) + (((((this.zzvn == null ? 0 : this.zzvn.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zzvm == null ? 0 : this.zzvm.hashCode()) + (((this.zzvl == null ? 0 : this.zzvl.hashCode()) + (((this.zzvk == null ? 0 : this.zzvk.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzvc)) * 31) + zzapa.hashCode(this.zzvd)) * 31) + zzapa.hashCode(this.zzve)) * 31) + zzapa.hashCode(this.zzvf)) * 31) + zzapa.hashCode(this.zzvg)) * 31) + zzapa.hashCode(this.zzvh)) * 31) + zzapa.hashCode(this.zzvi)) * 31) + zzapa.hashCode(this.zzvj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zzvo)) * 31)) * 31) + zzapa.hashCode(this.zzvq)) * 31) + this.zzvr) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.zzvd != null && this.zzvd.length > 0) {
                for (String str : this.zzvd) {
                    if (str != null) {
                        com_google_android_gms_internal_zzaov.zzr(1, str);
                    }
                }
            }
            if (this.zzve != null && this.zzve.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzve) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(2, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzvf) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        com_google_android_gms_internal_zzaov.zza(3, com_google_android_gms_internal_zzapc2);
                    }
                }
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc22 : this.zzvg) {
                    if (com_google_android_gms_internal_zzapc22 != null) {
                        com_google_android_gms_internal_zzaov.zza(4, com_google_android_gms_internal_zzapc22);
                    }
                }
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc222 : this.zzvh) {
                    if (com_google_android_gms_internal_zzapc222 != null) {
                        com_google_android_gms_internal_zzaov.zza(5, com_google_android_gms_internal_zzapc222);
                    }
                }
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2222 : this.zzvi) {
                    if (com_google_android_gms_internal_zzapc2222 != null) {
                        com_google_android_gms_internal_zzaov.zza(6, com_google_android_gms_internal_zzapc2222);
                    }
                }
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc22222 : this.zzvj) {
                    if (com_google_android_gms_internal_zzapc22222 != null) {
                        com_google_android_gms_internal_zzaov.zza(7, com_google_android_gms_internal_zzapc22222);
                    }
                }
            }
            if (!this.zzvk.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(9, this.zzvk);
            }
            if (!this.zzvl.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                com_google_android_gms_internal_zzaov.zzr(12, this.zzvm);
            }
            if (!this.version.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(13, this.version);
            }
            if (this.zzvn != null) {
                com_google_android_gms_internal_zzaov.zza(14, this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                com_google_android_gms_internal_zzaov.zzc(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                for (String str2 : this.zzvq) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzaov.zzr(16, str2);
                    }
                }
            }
            if (this.zzvr != 0) {
                com_google_android_gms_internal_zzaov.zzae(17, this.zzvr);
            }
            if (this.zzvp) {
                com_google_android_gms_internal_zzaov.zzj(18, this.zzvp);
            }
            if (this.zzvc != null && this.zzvc.length > 0) {
                while (i < this.zzvc.length) {
                    String str3 = this.zzvc[i];
                    if (str3 != null) {
                        com_google_android_gms_internal_zzaov.zzr(19, str3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzf zzaj() {
            this.zzvc = zzapf.bir;
            this.zzvd = zzapf.bir;
            this.zzve = com.google.android.gms.internal.zzai.zza.zzaq();
            this.zzvf = zze.zzah();
            this.zzvg = zzb.zzac();
            this.zzvh = zzb.zzac();
            this.zzvi = zzb.zzac();
            this.zzvj = zzg.zzak();
            this.zzvk = BuildConfig.FLAVOR;
            this.zzvl = BuildConfig.FLAVOR;
            this.zzvm = "0";
            this.version = BuildConfig.FLAVOR;
            this.zzvn = null;
            this.zzvo = 0.0f;
            this.zzvp = false;
            this.zzvq = zzapf.bir;
            this.zzvr = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzo(com_google_android_gms_internal_zzaou);
        }

        public zzf zzo(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.zzvd == null ? 0 : this.zzvd.length;
                        obj = new String[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvd, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.readString();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.readString();
                        this.zzvd = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 18);
                        J = this.zzve == null ? 0 : this.zzve.length;
                        obj = new com.google.android.gms.internal.zzai.zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzve, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new com.google.android.gms.internal.zzai.zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new com.google.android.gms.internal.zzai.zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzve = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 26);
                        J = this.zzvf == null ? 0 : this.zzvf.length;
                        obj = new zze[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvf, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zze();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zze();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzvf = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 34);
                        J = this.zzvg == null ? 0 : this.zzvg.length;
                        obj = new zzb[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvg, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzb();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzb();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzvg = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 42);
                        J = this.zzvh == null ? 0 : this.zzvh.length;
                        obj = new zzb[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvh, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzb();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzb();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzvh = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarStyle /*50*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 50);
                        J = this.zzvi == null ? 0 : this.zzvi.length;
                        obj = new zzb[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvi, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzb();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzb();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzvi = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 58);
                        J = this.zzvj == null ? 0 : this.zzvj.length;
                        obj = new zzg[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvj, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzg();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzg();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzvj = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dropDownListViewStyle /*74*/:
                        this.zzvk = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorPrimary /*82*/:
                        this.zzvl = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                        this.zzvm = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_ratingBarStyle /*106*/:
                        this.version = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 114:
                        if (this.zzvn == null) {
                            this.zzvn = new zza();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzvn);
                        continue;
                    case 125:
                        this.zzvo = com_google_android_gms_internal_zzaou.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, TransportMediator.KEYCODE_MEDIA_RECORD);
                        J = this.zzvq == null ? 0 : this.zzvq.length;
                        obj = new String[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvq, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.readString();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.readString();
                        this.zzvq = obj;
                        continue;
                    case 136:
                        this.zzvr = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case 144:
                        this.zzvp = com_google_android_gms_internal_zzaou.m48P();
                        continue;
                    case 154:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 154);
                        J = this.zzvc == null ? 0 : this.zzvc.length;
                        obj = new String[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvc, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.readString();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.readString();
                        this.zzvc = obj;
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

        protected int zzy() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzy = super.zzy();
            if (this.zzvd == null || this.zzvd.length <= 0) {
                i = zzy;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzvd) {
                    if (str != null) {
                        i3++;
                        i2 += zzaov.zztg(str);
                    }
                }
                i = (zzy + i2) + (i3 * 1);
            }
            if (this.zzve != null && this.zzve.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc : this.zzve) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i2 += zzaov.zzc(2, com_google_android_gms_internal_zzapc);
                    }
                }
                i = i2;
            }
            if (this.zzvf != null && this.zzvf.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzvf) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        i2 += zzaov.zzc(3, com_google_android_gms_internal_zzapc2);
                    }
                }
                i = i2;
            }
            if (this.zzvg != null && this.zzvg.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc22 : this.zzvg) {
                    if (com_google_android_gms_internal_zzapc22 != null) {
                        i2 += zzaov.zzc(4, com_google_android_gms_internal_zzapc22);
                    }
                }
                i = i2;
            }
            if (this.zzvh != null && this.zzvh.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc222 : this.zzvh) {
                    if (com_google_android_gms_internal_zzapc222 != null) {
                        i2 += zzaov.zzc(5, com_google_android_gms_internal_zzapc222);
                    }
                }
                i = i2;
            }
            if (this.zzvi != null && this.zzvi.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc2222 : this.zzvi) {
                    if (com_google_android_gms_internal_zzapc2222 != null) {
                        i2 += zzaov.zzc(6, com_google_android_gms_internal_zzapc2222);
                    }
                }
                i = i2;
            }
            if (this.zzvj != null && this.zzvj.length > 0) {
                i2 = i;
                for (zzapc com_google_android_gms_internal_zzapc22222 : this.zzvj) {
                    if (com_google_android_gms_internal_zzapc22222 != null) {
                        i2 += zzaov.zzc(7, com_google_android_gms_internal_zzapc22222);
                    }
                }
                i = i2;
            }
            if (!this.zzvk.equals(BuildConfig.FLAVOR)) {
                i += zzaov.zzs(9, this.zzvk);
            }
            if (!this.zzvl.equals(BuildConfig.FLAVOR)) {
                i += zzaov.zzs(10, this.zzvl);
            }
            if (!this.zzvm.equals("0")) {
                i += zzaov.zzs(12, this.zzvm);
            }
            if (!this.version.equals(BuildConfig.FLAVOR)) {
                i += zzaov.zzs(13, this.version);
            }
            if (this.zzvn != null) {
                i += zzaov.zzc(14, this.zzvn);
            }
            if (Float.floatToIntBits(this.zzvo) != Float.floatToIntBits(0.0f)) {
                i += zzaov.zzd(15, this.zzvo);
            }
            if (this.zzvq != null && this.zzvq.length > 0) {
                i3 = 0;
                zzy = 0;
                for (String str2 : this.zzvq) {
                    if (str2 != null) {
                        zzy++;
                        i3 += zzaov.zztg(str2);
                    }
                }
                i = (i + i3) + (zzy * 2);
            }
            if (this.zzvr != 0) {
                i += zzaov.zzag(17, this.zzvr);
            }
            if (this.zzvp) {
                i += zzaov.zzk(18, this.zzvp);
            }
            if (this.zzvc == null || this.zzvc.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzvc.length) {
                String str3 = this.zzvc[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzaov.zztg(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }
    }

    public static final class zzg extends zzaow<zzg> {
        private static volatile zzg[] zzvs;
        public int[] zzvt;
        public int[] zzvu;
        public int[] zzvv;
        public int[] zzvw;
        public int[] zzvx;
        public int[] zzvy;
        public int[] zzvz;
        public int[] zzwa;
        public int[] zzwb;
        public int[] zzwc;

        public zzg() {
            zzal();
        }

        public static zzg[] zzak() {
            if (zzvs == null) {
                synchronized (zzapa.bij) {
                    if (zzvs == null) {
                        zzvs = new zzg[0];
                    }
                }
            }
            return zzvs;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzah_zzg = (zzg) obj;
            return (zzapa.equals(this.zzvt, com_google_android_gms_internal_zzah_zzg.zzvt) && zzapa.equals(this.zzvu, com_google_android_gms_internal_zzah_zzg.zzvu) && zzapa.equals(this.zzvv, com_google_android_gms_internal_zzah_zzg.zzvv) && zzapa.equals(this.zzvw, com_google_android_gms_internal_zzah_zzg.zzvw) && zzapa.equals(this.zzvx, com_google_android_gms_internal_zzah_zzg.zzvx) && zzapa.equals(this.zzvy, com_google_android_gms_internal_zzah_zzg.zzvy) && zzapa.equals(this.zzvz, com_google_android_gms_internal_zzah_zzg.zzvz) && zzapa.equals(this.zzwa, com_google_android_gms_internal_zzah_zzg.zzwa) && zzapa.equals(this.zzwb, com_google_android_gms_internal_zzah_zzg.zzwb) && zzapa.equals(this.zzwc, com_google_android_gms_internal_zzah_zzg.zzwc)) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzg.bib == null || com_google_android_gms_internal_zzah_zzg.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzg.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzvt)) * 31) + zzapa.hashCode(this.zzvu)) * 31) + zzapa.hashCode(this.zzvv)) * 31) + zzapa.hashCode(this.zzvw)) * 31) + zzapa.hashCode(this.zzvx)) * 31) + zzapa.hashCode(this.zzvy)) * 31) + zzapa.hashCode(this.zzvz)) * 31) + zzapa.hashCode(this.zzwa)) * 31) + zzapa.hashCode(this.zzwb)) * 31) + zzapa.hashCode(this.zzwc)) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.zzvt != null && this.zzvt.length > 0) {
                for (int zzae : this.zzvt) {
                    com_google_android_gms_internal_zzaov.zzae(1, zzae);
                }
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                for (int zzae2 : this.zzvu) {
                    com_google_android_gms_internal_zzaov.zzae(2, zzae2);
                }
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                for (int zzae22 : this.zzvv) {
                    com_google_android_gms_internal_zzaov.zzae(3, zzae22);
                }
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                for (int zzae222 : this.zzvw) {
                    com_google_android_gms_internal_zzaov.zzae(4, zzae222);
                }
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                for (int zzae2222 : this.zzvx) {
                    com_google_android_gms_internal_zzaov.zzae(5, zzae2222);
                }
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                for (int zzae22222 : this.zzvy) {
                    com_google_android_gms_internal_zzaov.zzae(6, zzae22222);
                }
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                for (int zzae222222 : this.zzvz) {
                    com_google_android_gms_internal_zzaov.zzae(7, zzae222222);
                }
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                for (int zzae2222222 : this.zzwa) {
                    com_google_android_gms_internal_zzaov.zzae(8, zzae2222222);
                }
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                for (int zzae22222222 : this.zzwb) {
                    com_google_android_gms_internal_zzaov.zzae(9, zzae22222222);
                }
            }
            if (this.zzwc != null && this.zzwc.length > 0) {
                while (i < this.zzwc.length) {
                    com_google_android_gms_internal_zzaov.zzae(10, this.zzwc[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzg zzal() {
            this.zzvt = zzapf.bim;
            this.zzvu = zzapf.bim;
            this.zzvv = zzapf.bim;
            this.zzvw = zzapf.bim;
            this.zzvx = zzapf.bim;
            this.zzvy = zzapf.bim;
            this.zzvz = zzapf.bim;
            this.zzwa = zzapf.bim;
            this.zzwb = zzapf.bim;
            this.zzwc = zzapf.bim;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzp(com_google_android_gms_internal_zzaou);
        }

        public zzg zzp(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                int zzaei;
                Object obj2;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 8);
                        J = this.zzvt == null ? 0 : this.zzvt.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvt, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvt = obj;
                        continue;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvt == null ? 0 : this.zzvt.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvt, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvt = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 16);
                        J = this.zzvu == null ? 0 : this.zzvu.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvu, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvu = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvu == null ? 0 : this.zzvu.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvu, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvu = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 24);
                        J = this.zzvv == null ? 0 : this.zzvv.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvv, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvv = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvv == null ? 0 : this.zzvv.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvv, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvv = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 32);
                        J = this.zzvw == null ? 0 : this.zzvw.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvw, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvw = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvw == null ? 0 : this.zzvw.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvw, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvw = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 40);
                        J = this.zzvx == null ? 0 : this.zzvx.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvx, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvx = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvx == null ? 0 : this.zzvx.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvx, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvx = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 48);
                        J = this.zzvy == null ? 0 : this.zzvy.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvy, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvy = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarStyle /*50*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvy == null ? 0 : this.zzvy.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvy, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvy = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_dividerHorizontal /*56*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 56);
                        J = this.zzvz == null ? 0 : this.zzvz.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzvz, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzvz = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzvz == null ? 0 : this.zzvz.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzvz, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzvz = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 64);
                        J = this.zzwa == null ? 0 : this.zzwa.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwa, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwa = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwa == null ? 0 : this.zzwa.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwa, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwa = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 72);
                        J = this.zzwb == null ? 0 : this.zzwb.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwb, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwb = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dropDownListViewStyle /*74*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwb == null ? 0 : this.zzwb.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwb = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 80);
                        J = this.zzwc == null ? 0 : this.zzwc.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwc, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwc = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorPrimary /*82*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwc == null ? 0 : this.zzwc.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwc = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
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

        protected int zzy() {
            int i;
            int i2;
            int i3 = 0;
            int zzy = super.zzy();
            if (this.zzvt == null || this.zzvt.length <= 0) {
                i = zzy;
            } else {
                i2 = 0;
                for (int zzaeo : this.zzvt) {
                    i2 += zzaov.zzaeo(zzaeo);
                }
                i = (zzy + i2) + (this.zzvt.length * 1);
            }
            if (this.zzvu != null && this.zzvu.length > 0) {
                zzy = 0;
                for (int zzaeo2 : this.zzvu) {
                    zzy += zzaov.zzaeo(zzaeo2);
                }
                i = (i + zzy) + (this.zzvu.length * 1);
            }
            if (this.zzvv != null && this.zzvv.length > 0) {
                zzy = 0;
                for (int zzaeo22 : this.zzvv) {
                    zzy += zzaov.zzaeo(zzaeo22);
                }
                i = (i + zzy) + (this.zzvv.length * 1);
            }
            if (this.zzvw != null && this.zzvw.length > 0) {
                zzy = 0;
                for (int zzaeo222 : this.zzvw) {
                    zzy += zzaov.zzaeo(zzaeo222);
                }
                i = (i + zzy) + (this.zzvw.length * 1);
            }
            if (this.zzvx != null && this.zzvx.length > 0) {
                zzy = 0;
                for (int zzaeo2222 : this.zzvx) {
                    zzy += zzaov.zzaeo(zzaeo2222);
                }
                i = (i + zzy) + (this.zzvx.length * 1);
            }
            if (this.zzvy != null && this.zzvy.length > 0) {
                zzy = 0;
                for (int zzaeo22222 : this.zzvy) {
                    zzy += zzaov.zzaeo(zzaeo22222);
                }
                i = (i + zzy) + (this.zzvy.length * 1);
            }
            if (this.zzvz != null && this.zzvz.length > 0) {
                zzy = 0;
                for (int zzaeo222222 : this.zzvz) {
                    zzy += zzaov.zzaeo(zzaeo222222);
                }
                i = (i + zzy) + (this.zzvz.length * 1);
            }
            if (this.zzwa != null && this.zzwa.length > 0) {
                zzy = 0;
                for (int zzaeo2222222 : this.zzwa) {
                    zzy += zzaov.zzaeo(zzaeo2222222);
                }
                i = (i + zzy) + (this.zzwa.length * 1);
            }
            if (this.zzwb != null && this.zzwb.length > 0) {
                zzy = 0;
                for (int zzaeo22222222 : this.zzwb) {
                    zzy += zzaov.zzaeo(zzaeo22222222);
                }
                i = (i + zzy) + (this.zzwb.length * 1);
            }
            if (this.zzwc == null || this.zzwc.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zzwc.length) {
                i2 += zzaov.zzaeo(this.zzwc[i3]);
                i3++;
            }
            return (i + i2) + (this.zzwc.length * 1);
        }
    }

    public static final class zzh extends zzaow<zzh> {
        public static final zzaox<com.google.android.gms.internal.zzai.zza, zzh> zzwd;
        private static final zzh[] zzwe;
        public int[] zzwf;
        public int[] zzwg;
        public int[] zzwh;
        public int zzwi;
        public int[] zzwj;
        public int zzwk;
        public int zzwl;

        static {
            zzwd = zzaox.zza(11, zzh.class, 810);
            zzwe = new zzh[0];
        }

        public zzh() {
            zzam();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzah_zzh = (zzh) obj;
            return (zzapa.equals(this.zzwf, com_google_android_gms_internal_zzah_zzh.zzwf) && zzapa.equals(this.zzwg, com_google_android_gms_internal_zzah_zzh.zzwg) && zzapa.equals(this.zzwh, com_google_android_gms_internal_zzah_zzh.zzwh) && this.zzwi == com_google_android_gms_internal_zzah_zzh.zzwi && zzapa.equals(this.zzwj, com_google_android_gms_internal_zzah_zzh.zzwj) && this.zzwk == com_google_android_gms_internal_zzah_zzh.zzwk && this.zzwl == com_google_android_gms_internal_zzah_zzh.zzwl) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzh.bib == null || com_google_android_gms_internal_zzah_zzh.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzh.bib) : false;
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzwf)) * 31) + zzapa.hashCode(this.zzwg)) * 31) + zzapa.hashCode(this.zzwh)) * 31) + this.zzwi) * 31) + zzapa.hashCode(this.zzwj)) * 31) + this.zzwk) * 31) + this.zzwl) * 31;
            int hashCode2 = (this.bib == null || this.bib.isEmpty()) ? 0 : this.bib.hashCode();
            return hashCode2 + hashCode;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.zzwf != null && this.zzwf.length > 0) {
                for (int zzae : this.zzwf) {
                    com_google_android_gms_internal_zzaov.zzae(1, zzae);
                }
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                for (int zzae2 : this.zzwg) {
                    com_google_android_gms_internal_zzaov.zzae(2, zzae2);
                }
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                for (int zzae22 : this.zzwh) {
                    com_google_android_gms_internal_zzaov.zzae(3, zzae22);
                }
            }
            if (this.zzwi != 0) {
                com_google_android_gms_internal_zzaov.zzae(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                while (i < this.zzwj.length) {
                    com_google_android_gms_internal_zzaov.zzae(5, this.zzwj[i]);
                    i++;
                }
            }
            if (this.zzwk != 0) {
                com_google_android_gms_internal_zzaov.zzae(6, this.zzwk);
            }
            if (this.zzwl != 0) {
                com_google_android_gms_internal_zzaov.zzae(7, this.zzwl);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzh zzam() {
            this.zzwf = zzapf.bim;
            this.zzwg = zzapf.bim;
            this.zzwh = zzapf.bim;
            this.zzwi = 0;
            this.zzwj = zzapf.bim;
            this.zzwk = 0;
            this.zzwl = 0;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzq(com_google_android_gms_internal_zzaou);
        }

        public zzh zzq(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                int zzaei;
                Object obj2;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 8);
                        J = this.zzwf == null ? 0 : this.zzwf.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwf, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwf = obj;
                        continue;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwf == null ? 0 : this.zzwf.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwf, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwf = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 16);
                        J = this.zzwg == null ? 0 : this.zzwg.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwg, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwg = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwg == null ? 0 : this.zzwg.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwg, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwg = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 24);
                        J = this.zzwh == null ? 0 : this.zzwh.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwh, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwh = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwh == null ? 0 : this.zzwh.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwh, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwh = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.zzwi = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 40);
                        J = this.zzwj == null ? 0 : this.zzwj.length;
                        obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwj, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzwj = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzwj == null ? 0 : this.zzwj.length;
                        obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzwj, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzwj = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zzwk = com_google_android_gms_internal_zzaou.m46N();
                        continue;
                    case C0337R.styleable.AppCompatTheme_dividerHorizontal /*56*/:
                        this.zzwl = com_google_android_gms_internal_zzaou.m46N();
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

        protected int zzy() {
            int i;
            int i2;
            int i3 = 0;
            int zzy = super.zzy();
            if (this.zzwf == null || this.zzwf.length <= 0) {
                i = zzy;
            } else {
                i2 = 0;
                for (int zzaeo : this.zzwf) {
                    i2 += zzaov.zzaeo(zzaeo);
                }
                i = (zzy + i2) + (this.zzwf.length * 1);
            }
            if (this.zzwg != null && this.zzwg.length > 0) {
                zzy = 0;
                for (int zzaeo2 : this.zzwg) {
                    zzy += zzaov.zzaeo(zzaeo2);
                }
                i = (i + zzy) + (this.zzwg.length * 1);
            }
            if (this.zzwh != null && this.zzwh.length > 0) {
                zzy = 0;
                for (int zzaeo22 : this.zzwh) {
                    zzy += zzaov.zzaeo(zzaeo22);
                }
                i = (i + zzy) + (this.zzwh.length * 1);
            }
            if (this.zzwi != 0) {
                i += zzaov.zzag(4, this.zzwi);
            }
            if (this.zzwj != null && this.zzwj.length > 0) {
                i2 = 0;
                while (i3 < this.zzwj.length) {
                    i2 += zzaov.zzaeo(this.zzwj[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzwj.length * 1);
            }
            if (this.zzwk != 0) {
                i += zzaov.zzag(6, this.zzwk);
            }
            return this.zzwl != 0 ? i + zzaov.zzag(7, this.zzwl) : i;
        }
    }

    public static final class zzi extends zzaow<zzi> {
        private static volatile zzi[] zzwm;
        public String name;
        public com.google.android.gms.internal.zzai.zza zzwn;
        public zzd zzwo;

        public zzi() {
            zzao();
        }

        public static zzi[] zzan() {
            if (zzwm == null) {
                synchronized (zzapa.bij) {
                    if (zzwm == null) {
                        zzwm = new zzi[0];
                    }
                }
            }
            return zzwm;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzah_zzi = (zzi) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzah_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzah_zzi.name)) {
                return false;
            }
            if (this.zzwn == null) {
                if (com_google_android_gms_internal_zzah_zzi.zzwn != null) {
                    return false;
                }
            } else if (!this.zzwn.equals(com_google_android_gms_internal_zzah_zzi.zzwn)) {
                return false;
            }
            if (this.zzwo == null) {
                if (com_google_android_gms_internal_zzah_zzi.zzwo != null) {
                    return false;
                }
            } else if (!this.zzwo.equals(com_google_android_gms_internal_zzah_zzi.zzwo)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzi.bib == null || com_google_android_gms_internal_zzah_zzi.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzi.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzwo == null ? 0 : this.zzwo.hashCode()) + (((this.zzwn == null ? 0 : this.zzwn.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(1, this.name);
            }
            if (this.zzwn != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzwn);
            }
            if (this.zzwo != null) {
                com_google_android_gms_internal_zzaov.zza(3, this.zzwo);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzi zzao() {
            this.name = BuildConfig.FLAVOR;
            this.zzwn = null;
            this.zzwo = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzr(com_google_android_gms_internal_zzaou);
        }

        public zzi zzr(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzwn == null) {
                            this.zzwn = new com.google.android.gms.internal.zzai.zza();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzwn);
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        if (this.zzwo == null) {
                            this.zzwo = new zzd();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzwo);
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

        protected int zzy() {
            int zzy = super.zzy();
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.zzwn != null) {
                zzy += zzaov.zzc(2, this.zzwn);
            }
            return this.zzwo != null ? zzy + zzaov.zzc(3, this.zzwo) : zzy;
        }
    }

    public static final class zzj extends zzaow<zzj> {
        public zzi[] zzwp;
        public zzf zzwq;
        public String zzwr;

        public zzj() {
            zzap();
        }

        public static zzj zzf(byte[] bArr) throws zzapb {
            return (zzj) zzapc.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzah_zzj = (zzj) obj;
            if (!zzapa.equals(this.zzwp, com_google_android_gms_internal_zzah_zzj.zzwp)) {
                return false;
            }
            if (this.zzwq == null) {
                if (com_google_android_gms_internal_zzah_zzj.zzwq != null) {
                    return false;
                }
            } else if (!this.zzwq.equals(com_google_android_gms_internal_zzah_zzj.zzwq)) {
                return false;
            }
            if (this.zzwr == null) {
                if (com_google_android_gms_internal_zzah_zzj.zzwr != null) {
                    return false;
                }
            } else if (!this.zzwr.equals(com_google_android_gms_internal_zzah_zzj.zzwr)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzah_zzj.bib == null || com_google_android_gms_internal_zzah_zzj.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzah_zzj.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzwr == null ? 0 : this.zzwr.hashCode()) + (((this.zzwq == null ? 0 : this.zzwq.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.zzwp)) * 31)) * 31)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzwp) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzwq != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzwq);
            }
            if (!this.zzwr.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(3, this.zzwr);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zzj zzap() {
            this.zzwp = zzi.zzan();
            this.zzwq = null;
            this.zzwr = BuildConfig.FLAVOR;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzs(com_google_android_gms_internal_zzaou);
        }

        public zzj zzs(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.zzwp == null ? 0 : this.zzwp.length;
                        Object obj = new zzi[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwp, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzi();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzi();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzwp = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzwq == null) {
                            this.zzwq = new zzf();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzwq);
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        this.zzwr = com_google_android_gms_internal_zzaou.readString();
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

        protected int zzy() {
            int zzy = super.zzy();
            if (this.zzwp != null && this.zzwp.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzwp) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        zzy += zzaov.zzc(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzwq != null) {
                zzy += zzaov.zzc(2, this.zzwq);
            }
            return !this.zzwr.equals(BuildConfig.FLAVOR) ? zzy + zzaov.zzs(3, this.zzwr) : zzy;
        }
    }
}
