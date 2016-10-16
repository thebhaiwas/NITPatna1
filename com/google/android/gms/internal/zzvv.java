package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzvv implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzvs.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzdy(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final GoogleNowAuthState auf;
        private final Status cc;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.cc = status;
            this.auf = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.auf;
        }

        public Status getStatus() {
            return this.cc;
        }
    }

    static class zzb extends com.google.android.gms.internal.zzpr.zza<Status, zzvu> {
        private final String atX;
        private final String aua;
        private final boolean aub;

        /* renamed from: com.google.android.gms.internal.zzvv.zzb.1 */
        class C05931 extends zza {
            final /* synthetic */ zzb auc;

            C05931(zzb com_google_android_gms_internal_zzvv_zzb) {
                this.auc = com_google_android_gms_internal_zzvv_zzb;
            }

            public void zzdy(Status status) {
                if (this.auc.aub) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.auc.zzc((Result) status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.API, googleApiClient);
            this.aub = Log.isLoggable("SearchAuth", 3);
            this.atX = str;
            this.aua = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzvu com_google_android_gms_internal_zzvu) throws RemoteException {
            if (this.aub) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            ((zzvt) com_google_android_gms_internal_zzvu.zzarw()).zzb(new C05931(this), this.aua, this.atX);
        }

        protected Status zzb(Status status) {
            if (this.aub) {
                String str = "SearchAuth";
                String str2 = "ClearTokenImpl received failure: ";
                String valueOf = String.valueOf(status.getStatusMessage());
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class zzc extends com.google.android.gms.internal.zzpr.zza<GoogleNowAuthResult, zzvu> {
        private final String aua;
        private final boolean aub;
        private final String aud;

        /* renamed from: com.google.android.gms.internal.zzvv.zzc.1 */
        class C05941 extends zza {
            final /* synthetic */ zzc aue;

            C05941(zzc com_google_android_gms_internal_zzvv_zzc) {
                this.aue = com_google_android_gms_internal_zzvv_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.aue.aub) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.aue.zzc(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.API, googleApiClient);
            this.aub = Log.isLoggable("SearchAuth", 3);
            this.aud = str;
            this.aua = googleApiClient.getContext().getPackageName();
        }

        protected void zza(zzvu com_google_android_gms_internal_zzvu) throws RemoteException {
            if (this.aub) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            ((zzvt) com_google_android_gms_internal_zzvu.zzarw()).zza(new C05941(this), this.aua, this.aud);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzdz(status);
        }

        protected GoogleNowAuthResult zzdz(Status status) {
            if (this.aub) {
                String str = "SearchAuth";
                String str2 = "GetGoogleNowAuthImpl received failure: ";
                String valueOf = String.valueOf(status.getStatusMessage());
                Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            return new zzd(status, null);
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzc(new zzb(googleApiClient, str));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zzc(new zzc(googleApiClient, str));
    }
}
