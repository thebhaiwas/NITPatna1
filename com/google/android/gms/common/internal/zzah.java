package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzah<T extends IInterface> extends zzk<T> {
    private final zzg<T> zb;

    public zzah(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg, zzg<T> com_google_android_gms_common_api_Api_zzg_T) {
        super(context, looper, i, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zb = com_google_android_gms_common_api_Api_zzg_T;
    }

    public zzg<T> zzatj() {
        return this.zb;
    }

    protected T zzbb(IBinder iBinder) {
        return this.zb.zzbb(iBinder);
    }

    protected void zzc(int i, T t) {
        this.zb.zza(i, t);
    }

    protected String zzra() {
        return this.zb.zzra();
    }

    protected String zzrb() {
        return this.zb.zzrb();
    }
}
