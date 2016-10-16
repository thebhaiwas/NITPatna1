package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzui;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    public static class zza extends zza<Boolean> {

        /* renamed from: com.google.android.gms.flags.impl.zza.zza.1 */
        class C02271 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences Qu;
            final /* synthetic */ String Qv;
            final /* synthetic */ Boolean Qw;

            C02271(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.Qu = sharedPreferences;
                this.Qv = str;
                this.Qw = bool;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzto();
            }

            public Boolean zzto() {
                return Boolean.valueOf(this.Qu.getBoolean(this.Qv, this.Qw.booleanValue()));
            }
        }

        public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) zzui.zzb(new C02271(sharedPreferences, str, bool));
        }
    }

    public static class zzb extends zza<Integer> {

        /* renamed from: com.google.android.gms.flags.impl.zza.zzb.1 */
        class C02281 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences Qu;
            final /* synthetic */ String Qv;
            final /* synthetic */ Integer Qx;

            C02281(SharedPreferences sharedPreferences, String str, Integer num) {
                this.Qu = sharedPreferences;
                this.Qv = str;
                this.Qx = num;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzbft();
            }

            public Integer zzbft() {
                return Integer.valueOf(this.Qu.getInt(this.Qv, this.Qx.intValue()));
            }
        }

        public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) zzui.zzb(new C02281(sharedPreferences, str, num));
        }
    }

    public static class zzc extends zza<Long> {

        /* renamed from: com.google.android.gms.flags.impl.zza.zzc.1 */
        class C02291 implements Callable<Long> {
            final /* synthetic */ SharedPreferences Qu;
            final /* synthetic */ String Qv;
            final /* synthetic */ Long Qy;

            C02291(SharedPreferences sharedPreferences, String str, Long l) {
                this.Qu = sharedPreferences;
                this.Qv = str;
                this.Qy = l;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzbfu();
            }

            public Long zzbfu() {
                return Long.valueOf(this.Qu.getLong(this.Qv, this.Qy.longValue()));
            }
        }

        public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) zzui.zzb(new C02291(sharedPreferences, str, l));
        }
    }

    public static class zzd extends zza<String> {

        /* renamed from: com.google.android.gms.flags.impl.zza.zzd.1 */
        class C02301 implements Callable<String> {
            final /* synthetic */ SharedPreferences Qu;
            final /* synthetic */ String Qv;
            final /* synthetic */ String Qz;

            C02301(SharedPreferences sharedPreferences, String str, String str2) {
                this.Qu = sharedPreferences;
                this.Qv = str;
                this.Qz = str2;
            }

            public /* synthetic */ Object call() throws Exception {
                return zzaba();
            }

            public String zzaba() {
                return this.Qu.getString(this.Qv, this.Qz);
            }
        }

        public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) zzui.zzb(new C02301(sharedPreferences, str, str2));
        }
    }
}
