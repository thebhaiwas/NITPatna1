package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends zzaa {
    private static final AtomicLong amf;
    private zzd alW;
    private zzd alX;
    private final PriorityBlockingQueue<FutureTask<?>> alY;
    private final BlockingQueue<FutureTask<?>> alZ;
    private final UncaughtExceptionHandler ama;
    private final UncaughtExceptionHandler amb;
    private final Object amc;
    private final Semaphore amd;
    private volatile boolean ame;

    static class zza extends RuntimeException {
    }

    private final class zzb implements UncaughtExceptionHandler {
        private final String amg;
        final /* synthetic */ zzw amh;

        public zzb(zzw com_google_android_gms_measurement_internal_zzw, String str) {
            this.amh = com_google_android_gms_measurement_internal_zzw;
            zzab.zzaa(str);
            this.amg = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.amh.zzbsz().zzbtr().zzj(this.amg, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        private final String amg;
        final /* synthetic */ zzw amh;
        private final long ami;
        private final boolean amj;

        zzc(zzw com_google_android_gms_measurement_internal_zzw, Runnable runnable, boolean z, String str) {
            this.amh = com_google_android_gms_measurement_internal_zzw;
            super(runnable, null);
            zzab.zzaa(str);
            this.ami = zzw.amf.getAndIncrement();
            this.amg = str;
            this.amj = z;
            if (this.ami == Long.MAX_VALUE) {
                com_google_android_gms_measurement_internal_zzw.zzbsz().zzbtr().log("Tasks index overflow");
            }
        }

        zzc(zzw com_google_android_gms_measurement_internal_zzw, Callable<V> callable, boolean z, String str) {
            this.amh = com_google_android_gms_measurement_internal_zzw;
            super(callable);
            zzab.zzaa(str);
            this.ami = zzw.amf.getAndIncrement();
            this.amg = str;
            this.amj = z;
            if (this.ami == Long.MAX_VALUE) {
                com_google_android_gms_measurement_internal_zzw.zzbsz().zzbtr().log("Tasks index overflow");
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return zzb((zzc) obj);
        }

        protected void setException(Throwable th) {
            this.amh.zzbsz().zzbtr().zzj(this.amg, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        public int zzb(zzc com_google_android_gms_measurement_internal_zzw_zzc) {
            if (this.amj != com_google_android_gms_measurement_internal_zzw_zzc.amj) {
                return this.amj ? -1 : 1;
            } else {
                if (this.ami < com_google_android_gms_measurement_internal_zzw_zzc.ami) {
                    return -1;
                }
                if (this.ami > com_google_android_gms_measurement_internal_zzw_zzc.ami) {
                    return 1;
                }
                this.amh.zzbsz().zzbts().zzj("Two tasks share the same index. index", Long.valueOf(this.ami));
                return 0;
            }
        }
    }

    private final class zzd extends Thread {
        final /* synthetic */ zzw amh;
        private final Object amk;
        private final BlockingQueue<FutureTask<?>> aml;

        public zzd(zzw com_google_android_gms_measurement_internal_zzw, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.amh = com_google_android_gms_measurement_internal_zzw;
            zzab.zzaa(str);
            zzab.zzaa(blockingQueue);
            this.amk = new Object();
            this.aml = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            this.amh.zzbsz().zzbtt().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r4 = this;
            r0 = 0;
            r1 = r0;
        L_0x0002:
            if (r1 != 0) goto L_0x0015;
        L_0x0004:
            r0 = r4.amh;	 Catch:{ InterruptedException -> 0x0010 }
            r0 = r0.amd;	 Catch:{ InterruptedException -> 0x0010 }
            r0.acquire();	 Catch:{ InterruptedException -> 0x0010 }
            r0 = 1;
            r1 = r0;
            goto L_0x0002;
        L_0x0010:
            r0 = move-exception;
            r4.zza(r0);
            goto L_0x0002;
        L_0x0015:
            r0 = r4.aml;	 Catch:{ all -> 0x0023 }
            r0 = r0.poll();	 Catch:{ all -> 0x0023 }
            r0 = (java.util.concurrent.FutureTask) r0;	 Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x004d;
        L_0x001f:
            r0.run();	 Catch:{ all -> 0x0023 }
            goto L_0x0015;
        L_0x0023:
            r0 = move-exception;
            r1 = r4.amh;
            r1 = r1.amc;
            monitor-enter(r1);
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r2 = r2.amd;	 Catch:{ all -> 0x00e1 }
            r2.release();	 Catch:{ all -> 0x00e1 }
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r2 = r2.amc;	 Catch:{ all -> 0x00e1 }
            r2.notifyAll();	 Catch:{ all -> 0x00e1 }
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r2 = r2.alW;	 Catch:{ all -> 0x00e1 }
            if (r4 != r2) goto L_0x00d1;
        L_0x0045:
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r3 = 0;
            r2.alW = r3;	 Catch:{ all -> 0x00e1 }
        L_0x004b:
            monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
            throw r0;
        L_0x004d:
            r1 = r4.amk;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.aml;	 Catch:{ all -> 0x00a6 }
            r0 = r0.peek();	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0058:
            r0 = r4.amh;	 Catch:{ all -> 0x00a6 }
            r0 = r0.ame;	 Catch:{ all -> 0x00a6 }
            if (r0 != 0) goto L_0x0067;
        L_0x0060:
            r0 = r4.amk;	 Catch:{ InterruptedException -> 0x00a1 }
            r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
            r0.wait(r2);	 Catch:{ InterruptedException -> 0x00a1 }
        L_0x0067:
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            r0 = r4.amh;	 Catch:{ all -> 0x0023 }
            r1 = r0.amc;	 Catch:{ all -> 0x0023 }
            monitor-enter(r1);	 Catch:{ all -> 0x0023 }
            r0 = r4.aml;	 Catch:{ all -> 0x00ce }
            r0 = r0.peek();	 Catch:{ all -> 0x00ce }
            if (r0 != 0) goto L_0x00cb;
        L_0x0077:
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            r0 = r4.amh;
            r1 = r0.amc;
            monitor-enter(r1);
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r0 = r0.amd;	 Catch:{ all -> 0x00b8 }
            r0.release();	 Catch:{ all -> 0x00b8 }
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r0 = r0.amc;	 Catch:{ all -> 0x00b8 }
            r0.notifyAll();	 Catch:{ all -> 0x00b8 }
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r0 = r0.alW;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00a9;
        L_0x0099:
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.alW = r2;	 Catch:{ all -> 0x00b8 }
        L_0x009f:
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            return;
        L_0x00a1:
            r0 = move-exception;
            r4.zza(r0);	 Catch:{ all -> 0x00a6 }
            goto L_0x0067;
        L_0x00a6:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00a6 }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00a9:
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r0 = r0.alX;	 Catch:{ all -> 0x00b8 }
            if (r4 != r0) goto L_0x00bb;
        L_0x00b1:
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r2 = 0;
            r0.alX = r2;	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00b8:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00b8 }
            throw r0;
        L_0x00bb:
            r0 = r4.amh;	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbsz();	 Catch:{ all -> 0x00b8 }
            r0 = r0.zzbtr();	 Catch:{ all -> 0x00b8 }
            r2 = "Current scheduler thread is neither worker nor network";
            r0.log(r2);	 Catch:{ all -> 0x00b8 }
            goto L_0x009f;
        L_0x00cb:
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            goto L_0x0015;
        L_0x00ce:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ce }
            throw r0;	 Catch:{ all -> 0x0023 }
        L_0x00d1:
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r2 = r2.alX;	 Catch:{ all -> 0x00e1 }
            if (r4 != r2) goto L_0x00e4;
        L_0x00d9:
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r3 = 0;
            r2.alX = r3;	 Catch:{ all -> 0x00e1 }
            goto L_0x004b;
        L_0x00e1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
            throw r0;
        L_0x00e4:
            r2 = r4.amh;	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbsz();	 Catch:{ all -> 0x00e1 }
            r2 = r2.zzbtr();	 Catch:{ all -> 0x00e1 }
            r3 = "Current scheduler thread is neither worker nor network";
            r2.log(r3);	 Catch:{ all -> 0x00e1 }
            goto L_0x004b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zzd.run():void");
        }

        public void zznm() {
            synchronized (this.amk) {
                this.amk.notifyAll();
            }
        }
    }

    static {
        amf = new AtomicLong(Long.MIN_VALUE);
    }

    zzw(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.amc = new Object();
        this.amd = new Semaphore(2);
        this.alY = new PriorityBlockingQueue();
        this.alZ = new LinkedBlockingQueue();
        this.ama = new zzb(this, "Thread death: Uncaught exception on worker thread");
        this.amb = new zzb(this, "Thread death: Uncaught exception on network thread");
    }

    private void zza(zzc<?> com_google_android_gms_measurement_internal_zzw_zzc_) {
        synchronized (this.amc) {
            this.alY.add(com_google_android_gms_measurement_internal_zzw_zzc_);
            if (this.alW == null) {
                this.alW = new zzd(this, "Measurement Worker", this.alY);
                this.alW.setUncaughtExceptionHandler(this.ama);
                this.alW.start();
            } else {
                this.alW.zznm();
            }
        }
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.amc) {
            this.alZ.add(futureTask);
            if (this.alX == null) {
                this.alX = new zzd(this, "Measurement Network", this.alZ);
                this.alX.setUncaughtExceptionHandler(this.amb);
                this.alX.start();
            } else {
                this.alX.zznm();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzbso() {
        if (Thread.currentThread() != this.alX) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    public <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(callable);
        zzc com_google_android_gms_measurement_internal_zzw_zzc = new zzc(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.alW) {
            com_google_android_gms_measurement_internal_zzw_zzc.run();
        } else {
            zza(com_google_android_gms_measurement_internal_zzw_zzc);
        }
        return com_google_android_gms_measurement_internal_zzw_zzc;
    }

    public <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(callable);
        zzc com_google_android_gms_measurement_internal_zzw_zzc = new zzc(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.alW) {
            com_google_android_gms_measurement_internal_zzw_zzc.run();
        } else {
            zza(com_google_android_gms_measurement_internal_zzw_zzc);
        }
        return com_google_android_gms_measurement_internal_zzw_zzc;
    }

    public void zzl(Runnable runnable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(runnable);
        zza(new zzc(this, runnable, false, "Task exception on worker thread"));
    }

    public void zzm(Runnable runnable) throws IllegalStateException {
        zzzg();
        zzab.zzaa(runnable);
        zza(new zzc(this, runnable, false, "Task exception on network thread"));
    }

    public void zzwu() {
        if (Thread.currentThread() != this.alW) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    protected void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
