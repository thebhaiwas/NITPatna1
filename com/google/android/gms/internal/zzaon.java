package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzaon {
    public static final zzanl bgA;
    public static final zzank<String> bgB;
    public static final zzank<BigDecimal> bgC;
    public static final zzank<BigInteger> bgD;
    public static final zzanl bgE;
    public static final zzank<StringBuilder> bgF;
    public static final zzanl bgG;
    public static final zzank<StringBuffer> bgH;
    public static final zzanl bgI;
    public static final zzank<URL> bgJ;
    public static final zzanl bgK;
    public static final zzank<URI> bgL;
    public static final zzanl bgM;
    public static final zzank<InetAddress> bgN;
    public static final zzanl bgO;
    public static final zzank<UUID> bgP;
    public static final zzanl bgQ;
    public static final zzanl bgR;
    public static final zzank<Calendar> bgS;
    public static final zzanl bgT;
    public static final zzank<Locale> bgU;
    public static final zzanl bgV;
    public static final zzank<zzamy> bgW;
    public static final zzanl bgX;
    public static final zzanl bgY;
    public static final zzank<Class> bgh;
    public static final zzanl bgi;
    public static final zzank<BitSet> bgj;
    public static final zzanl bgk;
    public static final zzank<Boolean> bgl;
    public static final zzank<Boolean> bgm;
    public static final zzanl bgn;
    public static final zzank<Number> bgo;
    public static final zzanl bgp;
    public static final zzank<Number> bgq;
    public static final zzanl bgr;
    public static final zzank<Number> bgs;
    public static final zzanl bgt;
    public static final zzank<Number> bgu;
    public static final zzank<Number> bgv;
    public static final zzank<Number> bgw;
    public static final zzank<Number> bgx;
    public static final zzanl bgy;
    public static final zzank<Character> bgz;

    /* renamed from: com.google.android.gms.internal.zzaon.26 */
    static /* synthetic */ class AnonymousClass26 {
        static final /* synthetic */ int[] bfU;

        static {
            bfU = new int[zzaoq.values().length];
            try {
                bfU[zzaoq.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bfU[zzaoq.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bfU[zzaoq.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bfU[zzaoq.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bfU[zzaoq.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bfU[zzaoq.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                bfU[zzaoq.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                bfU[zzaoq.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                bfU[zzaoq.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                bfU[zzaoq.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.1 */
    static class C04761 extends zzank<Class> {
        C04761() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Class cls) throws IOException {
            if (cls == null) {
                com_google_android_gms_internal_zzaor.m40r();
            } else {
                String valueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzo(com_google_android_gms_internal_zzaop);
        }

        public Class zzo(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.20 */
    static class AnonymousClass20 implements zzanl {
        final /* synthetic */ zzaoo bfd;
        final /* synthetic */ zzank bhb;

        AnonymousClass20(zzaoo com_google_android_gms_internal_zzaoo, zzank com_google_android_gms_internal_zzank) {
            this.bfd = com_google_android_gms_internal_zzaoo;
            this.bhb = com_google_android_gms_internal_zzank;
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.equals(this.bfd) ? this.bhb : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.21 */
    static class AnonymousClass21 implements zzanl {
        final /* synthetic */ zzank bhb;
        final /* synthetic */ Class bhc;

        AnonymousClass21(Class cls, zzank com_google_android_gms_internal_zzank) {
            this.bhc = cls;
            this.bhb = com_google_android_gms_internal_zzank;
        }

        public String toString() {
            String valueOf = String.valueOf(this.bhc.getName());
            String valueOf2 = String.valueOf(this.bhb);
            return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.m18s() == this.bhc ? this.bhb : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.22 */
    static class AnonymousClass22 implements zzanl {
        final /* synthetic */ zzank bhb;
        final /* synthetic */ Class bhd;
        final /* synthetic */ Class bhe;

        AnonymousClass22(Class cls, Class cls2, zzank com_google_android_gms_internal_zzank) {
            this.bhd = cls;
            this.bhe = cls2;
            this.bhb = com_google_android_gms_internal_zzank;
        }

        public String toString() {
            String valueOf = String.valueOf(this.bhe.getName());
            String valueOf2 = String.valueOf(this.bhd.getName());
            String valueOf3 = String.valueOf(this.bhb);
            return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            Class s = com_google_android_gms_internal_zzaoo_T.m18s();
            return (s == this.bhd || s == this.bhe) ? this.bhb : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.24 */
    static class AnonymousClass24 implements zzanl {
        final /* synthetic */ zzank bhb;
        final /* synthetic */ Class bhf;
        final /* synthetic */ Class bhg;

        AnonymousClass24(Class cls, Class cls2, zzank com_google_android_gms_internal_zzank) {
            this.bhf = cls;
            this.bhg = cls2;
            this.bhb = com_google_android_gms_internal_zzank;
        }

        public String toString() {
            String valueOf = String.valueOf(this.bhf.getName());
            String valueOf2 = String.valueOf(this.bhg.getName());
            String valueOf3 = String.valueOf(this.bhb);
            return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            Class s = com_google_android_gms_internal_zzaoo_T.m18s();
            return (s == this.bhf || s == this.bhg) ? this.bhb : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.25 */
    static class AnonymousClass25 implements zzanl {
        final /* synthetic */ zzank bhb;
        final /* synthetic */ Class bhh;

        AnonymousClass25(Class cls, zzank com_google_android_gms_internal_zzank) {
            this.bhh = cls;
            this.bhb = com_google_android_gms_internal_zzank;
        }

        public String toString() {
            String valueOf = String.valueOf(this.bhh.getName());
            String valueOf2 = String.valueOf(this.bhb);
            return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return this.bhh.isAssignableFrom(com_google_android_gms_internal_zzaoo_T.m18s()) ? this.bhb : null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.2 */
    static class C04772 extends zzank<Number> {
        C04772() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
            com_google_android_gms_internal_zzaor.zza(number);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzg(com_google_android_gms_internal_zzaop);
        }

        public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return Double.valueOf(com_google_android_gms_internal_zzaop.nextDouble());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.3 */
    static class C04783 extends zzank<Number> {
        C04783() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
            com_google_android_gms_internal_zzaor.zza(number);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzg(com_google_android_gms_internal_zzaop);
        }

        public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            zzaoq h = com_google_android_gms_internal_zzaop.m29h();
            switch (AnonymousClass26.bfU[h.ordinal()]) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    return new zzanv(com_google_android_gms_internal_zzaop.nextString());
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                default:
                    String valueOf = String.valueOf(h);
                    throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.4 */
    static class C04794 extends zzank<Character> {
        C04794() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, Character ch) throws IOException {
            com_google_android_gms_internal_zzaor.zztb(ch == null ? null : String.valueOf(ch));
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzp(com_google_android_gms_internal_zzaop);
        }

        public Character zzp(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            String nextString = com_google_android_gms_internal_zzaop.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String str = "Expecting character, got: ";
            nextString = String.valueOf(nextString);
            throw new zzanh(nextString.length() != 0 ? str.concat(nextString) : new String(str));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.5 */
    static class C04805 extends zzank<String> {
        C04805() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, String str) throws IOException {
            com_google_android_gms_internal_zzaor.zztb(str);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzq(com_google_android_gms_internal_zzaop);
        }

        public String zzq(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            zzaoq h = com_google_android_gms_internal_zzaop.m29h();
            if (h != zzaoq.NULL) {
                return h == zzaoq.BOOLEAN ? Boolean.toString(com_google_android_gms_internal_zzaop.nextBoolean()) : com_google_android_gms_internal_zzaop.nextString();
            } else {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.6 */
    static class C04816 extends zzank<BigDecimal> {
        C04816() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, BigDecimal bigDecimal) throws IOException {
            com_google_android_gms_internal_zzaor.zza(bigDecimal);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzr(com_google_android_gms_internal_zzaop);
        }

        public BigDecimal zzr(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            try {
                return new BigDecimal(com_google_android_gms_internal_zzaop.nextString());
            } catch (Throwable e) {
                throw new zzanh(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.7 */
    static class C04827 extends zzank<BigInteger> {
        C04827() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, BigInteger bigInteger) throws IOException {
            com_google_android_gms_internal_zzaor.zza(bigInteger);
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzs(com_google_android_gms_internal_zzaop);
        }

        public BigInteger zzs(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
            try {
                return new BigInteger(com_google_android_gms_internal_zzaop.nextString());
            } catch (Throwable e) {
                throw new zzanh(e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.8 */
    static class C04838 extends zzank<StringBuilder> {
        C04838() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, StringBuilder stringBuilder) throws IOException {
            com_google_android_gms_internal_zzaor.zztb(stringBuilder == null ? null : stringBuilder.toString());
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzt(com_google_android_gms_internal_zzaop);
        }

        public StringBuilder zzt(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return new StringBuilder(com_google_android_gms_internal_zzaop.nextString());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaon.9 */
    static class C04849 extends zzank<StringBuffer> {
        C04849() {
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, StringBuffer stringBuffer) throws IOException {
            com_google_android_gms_internal_zzaor.zztb(stringBuffer == null ? null : stringBuffer.toString());
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzu(com_google_android_gms_internal_zzaop);
        }

        public StringBuffer zzu(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return new StringBuffer(com_google_android_gms_internal_zzaop.nextString());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }
    }

    private static final class zza<T extends Enum<T>> extends zzank<T> {
        private final Map<String, T> bhi;
        private final Map<T, String> bhj;

        public zza(Class<T> cls) {
            this.bhi = new HashMap();
            this.bhj = new HashMap();
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzann com_google_android_gms_internal_zzann = (zzann) cls.getField(name).getAnnotation(zzann.class);
                    if (com_google_android_gms_internal_zzann != null) {
                        name = com_google_android_gms_internal_zzann.value();
                        for (Object put : com_google_android_gms_internal_zzann.zzczy()) {
                            this.bhi.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.bhi.put(str, enumR);
                    this.bhj.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void zza(zzaor com_google_android_gms_internal_zzaor, T t) throws IOException {
            com_google_android_gms_internal_zzaor.zztb(t == null ? null : (String) this.bhj.get(t));
        }

        public T zzaf(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                return (Enum) this.bhi.get(com_google_android_gms_internal_zzaop.nextString());
            }
            com_google_android_gms_internal_zzaop.nextNull();
            return null;
        }

        public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            return zzaf(com_google_android_gms_internal_zzaop);
        }
    }

    static {
        bgh = new C04761();
        bgi = zza(Class.class, bgh);
        bgj = new zzank<BitSet>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    com_google_android_gms_internal_zzaor.m40r();
                    return;
                }
                com_google_android_gms_internal_zzaor.m36n();
                for (int i = 0; i < bitSet.length(); i++) {
                    com_google_android_gms_internal_zzaor.zzcp((long) (bitSet.get(i) ? 1 : 0));
                }
                com_google_android_gms_internal_zzaor.m37o();
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzx(com_google_android_gms_internal_zzaop);
            }

            public BitSet zzx(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                BitSet bitSet = new BitSet();
                com_google_android_gms_internal_zzaop.beginArray();
                zzaoq h = com_google_android_gms_internal_zzaop.m29h();
                int i = 0;
                while (h != zzaoq.END_ARRAY) {
                    boolean z;
                    String valueOf;
                    switch (AnonymousClass26.bfU[h.ordinal()]) {
                        case ConnectionResult.SERVICE_MISSING /*1*/:
                            if (com_google_android_gms_internal_zzaop.nextInt() == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                            z = com_google_android_gms_internal_zzaop.nextBoolean();
                            break;
                        case ConnectionResult.SERVICE_DISABLED /*3*/:
                            Object nextString = com_google_android_gms_internal_zzaop.nextString();
                            try {
                                if (Integer.parseInt(nextString) == 0) {
                                    z = false;
                                    break;
                                }
                                z = true;
                                break;
                            } catch (NumberFormatException e) {
                                String str = "Error: Expecting: bitset number value (1, 0), Found: ";
                                valueOf = String.valueOf(nextString);
                                throw new zzanh(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            }
                        default:
                            valueOf = String.valueOf(h);
                            throw new zzanh(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Invalid bitset value type: ").append(valueOf).toString());
                    }
                    if (z) {
                        bitSet.set(i);
                    }
                    i++;
                    h = com_google_android_gms_internal_zzaop.m29h();
                }
                com_google_android_gms_internal_zzaop.endArray();
                return bitSet;
            }
        };
        bgk = zza(BitSet.class, bgj);
        bgl = new zzank<Boolean>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Boolean bool) throws IOException {
                if (bool == null) {
                    com_google_android_gms_internal_zzaor.m40r();
                } else {
                    com_google_android_gms_internal_zzaor.zzcz(bool.booleanValue());
                }
            }

            public Boolean zzae(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                    return com_google_android_gms_internal_zzaop.m29h() == zzaoq.STRING ? Boolean.valueOf(Boolean.parseBoolean(com_google_android_gms_internal_zzaop.nextString())) : Boolean.valueOf(com_google_android_gms_internal_zzaop.nextBoolean());
                } else {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzae(com_google_android_gms_internal_zzaop);
            }
        };
        bgm = new zzank<Boolean>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Boolean bool) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(bool == null ? "null" : bool.toString());
            }

            public Boolean zzae(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                    return Boolean.valueOf(com_google_android_gms_internal_zzaop.nextString());
                }
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzae(com_google_android_gms_internal_zzaop);
            }
        };
        bgn = zza(Boolean.TYPE, Boolean.class, bgl);
        bgo = new zzank<Number>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
                com_google_android_gms_internal_zzaor.zza(number);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzg(com_google_android_gms_internal_zzaop);
            }

            public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) com_google_android_gms_internal_zzaop.nextInt());
                } catch (Throwable e) {
                    throw new zzanh(e);
                }
            }
        };
        bgp = zza(Byte.TYPE, Byte.class, bgo);
        bgq = new zzank<Number>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
                com_google_android_gms_internal_zzaor.zza(number);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzg(com_google_android_gms_internal_zzaop);
            }

            public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) com_google_android_gms_internal_zzaop.nextInt());
                } catch (Throwable e) {
                    throw new zzanh(e);
                }
            }
        };
        bgr = zza(Short.TYPE, Short.class, bgq);
        bgs = new zzank<Number>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
                com_google_android_gms_internal_zzaor.zza(number);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzg(com_google_android_gms_internal_zzaop);
            }

            public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(com_google_android_gms_internal_zzaop.nextInt());
                } catch (Throwable e) {
                    throw new zzanh(e);
                }
            }
        };
        bgt = zza(Integer.TYPE, Integer.class, bgs);
        bgu = new zzank<Number>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
                com_google_android_gms_internal_zzaor.zza(number);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzg(com_google_android_gms_internal_zzaop);
            }

            public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(com_google_android_gms_internal_zzaop.nextLong());
                } catch (Throwable e) {
                    throw new zzanh(e);
                }
            }
        };
        bgv = new zzank<Number>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Number number) throws IOException {
                com_google_android_gms_internal_zzaor.zza(number);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzg(com_google_android_gms_internal_zzaop);
            }

            public Number zzg(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                    return Float.valueOf((float) com_google_android_gms_internal_zzaop.nextDouble());
                }
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
        };
        bgw = new C04772();
        bgx = new C04783();
        bgy = zza(Number.class, bgx);
        bgz = new C04794();
        bgA = zza(Character.TYPE, Character.class, bgz);
        bgB = new C04805();
        bgC = new C04816();
        bgD = new C04827();
        bgE = zza(String.class, bgB);
        bgF = new C04838();
        bgG = zza(StringBuilder.class, bgF);
        bgH = new C04849();
        bgI = zza(StringBuffer.class, bgH);
        bgJ = new zzank<URL>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, URL url) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(url == null ? null : url.toExternalForm());
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzv(com_google_android_gms_internal_zzaop);
            }

            public URL zzv(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                String nextString = com_google_android_gms_internal_zzaop.nextString();
                return !"null".equals(nextString) ? new URL(nextString) : null;
            }
        };
        bgK = zza(URL.class, bgJ);
        bgL = new zzank<URI>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, URI uri) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(uri == null ? null : uri.toASCIIString());
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzw(com_google_android_gms_internal_zzaop);
            }

            public URI zzw(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                URI uri = null;
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                } else {
                    try {
                        String nextString = com_google_android_gms_internal_zzaop.nextString();
                        if (!"null".equals(nextString)) {
                            uri = new URI(nextString);
                        }
                    } catch (Throwable e) {
                        throw new zzamz(e);
                    }
                }
                return uri;
            }
        };
        bgM = zza(URI.class, bgL);
        bgN = new zzank<InetAddress>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, InetAddress inetAddress) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(inetAddress == null ? null : inetAddress.getHostAddress());
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzy(com_google_android_gms_internal_zzaop);
            }

            public InetAddress zzy(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                    return InetAddress.getByName(com_google_android_gms_internal_zzaop.nextString());
                }
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
        };
        bgO = zzb(InetAddress.class, bgN);
        bgP = new zzank<UUID>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, UUID uuid) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(uuid == null ? null : uuid.toString());
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzz(com_google_android_gms_internal_zzaop);
            }

            public UUID zzz(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
                    return UUID.fromString(com_google_android_gms_internal_zzaop.nextString());
                }
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            }
        };
        bgQ = zza(UUID.class, bgP);
        bgR = new zzanl() {

            /* renamed from: com.google.android.gms.internal.zzaon.15.1 */
            class C04751 extends zzank<Timestamp> {
                final /* synthetic */ zzank bgZ;
                final /* synthetic */ AnonymousClass15 bha;

                C04751(AnonymousClass15 anonymousClass15, zzank com_google_android_gms_internal_zzank) {
                    this.bha = anonymousClass15;
                    this.bgZ = com_google_android_gms_internal_zzank;
                }

                public void zza(zzaor com_google_android_gms_internal_zzaor, Timestamp timestamp) throws IOException {
                    this.bgZ.zza(com_google_android_gms_internal_zzaor, timestamp);
                }

                public Timestamp zzaa(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                    Date date = (Date) this.bgZ.zzb(com_google_android_gms_internal_zzaop);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                    return zzaa(com_google_android_gms_internal_zzaop);
                }
            }

            public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
                return com_google_android_gms_internal_zzaoo_T.m18s() != Timestamp.class ? null : new C04751(this, com_google_android_gms_internal_zzams.zzk(Date.class));
            }
        };
        bgS = new zzank<Calendar>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Calendar calendar) throws IOException {
                if (calendar == null) {
                    com_google_android_gms_internal_zzaor.m40r();
                    return;
                }
                com_google_android_gms_internal_zzaor.m38p();
                com_google_android_gms_internal_zzaor.zzta("year");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(1));
                com_google_android_gms_internal_zzaor.zzta("month");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(2));
                com_google_android_gms_internal_zzaor.zzta("dayOfMonth");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(5));
                com_google_android_gms_internal_zzaor.zzta("hourOfDay");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(11));
                com_google_android_gms_internal_zzaor.zzta("minute");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(12));
                com_google_android_gms_internal_zzaor.zzta("second");
                com_google_android_gms_internal_zzaor.zzcp((long) calendar.get(13));
                com_google_android_gms_internal_zzaor.m39q();
            }

            public Calendar zzab(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                int i = 0;
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                com_google_android_gms_internal_zzaop.beginObject();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (com_google_android_gms_internal_zzaop.m29h() != zzaoq.END_OBJECT) {
                    String nextName = com_google_android_gms_internal_zzaop.nextName();
                    int nextInt = com_google_android_gms_internal_zzaop.nextInt();
                    if ("year".equals(nextName)) {
                        i6 = nextInt;
                    } else if ("month".equals(nextName)) {
                        i5 = nextInt;
                    } else if ("dayOfMonth".equals(nextName)) {
                        i4 = nextInt;
                    } else if ("hourOfDay".equals(nextName)) {
                        i3 = nextInt;
                    } else if ("minute".equals(nextName)) {
                        i2 = nextInt;
                    } else if ("second".equals(nextName)) {
                        i = nextInt;
                    }
                }
                com_google_android_gms_internal_zzaop.endObject();
                return new GregorianCalendar(i6, i5, i4, i3, i2, i);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzab(com_google_android_gms_internal_zzaop);
            }
        };
        bgT = zzb(Calendar.class, GregorianCalendar.class, bgS);
        bgU = new zzank<Locale>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, Locale locale) throws IOException {
                com_google_android_gms_internal_zzaor.zztb(locale == null ? null : locale.toString());
            }

            public Locale zzac(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
                    com_google_android_gms_internal_zzaop.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(com_google_android_gms_internal_zzaop.nextString(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzac(com_google_android_gms_internal_zzaop);
            }
        };
        bgV = zza(Locale.class, bgU);
        bgW = new zzank<zzamy>() {
            public void zza(zzaor com_google_android_gms_internal_zzaor, zzamy com_google_android_gms_internal_zzamy) throws IOException {
                if (com_google_android_gms_internal_zzamy == null || com_google_android_gms_internal_zzamy.zzczp()) {
                    com_google_android_gms_internal_zzaor.m40r();
                } else if (com_google_android_gms_internal_zzamy.zzczo()) {
                    zzane zzczs = com_google_android_gms_internal_zzamy.zzczs();
                    if (zzczs.zzczv()) {
                        com_google_android_gms_internal_zzaor.zza(zzczs.zzczg());
                    } else if (zzczs.zzczu()) {
                        com_google_android_gms_internal_zzaor.zzcz(zzczs.zzczl());
                    } else {
                        com_google_android_gms_internal_zzaor.zztb(zzczs.zzczh());
                    }
                } else if (com_google_android_gms_internal_zzamy.zzczm()) {
                    com_google_android_gms_internal_zzaor.m36n();
                    Iterator it = com_google_android_gms_internal_zzamy.zzczr().iterator();
                    while (it.hasNext()) {
                        zza(com_google_android_gms_internal_zzaor, (zzamy) it.next());
                    }
                    com_google_android_gms_internal_zzaor.m37o();
                } else if (com_google_android_gms_internal_zzamy.zzczn()) {
                    com_google_android_gms_internal_zzaor.m38p();
                    for (Entry entry : com_google_android_gms_internal_zzamy.zzczq().entrySet()) {
                        com_google_android_gms_internal_zzaor.zzta((String) entry.getKey());
                        zza(com_google_android_gms_internal_zzaor, (zzamy) entry.getValue());
                    }
                    com_google_android_gms_internal_zzaor.m39q();
                } else {
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzamy.getClass());
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
                }
            }

            public zzamy zzad(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                zzamy com_google_android_gms_internal_zzamv;
                switch (AnonymousClass26.bfU[com_google_android_gms_internal_zzaop.m29h().ordinal()]) {
                    case ConnectionResult.SERVICE_MISSING /*1*/:
                        return new zzane(new zzanv(com_google_android_gms_internal_zzaop.nextString()));
                    case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                        return new zzane(Boolean.valueOf(com_google_android_gms_internal_zzaop.nextBoolean()));
                    case ConnectionResult.SERVICE_DISABLED /*3*/:
                        return new zzane(com_google_android_gms_internal_zzaop.nextString());
                    case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                        com_google_android_gms_internal_zzaop.nextNull();
                        return zzana.bes;
                    case ConnectionResult.INVALID_ACCOUNT /*5*/:
                        com_google_android_gms_internal_zzamv = new zzamv();
                        com_google_android_gms_internal_zzaop.beginArray();
                        while (com_google_android_gms_internal_zzaop.hasNext()) {
                            com_google_android_gms_internal_zzamv.zzc((zzamy) zzb(com_google_android_gms_internal_zzaop));
                        }
                        com_google_android_gms_internal_zzaop.endArray();
                        return com_google_android_gms_internal_zzamv;
                    case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                        com_google_android_gms_internal_zzamv = new zzanb();
                        com_google_android_gms_internal_zzaop.beginObject();
                        while (com_google_android_gms_internal_zzaop.hasNext()) {
                            com_google_android_gms_internal_zzamv.zza(com_google_android_gms_internal_zzaop.nextName(), (zzamy) zzb(com_google_android_gms_internal_zzaop));
                        }
                        com_google_android_gms_internal_zzaop.endObject();
                        return com_google_android_gms_internal_zzamv;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
                return zzad(com_google_android_gms_internal_zzaop);
            }
        };
        bgX = zzb(zzamy.class, bgW);
        bgY = new zzanl() {
            public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
                Class s = com_google_android_gms_internal_zzaoo_T.m18s();
                if (!Enum.class.isAssignableFrom(s) || s == Enum.class) {
                    return null;
                }
                if (!s.isEnum()) {
                    s = s.getSuperclass();
                }
                return new zza(s);
            }
        };
    }

    public static <TT> zzanl zza(zzaoo<TT> com_google_android_gms_internal_zzaoo_TT, zzank<TT> com_google_android_gms_internal_zzank_TT) {
        return new AnonymousClass20(com_google_android_gms_internal_zzaoo_TT, com_google_android_gms_internal_zzank_TT);
    }

    public static <TT> zzanl zza(Class<TT> cls, zzank<TT> com_google_android_gms_internal_zzank_TT) {
        return new AnonymousClass21(cls, com_google_android_gms_internal_zzank_TT);
    }

    public static <TT> zzanl zza(Class<TT> cls, Class<TT> cls2, zzank<? super TT> com_google_android_gms_internal_zzank__super_TT) {
        return new AnonymousClass22(cls, cls2, com_google_android_gms_internal_zzank__super_TT);
    }

    public static <TT> zzanl zzb(Class<TT> cls, zzank<TT> com_google_android_gms_internal_zzank_TT) {
        return new AnonymousClass25(cls, com_google_android_gms_internal_zzank_TT);
    }

    public static <TT> zzanl zzb(Class<TT> cls, Class<? extends TT> cls2, zzank<? super TT> com_google_android_gms_internal_zzank__super_TT) {
        return new AnonymousClass24(cls, cls2, com_google_android_gms_internal_zzank__super_TT);
    }
}
