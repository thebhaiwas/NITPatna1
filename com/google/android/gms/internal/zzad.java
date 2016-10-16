package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzad {

    public static final class zza extends zzaow<zza> {
        public String stackTrace;
        public String zzck;
        public Long zzcl;
        public String zzcm;
        public String zzcn;
        public Long zzco;
        public Long zzcp;
        public String zzcq;
        public Long zzcr;
        public String zzcs;

        public zza() {
            this.zzck = null;
            this.zzcl = null;
            this.stackTrace = null;
            this.zzcm = null;
            this.zzcn = null;
            this.zzco = null;
            this.zzcp = null;
            this.zzcq = null;
            this.zzcr = null;
            this.zzcs = null;
            this.bik = -1;
        }

        public zza zza(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        this.zzck = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case ConnectionResult.API_UNAVAILABLE /*16*/:
                        this.zzcl = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        this.stackTrace = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                        this.zzcm = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.zzcn = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                        this.zzco = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_dividerHorizontal /*56*/:
                        this.zzcp = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                        this.zzcq = com_google_android_gms_internal_zzaou.readString();
                        continue;
                    case C0337R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                        this.zzcr = Long.valueOf(com_google_android_gms_internal_zzaou.m45M());
                        continue;
                    case C0337R.styleable.AppCompatTheme_colorPrimary /*82*/:
                        this.zzcs = com_google_android_gms_internal_zzaou.readString();
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

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            if (this.zzck != null) {
                com_google_android_gms_internal_zzaov.zzr(1, this.zzck);
            }
            if (this.zzcl != null) {
                com_google_android_gms_internal_zzaov.zzb(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                com_google_android_gms_internal_zzaov.zzr(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                com_google_android_gms_internal_zzaov.zzr(4, this.zzcm);
            }
            if (this.zzcn != null) {
                com_google_android_gms_internal_zzaov.zzr(5, this.zzcn);
            }
            if (this.zzco != null) {
                com_google_android_gms_internal_zzaov.zzb(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                com_google_android_gms_internal_zzaov.zzb(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                com_google_android_gms_internal_zzaov.zzr(8, this.zzcq);
            }
            if (this.zzcr != null) {
                com_google_android_gms_internal_zzaov.zzb(9, this.zzcr.longValue());
            }
            if (this.zzcs != null) {
                com_google_android_gms_internal_zzaov.zzr(10, this.zzcs);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zza(com_google_android_gms_internal_zzaou);
        }

        protected int zzy() {
            int zzy = super.zzy();
            if (this.zzck != null) {
                zzy += zzaov.zzs(1, this.zzck);
            }
            if (this.zzcl != null) {
                zzy += zzaov.zze(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                zzy += zzaov.zzs(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                zzy += zzaov.zzs(4, this.zzcm);
            }
            if (this.zzcn != null) {
                zzy += zzaov.zzs(5, this.zzcn);
            }
            if (this.zzco != null) {
                zzy += zzaov.zze(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                zzy += zzaov.zze(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                zzy += zzaov.zzs(8, this.zzcq);
            }
            if (this.zzcr != null) {
                zzy += zzaov.zze(9, this.zzcr.longValue());
            }
            return this.zzcs != null ? zzy + zzaov.zzs(10, this.zzcs) : zzy;
        }
    }
}
