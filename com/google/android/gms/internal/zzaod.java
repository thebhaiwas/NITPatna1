package com.google.android.gms.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class zzaod extends zzank<Date> {
    public static final zzanl bfE;
    private final DateFormat bdO;
    private final DateFormat bdP;
    private final DateFormat bdQ;

    /* renamed from: com.google.android.gms.internal.zzaod.1 */
    static class C04701 implements zzanl {
        C04701() {
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.m18s() == Date.class ? new zzaod() : null;
        }
    }

    static {
        bfE = new C04701();
    }

    public zzaod() {
        this.bdO = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        this.bdP = DateFormat.getDateTimeInstance(2, 2);
        this.bdQ = m74g();
    }

    private static DateFormat m74g() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private synchronized Date zzsz(String str) {
        Date parse;
        try {
            parse = this.bdP.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.bdO.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.bdQ.parse(str);
                } catch (Throwable e3) {
                    throw new zzanh(str, e3);
                }
            }
        }
        return parse;
    }

    public synchronized void zza(zzaor com_google_android_gms_internal_zzaor, Date date) throws IOException {
        if (date == null) {
            com_google_android_gms_internal_zzaor.m40r();
        } else {
            com_google_android_gms_internal_zzaor.zztb(this.bdO.format(date));
        }
    }

    public /* synthetic */ Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        return zzk(com_google_android_gms_internal_zzaop);
    }

    public Date zzk(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        if (com_google_android_gms_internal_zzaop.m29h() != zzaoq.NULL) {
            return zzsz(com_google_android_gms_internal_zzaop.nextString());
        }
        com_google_android_gms_internal_zzaop.nextNull();
        return null;
    }
}
