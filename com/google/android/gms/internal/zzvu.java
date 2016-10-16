package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzvt.zza;

public class zzvu extends zzk<zzvt> {
    public zzvu(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg) {
        super(context, context.getMainLooper(), 73, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzbb(IBinder iBinder) {
        return zzkg(iBinder);
    }

    protected zzvt zzkg(IBinder iBinder) {
        return zza.zzkf(iBinder);
    }

    protected String zzra() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzrb() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
