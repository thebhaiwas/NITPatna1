package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzrp.zza;

public class zzrn extends zzk<zzrp> {
    public zzrn(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzbb(IBinder iBinder) {
        return zzdy(iBinder);
    }

    protected zzrp zzdy(IBinder iBinder) {
        return zza.zzea(iBinder);
    }

    public String zzra() {
        return "com.google.android.gms.common.service.START";
    }

    protected String zzrb() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
