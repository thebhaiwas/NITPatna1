package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable {
    private static final Object ye;
    private static ClassLoader yf;
    private static Integer yg;
    private boolean yh;

    static {
        ye = new Object();
        yf = null;
        yg = null;
    }

    public DowngradeableSafeParcel() {
        this.yh = false;
    }

    protected static ClassLoader zzaso() {
        synchronized (ye) {
        }
        return null;
    }

    protected static Integer zzasp() {
        synchronized (ye) {
        }
        return null;
    }

    private static boolean zzd(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean zzhl(String str) {
        ClassLoader zzaso = zzaso();
        if (zzaso == null) {
            return true;
        }
        try {
            return zzd(zzaso.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean zzasq() {
        return false;
    }
}
