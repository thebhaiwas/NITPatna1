package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.zze;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T LQ;
    private Bundle LR;
    private LinkedList<zza> LS;
    private final zzf<T> LT;

    /* renamed from: com.google.android.gms.dynamic.zza.5 */
    class C02265 implements OnClickListener {
        final /* synthetic */ Context zzaky;
        final /* synthetic */ int zzbjz;

        C02265(Context context, int i) {
            this.zzaky = context;
            this.zzbjz = i;
        }

        public void onClick(View view) {
            this.zzaky.startActivity(GooglePlayServicesUtil.zzfb(this.zzbjz));
        }
    }

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    /* renamed from: com.google.android.gms.dynamic.zza.1 */
    class C04401 implements zzf<T> {
        final /* synthetic */ zza LU;

        C04401(zza com_google_android_gms_dynamic_zza) {
            this.LU = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.LU.LQ = t;
            Iterator it = this.LU.LS.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.LU.LQ);
            }
            this.LU.LS.clear();
            this.LU.LR = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.2 */
    class C04412 implements zza {
        final /* synthetic */ zza LU;
        final /* synthetic */ Bundle LV;
        final /* synthetic */ Bundle LW;
        final /* synthetic */ Activity val$activity;

        C04412(zza com_google_android_gms_dynamic_zza, Activity activity, Bundle bundle, Bundle bundle2) {
            this.LU = com_google_android_gms_dynamic_zza;
            this.val$activity = activity;
            this.LV = bundle;
            this.LW = bundle2;
        }

        public int getState() {
            return 0;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.LU.LQ.onInflate(this.val$activity, this.LV, this.LW);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.3 */
    class C04423 implements zza {
        final /* synthetic */ zza LU;
        final /* synthetic */ Bundle LW;

        C04423(zza com_google_android_gms_dynamic_zza, Bundle bundle) {
            this.LU = com_google_android_gms_dynamic_zza;
            this.LW = bundle;
        }

        public int getState() {
            return 1;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.LU.LQ.onCreate(this.LW);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.4 */
    class C04434 implements zza {
        final /* synthetic */ zza LU;
        final /* synthetic */ Bundle LW;
        final /* synthetic */ FrameLayout LX;
        final /* synthetic */ LayoutInflater LY;
        final /* synthetic */ ViewGroup LZ;

        C04434(zza com_google_android_gms_dynamic_zza, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.LU = com_google_android_gms_dynamic_zza;
            this.LX = frameLayout;
            this.LY = layoutInflater;
            this.LZ = viewGroup;
            this.LW = bundle;
        }

        public int getState() {
            return 2;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.LX.removeAllViews();
            this.LX.addView(this.LU.LQ.onCreateView(this.LY, this.LZ, this.LW));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.6 */
    class C04446 implements zza {
        final /* synthetic */ zza LU;

        C04446(zza com_google_android_gms_dynamic_zza) {
            this.LU = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.LU.LQ.onStart();
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.7 */
    class C04457 implements zza {
        final /* synthetic */ zza LU;

        C04457(zza com_google_android_gms_dynamic_zza) {
            this.LU = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.LU.LQ.onResume();
        }
    }

    public zza() {
        this.LT = new C04401(this);
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.LQ != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.LQ);
            return;
        }
        if (this.LS == null) {
            this.LS = new LinkedList();
        }
        this.LS.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.LR == null) {
                this.LR = (Bundle) bundle.clone();
            } else {
                this.LR.putAll(bundle);
            }
        }
        zza(this.LT);
    }

    public static void zzb(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzc = zzh.zzc(context, isGooglePlayServicesAvailable, zze.zzbv(context));
        CharSequence zzh = zzh.zzh(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new C02265(context, isGooglePlayServicesAvailable));
        }
    }

    private void zzmz(int i) {
        while (!this.LS.isEmpty() && ((zza) this.LS.getLast()).getState() >= i) {
            this.LS.removeLast();
        }
    }

    public void onCreate(Bundle bundle) {
        zza(bundle, new C04423(this, bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zza(bundle, new C04434(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.LQ == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.LQ != null) {
            this.LQ.onDestroy();
        } else {
            zzmz(1);
        }
    }

    public void onDestroyView() {
        if (this.LQ != null) {
            this.LQ.onDestroyView();
        } else {
            zzmz(2);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        zza(bundle2, new C04412(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        if (this.LQ != null) {
            this.LQ.onLowMemory();
        }
    }

    public void onPause() {
        if (this.LQ != null) {
            this.LQ.onPause();
        } else {
            zzmz(5);
        }
    }

    public void onResume() {
        zza(null, new C04457(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.LQ != null) {
            this.LQ.onSaveInstanceState(bundle);
        } else if (this.LR != null) {
            bundle.putAll(this.LR);
        }
    }

    public void onStart() {
        zza(null, new C04446(this));
    }

    public void onStop() {
        if (this.LQ != null) {
            this.LQ.onStop();
        } else {
            zzmz(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zzbcr() {
        return this.LQ;
    }
}
