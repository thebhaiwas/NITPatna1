package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

class zzb {
    static AppMeasurement aOC;

    private static void zzc(Context context, String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        stringExtra = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra != null) {
            bundle.putString("_nmn", stringExtra);
        }
        stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            stringExtra = null;
        }
        if (stringExtra != null) {
            bundle.putString("_nt", stringExtra);
        }
        try {
            bundle.putInt("_nmt", Integer.valueOf(intent.getStringExtra("google.c.a.ts")).intValue());
        } catch (Throwable e) {
            Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.valueOf(intent.getStringExtra("google.c.a.udt")).intValue());
            } catch (Throwable e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            Log.d("FirebaseMessaging", new StringBuilder((String.valueOf(str).length() + 22) + String.valueOf(valueOf).length()).append("Sending event=").append(str).append(" params=").append(valueOf).toString());
        }
        AppMeasurement zzep = zzep(context);
        if (zzep != null) {
            zzep.zzd("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event, missing measurement library");
        }
    }

    private static AppMeasurement zzep(Context context) {
        if (null != null) {
            return aOC;
        }
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    public static void zzl(Context context, Intent intent) {
        zzc(context, "_nr", intent);
    }

    public static void zzm(Context context, Intent intent) {
        zzp(context, intent);
        zzc(context, "_no", intent);
    }

    public static void zzn(Context context, Intent intent) {
        zzc(context, "_nd", intent);
    }

    public static void zzo(Context context, Intent intent) {
        zzc(context, "_nf", intent);
    }

    private static void zzp(Context context, Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                AppMeasurement zzep = zzep(context);
                if (zzep != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    zzep.zzb("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", "Firebase");
                    bundle.putString("medium", "notification");
                    bundle.putString("campaign", stringExtra);
                    zzep.zzd("fcm", "_cmp", bundle);
                    return;
                }
                Log.w("FirebaseMessaging", "Unable to set user property for event tracking, missing measurement library");
            }
        }
    }
}
