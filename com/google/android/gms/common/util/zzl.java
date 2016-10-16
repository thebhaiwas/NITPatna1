package com.google.android.gms.common.util;

import com.android.volley.toolbox.ImageRequest;
import java.util.regex.Pattern;

public final class zzl {
    private static Pattern AS;

    static {
        AS = null;
    }

    public static int zzgw(int i) {
        return i / ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS;
    }
}
