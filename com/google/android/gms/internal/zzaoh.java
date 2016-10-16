package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaoh implements zzanl {
    private final zzans beb;
    private final boolean bfQ;

    private final class zza<K, V> extends zzank<Map<K, V>> {
        private final zzanx<? extends Map<K, V>> bfI;
        private final zzank<K> bfR;
        private final zzank<V> bfS;
        final /* synthetic */ zzaoh bfT;

        public zza(zzaoh com_google_android_gms_internal_zzaoh, zzams com_google_android_gms_internal_zzams, Type type, zzank<K> com_google_android_gms_internal_zzank_K, Type type2, zzank<V> com_google_android_gms_internal_zzank_V, zzanx<? extends Map<K, V>> com_google_android_gms_internal_zzanx__extends_java_util_Map_K__V) {
            this.bfT = com_google_android_gms_internal_zzaoh;
            this.bfR = new zzaom(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzank_K, type);
            this.bfS = new zzaom(com_google_android_gms_internal_zzams, com_google_android_gms_internal_zzank_V, type2);
            this.bfI = com_google_android_gms_internal_zzanx__extends_java_util_Map_K__V;
        }

        private String zze(zzamy com_google_android_gms_internal_zzamy) {
            if (com_google_android_gms_internal_zzamy.zzczo()) {
                zzane zzczs = com_google_android_gms_internal_zzamy.zzczs();
                if (zzczs.zzczv()) {
                    return String.valueOf(zzczs.zzczg());
                }
                if (zzczs.zzczu()) {
                    return Boolean.toString(zzczs.zzczl());
                }
                if (zzczs.zzczw()) {
                    return zzczs.zzczh();
                }
                throw new AssertionError();
            } else if (com_google_android_gms_internal_zzamy.zzczp()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                com_google_android_gms_internal_zzaor.m40r();
            } else if (this.bfT.bfQ) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    zzamy zzcl = this.bfR.zzcl(entry.getKey());
                    arrayList.add(zzcl);
                    arrayList2.add(entry.getValue());
                    int i3 = (zzcl.zzczm() || zzcl.zzczn()) ? 1 : 0;
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    com_google_android_gms_internal_zzaor.m36n();
                    while (i < arrayList.size()) {
                        com_google_android_gms_internal_zzaor.m36n();
                        zzanz.zzb((zzamy) arrayList.get(i), com_google_android_gms_internal_zzaor);
                        this.bfS.zza(com_google_android_gms_internal_zzaor, arrayList2.get(i));
                        com_google_android_gms_internal_zzaor.m37o();
                        i++;
                    }
                    com_google_android_gms_internal_zzaor.m37o();
                    return;
                }
                com_google_android_gms_internal_zzaor.m38p();
                while (i < arrayList.size()) {
                    com_google_android_gms_internal_zzaor.zzta(zze((zzamy) arrayList.get(i)));
                    this.bfS.zza(com_google_android_gms_internal_zzaor, arrayList2.get(i));
                    i++;
                }
                com_google_android_gms_internal_zzaor.m39q();
            } else {
                com_google_android_gms_internal_zzaor.m38p();
                for (Entry entry2 : map.entrySet()) {
                    com_google_android_gms_internal_zzaor.zzta(String.valueOf(entry2.getKey()));
                    this.bfS.zza(com_google_android_gms_internal_zzaor, entry2.getValue());
                }
                com_google_android_gms_internal_zzaor.m39q();
            }
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzl(com_google_android_gms_internal_zzaop);
        }

        public Map<K, V> zzl(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            zzaoq h = com_google_android_gms_internal_zzaop.m29h();
            if (h == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.bfI.m16a();
            Object zzb;
            if (h == zzaoq.BEGIN_ARRAY) {
                com_google_android_gms_internal_zzaop.beginArray();
                while (com_google_android_gms_internal_zzaop.hasNext()) {
                    com_google_android_gms_internal_zzaop.beginArray();
                    zzb = this.bfR.zzb(com_google_android_gms_internal_zzaop);
                    if (map.put(zzb, this.bfS.zzb(com_google_android_gms_internal_zzaop)) != null) {
                        String valueOf = String.valueOf(zzb);
                        throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                    }
                    com_google_android_gms_internal_zzaop.endArray();
                }
                com_google_android_gms_internal_zzaop.endArray();
                return map;
            }
            com_google_android_gms_internal_zzaop.beginObject();
            while (com_google_android_gms_internal_zzaop.hasNext()) {
                zzanu.bff.zzi(com_google_android_gms_internal_zzaop);
                zzb = this.bfR.zzb(com_google_android_gms_internal_zzaop);
                if (map.put(zzb, this.bfS.zzb(com_google_android_gms_internal_zzaop)) != null) {
                    valueOf = String.valueOf(zzb);
                    throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                }
            }
            com_google_android_gms_internal_zzaop.endObject();
            return map;
        }
    }

    public zzaoh(zzans com_google_android_gms_internal_zzans, boolean z) {
        this.beb = com_google_android_gms_internal_zzans;
        this.bfQ = z;
    }

    private zzank<?> zza(zzams com_google_android_gms_internal_zzams, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzaon.bgm : com_google_android_gms_internal_zzams.zza(zzaoo.zzl(type));
    }

    public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Type t = com_google_android_gms_internal_zzaoo_T.m19t();
        if (!Map.class.isAssignableFrom(com_google_android_gms_internal_zzaoo_T.m18s())) {
            return null;
        }
        Type[] zzb = zzanr.zzb(t, zzanr.zzf(t));
        zzank zza = zza(com_google_android_gms_internal_zzams, zzb[0]);
        zzank zza2 = com_google_android_gms_internal_zzams.zza(zzaoo.zzl(zzb[1]));
        zzanx zzb2 = this.beb.zzb(com_google_android_gms_internal_zzaoo_T);
        return new zza(this, com_google_android_gms_internal_zzams, zzb[0], zza, zzb[1], zza2, zzb2);
    }
}
