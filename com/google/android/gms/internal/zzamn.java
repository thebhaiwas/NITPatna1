package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class zzamn implements zzamx<Date>, zzang<Date> {
    private final DateFormat bdO;
    private final DateFormat bdP;
    private final DateFormat bdQ;

    zzamn() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public zzamn(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    zzamn(String str) {
        this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
    }

    zzamn(DateFormat dateFormat, DateFormat dateFormat2) {
        this.bdO = dateFormat;
        this.bdP = dateFormat2;
        this.bdQ = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.bdQ.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date zza(zzamy com_google_android_gms_internal_zzamy) {
        Date parse;
        synchronized (this.bdP) {
            try {
                parse = this.bdP.parse(com_google_android_gms_internal_zzamy.zzczh());
            } catch (ParseException e) {
                try {
                    parse = this.bdO.parse(com_google_android_gms_internal_zzamy.zzczh());
                } catch (ParseException e2) {
                    try {
                        parse = this.bdQ.parse(com_google_android_gms_internal_zzamy.zzczh());
                    } catch (Throwable e3) {
                        throw new zzanh(com_google_android_gms_internal_zzamy.zzczh(), e3);
                    }
                }
            }
        }
        return parse;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(zzamn.class.getSimpleName());
        stringBuilder.append('(').append(this.bdP.getClass().getSimpleName()).append(')');
        return stringBuilder.toString();
    }

    public zzamy zza(Date date, Type type, zzanf com_google_android_gms_internal_zzanf) {
        zzamy com_google_android_gms_internal_zzane;
        synchronized (this.bdP) {
            com_google_android_gms_internal_zzane = new zzane(this.bdO.format(date));
        }
        return com_google_android_gms_internal_zzane;
    }

    public Date zza(zzamy com_google_android_gms_internal_zzamy, Type type, zzamw com_google_android_gms_internal_zzamw) throws zzanc {
        if (com_google_android_gms_internal_zzamy instanceof zzane) {
            Date zza = zza(com_google_android_gms_internal_zzamy);
            if (type == Date.class) {
                return zza;
            }
            if (type == Timestamp.class) {
                return new Timestamp(zza.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(zza.getTime());
            }
            String valueOf = String.valueOf(getClass());
            String valueOf2 = String.valueOf(type);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot deserialize to ").append(valueOf2).toString());
        }
        throw new zzanc("The date should be a string value");
    }

    public /* synthetic */ Object zzb(zzamy com_google_android_gms_internal_zzamy, Type type, zzamw com_google_android_gms_internal_zzamw) throws zzanc {
        return zza(com_google_android_gms_internal_zzamy, type, com_google_android_gms_internal_zzamw);
    }
}
