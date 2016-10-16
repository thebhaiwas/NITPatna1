package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzams {
    private final ThreadLocal<Map<zzaoo<?>, zza<?>>> bdY;
    private final Map<zzaoo<?>, zzank<?>> bdZ;
    private final List<zzanl> bea;
    private final zzans beb;
    private final boolean bec;
    private final boolean bed;
    private final boolean bee;
    private final boolean bef;
    final zzamw beg;
    final zzanf beh;

    /* renamed from: com.google.android.gms.internal.zzams.1 */
    class C04461 implements zzamw {
        final /* synthetic */ zzams bei;

        C04461(zzams com_google_android_gms_internal_zzams) {
            this.bei = com_google_android_gms_internal_zzams;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzams.2 */
    class C04472 implements zzanf {
        final /* synthetic */ zzams bei;

        C04472(zzams com_google_android_gms_internal_zzams) {
            this.bei = com_google_android_gms_internal_zzams;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzams.3 */
    class C04483 extends zzank<Number> {
        final /* synthetic */ zzams bei;

        C04483(zzams com_google_android_gms_internal_zzams) {
            this.bei = com_google_android_gms_internal_zzams;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
            if (number == null) {
                com_google_android_gms_internal_zzaor.m40r();
                return;
            }
            this.bei.zzn(number.doubleValue());
            com_google_android_gms_internal_zzaor.zza(number);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zze(com_google_android_gms_internal_zzaop);
        }

        public Double zze(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return Double.valueOf(com_google_android_gms_internal_zzaop.nextDouble());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzams.4 */
    class C04494 extends zzank<Number> {
        final /* synthetic */ zzams bei;

        C04494(zzams com_google_android_gms_internal_zzams) {
            this.bei = com_google_android_gms_internal_zzams;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
            if (number == null) {
                com_google_android_gms_internal_zzaor.m40r();
                return;
            }
            this.bei.zzn((double) number.floatValue());
            com_google_android_gms_internal_zzaor.zza(number);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzf(com_google_android_gms_internal_zzaop);
        }

        public Float zzf(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return Float.valueOf((float) com_google_android_gms_internal_zzaop.nextDouble());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzams.5 */
    class C04505 extends zzank<Number> {
        final /* synthetic */ zzams bei;

        C04505(zzams com_google_android_gms_internal_zzams) {
            this.bei = com_google_android_gms_internal_zzams;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
            if (number == null) {
                com_google_android_gms_internal_zzaor.m40r();
            } else {
                com_google_android_gms_internal_zzaor.zztb(number.toString());
            }
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzg(com_google_android_gms_internal_zzaop);
        }

        public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return Long.valueOf(com_google_android_gms_internal_zzaop.nextLong());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    static class zza<T> extends zzank<T> {
        private zzank<T> bej;

        zza() {
        }

        public void zza(zzank<T> com_google_android_gms_internal_zzank_T) {
            if (this.bej != null) {
                throw new AssertionError();
            }
            this.bej = com_google_android_gms_internal_zzank_T;
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
            if (this.bej == null) {
                throw new IllegalStateException();
            }
            this.bej.zza(com_google_android_gms_internal_zzaor, t);
        }

        public T zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (this.bej != null) {
                return this.bej.zzb(com_google_android_gms_internal_zzaop);
            }
            throw new IllegalStateException();
        }
    }

    public zzams() {
        this(zzant.beU, zzamq.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzani.DEFAULT, Collections.emptyList());
    }

    zzams(zzant com_google_android_gms_internal_zzant, zzamr com_google_android_gms_internal_zzamr, Map<Type, zzamu<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzani com_google_android_gms_internal_zzani, List<zzanl> list) {
        this.bdY = new ThreadLocal();
        this.bdZ = Collections.synchronizedMap(new HashMap());
        this.beg = new C04461(this);
        this.beh = new C04472(this);
        this.beb = new zzans(map);
        this.bec = z;
        this.bee = z3;
        this.bed = z4;
        this.bef = z5;
        List arrayList = new ArrayList();
        arrayList.add(zzaon.bgX);
        arrayList.add(zzaoi.bfE);
        arrayList.add(com_google_android_gms_internal_zzant);
        arrayList.addAll(list);
        arrayList.add(zzaon.bgE);
        arrayList.add(zzaon.bgt);
        arrayList.add(zzaon.bgn);
        arrayList.add(zzaon.bgp);
        arrayList.add(zzaon.bgr);
        arrayList.add(zzaon.zza(Long.TYPE, Long.class, zza(com_google_android_gms_internal_zzani)));
        arrayList.add(zzaon.zza(Double.TYPE, Double.class, zzcx(z6)));
        arrayList.add(zzaon.zza(Float.TYPE, Float.class, zzcy(z6)));
        arrayList.add(zzaon.bgy);
        arrayList.add(zzaon.bgA);
        arrayList.add(zzaon.bgG);
        arrayList.add(zzaon.bgI);
        arrayList.add(zzaon.zza(BigDecimal.class, zzaon.bgC));
        arrayList.add(zzaon.zza(BigInteger.class, zzaon.bgD));
        arrayList.add(zzaon.bgK);
        arrayList.add(zzaon.bgM);
        arrayList.add(zzaon.bgQ);
        arrayList.add(zzaon.bgV);
        arrayList.add(zzaon.bgO);
        arrayList.add(zzaon.bgk);
        arrayList.add(zzaod.bfE);
        arrayList.add(zzaon.bgT);
        arrayList.add(zzaol.bfE);
        arrayList.add(zzaok.bfE);
        arrayList.add(zzaon.bgR);
        arrayList.add(zzaob.bfE);
        arrayList.add(zzaon.bgi);
        arrayList.add(new zzaoc(this.beb));
        arrayList.add(new zzaoh(this.beb, z2));
        arrayList.add(new zzaoe(this.beb));
        arrayList.add(zzaon.bgY);
        arrayList.add(new zzaoj(this.beb, com_google_android_gms_internal_zzamr, com_google_android_gms_internal_zzant));
        this.bea = Collections.unmodifiableList(arrayList);
    }

    private zzank<Number> zza(zzani com_google_android_gms_internal_zzani) {
        return com_google_android_gms_internal_zzani == zzani.DEFAULT ? zzaon.bgu : new C04505(this);
    }

    private static void zza(Object obj, zzaop com_google_android_gms_internal_zzaop) {
        if (obj != null) {
            try {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.END_DOCUMENT) {
                    throw new zzamz("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new zzanh(e);
            } catch (Throwable e2) {
                throw new zzamz(e2);
            }
        }
    }

    private zzank<Number> zzcx(boolean z) {
        return z ? zzaon.bgw : new C04483(this);
    }

    private zzank<Number> zzcy(boolean z) {
        return z ? zzaon.bgv : new C04494(this);
    }

    private void zzn(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.bec + "factories:" + this.bea + ",instanceCreators:" + this.beb + "}";
    }

    public <T> zzank<T> zza(zzanl com_google_android_gms_internal_zzanl, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Object obj = null;
        if (!this.bea.contains(com_google_android_gms_internal_zzanl)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (zzanl com_google_android_gms_internal_zzanl2 : this.bea) {
            if (obj2 != null) {
                zzank<T> zza = com_google_android_gms_internal_zzanl2.zza(this, com_google_android_gms_internal_zzaoo_T);
                if (zza != null) {
                    return zza;
                }
            } else if (com_google_android_gms_internal_zzanl2 == com_google_android_gms_internal_zzanl) {
                obj2 = 1;
            }
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzaoo_T);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public <T> zzank<T> zza(zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        zzank<T> com_google_android_gms_internal_zzank_T = (zzank) this.bdZ.get(com_google_android_gms_internal_zzaoo_T);
        if (com_google_android_gms_internal_zzank_T == null) {
            Map map;
            Map map2 = (Map) this.bdY.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.bdY.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            zza com_google_android_gms_internal_zzams_zza = (zza) map.get(com_google_android_gms_internal_zzaoo_T);
            if (com_google_android_gms_internal_zzams_zza == null) {
                try {
                    zza com_google_android_gms_internal_zzams_zza2 = new zza();
                    map.put(com_google_android_gms_internal_zzaoo_T, com_google_android_gms_internal_zzams_zza2);
                    for (zzanl zza : this.bea) {
                        com_google_android_gms_internal_zzank_T = zza.zza(this, com_google_android_gms_internal_zzaoo_T);
                        if (com_google_android_gms_internal_zzank_T != null) {
                            com_google_android_gms_internal_zzams_zza2.zza(com_google_android_gms_internal_zzank_T);
                            this.bdZ.put(com_google_android_gms_internal_zzaoo_T, com_google_android_gms_internal_zzank_T);
                            map.remove(com_google_android_gms_internal_zzaoo_T);
                            if (obj != null) {
                                this.bdY.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzaoo_T);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    map.remove(com_google_android_gms_internal_zzaoo_T);
                    if (obj != null) {
                        this.bdY.remove();
                    }
                }
            }
        }
        return com_google_android_gms_internal_zzank_T;
    }

    public zzaor zza(Writer writer) throws IOException {
        if (this.bee) {
            writer.write(")]}'\n");
        }
        zzaor com_google_android_gms_internal_zzaor = new zzaor(writer);
        if (this.bef) {
            com_google_android_gms_internal_zzaor.setIndent("  ");
        }
        com_google_android_gms_internal_zzaor.zzdc(this.bec);
        return com_google_android_gms_internal_zzaor;
    }

    public <T> T zza(zzamy com_google_android_gms_internal_zzamy, Class<T> cls) throws zzanh {
        return zzany.zzp(cls).cast(zza(com_google_android_gms_internal_zzamy, (Type) cls));
    }

    public <T> T zza(zzamy com_google_android_gms_internal_zzamy, Type type) throws zzanh {
        return com_google_android_gms_internal_zzamy == null ? null : zza(new zzaof(com_google_android_gms_internal_zzamy), type);
    }

    public <T> T zza(zzaop com_google_android_gms_internal_zzaop, Type type) throws zzamz, zzanh {
        boolean z = true;
        boolean isLenient = com_google_android_gms_internal_zzaop.isLenient();
        com_google_android_gms_internal_zzaop.setLenient(true);
        try {
            com_google_android_gms_internal_zzaop.m29h();
            z = false;
            T zzb = zza(zzaoo.zzl(type)).zzb(com_google_android_gms_internal_zzaop);
            com_google_android_gms_internal_zzaop.setLenient(isLenient);
            return zzb;
        } catch (Throwable e) {
            if (z) {
                com_google_android_gms_internal_zzaop.setLenient(isLenient);
                return null;
            }
            throw new zzanh(e);
        } catch (Throwable e2) {
            throw new zzanh(e2);
        } catch (Throwable e22) {
            throw new zzanh(e22);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaop.setLenient(isLenient);
        }
    }

    public <T> T zza(Reader reader, Type type) throws zzamz, zzanh {
        zzaop com_google_android_gms_internal_zzaop = new zzaop(reader);
        Object zza = zza(com_google_android_gms_internal_zzaop, type);
        zza(zza, com_google_android_gms_internal_zzaop);
        return zza;
    }

    public <T> T zza(String str, Type type) throws zzanh {
        return str == null ? null : zza(new StringReader(str), type);
    }

    public void zza(zzamy com_google_android_gms_internal_zzamy, zzaor com_google_android_gms_internal_zzaor) throws zzamz {
        boolean isLenient = com_google_android_gms_internal_zzaor.isLenient();
        com_google_android_gms_internal_zzaor.setLenient(true);
        boolean D = com_google_android_gms_internal_zzaor.m34D();
        com_google_android_gms_internal_zzaor.zzdb(this.bed);
        boolean E = com_google_android_gms_internal_zzaor.m35E();
        com_google_android_gms_internal_zzaor.zzdc(this.bec);
        try {
            zzanz.zzb(com_google_android_gms_internal_zzamy, com_google_android_gms_internal_zzaor);
            com_google_android_gms_internal_zzaor.setLenient(isLenient);
            com_google_android_gms_internal_zzaor.zzdb(D);
            com_google_android_gms_internal_zzaor.zzdc(E);
        } catch (Throwable e) {
            throw new zzamz(e);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaor.setLenient(isLenient);
            com_google_android_gms_internal_zzaor.zzdb(D);
            com_google_android_gms_internal_zzaor.zzdc(E);
        }
    }

    public void zza(zzamy com_google_android_gms_internal_zzamy, Appendable appendable) throws zzamz {
        try {
            zza(com_google_android_gms_internal_zzamy, zza(zzanz.zza(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaor com_google_android_gms_internal_zzaor) throws zzamz {
        zzank zza = zza(zzaoo.zzl(type));
        boolean isLenient = com_google_android_gms_internal_zzaor.isLenient();
        com_google_android_gms_internal_zzaor.setLenient(true);
        boolean D = com_google_android_gms_internal_zzaor.m34D();
        com_google_android_gms_internal_zzaor.zzdb(this.bed);
        boolean E = com_google_android_gms_internal_zzaor.m35E();
        com_google_android_gms_internal_zzaor.zzdc(this.bec);
        try {
            zza.zza(com_google_android_gms_internal_zzaor, obj);
            com_google_android_gms_internal_zzaor.setLenient(isLenient);
            com_google_android_gms_internal_zzaor.zzdb(D);
            com_google_android_gms_internal_zzaor.zzdc(E);
        } catch (Throwable e) {
            throw new zzamz(e);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaor.setLenient(isLenient);
            com_google_android_gms_internal_zzaor.zzdb(D);
            com_google_android_gms_internal_zzaor.zzdc(E);
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) throws zzamz {
        try {
            zza(obj, type, zza(zzanz.zza(appendable)));
        } catch (Throwable e) {
            throw new zzamz(e);
        }
    }

    public String zzb(zzamy com_google_android_gms_internal_zzamy) {
        Appendable stringWriter = new StringWriter();
        zza(com_google_android_gms_internal_zzamy, stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        zza(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String zzcj(Object obj) {
        return obj == null ? zzb(zzana.bes) : zzc(obj, obj.getClass());
    }

    public <T> T zzf(String str, Class<T> cls) throws zzanh {
        return zzany.zzp(cls).cast(zza(str, (Type) cls));
    }

    public <T> zzank<T> zzk(Class<T> cls) {
        return zza(zzaoo.zzr(cls));
    }
}
