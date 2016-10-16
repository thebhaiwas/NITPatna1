package com.google.android.gms.common.stats;

import android.support.v4.util.SimpleArrayMap;

public class zze {
    private final long Av;
    private final int Aw;
    private final SimpleArrayMap<String, Long> Ax;

    public zze() {
        this.Av = 60000;
        this.Aw = 10;
        this.Ax = new SimpleArrayMap(10);
    }

    public zze(int i, long j) {
        this.Av = j;
        this.Aw = i;
        this.Ax = new SimpleArrayMap();
    }

    private void zze(long j, long j2) {
        for (int size = this.Ax.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.Ax.valueAt(size)).longValue() > j) {
                this.Ax.removeAt(size);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Long zzhy(java.lang.String r9) {
        /*
        r8 = this;
        r2 = android.os.SystemClock.elapsedRealtime();
        r0 = r8.Av;
        monitor-enter(r8);
    L_0x0007:
        r4 = r8.Ax;	 Catch:{ all -> 0x003e }
        r4 = r4.size();	 Catch:{ all -> 0x003e }
        r5 = r8.Aw;	 Catch:{ all -> 0x003e }
        if (r4 < r5) goto L_0x0041;
    L_0x0011:
        r8.zze(r0, r2);	 Catch:{ all -> 0x003e }
        r4 = 2;
        r0 = r0 / r4;
        r4 = "ConnectionTracker";
        r5 = r8.Aw;	 Catch:{ all -> 0x003e }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003e }
        r7 = 94;
        r6.<init>(r7);	 Catch:{ all -> 0x003e }
        r7 = "The max capacity ";
        r6 = r6.append(r7);	 Catch:{ all -> 0x003e }
        r5 = r6.append(r5);	 Catch:{ all -> 0x003e }
        r6 = " is not enough. Current durationThreshold is: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x003e }
        r5 = r5.append(r0);	 Catch:{ all -> 0x003e }
        r5 = r5.toString();	 Catch:{ all -> 0x003e }
        android.util.Log.w(r4, r5);	 Catch:{ all -> 0x003e }
        goto L_0x0007;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        throw r0;
    L_0x0041:
        r0 = r8.Ax;	 Catch:{ all -> 0x003e }
        r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x003e }
        r0 = r0.put(r9, r1);	 Catch:{ all -> 0x003e }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x003e }
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.stats.zze.zzhy(java.lang.String):java.lang.Long");
    }

    public boolean zzhz(String str) {
        boolean z;
        synchronized (this) {
            z = this.Ax.remove(str) != null;
        }
        return z;
    }
}
