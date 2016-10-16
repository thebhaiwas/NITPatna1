package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmq;

public final class zza {
    public static final zzf<zzmo> aF;
    private static final com.google.android.gms.common.api.Api.zza<zzmo, NoOptions> aG;
    public static final Api<NoOptions> aH;
    public static final zzk aI;

    /* renamed from: com.google.android.gms.appdatasearch.zza.1 */
    class C05791 extends com.google.android.gms.common.api.Api.zza<zzmo, NoOptions> {
        C05791() {
        }

        public zzmo zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmo(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        aF = new zzf();
        aG = new C05791();
        aH = new Api("AppDataSearch.LIGHTWEIGHT_API", aG, aF);
        aI = new zzmq();
    }
}
