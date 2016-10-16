package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.C0219R;

public class zzai {
    private final Resources zc;
    private final String zd;

    public zzai(Context context) {
        zzab.zzaa(context);
        this.zc = context.getResources();
        this.zd = this.zc.getResourcePackageName(C0219R.string.common_google_play_services_unknown_issue);
    }

    public String getString(String str) {
        int identifier = this.zc.getIdentifier(str, "string", this.zd);
        return identifier == 0 ? null : this.zc.getString(identifier);
    }
}
