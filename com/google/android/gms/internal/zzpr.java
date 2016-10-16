package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.atomic.AtomicReference;

public class zzpr {

    public interface zzb<R> {
        void setResult(R r);

        void zzz(Status status);
    }

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zzpt<R> implements zzb<R> {
        private final Api<?> pD;
        private AtomicReference<zzb> sA;
        private final zzc<A> sz;

        @Deprecated
        protected zza(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.sA = new AtomicReference();
            this.sz = (zzc) zzab.zzaa(com_google_android_gms_common_api_Api_zzc_A);
            this.pD = null;
        }

        protected zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            this.sA = new AtomicReference();
            this.sz = api.zzanp();
            this.pD = api;
        }

        private void zza(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        public /* synthetic */ void setResult(Object obj) {
            super.zzc((Result) obj);
        }

        protected abstract void zza(A a) throws RemoteException;

        public void zza(zzb com_google_android_gms_internal_zzrd_zzb) {
            this.sA.set(com_google_android_gms_internal_zzrd_zzb);
        }

        public final zzc<A> zzanp() {
            return this.sz;
        }

        public final Api<?> zzanw() {
            return this.pD;
        }

        public void zzaoo() {
            setResultCallback(null);
        }

        protected void zzaop() {
            zzb com_google_android_gms_internal_zzrd_zzb = (zzb) this.sA.getAndSet(null);
            if (com_google_android_gms_internal_zzrd_zzb != null) {
                com_google_android_gms_internal_zzrd_zzb.zzh(this);
            }
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((com.google.android.gms.common.api.Api.zzb) a);
            } catch (RemoteException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        protected void zzb(R r) {
        }

        public final void zzz(Status status) {
            zzab.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            Result zzc = zzc(status);
            zzc(zzc);
            zzb(zzc);
        }
    }
}
