package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzmq implements zzk, AppIndexApi {
    private static final String TAG;

    @Deprecated
    private static final class zza implements ActionResult {
        private zzmq bI;
        private PendingResult<Status> bJ;
        private Action bK;

        zza(zzmq com_google_android_gms_internal_zzmq, PendingResult<Status> pendingResult, Action action) {
            this.bI = com_google_android_gms_internal_zzmq;
            this.bJ = pendingResult;
            this.bK = action;
        }

        public PendingResult<Status> end(GoogleApiClient googleApiClient) {
            String packageName = googleApiClient.getContext().getPackageName();
            UsageInfo zza = zzmp.zza(this.bK, System.currentTimeMillis(), packageName, 2);
            return this.bI.zza(googleApiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.bJ;
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.internal.zzpr.zza<T, zzmo> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.aH, googleApiClient);
        }

        protected abstract void zza(zzml com_google_android_gms_internal_zzml) throws RemoteException;

        protected final void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            zza(com_google_android_gms_internal_zzmo.zzaes());
        }
    }

    public static final class zzd extends zzmn<Status> {
        public zzd(com.google.android.gms.internal.zzpr.zzb<Status> com_google_android_gms_internal_zzpr_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzpr_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.bF.setResult(status);
        }
    }

    public static abstract class zzc<T extends Result> extends zzb<Status> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzmq.1 */
    class C05991 extends zzc<Status> {
        final /* synthetic */ UsageInfo[] bG;
        final /* synthetic */ zzmq bH;

        C05991(zzmq com_google_android_gms_internal_zzmq, GoogleApiClient googleApiClient, UsageInfo[] usageInfoArr) {
            this.bH = com_google_android_gms_internal_zzmq;
            this.bG = usageInfoArr;
            super(googleApiClient);
        }

        protected void zza(zzml com_google_android_gms_internal_zzml) throws RemoteException {
            com_google_android_gms_internal_zzml.zza(new zzd(this), null, this.bG);
        }
    }

    static {
        TAG = zzmq.class.getSimpleName();
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        if (zzl(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (zzm(uri)) {
            return new Intent("android.intent.action.VIEW", zzk(uri));
        }
        String valueOf = String.valueOf(uri);
        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 70).append("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: ").append(valueOf).toString());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzmp.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        String valueOf;
        if (zzl(uri)) {
            if (uri.getHost().isEmpty()) {
                valueOf = String.valueOf(uri);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 98).append("AppIndex: The web URL must have a host (follow the format http(s)://<host>/<path>). Provided URI: ").append(valueOf).toString());
            }
        } else if (!zzm(uri)) {
            valueOf = String.valueOf(uri);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 176).append("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/<host_path>'. Provided URI: ").append(valueOf).toString());
        } else if (str == null || str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                valueOf = String.valueOf(uri);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + TransportMediator.FLAG_KEY_MEDIA_NEXT).append("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/<host_path>). Provided URI: ").append(valueOf).toString());
            }
        } else {
            valueOf = String.valueOf(uri);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 150).append("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/<host_path>. Provided URI: ").append(valueOf).toString());
        }
    }

    private static Uri zzk(Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        } else {
            str = TAG;
            String valueOf = String.valueOf(uri);
            Log.e(str, new StringBuilder(String.valueOf(valueOf).length() + 88).append("The app URI must have the format: android-app://<package_name>/<scheme>/<path>. But got ").append(valueOf).toString());
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    private static boolean zzl(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    private static boolean zzm(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    public static void zzv(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzv(list);
        return zza(googleApiClient, new UsageInfo(packageName, intent, str, uri, null, list, 1));
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, (List) list);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(packageName, intent)).zzy(System.currentTimeMillis()).zzch(0).zzci(2).zzaer());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, UsageInfo... usageInfoArr) {
        return googleApiClient.zzc(new C05991(this, googleApiClient, usageInfoArr));
    }
}
