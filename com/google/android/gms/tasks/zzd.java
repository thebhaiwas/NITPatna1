package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    private OnFailureListener aDH;
    private final Executor avP;
    private final Object zzail;

    /* renamed from: com.google.android.gms.tasks.zzd.1 */
    class C02981 implements Runnable {
        final /* synthetic */ Task aDC;
        final /* synthetic */ zzd aDI;

        C02981(zzd com_google_android_gms_tasks_zzd, Task task) {
            this.aDI = com_google_android_gms_tasks_zzd;
            this.aDC = task;
        }

        public void run() {
            synchronized (this.aDI.zzail) {
                if (this.aDI.aDH != null) {
                    this.aDI.aDH.onFailure(this.aDC.getException());
                }
            }
        }
    }

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzail = new Object();
        this.avP = executor;
        this.aDH = onFailureListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDH = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.zzail) {
                if (this.aDH == null) {
                    return;
                }
                this.avP.execute(new C02981(this, task));
            }
        }
    }
}
