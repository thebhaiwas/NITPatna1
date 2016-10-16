package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzud.zzd;
import java.util.ArrayList;
import java.util.Collection;

public class zzue {
    private final Collection<zzud> zzaxp;
    private final Collection<zzd> zzaxq;
    private final Collection<zzd> zzaxr;

    public zzue() {
        this.zzaxp = new ArrayList();
        this.zzaxq = new ArrayList();
        this.zzaxr = new ArrayList();
    }

    public static void initialize(Context context) {
        zzuh.zzbfs().initialize(context);
    }

    public void zza(zzud com_google_android_gms_internal_zzud) {
        this.zzaxp.add(com_google_android_gms_internal_zzud);
    }
}
