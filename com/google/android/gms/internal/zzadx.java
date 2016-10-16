package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzah.zzf;
import com.google.android.gms.internal.zzah.zzj;
import java.io.IOException;
import xyz.purush.nitp.nitpatna.C0337R;

public interface zzadx {

    public static final class zza extends zzaow<zza> {
        public long aDp;
        public zzj aDq;
        public zzf zzwq;

        public zza() {
            zzcgt();
        }

        public static zza zzap(byte[] bArr) throws zzapb {
            return (zza) zzapc.zza(new zza(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzadx_zza = (zza) obj;
            if (this.aDp != com_google_android_gms_internal_zzadx_zza.aDp) {
                return false;
            }
            if (this.zzwq == null) {
                if (com_google_android_gms_internal_zzadx_zza.zzwq != null) {
                    return false;
                }
            } else if (!this.zzwq.equals(com_google_android_gms_internal_zzadx_zza.zzwq)) {
                return false;
            }
            if (this.aDq == null) {
                if (com_google_android_gms_internal_zzadx_zza.aDq != null) {
                    return false;
                }
            } else if (!this.aDq.equals(com_google_android_gms_internal_zzadx_zza.aDq)) {
                return false;
            }
            return (this.bib == null || this.bib.isEmpty()) ? com_google_android_gms_internal_zzadx_zza.bib == null || com_google_android_gms_internal_zzadx_zza.bib.isEmpty() : this.bib.equals(com_google_android_gms_internal_zzadx_zza.bib);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aDq == null ? 0 : this.aDq.hashCode()) + (((this.zzwq == null ? 0 : this.zzwq.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.aDp ^ (this.aDp >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.bib == null || this.bib.isEmpty())) {
                i = this.bib.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
            com_google_android_gms_internal_zzaov.zzb(1, this.aDp);
            if (this.zzwq != null) {
                com_google_android_gms_internal_zzaov.zza(2, this.zzwq);
            }
            if (this.aDq != null) {
                com_google_android_gms_internal_zzaov.zza(3, this.aDq);
            }
            super.zza(com_google_android_gms_internal_zzaov);
        }

        public /* synthetic */ zzapc zzb(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            return zzbt(com_google_android_gms_internal_zzaou);
        }

        public zza zzbt(zzaou com_google_android_gms_internal_zzaou) throws IOException {
            while (true) {
                int J = com_google_android_gms_internal_zzaou.m42J();
                switch (J) {
                    case ConnectionResult.SUCCESS /*0*/:
                        break;
                    case ConnectionResult.INTERNAL_ERROR /*8*/:
                        this.aDp = com_google_android_gms_internal_zzaou.m45M();
                        continue;
                    case ConnectionResult.SERVICE_UPDATING /*18*/:
                        if (this.zzwq == null) {
                            this.zzwq = new zzf();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.zzwq);
                        continue;
                    case C0337R.styleable.AppCompatTheme_actionMenuTextColor /*26*/:
                        if (this.aDq == null) {
                            this.aDq = new zzj();
                        }
                        com_google_android_gms_internal_zzaou.zza(this.aDq);
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

        public zza zzcgt() {
            this.aDp = 0;
            this.zzwq = null;
            this.aDq = null;
            this.bib = null;
            this.bik = -1;
            return this;
        }

        protected int zzy() {
            int zzy = super.zzy() + zzaov.zze(1, this.aDp);
            if (this.zzwq != null) {
                zzy += zzaov.zzc(2, this.zzwq);
            }
            return this.aDq != null ? zzy + zzaov.zzc(3, this.aDq) : zzy;
        }
    }
}
