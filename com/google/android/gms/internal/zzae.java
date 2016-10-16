package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzae {

    public static final class zza extends zzaow<zza> {
        public String zzcs;
        public String zzct;
        public Long zzcu;
        public Long zzcv;
        public Long zzcw;
        public Long zzcx;
        public Long zzcy;
        public Long zzcz;
        public Long zzda;
        public Long zzdb;
        public Long zzdc;
        public Long zzdd;
        public String zzde;
        public Long zzdf;
        public Long zzdg;
        public Long zzdh;
        public Long zzdi;
        public Long zzdj;
        public Long zzdk;
        public Long zzdl;
        public Long zzdm;
        public Long zzdn;
        public String zzdo;
        public String zzdp;
        public Long zzdq;
        public Long zzdr;
        public Long zzds;
        public String zzdt;
        public Long zzdu;
        public Long zzdv;
        public Long zzdw;
        public zzb zzdx;
        public Long zzdy;
        public Long zzdz;
        public Long zzea;
        public Long zzeb;
        public Long zzec;
        public Long zzed;
        public zza[] zzee;
        public Long zzef;
        public String zzeg;
        public Integer zzeh;
        public Boolean zzei;
        public String zzej;
        public Long zzek;
        public zze zzel;

        public static final class zza extends zzaow<zza> {
            private static volatile zza[] zzem;
            public Long zzdf;
            public Long zzdg;

            public zza() {
                this.zzdf = null;
                this.zzdg = null;
                this.bik = -1;
            }

            public static zza[] zzz() {
                if (zzem == null) {
                    synchronized (zzapa.bij) {
                        if (zzem == null) {
                            zzem = new zza[0];
                        }
                    }
                }
                return zzem;
            }

            public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
                if (this.zzdf != null) {
                    com_google_android_gms_internal_zzaov.zzb(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    com_google_android_gms_internal_zzaov.zzb(2, this.zzdg.longValue());
                }
                super.zza(com_google_android_gms_internal_zzaov);
            }

            public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
                return zzd(com_google_android_gms_internal_zzaou);
            }

            public zza zzd(zzaou com_google_android_gms_internal_zzaou) throws IOException {
                while (true) {
                    int J = com_google_android_gms_internal_zzaou.m42J();
                    switch (J) {
                        case ConnectionResult.SUCCESS /*0*/:
                            break;
                        case ConnectionResult.INTERNAL_ERROR /*8*/:
                            this.zzdf = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                            continue;
                        case ConnectionResult.API_UNAVAILABLE /*16*/:
                            this.zzdg = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
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
                if (this.zzdf != null) {
                    zzy += zzaov.zze(1, this.zzdf.longValue());
                }
                return this.zzdg != null ? zzy + zzaov.zze(2, this.zzdg.longValue()) : zzy;
            }
        }

        public zza() {
            this.zzct = null;
            this.zzcs = null;
            this.zzcu = null;
            this.zzcv = null;
            this.zzcw = null;
            this.zzcx = null;
            this.zzcy = null;
            this.zzcz = null;
            this.zzda = null;
            this.zzdb = null;
            this.zzdc = null;
            this.zzdd = null;
            this.zzde = null;
            this.zzdf = null;
            this.zzdg = null;
            this.zzdh = null;
            this.zzdi = null;
            this.zzdj = null;
            this.zzdk = null;
            this.zzdl = null;
            this.zzdm = null;
            this.zzdn = null;
            this.zzdo = null;
            this.zzdp = null;
            this.zzdq = null;
            this.zzdr = null;
            this.zzds = null;
            this.zzdt = null;
            this.zzdu = null;
            this.zzdv = null;
            this.zzdw = null;
            this.zzdy = null;
            this.zzdz = null;
            this.zzea = null;
            this.zzeb = null;
            this.zzec = null;
            this.zzed = null;
            this.zzee = zza.zzz();
            this.zzef = null;
            this.zzeg = null;
            this.zzeh = null;
            this.zzei = null;
            this.zzej = null;
            this.zzek = null;
            this.bik = -1;
        }

        public static zza zzc(byte[] bArr) throws zzapb {
            return (zza) zzapc.zza(new zza(), bArr);
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzct != null) {
                com_google_android_gms_internal_zzaov.zzr(1, this.zzct);
            }
            if (this.zzcs != null) {
                com_google_android_gms_internal_zzaov.zzr(2, this.zzcs);
            }
            if (this.zzcu != null) {
                com_google_android_gms_internal_zzaov.zzb(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                com_google_android_gms_internal_zzaov.zzb(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                com_google_android_gms_internal_zzaov.zzb(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                com_google_android_gms_internal_zzaov.zzb(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                com_google_android_gms_internal_zzaov.zzb(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                com_google_android_gms_internal_zzaov.zzb(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                com_google_android_gms_internal_zzaov.zzb(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                com_google_android_gms_internal_zzaov.zzb(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                com_google_android_gms_internal_zzaov.zzb(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                com_google_android_gms_internal_zzaov.zzb(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                com_google_android_gms_internal_zzaov.zzr(13, this.zzde);
            }
            if (this.zzdf != null) {
                com_google_android_gms_internal_zzaov.zzb(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                com_google_android_gms_internal_zzaov.zzb(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                com_google_android_gms_internal_zzaov.zzb(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                com_google_android_gms_internal_zzaov.zzb(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                com_google_android_gms_internal_zzaov.zzb(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                com_google_android_gms_internal_zzaov.zzb(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                com_google_android_gms_internal_zzaov.zzb(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                com_google_android_gms_internal_zzaov.zzb(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                com_google_android_gms_internal_zzaov.zzb(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                com_google_android_gms_internal_zzaov.zzb(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                com_google_android_gms_internal_zzaov.zzr(24, this.zzeg);
            }
            if (this.zzek != null) {
                com_google_android_gms_internal_zzaov.zzb(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                com_google_android_gms_internal_zzaov.zzae(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                com_google_android_gms_internal_zzaov.zzr(27, this.zzdo);
            }
            if (this.zzei != null) {
                com_google_android_gms_internal_zzaov.zzj(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                com_google_android_gms_internal_zzaov.zzr(29, this.zzdp);
            }
            if (this.zzej != null) {
                com_google_android_gms_internal_zzaov.zzr(30, this.zzej);
            }
            if (this.zzdq != null) {
                com_google_android_gms_internal_zzaov.zzb(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                com_google_android_gms_internal_zzaov.zzb(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                com_google_android_gms_internal_zzaov.zzb(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                com_google_android_gms_internal_zzaov.zzr(34, this.zzdt);
            }
            if (this.zzdu != null) {
                com_google_android_gms_internal_zzaov.zzb(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                com_google_android_gms_internal_zzaov.zzb(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                com_google_android_gms_internal_zzaov.zzb(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                com_google_android_gms_internal_zzaov.zza(38, this.zzdx);
            }
            if (this.zzdy != null) {
                com_google_android_gms_internal_zzaov.zzb(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                com_google_android_gms_internal_zzaov.zzb(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                com_google_android_gms_internal_zzaov.zzb(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                com_google_android_gms_internal_zzaov.zzb(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                for (zzapc com_google_android_gms_internal_zzapc : this.zzee) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        com_google_android_gms_internal_zzaov.zza(43, com_google_android_gms_internal_zzapc);
                    }
                }
            }
            if (this.zzec != null) {
                com_google_android_gms_internal_zzaov.zzb(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                com_google_android_gms_internal_zzaov.zzb(45, this.zzed.longValue());
            }
            if (this.zzel != null) {
                com_google_android_gms_internal_zzaov.zza(201, this.zzel);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzc(com_google_android_gms_internal_zzaou);
        }

        public zza zzc(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzct = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzcs = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.zzcu = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        this.zzcv = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        this.zzcw = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zzcx = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_dividerHorizontal /*56*/:
                        this.zzcy = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_FAST_FORWARD /*64*/:
                        this.zzcz = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                        this.zzda = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_panelMenuListTheme /*80*/:
                        this.zzdb = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorButtonNormal /*88*/:
                        this.zzdc = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                        this.zzdd = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_ratingBarStyle /*106*/:
                        this.zzde = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 112:
                        this.zzdf = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 120:
                        this.zzdg = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case TransportMediator.FLAG_KEY_MEDIA_NEXT /*128*/:
                        this.zzdh = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 136:
                        this.zzdi = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 144:
                        this.zzdj = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 152:
                        this.zzdk = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 160:
                        this.zzdl = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 168:
                        this.zzef = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 176:
                        this.zzdm = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 184:
                        this.zzdn = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 194:
                        this.zzeg = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case Callback.DEFAULT_DRAG_ANIMATION_DURATION /*200*/:
                        this.zzek = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 208:
                        J = com_google_android_gms_internal_zzaou.m46N();
                        switch (J) {
                            case ConnectionResult.SUCCESS /*0*/:
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                            case ConnectionResult.SERVICE_DISABLED /*3*/:
                            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                                this.zzeh = Integer.valueOf(J);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzdo = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 224:
                        this.zzei = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    case 234:
                        this.zzdp = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 242:
                        this.zzej = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 248:
                        this.zzdq = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY /*256*/:
                        this.zzdr = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 264:
                        this.zzds = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 274:
                        this.zzdt = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case 280:
                        this.zzdu = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 288:
                        this.zzdv = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 296:
                        this.zzdw = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzdx);
                        continue;
                    case 312:
                        this.zzdy = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 320:
                        this.zzdz = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 328:
                        this.zzea = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 336:
                        this.zzeb = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 346:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 346);
                        J = this.zzee == null ? 0 : this.zzee.length;
                        Object obj = new zza[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzee, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = new zza();
                            com_google_android_gms_internal_zzaou.zza(obj[J]);
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = new zza();
                        com_google_android_gms_internal_zzaou.zza(obj[J]);
                        this.zzee = obj;
                        continue;
                    case 352:
                        this.zzec = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 360:
                        this.zzed = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case 1610:
                        if (this.zzel == null) {
                            this.zzel = new zze();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzel);
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
            if (this.zzct != null) {
                zzy += zzaov.zzs(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzy += zzaov.zzs(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzy += zzaov.zze(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzy += zzaov.zze(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzy += zzaov.zze(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzy += zzaov.zze(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzy += zzaov.zze(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzy += zzaov.zze(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzy += zzaov.zze(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzy += zzaov.zze(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzy += zzaov.zze(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzy += zzaov.zze(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzy += zzaov.zzs(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzy += zzaov.zze(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzy += zzaov.zze(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzy += zzaov.zze(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzy += zzaov.zze(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzy += zzaov.zze(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzy += zzaov.zze(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzy += zzaov.zze(20, this.zzdl.longValue());
            }
            if (this.zzef != null) {
                zzy += zzaov.zze(21, this.zzef.longValue());
            }
            if (this.zzdm != null) {
                zzy += zzaov.zze(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzy += zzaov.zze(23, this.zzdn.longValue());
            }
            if (this.zzeg != null) {
                zzy += zzaov.zzs(24, this.zzeg);
            }
            if (this.zzek != null) {
                zzy += zzaov.zze(25, this.zzek.longValue());
            }
            if (this.zzeh != null) {
                zzy += zzaov.zzag(26, this.zzeh.intValue());
            }
            if (this.zzdo != null) {
                zzy += zzaov.zzs(27, this.zzdo);
            }
            if (this.zzei != null) {
                zzy += zzaov.zzk(28, this.zzei.booleanValue());
            }
            if (this.zzdp != null) {
                zzy += zzaov.zzs(29, this.zzdp);
            }
            if (this.zzej != null) {
                zzy += zzaov.zzs(30, this.zzej);
            }
            if (this.zzdq != null) {
                zzy += zzaov.zze(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzy += zzaov.zze(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzy += zzaov.zze(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzy += zzaov.zzs(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzy += zzaov.zze(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzy += zzaov.zze(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzy += zzaov.zze(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzy += zzaov.zzc(38, this.zzdx);
            }
            if (this.zzdy != null) {
                zzy += zzaov.zze(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzy += zzaov.zze(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzy += zzaov.zze(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzy += zzaov.zze(42, this.zzeb.longValue());
            }
            if (this.zzee != null && this.zzee.length > 0) {
                int i = zzy;
                for (zzapc com_google_android_gms_internal_zzapc : this.zzee) {
                    if (com_google_android_gms_internal_zzapc != null) {
                        i += zzaov.zzc(43, com_google_android_gms_internal_zzapc);
                    }
                }
                zzy = i;
            }
            if (this.zzec != null) {
                zzy += zzaov.zze(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzy += zzaov.zze(45, this.zzed.longValue());
            }
            return this.zzel != null ? zzy + zzaov.zzc(201, this.zzel) : zzy;
        }
    }

    public static final class zzb extends zzaow<zzb> {
        public Long zzen;
        public Integer zzeo;
        public Boolean zzep;
        public int[] zzeq;

        public zzb() {
            this.zzen = null;
            this.zzeo = null;
            this.zzep = null;
            this.zzeq = zzapf.bim;
            this.bik = -1;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzen != null) {
                com_google_android_gms_internal_zzaov.zzb(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                com_google_android_gms_internal_zzaov.zzae(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                com_google_android_gms_internal_zzaov.zzj(3, this.zzep.booleanValue());
            }
            if (this.zzeq != null && this.zzeq.length > 0) {
                for (int zzae : this.zzeq) {
                    com_google_android_gms_internal_zzaov.zzae(4, zzae);
                }
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zze(com_google_android_gms_internal_zzaou);
        }

        public zzb zze(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                int zzc;
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.zzen = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.zzeo = Integer.valueOf(com_google_android_gms_internal_zzaou.m46N());
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        this.zzep = Boolean.valueOf(com_google_android_gms_internal_zzaou.m48P());
                        continue;
                    case ItemTouchHelper.END /*32*/:
                        zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 32);
                        J = this.zzeq == null ? 0 : this.zzeq.length;
                        Object obj = new int[(zzc + J)];
                        if (J != 0) {
                            System.arraycopy(this.zzeq, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.m46N();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.m46N();
                        this.zzeq = obj;
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        int zzaei = com_google_android_gms_internal_zzaou.zzaei(com_google_android_gms_internal_zzaou.m51S());
                        zzc = com_google_android_gms_internal_zzaou.getPosition();
                        J = 0;
                        while (com_google_android_gms_internal_zzaou.m55X() > 0) {
                            com_google_android_gms_internal_zzaou.m46N();
                            J++;
                        }
                        com_google_android_gms_internal_zzaou.zzaek(zzc);
                        zzc = this.zzeq == null ? 0 : this.zzeq.length;
                        Object obj2 = new int[(J + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzeq, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zzaou.m46N();
                            zzc++;
                        }
                        this.zzeq = obj2;
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
            int i = 0;
            int zzy = super.zzy();
            if (this.zzen != null) {
                zzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzeo != null) {
                zzy += zzaov.zzag(2, this.zzeo.intValue());
            }
            if (this.zzep != null) {
                zzy += zzaov.zzk(3, this.zzep.booleanValue());
            }
            if (this.zzeq == null || this.zzeq.length <= 0) {
                return zzy;
            }
            int i2 = 0;
            while (i < this.zzeq.length) {
                i2 += zzaov.zzaeo(this.zzeq[i]);
                i++;
            }
            return (zzy + i2) + (this.zzeq.length * 1);
        }
    }

    public static final class zzc extends zzaow<zzc> {
        public byte[] zzer;
        public byte[] zzes;

        public zzc() {
            this.zzer = null;
            this.zzes = null;
            this.bik = -1;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzer != null) {
                com_google_android_gms_internal_zzaov.zza(1, this.zzer);
            }
            if (this.zzes != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzes);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzf(com_google_android_gms_internal_zzaou);
        }

        public zzc zzf(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzer = com_google_android_gms_internal_zzaou.readBytes();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzes = com_google_android_gms_internal_zzaou.readBytes();
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
            if (this.zzer != null) {
                zzy += zzaov.zzb(1, this.zzer);
            }
            return this.zzes != null ? zzy + zzaov.zzb(2, this.zzes) : zzy;
        }
    }

    public static final class zzd extends zzaow<zzd> {
        public byte[] data;
        public byte[] zzet;
        public byte[] zzeu;
        public byte[] zzev;

        public zzd() {
            this.data = null;
            this.zzet = null;
            this.zzeu = null;
            this.zzev = null;
            this.bik = -1;
        }

        public static zzd zzd(byte[] bArr) throws zzapb {
            return (zzd) zzapc.zza(new zzd(), bArr);
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.data != null) {
                com_google_android_gms_internal_zzaov.zza(1, this.data);
            }
            if (this.zzet != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzet);
            }
            if (this.zzeu != null) {
                com_google_android_gms_internal_zzaov.zza(3, this.zzeu);
            }
            if (this.zzev != null) {
                com_google_android_gms_internal_zzaov.zza(4, this.zzev);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzg(com_google_android_gms_internal_zzaou);
        }

        public zzd zzg(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.data = com_google_android_gms_internal_zzaou.readBytes();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzet = com_google_android_gms_internal_zzaou.readBytes();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        this.zzeu = com_google_android_gms_internal_zzaou.readBytes();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzev = com_google_android_gms_internal_zzaou.readBytes();
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
            if (this.data != null) {
                zzy += zzaov.zzb(1, this.data);
            }
            if (this.zzet != null) {
                zzy += zzaov.zzb(2, this.zzet);
            }
            if (this.zzeu != null) {
                zzy += zzaov.zzb(3, this.zzeu);
            }
            return this.zzev != null ? zzy + zzaov.zzb(4, this.zzev) : zzy;
        }
    }

    public static final class zze extends zzaow<zze> {
        public Long zzen;
        public String zzew;
        public byte[] zzex;

        public zze() {
            this.zzen = null;
            this.zzew = null;
            this.zzex = null;
            this.bik = -1;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzen != null) {
                com_google_android_gms_internal_zzaov.zzb(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                com_google_android_gms_internal_zzaov.zzr(3, this.zzew);
            }
            if (this.zzex != null) {
                com_google_android_gms_internal_zzaov.zza(4, this.zzex);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzh(com_google_android_gms_internal_zzaou);
        }

        public zze zzh(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.zzen = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        this.zzew = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzex = com_google_android_gms_internal_zzaou.readBytes();
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
            if (this.zzen != null) {
                zzy += zzaov.zze(1, this.zzen.longValue());
            }
            if (this.zzew != null) {
                zzy += zzaov.zzs(3, this.zzew);
            }
            return this.zzex != null ? zzy + zzaov.zzb(4, this.zzex) : zzy;
        }
    }

    public static final class zzf extends zzaow<zzf> {
        public byte[] zzet;
        public byte[][] zzey;
        public Integer zzez;
        public Integer zzfa;

        public zzf() {
            this.zzey = zzapf.bis;
            this.zzet = null;
            this.zzez = null;
            this.zzfa = null;
            this.bik = -1;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzey != null && this.zzey.length > 0) {
                for (byte[] bArr : this.zzey) {
                    if (bArr != null) {
                        com_google_android_gms_internal_zzaov.zza(1, bArr);
                    }
                }
            }
            if (this.zzet != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzet);
            }
            if (this.zzez != null) {
                com_google_android_gms_internal_zzaov.zzae(3, this.zzez.intValue());
            }
            if (this.zzfa != null) {
                com_google_android_gms_internal_zzaov.zzae(4, this.zzfa.intValue());
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzi(com_google_android_gms_internal_zzaou);
        }

        public zzf zzi(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        int zzc = zzapf.zzc(com_google_android_gms_internal_zzaou, 10);
                        J = this.zzey == null ? 0 : this.zzey.length;
                        Object obj = new byte[(zzc + J)][];
                        if (J != 0) {
                            System.arraycopy(this.zzey, 0, obj, 0, J);
                        }
                        while (J < obj.length - 1) {
                            obj[J] = com_google_android_gms_internal_zzaou.readBytes();
                            com_google_android_gms_internal_zzaou.m42J();
                            J++;
                        }
                        obj[J] = com_google_android_gms_internal_zzaou.readBytes();
                        this.zzey = obj;
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        this.zzet = com_google_android_gms_internal_zzaou.readBytes();
                        continue;
                    case C0337R.styleable.Toolbar_subtitleTextColor /*24*/:
                        J = com_google_android_gms_internal_zzaou.m46N();
                        switch (J) {
                            case ConnectionResult.SUCCESS /*0*/:
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                                this.zzez = Integer.valueOf(J);
                                break;
                            default:
                                continue;
                        }
                    case ItemTouchHelper.END /*32*/:
                        J = com_google_android_gms_internal_zzaou.m46N();
                        switch (J) {
                            case ConnectionResult.SUCCESS /*0*/:
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                                this.zzfa = Integer.valueOf(J);
                                break;
                            default:
                                continue;
                        }
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
            if (this.zzey == null || this.zzey.length <= 0) {
                i = zzy;
            } else {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzey.length) {
                    byte[] bArr = this.zzey[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zzaov.zzbc(bArr);
                    }
                    i++;
                }
                i = (zzy + i2) + (i3 * 1);
            }
            if (this.zzet != null) {
                i += zzaov.zzb(2, this.zzet);
            }
            if (this.zzez != null) {
                i += zzaov.zzag(3, this.zzez.intValue());
            }
            return this.zzfa != null ? i + zzaov.zzag(4, this.zzfa.intValue()) : i;
        }
    }
}
