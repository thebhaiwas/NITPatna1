package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzpv implements zzqm {
    private final Context mContext;
    private final zzqd sX;
    private final zzqf sY;
    private final zzqf sZ;
    private final Map<zzc<?>, zzqf> ta;
    private final Set<zzqy> tb;
    private final zze tc;
    private Bundle td;
    private ConnectionResult te;
    private ConnectionResult tf;
    private boolean tg;
    private final Lock th;
    private int ti;
    private final Looper zzahv;

    /* renamed from: com.google.android.gms.internal.zzpv.1 */
    class C02461 implements Runnable {
        final /* synthetic */ zzpv tj;

        C02461(zzpv com_google_android_gms_internal_zzpv) {
            this.tj = com_google_android_gms_internal_zzpv;
        }

        public void run() {
            this.tj.th.lock();
            try {
                this.tj.zzapb();
            } finally {
                this.tj.th.unlock();
            }
        }
    }

    private class zza implements com.google.android.gms.internal.zzqm.zza {
        final /* synthetic */ zzpv tj;

        private zza(zzpv com_google_android_gms_internal_zzpv) {
            this.tj = com_google_android_gms_internal_zzpv;
        }

        public void zzc(int i, boolean z) {
            this.tj.th.lock();
            try {
                if (this.tj.tg || this.tj.tf == null || !this.tj.tf.isSuccess()) {
                    this.tj.tg = false;
                    this.tj.zzb(i, z);
                    return;
                }
                this.tj.tg = true;
                this.tj.sZ.onConnectionSuspended(i);
                this.tj.th.unlock();
            } finally {
                this.tj.th.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            this.tj.th.lock();
            try {
                this.tj.te = connectionResult;
                this.tj.zzapb();
            } finally {
                this.tj.th.unlock();
            }
        }

        public void zzm(@Nullable Bundle bundle) {
            this.tj.th.lock();
            try {
                this.tj.zzl(bundle);
                this.tj.te = ConnectionResult.qR;
                this.tj.zzapb();
            } finally {
                this.tj.th.unlock();
            }
        }
    }

    private class zzb implements com.google.android.gms.internal.zzqm.zza {
        final /* synthetic */ zzpv tj;

        private zzb(zzpv com_google_android_gms_internal_zzpv) {
            this.tj = com_google_android_gms_internal_zzpv;
        }

        public void zzc(int i, boolean z) {
            this.tj.th.lock();
            try {
                if (this.tj.tg) {
                    this.tj.tg = false;
                    this.tj.zzb(i, z);
                    return;
                }
                this.tj.tg = true;
                this.tj.sY.onConnectionSuspended(i);
                this.tj.th.unlock();
            } finally {
                this.tj.th.unlock();
            }
        }

        public void zzd(@NonNull ConnectionResult connectionResult) {
            this.tj.th.lock();
            try {
                this.tj.tf = connectionResult;
                this.tj.zzapb();
            } finally {
                this.tj.th.unlock();
            }
        }

        public void zzm(@Nullable Bundle bundle) {
            this.tj.th.lock();
            try {
                this.tj.tf = ConnectionResult.qR;
                this.tj.zzapb();
            } finally {
                this.tj.th.unlock();
            }
        }
    }

    private zzpv(Context context, zzqd com_google_android_gms_internal_zzqd, Lock lock, Looper looper, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzg com_google_android_gms_common_internal_zzg, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, zze com_google_android_gms_common_api_Api_zze, ArrayList<zzpu> arrayList, ArrayList<zzpu> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.tb = Collections.newSetFromMap(new WeakHashMap());
        this.te = null;
        this.tf = null;
        this.tg = false;
        this.ti = 0;
        this.mContext = context;
        this.sX = com_google_android_gms_internal_zzqd;
        this.th = lock;
        this.zzahv = looper;
        this.tc = com_google_android_gms_common_api_Api_zze;
        this.sY = new zzqf(context, this.sX, lock, looper, com_google_android_gms_common_zzc, map2, null, map4, null, arrayList2, new zza());
        this.sZ = new zzqf(context, this.sX, lock, looper, com_google_android_gms_common_zzc, map, com_google_android_gms_common_internal_zzg, map3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, arrayList, new zzb());
        Map arrayMap = new ArrayMap();
        for (zzc put : map2.keySet()) {
            arrayMap.put(put, this.sY);
        }
        for (zzc put2 : map.keySet()) {
            arrayMap.put(put2, this.sZ);
        }
        this.ta = Collections.unmodifiableMap(arrayMap);
    }

    public static zzpv zza(Context context, zzqd com_google_android_gms_internal_zzqd, Lock lock, Looper looper, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, Map<zzc<?>, zze> map, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzvx, zzvy> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, ArrayList<zzpu> arrayList) {
        zze com_google_android_gms_common_api_Api_zze = null;
        Map arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        for (Entry entry : map.entrySet()) {
            zze com_google_android_gms_common_api_Api_zze2 = (zze) entry.getValue();
            if (com_google_android_gms_common_api_Api_zze2.zzafz()) {
                com_google_android_gms_common_api_Api_zze = com_google_android_gms_common_api_Api_zze2;
            }
            if (com_google_android_gms_common_api_Api_zze2.zzafk()) {
                arrayMap.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            } else {
                arrayMap2.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            }
        }
        zzab.zza(!arrayMap.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc zzanp = api.zzanp();
            if (arrayMap.containsKey(zzanp)) {
                arrayMap3.put(api, (Integer) map2.get(api));
            } else if (arrayMap2.containsKey(zzanp)) {
                arrayMap4.put(api, (Integer) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzpu com_google_android_gms_internal_zzpu = (zzpu) it.next();
            if (arrayMap3.containsKey(com_google_android_gms_internal_zzpu.pD)) {
                arrayList2.add(com_google_android_gms_internal_zzpu);
            } else if (arrayMap4.containsKey(com_google_android_gms_internal_zzpu.pD)) {
                arrayList3.add(com_google_android_gms_internal_zzpu);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new zzpv(context, com_google_android_gms_internal_zzqd, lock, looper, com_google_android_gms_common_zzc, arrayMap, arrayMap2, com_google_android_gms_common_internal_zzg, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvx__com_google_android_gms_internal_zzvy, com_google_android_gms_common_api_Api_zze, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void zzapa() {
        this.tf = null;
        this.te = null;
        this.sY.connect();
        this.sZ.connect();
    }

    private void zzapb() {
        if (zzc(this.te)) {
            if (zzc(this.tf) || zzape()) {
                zzapc();
            } else if (this.tf == null) {
            } else {
                if (this.ti == 1) {
                    zzapd();
                    return;
                }
                zzb(this.tf);
                this.sY.disconnect();
            }
        } else if (this.te != null && zzc(this.tf)) {
            this.sZ.disconnect();
            zzb(this.te);
        } else if (this.te != null && this.tf != null) {
            ConnectionResult connectionResult = this.te;
            if (this.sZ.uq < this.sY.uq) {
                connectionResult = this.tf;
            }
            zzb(connectionResult);
        }
    }

    private void zzapc() {
        switch (this.ti) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                this.sX.zzm(this.td);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        zzapd();
        this.ti = 0;
    }

    private void zzapd() {
        for (zzqy zzafy : this.tb) {
            zzafy.zzafy();
        }
        this.tb.clear();
    }

    private boolean zzape() {
        return this.tf != null && this.tf.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzapf() {
        return this.tc == null ? null : PendingIntent.getActivity(this.mContext, this.sX.getSessionId(), this.tc.zzaga(), 134217728);
    }

    private void zzb(int i, boolean z) {
        this.sX.zzc(i, z);
        this.tf = null;
        this.te = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.ti) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                this.sX.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzapd();
        this.ti = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zze(com.google.android.gms.internal.zzpr.zza<? extends Result, ? extends com.google.android.gms.common.api.Api.zzb> com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc zzanp = com_google_android_gms_internal_zzpr_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.zzanp();
        zzab.zzb(this.ta.containsKey(zzanp), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzqf) this.ta.get(zzanp)).equals(this.sZ);
    }

    private void zzl(Bundle bundle) {
        if (this.td == null) {
            this.td = bundle;
        } else if (bundle != null) {
            this.td.putAll(bundle);
        }
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.ti = 2;
        this.tg = false;
        zzapa();
    }

    public void disconnect() {
        this.tf = null;
        this.te = null;
        this.ti = 0;
        this.sY.disconnect();
        this.sZ.disconnect();
        zzapd();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.sZ.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.sY.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return ((zzqf) this.ta.get(api.zzanp())).equals(this.sZ) ? zzape() ? new ConnectionResult(4, zzapf()) : this.sZ.getConnectionResult(api) : this.sY.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.th.lock();
        try {
            if (!(this.sY.isConnected() && (zzaoz() || zzape() || this.ti == 1))) {
                z = false;
            }
            this.th.unlock();
            return z;
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    public boolean isConnecting() {
        this.th.lock();
        try {
            boolean z = this.ti == 2;
            this.th.unlock();
            return z;
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    public boolean zza(zzqy com_google_android_gms_internal_zzqy) {
        this.th.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzaoz()) {
                this.tb.add(com_google_android_gms_internal_zzqy);
                if (this.ti == 0) {
                    this.ti = 1;
                }
                this.tf = null;
                this.sZ.connect();
                return true;
            }
            this.th.unlock();
            return false;
        } finally {
            this.th.unlock();
        }
    }

    public void zzaoc() {
        this.th.lock();
        try {
            boolean isConnecting = isConnecting();
            this.sZ.disconnect();
            this.tf = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzahv).post(new C02461(this));
            } else {
                zzapd();
            }
            this.th.unlock();
        } catch (Throwable th) {
            this.th.unlock();
        }
    }

    public void zzaoy() {
        this.sY.zzaoy();
        this.sZ.zzaoy();
    }

    public boolean zzaoz() {
        return this.sZ.isConnected();
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpr.zza<R, A>> T zzc(@NonNull T t) {
        if (!zze((com.google.android.gms.internal.zzpr.zza) t)) {
            return this.sY.zzc((com.google.android.gms.internal.zzpr.zza) t);
        }
        if (!zzape()) {
            return this.sZ.zzc((com.google.android.gms.internal.zzpr.zza) t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        if (!zze((com.google.android.gms.internal.zzpr.zza) t)) {
            return this.sY.zzd(t);
        }
        if (!zzape()) {
            return this.sZ.zzd(t);
        }
        t.zzz(new Status(4, null, zzapf()));
        return t;
    }
}
