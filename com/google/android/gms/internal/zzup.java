package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzup {

    public static final class zza extends zzapc {
        private static volatile zza[] aoF;
        public Integer anW;
        public zzf aoG;
        public zzf aoH;
        public Boolean aoI;

        public zza() {
            zzbwp();
        }

        public static zza[] zzbwo() {
            if (aoF == null) {
                synchronized (zzapa.bij) {
                    if (aoF == null) {
                        aoF = new zza[0];
                    }
                }
            }
            return aoF;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzup_zza = (zza) obj;
            if (this.anW == null) {
                if (com_google_android_gms_internal_zzup_zza.anW != null) {
                    return false;
                }
            } else if (!this.anW.equals(com_google_android_gms_internal_zzup_zza.anW)) {
                return false;
            }
            if (this.aoG == null) {
                if (com_google_android_gms_internal_zzup_zza.aoG != null) {
                    return false;
                }
            } else if (!this.aoG.equals(com_google_android_gms_internal_zzup_zza.aoG)) {
                return false;
            }
            if (this.aoH == null) {
                if (com_google_android_gms_internal_zzup_zza.aoH != null) {
                    return false;
                }
            } else if (!this.aoH.equals(com_google_android_gms_internal_zzup_zza.aoH)) {
                return false;
            }
            return this.aoI == null ? com_google_android_gms_internal_zzup_zza.aoI == null : this.aoI.equals(com_google_android_gms_internal_zzup_zza.aoI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aoH == null ? 0 : this.aoH.hashCode()) + (((this.aoG == null ? 0 : this.aoG.hashCode()) + (((this.anW == null ? 0 : this.anW.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.aoI != null) {
                i = this.aoI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.anW != null) {
                com_google_android_gms_internal_zzaov.zzae(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.aoG);
            }
            if (this.aoH != null) {
                com_google_android_gms_internal_zzaov.zza(3, this.aoH);
            }
            if (this.aoI != null) {
                com_google_android_gms_internal_zzaov.zzj(4, this.aoI.booleanValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbm(com_google_android_gms_internal_zzaou);
        }

        public zza zzbm(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.anW = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.aoG == null) {
                            this.aoG = new zzf();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.aoG);
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        if (this.aoH == null) {
                            this.aoH = new zzf();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.aoH);
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.aoI = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
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

        public zza zzbwp() {
            this.anW = null;
            this.aoG = null;
            this.aoH = null;
            this.aoI = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.anW != null) {
                zzy += zzaov.zzag(1, this.anW.intValue());
            }
            if (this.aoG != null) {
                zzy += zzaov.zzc(2, this.aoG);
            }
            if (this.aoH != null) {
                zzy += zzaov.zzc(3, this.aoH);
            }
            return this.aoI != null ? zzy + zzaov.zzk(4, this.aoI.booleanValue()) : zzy;
        }
    }

    public static final class zzb extends zzapc {
        private static volatile zzb[] aoJ;
        public zzc[] aoK;
        public Long aoL;
        public Long aoM;
        public Integer count;
        public String name;

        public zzb() {
            zzbwr();
        }

        public static zzb[] zzbwq() {
            if (aoJ == null) {
                synchronized (zzapa.bij) {
                    if (aoJ == null) {
                        aoJ = new zzb[0];
                    }
                }
            }
            return aoJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzup_zzb = (zzb) obj;
            if (!zzapa.equals(this.aoK, com_google_android_gms_internal_zzup_zzb.aoK)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzup_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzup_zzb.name)) {
                return false;
            }
            if (this.aoL == null) {
                if (com_google_android_gms_internal_zzup_zzb.aoL != null) {
                    return false;
                }
            } else if (!this.aoL.equals(com_google_android_gms_internal_zzup_zzb.aoL)) {
                return false;
            }
            if (this.aoM == null) {
                if (com_google_android_gms_internal_zzup_zzb.aoM != null) {
                    return false;
                }
            } else if (!this.aoM.equals(com_google_android_gms_internal_zzup_zzb.aoM)) {
                return false;
            }
            return this.count == null ? com_google_android_gms_internal_zzup_zzb.count == null : this.count.equals(com_google_android_gms_internal_zzup_zzb.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aoM == null ? 0 : this.aoM.hashCode()) + (((this.aoL == null ? 0 : this.aoL.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.aoK)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.aoK != null && this.aoK.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoK) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.name != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.name);
            }
            if (this.aoL != null) {
                com_google_android_gms_internal_zzaov.zzb(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                com_google_android_gms_internal_zzaov.zzb(4, this.aoM.longValue());
            }
            if (this.count != null) {
                com_google_android_gms_internal_zzaov.zzae(5, this.count.intValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbn(com_google_android_gms_internal_zzaou);
        }

        public zzb zzbn(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.aoK == null ? 0 : this.aoK.length;
                        Object obj = new zzc[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoK, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzc();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzc();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoK = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.aoL = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.aoM = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.count = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
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

        public zzb zzbwr() {
            this.aoK = zzc.zzbws();
            this.name = null;
            this.aoL = null;
            this.aoM = null;
            this.count = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.aoK != null && this.aoK.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoK) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        zzy += zzaov.zzc(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.name != null) {
                zzy += zzaov.zzs(2, this.name);
            }
            if (this.aoL != null) {
                zzy += zzaov.zze(3, this.aoL.longValue());
            }
            if (this.aoM != null) {
                zzy += zzaov.zze(4, this.aoM.longValue());
            }
            return this.count != null ? zzy + zzaov.zzag(5, this.count.intValue()) : zzy;
        }
    }

    public static final class zzc extends zzapc {
        private static volatile zzc[] aoN;
        public Float anS;
        public Double anT;
        public Long aoO;
        public String name;
        public String zr;

        public zzc() {
            zzbwt();
        }

        public static zzc[] zzbws() {
            if (aoN == null) {
                synchronized (zzapa.bij) {
                    if (aoN == null) {
                        aoN = new zzc[0];
                    }
                }
            }
            return aoN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzup_zzc = (zzc) obj;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzup_zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzup_zzc.name)) {
                return false;
            }
            if (this.zr == null) {
                if (com_google_android_gms_internal_zzup_zzc.zr != null) {
                    return false;
                }
            } else if (!this.zr.equals(com_google_android_gms_internal_zzup_zzc.zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (com_google_android_gms_internal_zzup_zzc.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(com_google_android_gms_internal_zzup_zzc.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (com_google_android_gms_internal_zzup_zzc.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(com_google_android_gms_internal_zzup_zzc.anS)) {
                return false;
            }
            return this.anT == null ? com_google_android_gms_internal_zzup_zzc.anT == null : this.anT.equals(com_google_android_gms_internal_zzup_zzc.anT);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.zr == null ? 0 : this.zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.anT != null) {
                i = this.anT.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.name != null) {
                com_google_android_gms_internal_zzaov.zzr(1, this.name);
            }
            if (this.zr != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.zr);
            }
            if (this.aoO != null) {
                com_google_android_gms_internal_zzaov.zzb(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                com_google_android_gms_internal_zzaov.zzc(4, this.anS.floatValue());
            }
            if (this.anT != null) {
                com_google_android_gms_internal_zzaov.zza(5, this.anT.doubleValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbo(com_google_android_gms_internal_zzaou);
        }

        public zzc zzbo(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zr = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.aoO = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                        this.anS = Float.valueOf(com_google_android_gms_internal_zzaou.readFloat());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                        this.anT = Double.valueOf(com_google_android_gms_internal_zzaou.readDouble());
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

        public zzc zzbwt() {
            this.name = null;
            this.zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.name != null) {
                zzy += zzaov.zzs(1, this.name);
            }
            if (this.zr != null) {
                zzy += zzaov.zzs(2, this.zr);
            }
            if (this.aoO != null) {
                zzy += zzaov.zze(3, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzy += zzaov.zzd(4, this.anS.floatValue());
            }
            return this.anT != null ? zzy + zzaov.zzb(5, this.anT.doubleValue()) : zzy;
        }
    }

    public static final class zzd extends zzapc {
        public zze[] aoP;

        public zzd() {
            zzbwu();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            return zzapa.equals(this.aoP, ((zzd) obj).aoP);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.aoP);
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.aoP != null && this.aoP.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoP) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbp(com_google_android_gms_internal_zzaou);
        }

        public zzd zzbp(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.aoP == null ? 0 : this.aoP.length;
                        Object obj = new zze[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoP, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zze();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zze();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoP = obj;
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

        public zzd zzbwu() {
            this.aoP = zze.zzbwv();
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.aoP != null && this.aoP.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoP) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        zzy += zzaov.zzc(1, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            return zzy;
        }
    }

    public static final class zze extends zzapc {
        private static volatile zze[] aoQ;
        public String abU;
        public String ajA;
        public String ajD;
        public String ajH;
        public String ajz;
        public Integer aoR;
        public zzb[] aoS;
        public zzg[] aoT;
        public Long aoU;
        public Long aoV;
        public Long aoW;
        public Long aoX;
        public Long aoY;
        public String aoZ;
        public String apa;
        public String apb;
        public Integer apc;
        public Long apd;
        public Long ape;
        public String apf;
        public Boolean apg;
        public String aph;
        public Long api;
        public Integer apj;
        public Boolean apk;
        public zza[] apl;
        public Integer apm;
        public Integer apn;
        public Integer apo;
        public String app;
        public String zzck;
        public String zzct;

        public zze() {
            zzbww();
        }

        public static zze[] zzbwv() {
            if (aoQ == null) {
                synchronized (zzapa.bij) {
                    if (aoQ == null) {
                        aoQ = new zze[0];
                    }
                }
            }
            return aoQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzup_zze = (zze) obj;
            if (this.aoR == null) {
                if (com_google_android_gms_internal_zzup_zze.aoR != null) {
                    return false;
                }
            } else if (!this.aoR.equals(com_google_android_gms_internal_zzup_zze.aoR)) {
                return false;
            }
            if (!zzapa.equals(this.aoS, com_google_android_gms_internal_zzup_zze.aoS)) {
                return false;
            }
            if (!zzapa.equals(this.aoT, com_google_android_gms_internal_zzup_zze.aoT)) {
                return false;
            }
            if (this.aoU == null) {
                if (com_google_android_gms_internal_zzup_zze.aoU != null) {
                    return false;
                }
            } else if (!this.aoU.equals(com_google_android_gms_internal_zzup_zze.aoU)) {
                return false;
            }
            if (this.aoV == null) {
                if (com_google_android_gms_internal_zzup_zze.aoV != null) {
                    return false;
                }
            } else if (!this.aoV.equals(com_google_android_gms_internal_zzup_zze.aoV)) {
                return false;
            }
            if (this.aoW == null) {
                if (com_google_android_gms_internal_zzup_zze.aoW != null) {
                    return false;
                }
            } else if (!this.aoW.equals(com_google_android_gms_internal_zzup_zze.aoW)) {
                return false;
            }
            if (this.aoX == null) {
                if (com_google_android_gms_internal_zzup_zze.aoX != null) {
                    return false;
                }
            } else if (!this.aoX.equals(com_google_android_gms_internal_zzup_zze.aoX)) {
                return false;
            }
            if (this.aoY == null) {
                if (com_google_android_gms_internal_zzup_zze.aoY != null) {
                    return false;
                }
            } else if (!this.aoY.equals(com_google_android_gms_internal_zzup_zze.aoY)) {
                return false;
            }
            if (this.aoZ == null) {
                if (com_google_android_gms_internal_zzup_zze.aoZ != null) {
                    return false;
                }
            } else if (!this.aoZ.equals(com_google_android_gms_internal_zzup_zze.aoZ)) {
                return false;
            }
            if (this.zzct == null) {
                if (com_google_android_gms_internal_zzup_zze.zzct != null) {
                    return false;
                }
            } else if (!this.zzct.equals(com_google_android_gms_internal_zzup_zze.zzct)) {
                return false;
            }
            if (this.apa == null) {
                if (com_google_android_gms_internal_zzup_zze.apa != null) {
                    return false;
                }
            } else if (!this.apa.equals(com_google_android_gms_internal_zzup_zze.apa)) {
                return false;
            }
            if (this.apb == null) {
                if (com_google_android_gms_internal_zzup_zze.apb != null) {
                    return false;
                }
            } else if (!this.apb.equals(com_google_android_gms_internal_zzup_zze.apb)) {
                return false;
            }
            if (this.apc == null) {
                if (com_google_android_gms_internal_zzup_zze.apc != null) {
                    return false;
                }
            } else if (!this.apc.equals(com_google_android_gms_internal_zzup_zze.apc)) {
                return false;
            }
            if (this.ajA == null) {
                if (com_google_android_gms_internal_zzup_zze.ajA != null) {
                    return false;
                }
            } else if (!this.ajA.equals(com_google_android_gms_internal_zzup_zze.ajA)) {
                return false;
            }
            if (this.zzck == null) {
                if (com_google_android_gms_internal_zzup_zze.zzck != null) {
                    return false;
                }
            } else if (!this.zzck.equals(com_google_android_gms_internal_zzup_zze.zzck)) {
                return false;
            }
            if (this.abU == null) {
                if (com_google_android_gms_internal_zzup_zze.abU != null) {
                    return false;
                }
            } else if (!this.abU.equals(com_google_android_gms_internal_zzup_zze.abU)) {
                return false;
            }
            if (this.apd == null) {
                if (com_google_android_gms_internal_zzup_zze.apd != null) {
                    return false;
                }
            } else if (!this.apd.equals(com_google_android_gms_internal_zzup_zze.apd)) {
                return false;
            }
            if (this.ape == null) {
                if (com_google_android_gms_internal_zzup_zze.ape != null) {
                    return false;
                }
            } else if (!this.ape.equals(com_google_android_gms_internal_zzup_zze.ape)) {
                return false;
            }
            if (this.apf == null) {
                if (com_google_android_gms_internal_zzup_zze.apf != null) {
                    return false;
                }
            } else if (!this.apf.equals(com_google_android_gms_internal_zzup_zze.apf)) {
                return false;
            }
            if (this.apg == null) {
                if (com_google_android_gms_internal_zzup_zze.apg != null) {
                    return false;
                }
            } else if (!this.apg.equals(com_google_android_gms_internal_zzup_zze.apg)) {
                return false;
            }
            if (this.aph == null) {
                if (com_google_android_gms_internal_zzup_zze.aph != null) {
                    return false;
                }
            } else if (!this.aph.equals(com_google_android_gms_internal_zzup_zze.aph)) {
                return false;
            }
            if (this.api == null) {
                if (com_google_android_gms_internal_zzup_zze.api != null) {
                    return false;
                }
            } else if (!this.api.equals(com_google_android_gms_internal_zzup_zze.api)) {
                return false;
            }
            if (this.apj == null) {
                if (com_google_android_gms_internal_zzup_zze.apj != null) {
                    return false;
                }
            } else if (!this.apj.equals(com_google_android_gms_internal_zzup_zze.apj)) {
                return false;
            }
            if (this.ajD == null) {
                if (com_google_android_gms_internal_zzup_zze.ajD != null) {
                    return false;
                }
            } else if (!this.ajD.equals(com_google_android_gms_internal_zzup_zze.ajD)) {
                return false;
            }
            if (this.ajz == null) {
                if (com_google_android_gms_internal_zzup_zze.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(com_google_android_gms_internal_zzup_zze.ajz)) {
                return false;
            }
            if (this.apk == null) {
                if (com_google_android_gms_internal_zzup_zze.apk != null) {
                    return false;
                }
            } else if (!this.apk.equals(com_google_android_gms_internal_zzup_zze.apk)) {
                return false;
            }
            if (!zzapa.equals(this.apl, com_google_android_gms_internal_zzup_zze.apl)) {
                return false;
            }
            if (this.ajH == null) {
                if (com_google_android_gms_internal_zzup_zze.ajH != null) {
                    return false;
                }
            } else if (!this.ajH.equals(com_google_android_gms_internal_zzup_zze.ajH)) {
                return false;
            }
            if (this.apm == null) {
                if (com_google_android_gms_internal_zzup_zze.apm != null) {
                    return false;
                }
            } else if (!this.apm.equals(com_google_android_gms_internal_zzup_zze.apm)) {
                return false;
            }
            if (this.apn == null) {
                if (com_google_android_gms_internal_zzup_zze.apn != null) {
                    return false;
                }
            } else if (!this.apn.equals(com_google_android_gms_internal_zzup_zze.apn)) {
                return false;
            }
            if (this.apo == null) {
                if (com_google_android_gms_internal_zzup_zze.apo != null) {
                    return false;
                }
            } else if (!this.apo.equals(com_google_android_gms_internal_zzup_zze.apo)) {
                return false;
            }
            return this.app == null ? com_google_android_gms_internal_zzup_zze.app == null : this.app.equals(com_google_android_gms_internal_zzup_zze.app);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.apo == null ? 0 : this.apo.hashCode()) + (((this.apn == null ? 0 : this.apn.hashCode()) + (((this.apm == null ? 0 : this.apm.hashCode()) + (((this.ajH == null ? 0 : this.ajH.hashCode()) + (((((this.apk == null ? 0 : this.apk.hashCode()) + (((this.ajz == null ? 0 : this.ajz.hashCode()) + (((this.ajD == null ? 0 : this.ajD.hashCode()) + (((this.apj == null ? 0 : this.apj.hashCode()) + (((this.api == null ? 0 : this.api.hashCode()) + (((this.aph == null ? 0 : this.aph.hashCode()) + (((this.apg == null ? 0 : this.apg.hashCode()) + (((this.apf == null ? 0 : this.apf.hashCode()) + (((this.ape == null ? 0 : this.ape.hashCode()) + (((this.apd == null ? 0 : this.apd.hashCode()) + (((this.abU == null ? 0 : this.abU.hashCode()) + (((this.zzck == null ? 0 : this.zzck.hashCode()) + (((this.ajA == null ? 0 : this.ajA.hashCode()) + (((this.apc == null ? 0 : this.apc.hashCode()) + (((this.apb == null ? 0 : this.apb.hashCode()) + (((this.apa == null ? 0 : this.apa.hashCode()) + (((this.zzct == null ? 0 : this.zzct.hashCode()) + (((this.aoZ == null ? 0 : this.aoZ.hashCode()) + (((this.aoY == null ? 0 : this.aoY.hashCode()) + (((this.aoX == null ? 0 : this.aoX.hashCode()) + (((this.aoW == null ? 0 : this.aoW.hashCode()) + (((this.aoV == null ? 0 : this.aoV.hashCode()) + (((this.aoU == null ? 0 : this.aoU.hashCode()) + (((((((this.aoR == null ? 0 : this.aoR.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzapa.hashCode(this.aoS)) * 31) + zzapa.hashCode(this.aoT)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzapa.hashCode(this.apl)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.app != null) {
                i = this.app.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.aoR != null) {
                com_google_android_gms_internal_zzaov.zzae(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.aoS) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(2, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.aoT != null && this.aoT.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc2 : this.aoT) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        com_google_android_gms_internal_zzaov.zza(3, com_google_android_gms_internal_zzapc2);
                    }
                }
            }
            if (this.aoU != null) {
                com_google_android_gms_internal_zzaov.zzb(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                com_google_android_gms_internal_zzaov.zzb(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                com_google_android_gms_internal_zzaov.zzb(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                com_google_android_gms_internal_zzaov.zzb(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                com_google_android_gms_internal_zzaov.zzr(8, this.aoZ);
            }
            if (this.zzct != null) {
                com_google_android_gms_internal_zzaov.zzr(9, this.zzct);
            }
            if (this.apa != null) {
                com_google_android_gms_internal_zzaov.zzr(10, this.apa);
            }
            if (this.apb != null) {
                com_google_android_gms_internal_zzaov.zzr(11, this.apb);
            }
            if (this.apc != null) {
                com_google_android_gms_internal_zzaov.zzae(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                com_google_android_gms_internal_zzaov.zzr(13, this.ajA);
            }
            if (this.zzck != null) {
                com_google_android_gms_internal_zzaov.zzr(14, this.zzck);
            }
            if (this.abU != null) {
                com_google_android_gms_internal_zzaov.zzr(16, this.abU);
            }
            if (this.apd != null) {
                com_google_android_gms_internal_zzaov.zzb(17, this.apd.longValue());
            }
            if (this.ape != null) {
                com_google_android_gms_internal_zzaov.zzb(18, this.ape.longValue());
            }
            if (this.apf != null) {
                com_google_android_gms_internal_zzaov.zzr(19, this.apf);
            }
            if (this.apg != null) {
                com_google_android_gms_internal_zzaov.zzj(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                com_google_android_gms_internal_zzaov.zzr(21, this.aph);
            }
            if (this.api != null) {
                com_google_android_gms_internal_zzaov.zzb(22, this.api.longValue());
            }
            if (this.apj != null) {
                com_google_android_gms_internal_zzaov.zzae(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                com_google_android_gms_internal_zzaov.zzr(24, this.ajD);
            }
            if (this.ajz != null) {
                com_google_android_gms_internal_zzaov.zzr(25, this.ajz);
            }
            if (this.aoX != null) {
                com_google_android_gms_internal_zzaov.zzb(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                com_google_android_gms_internal_zzaov.zzj(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                while (i < this.apl.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.apl[i];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        com_google_android_gms_internal_zzaov.zza(29, com_google_android_gms_internal_zzapc3);
                    }
                    i++;
                }
            }
            if (this.ajH != null) {
                com_google_android_gms_internal_zzaov.zzr(30, this.ajH);
            }
            if (this.apm != null) {
                com_google_android_gms_internal_zzaov.zzae(31, this.apm.intValue());
            }
            if (this.apn != null) {
                com_google_android_gms_internal_zzaov.zzae(32, this.apn.intValue());
            }
            if (this.apo != null) {
                com_google_android_gms_internal_zzaov.zzae(33, this.apo.intValue());
            }
            if (this.app != null) {
                com_google_android_gms_internal_zzaov.zzr(34, this.app);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbq(com_google_android_gms_internal_zzaou);
        }

        public zze zzbq(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                Object obj;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.aoR = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 18);
                        J = this.aoS == null ? 0 : this.aoS.length;
                        obj = new zzb[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoS, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzb();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzb();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoS = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 26);
                        J = this.aoT == null ? 0 : this.aoT.length;
                        obj = new zzg[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.aoT, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zzg();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zzg();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.aoT = obj;
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.aoU = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.aoV = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.aoW = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_dividerHorizontal /*56*/:
                        this.aoY = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                        this.aoZ = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_dropDownListViewStyle /*74*/:
                        this.zzct = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorPrimary /*82*/:
                        this.apa = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_controlBackground /*90*/:
                        this.apb = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                        this.apc = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case C0337R.styleable.AppCompatTheme_ratingBarStyle /*106*/:
                        this.ajA = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 114:
                        this.zzck = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        this.abU = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 136:
                        this.apd = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 144:
                        this.ape = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 154:
                        this.apf = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 160:
                        this.apg = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    case 170:
                        this.aph = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 176:
                        this.api = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 184:
                        this.apj = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case 194:
                        this.ajD = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 202:
                        this.ajz = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 208:
                        this.aoX = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 224:
                        this.apk = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    case 234:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 234);
                        J = this.apl == null ? 0 : this.apl.length;
                        obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.apl, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.apl = obj;
                        continue;
                    case 242:
                        this.ajH = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 248:
                        this.apm = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY /*256*/:
                        this.apn = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case 264:
                        this.apo = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case 274:
                        this.app = com_google_android_gms_internal_zzaou.readString();
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

        public zze zzbww() {
            this.aoR = null;
            this.aoS = zzb.zzbwq();
            this.aoT = zzg.zzbwy();
            this.aoU = null;
            this.aoV = null;
            this.aoW = null;
            this.aoX = null;
            this.aoY = null;
            this.aoZ = null;
            this.zzct = null;
            this.apa = null;
            this.apb = null;
            this.apc = null;
            this.ajA = null;
            this.zzck = null;
            this.abU = null;
            this.apd = null;
            this.ape = null;
            this.apf = null;
            this.apg = null;
            this.aph = null;
            this.api = null;
            this.apj = null;
            this.ajD = null;
            this.ajz = null;
            this.apk = null;
            this.apl = zza.zzbwo();
            this.ajH = null;
            this.apm = null;
            this.apn = null;
            this.apo = null;
            this.app = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int i;
            int i2 = 0;
            int zzy = super.zzy();
            if (this.aoR != null) {
                zzy += zzaov.zzag(1, this.aoR.intValue());
            }
            if (this.aoS != null && this.aoS.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc : this.aoS) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i += zzaov.zzc(2, com_google_android_gms_internal_zzapc);
                    }
                }
                zzy = i;
            }
            if (this.aoT != null && this.aoT.length > 0) {
                i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc2 : this.aoT) {
                    if (com_google_android_gms_internal_zzapc2 != null) {
                        i += zzaov.zzc(3, com_google_android_gms_internal_zzapc2);
                    }
                }
                zzy = i;
            }
            if (this.aoU != null) {
                zzy += zzaov.zze(4, this.aoU.longValue());
            }
            if (this.aoV != null) {
                zzy += zzaov.zze(5, this.aoV.longValue());
            }
            if (this.aoW != null) {
                zzy += zzaov.zze(6, this.aoW.longValue());
            }
            if (this.aoY != null) {
                zzy += zzaov.zze(7, this.aoY.longValue());
            }
            if (this.aoZ != null) {
                zzy += zzaov.zzs(8, this.aoZ);
            }
            if (this.zzct != null) {
                zzy += zzaov.zzs(9, this.zzct);
            }
            if (this.apa != null) {
                zzy += zzaov.zzs(10, this.apa);
            }
            if (this.apb != null) {
                zzy += zzaov.zzs(11, this.apb);
            }
            if (this.apc != null) {
                zzy += zzaov.zzag(12, this.apc.intValue());
            }
            if (this.ajA != null) {
                zzy += zzaov.zzs(13, this.ajA);
            }
            if (this.zzck != null) {
                zzy += zzaov.zzs(14, this.zzck);
            }
            if (this.abU != null) {
                zzy += zzaov.zzs(16, this.abU);
            }
            if (this.apd != null) {
                zzy += zzaov.zze(17, this.apd.longValue());
            }
            if (this.ape != null) {
                zzy += zzaov.zze(18, this.ape.longValue());
            }
            if (this.apf != null) {
                zzy += zzaov.zzs(19, this.apf);
            }
            if (this.apg != null) {
                zzy += zzaov.zzk(20, this.apg.booleanValue());
            }
            if (this.aph != null) {
                zzy += zzaov.zzs(21, this.aph);
            }
            if (this.api != null) {
                zzy += zzaov.zze(22, this.api.longValue());
            }
            if (this.apj != null) {
                zzy += zzaov.zzag(23, this.apj.intValue());
            }
            if (this.ajD != null) {
                zzy += zzaov.zzs(24, this.ajD);
            }
            if (this.ajz != null) {
                zzy += zzaov.zzs(25, this.ajz);
            }
            if (this.aoX != null) {
                zzy += zzaov.zze(26, this.aoX.longValue());
            }
            if (this.apk != null) {
                zzy += zzaov.zzk(28, this.apk.booleanValue());
            }
            if (this.apl != null && this.apl.length > 0) {
                while (i2 < this.apl.length) {
                    zzapc com_google_android_gms_internal_zzapc3 = this.apl[i2];
                    if (com_google_android_gms_internal_zzapc3 != null) {
                        zzy += zzaov.zzc(29, com_google_android_gms_internal_zzapc3);
                    }
                    i2++;
                }
            }
            if (this.ajH != null) {
                zzy += zzaov.zzs(30, this.ajH);
            }
            if (this.apm != null) {
                zzy += zzaov.zzag(31, this.apm.intValue());
            }
            if (this.apn != null) {
                zzy += zzaov.zzag(32, this.apn.intValue());
            }
            if (this.apo != null) {
                zzy += zzaov.zzag(33, this.apo.intValue());
            }
            return this.app != null ? zzy + zzaov.zzs(34, this.app) : zzy;
        }
    }

    public static final class zzf extends zzapc {
        public long[] apq;
        public long[] apr;

        public zzf() {
            zzbwx();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzup_zzf = (zzf) obj;
            return !zzapa.equals(this.apq, com_google_android_gms_internal_zzup_zzf.apq) ? false : zzapa.equals(this.apr, com_google_android_gms_internal_zzup_zzf.apr);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzapa.hashCode(this.apq)) * 31) + zzapa.hashCode(this.apr);
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            int i = 0;
            if (this.apq != null && this.apq.length > 0) {
                for (long zza : this.apq) {
                    com_google_android_gms_internal_zzaov.zza(1, zza);
                }
            }
            if (this.apr != null && this.apr.length > 0) {
                while (i < this.apr.length) {
                    com_google_android_gms_internal_zzaov.zza(2, this.apr[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbr(com_google_android_gms_internal_zzaou);
        }

        public zzf zzbr(zzaou com_google_android_gms_internal_zzaou) throws IOException {
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
                        J = this.apq == null ? 0 : this.apq.length;
                        obj = new long[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.apq, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m44L();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m44L();
                        this.apq = obj;
                        continue;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m44L();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.apq == null ? 0 : this.apq.length;
                        obj2 = new long[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.apq, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m44L();
                            zzc++;
                        }
                        this.apq = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 16);
                        J = this.apr == null ? 0 : this.apr.length;
                        obj = new long[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.apr, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m44L();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m44L();
                        this.apr = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m44L();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.apr == null ? 0 : this.apr.length;
                        obj2 = new long[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.apr, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m44L();
                            zzc++;
                        }
                        this.apr = obj2;
                        com_google_android_gms_internal_zzaou.zzaej(zzaei);
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

        public zzf zzbwx() {
            this.apq = zzapf.bin;
            this.apr = zzapf.bin;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int i;
            int i2;
            int i3 = 0;
            int zzy = super.zzy();
            if (this.apq == null || this.apq.length <= 0) {
                i = zzy;
            } else {
                i2 = 0;
                for (long zzcv : this.apq) {
                    i2 += zzaov.zzcv(zzcv);
                }
                i = (zzy + i2) + (this.apq.length * 1);
            }
            if (this.apr == null || this.apr.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.apr.length) {
                i2 += zzaov.zzcv(this.apr[i3]);
                i3++;
            }
            return (i + i2) + (this.apr.length * 1);
        }
    }

    public static final class zzg extends zzapc {
        private static volatile zzg[] aps;
        public Float anS;
        public Double anT;
        public Long aoO;
        public Long apt;
        public String name;
        public String zr;

        public zzg() {
            zzbwz();
        }

        public static zzg[] zzbwy() {
            if (aps == null) {
                synchronized (zzapa.bij) {
                    if (aps == null) {
                        aps = new zzg[0];
                    }
                }
            }
            return aps;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzup_zzg = (zzg) obj;
            if (this.apt == null) {
                if (com_google_android_gms_internal_zzup_zzg.apt != null) {
                    return false;
                }
            } else if (!this.apt.equals(com_google_android_gms_internal_zzup_zzg.apt)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzup_zzg.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzup_zzg.name)) {
                return false;
            }
            if (this.zr == null) {
                if (com_google_android_gms_internal_zzup_zzg.zr != null) {
                    return false;
                }
            } else if (!this.zr.equals(com_google_android_gms_internal_zzup_zzg.zr)) {
                return false;
            }
            if (this.aoO == null) {
                if (com_google_android_gms_internal_zzup_zzg.aoO != null) {
                    return false;
                }
            } else if (!this.aoO.equals(com_google_android_gms_internal_zzup_zzg.aoO)) {
                return false;
            }
            if (this.anS == null) {
                if (com_google_android_gms_internal_zzup_zzg.anS != null) {
                    return false;
                }
            } else if (!this.anS.equals(com_google_android_gms_internal_zzup_zzg.anS)) {
                return false;
            }
            return this.anT == null ? com_google_android_gms_internal_zzup_zzg.anT == null : this.anT.equals(com_google_android_gms_internal_zzup_zzg.anT);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anS == null ? 0 : this.anS.hashCode()) + (((this.aoO == null ? 0 : this.aoO.hashCode()) + (((this.zr == null ? 0 : this.zr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.apt == null ? 0 : this.apt.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.anT != null) {
                i = this.anT.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.apt != null) {
                com_google_android_gms_internal_zzaov.zzb(1, this.apt.longValue());
            }
            if (this.name != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.name);
            }
            if (this.zr != null) {
                com_google_android_gms_internal_zzaov.zzr(3, this.zr);
            }
            if (this.aoO != null) {
                com_google_android_gms_internal_zzaov.zzb(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                com_google_android_gms_internal_zzaov.zzc(5, this.anS.floatValue());
            }
            if (this.anT != null) {
                com_google_android_gms_internal_zzaov.zza(6, this.anT.doubleValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbs(com_google_android_gms_internal_zzaou);
        }

        public zzg zzbs(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.apt = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.name = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        this.zr = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.aoO = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                        this.anS = Float.valueOf(com_google_android_gms_internal_zzaou.readFloat());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionButtonStyle /*49*/:
                        this.anT = Double.valueOf(com_google_android_gms_internal_zzaou.readDouble());
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

        public zzg zzbwz() {
            this.apt = null;
            this.name = null;
            this.zr = null;
            this.aoO = null;
            this.anS = null;
            this.anT = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.apt != null) {
                zzy += zzaov.zze(1, this.apt.longValue());
            }
            if (this.name != null) {
                zzy += zzaov.zzs(2, this.name);
            }
            if (this.zr != null) {
                zzy += zzaov.zzs(3, this.zr);
            }
            if (this.aoO != null) {
                zzy += zzaov.zze(4, this.aoO.longValue());
            }
            if (this.anS != null) {
                zzy += zzaov.zzd(5, this.anS.floatValue());
            }
            return this.anT != null ? zzy + zzaov.zzb(6, this.anT.doubleValue()) : zzy;
        }
    }
}
