package com.google.android.gms.internal;

import java.math.BigInteger;

public final class zzane extends zzamy {
    private static final Class<?>[] beu;
    private Object aQx;

    static {
        beu = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    }

    public zzane(Boolean bool) {
        setValue(bool);
    }

    public zzane(Number number) {
        setValue(number);
    }

    public zzane(String str) {
        setValue(str);
    }

    private static boolean zza(zzane com_google_android_gms_internal_zzane) {
        if (!(com_google_android_gms_internal_zzane.aQx instanceof Number)) {
            return false;
        }
        Number number = (Number) com_google_android_gms_internal_zzane.aQx;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean zzck(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : beu) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzane com_google_android_gms_internal_zzane = (zzane) obj;
        if (this.aQx == null) {
            return com_google_android_gms_internal_zzane.aQx == null;
        } else {
            if (zza(this) && zza(com_google_android_gms_internal_zzane)) {
                return zzczg().longValue() == com_google_android_gms_internal_zzane.zzczg().longValue();
            } else {
                if (!(this.aQx instanceof Number) || !(com_google_android_gms_internal_zzane.aQx instanceof Number)) {
                    return this.aQx.equals(com_google_android_gms_internal_zzane.aQx);
                }
                double doubleValue = zzczg().doubleValue();
                double doubleValue2 = com_google_android_gms_internal_zzane.zzczg().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public int hashCode() {
        if (this.aQx == null) {
            return 31;
        }
        long longValue;
        if (zza(this)) {
            longValue = zzczg().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.aQx instanceof Number)) {
            return this.aQx.hashCode();
        } else {
            longValue = Double.doubleToLongBits(zzczg().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            this.aQx = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || zzck(obj);
        zzanq.zzbn(z);
        this.aQx = obj;
    }

    public Number zzczg() {
        return this.aQx instanceof String ? new zzanv((String) this.aQx) : (Number) this.aQx;
    }

    public String zzczh() {
        return zzczv() ? zzczg().toString() : zzczu() ? zzczt().toString() : (String) this.aQx;
    }

    public double zzczi() {
        return zzczv() ? zzczg().doubleValue() : Double.parseDouble(zzczh());
    }

    public long zzczj() {
        return zzczv() ? zzczg().longValue() : Long.parseLong(zzczh());
    }

    public int zzczk() {
        return zzczv() ? zzczg().intValue() : Integer.parseInt(zzczh());
    }

    public boolean zzczl() {
        return zzczu() ? zzczt().booleanValue() : Boolean.parseBoolean(zzczh());
    }

    Boolean zzczt() {
        return (Boolean) this.aQx;
    }

    public boolean zzczu() {
        return this.aQx instanceof Boolean;
    }

    public boolean zzczv() {
        return this.aQx instanceof Number;
    }

    public boolean zzczw() {
        return this.aQx instanceof String;
    }
}
