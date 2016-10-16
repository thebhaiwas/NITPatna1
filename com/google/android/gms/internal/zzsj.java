package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.zzc;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsj {
    private static zzsk Me;
    private static final zza Mf;
    public static final zzb Mg;
    public static final zzb Mh;
    public static final zzb Mi;
    public static final zzb Mj;
    public static final zzb Mk;
    private final Context Ml;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzd(Context context, String str, boolean z);

            int zzt(Context context, String str);
        }

        public static class zzb {
            public int Mn;
            public int Mo;
            public int Mp;

            public zzb() {
                this.Mn = 0;
                this.Mo = 0;
                this.Mp = 0;
            }
        }

        zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza);
    }

    /* renamed from: com.google.android.gms.internal.zzsj.1 */
    class C05021 implements zza {
        C05021() {
        }

        public int zzd(Context context, String str, boolean z) {
            return zzsj.zzd(context, str, z);
        }

        public int zzt(Context context, String str) {
            return zzsj.zzt(context, str);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.2 */
    class C05032 implements zzb {
        C05032() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza) {
            zzb com_google_android_gms_internal_zzsj_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mo != 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 1;
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mn = com_google_android_gms_internal_zzsj_zzb_zza.zzt(context, str);
                if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn != 0) {
                    com_google_android_gms_internal_zzsj_zzb_zzb.Mp = -1;
                }
            }
            return com_google_android_gms_internal_zzsj_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.3 */
    class C05043 implements zzb {
        C05043() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza) {
            zzb com_google_android_gms_internal_zzsj_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsj_zzb_zzb.Mn = com_google_android_gms_internal_zzsj_zzb_zza.zzt(context, str);
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn != 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = -1;
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, true);
                if (com_google_android_gms_internal_zzsj_zzb_zzb.Mo != 0) {
                    com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 1;
                }
            }
            return com_google_android_gms_internal_zzsj_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.4 */
    class C05054 implements zzb {
        C05054() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza) {
            zzb com_google_android_gms_internal_zzsj_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsj_zzb_zzb.Mn = com_google_android_gms_internal_zzsj_zzb_zza.zzt(context, str);
            com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn == 0 && com_google_android_gms_internal_zzsj_zzb_zzb.Mo == 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 0;
            } else if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn >= com_google_android_gms_internal_zzsj_zzb_zzb.Mo) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = -1;
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 1;
            }
            return com_google_android_gms_internal_zzsj_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.5 */
    class C05065 implements zzb {
        C05065() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza) {
            zzb com_google_android_gms_internal_zzsj_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsj_zzb_zzb.Mn = com_google_android_gms_internal_zzsj_zzb_zza.zzt(context, str);
            com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, true);
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn == 0 && com_google_android_gms_internal_zzsj_zzb_zzb.Mo == 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 0;
            } else if (com_google_android_gms_internal_zzsj_zzb_zzb.Mo >= com_google_android_gms_internal_zzsj_zzb_zzb.Mn) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 1;
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = -1;
            }
            return com_google_android_gms_internal_zzsj_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.6 */
    class C05076 implements zzb {
        C05076() {
        }

        public zzb zza(Context context, String str, zza com_google_android_gms_internal_zzsj_zzb_zza) {
            zzb com_google_android_gms_internal_zzsj_zzb_zzb = new zzb();
            com_google_android_gms_internal_zzsj_zzb_zzb.Mn = com_google_android_gms_internal_zzsj_zzb_zza.zzt(context, str);
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn != 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, false);
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mo = com_google_android_gms_internal_zzsj_zzb_zza.zzd(context, str, true);
            }
            if (com_google_android_gms_internal_zzsj_zzb_zzb.Mn == 0 && com_google_android_gms_internal_zzsj_zzb_zzb.Mo == 0) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 0;
            } else if (com_google_android_gms_internal_zzsj_zzb_zzb.Mo >= com_google_android_gms_internal_zzsj_zzb_zzb.Mn) {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = 1;
            } else {
                com_google_android_gms_internal_zzsj_zzb_zzb.Mp = -1;
            }
            return com_google_android_gms_internal_zzsj_zzb_zzb;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzsj.7 */
    class C05087 implements zza {
        final /* synthetic */ int Mm;

        C05087(int i) {
            this.Mm = i;
        }

        public int zzd(Context context, String str, boolean z) {
            return 0;
        }

        public int zzt(Context context, String str) {
            return this.Mm;
        }
    }

    static {
        Mf = new C05021();
        Mg = new C05032();
        Mh = new C05043();
        Mi = new C05054();
        Mj = new C05065();
        Mk = new C05076();
    }

    private zzsj(Context context) {
        this.Ml = (Context) zzab.zzaa(context);
    }

    public static zzsj zza(Context context, zzb com_google_android_gms_internal_zzsj_zzb, String str) throws zza {
        zzb zza = com_google_android_gms_internal_zzsj_zzb.zza(context, str, Mf);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza.Mn).append(" and remote module ").append(str).append(":").append(zza.Mo).toString());
        if (zza.Mp == 0 || ((zza.Mp == -1 && zza.Mn == 0) || (zza.Mp == 1 && zza.Mo == 0))) {
            throw new zza(null);
        } else if (zza.Mp == -1) {
            return zzv(context, str);
        } else {
            if (zza.Mp == 1) {
                try {
                    return zza(context, str, zza.Mo);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (zza.Mn != 0 && com_google_android_gms_internal_zzsj_zzb.zza(context, str, new C05087(zza.Mn)).Mp == -1) {
                        return zzv(context, str);
                    }
                    throw new zza(th, null);
                }
            }
            throw new zza(null);
        }
    }

    private static zzsj zza(Context context, String str, int i) throws zza {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsk zzcs = zzcs(context);
        if (zzcs == null) {
            throw new zza(null);
        }
        try {
            zzd zza = zzcs.zza(zze.zzae(context), str, i);
            if (zze.zzad(zza) != null) {
                return new zzsj((Context) zze.zzad(zza));
            }
            throw new zza(null);
        } catch (Throwable e) {
            throw new zza(e, null);
        }
    }

    private static zzsk zzcs(Context context) {
        synchronized (zzsj.class) {
            zzsk com_google_android_gms_internal_zzsk;
            if (Me != null) {
                com_google_android_gms_internal_zzsk = Me;
                return com_google_android_gms_internal_zzsk;
            } else if (zzc.zzand().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    com_google_android_gms_internal_zzsk = com.google.android.gms.internal.zzsk.zza.zzfd((IBinder) context.createPackageContext(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (com_google_android_gms_internal_zzsk != null) {
                        Me = com_google_android_gms_internal_zzsk;
                        return com_google_android_gms_internal_zzsk;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return null;
            }
        }
    }

    public static int zzd(Context context, String str, boolean z) {
        zzsk zzcs = zzcs(context);
        if (zzcs == null) {
            return 0;
        }
        try {
            return zzcs.zza(zze.zzae(context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static int zzt(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e2.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int zzu(Context context, String str) {
        return zzd(context, str, false);
    }

    private static zzsj zzv(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new zzsj(context.getApplicationContext());
    }

    public Context zzbcw() {
        return this.Ml;
    }

    public IBinder zziv(String str) throws zza {
        Throwable e;
        String str2;
        String valueOf;
        try {
            return (IBinder) this.Ml.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException e2) {
            e = e2;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            throw new zza(e, null);
        } catch (InstantiationException e3) {
            e = e3;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(e, null);
        } catch (IllegalAccessException e4) {
            e = e4;
            str2 = "Failed to instantiate module class: ";
            valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
            }
            throw new zza(e, null);
        }
    }
}
