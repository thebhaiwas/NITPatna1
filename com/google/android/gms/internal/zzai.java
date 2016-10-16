package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.BuildConfig;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzai {

    public static final class zza extends zzaow<zza> {
        private static volatile zza[] zzws;
        public int type;
        public String zzwt;
        public zza[] zzwu;
        public zza[] zzwv;
        public zza[] zzww;
        public String zzwx;
        public String zzwy;
        public long zzwz;
        public boolean zzxa;
        public zza[] zzxb;
        public int[] zzxc;
        public boolean zzxd;

        public zza() {
            zzar();
        }

        public static zza[] zzaq() {
            if (zzws == null) {
                synchronized (zzapa.bij) {
                    if (zzws == null) {
                        zzws = new zza[0];
                    }
                }
            }
            return zzws;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzai_zza = (zza) obj;
            if (this.type != com_google_android_gms_internal_zzai_zza.type) {
                return false;
            }
            if (this.zzwt == null) {
                if (com_google_android_gms_internal_zzai_zza.zzwt != null) {
                    return false;
                }
            } else if (!this.zzwt.equals(com_google_android_gms_internal_zzai_zza.zzwt)) {
                return false;
            }
            if (!zzapa.equals(this.zzwu, com_google_android_gms_internal_zzai_zza.zzwu) || !zzapa.equals(this.zzwv, com_google_android_gms_internal_zzai_zza.zzwv) || !zzapa.equals(this.zzww, com_google_android_gms_internal_zzai_zza.zzww)) {
                return false;
            }
            if (this.zzwx == null) {
                if (com_google_android_gms_internal_zzai_zza.zzwx != null) {
                    return false;
                }
            } else if (!this.zzwx.equals(com_google_android_gms_internal_zzai_zza.zzwx)) {
                return false;
            }
            if (this.zzwy == null) {
                if (com_google_android_gms_internal_zzai_zza.zzwy != null) {
                    return false;
                }
            } else if (!this.zzwy.equals(com_google_android_gms_internal_zzai_zza.zzwy)) {
                return false;
            }
            return (this.zzwz == com_google_android_gms_internal_zzai_zza.zzwz && this.zzxa == com_google_android_gms_internal_zzai_zza.zzxa && zzapa.equals(this.zzxb, com_google_android_gms_internal_zzai_zza.zzxb) && zzapa.equals(this.zzxc, com_google_android_gms_internal_zzai_zza.zzxc) && this.zzxd == com_google_android_gms_internal_zzai_zza.zzxd) ? (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzai_zza.bib == null || com_google_android_gms_internal_zzai_zza.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzai_zza.bib) : false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzxa ? 1231 : 1237) + (((((this.zzwy == null ? 0 : this.zzwy.hashCode()) + (((this.zzwx == null ? 0 : this.zzwx.hashCode()) + (((((((((this.zzwt == null ? 0 : this.zzwt.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzapa.hashCode(this.zzwu)) * 31) + zzapa.hashCode(this.zzwv)) * 31) + zzapa.hashCode(this.zzww)) * 31)) * 31)) * 31) + ((int) (this.zzwz ^ (this.zzwz >>> 32)))) * 31)) * 31) + zzapa.hashCode(this.zzxb)) * 31) + zzapa.hashCode(this.zzxc)) * 31;
            if (!this.zzxd) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i2 = this.bib.hashCode();
            }
            return hashCode + i2;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            com_google_android_gms_internal_zzaov.zzae(1, this.type);
            if (!this.zzwt.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzwu) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(3, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzwv) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        com_google_android_gms_internal_zzaov.zza(4, com_google_android_gms_internal_zzapc2);
                    }
                }
            }
            if (this.zzww != null && this.zzww.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc22 : this.zzww) {
                    if (com_google_android_gms_internal_zzapc22 != null) {
                        com_google_android_gms_internal_zzaov.zza(5, com_google_android_gms_internal_zzapc22);
                    }
                }
            }
            if (!this.zzwx.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(6, this.zzwx);
            }
            if (!this.zzwy.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzaov.zzr(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                com_google_android_gms_internal_zzaov.zzb(8, this.zzwz);
            }
            if (this.zzxd) {
                com_google_android_gms_internal_zzaov.zzj(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                for (int zzae : this.zzxc) {
                    com_google_android_gms_internal_zzaov.zzae(10, zzae);
                }
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                while (i < this.zzxb.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.zzxb[i];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        com_google_android_gms_internal_zzaov.zza(11, com_google_android_gms_internal_zzapc3);
                    }
                    i++;
                }
            }
            if (this.zzxa) {
                com_google_android_gms_internal_zzaov.zzj(12, this.zzxa);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public zza zzar() {
            this.type = 1;
            this.zzwt = BuildConfig.FLAVOR;
            this.zzwu = zzaq();
            this.zzwv = zzaq();
            this.zzww = zzaq();
            this.zzwx = BuildConfig.FLAVOR;
            this.zzwy = BuildConfig.FLAVOR;
            this.zzwz = 0;
            this.zzxa = false;
            this.zzxb = zzaq();
            this.zzxc = zzapf.bim;
            this.zzxd = false;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzt(com_google_android_gms_internal_zzaou);
        }

        public zza zzt(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                int i;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        J = com_google_android_gms_internal_zzaou.m46N();
                        switch (J) {
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                            case ConnectionResult.SERVICE_DISABLED /*3*/:
                            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                            case ConnectionResult.NETWORK_ERROR /*7*/:
                            case ConnectionResult.INTERNAL_ERROR /*8*/:
                                this.type = J;
                                break;
                            default:
                                continue;
                        }
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzwt = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 26);
                        J = this.zzwu == null ? 0 : this.zzwu.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwu, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzwu = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 34);
                        J = this.zzwv == null ? 0 : this.zzwv.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzwv, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzwv = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 42);
                        J = this.zzww == null ? 0 : this.zzww.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzww, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzww = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarStyle /*50*/:
                        this.zzwx = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                        this.zzwy = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        this.zzwz = com_google_android_gms_internal_zzaou.m45M();
                        continue;
                    case C0337R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                        this.zzxd = com_google_android_gms_internal_zzaou.m48P();
                        continue;
                    case C0337R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                        int zzc2 = zzapf.zzc(com_google_android_gms_internal_zzaou, 80);
                        Object obj2 = new int[zzc2];
                        i = 0;
                        zzc = 0;
                        while (i < zzc2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zzaou.m42J();
                            }
                            int N = com_google_android_gms_internal_zzaou.m46N();
                            switch (N) {
                                case ConnectionResult.SERVICE_MISSING /*1*/:
                                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                                case ConnectionResult.SERVICE_DISABLED /*3*/:
                                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                                case ConnectionResult.NETWORK_ERROR /*7*/:
                                case ConnectionResult.INTERNAL_ERROR /*8*/:
                                case ConnectionResult.SERVICE_INVALID /*9*/:
                                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0337R.styleable.Toolbar_titleMargins /*12*/:
                                case ConnectionResult.CANCELED /*13*/:
                                case ConnectionResult.TIMEOUT /*14*/:
                                case ConnectionResult.INTERRUPTED /*15*/:
                                case ConnectionResult.API_UNAVAILABLE /*16*/:
                                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                    J = zzc + 1;
                                    obj2[zzc] = N;
                                    break;
                                default:
                                    J = zzc;
                                    break;
                            }
                            i++;
                            zzc = J;
                        }
                        if (zzc != 0) {
                            J = this.zzxc == null ? 0 : this.zzxc.length;
                            if (J != 0 || zzc != zzc2) {
                                Object obj3 = new int[(J + zzc)];
                                if (J != 0) {
                                    System.arraycopy(this.zzxc, 0, obj3, 0, J);
                                }
                                System.arraycopy(obj2, 0, obj3, J, zzc);
                                this.zzxc = obj3;
                                break;
                            }
                            this.zzxc = obj2;
                            break;
                        }
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorPrimary /*82*/:
                        i = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            switch (com_google_android_gms_internal_zzaou.m46N()) {
                                case ConnectionResult.SERVICE_MISSING /*1*/:
                                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                                case ConnectionResult.SERVICE_DISABLED /*3*/:
                                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                                case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                                case ConnectionResult.NETWORK_ERROR /*7*/:
                                case ConnectionResult.INTERNAL_ERROR /*8*/:
                                case ConnectionResult.SERVICE_INVALID /*9*/:
                                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                case C0337R.styleable.Toolbar_titleMargins /*12*/:
                                case ConnectionResult.CANCELED /*13*/:
                                case ConnectionResult.TIMEOUT /*14*/:
                                case ConnectionResult.INTERRUPTED /*15*/:
                                case ConnectionResult.API_UNAVAILABLE /*16*/:
                                case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                    J++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (J != 0) {
                            com_google_android_gms_internal_zzaou.zzaek(zzc);
                            zzc = this.zzxc == null ? 0 : this.zzxc.length;
                            Object obj4 = new int[(J + zzc)];
                            if (zzc != 0) {
                                System.arraycopy(this.zzxc, 0, obj4, 0, zzc);
                            }
                            while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                                int N2 = com_google_android_gms_internal_zzaou.m46N();
                                switch (N2) {
                                    case ConnectionResult.SERVICE_MISSING /*1*/:
                                    case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                                    case ConnectionResult.INVALID_ACCOUNT /*5*/:
                                    case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                                    case ConnectionResult.NETWORK_ERROR /*7*/:
                                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                                    case ConnectionResult.SERVICE_INVALID /*9*/:
                                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                                    case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                                    case C0337R.styleable.Toolbar_titleMargins /*12*/:
                                    case ConnectionResult.CANCELED /*13*/:
                                    case ConnectionResult.TIMEOUT /*14*/:
                                    case ConnectionResult.INTERRUPTED /*15*/:
                                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                                    case ConnectionResult.SIGN_IN_FAILED /*17*/:
                                        J = zzc + 1;
                                        obj4[zzc] = N2;
                                        zzc = J;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzxc = obj4;
                        }
                        com_google_android_gms_internal_zzaou.zzaej(i);
                        continue;
                    case C0337R.styleable.AppCompatTheme_controlBackground /*90*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 90);
                        J = this.zzxb == null ? 0 : this.zzxb.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzxb, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzxb = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                        this.zzxa = com_google_android_gms_internal_zzaou.m48P();
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
            int zzy = super.zzy() + zzaov.zzag(1, this.type);
            if (!this.zzwt.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(2, this.zzwt);
            }
            if (this.zzwu != null && this.zzwu.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc : this.zzwu) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i += zzaov.zzc(3, com_google_android_gms_internal_zzapc);
                    }
                }
                zzy = i;
            }
            if (this.zzwv != null && this.zzwv.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc2 : this.zzwv) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        i += zzaov.zzc(4, com_google_android_gms_internal_zzapc2);
                    }
                }
                zzy = i;
            }
            if (this.zzww != null && this.zzww.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc22 : this.zzww) {
                    if (com_google_android_gms_internal_zzapc22 != null) {
                        i += zzaov.zzc(5, com_google_android_gms_internal_zzapc22);
                    }
                }
                zzy = i;
            }
            if (!this.zzwx.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(6, this.zzwx);
            }
            if (!this.zzwy.equals(BuildConfig.FLAVOR)) {
                zzy += zzaov.zzs(7, this.zzwy);
            }
            if (this.zzwz != 0) {
                zzy += zzaov.zze(8, this.zzwz);
            }
            if (this.zzxd) {
                zzy += zzaov.zzk(9, this.zzxd);
            }
            if (this.zzxc != null && this.zzxc.length > 0) {
                int i3 = 0;
                for (int zzaeo : this.zzxc) {
                    i3 += zzaov.zzaeo(zzaeo);
                }
                zzy = (zzy + i3) + (this.zzxc.length * 1);
            }
            if (this.zzxb != null && this.zzxb.length > 0) {
                while (i2 < this.zzxb.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.zzxb[i2];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        zzy += zzaov.zzc(11, com_google_android_gms_internal_zzapc3);
                    }
                    i2++;
                }
            }
            return this.zzxa ? zzy + zzaov.zzk(12, this.zzxa) : zzy;
        }
    }
}
