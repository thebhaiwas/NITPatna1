package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzpp extends zzps {
    private final SparseArray<zza> ss;

    private class zza implements OnConnectionFailedListener {
        public final int st;
        public final GoogleApiClient su;
        public final OnConnectionFailedListener sv;
        final /* synthetic */ zzpp sw;

        public zza(zzpp com_google_android_gms_internal_zzpp, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.sw = com_google_android_gms_internal_zzpp;
            this.st = i;
            this.su = googleApiClient;
            this.sv = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.st);
            printWriter.println(":");
            this.su.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.sw.zzb(connectionResult, this.st);
        }

        public void zzaom() {
            this.su.unregisterConnectionFailedListener(this);
            this.su.disconnect();
        }
    }

    private zzpp(zzqp com_google_android_gms_internal_zzqp) {
        super(com_google_android_gms_internal_zzqp);
        this.ss = new SparseArray();
        this.va.zza("AutoManageHelper", (zzqo) this);
    }

    public static zzpp zza(zzqn com_google_android_gms_internal_zzqn) {
        zzqp zzc = zzqo.zzc(com_google_android_gms_internal_zzqn);
        zzpp com_google_android_gms_internal_zzpp = (zzpp) zzc.zza("AutoManageHelper", zzpp.class);
        return com_google_android_gms_internal_zzpp != null ? com_google_android_gms_internal_zzpp : new zzpp(zzc);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.ss.size(); i++) {
            ((zza) this.ss.valueAt(i)).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.ss);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.sB) {
            for (int i = 0; i < this.ss.size(); i++) {
                ((zza) this.ss.valueAt(i)).su.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.ss.size(); i++) {
            ((zza) this.ss.valueAt(i)).su.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzab.zza(this.ss.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.mStarted + " " + this.sB);
        this.ss.put(i, new zza(this, i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.sB) {
            String valueOf = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            googleApiClient.connect();
        }
    }

    protected void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza com_google_android_gms_internal_zzpp_zza = (zza) this.ss.get(i);
        if (com_google_android_gms_internal_zzpp_zza != null) {
            zzff(i);
            OnConnectionFailedListener onConnectionFailedListener = com_google_android_gms_internal_zzpp_zza.sv;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    protected void zzaol() {
        for (int i = 0; i < this.ss.size(); i++) {
            ((zza) this.ss.valueAt(i)).su.connect();
        }
    }

    public void zzff(int i) {
        zza com_google_android_gms_internal_zzpp_zza = (zza) this.ss.get(i);
        this.ss.remove(i);
        if (com_google_android_gms_internal_zzpp_zza != null) {
            com_google_android_gms_internal_zzpp_zza.zzaom();
        }
    }
}
