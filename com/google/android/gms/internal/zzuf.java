package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzug.zza;

public class zzuf {
    private zzug Qq;
    private boolean zzamr;

    public zzuf() {
        this.zzamr = false;
        this.Qq = null;
    }

    public void initialize(Context context) {
        Throwable e;
        synchronized (this) {
            if (this.zzamr) {
                return;
            }
            try {
                this.Qq = zza.asInterface(zzsj.zza(context, zzsj.Mg, ModuleDescriptor.MODULE_ID).zziv("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.Qq.init(zze.zzae(context));
                this.zzamr = true;
            } catch (zzsj.zza e2) {
                e = e2;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            } catch (RemoteException e3) {
                e = e3;
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }

    public <T> T zzb(zzud<T> com_google_android_gms_internal_zzud_T) {
        synchronized (this) {
            if (this.zzamr) {
                return com_google_android_gms_internal_zzud_T.zza(this.Qq);
            }
            T zzjw = com_google_android_gms_internal_zzud_T.zzjw();
            return zzjw;
        }
    }
}
