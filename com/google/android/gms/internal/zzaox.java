package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzaox<M extends zzaow<M>, T> {
    protected final Class<T> bau;
    protected final boolean bic;
    public final int tag;
    protected final int type;

    private zzaox(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.bau = cls;
        this.tag = i2;
        this.bic = z;
    }

    public static <M extends zzaow<M>, T extends zzapc> zzaox<M, T> zza(int i, Class<T> cls, long j) {
        return new zzaox(i, cls, (int) j, false);
    }

    private T zzaw(List<zzape> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zzape com_google_android_gms_internal_zzape = (zzape) list.get(i);
            if (com_google_android_gms_internal_zzape.bil.length != 0) {
                zza(com_google_android_gms_internal_zzape, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.bau.cast(Array.newInstance(this.bau.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T zzax(List<zzape> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.bau.cast(zzcf(zzaou.zzaz(((zzape) list.get(list.size() - 1)).bil)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaox)) {
            return false;
        }
        zzaox com_google_android_gms_internal_zzaox = (zzaox) obj;
        return this.type == com_google_android_gms_internal_zzaox.type && this.bau == com_google_android_gms_internal_zzaox.bau && this.tag == com_google_android_gms_internal_zzaox.tag && this.bic == com_google_android_gms_internal_zzaox.bic;
    }

    public int hashCode() {
        return (this.bic ? 1 : 0) + ((((((this.type + 1147) * 31) + this.bau.hashCode()) * 31) + this.tag) * 31);
    }

    protected void zza(zzape com_google_android_gms_internal_zzape, List<Object> list) {
        list.add(zzcf(zzaou.zzaz(com_google_android_gms_internal_zzape.bil)));
    }

    void zza(Object obj, zzaov com_google_android_gms_internal_zzaov) throws IOException {
        if (this.bic) {
            zzc(obj, com_google_android_gms_internal_zzaov);
        } else {
            zzb(obj, com_google_android_gms_internal_zzaov);
        }
    }

    final T zzav(List<zzape> list) {
        return list == null ? null : this.bic ? zzaw(list) : zzax(list);
    }

    protected void zzb(Object obj, zzaov com_google_android_gms_internal_zzaov) {
        try {
            com_google_android_gms_internal_zzaov.zzaes(this.tag);
            switch (this.type) {
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    zzapc com_google_android_gms_internal_zzapc = (zzapc) obj;
                    int zzafa = zzapf.zzafa(this.tag);
                    com_google_android_gms_internal_zzaov.zzb(com_google_android_gms_internal_zzapc);
                    com_google_android_gms_internal_zzaov.zzai(zzafa, 4);
                    return;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    com_google_android_gms_internal_zzaov.zzc((zzapc) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void zzc(Object obj, zzaov com_google_android_gms_internal_zzaov) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, com_google_android_gms_internal_zzaov);
            }
        }
    }

    protected Object zzcf(zzaou com_google_android_gms_internal_zzaou) {
        String valueOf;
        Class componentType = this.bic ? this.bau.getComponentType() : this.bau;
        try {
            zzapc com_google_android_gms_internal_zzapc;
            switch (this.type) {
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    com_google_android_gms_internal_zzapc = (zzapc) componentType.newInstance();
                    com_google_android_gms_internal_zzaou.zza(com_google_android_gms_internal_zzapc, zzapf.zzafa(this.tag));
                    return com_google_android_gms_internal_zzapc;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    com_google_android_gms_internal_zzapc = (zzapc) componentType.newInstance();
                    com_google_android_gms_internal_zzaou.zza(com_google_android_gms_internal_zzapc);
                    return com_google_android_gms_internal_zzapc;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    int zzcr(Object obj) {
        return this.bic ? zzcs(obj) : zzct(obj);
    }

    protected int zzcs(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzct(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzct(Object obj) {
        int zzafa = zzapf.zzafa(this.tag);
        switch (this.type) {
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                return zzaov.zzb(zzafa, (zzapc) obj);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzaov.zzc(zzafa, (zzapc) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }
}
