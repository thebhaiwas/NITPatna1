package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class zzud<T> {
    private final int zzaxm;
    private final String zzaxn;
    private final T zzaxo;

    public static class zza extends zzud<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(str, bool, null);
        }

        public /* synthetic */ Object zza(zzug com_google_android_gms_internal_zzug) {
            return zzb(com_google_android_gms_internal_zzug);
        }

        public Boolean zzb(zzug com_google_android_gms_internal_zzug) {
            try {
                return Boolean.valueOf(com_google_android_gms_internal_zzug.getBooleanFlagValue(getKey(), ((Boolean) zzjw()).booleanValue(), getSource()));
            } catch (RemoteException e) {
                return (Boolean) zzjw();
            }
        }
    }

    public static class zzb extends zzud<Integer> {
        public zzb(int i, String str, Integer num) {
            super(str, num, null);
        }

        public /* synthetic */ Object zza(zzug com_google_android_gms_internal_zzug) {
            return zzc(com_google_android_gms_internal_zzug);
        }

        public Integer zzc(zzug com_google_android_gms_internal_zzug) {
            try {
                return Integer.valueOf(com_google_android_gms_internal_zzug.getIntFlagValue(getKey(), ((Integer) zzjw()).intValue(), getSource()));
            } catch (RemoteException e) {
                return (Integer) zzjw();
            }
        }
    }

    public static class zzc extends zzud<Long> {
        public zzc(int i, String str, Long l) {
            super(str, l, null);
        }

        public /* synthetic */ Object zza(zzug com_google_android_gms_internal_zzug) {
            return zzd(com_google_android_gms_internal_zzug);
        }

        public Long zzd(zzug com_google_android_gms_internal_zzug) {
            try {
                return Long.valueOf(com_google_android_gms_internal_zzug.getLongFlagValue(getKey(), ((Long) zzjw()).longValue(), getSource()));
            } catch (RemoteException e) {
                return (Long) zzjw();
            }
        }
    }

    public static class zzd extends zzud<String> {
        public zzd(int i, String str, String str2) {
            super(str, str2, null);
        }

        public /* synthetic */ Object zza(zzug com_google_android_gms_internal_zzug) {
            return zze(com_google_android_gms_internal_zzug);
        }

        public String zze(zzug com_google_android_gms_internal_zzug) {
            try {
                return com_google_android_gms_internal_zzug.getStringFlagValue(getKey(), (String) zzjw(), getSource());
            } catch (RemoteException e) {
                return (String) zzjw();
            }
        }
    }

    private zzud(int i, String str, T t) {
        this.zzaxm = i;
        this.zzaxn = str;
        this.zzaxo = t;
        zzuh.zzbfr().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return zzuh.zzbfs().zzb(this);
    }

    public String getKey() {
        return this.zzaxn;
    }

    public int getSource() {
        return this.zzaxm;
    }

    protected abstract T zza(zzug com_google_android_gms_internal_zzug);

    public T zzjw() {
        return this.zzaxo;
    }
}
