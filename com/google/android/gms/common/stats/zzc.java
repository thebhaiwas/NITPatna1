package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzre;
import xyz.purush.nitp.nitpatna.BuildConfig;

public final class zzc {
    public static zzre<Integer> Af;
    public static zzre<Integer> Ag;

    public static final class zza {
        public static zzre<Integer> Ah;
        public static zzre<String> Ai;
        public static zzre<String> Aj;
        public static zzre<String> Ak;
        public static zzre<String> Al;
        public static zzre<Long> Am;

        static {
            Ah = zzre.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
            Ai = zzre.zzab("gms:common:stats:connections:ignored_calling_processes", BuildConfig.FLAVOR);
            Aj = zzre.zzab("gms:common:stats:connections:ignored_calling_services", BuildConfig.FLAVOR);
            Ak = zzre.zzab("gms:common:stats:connections:ignored_target_processes", BuildConfig.FLAVOR);
            Al = zzre.zzab("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
            Am = zzre.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
        }
    }

    public static final class zzb {
        public static zzre<Integer> Ah;
        public static zzre<Long> Am;

        static {
            Ah = zzre.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
            Am = zzre.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
        }
    }

    static {
        Af = zzre.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
        Ag = zzre.zza("gms:common:stats:max_chunk_size", Integer.valueOf(100));
    }
}
