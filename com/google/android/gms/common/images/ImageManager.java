package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object wf;
    private static HashSet<Uri> wg;
    private static ImageManager wh;
    private static ImageManager wi;
    private final Context mContext;
    private final Handler mHandler;
    private final ExecutorService wj;
    private final zzb wk;
    private final zzrh wl;
    private final Map<zza, ImageReceiver> wm;
    private final Map<Uri, ImageReceiver> wn;
    private final Map<Uri, Long> wo;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zza> wp;
        final /* synthetic */ ImageManager wq;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.wq = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.wp = new ArrayList();
        }

        public void onReceiveResult(int i, Bundle bundle) {
            this.wq.wj.execute(new zzc(this.wq, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzarl() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.wq.mContext.sendBroadcast(intent);
        }

        public void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.wp.add(com_google_android_gms_common_images_zza);
        }

        public void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzhj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.wp.remove(com_google_android_gms_common_images_zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        final /* synthetic */ ImageManager wq;
        private final ParcelFileDescriptor wr;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.wq = imageManager;
            this.mUri = uri;
            this.wr = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhk("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.wr != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.wr.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.wr.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.wq.mHandler.post(new zzf(this.wq, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager wq;
        private final zza ws;

        public zzd(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.wq = imageManager;
            this.ws = com_google_android_gms_common_images_zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.wq.wm.get(this.ws);
            if (imageReceiver != null) {
                this.wq.wm.remove(this.ws);
                imageReceiver.zzc(this.ws);
            }
            zza com_google_android_gms_common_images_zza_zza = this.ws.wu;
            if (com_google_android_gms_common_images_zza_zza.uri == null) {
                this.ws.zza(this.wq.mContext, this.wq.wl, true);
                return;
            }
            Bitmap zza = this.wq.zza(com_google_android_gms_common_images_zza_zza);
            if (zza != null) {
                this.ws.zza(this.wq.mContext, zza, true);
                return;
            }
            Long l = (Long) this.wq.wo.get(com_google_android_gms_common_images_zza_zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.ws.zza(this.wq.mContext, this.wq.wl, true);
                    return;
                }
                this.wq.wo.remove(com_google_android_gms_common_images_zza_zza.uri);
            }
            this.ws.zza(this.wq.mContext, this.wq.wl);
            imageReceiver = (ImageReceiver) this.wq.wn.get(com_google_android_gms_common_images_zza_zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.wq, com_google_android_gms_common_images_zza_zza.uri);
                this.wq.wn.put(com_google_android_gms_common_images_zza_zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.ws);
            if (!(this.ws instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.wq.wm.put(this.ws, imageReceiver);
            }
            synchronized (ImageManager.wf) {
                if (!ImageManager.wg.contains(com_google_android_gms_common_images_zza_zza.uri)) {
                    ImageManager.wg.add(com_google_android_gms_common_images_zza_zza.uri);
                    imageReceiver.zzarl();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb wk;

        public zze(zzb com_google_android_gms_common_images_ImageManager_zzb) {
            this.wk = com_google_android_gms_common_images_ImageManager_zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.wk.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.wk.evictAll();
            } else if (i >= 20) {
                this.wk.trimToSize(this.wk.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        final /* synthetic */ ImageManager wq;
        private boolean wt;
        private final CountDownLatch zzalc;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.wq = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.wt = z;
            this.zzalc = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.wp;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) zza.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.zza(this.wq.mContext, this.mBitmap, false);
                } else {
                    this.wq.wo.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.zza(this.wq.mContext, this.wq.wl, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.wq.wm.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.wq.wk != null) {
                if (this.wt) {
                    this.wq.wk.evictAll();
                    System.gc();
                    this.wt = false;
                    this.wq.mHandler.post(this);
                    return;
                } else if (z) {
                    this.wq.wk.put(new zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.wq.wn.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzalc.countDown();
            synchronized (ImageManager.wf) {
                ImageManager.wg.remove(this.mUri);
            }
        }
    }

    private static final class zzb extends LruCache<zza, Bitmap> {
        public zzb(Context context) {
            super(zzcc(context));
        }

        @TargetApi(11)
        private static int zzcc(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityNodeInfoCompat.ACTION_DISMISS) != 0 ? 1 : null) == null || !zzs.zzavj()) ? activityManager.getMemoryClass() : zza.zza(activityManager);
            return (int) (((float) (memoryClass * AccessibilityNodeInfoCompat.ACTION_DISMISS)) * 0.33f);
        }

        protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            zza(z, (zza) obj, (Bitmap) obj2, (Bitmap) obj3);
        }

        protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
            return zza((zza) obj, (Bitmap) obj2);
        }

        protected int zza(zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean z, zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, com_google_android_gms_common_images_zza_zza, bitmap, bitmap2);
        }
    }

    static {
        wf = new Object();
        wg = new HashSet();
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.wj = Executors.newFixedThreadPool(4);
        if (z) {
            this.wk = new zzb(this.mContext);
            if (zzs.zzavm()) {
                zzarj();
            }
        } else {
            this.wk = null;
        }
        this.wl = new zzrh();
        this.wm = new HashMap();
        this.wn = new HashMap();
        this.wo = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    private Bitmap zza(zza com_google_android_gms_common_images_zza_zza) {
        return this.wk == null ? null : (Bitmap) this.wk.get(com_google_android_gms_common_images_zza_zza);
    }

    @TargetApi(14)
    private void zzarj() {
        this.mContext.registerComponentCallbacks(new zze(this.wk));
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (wi == null) {
                wi = new ImageManager(context, true);
            }
            return wi;
        }
        if (wh == null) {
            wh = new ImageManager(context, false);
        }
        return wh;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza com_google_android_gms_common_images_zza_zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        com_google_android_gms_common_images_zza_zzb.zzfu(i);
        zza(com_google_android_gms_common_images_zza_zzb);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza com_google_android_gms_common_images_zza_zzc = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        com_google_android_gms_common_images_zza_zzc.zzfu(i);
        zza(com_google_android_gms_common_images_zza_zzc);
    }

    public void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzb.zzhj("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, com_google_android_gms_common_images_zza).run();
    }
}
