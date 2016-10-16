package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Continuation<TResult, Task<TContinuationResult>> aDA;
    private final zzh<TContinuationResult> aDB;
    private final Executor avP;

    /* renamed from: com.google.android.gms.tasks.zzb.1 */
    class C02961 implements Runnable {
        final /* synthetic */ Task aDC;
        final /* synthetic */ zzb aDE;

        C02961(zzb com_google_android_gms_tasks_zzb, Task task) {
            this.aDE = com_google_android_gms_tasks_zzb;
            this.aDC = task;
        }

        public void run() {
            try {
                Task task = (Task) this.aDE.aDA.then(this.aDC);
                if (task == null) {
                    this.aDE.onFailure(new NullPointerException("Continuation returned null"));
                    return;
                }
                task.addOnSuccessListener(TaskExecutors.aDO, this.aDE);
                task.addOnFailureListener(TaskExecutors.aDO, this.aDE);
            } catch (Exception e) {
                if (e.getCause() instanceof Exception) {
                    this.aDE.aDB.setException((Exception) e.getCause());
                } else {
                    this.aDE.aDB.setException(e);
                }
            } catch (Exception e2) {
                this.aDE.aDB.setException(e2);
            }
        }
    }

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> com_google_android_gms_tasks_zzh_TContinuationResult) {
        this.avP = executor;
        this.aDA = continuation;
        this.aDB = com_google_android_gms_tasks_zzh_TContinuationResult;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull Task<TResult> task) {
        this.avP.execute(new C02961(this, task));
    }

    public void onFailure(@NonNull Exception exception) {
        this.aDB.setException(exception);
    }

    public void onSuccess(TContinuationResult tContinuationResult) {
        this.aDB.setResult(tContinuationResult);
    }
}
