package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzqp;

public abstract class zzi implements OnClickListener {

    /* renamed from: com.google.android.gms.common.internal.zzi.1 */
    class C04351 extends zzi {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;

        C04351(Activity activity, Intent intent, int i) {
            this.val$activity = activity;
            this.val$intent = intent;
            this.val$requestCode = i;
        }

        public void zzasn() {
            this.val$activity.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzi.2 */
    class C04362 extends zzi {
        final /* synthetic */ Fragment val$fragment;
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;

        C04362(Fragment fragment, Intent intent, int i) {
            this.val$fragment = fragment;
            this.val$intent = intent;
            this.val$requestCode = i;
        }

        public void zzasn() {
            this.val$fragment.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzi.3 */
    class C04373 extends zzi {
        final /* synthetic */ Intent val$intent;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ zzqp yd;

        C04373(zzqp com_google_android_gms_internal_zzqp, Intent intent, int i) {
            this.yd = com_google_android_gms_internal_zzqp;
            this.val$intent = intent;
            this.val$requestCode = i;
        }

        @TargetApi(11)
        public void zzasn() {
            this.yd.startActivityForResult(this.val$intent, this.val$requestCode);
        }
    }

    public static zzi zza(Activity activity, Intent intent, int i) {
        return new C04351(activity, intent, i);
    }

    public static zzi zza(@NonNull Fragment fragment, Intent intent, int i) {
        return new C04362(fragment, intent, i);
    }

    public static zzi zza(@NonNull zzqp com_google_android_gms_internal_zzqp, Intent intent, int i) {
        return new C04373(com_google_android_gms_internal_zzqp, intent, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzasn();
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services");
        }
    }

    public abstract void zzasn();
}
