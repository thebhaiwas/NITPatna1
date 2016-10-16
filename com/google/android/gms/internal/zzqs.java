package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzab;

public final class zzqs<L> {
    private volatile L mListener;
    private final zza vg;

    private final class zza extends Handler {
        final /* synthetic */ zzqs vh;

        public zza(zzqs com_google_android_gms_internal_zzqs, Looper looper) {
            this.vh = com_google_android_gms_internal_zzqs;
            super(looper);
        }

        public void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            zzab.zzbn(z);
            this.vh.zzb((zzb) message.obj);
        }
    }

    public interface zzb<L> {
        void zzapg();

        void zzu(L l);
    }

    zzqs(Looper looper, L l) {
        this.vg = new zza(this, looper);
        this.mListener = zzab.zzb((Object) l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> com_google_android_gms_internal_zzqs_zzb__super_L) {
        zzab.zzb((Object) com_google_android_gms_internal_zzqs_zzb__super_L, (Object) "Notifier must not be null");
        this.vg.sendMessage(this.vg.obtainMessage(1, com_google_android_gms_internal_zzqs_zzb__super_L));
    }

    void zzb(zzb<? super L> com_google_android_gms_internal_zzqs_zzb__super_L) {
        Object obj = this.mListener;
        if (obj == null) {
            com_google_android_gms_internal_zzqs_zzb__super_L.zzapg();
            return;
        }
        try {
            com_google_android_gms_internal_zzqs_zzb__super_L.zzu(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_internal_zzqs_zzb__super_L.zzapg();
            throw e;
        }
    }
}
