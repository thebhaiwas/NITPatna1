package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzans {
    private final Map<Type, zzamu<?>> ben;

    /* renamed from: com.google.android.gms.internal.zzans.1 */
    class C04531 implements zzanx<T> {
        final /* synthetic */ zzamu beN;
        final /* synthetic */ Type beO;
        final /* synthetic */ zzans beP;

        C04531(zzans com_google_android_gms_internal_zzans, zzamu com_google_android_gms_internal_zzamu, Type type) {
            this.beP = com_google_android_gms_internal_zzans;
            this.beN = com_google_android_gms_internal_zzamu;
            this.beO = type;
        }

        public T m64a() {
            return this.beN.zza(this.beO);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.2 */
    class C04542 implements zzanx<T> {
        final /* synthetic */ zzans beP;

        C04542(zzans com_google_android_gms_internal_zzans) {
            this.beP = com_google_android_gms_internal_zzans;
        }

        public T m65a() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.3 */
    class C04553 implements zzanx<T> {
        final /* synthetic */ zzans beP;

        C04553(zzans com_google_android_gms_internal_zzans) {
            this.beP = com_google_android_gms_internal_zzans;
        }

        public T m66a() {
            return new zzanw();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.4 */
    class C04564 implements zzanx<T> {
        final /* synthetic */ Type beO;
        final /* synthetic */ zzans beP;
        private final zzaoa beQ;
        final /* synthetic */ Class beR;

        C04564(zzans com_google_android_gms_internal_zzans, Class cls, Type type) {
            this.beP = com_google_android_gms_internal_zzans;
            this.beR = cls;
            this.beO = type;
            this.beQ = zzaoa.m17f();
        }

        public T m67a() {
            try {
                return this.beQ.zzf(this.beR);
            } catch (Throwable e) {
                String valueOf = String.valueOf(this.beO);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.5 */
    class C04575 implements zzanx<T> {
        final /* synthetic */ Type beO;
        final /* synthetic */ zzans beP;
        final /* synthetic */ zzamu beS;

        C04575(zzans com_google_android_gms_internal_zzans, zzamu com_google_android_gms_internal_zzamu, Type type) {
            this.beP = com_google_android_gms_internal_zzans;
            this.beS = com_google_android_gms_internal_zzamu;
            this.beO = type;
        }

        public T m68a() {
            return this.beS.zza(this.beO);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.6 */
    class C04586 implements zzanx<T> {
        final /* synthetic */ zzans beP;
        final /* synthetic */ Constructor beT;

        C04586(zzans com_google_android_gms_internal_zzans, Constructor constructor) {
            this.beP = com_google_android_gms_internal_zzans;
            this.beT = constructor;
        }

        public T m69a() {
            String valueOf;
            try {
                return this.beT.newInstance(null);
            } catch (Throwable e) {
                valueOf = String.valueOf(this.beT);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
            } catch (InvocationTargetException e2) {
                valueOf = String.valueOf(this.beT);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e2.getTargetException());
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.7 */
    class C04597 implements zzanx<T> {
        final /* synthetic */ zzans beP;

        C04597(zzans com_google_android_gms_internal_zzans) {
            this.beP = com_google_android_gms_internal_zzans;
        }

        public T m70a() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.8 */
    class C04608 implements zzanx<T> {
        final /* synthetic */ Type beO;
        final /* synthetic */ zzans beP;

        C04608(zzans com_google_android_gms_internal_zzans, Type type) {
            this.beP = com_google_android_gms_internal_zzans;
            this.beO = type;
        }

        public T m71a() {
            if (this.beO instanceof ParameterizedType) {
                Type type = ((ParameterizedType) this.beO).getActualTypeArguments()[0];
                if (type instanceof Class) {
                    return EnumSet.noneOf((Class) type);
                }
                String str = "Invalid EnumSet type: ";
                String valueOf = String.valueOf(this.beO.toString());
                throw new zzamz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
            str = "Invalid EnumSet type: ";
            valueOf = String.valueOf(this.beO.toString());
            throw new zzamz(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzans.9 */
    class C04619 implements zzanx<T> {
        final /* synthetic */ zzans beP;

        C04619(zzans com_google_android_gms_internal_zzans) {
            this.beP = com_google_android_gms_internal_zzans;
        }

        public T m72a() {
            return new LinkedHashSet();
        }
    }

    public zzans(Map<Type, zzamu<?>> map) {
        this.ben = map;
    }

    private <T> zzanx<T> zzc(Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C04597(this) : EnumSet.class.isAssignableFrom(cls) ? new C04608(this, type) : Set.class.isAssignableFrom(cls) ? new C04619(this) : Queue.class.isAssignableFrom(cls) ? new zzanx<T>() {
            final /* synthetic */ zzans beP;

            {
                this.beP = r1;
            }

            public T m61a() {
                return new LinkedList();
            }
        } : new zzanx<T>() {
            final /* synthetic */ zzans beP;

            {
                this.beP = r1;
            }

            public T m62a() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new zzanx<T>() {
            final /* synthetic */ zzans beP;

            {
                this.beP = r1;
            }

            public T m63a() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzaoo.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).m18s())) ? new C04553(this) : new C04542(this) : null;
    }

    private <T> zzanx<T> zzd(Type type, Class<? super T> cls) {
        return new C04564(this, cls, type);
    }

    private <T> zzanx<T> zzl(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C04586(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public String toString() {
        return this.ben.toString();
    }

    public <T> zzanx<T> zzb(zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
        Type t = com_google_android_gms_internal_zzaoo_T.m19t();
        Class s = com_google_android_gms_internal_zzaoo_T.m18s();
        zzamu com_google_android_gms_internal_zzamu = (zzamu) this.ben.get(t);
        if (com_google_android_gms_internal_zzamu != null) {
            return new C04531(this, com_google_android_gms_internal_zzamu, t);
        }
        com_google_android_gms_internal_zzamu = (zzamu) this.ben.get(s);
        if (com_google_android_gms_internal_zzamu != null) {
            return new C04575(this, com_google_android_gms_internal_zzamu, t);
        }
        zzanx<T> zzl = zzl(s);
        if (zzl != null) {
            return zzl;
        }
        zzl = zzc(t, s);
        return zzl == null ? zzd(t, s) : zzl;
    }
}
