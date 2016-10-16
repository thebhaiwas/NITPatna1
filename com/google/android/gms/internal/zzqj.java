package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class zzqj extends BroadcastReceiver {
    protected Context mContext;
    private final zza uQ;

    public static abstract class zza {
        public abstract void zzaor();
    }

    public zzqj(zza com_google_android_gms_internal_zzqj_zza) {
        this.uQ = com_google_android_gms_internal_zzqj_zza;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if (GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE.equals(obj)) {
            this.uQ.zzaor();
            unregister();
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }
}
