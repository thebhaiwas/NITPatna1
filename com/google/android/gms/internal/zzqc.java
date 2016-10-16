package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzpr.zza;
import java.util.Collections;

public class zzqc implements zzqe {
    private final zzqf tm;

    public zzqc(zzqf com_google_android_gms_internal_zzqf) {
        this.tm = com_google_android_gms_internal_zzqf;
    }

    public void begin() {
        this.tm.zzapy();
        this.tm.sX.tZ = Collections.emptySet();
    }

    public void connect() {
        this.tm.zzapw();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        this.tm.sX.tS.add(t);
        return t;
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
