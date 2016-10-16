package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqs;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzvw;
import com.google.android.gms.internal.zzvx;
import com.google.android.gms.internal.zzvy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> rM;

    public static final class Builder {
        private Account aP;
        private String cb;
        private final Context mContext;
        private final Set<Scope> rN;
        private final Set<Scope> rO;
        private int rP;
        private View rQ;
        private String rR;
        private final Map<Api<?>, zza> rS;
        private final Map<Api<?>, ApiOptions> rT;
        private zzqn rU;
        private int rV;
        private OnConnectionFailedListener rW;
        private GoogleApiAvailability rX;
        private Api.zza<? extends zzvx, zzvy> rY;
        private final ArrayList<ConnectionCallbacks> rZ;
        private final ArrayList<OnConnectionFailedListener> sa;
        private Looper zzahv;

        public Builder(@NonNull Context context) {
            this.rN = new HashSet();
            this.rO = new HashSet();
            this.rS = new ArrayMap();
            this.rT = new ArrayMap();
            this.rV = -1;
            this.rX = GoogleApiAvailability.getInstance();
            this.rY = zzvw.bO;
            this.rZ = new ArrayList();
            this.sa = new ArrayList();
            this.mContext = context;
            this.zzahv = context.getMainLooper();
            this.cb = context.getPackageName();
            this.rR = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzab.zzb((Object) connectionCallbacks, (Object) "Must provide a connected listener");
            this.rZ.add(connectionCallbacks);
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.sa.add(onConnectionFailedListener);
        }

        private static <C extends zze, O> C zza(Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return com_google_android_gms_common_api_Api_zza_C__O.zza(context, looper, com_google_android_gms_common_internal_zzg, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private Builder zza(@NonNull zzqn com_google_android_gms_internal_zzqn, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.rV = i;
            this.rW = onConnectionFailedListener;
            this.rU = com_google_android_gms_internal_zzqn;
            return this;
        }

        private static <C extends Api.zzg, O> zzah zza(zzh<C, O> com_google_android_gms_common_api_Api_zzh_C__O, Object obj, Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzah(context, looper, com_google_android_gms_common_api_Api_zzh_C__O.zzant(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg, com_google_android_gms_common_api_Api_zzh_C__O.zzs(obj));
        }

        private <O extends ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            int i2 = 0;
            if (i != GoogleApiClient.SIGN_IN_MODE_REQUIRED) {
                if (i == GoogleApiClient.SIGN_IN_MODE_OPTIONAL) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            Set hashSet = new HashSet(api.zzanm().zzq(o));
            int length = scopeArr.length;
            while (i2 < length) {
                hashSet.add(scopeArr[i2]);
                i2 += GoogleApiClient.SIGN_IN_MODE_REQUIRED;
            }
            this.rS.put(api, new zza(hashSet, z));
        }

        private GoogleApiClient zzaof() {
            zzg zzaoe = zzaoe();
            Api api = null;
            Map zzash = zzaoe.zzash();
            Map arrayMap = new ArrayMap();
            Map arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api2 = null;
            for (Api api3 : this.rT.keySet()) {
                Api api32;
                zze zza;
                Api api4;
                Object obj = this.rT.get(api32);
                int i = 0;
                if (zzash.get(api32) != null) {
                    i = ((zza) zzash.get(api32)).yc ? GoogleApiClient.SIGN_IN_MODE_REQUIRED : GoogleApiClient.SIGN_IN_MODE_OPTIONAL;
                }
                arrayMap.put(api32, Integer.valueOf(i));
                ConnectionCallbacks com_google_android_gms_internal_zzpu = new zzpu(api32, i);
                arrayList.add(com_google_android_gms_internal_zzpu);
                Api api5;
                if (api32.zzanq()) {
                    zzh zzano = api32.zzano();
                    api5 = zzano.getPriority() == GoogleApiClient.SIGN_IN_MODE_REQUIRED ? api32 : api2;
                    zza = zza(zzano, obj, this.mContext, this.zzahv, zzaoe, com_google_android_gms_internal_zzpu, (OnConnectionFailedListener) com_google_android_gms_internal_zzpu);
                    api4 = api5;
                } else {
                    Api.zza zzann = api32.zzann();
                    api5 = zzann.getPriority() == GoogleApiClient.SIGN_IN_MODE_REQUIRED ? api32 : api2;
                    zza = zza(zzann, obj, this.mContext, this.zzahv, zzaoe, com_google_android_gms_internal_zzpu, (OnConnectionFailedListener) com_google_android_gms_internal_zzpu);
                    api4 = api5;
                }
                arrayMap2.put(api32.zzanp(), zza);
                if (!zza.zzafz()) {
                    api32 = api;
                } else if (api != null) {
                    String valueOf = String.valueOf(api32.getName());
                    String valueOf2 = String.valueOf(api.getName());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                api2 = api4;
                api = api32;
            }
            if (api != null) {
                if (api2 != null) {
                    valueOf = String.valueOf(api.getName());
                    valueOf2 = String.valueOf(api2.getName());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                boolean z = this.aP == null;
                Object[] objArr = new Object[GoogleApiClient.SIGN_IN_MODE_REQUIRED];
                objArr[0] = api.getName();
                zzab.zza(z, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", objArr);
                objArr = new Object[GoogleApiClient.SIGN_IN_MODE_REQUIRED];
                objArr[0] = api.getName();
                zzab.zza(this.rN.equals(this.rO), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", objArr);
            }
            return new zzqd(this.mContext, new ReentrantLock(), this.zzahv, zzaoe, this.rX, this.rY, arrayMap, this.rZ, this.sa, arrayMap2, this.rV, zzqd.zza(arrayMap2.values(), true), arrayList);
        }

        private void zzf(GoogleApiClient googleApiClient) {
            zzpp.zza(this.rU).zza(this.rV, googleApiClient, this.rW);
        }

        public Builder addApi(@NonNull Api<? extends NotRequiredOptions> api) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.rT.put(api, null);
            Collection zzq = api.zzanm().zzq(null);
            this.rO.addAll(zzq);
            this.rN.addAll(zzq);
            return this;
        }

        public <O extends HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.rT.put(api, o);
            Collection zzq = api.zzanm().zzq(o);
            this.rO.addAll(zzq);
            this.rN.addAll(zzq);
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.rT.put(api, o);
            zza(api, o, GoogleApiClient.SIGN_IN_MODE_REQUIRED, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.rT.put(api, null);
            zza(api, null, GoogleApiClient.SIGN_IN_MODE_REQUIRED, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzab.zzb((Object) connectionCallbacks, (Object) "Listener must not be null");
            this.rZ.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Listener must not be null");
            this.sa.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzab.zzb((Object) scope, (Object) "Scope must not be null");
            this.rN.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzab.zzb(!this.rT.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient zzaof = zzaof();
            synchronized (GoogleApiClient.rM) {
                GoogleApiClient.rM.add(zzaof);
            }
            if (this.rV >= 0) {
                zzf(zzaof);
            }
            return zzaof;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return zza(new zzqn(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.aP = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.rP = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzab.zzb((Object) handler, (Object) "Handler must not be null");
            this.zzahv = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            zzab.zzb((Object) view, (Object) "View must not be null");
            this.rQ = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzg zzaoe() {
            zzvy com_google_android_gms_internal_zzvy = zzvy.aul;
            if (this.rT.containsKey(zzvw.API)) {
                com_google_android_gms_internal_zzvy = (zzvy) this.rT.get(zzvw.API);
            }
            return new zzg(this.aP, this.rN, this.rS, this.rP, this.rQ, this.cb, this.rR, com_google_android_gms_internal_zzvy);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    static {
        rM = Collections.newSetFromMap(new WeakHashMap());
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (rM) {
            String concat = String.valueOf(str).concat("  ");
            int i = 0;
            for (GoogleApiClient googleApiClient : rM) {
                int i2 = i + SIGN_IN_MODE_REQUIRED;
                printWriter.append(str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i = i2;
            }
        }
    }

    public static Set<GoogleApiClient> zzaob() {
        Set<GoogleApiClient> set;
        synchronized (rM) {
            set = rM;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends zze> C zza(@NonNull zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzrc com_google_android_gms_internal_zzrc) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzqy com_google_android_gms_internal_zzqy) {
        throw new UnsupportedOperationException();
    }

    public void zzaoc() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzrc com_google_android_gms_internal_zzrc) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends zzpr.zza<R, A>> T zzc(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends zzpr.zza<? extends Result, A>> T zzd(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzqs<L> zzt(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
