package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class zzaoa {

    /* renamed from: com.google.android.gms.internal.zzaoa.1 */
    static class C04651 extends zzaoa {
        final /* synthetic */ Method bfA;
        final /* synthetic */ Object bfB;

        C04651(Method method, Object obj) {
            this.bfA = method;
            this.bfB = obj;
        }

        public <T> T zzf(Class<T> cls) throws Exception {
            return this.bfA.invoke(this.bfB, new Object[]{cls});
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoa.2 */
    static class C04662 extends zzaoa {
        final /* synthetic */ Method bfC;
        final /* synthetic */ int bfD;

        C04662(Method method, int i) {
            this.bfC = method;
            this.bfD = i;
        }

        public <T> T zzf(Class<T> cls) throws Exception {
            return this.bfC.invoke(null, new Object[]{cls, Integer.valueOf(this.bfD)});
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoa.3 */
    static class C04673 extends zzaoa {
        final /* synthetic */ Method bfC;

        C04673(Method method) {
            this.bfC = method;
        }

        public <T> T zzf(Class<T> cls) throws Exception {
            return this.bfC.invoke(null, new Object[]{cls, Object.class});
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoa.4 */
    static class C04684 extends zzaoa {
        C04684() {
        }

        public <T> T zzf(Class<T> cls) {
            String valueOf = String.valueOf(cls);
            throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 16).append("Cannot allocate ").append(valueOf).toString());
        }
    }

    public static zzaoa m17f() {
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new C04651(cls.getMethod("allocateInstance", new Class[]{Class.class}), declaredField.get(null));
        } catch (Exception e) {
            try {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new C04662(declaredMethod2, intValue);
            } catch (Exception e2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                    declaredMethod3.setAccessible(true);
                    return new C04673(declaredMethod3);
                } catch (Exception e3) {
                    return new C04684();
                }
            }
        }
    }

    public abstract <T> T zzf(Class<T> cls) throws Exception;
}
