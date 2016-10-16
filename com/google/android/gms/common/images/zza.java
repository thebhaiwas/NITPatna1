package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.lang.ref.WeakReference;

public abstract class zza {
    private boolean wA;
    final zza wu;
    protected int wv;
    protected int ww;
    protected boolean wx;
    private boolean wy;
    private boolean wz;

    static final class zza {
        public final Uri uri;

        public zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof zza) ? false : this == obj ? true : zzaa.equal(((zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzaa.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> wB;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzw(imageView);
            this.wB = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzw(imageView);
            this.wB = new WeakReference(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zzrg)) {
                int zzaro = ((zzrg) imageView).zzaro();
                if (this.ww != 0 && zzaro == this.ww) {
                    return;
                }
            }
            boolean zzc = zzc(z, z2);
            Drawable zza = zzc ? zza(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(zza);
            if (imageView instanceof zzrg) {
                zzrg com_google_android_gms_internal_zzrg = (zzrg) imageView;
                com_google_android_gms_internal_zzrg.zzp(z3 ? this.wu.uri : null);
                com_google_android_gms_internal_zzrg.zzfw(obj != null ? this.ww : 0);
            }
            if (zzc) {
                ((zzrf) zza).startTransition(Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.wB.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).wB.get();
            boolean z = (imageView2 == null || imageView == null || !zzaa.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.wB.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> wC;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzw(onImageLoadedListener);
            this.wC = new WeakReference(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.wC.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.wC.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && zzaa.equal(onImageLoadedListener2, onImageLoadedListener) && zzaa.equal(com_google_android_gms_common_images_zza_zzc.wu, this.wu);
            return z;
        }

        public int hashCode() {
            return zzaa.hashCode(this.wu);
        }

        protected void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.wC.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.wu.uri, drawable, z3);
                }
            }
        }
    }

    public zza(Uri uri, int i) {
        this.wv = 0;
        this.ww = 0;
        this.wx = false;
        this.wy = true;
        this.wz = false;
        this.wA = true;
        this.wu = new zza(uri);
        this.ww = i;
    }

    private Drawable zza(Context context, zzrh com_google_android_gms_internal_zzrh, int i) {
        return context.getResources().getDrawable(i);
    }

    protected zzrf zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzrf) {
            drawable = ((zzrf) drawable).zzarm();
        }
        return new zzrf(drawable, drawable2);
    }

    void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzw(bitmap);
        zza(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void zza(Context context, zzrh com_google_android_gms_internal_zzrh) {
        if (this.wA) {
            zza(null, false, true, false);
        }
    }

    void zza(Context context, zzrh com_google_android_gms_internal_zzrh, boolean z) {
        Drawable drawable = null;
        if (this.ww != 0) {
            drawable = zza(context, com_google_android_gms_internal_zzrh, this.ww);
        }
        zza(drawable, z, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean zzc(boolean z, boolean z2) {
        return (!this.wy || z2 || z) ? false : true;
    }

    public void zzfu(int i) {
        this.ww = i;
    }
}
