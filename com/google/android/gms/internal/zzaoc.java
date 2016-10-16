package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class zzaoc implements zzanl {
    private final zzans beb;

    private static final class zza<E> extends zzank<Collection<E>> {
        private final zzank<E> bfH;
        private final zzanx<? extends Collection<E>> bfI;

        public zza(zzams com_google_android_gms_internal_zzams, Type type, zzank<E> com_google_android_gms_internal_zzank_E, zzanx<? extends Collection<E>> com_google_android_gms_internal_zzanx__extends_java_util_Collection_E) {
            this.bfH = new zzaom(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzank_E, type);
            this.bfI = com_google_android_gms_internal_zzanx__extends_java_util_Collection_E;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Collection<E> collection) throws IOException {
            if (collection == null) {
                com_google_android_gms_internal_zzaor.m40r();
                return;
            }
            com_google_android_gms_internal_zzaor.m36n();
            for (E zza : collection) {
                this.bfH.zza(com_google_android_gms_internal_zzaor, zza);
            }
            com_google_android_gms_internal_zzaor.m37o();
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzj(com_google_android_gms_internal_zzaop);
        }

        public Collection<E> zzj(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.bfI.m16a();
            com_google_android_gms_internal_zzaop.beginArray();
            while (com_google_android_gms_internal_zzaop.hasNext()) {
                collection.add(this.bfH.zzb(com_google_android_gms_internal_zzaop));
            }
            com_google_android_gms_internal_zzaop.endArray();
            return collection;
        }
    }

    public zzaoc(zzans com_google_android_gms_internal_zzans) {
        this.beb = com_google_android_gms_internal_zzans;
    }

    public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Type t = com_google_android_gms_internal_zzaoo_T.m19t();
        Class s = com_google_android_gms_internal_zzaoo_T.m18s();
        if (!Collection.class.isAssignableFrom(s)) {
            return null;
        }
        Type zza = zzanr.zza(t, s);
        return new zza(com_google_android_gms_internal_zzams, zza, com_google_android_gms_internal_zzams.zza(zzaoo.zzl(zza)), this.beb.zzb(com_google_android_gms_internal_zzaoo_T));
    }
}
