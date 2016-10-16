package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    private OnSuccessListener<? super TResult> aDJ;
    private final Executor avP;
    private final Object zzail;

    /* renamed from: com.google.android.gms.tasks.zze.1 */
    class C02991 implements Runnable {
        final /* synthetic */ Task aDC;
        final /* synthetic */ zze aDK;

        C02991(zze com_google_android_gms_tasks_zze, Task task) {
            this.aDK = com_google_android_gms_tasks_zze;
            this.aDC = task;
        }

        public void run() {
            synchronized (this.aDK.zzail) {
                if (this.aDK.aDJ != null) {
                    this.aDK.aDJ.onSuccess(this.aDC.getResult());
                }
            }
        }
    }

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzail = new Object();
        this.avP = executor;
        this.aDJ = onSuccessListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDJ = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzail) {
                if (this.aDJ == null) {
                    return;
                }
                this.avP.execute(new C02991(this, task));
            }
        }
    }
}
