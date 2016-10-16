package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    private OnCompleteListener<TResult> aDF;
    private final Executor avP;
    private final Object zzail;

    /* renamed from: com.google.android.gms.tasks.zzc.1 */
    class C02971 implements Runnable {
        final /* synthetic */ Task aDC;
        final /* synthetic */ zzc aDG;

        C02971(zzc com_google_android_gms_tasks_zzc, Task task) {
            this.aDG = com_google_android_gms_tasks_zzc;
            this.aDC = task;
        }

        public void run() {
            synchronized (this.aDG.zzail) {
                if (this.aDG.aDF != null) {
                    this.aDG.aDF.onComplete(this.aDC);
                }
            }
        }
    }

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzail = new Object();
        this.avP = executor;
        this.aDF = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.zzail) {
            this.aDF = null;
        }
    }

    public void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.zzail) {
            if (this.aDF == null) {
                return;
            }
            this.avP.execute(new C02971(this, task));
        }
    }
}
