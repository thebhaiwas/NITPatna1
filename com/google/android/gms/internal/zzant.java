package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzant implements zzanl, Cloneable {
    public static final zzant beU;
    private double beV;
    private int beW;
    private boolean beX;
    private List<zzamo> beY;
    private List<zzamo> beZ;

    /* renamed from: com.google.android.gms.internal.zzant.1 */
    class C04621 extends zzank<T> {
        private zzank<T> bej;
        final /* synthetic */ boolean bfa;
        final /* synthetic */ boolean bfb;
        final /* synthetic */ zzams bfc;
        final /* synthetic */ zzaoo bfd;
        final /* synthetic */ zzant bfe;

        C04621(zzant com_google_android_gms_internal_zzant, boolean z, boolean z2, zzams com_google_android_gms_internal_zzams, zzaoo com_google_android_gms_internal_zzaoo) {
            this.bfe = com_google_android_gms_internal_zzant;
            this.bfa = z;
            this.bfb = z2;
            this.bfc = com_google_android_gms_internal_zzams;
            this.bfd = com_google_android_gms_internal_zzaoo;
        }

        private zzank<T> zzczx() {
            zzank<T> com_google_android_gms_internal_zzank_T = this.bej;
            if (com_google_android_gms_internal_zzank_T != null) {
                return com_google_android_gms_internal_zzank_T;
            }
            com_google_android_gms_internal_zzank_T = this.bfc.zza(this.bfe, this.bfd);
            this.bej = com_google_android_gms_internal_zzank_T;
            return com_google_android_gms_internal_zzank_T;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
            if (this.bfb) {
                com_google_android_gms_internal_zzaor.m40r();
            } else {
                zzczx().zza(com_google_android_gms_internal_zzaor, t);
            }
        }

        public T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (!this.bfa) {
                return zzczx().zzb(com_google_android_gms_internal_zzaop);
            }
            com_google_android_gms_internal_zzaop.skipValue();
            return null;
        }
    }

    static {
        beU = new zzant();
    }

    public zzant() {
        this.beV = -1.0d;
        this.beW = 136;
        this.beX = true;
        this.beY = Collections.emptyList();
        this.beZ = Collections.emptyList();
    }

    private boolean zza(zzano com_google_android_gms_internal_zzano) {
        return com_google_android_gms_internal_zzano == null || com_google_android_gms_internal_zzano.zzczz() <= this.beV;
    }

    private boolean zza(zzano com_google_android_gms_internal_zzano, zzanp com_google_android_gms_internal_zzanp) {
        return zza(com_google_android_gms_internal_zzano) && zza(com_google_android_gms_internal_zzanp);
    }

    private boolean zza(zzanp com_google_android_gms_internal_zzanp) {
        return com_google_android_gms_internal_zzanp == null || com_google_android_gms_internal_zzanp.zzczz() > this.beV;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    protected zzant m73b() {
        try {
            return (zzant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m73b();
    }

    public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Class s = com_google_android_gms_internal_zzaoo_T.m18s();
        boolean zza = zza(s, true);
        boolean zza2 = zza(s, false);
        return (zza || zza2) ? new C04621(this, zza2, zza, com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzaoo_T) : null;
    }

    public zzant zza(zzamo com_google_android_gms_internal_zzamo, boolean z, boolean z2) {
        zzant b = m73b();
        if (z) {
            b.beY = new ArrayList(this.beY);
            b.beY.add(com_google_android_gms_internal_zzamo);
        }
        if (z2) {
            b.beZ = new ArrayList(this.beZ);
            b.beZ.add(com_google_android_gms_internal_zzamo);
        }
        return b;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.beV != -1.0d && !zza((zzano) cls.getAnnotation(zzano.class), (zzanp) cls.getAnnotation(zzanp.class))) {
            return true;
        }
        if (!this.beX && zzn(cls)) {
            return true;
        }
        if (zzm(cls)) {
            return true;
        }
        for (zzamo zzh : z ? this.beY : this.beZ) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.beW & field.getModifiers()) != 0) {
            return true;
        }
        if (this.beV != -1.0d && !zza((zzano) field.getAnnotation(zzano.class), (zzanp) field.getAnnotation(zzanp.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.beX && zzn(field.getType())) {
            return true;
        }
        if (zzm(field.getType())) {
            return true;
        }
        List<zzamo> list = z ? this.beY : this.beZ;
        if (!list.isEmpty()) {
            zzamp com_google_android_gms_internal_zzamp = new zzamp(field);
            for (zzamo zza : list) {
                if (zza.zza(com_google_android_gms_internal_zzamp)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zzant zze(int... iArr) {
        int i = 0;
        zzant b = m73b();
        b.beW = 0;
        int length = iArr.length;
        while (i < length) {
            b.beW = iArr[i] | b.beW;
            i++;
        }
        return b;
    }
}
