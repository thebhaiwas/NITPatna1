package com.google.android.gms.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class zzaol extends zzank<Time> {
    public static final zzanl bfE;
    private final DateFormat bge;

    /* renamed from: com.google.android.gms.internal.zzaol.1 */
    static class C04741 implements zzanl {
        C04741() {
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.m18s() == Time.class ? new zzaol() : null;
        }
    }

    static {
        bfE = new C04741();
    }

    public zzaol() {
        this.bge = new SimpleDateFormat("hh:mm:ss a");
    }

    public synchronized void zza(zzaor com_google_android_gms_internal_zzaor, Time time) throws IOException {
        com_google_android_gms_internal_zzaor.zztb(time == null ? null : this.bge.format(time));
    }

    public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        return zzn(com_google_android_gms_internal_zzaop);
    }

    public synchronized Time zzn(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        Time time;
        if (com_google_android_gms_internal_zzaop.m29h() == zzaoq.NULL) {
            com_google_android_gms_internal_zzaop.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.bge.parse(com_google_android_gms_internal_zzaop.nextString()).getTime());
            } catch (Throwable e) {
                throw new zzanh(e);
            }
        }
        return time;
    }
}
