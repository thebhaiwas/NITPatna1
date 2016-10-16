package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.ConnectionResult;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaor implements Closeable, Flushable {
    private static final String[] bhK;
    private static final String[] bhL;
    private boolean bec;
    private boolean bed;
    private String bhM;
    private String bhN;
    private boolean bhn;
    private int[] bhv;
    private int bhw;
    private final Writer out;
    private String separator;

    static {
        bhK = new String[TransportMediator.FLAG_KEY_MEDIA_NEXT];
        for (int i = 0; i <= 31; i++) {
            bhK[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        bhK[34] = "\\\"";
        bhK[92] = "\\\\";
        bhK[9] = "\\t";
        bhK[8] = "\\b";
        bhK[10] = "\\n";
        bhK[13] = "\\r";
        bhK[12] = "\\f";
        bhL = (String[]) bhK.clone();
        bhL[60] = "\\u003c";
        bhL[62] = "\\u003e";
        bhL[38] = "\\u0026";
        bhL[61] = "\\u003d";
        bhL[39] = "\\u0027";
    }

    public zzaor(Writer writer) {
        this.bhv = new int[32];
        this.bhw = 0;
        zzaec(6);
        this.separator = ":";
        this.bec = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    private int m30F() {
        if (this.bhw != 0) {
            return this.bhv[this.bhw - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m31G() throws IOException {
        if (this.bhN != null) {
            m33I();
            zzte(this.bhN);
            this.bhN = null;
        }
    }

    private void m32H() throws IOException {
        if (this.bhM != null) {
            this.out.write("\n");
            int i = this.bhw;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.bhM);
            }
        }
    }

    private void m33I() throws IOException {
        int F = m30F();
        if (F == 5) {
            this.out.write(44);
        } else if (F != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m32H();
        zzaee(4);
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            Object obj = new int[(this.bhw * 2)];
            System.arraycopy(this.bhv, 0, obj, 0, this.bhw);
            this.bhv = obj;
        }
        int[] iArr = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr[i2] = i;
    }

    private void zzaee(int i) {
        this.bhv[this.bhw - 1] = i;
    }

    private zzaor zzc(int i, int i2, String str) throws IOException {
        int F = m30F();
        if (F != i2 && F != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.bhN != null) {
            String str2 = "Dangling name: ";
            String valueOf = String.valueOf(this.bhN);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            this.bhw--;
            if (F == i2) {
                m32H();
            }
            this.out.write(str);
            return this;
        }
    }

    private void zzdd(boolean z) throws IOException {
        switch (m30F()) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                zzaee(2);
                m32H();
                return;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                this.out.append(',');
                m32H();
                return;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                this.out.append(this.separator);
                zzaee(5);
                return;
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                break;
            case ConnectionResult.NETWORK_ERROR /*7*/:
                if (!this.bhn) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.bhn || z) {
            zzaee(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private zzaor zzq(int i, String str) throws IOException {
        zzdd(true);
        zzaec(i);
        this.out.write(str);
        return this;
    }

    private void zzte(String str) throws IOException {
        int i = 0;
        String[] strArr = this.bed ? bhL : bhK;
        this.out.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.out.write(str, i, i2 - i);
                }
                this.out.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.out.write(str, i, length - i);
        }
        this.out.write("\"");
    }

    public final boolean m34D() {
        return this.bed;
    }

    public final boolean m35E() {
        return this.bec;
    }

    public void close() throws IOException {
        this.out.close();
        int i = this.bhw;
        if (i > 1 || (i == 1 && this.bhv[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.bhw = 0;
    }

    public void flush() throws IOException {
        if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public boolean isLenient() {
        return this.bhn;
    }

    public zzaor m36n() throws IOException {
        m31G();
        return zzq(1, "[");
    }

    public zzaor m37o() throws IOException {
        return zzc(1, 2, "]");
    }

    public zzaor m38p() throws IOException {
        m31G();
        return zzq(3, "{");
    }

    public zzaor m39q() throws IOException {
        return zzc(3, 5, "}");
    }

    public zzaor m40r() throws IOException {
        if (this.bhN != null) {
            if (this.bec) {
                m31G();
            } else {
                this.bhN = null;
                return this;
            }
        }
        zzdd(false);
        this.out.write("null");
        return this;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.bhM = null;
            this.separator = ":";
            return;
        }
        this.bhM = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return m40r();
        }
        m31G();
        CharSequence obj = number.toString();
        if (this.bhn || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            zzdd(false);
            this.out.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public zzaor zzcp(long j) throws IOException {
        m31G();
        zzdd(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaor zzcz(boolean z) throws IOException {
        m31G();
        zzdd(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final void zzdb(boolean z) {
        this.bed = z;
    }

    public final void zzdc(boolean z) {
        this.bec = z;
    }

    public zzaor zzta(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.bhN != null) {
            throw new IllegalStateException();
        } else if (this.bhw == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.bhN = str;
            return this;
        }
    }

    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return m40r();
        }
        m31G();
        zzdd(false);
        zzte(str);
        return this;
    }
}
