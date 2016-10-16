package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqo {
    protected final zzqp va;

    protected zzqo(zzqp com_google_android_gms_internal_zzqp) {
        this.va = com_google_android_gms_internal_zzqp;
    }

    protected static zzqp zzc(zzqn com_google_android_gms_internal_zzqn) {
        return com_google_android_gms_internal_zzqn.zzaqm() ? zzra.zza(com_google_android_gms_internal_zzqn.zzaqo()) : zzqq.zzt(com_google_android_gms_internal_zzqn.zzaqn());
    }

    protected static zzqp zzs(Activity activity) {
        return zzc(new zzqn(activity));
    }

    @MainThread
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        return this.va.zzaqp();
    }

    @MainThread
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @MainThread
    public void onCreate(Bundle bundle) {
    }

    @MainThread
    public void onSaveInstanceState(Bundle bundle) {
    }

    @MainThread
    public void onStart() {
    }

    @MainThread
    public void onStop() {
    }
}
