package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.zzg;

public final class zzvw {
    public static final Api<zzvy> API;
    public static final Api<zza> EX;
    public static final zzf<zzg> auj;
    static final com.google.android.gms.common.api.Api.zza<zzg, zza> auk;
    public static final zzf<zzg> bN;
    public static final com.google.android.gms.common.api.Api.zza<zzg, zzvy> bO;
    public static final Scope dP;
    public static final Scope dQ;

    /* renamed from: com.google.android.gms.internal.zzvw.1 */
    class C05861 extends com.google.android.gms.common.api.Api.zza<zzg, zzvy> {
        C05861() {
        }

        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, zzvy com_google_android_gms_internal_zzvy, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, true, com_google_android_gms_common_internal_zzg, com_google_android_gms_internal_zzvy == null ? zzvy.aul : com_google_android_gms_internal_zzvy, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzvw.2 */
    class C05872 extends com.google.android.gms.common.api.Api.zza<zzg, zza> {
        C05872() {
        }

        public zzg zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, zza com_google_android_gms_internal_zzvw_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, false, com_google_android_gms_common_internal_zzg, com_google_android_gms_internal_zzvw_zza.zzbzj(), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static class zza implements HasOptions {
        public Bundle zzbzj() {
            return null;
        }
    }

    static {
        bN = new zzf();
        auj = new zzf();
        bO = new C05861();
        auk = new C05872();
        dP = new Scope(Scopes.PROFILE);
        dQ = new Scope(Scopes.EMAIL);
        API = new Api("SignIn.API", bO, bN);
        EX = new Api("SignIn.INTERNAL_API", auk, auj);
    }
}
