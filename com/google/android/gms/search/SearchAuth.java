package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzvu;
import com.google.android.gms.internal.zzvv;

public class SearchAuth {
    public static final Api<NoOptions> API;
    public static final SearchAuthApi SearchAuthApi;
    private static final zza<zzvu, NoOptions> atZ;
    public static final zzf<zzvu> bN;

    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    /* renamed from: com.google.android.gms.search.SearchAuth.1 */
    class C05881 extends zza<zzvu, NoOptions> {
        C05881() {
        }

        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzt(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzvu zzt(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzvu(context, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
        }
    }

    static {
        atZ = new C05881();
        bN = new zzf();
        API = new Api("SearchAuth.API", atZ, bN);
        SearchAuthApi = new zzvv();
    }

    private SearchAuth() {
    }
}
