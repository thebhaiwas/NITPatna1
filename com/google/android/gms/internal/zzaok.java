package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaok extends zzank<Date> {
    public static final zzanl bfE;
    private final DateFormat bge;

    /* renamed from: com.google.android.gms.internal.zzaok.1 */
    static class C04731 implements zzanl {
        C04731() {
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.m18s() == Date.class ? new zzaok() : null;
        }
    }

    static {
        bfE = new C04731();
    }

    public zzaok() {
        this.bge = new SimpleDateFormat("MMM d, yyyy");
    }

    public synchronized void zza(zzaor com_google_android_gms_internal_zzaor, Date date) throws IOException {
        com_google_android_gms_internal_zzaor.zztb(date == null ? null : this.bge.format(date));
    }

    public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        return zzm(com_google_android_gms_internal_zzaop);
    }

    public synchronized Date zzm(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        Date date;
        if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
            com_google_android_gms_internal_zzaop.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.bge.parse(com_google_android_gms_internal_zzaop.nextString()).getTime());
            } catch (Throwable e) {
                throw new zzanh(e);
            }
        }
        return date;
    }
}
