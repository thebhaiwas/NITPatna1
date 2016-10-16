package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzaoi extends zzank<Object> {
    public static final zzanl bfE;
    private final zzams beA;

    /* renamed from: com.google.android.gms.internal.zzaoi.2 */
    static /* synthetic */ class C02402 {
        static final /* synthetic */ int[] bfU;

        static {
            bfU = new int[zzaoq.values().length];
            try {
                bfU[zzaoq.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bfU[zzaoq.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bfU[zzaoq.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                bfU[zzaoq.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                bfU[zzaoq.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                bfU[zzaoq.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzaoi.1 */
    static class C04711 implements zzanl {
        C04711() {
        }

        public <T> zzank<T> zza(zzams com_google_android_gms_internal_zzams, zzaoo<T> com_google_android_gms_internal_zzaoo_T) {
            return com_google_android_gms_internal_zzaoo_T.m18s() == Object.class ? new zzaoi(null) : null;
        }
    }

    static {
        bfE = new C04711();
    }

    private zzaoi(zzams com_google_android_gms_internal_zzams) {
        this.beA = com_google_android_gms_internal_zzams;
    }

    public void zza(zzaor com_google_android_gms_internal_zzaor, Object obj) throws IOException {
        if (obj == null) {
            com_google_android_gms_internal_zzaor.m40r();
            return;
        }
        zzank zzk = this.beA.zzk(obj.getClass());
        if (zzk instanceof zzaoi) {
            com_google_android_gms_internal_zzaor.m38p();
            com_google_android_gms_internal_zzaor.m39q();
            return;
        }
        zzk.zza(com_google_android_gms_internal_zzaor, obj);
    }

    public Object zzb(zzaop com_google_android_gms_internal_zzaop) throws IOException {
        switch (C02402.bfU[com_google_android_gms_internal_zzaop.m29h().ordinal()]) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                List arrayList = new ArrayList();
                com_google_android_gms_internal_zzaop.beginArray();
                while (com_google_android_gms_internal_zzaop.hasNext()) {
                    arrayList.add(zzb(com_google_android_gms_internal_zzaop));
                }
                com_google_android_gms_internal_zzaop.endArray();
                return arrayList;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                Map com_google_android_gms_internal_zzanw = new zzanw();
                com_google_android_gms_internal_zzaop.beginObject();
                while (com_google_android_gms_internal_zzaop.hasNext()) {
                    com_google_android_gms_internal_zzanw.put(com_google_android_gms_internal_zzaop.nextName(), zzb(com_google_android_gms_internal_zzaop));
                }
                com_google_android_gms_internal_zzaop.endObject();
                return com_google_android_gms_internal_zzanw;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return com_google_android_gms_internal_zzaop.nextString();
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return Double.valueOf(com_google_android_gms_internal_zzaop.nextDouble());
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                return Boolean.valueOf(com_google_android_gms_internal_zzaop.nextBoolean());
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                com_google_android_gms_internal_zzaop.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
