package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public class zzb {
    private static SharedPreferences QA;

    /* renamed from: com.google.android.gms.flags.impl.zzb.1 */
    class C02311 implements Callable<SharedPreferences> {
        final /* synthetic */ Context zzaky;

        C02311(Context context) {
            this.zzaky = context;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzbfv();
        }

        public SharedPreferences zzbfv() {
            return this.zzaky.getSharedPreferences("google_sdk_flags", 1);
        }
    }

    static {
        QA = null;
    }

    public static SharedPreferences zzn(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (QA == null) {
                QA = (SharedPreferences) zzui.zzb(new C02311(context));
            }
            sharedPreferences = QA;
        }
        return sharedPreferences;
    }
}
