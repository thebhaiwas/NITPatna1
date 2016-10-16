package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzaof extends zzaop {
    private static final Reader bfJ;
    private static final Object bfK;
    private final List<Object> bfL;

    /* renamed from: com.google.android.gms.internal.zzaof.1 */
    static class C02381 extends Reader {
        C02381() {
        }

        public void close() throws IOException {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        bfJ = new C02381();
        bfK = new Object();
    }

    public zzaof(zzamy com_google_android_gms_internal_zzamy) {
        super(bfJ);
        this.bfL = new ArrayList();
        this.bfL.add(com_google_android_gms_internal_zzamy);
    }

    private Object m75i() {
        return this.bfL.get(this.bfL.size() - 1);
    }

    private Object m76j() {
        return this.bfL.remove(this.bfL.size() - 1);
    }

    private void zza(zzaoq com_google_android_gms_internal_zzaoq) throws IOException {
        if (m77h() != com_google_android_gms_internal_zzaoq) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzaoq);
            String valueOf2 = String.valueOf(m77h());
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
        }
    }

    public void beginArray() throws IOException {
        zza(zzaoq.BEGIN_ARRAY);
        this.bfL.add(((zzamv) m75i()).iterator());
    }

    public void beginObject() throws IOException {
        zza(zzaoq.BEGIN_OBJECT);
        this.bfL.add(((zzanb) m75i()).entrySet().iterator());
    }

    public void close() throws IOException {
        this.bfL.clear();
        this.bfL.add(bfK);
    }

    public void endArray() throws IOException {
        zza(zzaoq.END_ARRAY);
        m76j();
        m76j();
    }

    public void endObject() throws IOException {
        zza(zzaoq.END_OBJECT);
        m76j();
        m76j();
    }

    public zzaoq m77h() throws IOException {
        if (this.bfL.isEmpty()) {
            return zzaoq.END_DOCUMENT;
        }
        Object i = m75i();
        if (i instanceof Iterator) {
            boolean z = this.bfL.get(this.bfL.size() - 2) instanceof zzanb;
            Iterator it = (Iterator) i;
            if (!it.hasNext()) {
                return z ? zzaoq.END_OBJECT : zzaoq.END_ARRAY;
            } else {
                if (z) {
                    return zzaoq.NAME;
                }
                this.bfL.add(it.next());
                return m77h();
            }
        } else if (i instanceof zzanb) {
            return zzaoq.BEGIN_OBJECT;
        } else {
            if (i instanceof zzamv) {
                return zzaoq.BEGIN_ARRAY;
            }
            if (i instanceof zzane) {
                zzane com_google_android_gms_internal_zzane = (zzane) i;
                if (com_google_android_gms_internal_zzane.zzczw()) {
                    return zzaoq.STRING;
                }
                if (com_google_android_gms_internal_zzane.zzczu()) {
                    return zzaoq.BOOLEAN;
                }
                if (com_google_android_gms_internal_zzane.zzczv()) {
                    return zzaoq.NUMBER;
                }
                throw new AssertionError();
            } else if (i instanceof zzana) {
                return zzaoq.NULL;
            } else {
                if (i == bfK) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public boolean hasNext() throws IOException {
        zzaoq h = m77h();
        return (h == zzaoq.END_OBJECT || h == zzaoq.END_ARRAY) ? false : true;
    }

    public void m78k() throws IOException {
        zza(zzaoq.NAME);
        Entry entry = (Entry) ((Iterator) m75i()).next();
        this.bfL.add(entry.getValue());
        this.bfL.add(new zzane((String) entry.getKey()));
    }

    public boolean nextBoolean() throws IOException {
        zza(zzaoq.BOOLEAN);
        return ((zzane) m76j()).zzczl();
    }

    public double nextDouble() throws IOException {
        zzaoq h = m77h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            double zzczi = ((zzane) m75i()).zzczi();
            if (isLenient() || !(Double.isNaN(zzczi) || Double.isInfinite(zzczi))) {
                m76j();
                return zzczi;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + zzczi);
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public int nextInt() throws IOException {
        zzaoq h = m77h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            int zzczk = ((zzane) m75i()).zzczk();
            m76j();
            return zzczk;
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public long nextLong() throws IOException {
        zzaoq h = m77h();
        if (h == zzaoq.NUMBER || h == zzaoq.STRING) {
            long zzczj = ((zzane) m75i()).zzczj();
            m76j();
            return zzczj;
        }
        String valueOf = String.valueOf(zzaoq.NUMBER);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public String nextName() throws IOException {
        zza(zzaoq.NAME);
        Entry entry = (Entry) ((Iterator) m75i()).next();
        this.bfL.add(entry.getValue());
        return (String) entry.getKey();
    }

    public void nextNull() throws IOException {
        zza(zzaoq.NULL);
        m76j();
    }

    public String nextString() throws IOException {
        zzaoq h = m77h();
        if (h == zzaoq.STRING || h == zzaoq.NUMBER) {
            return ((zzane) m76j()).zzczh();
        }
        String valueOf = String.valueOf(zzaoq.STRING);
        String valueOf2 = String.valueOf(h);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public void skipValue() throws IOException {
        if (m77h() == zzaoq.NAME) {
            nextName();
        } else {
            m76j();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
