package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends zzaa {
    private final zza anl;
    private zzm anm;
    private Boolean ann;
    private final zzf ano;
    private final zzah anp;
    private final List<Runnable> anq;
    private final zzf anr;

    /* renamed from: com.google.android.gms.measurement.internal.zzad.3 */
    class C02633 implements Runnable {
        final /* synthetic */ zzad ans;

        C02633(zzad com_google_android_gms_measurement_internal_zzad) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
        }

        public void run() {
            zzm zzc = this.ans.anm;
            if (zzc == null) {
                this.ans.zzbsz().zzbtr().log("Failed to send measurementEnabled to service");
                return;
            }
            try {
                zzc.zzb(this.ans.zzbsr().zzlw(this.ans.zzbsz().zzbtz()));
                this.ans.zzzt();
            } catch (RemoteException e) {
                this.ans.zzbsz().zzbtr().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.4 */
    class C02644 implements Runnable {
        final /* synthetic */ String aee;
        final /* synthetic */ EventParcel amT;
        final /* synthetic */ zzad ans;

        C02644(zzad com_google_android_gms_measurement_internal_zzad, String str, EventParcel eventParcel) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
            this.aee = str;
            this.amT = eventParcel;
        }

        public void run() {
            zzm zzc = this.ans.anm;
            if (zzc == null) {
                this.ans.zzbsz().zzbtr().log("Discarding data. Failed to send event to service");
                return;
            }
            try {
                if (TextUtils.isEmpty(this.aee)) {
                    zzc.zza(this.amT, this.ans.zzbsr().zzlw(this.ans.zzbsz().zzbtz()));
                } else {
                    zzc.zza(this.amT, this.aee, this.ans.zzbsz().zzbtz());
                }
                this.ans.zzzt();
            } catch (RemoteException e) {
                this.ans.zzbsz().zzbtr().zzj("Failed to send event to AppMeasurementService", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.5 */
    class C02655 implements Runnable {
        final /* synthetic */ UserAttributeParcel amV;
        final /* synthetic */ zzad ans;

        C02655(zzad com_google_android_gms_measurement_internal_zzad, UserAttributeParcel userAttributeParcel) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
            this.amV = userAttributeParcel;
        }

        public void run() {
            zzm zzc = this.ans.anm;
            if (zzc == null) {
                this.ans.zzbsz().zzbtr().log("Discarding data. Failed to set user attribute");
                return;
            }
            try {
                zzc.zza(this.amV, this.ans.zzbsr().zzlw(this.ans.zzbsz().zzbtz()));
                this.ans.zzzt();
            } catch (RemoteException e) {
                this.ans.zzbsz().zzbtr().zzj("Failed to send attribute to AppMeasurementService", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.6 */
    class C02666 implements Runnable {
        final /* synthetic */ boolean ank;
        final /* synthetic */ zzad ans;
        final /* synthetic */ AtomicReference ant;

        C02666(zzad com_google_android_gms_measurement_internal_zzad, AtomicReference atomicReference, boolean z) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
            this.ant = atomicReference;
            this.ank = z;
        }

        public void run() {
            synchronized (this.ant) {
                try {
                    zzm zzc = this.ans.anm;
                    if (zzc == null) {
                        this.ans.zzbsz().zzbtr().log("Failed to get user properties");
                        return;
                    }
                    this.ant.set(zzc.zza(this.ans.zzbsr().zzlw(null), this.ank));
                    this.ans.zzzt();
                    this.ant.notify();
                } catch (RemoteException e) {
                    this.ans.zzbsz().zzbtr().zzj("Failed to get user properties", e);
                } finally {
                    this.ant.notify();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.7 */
    class C02677 implements Runnable {
        final /* synthetic */ zzad ans;

        C02677(zzad com_google_android_gms_measurement_internal_zzad) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
        }

        public void run() {
            zzm zzc = this.ans.anm;
            if (zzc == null) {
                this.ans.zzbsz().zzbtr().log("Discarding data. Failed to send app launch");
                return;
            }
            try {
                zzc.zza(this.ans.zzbsr().zzlw(this.ans.zzbsz().zzbtz()));
                this.ans.zzzt();
            } catch (RemoteException e) {
                this.ans.zzbsz().zzbtr().zzj("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.1 */
    class C05091 extends zzf {
        final /* synthetic */ zzad ans;

        C05091(zzad com_google_android_gms_measurement_internal_zzad, zzx com_google_android_gms_measurement_internal_zzx) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
            super(com_google_android_gms_measurement_internal_zzx);
        }

        public void run() {
            this.ans.zzzu();
        }
    }

    /* renamed from: com.google.android.gms.measurement.internal.zzad.2 */
    class C05102 extends zzf {
        final /* synthetic */ zzad ans;

        C05102(zzad com_google_android_gms_measurement_internal_zzad, zzx com_google_android_gms_measurement_internal_zzx) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
            super(com_google_android_gms_measurement_internal_zzx);
        }

        public void run() {
            this.ans.zzbsz().zzbtt().log("Tasks have been queued for a long time");
        }
    }

    protected class zza implements ServiceConnection, zzb, zzc {
        final /* synthetic */ zzad ans;
        private volatile boolean anu;
        private volatile zzo anv;

        /* renamed from: com.google.android.gms.measurement.internal.zzad.zza.1 */
        class C02681 implements Runnable {
            final /* synthetic */ zzm anw;
            final /* synthetic */ zza anx;

            C02681(zza com_google_android_gms_measurement_internal_zzad_zza, zzm com_google_android_gms_measurement_internal_zzm) {
                this.anx = com_google_android_gms_measurement_internal_zzad_zza;
                this.anw = com_google_android_gms_measurement_internal_zzm;
            }

            public void run() {
                synchronized (this.anx) {
                    this.anx.anu = false;
                    if (!this.anx.ans.isConnected()) {
                        this.anx.ans.zzbsz().zzbty().log("Connected to service");
                        this.anx.ans.zza(this.anw);
                    }
                }
            }
        }

        /* renamed from: com.google.android.gms.measurement.internal.zzad.zza.2 */
        class C02692 implements Runnable {
            final /* synthetic */ zza anx;
            final /* synthetic */ ComponentName zzcxy;

            C02692(zza com_google_android_gms_measurement_internal_zzad_zza, ComponentName componentName) {
                this.anx = com_google_android_gms_measurement_internal_zzad_zza;
                this.zzcxy = componentName;
            }

            public void run() {
                this.anx.ans.onServiceDisconnected(this.zzcxy);
            }
        }

        /* renamed from: com.google.android.gms.measurement.internal.zzad.zza.3 */
        class C02703 implements Runnable {
            final /* synthetic */ zza anx;
            final /* synthetic */ zzm any;

            C02703(zza com_google_android_gms_measurement_internal_zzad_zza, zzm com_google_android_gms_measurement_internal_zzm) {
                this.anx = com_google_android_gms_measurement_internal_zzad_zza;
                this.any = com_google_android_gms_measurement_internal_zzm;
            }

            public void run() {
                synchronized (this.anx) {
                    this.anx.anu = false;
                    if (!this.anx.ans.isConnected()) {
                        this.anx.ans.zzbsz().zzbtx().log("Connected to remote service");
                        this.anx.ans.zza(this.any);
                    }
                }
            }
        }

        /* renamed from: com.google.android.gms.measurement.internal.zzad.zza.4 */
        class C02714 implements Runnable {
            final /* synthetic */ zza anx;

            C02714(zza com_google_android_gms_measurement_internal_zzad_zza) {
                this.anx = com_google_android_gms_measurement_internal_zzad_zza;
            }

            public void run() {
                this.anx.ans.onServiceDisconnected(new ComponentName(this.anx.ans.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected zza(zzad com_google_android_gms_measurement_internal_zzad) {
            this.ans = com_google_android_gms_measurement_internal_zzad;
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzab.zzhj("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    zzm com_google_android_gms_measurement_internal_zzm = (zzm) this.anv.zzarw();
                    this.anv = null;
                    this.ans.zzbsy().zzl(new C02703(this, com_google_android_gms_measurement_internal_zzm));
                } catch (DeadObjectException e) {
                    this.anv = null;
                    this.anu = false;
                } catch (IllegalStateException e2) {
                    this.anv = null;
                    this.anu = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzab.zzhj("MeasurementServiceConnection.onConnectionFailed");
            zzp zzbul = this.ans.aja.zzbul();
            if (zzbul != null) {
                zzbul.zzbtt().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.anu = false;
                this.anv = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzab.zzhj("MeasurementServiceConnection.onConnectionSuspended");
            this.ans.zzbsz().zzbtx().log("Service connection suspended");
            this.ans.zzbsy().zzl(new C02714(this));
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzhj("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.anu = false;
                    this.ans.zzbsz().zzbtr().log("Service connected with null binder");
                    return;
                }
                zzm com_google_android_gms_measurement_internal_zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        com_google_android_gms_measurement_internal_zzm = com.google.android.gms.measurement.internal.zzm.zza.zzjb(iBinder);
                        this.ans.zzbsz().zzbty().log("Bound to IMeasurementService interface");
                    } else {
                        this.ans.zzbsz().zzbtr().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.ans.zzbsz().zzbtr().log("Service connect failed to get IMeasurementService");
                }
                if (com_google_android_gms_measurement_internal_zzm == null) {
                    this.anu = false;
                    try {
                        com.google.android.gms.common.stats.zzb.zzaut().zza(this.ans.getContext(), this.ans.anl);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.ans.zzbsy().zzl(new C02681(this, com_google_android_gms_measurement_internal_zzm));
                }
                return;
            }
        }

        @MainThread
        public void onServiceDisconnected(ComponentName componentName) {
            zzab.zzhj("MeasurementServiceConnection.onServiceDisconnected");
            this.ans.zzbsz().zzbtx().log("Service disconnected");
            this.ans.zzbsy().zzl(new C02692(this, componentName));
        }

        @WorkerThread
        public void zzbvs() {
            this.ans.zzwu();
            Context context = this.ans.getContext();
            synchronized (this) {
                if (this.anu) {
                    this.ans.zzbsz().zzbty().log("Connection attempt already in progress");
                } else if (this.anv != null) {
                    this.ans.zzbsz().zzbty().log("Already awaiting connection attempt");
                } else {
                    this.anv = new zzo(context, Looper.getMainLooper(), this, this);
                    this.ans.zzbsz().zzbty().log("Connecting to remote service");
                    this.anu = true;
                    this.anv.zzart();
                }
            }
        }

        @WorkerThread
        public void zzx(Intent intent) {
            this.ans.zzwu();
            Context context = this.ans.getContext();
            com.google.android.gms.common.stats.zzb zzaut = com.google.android.gms.common.stats.zzb.zzaut();
            synchronized (this) {
                if (this.anu) {
                    this.ans.zzbsz().zzbty().log("Connection attempt already in progress");
                    return;
                }
                this.anu = true;
                zzaut.zza(context, intent, this.ans.anl, 129);
            }
        }
    }

    protected zzad(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.anq = new ArrayList();
        this.anp = new zzah(com_google_android_gms_measurement_internal_zzx.zzyw());
        this.anl = new zza(this);
        this.ano = new C05091(this, com_google_android_gms_measurement_internal_zzx);
        this.anr = new C05102(this, com_google_android_gms_measurement_internal_zzx);
    }

    @WorkerThread
    private void onServiceDisconnected(ComponentName componentName) {
        zzwu();
        if (this.anm != null) {
            this.anm = null;
            zzbsz().zzbty().zzj("Disconnected from device MeasurementService", componentName);
            zzbvq();
        }
    }

    @WorkerThread
    private void zza(zzm com_google_android_gms_measurement_internal_zzm) {
        zzwu();
        zzab.zzaa(com_google_android_gms_measurement_internal_zzm);
        this.anm = com_google_android_gms_measurement_internal_zzm;
        zzzt();
        zzbvr();
    }

    private boolean zzbvo() {
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), AccessibilityNodeInfoCompat.ACTION_CUT);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    @WorkerThread
    private void zzbvq() {
        zzwu();
        zzaai();
    }

    @WorkerThread
    private void zzbvr() {
        zzwu();
        zzbsz().zzbty().zzj("Processing queued up service tasks", Integer.valueOf(this.anq.size()));
        for (Runnable zzl : this.anq) {
            zzbsy().zzl(zzl);
        }
        this.anq.clear();
        this.anr.cancel();
    }

    @WorkerThread
    private void zzn(Runnable runnable) throws IllegalStateException {
        zzwu();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.anq.size()) >= zzbtb().zzbsd()) {
            zzbsz().zzbtr().log("Discarding data. Max runnable queue size reached");
        } else {
            this.anq.add(runnable);
            if (!this.aja.zzbuu()) {
                this.anr.zzv(60000);
            }
            zzaai();
        }
    }

    @WorkerThread
    private void zzzt() {
        zzwu();
        this.anp.start();
        if (!this.aja.zzbuu()) {
            this.ano.zzv(zzbtb().zzabx());
        }
    }

    @WorkerThread
    private void zzzu() {
        zzwu();
        if (isConnected()) {
            zzbsz().zzbty().log("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzwu();
        zzzg();
        try {
            com.google.android.gms.common.stats.zzb.zzaut().zza(getContext(), this.anl);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.anm = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzwu();
        zzzg();
        return this.anm != null;
    }

    @WorkerThread
    protected void zza(UserAttributeParcel userAttributeParcel) {
        zzwu();
        zzzg();
        zzn(new C02655(this, userAttributeParcel));
    }

    @WorkerThread
    protected void zza(AtomicReference<List<UserAttributeParcel>> atomicReference, boolean z) {
        zzwu();
        zzzg();
        zzn(new C02666(this, atomicReference, z));
    }

    @WorkerThread
    void zzaai() {
        zzwu();
        zzzg();
        if (!isConnected()) {
            if (this.ann == null) {
                this.ann = zzbta().zzbuf();
                if (this.ann == null) {
                    zzbsz().zzbty().log("State of service unknown");
                    this.ann = Boolean.valueOf(zzbvp());
                    zzbta().zzca(this.ann.booleanValue());
                }
            }
            if (this.ann.booleanValue()) {
                zzbsz().zzbty().log("Using measurement service");
                this.anl.zzbvs();
            } else if (!this.aja.zzbuu() && zzbvo()) {
                zzbsz().zzbty().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.anl.zzx(intent);
            } else if (zzbtb().zzabd()) {
                zzbsz().zzbty().log("Using direct local measurement implementation");
                zza(new zzy(this.aja, true));
            } else {
                zzbsz().zzbtr().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    @WorkerThread
    protected void zzbvk() {
        zzwu();
        zzzg();
        zzn(new C02677(this));
    }

    @WorkerThread
    protected void zzbvn() {
        zzwu();
        zzzg();
        zzn(new C02633(this));
    }

    @WorkerThread
    protected boolean zzbvp() {
        zzwu();
        zzzg();
        if (zzbtb().zzabc()) {
            return true;
        }
        zzbsz().zzbty().log("Checking service availability");
        switch (com.google.android.gms.common.zzc.zzand().isGooglePlayServicesAvailable(getContext())) {
            case ConnectionResult.SUCCESS /*0*/:
                zzbsz().zzbty().log("Service available");
                return true;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                zzbsz().zzbty().log("Service missing");
                return false;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                zzbsz().zzbtx().log("Service container out of date");
                return true;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                zzbsz().zzbtt().log("Service disabled");
                return false;
            case ConnectionResult.SERVICE_INVALID /*9*/:
                zzbsz().zzbtt().log("Service invalid");
                return false;
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                zzbsz().zzbtt().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    @WorkerThread
    protected void zzc(EventParcel eventParcel, String str) {
        zzab.zzaa(eventParcel);
        zzwu();
        zzzg();
        zzn(new C02644(this, str, eventParcel));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    protected void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
