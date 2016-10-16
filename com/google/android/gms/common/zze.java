package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0219R;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzl;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.internal.zzru;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import xyz.purush.nitp.nitpatna.C0337R;

public class zze {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean rf;
    public static boolean rg;
    static boolean rh;
    private static String ri;
    private static int rj;
    private static boolean rk;
    static final AtomicBoolean rl;
    private static final AtomicBoolean rm;

    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = zzank();
        rf = false;
        rg = false;
        rh = false;
        ri = null;
        rj = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        rk = false;
        rl = new AtomicBoolean();
        rm = new AtomicBoolean();
    }

    zze() {
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzc.zzand().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Builder().scheme("android.resource").authority(GOOGLE_PLAY_SERVICES_PACKAGE).appendPath("raw").appendPath("third_party_licenses").build());
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream == null) {
                return next;
            }
            openInputStream.close();
            return next;
        } catch (NoSuchElementException e) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        } catch (Exception e2) {
            return null;
        } catch (Throwable th) {
            if (openInputStream != null) {
                openInputStream.close();
            }
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0219R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName())) {
            zzbs(context);
        }
        int i = !zzi.zzck(context) ? 1 : GOOGLE_PLAY_SERVICES_VERSION_CODE;
        PackageInfo packageInfo = null;
        if (i != 0) {
            try {
                packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 8256);
            } catch (NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            zzf zzbz = zzf.zzbz(context);
            if (i != 0) {
                if (zzbz.zza(packageInfo, zzd.re) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    return 9;
                }
                if (zzbz.zza(packageInfo2, zzbz.zza(packageInfo, zzd.re)) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    return 9;
                }
            } else if (zzbz.zza(packageInfo2, zzd.re) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzl.zzgw(packageInfo2.versionCode) < zzl.zzgw(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo2.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, GOOGLE_PLAY_SERVICES_VERSION_CODE);
                } catch (Throwable e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : GOOGLE_PLAY_SERVICES_VERSION_CODE;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
                return true;
            default:
                return false;
        }
    }

    private static int zzank() {
        return com.google.android.gms.common.internal.zze.xB;
    }

    @Deprecated
    public static boolean zzanl() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzy.zzb(context, i, str);
    }

    @Deprecated
    public static void zzbb(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = zzc.zzand().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zza = zzc.zzand().zza(context, isGooglePlayServicesAvailable, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (zza == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
        }
    }

    @Deprecated
    public static int zzbn(Context context) {
        int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        try {
            return context.getPackageManager().getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, GOOGLE_PLAY_SERVICES_VERSION_CODE).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return i;
        }
    }

    @Deprecated
    public static void zzbp(Context context) {
        if (!rl.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzbs(Context context) {
        if (!rm.get()) {
            zzbx(context);
            if (rj == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (rj != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                int i2 = rj;
                String valueOf = String.valueOf("com.google.android.gms.version");
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 290).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(i).append(" but found ").append(i2).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"").append(valueOf).append("\" android:value=\"@integer/google_play_services_version\" />").toString());
            }
        }
    }

    public static boolean zzbt(Context context) {
        zzbx(context);
        return rh;
    }

    public static boolean zzbu(Context context) {
        return zzbt(context) || !zzanl();
    }

    public static String zzbv(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = zzru.zzcq(context).getApplicationInfo(context.getPackageName(), GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    @TargetApi(18)
    public static boolean zzbw(Context context) {
        if (zzs.zzavp()) {
            Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }

    private static void zzbx(Context context) {
        if (!rk) {
            zzby(context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzby(android.content.Context r7) {
        /*
        r6 = 1;
        r0 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x003a }
        ri = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = com.google.android.gms.internal.zzru.zzcq(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = com.google.android.gms.common.internal.zzz.zzcg(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        rj = r1;	 Catch:{ NameNotFoundException -> 0x003a }
        r1 = "com.google.android.gms";
        r2 = 64;
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x001b:
        r1 = com.google.android.gms.common.zzf.zzbz(r7);	 Catch:{ NameNotFoundException -> 0x003a }
        r2 = 1;
        r2 = new com.google.android.gms.common.zzd.zza[r2];	 Catch:{ NameNotFoundException -> 0x003a }
        r3 = 0;
        r4 = com.google.android.gms.common.zzd.zzd.re;	 Catch:{ NameNotFoundException -> 0x003a }
        r5 = 1;
        r4 = r4[r5];	 Catch:{ NameNotFoundException -> 0x003a }
        r2[r3] = r4;	 Catch:{ NameNotFoundException -> 0x003a }
        r0 = r1.zza(r0, r2);	 Catch:{ NameNotFoundException -> 0x003a }
        if (r0 == 0) goto L_0x0036;
    L_0x0030:
        r0 = 1;
        rh = r0;	 Catch:{ NameNotFoundException -> 0x003a }
    L_0x0033:
        rk = r6;
    L_0x0035:
        return;
    L_0x0036:
        r0 = 0;
        rh = r0;	 Catch:{ NameNotFoundException -> 0x003a }
        goto L_0x0033;
    L_0x003a:
        r0 = move-exception;
        r1 = "GooglePlayServicesUtil";
        r2 = "Cannot find Google Play services package name.";
        android.util.Log.w(r1, r2, r0);	 Catch:{ all -> 0x0045 }
        rk = r6;
        goto L_0x0035;
    L_0x0045:
        r0 = move-exception;
        rk = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zze.zzby(android.content.Context):void");
    }

    @Deprecated
    public static boolean zzc(Context context, int i) {
        return i == 18 ? true : i == 1 ? zzm(context, GOOGLE_PLAY_SERVICES_PACKAGE) : false;
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return i == 9 ? zzm(context, GOOGLE_PLAY_STORE_PACKAGE) : false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return zzy.zze(context, i);
    }

    @Deprecated
    public static Intent zzfb(int i) {
        return zzc.zzand().zza(null, i, null);
    }

    static boolean zzfc(int i) {
        switch (i) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
            case ConnectionResult.SERVICE_DISABLED /*3*/:
            case ConnectionResult.SERVICE_UPDATING /*18*/:
            case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(21)
    static boolean zzm(Context context, String str) {
        if (str.equals(GOOGLE_PLAY_SERVICES_PACKAGE) && zzd.zzabc()) {
            return false;
        }
        if (zzs.zzavs()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            boolean z = context.getPackageManager().getApplicationInfo(str, AccessibilityNodeInfoCompat.ACTION_SCROLL_BACKWARD).enabled && !zzbw(context);
            return z;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
