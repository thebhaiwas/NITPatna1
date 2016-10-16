package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import java.lang.ref.WeakReference;

public class zzrc<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object sJ;
    private final WeakReference<GoogleApiClient> sL;
    private ResultTransform<? super R, ? extends Result> vk;
    private zzrc<? extends Result> vl;
    private volatile ResultCallbacks<? super R> vm;
    private PendingResult<R> vn;
    private Status vo;
    private final zza vp;
    private boolean vq;

    /* renamed from: com.google.android.gms.internal.zzrc.1 */
    class C02501 implements Runnable {
        final /* synthetic */ Result vr;
        final /* synthetic */ zzrc vs;

        C02501(zzrc com_google_android_gms_internal_zzrc, Result result) {
            this.vs = com_google_android_gms_internal_zzrc;
            this.vr = result;
        }

        @WorkerThread
        public void run() {
            GoogleApiClient googleApiClient;
            try {
                zzpt.sI.set(Boolean.valueOf(true));
                this.vs.vp.sendMessage(this.vs.vp.obtainMessage(0, this.vs.vk.onSuccess(this.vr)));
                zzpt.sI.set(Boolean.valueOf(false));
                this.vs.zze(this.vr);
                googleApiClient = (GoogleApiClient) this.vs.sL.get();
                if (googleApiClient != null) {
                    googleApiClient.zzb(this.vs);
                }
            } catch (RuntimeException e) {
                this.vs.vp.sendMessage(this.vs.vp.obtainMessage(1, e));
                zzpt.sI.set(Boolean.valueOf(false));
                this.vs.zze(this.vr);
                googleApiClient = (GoogleApiClient) this.vs.sL.get();
                if (googleApiClient != null) {
                    googleApiClient.zzb(this.vs);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                zzpt.sI.set(Boolean.valueOf(false));
                this.vs.zze(this.vr);
                googleApiClient = (GoogleApiClient) this.vs.sL.get();
                if (googleApiClient != null) {
                    googleApiClient.zzb(this.vs);
                }
            }
        }
    }

    private final class zza extends Handler {
        final /* synthetic */ zzrc vs;

        public zza(zzrc com_google_android_gms_internal_zzrc, Looper looper) {
            this.vs = com_google_android_gms_internal_zzrc;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case ConnectionResult.SUCCESS /*0*/:
                    PendingResult pendingResult = (PendingResult) message.obj;
                    synchronized (this.vs.sJ) {
                        if (pendingResult != null) {
                            if (pendingResult instanceof zzqx) {
                                this.vs.vl.zzac(((zzqx) pendingResult).getStatus());
                            } else {
                                this.vs.vl.zza(pendingResult);
                            }
                            break;
                        }
                        this.vs.vl.zzac(new Status(13, "Transform returned null"));
                        break;
                    }
                case ConnectionResult.SERVICE_MISSING /*1*/:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
            }
        }
    }

    public zzrc(WeakReference<GoogleApiClient> weakReference) {
        this.vk = null;
        this.vl = null;
        this.vm = null;
        this.vn = null;
        this.sJ = new Object();
        this.vo = null;
        this.vq = false;
        zzab.zzb((Object) weakReference, (Object) "GoogleApiClient reference must not be null");
        this.sL = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.sL.get();
        this.vp = new zza(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private void zzac(Status status) {
        synchronized (this.sJ) {
            this.vo = status;
            zzad(this.vo);
        }
    }

    private void zzad(Status status) {
        synchronized (this.sJ) {
            if (this.vk != null) {
                Object onFailure = this.vk.onFailure(status);
                zzab.zzb(onFailure, (Object) "onFailure must not return null");
                this.vl.zzac(onFailure);
            } else if (zzaqu()) {
                this.vm.onFailure(status);
            }
        }
    }

    private void zzaqs() {
        if (this.vk != null || this.vm != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.sL.get();
            if (!(this.vq || this.vk == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.vq = true;
            }
            if (this.vo != null) {
                zzad(this.vo);
            } else if (this.vn != null) {
                this.vn.setResultCallback(this);
            }
        }
    }

    private boolean zzaqu() {
        return (this.vm == null || ((GoogleApiClient) this.sL.get()) == null) ? false : true;
    }

    private void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        synchronized (this.sJ) {
            zzab.zza(this.vm == null, (Object) "Cannot call andFinally() twice.");
            if (this.vk != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.vm = resultCallbacks;
            zzaqs();
        }
    }

    public void onResult(R r) {
        synchronized (this.sJ) {
            if (!r.getStatus().isSuccess()) {
                zzac(r.getStatus());
                zze((Result) r);
            } else if (this.vk != null) {
                zzqw.zzapz().submit(new C02501(this, r));
            } else if (zzaqu()) {
                this.vm.onSuccess(r);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult com_google_android_gms_internal_zzrc;
        boolean z = true;
        synchronized (this.sJ) {
            zzab.zza(this.vk == null, (Object) "Cannot call then() twice.");
            if (this.vm != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.vk = resultTransform;
            com_google_android_gms_internal_zzrc = new zzrc(this.sL);
            this.vl = com_google_android_gms_internal_zzrc;
            zzaqs();
        }
        return com_google_android_gms_internal_zzrc;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.sJ) {
            this.vn = pendingResult;
            zzaqs();
        }
    }

    void zzaqt() {
        this.vm = null;
    }
}
