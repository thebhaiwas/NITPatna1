package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzb extends Service {
    private int aay;
    private int aaz;
    MessengerCompat abV;
    final ExecutorService axF;
    private final Object zzail;

    /* renamed from: com.google.firebase.iid.zzb.1 */
    class C03031 extends Handler {
        final /* synthetic */ zzb baC;

        C03031(zzb com_google_firebase_iid_zzb, Looper looper) {
            this.baC = com_google_firebase_iid_zzb;
            super(looper);
        }

        public void handleMessage(Message message) {
            int zzc = MessengerCompat.zzc(message);
            zzf.zzdi(this.baC);
            this.baC.getPackageManager();
            if (zzc == zzf.ach || zzc == zzf.acg) {
                this.baC.zzm((Intent) message.obj);
                return;
            }
            int i = zzf.acg;
            Log.w("FirebaseInstanceId", "Message from unexpected caller " + zzc + " mine=" + i + " appid=" + zzf.ach);
        }
    }

    /* renamed from: com.google.firebase.iid.zzb.2 */
    class C03042 implements Runnable {
        final /* synthetic */ zzb baC;
        final /* synthetic */ Intent val$intent;

        C03042(zzb com_google_firebase_iid_zzb, Intent intent) {
            this.baC = com_google_firebase_iid_zzb;
            this.val$intent = intent;
        }

        public void run() {
            this.baC.zzm(this.val$intent);
            this.baC.zzbmb();
        }
    }

    public zzb() {
        this.abV = new MessengerCompat(new C03031(this, Looper.getMainLooper()));
        this.axF = Executors.newSingleThreadExecutor();
        this.zzail = new Object();
        this.aaz = 0;
    }

    public final IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) ? null : this.abV.getBinder();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.zzail) {
            this.aay = i2;
            this.aaz++;
        }
        Intent zzz = zzz(intent);
        if (zzz == null) {
            zzbmb();
            return 2;
        }
        try {
            int zzaa = zzaa(zzz);
            if (zzz.getStringExtra("from") == null) {
                return zzaa;
            }
            WakefulBroadcastReceiver.completeWakefulIntent(zzz);
            return zzaa;
        } catch (Throwable th) {
            if (zzz.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(zzz);
            }
        }
    }

    protected int zzaa(Intent intent) {
        this.axF.execute(new C03042(this, intent));
        return 3;
    }

    protected void zzbmb() {
        synchronized (this.zzail) {
            this.aaz--;
            if (this.aaz == 0) {
                zzsh(this.aay);
            }
        }
    }

    public abstract void zzm(Intent intent);

    boolean zzsh(int i) {
        return stopSelfResult(i);
    }

    protected abstract Intent zzz(Intent intent);
}
