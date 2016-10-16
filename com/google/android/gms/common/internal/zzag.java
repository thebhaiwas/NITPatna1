package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0219R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzag extends Button {
    public zzag(Context context) {
        this(context, null);
    }

    public zzag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void zza(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? zzd(i, zzg(i2, C0219R.drawable.common_plus_signin_btn_icon_dark, C0219R.drawable.common_plus_signin_btn_icon_light, C0219R.drawable.common_plus_signin_btn_icon_dark), zzg(i2, C0219R.drawable.common_plus_signin_btn_text_dark, C0219R.drawable.common_plus_signin_btn_text_light, C0219R.drawable.common_plus_signin_btn_text_dark)) : zzd(i, zzg(i2, C0219R.drawable.common_google_signin_btn_icon_dark, C0219R.drawable.common_google_signin_btn_icon_light, C0219R.drawable.common_google_signin_btn_icon_light), zzg(i2, C0219R.drawable.common_google_signin_btn_text_dark, C0219R.drawable.common_google_signin_btn_text_light, C0219R.drawable.common_google_signin_btn_text_light))));
    }

    private boolean zza(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope zzaoh : scopeArr) {
            String zzaoh2 = zzaoh.zzaoh();
            if (zzaoh2.contains("/plus.") && !zzaoh2.equals(Scopes.PLUS_ME)) {
                return true;
            }
            if (zzaoh2.equals(Scopes.GAMES)) {
                return true;
            }
        }
        return false;
    }

    private void zzb(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzab.zzaa(resources.getColorStateList(z ? zzg(i2, C0219R.color.common_plus_signin_btn_text_dark, C0219R.color.common_plus_signin_btn_text_light, C0219R.color.common_plus_signin_btn_text_dark) : zzg(i2, C0219R.color.common_google_signin_btn_text_dark, C0219R.color.common_google_signin_btn_text_light, C0219R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case ConnectionResult.SUCCESS /*0*/:
                setText(resources.getString(C0219R.string.common_signin_button_text));
                break;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                setText(resources.getString(C0219R.string.common_signin_button_text_long));
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
    }

    private int zzd(int i, int i2, int i3) {
        switch (i) {
            case ConnectionResult.SUCCESS /*0*/:
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return i3;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return i2;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    private int zzg(int i, int i2, int i3, int i4) {
        switch (i) {
            case ConnectionResult.SUCCESS /*0*/:
                return i2;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return i3;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean zza = zza(scopeArr);
        zza(resources);
        zza(resources, i, i2, zza);
        zzb(resources, i, i2, zza);
    }
}
