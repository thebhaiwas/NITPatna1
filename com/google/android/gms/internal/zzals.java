package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzals {
    private static final AtomicReference<zzals> baW;

    static {
        baW = new AtomicReference();
    }

    zzals(Context context) {
    }

    @Nullable
    public static zzals zzcxe() {
        return (zzals) baW.get();
    }

    public static zzals zzen(Context context) {
        baW.compareAndSet(null, new zzals(context));
        return (zzals) baW.get();
    }

    public Set<String> zzcxf() {
        return Collections.emptySet();
    }

    public void zzf(@NonNull FirebaseApp firebaseApp) {
    }
}
