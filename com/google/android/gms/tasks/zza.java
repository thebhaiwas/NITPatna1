package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Continuation<TResult, TContinuationResult> aDA;
    private final zzh<TContinuationResult> aDB;
    private final Executor avP;

    /* renamed from: com.google.android.gms.tasks.zza.1 */
    class C02951 implements Runnable {
        final /* synthetic */ Task aDC;
        final /* synthetic */ zza aDD;

        C02951(zza com_google_android_gms_tasks_zza, Task task) {
            this.aDD = com_google_android_gms_tasks_zza;
            this.aDC = task;
        }

        public void run() {
            try {
                this.aDD.aDB.setResult(this.aDD.aDA.then(this.aDC));
            } catch (Exception e) {
                if (e.getCause() instanceof Exception) {
                    this.aDD.aDB.setException((Exception) e.getCause());
                } else {
                    this.aDD.aDB.setException(e);
                }
            } catch (Exception e2) {
                this.aDD.aDB.setException(e2);
            }
        }
    }

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> com_google_android_gms_tasks_zzh_TContinuationResult) {
        this.avP = executor;
        this.aDA = continuation;
        this.aDB = com_google_android_gms_tasks_zzh_TContinuationResult;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull Task<TResult> task) {
        this.avP.execute(new C02951(this, task));
    }
}
