package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class zzqt {
    private final Set<zzqs<?>> mg;

    public zzqt() {
        this.mg = Collections.newSetFromMap(new WeakHashMap());
    }

    public void release() {
        for (zzqs clear : this.mg) {
            clear.clear();
        }
        this.mg.clear();
    }

    public <L> zzqs<L> zzb(@NonNull L l, Looper looper) {
        zzab.zzb((Object) l, (Object) "Listener must not be null");
        zzab.zzb((Object) looper, (Object) "Looper must not be null");
        zzqs<L> com_google_android_gms_internal_zzqs = new zzqs(looper, l);
        this.mg.add(com_google_android_gms_internal_zzqs);
        return com_google_android_gms_internal_zzqs;
    }
}
