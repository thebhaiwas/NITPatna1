package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaoj implements zzanl {
    private final zzans beb;
    private final zzant bek;
    private final zzamr bem;

    static abstract class zzb {
        final boolean bgc;
        final boolean bgd;
        final String name;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.bgc = z;
            this.bgd = z2;
        }

        abstract void zza(zzaop com_google_android_gms_internal_zzaop, Object obj) throws IOException, IllegalAccessException;

        abstract void zza(zzaor com_google_android_gms_internal_zzaor, Object obj) throws IOException, IllegalAccessException;

        abstract boolean zzcq(Object obj) throws IOException, IllegalAccessException;
    }

    /* renamed from: com.google.android.gms.internal.zzaoj.1 */
    class C04721 extends zzb {
        final zzank<?> bfV;
        final /* synthetic */ zzams bfW;
        final /* synthetic */ Field bfX;
        final /* synthetic */ zzaoo bfY;
        final /* synthetic */ boolean bfZ;
        final /* synthetic */ zzaoj bga;

        C04721(zzaoj com_google_android_gms_internal_zzaoj, String str, boolean z, boolean z2, zzams com_google_android_gms_internal_zzams, Field field, zzaoo com_google_android_gms_internal_zzaoo, boolean z3) {
            this.bga = com_google_android_gms_internal_zzaoj;
            this.bfW = com_google_android_gms_internal_zzams;
            this.bfX = field;
            this.bfY = com_google_android_gms_internal_zzaoo;
            this.bfZ = z3;
            super(str, z, z2);
            this.bfV = this.bga.zza(this.bfW, this.bfX, this.bfY);
        }

        void zza(zzaop com_google_android_gms_internal_zzaop, Object obj) throws IOException, IllegalAccessException {
            Object zzb = this.bfV.zzb(com_google_android_gms_internal_zzaop);
            if (zzb != null || !this.bfZ) {
                this.bfX.set(obj, zzb);
            }
        }

        void zza(zzaor com_google_android_gms_internal_zzaor, Object obj) throws IOException, IllegalAccessException {
            new zzaom(this.bfW, this.bfV, this.bfY.m19t()).zza(com_google_android_gms_internal_zzaor, this.bfX.get(obj));
        }

        public boolean zzcq(Object obj) throws IOException, IllegalAccessException {
            return this.bgc && this.bfX.get(obj) != obj;
        }
    }

    public static final class zza<T> extends zzank<T> {
        private final zzanx<T> bfI;
        private final Map<String, zzb> bgb;

        private zza(zzanx<T> com_google_android_gms_internal_zzanx_T, Map<String, zzb> map) {
            this.bfI = com_google_android_gms_internal_zzanx_T;
            this.bgb = map;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
            if (t == null) {
                com_google_android_gms_internal_zzaor.m40r();
                return;
            }
            com_google_android_gms_internal_zzaor.m38p();
            try {
                for (zzb com_google_android_gms_internal_zzaoj_zzb : this.bgb.values()) {
                    if (com_google_android_gms_internal_zzaoj_zzb.zzcq(t)) {
                        com_google_android_gms_internal_zzaor.zzta(com_google_android_gms_internal_zzaoj_zzb.name);
                        com_google_android_gms_internal_zzaoj_zzb.zza(com_google_android_gms_internal_zzaor, (Object) t);
                    }
                }
                com_google_android_gms_internal_zzaor.m39q();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            T a = this.bfI.m16a();
            try {
                com_google_android_gms_internal_zzaop.beginObject();
                while (com_google_android_gms_internal_zzaop.hasNext()) {
                    zzb com_google_android_gms_internal_zzaoj_zzb = (zzb) this.bgb.get(com_google_android_gms_internal_zzaop.nextName());
                    if (com_google_android_gms_internal_zzaoj_zzb == null || !com_google_android_gms_internal_zzaoj_zzb.bgd) {
                        com_google_android_gms_internal_zzaop.skipValue();
                    } else {
                        com_google_android_gms_internal_zzaoj_zzb.zza(com_google_android_gms_internal_zzaop, (Object) a);
                    }
                }
                com_google_android_gms_internal_zzaop.endObject();
                return a;
            } catch (Throwable e) {
                throw new zzanh(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public zzaoj(zzans com_google_android_gms_internal_zzans, zzamr com_google_android_gms_internal_zzamr, zzant com_google_android_gms_internal_zzant) {
        this.beb = com_google_android_gms_internal_zzans;
        this.bem = com_google_android_gms_internal_zzamr;
        this.bek = com_google_android_gms_internal_zzant;
    }

    private zzank<?> zza(zzams com_google_android_gms_internal_zzams, Field field, zzaoo<?> com_google_android_gms_internal_zzaoo_) {
        zzanm com_google_android_gms_internal_zzanm = (zzanm) field.getAnnotation(zzanm.class);
        if (com_google_android_gms_internal_zzanm != null) {
            zzank<?> zza = zzaoe.zza(this.beb, com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzaoo_, com_google_android_gms_internal_zzanm);
            if (zza != null) {
                return zza;
            }
        }
        return com_google_android_gms_internal_zzams.zza((zzaoo) com_google_android_gms_internal_zzaoo_);
    }

    private zzb zza(zzams com_google_android_gms_internal_zzams, Field field, String str, zzaoo<?> com_google_android_gms_internal_zzaoo_, boolean z, boolean z2) {
        return new C04721(this, str, z, z2, com_google_android_gms_internal_zzams, field, com_google_android_gms_internal_zzaoo_, zzany.zzk(com_google_android_gms_internal_zzaoo_.m18s()));
    }

    static List<String> zza(zzamr com_google_android_gms_internal_zzamr, Field field) {
        zzann com_google_android_gms_internal_zzann = (zzann) field.getAnnotation(zzann.class);
        List<String> linkedList = new LinkedList();
        if (com_google_android_gms_internal_zzann == null) {
            linkedList.add(com_google_android_gms_internal_zzamr.zzc(field));
        } else {
            linkedList.add(com_google_android_gms_internal_zzann.value());
            for (Object add : com_google_android_gms_internal_zzann.zzczy()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private Map<String, zzb> zza(zzams com_google_android_gms_internal_zzams, zzaoo<?> com_google_android_gms_internal_zzaoo_, Class<?> cls) {
        Map<String, zzb> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type t = com_google_android_gms_internal_zzaoo_.m19t();
        Class s;
        while (s != Object.class) {
            for (Field field : s.getDeclaredFields()) {
                boolean zza = zza(field, true);
                boolean zza2 = zza(field, false);
                if (zza || zza2) {
                    field.setAccessible(true);
                    Type zza3 = zzanr.zza(r19.m19t(), s, field.getGenericType());
                    List zzd = zzd(field);
                    zzb com_google_android_gms_internal_zzaoj_zzb = null;
                    int i = 0;
                    while (i < zzd.size()) {
                        String str = (String) zzd.get(i);
                        if (i != 0) {
                            zza = false;
                        }
                        zzb com_google_android_gms_internal_zzaoj_zzb2 = (zzb) linkedHashMap.put(str, zza(com_google_android_gms_internal_zzams, field, str, zzaoo.zzl(zza3), zza, zza2));
                        if (com_google_android_gms_internal_zzaoj_zzb != null) {
                            com_google_android_gms_internal_zzaoj_zzb2 = com_google_android_gms_internal_zzaoj_zzb;
                        }
                        i++;
                        com_google_android_gms_internal_zzaoj_zzb = com_google_android_gms_internal_zzaoj_zzb2;
                    }
                    if (com_google_android_gms_internal_zzaoj_zzb != null) {
                        String valueOf = String.valueOf(t);
                        String str2 = com_google_android_gms_internal_zzaoj_zzb.name;
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str2).length()).append(valueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            zzaoo zzl = zzaoo.zzl(zzanr.zza(zzl.m19t(), s, s.getGenericSuperclass()));
            s = zzl.m18s();
        }
        return linkedHashMap;
    }

    static boolean zza(Field field, boolean z, zzant com_google_android_gms_internal_zzant) {
        return (com_google_android_gms_internal_zzant.zza(field.getType(), z) || com_google_android_gms_internal_zzant.zza(field, z)) ? false : true;
    }

    private List<String> zzd(Field field) {
        return zza(this.bem, field);
    }

    public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Class s = com_google_android_gms_internal_zzaoo_T.m18s();
        return !Object.class.isAssignableFrom(s) ? null : new zza(zza(com_google_android_gms_internal_zzams, (zzaoo) com_google_android_gms_internal_zzaoo_T, s), null);
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.bek);
    }
}
