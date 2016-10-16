package com.google.android.gms.internal;

import java.io.IOException;

final class zzanj<T> extends zzank<T> {
    private final zzams beA;
    private final zzaoo<T> beB;
    private final zzanl beC;
    private zzank<T> bej;
    private final zzang<T> bey;
    private final zzamx<T> bez;

    private static class zza implements zzanl {
        private final zzaoo<?> beD;
        private final boolean beE;
        private final Class<?> beF;
        private final zzang<?> bey;
        private final zzamx<?> bez;

        private zza(Object obj, zzaoo<?> com_google_android_gms_internal_zzaoo_, boolean z, Class<?> cls) {
            this.bey = obj instanceof zzang ? (zzang) obj : null;
            this.bez = obj instanceof zzamx ? (zzamx) obj : null;
            boolean z2 = (this.bey == null && this.bez == null) ? false : true;
            zzanq.zzbn(z2);
            this.beD = com_google_android_gms_internal_zzaoo_;
            this.beE = z;
            this.beF = cls;
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            boolean isAssignableFrom = this.beD != null ? this.beD.equals(com_google_android_gms_internal_zzaoo_T) || (this.beE && this.beD.m19t() == com_google_android_gms_internal_zzaoo_T.m18s()) : this.beF.isAssignableFrom(com_google_android_gms_internal_zzaoo_T.m18s());
            return isAssignableFrom ? new zzanj(this.bez, com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzaoo_T, this, null) : null;
        }
    }

    private zzanj(zzang<T> com_google_android_gms_internal_zzang_T, zzamx<T> com_google_android_gms_internal_zzamx_T, zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T, zzanl com_google_android_gms_internal_zzanl) {
        this.bey = com_google_android_gms_internal_zzang_T;
        this.bez = com_google_android_gms_internal_zzamx_T;
        this.beA = com_google_android_gms_internal_zzams;
        this.beB = com_google_android_gms_internal_zzaoo_T;
        this.beC = com_google_android_gms_internal_zzanl;
    }

    public static zzanl zza(zzaoo<?> com_google_android_gms_internal_zzaoo_, Object obj) {
        return new zza(com_google_android_gms_internal_zzaoo_, false, null, null);
    }

    public static zzanl zzb(zzaoo<?> com_google_android_gms_internal_zzaoo_, Object obj) {
        return new zza(com_google_android_gms_internal_zzaoo_, com_google_android_gms_internal_zzaoo_.m19t() == com_google_android_gms_internal_zzaoo_.m18s(), null, null);
    }

    private zzank<T> zzczx() {
        zzank<T> com_google_android_gms_internal_zzank_T = this.bej;
        if (com_google_android_gms_internal_zzank_T != null) {
            return com_google_android_gms_internal_zzank_T;
        }
        com_google_android_gms_internal_zzank_T = this.beA.zza(this.beC, this.beB);
        this.bej = com_google_android_gms_internal_zzank_T;
        return com_google_android_gms_internal_zzank_T;
    }

    public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
        if (this.bey == null) {
            zzczx().zza(com_google_android_gms_internal_zzaor, t);
        } else if (t == null) {
            com_google_android_gms_internal_zzaor.m40r();
        } else {
            zzanz.zzb(this.bey.zza(t, this.beB.m19t(), this.beA.beh), com_google_android_gms_internal_zzaor);
        }
    }

    public T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        if (this.bez == null) {
            return zzczx().zzb(com_google_android_gms_internal_zzaop);
        }
        zzamy zzh = zzanz.zzh(com_google_android_gms_internal_zzaop);
        if (zzh.zzczp()) {
            return null;
        }
        try {
            return this.bez.zzb(zzh, this.beB.m19t(), this.beA.beg);
        } catch (zzanc e) {
            throw e;
        } catch (Throwable e2) {
            throw new zzanc(e2);
        }
    }
}
