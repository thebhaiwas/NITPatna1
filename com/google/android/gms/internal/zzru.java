package com.google.android.gms.internal;

import android.content.Context;

public class zzru {
    private static zzru Bj;
    private zzrt Bi;

    static {
        Bj = new zzru();
    }

    public zzru() {
        this.Bi = null;
    }

    public static zzrt zzcq(Context context) {
        return Bj.zzcp(context);
    }

    public synchronized zzrt zzcp(Context context) {
        if (this.Bi == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.Bi = new zzrt(context);
        }
        return this.Bi;
    }
}
