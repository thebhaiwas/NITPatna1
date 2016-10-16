package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.google.android.gms.common.GooglePlayServicesUtil;

public final class zzd {
    public static final ComponentName An;
    public static int Ao;
    public static int Ap;
    public static int Aq;
    public static int Ar;
    public static int As;
    public static int At;
    public static int Au;
    public static int LOG_LEVEL_OFF;

    static {
        An = new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.common.stats.GmsCoreStatsService");
        LOG_LEVEL_OFF = 0;
        Ao = 1;
        Ap = 2;
        Aq = 4;
        Ar = 8;
        As = 16;
        At = 32;
        Au = 1;
    }
}
