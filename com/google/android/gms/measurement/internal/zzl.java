package com.google.android.gms.measurement.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzre;

public final class zzl {
    public static zza<Long> akA;
    public static zza<Long> akB;
    public static zza<Long> akC;
    public static zza<Long> akD;
    public static zza<Long> akE;
    public static zza<Integer> akF;
    public static zza<Long> akG;
    public static zza<Integer> akH;
    public static zza<Long> akI;
    public static zza<Boolean> aki;
    public static zza<Boolean> akj;
    public static zza<String> akk;
    public static zza<Long> akl;
    public static zza<Long> akm;
    public static zza<Long> akn;
    public static zza<String> ako;
    public static zza<String> akp;
    public static zza<Integer> akq;
    public static zza<Integer> akr;
    public static zza<Integer> aks;
    public static zza<Integer> akt;
    public static zza<Integer> aku;
    public static zza<Integer> akv;
    public static zza<Integer> akw;
    public static zza<Integer> akx;
    public static zza<String> aky;
    public static zza<Long> akz;

    public static final class zza<V> {
        private final V f4I;
        private final zzre<V> f5J;
        private final String zzaxn;

        private zza(String str, zzre<V> com_google_android_gms_internal_zzre_V, V v) {
            zzab.zzaa(com_google_android_gms_internal_zzre_V);
            this.f5J = com_google_android_gms_internal_zzre_V;
            this.f4I = v;
            this.zzaxn = str;
        }

        static zza<Integer> zzaa(String str, int i) {
            return zzo(str, i, i);
        }

        static zza<String> zzav(String str, String str2) {
            return zzl(str, str2, str2);
        }

        static zza<Long> zzb(String str, long j, long j2) {
            return new zza(str, zzre.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zzb(String str, boolean z, boolean z2) {
            return new zza(str, zzre.zzm(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzf(String str, long j) {
            return zzb(str, j, j);
        }

        static zza<String> zzl(String str, String str2, String str3) {
            return new zza(str, zzre.zzab(str, str3), str2);
        }

        static zza<Integer> zzo(String str, int i, int i2) {
            return new zza(str, zzre.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Boolean> zzo(String str, boolean z) {
            return zzb(str, z, z);
        }

        public V get() {
            return this.f4I;
        }

        public V get(V v) {
            return v != null ? v : this.f4I;
        }

        public String getKey() {
            return this.zzaxn;
        }
    }

    static {
        aki = zza.zzo("measurement.service_enabled", true);
        akj = zza.zzo("measurement.service_client_enabled", true);
        akk = zza.zzl("measurement.log_tag", "FA", "FA-SVC");
        akl = zza.zzf("measurement.ad_id_cache_time", 10000);
        akm = zza.zzf("measurement.monitoring.sample_period_millis", 86400000);
        akn = zza.zzb("measurement.config.cache_time", 86400000, 3600000);
        ako = zza.zzav("measurement.config.url_scheme", "https");
        akp = zza.zzav("measurement.config.url_authority", "app-measurement.com");
        akq = zza.zzaa("measurement.upload.max_bundles", 100);
        akr = zza.zzaa("measurement.upload.max_batch_size", AccessibilityNodeInfoCompat.ACTION_CUT);
        aks = zza.zzaa("measurement.upload.max_bundle_size", AccessibilityNodeInfoCompat.ACTION_CUT);
        akt = zza.zzaa("measurement.upload.max_events_per_bundle", ImageRequest.DEFAULT_IMAGE_TIMEOUT_MS);
        aku = zza.zzaa("measurement.upload.max_events_per_day", 100000);
        akv = zza.zzaa("measurement.upload.max_public_events_per_day", 50000);
        akw = zza.zzaa("measurement.upload.max_conversions_per_day", 500);
        akx = zza.zzaa("measurement.store.max_stored_events_per_app", 100000);
        aky = zza.zzav("measurement.upload.url", "https://app-measurement.com/a");
        akz = zza.zzf("measurement.upload.backoff_period", 43200000);
        akA = zza.zzf("measurement.upload.window_interval", 3600000);
        akB = zza.zzf("measurement.upload.interval", 3600000);
        akC = zza.zzf("measurement.upload.stale_data_deletion_interval", 86400000);
        akD = zza.zzf("measurement.upload.initial_upload_delay_time", 15000);
        akE = zza.zzf("measurement.upload.retry_time", 1800000);
        akF = zza.zzaa("measurement.upload.retry_count", 6);
        akG = zza.zzf("measurement.upload.max_queue_time", 2419200000L);
        akH = zza.zzaa("measurement.lifetimevalue.max_currency_tracked", 4);
        akI = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000);
    }
}
