package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class zzaog extends zzaor {
    private static final Writer bfM;
    private static final zzane bfN;
    private final List<zzamy> bfL;
    private String bfO;
    private zzamy bfP;

    /* renamed from: com.google.android.gms.internal.zzaog.1 */
    static class C02391 extends Writer {
        C02391() {
        }

        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    static {
        bfM = new C02391();
        bfN = new zzane("closed");
    }

    public zzaog() {
        super(bfM);
        this.bfL = new ArrayList();
        this.bfP = zzana.bes;
    }

    private zzamy m79m() {
        return (zzamy) this.bfL.get(this.bfL.size() - 1);
    }

    private void zzd(zzamy com_google_android_gms_internal_zzamy) {
        if (this.bfO != null) {
            if (!com_google_android_gms_internal_zzamy.zzczp() || m35E()) {
                ((zzanb) m79m()).zza(this.bfO, com_google_android_gms_internal_zzamy);
            }
            this.bfO = null;
        } else if (this.bfL.isEmpty()) {
            this.bfP = com_google_android_gms_internal_zzamy;
        } else {
            zzamy m = m79m();
            if (m instanceof zzamv) {
                ((zzamv) m).zzc(com_google_android_gms_internal_zzamy);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void close() throws IOException {
        if (this.bfL.isEmpty()) {
            this.bfL.add(bfN);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() throws IOException {
    }

    public zzamy m80l() {
        if (this.bfL.isEmpty()) {
            return this.bfP;
        }
        String valueOf = String.valueOf(this.bfL);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 34).append("Expected one JSON element but was ").append(valueOf).toString());
    }

    public zzaor m81n() throws IOException {
        zzamy com_google_android_gms_internal_zzamv = new zzamv();
        zzd(com_google_android_gms_internal_zzamv);
        this.bfL.add(com_google_android_gms_internal_zzamv);
        return this;
    }

    public zzaor m82o() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m79m() instanceof zzamv) {
            this.bfL.remove(this.bfL.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor m83p() throws IOException {
        zzamy com_google_android_gms_internal_zzanb = new zzanb();
        zzd(com_google_android_gms_internal_zzanb);
        this.bfL.add(com_google_android_gms_internal_zzanb);
        return this;
    }

    public zzaor m84q() throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m79m() instanceof zzanb) {
            this.bfL.remove(this.bfL.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor m85r() throws IOException {
        zzd(zzana.bes);
        return this;
    }

    public zzaor zza(Number number) throws IOException {
        if (number == null) {
            return m85r();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                String valueOf = String.valueOf(number);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("JSON forbids NaN and infinities: ").append(valueOf).toString());
            }
        }
        zzd(new zzane(number));
        return this;
    }

    public zzaor zzcp(long j) throws IOException {
        zzd(new zzane(Long.valueOf(j)));
        return this;
    }

    public zzaor zzcz(boolean z) throws IOException {
        zzd(new zzane(Boolean.valueOf(z)));
        return this;
    }

    public zzaor zzta(String str) throws IOException {
        if (this.bfL.isEmpty() || this.bfO != null) {
            throw new IllegalStateException();
        } else if (m79m() instanceof zzanb) {
            this.bfO = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public zzaor zztb(String str) throws IOException {
        if (str == null) {
            return m85r();
        }
        zzd(new zzane(str));
        return this;
    }
}
