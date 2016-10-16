package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzml.zza;

public class zzmo extends zzk<zzml> {
    public zzmo(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public zzml zzaes() throws DeadObjectException {
        return (zzml) zzarw();
    }

    protected /* synthetic */ IInterface zzbb(IBinder iBinder) {
        return zzbn(iBinder);
    }

    protected zzml zzbn(IBinder iBinder) {
        return zza.zzbl(iBinder);
    }

    protected String zzra() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzrb() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }
}
