package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzre<T> {
    private static zza vA;
    private static int vB;
    private static String vC;
    private static final Object zzamp;
    private T vD;
    protected final String zzaxn;
    protected final T zzaxo;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    /* renamed from: com.google.android.gms.internal.zzre.1 */
    class C04971 extends zzre<Boolean> {
        C04971(String str, Boolean bool) {
            super(str, bool);
        }

        protected /* synthetic */ Object zzgz(String str) {
            return zzha(str);
        }

        protected Boolean zzha(String str) {
            return null.zza(this.zzaxn, (Boolean) this.zzaxo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.2 */
    class C04982 extends zzre<Long> {
        C04982(String str, Long l) {
            super(str, l);
        }

        protected /* synthetic */ Object zzgz(String str) {
            return zzhb(str);
        }

        protected Long zzhb(String str) {
            return null.getLong(this.zzaxn, (Long) this.zzaxo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.3 */
    class C04993 extends zzre<Integer> {
        C04993(String str, Integer num) {
            super(str, num);
        }

        protected /* synthetic */ Object zzgz(String str) {
            return zzhc(str);
        }

        protected Integer zzhc(String str) {
            return null.zzb(this.zzaxn, (Integer) this.zzaxo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.4 */
    class C05004 extends zzre<Float> {
        C05004(String str, Float f) {
            super(str, f);
        }

        protected /* synthetic */ Object zzgz(String str) {
            return zzhd(str);
        }

        protected Float zzhd(String str) {
            return null.zzb(this.zzaxn, (Float) this.zzaxo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzre.5 */
    class C05015 extends zzre<String> {
        C05015(String str, String str2) {
            super(str, str2);
        }

        protected /* synthetic */ Object zzgz(String str) {
            return zzhe(str);
        }

        protected String zzhe(String str) {
            return null.getString(this.zzaxn, (String) this.zzaxo);
        }
    }

    static {
        zzamp = new Object();
        vA = null;
        vB = 0;
        vC = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }

    protected zzre(String str, T t) {
        this.vD = null;
        this.zzaxn = str;
        this.zzaxo = t;
    }

    public static zzre<Float> zza(String str, Float f) {
        return new C05004(str, f);
    }

    public static zzre<Integer> zza(String str, Integer num) {
        return new C04993(str, num);
    }

    public static zzre<Long> zza(String str, Long l) {
        return new C04982(str, l);
    }

    public static zzre<String> zzab(String str, String str2) {
        return new C05015(str, str2);
    }

    public static zzre<Boolean> zzm(String str, boolean z) {
        return new C04971(str, Boolean.valueOf(z));
    }

    public final T get() {
        T zzgz;
        long clearCallingIdentity;
        try {
            zzgz = zzgz(this.zzaxn);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            zzgz = zzgz(this.zzaxn);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return zzgz;
    }

    protected abstract T zzgz(String str);
}
