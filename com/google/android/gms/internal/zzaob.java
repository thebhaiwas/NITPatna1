package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class zzaob<E> extends zzank<Object> {
    public static final zzanl bfE;
    private final Class<E> bfF;
    private final zzank<E> bfG;

    /* renamed from: com.google.android.gms.internal.zzaob.1 */
    static class C04691 implements zzanl {
        C04691() {
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            Type t = com_google_android_gms_internal_zzaoo_T.m19t();
            if (!(t instanceof GenericArrayType) && (!(t instanceof Class) || !((Class) t).isArray())) {
                return null;
            }
            t = zzanr.zzh(t);
            return new zzaob(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzams.zza(zzaoo.zzl(t)), zzanr.zzf(t));
        }
    }

    static {
        bfE = new C04691();
    }

    public zzaob(zzams com_google_android_gms_internal_zzams, zzank<E> com_google_android_gms_internal_zzank_E, Class<E> cls) {
        this.bfG = new zzaom(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzank_E, cls);
        this.bfF = cls;
    }

    public void zza(zzaor com_google_android_gms_internal_zzaor, Object obj) throws IOException {
        if (obj == null) {
            com_google_android_gms_internal_zzaor.m40r();
            return;
        }
        com_google_android_gms_internal_zzaor.m36n();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bfG.zza(com_google_android_gms_internal_zzaor, Array.get(obj, i));
        }
        com_google_android_gms_internal_zzaor.m37o();
    }

    public Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzaop.beginArray();
        while (com_google_android_gms_internal_zzaop.hasNext()) {
            arrayList.add(this.bfG.zzb(com_google_android_gms_internal_zzaop));
        }
        com_google_android_gms_internal_zzaop.endArray();
        Object newInstance = Array.newInstance(this.bfF, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
