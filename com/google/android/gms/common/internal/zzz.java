package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import com.google.android.gms.internal.zzru;

public class zzz {
    private static String yS;
    private static int yT;
    private static Object zzamp;
    private static boolean zzbyy;

    static {
        zzamp = new Object();
    }

    public static String zzcf(Context context) {
        zzch(context);
        return yS;
    }

    public static int zzcg(Context context) {
        zzch(context);
        return yT;
    }

    private static void zzch(Context context) {
        synchronized (zzamp) {
            if (zzbyy) {
                return;
            }
            zzbyy = true;
            try {
                Bundle bundle = zzru.zzcq(context).getApplicationInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT).metaData;
                if (bundle == null) {
                    return;
                }
                yS = bundle.getString("com.google.app.id");
                yT = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
