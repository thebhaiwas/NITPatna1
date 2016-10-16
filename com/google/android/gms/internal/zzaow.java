package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzaow<M extends zzaow<M>> extends zzapc {
    protected zzaoy bib;

    public M ac() throws CloneNotSupportedException {
        zzaow com_google_android_gms_internal_zzaow = (zzaow) super.ad();
        zzapa.zza(this, com_google_android_gms_internal_zzaow);
        return com_google_android_gms_internal_zzaow;
    }

    public /* synthetic */ zzapc ad() throws CloneNotSupportedException {
        return (zzaow) clone();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return ac();
    }

    public final <T> T zza(zzaox<M, T> com_google_android_gms_internal_zzaox_M__T) {
        if (this.bib == null) {
            return null;
        }
        zzaoz zzaew = this.bib.zzaew(zzapf.zzafa(com_google_android_gms_internal_zzaox_M__T.tag));
        return zzaew != null ? zzaew.zzb(com_google_android_gms_internal_zzaox_M__T) : null;
    }

    public void zza(zzaov com_google_android_gms_internal_zzaov) throws IOException {
        if (this.bib != null) {
            for (int i = 0; i < this.bib.size(); i++) {
                this.bib.zzaex(i).zza(com_google_android_gms_internal_zzaov);
            }
        }
    }

    protected final boolean zza(zzaou com_google_android_gms_internal_zzaou, int i) throws IOException {
        int position = com_google_android_gms_internal_zzaou.getPosition();
        if (!com_google_android_gms_internal_zzaou.zzaeg(i)) {
            return false;
        }
        int zzafa = zzapf.zzafa(i);
        zzape com_google_android_gms_internal_zzape = new zzape(i, com_google_android_gms_internal_zzaou.zzad(position, com_google_android_gms_internal_zzaou.getPosition() - position));
        zzaoz com_google_android_gms_internal_zzaoz = null;
        if (this.bib == null) {
            this.bib = new zzaoy();
        } else {
            com_google_android_gms_internal_zzaoz = this.bib.zzaew(zzafa);
        }
        if (com_google_android_gms_internal_zzaoz == null) {
            com_google_android_gms_internal_zzaoz = new zzaoz();
            this.bib.zza(zzafa, com_google_android_gms_internal_zzaoz);
        }
        com_google_android_gms_internal_zzaoz.zza(com_google_android_gms_internal_zzape);
        return true;
    }

    protected int zzy() {
        int i = 0;
        if (this.bib == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.bib.size()) {
            i2 += this.bib.zzaex(i).zzy();
            i++;
        }
        return i2;
    }
}
