package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzaou;
import com.google.android.gms.internal.zzaov;
import com.google.android.gms.internal.zzup.zzf;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zze extends zzaa {
    private static final Map<String, String> ajJ;
    private final zzc ajK;
    private final zzah ajL;

    public static class zza {
        long ajM;
        long ajN;
        long ajO;
        long ajP;
    }

    interface zzb {
        boolean zza(long j, com.google.android.gms.internal.zzup.zzb com_google_android_gms_internal_zzup_zzb);

        void zzc(com.google.android.gms.internal.zzup.zze com_google_android_gms_internal_zzup_zze);
    }

    private class zzc extends SQLiteOpenHelper {
        final /* synthetic */ zze ajQ;

        zzc(zze com_google_android_gms_measurement_internal_zze, Context context, String str) {
            this.ajQ = com_google_android_gms_measurement_internal_zze;
            super(context, str, null, 1);
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zzb(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.ajQ.zzbsz().zzbtr().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            Set zzc = zzc(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (zzc.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!zzc.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!zzc.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        @WorkerThread
        private boolean zzb(SQLiteDatabase sQLiteDatabase, String str) {
            Object e;
            Throwable th;
            Cursor cursor = null;
            Cursor query;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.ajQ.zzbsz().zzbtt().zze("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.ajQ.zzbsz().zzbtt().zze("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        @WorkerThread
        private Set<String> zzc(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (this.ajQ.ajL.zzx(this.ajQ.zzbtb().zzbrw())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.ajQ.ajL.start();
                    this.ajQ.zzbsz().zzbtr().log("Opening the database failed, dropping and recreating it");
                    this.ajQ.getContext().getDatabasePath(this.ajQ.zzaab()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.ajQ.ajL.clear();
                    } catch (SQLiteException e2) {
                        this.ajQ.zzbsz().zzbtr().zzj("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.ajJ);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            zza(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            zza(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            zza(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            zza(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            zza(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        ajJ = new ArrayMap(16);
        ajJ.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        ajJ.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        ajJ.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        ajJ.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        ajJ.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        ajJ.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        ajJ.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        ajJ.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        ajJ.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        ajJ.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        ajJ.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        ajJ.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        ajJ.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        ajJ.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        ajJ.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        ajJ.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    zze(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.ajL = new zzah(zzyw());
        this.ajK = new zzc(this, getContext(), zzaab());
    }

    @WorkerThread
    @TargetApi(11)
    static int zza(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    @WorkerThread
    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @WorkerThread
    private void zza(String str, com.google.android.gms.internal.zzun.zza com_google_android_gms_internal_zzun_zza) {
        Object obj = null;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(com_google_android_gms_internal_zzun_zza);
        zzab.zzaa(com_google_android_gms_internal_zzun_zza.anY);
        zzab.zzaa(com_google_android_gms_internal_zzun_zza.anX);
        if (com_google_android_gms_internal_zzun_zza.anW == null) {
            zzbsz().zzbtt().log("Audience with no ID");
            return;
        }
        int intValue = com_google_android_gms_internal_zzun_zza.anW.intValue();
        for (com.google.android.gms.internal.zzun.zzb com_google_android_gms_internal_zzun_zzb : com_google_android_gms_internal_zzun_zza.anY) {
            if (com_google_android_gms_internal_zzun_zzb.aoa == null) {
                zzbsz().zzbtt().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", str, com_google_android_gms_internal_zzun_zza.anW);
                return;
            }
        }
        for (com.google.android.gms.internal.zzun.zze com_google_android_gms_internal_zzun_zze : com_google_android_gms_internal_zzun_zza.anX) {
            if (com_google_android_gms_internal_zzun_zze.aoa == null) {
                zzbsz().zzbtt().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", str, com_google_android_gms_internal_zzun_zza.anW);
                return;
            }
        }
        Object obj2 = 1;
        for (com.google.android.gms.internal.zzun.zzb zza : com_google_android_gms_internal_zzun_zza.anY) {
            if (!zza(str, intValue, zza)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (com.google.android.gms.internal.zzun.zze zza2 : com_google_android_gms_internal_zzun_zza.anX) {
                if (!zza(str, intValue, zza2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            zzz(str, intValue);
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, com.google.android.gms.internal.zzun.zzb com_google_android_gms_internal_zzun_zzb) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(com_google_android_gms_internal_zzun_zzb);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzun_zzb.aob)) {
            zzbsz().zzbtt().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzun_zzb.aoa));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzun_zzb.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzun_zzb.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzun_zzb.aoa);
            contentValues.put("event_name", com_google_android_gms_internal_zzun_zzb.aob);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzbsz().zzbtr().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, com.google.android.gms.internal.zzun.zze com_google_android_gms_internal_zzun_zze) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(com_google_android_gms_internal_zzun_zze);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzun_zze.aoq)) {
            zzbsz().zzbtt().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzun_zze.aoa));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzun_zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzun_zze.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzun_zze.aoa);
            contentValues.put("property_name", com_google_android_gms_internal_zzun_zze.aoq);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzbsz().zzbtr().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    @WorkerThread
    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private boolean zzbti() {
        return getContext().getDatabasePath(zzaab()).exists();
    }

    @WorkerThread
    public void beginTransaction() {
        zzzg();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public void endTransaction() {
        zzzg();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    SQLiteDatabase getWritableDatabase() {
        zzwu();
        try {
            return this.ajK.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbsz().zzbtt().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public void setTransactionSuccessful() {
        zzzg();
        getWritableDatabase().setTransactionSuccessful();
    }

    @WorkerThread
    public zza zza(long j, String str, boolean z, boolean z2, boolean z3) {
        Object e;
        Throwable th;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        String[] strArr = new String[]{str};
        zza com_google_android_gms_measurement_internal_zze_zza = new zza();
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            query = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_google_android_gms_measurement_internal_zze_zza.ajN = query.getLong(1);
                        com_google_android_gms_measurement_internal_zze_zza.ajM = query.getLong(2);
                        com_google_android_gms_measurement_internal_zze_zza.ajO = query.getLong(3);
                        com_google_android_gms_measurement_internal_zze_zza.ajP = query.getLong(4);
                    }
                    com_google_android_gms_measurement_internal_zze_zza.ajN++;
                    if (z) {
                        com_google_android_gms_measurement_internal_zze_zza.ajM++;
                    }
                    if (z2) {
                        com_google_android_gms_measurement_internal_zze_zza.ajO++;
                    }
                    if (z3) {
                        com_google_android_gms_measurement_internal_zze_zza.ajP++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.ajM));
                    contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.ajN));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.ajO));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.ajP));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_measurement_internal_zze_zza;
                }
                zzbsz().zzbtt().zzj("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return com_google_android_gms_measurement_internal_zze_zza;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsz().zzbtr().zzj("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_measurement_internal_zze_zza;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzbsz().zzbtr().zzj("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return com_google_android_gms_measurement_internal_zze_zza;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    void zza(ContentValues contentValues, String str, Object obj) {
        zzab.zzhs(str);
        zzab.zzaa(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public void zza(com.google.android.gms.internal.zzup.zze com_google_android_gms_internal_zzup_zze) {
        zzwu();
        zzzg();
        zzab.zzaa(com_google_android_gms_internal_zzup_zze);
        zzab.zzhs(com_google_android_gms_internal_zzup_zze.zzck);
        zzab.zzaa(com_google_android_gms_internal_zzup_zze.aoW);
        zzbtd();
        long currentTimeMillis = zzyw().currentTimeMillis();
        if (com_google_android_gms_internal_zzup_zze.aoW.longValue() < currentTimeMillis - zzbtb().zzbsb() || com_google_android_gms_internal_zzup_zze.aoW.longValue() > zzbtb().zzbsb() + currentTimeMillis) {
            zzbsz().zzbtt().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), com_google_android_gms_internal_zzup_zze.aoW);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzup_zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzup_zze.zza(zzba);
            zzba.ab();
            bArr = zzbsv().zzj(bArr);
            zzbsz().zzbty().zzj("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzup_zze.zzck);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzup_zze.aoW);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzbsz().zzbtr().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    @WorkerThread
    public void zza(zza com_google_android_gms_measurement_internal_zza) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zza);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zza.zzsi());
        contentValues.put("app_instance_id", com_google_android_gms_measurement_internal_zza.zzawj());
        contentValues.put("gmp_app_id", com_google_android_gms_measurement_internal_zza.zzbqo());
        contentValues.put("resettable_device_id_hash", com_google_android_gms_measurement_internal_zza.zzbqp());
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqy()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqr()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqs()));
        contentValues.put("app_version", com_google_android_gms_measurement_internal_zza.zzxc());
        contentValues.put("app_store", com_google_android_gms_measurement_internal_zza.zzbqu());
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqv()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqw()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_measurement_internal_zza.zzbqx()));
        contentValues.put("day", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbrc()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbrd()));
        contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbre()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbrf()));
        contentValues.put("config_fetched_time", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqz()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbra()));
        contentValues.put("app_version_int", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqt()));
        contentValues.put("firebase_instance_id", com_google_android_gms_measurement_internal_zza.zzbqq());
        contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbrg()));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing app", e);
        }
    }

    public void zza(zzh com_google_android_gms_measurement_internal_zzh, long j) {
        zzwu();
        zzzg();
        zzab.zzaa(com_google_android_gms_measurement_internal_zzh);
        zzab.zzhs(com_google_android_gms_measurement_internal_zzh.zzcjj);
        com.google.android.gms.internal.zzup.zzb com_google_android_gms_internal_zzup_zzb = new com.google.android.gms.internal.zzup.zzb();
        com_google_android_gms_internal_zzup_zzb.aoM = Long.valueOf(com_google_android_gms_measurement_internal_zzh.ajX);
        com_google_android_gms_internal_zzup_zzb.aoK = new com.google.android.gms.internal.zzup.zzc[com_google_android_gms_measurement_internal_zzh.ajY.size()];
        Iterator it = com_google_android_gms_measurement_internal_zzh.ajY.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            com.google.android.gms.internal.zzup.zzc com_google_android_gms_internal_zzup_zzc = new com.google.android.gms.internal.zzup.zzc();
            int i2 = i + 1;
            com_google_android_gms_internal_zzup_zzb.aoK[i] = com_google_android_gms_internal_zzup_zzc;
            com_google_android_gms_internal_zzup_zzc.name = str;
            zzbsv().zza(com_google_android_gms_internal_zzup_zzc, com_google_android_gms_measurement_internal_zzh.ajY.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzup_zzb.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzup_zzb.zza(zzba);
            zzba.ab();
            zzbsz().zzbty().zze("Saving event, name, data size", com_google_android_gms_measurement_internal_zzh.mName, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_measurement_internal_zzh.zzcjj);
            contentValues.put("name", com_google_android_gms_measurement_internal_zzh.mName);
            contentValues.put("timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzh.pz));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) == -1) {
                    zzbsz().zzbtr().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    @WorkerThread
    public void zza(zzi com_google_android_gms_measurement_internal_zzi) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzi);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzi.zzcjj);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzi.mName);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_measurement_internal_zzi.ajZ));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_measurement_internal_zzi.aka));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzi.akb));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing event aggregates", e);
        }
    }

    void zza(String str, int i, zzf com_google_android_gms_internal_zzup_zzf) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(com_google_android_gms_internal_zzup_zzf);
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzup_zzf.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzup_zzf.zza(zzba);
            zzba.ab();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzbsz().zzbtr().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    public void zza(String str, long j, zzb com_google_android_gms_measurement_internal_zze_zzb) {
        Object string;
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzaa(com_google_android_gms_measurement_internal_zze_zzb);
        zzwu();
        zzzg();
        try {
            String str2;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = writableDatabase.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = writableDatabase.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = writableDatabase.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    zzaou zzaz = zzaou.zzaz(cursor.getBlob(0));
                    com.google.android.gms.internal.zzup.zze com_google_android_gms_internal_zzup_zze = new com.google.android.gms.internal.zzup.zze();
                    try {
                        com.google.android.gms.internal.zzup.zze com_google_android_gms_internal_zzup_zze2 = (com.google.android.gms.internal.zzup.zze) com_google_android_gms_internal_zzup_zze.zzb(zzaz);
                        if (cursor.moveToNext()) {
                            zzbsz().zzbtt().log("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        com_google_android_gms_measurement_internal_zze_zzb.zzc(com_google_android_gms_internal_zzup_zze);
                        cursor2 = writableDatabase.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                long j2 = cursor2.getLong(0);
                                zzaou zzaz2 = zzaou.zzaz(cursor2.getBlob(3));
                                com.google.android.gms.internal.zzup.zzb com_google_android_gms_internal_zzup_zzb = new com.google.android.gms.internal.zzup.zzb();
                                try {
                                    com.google.android.gms.internal.zzup.zzb com_google_android_gms_internal_zzup_zzb2 = (com.google.android.gms.internal.zzup.zzb) com_google_android_gms_internal_zzup_zzb.zzb(zzaz2);
                                    com_google_android_gms_internal_zzup_zzb.name = cursor2.getString(1);
                                    com_google_android_gms_internal_zzup_zzb.aoL = Long.valueOf(cursor2.getLong(2));
                                    if (!com_google_android_gms_measurement_internal_zze_zzb.zza(j2, com_google_android_gms_internal_zzup_zzb)) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (IOException e2) {
                                    try {
                                        zzbsz().zzbtr().zze("Data loss. Failed to merge raw event", string, e2);
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                    }
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        zzbsz().zzbtt().log("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e22) {
                        zzbsz().zzbtr().zze("Data loss. Failed to merge raw event metadata", string, e22);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                zzbsz().zzbtr().log("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor2 = cursor;
                try {
                    zzbsz().zzbtr().zzj("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e32) {
            e = e32;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public boolean zza(zzak com_google_android_gms_measurement_internal_zzak) {
        zzab.zzaa(com_google_android_gms_measurement_internal_zzak);
        zzwu();
        zzzg();
        if (zzas(com_google_android_gms_measurement_internal_zzak.zzcjj, com_google_android_gms_measurement_internal_zzak.mName) == null) {
            if (zzal.zzmk(com_google_android_gms_measurement_internal_zzak.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_google_android_gms_measurement_internal_zzak.zzcjj}) >= ((long) zzbtb().zzbru())) {
                    return false;
                }
            }
            if (zzb("select count(1) from user_attributes where app_id=?", new String[]{com_google_android_gms_measurement_internal_zzak.zzcjj}) >= ((long) zzbtb().zzbrv())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzak.zzcjj);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzak.mName);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzak.anU));
        zza(contentValues, Param.VALUE, com_google_android_gms_measurement_internal_zzak.zzcnr);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzbsz().zzbtr().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing user property", e);
        }
        return true;
    }

    String zzaab() {
        if (!zzbtb().zzabc()) {
            return zzbtb().zzacc();
        }
        if (zzbtb().zzabd()) {
            return zzbtb().zzacc();
        }
        zzbsz().zzbtu().log("Using secondary database");
        return zzbtb().zzacd();
    }

    public void zzac(List<Long> list) {
        zzab.zzaa(list);
        zzwu();
        zzzg();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = getWritableDatabase().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            zzbsz().zzbtr().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    @WorkerThread
    public zzi zzaq(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            Cursor query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzi com_google_android_gms_measurement_internal_zzi = new zzi(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        zzbsz().zzbtr().log("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzi;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzi;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzbsz().zzbtr().zzd("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzbsz().zzbtr().zzd("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public void zzar(String str, String str2) {
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            zzbsz().zzbty().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    @WorkerThread
    public zzak zzas(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzab.zzhs(str2);
        zzwu();
        zzzg();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", Param.VALUE}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzak com_google_android_gms_measurement_internal_zzak = new zzak(str, str2, query.getLong(0), zzb(query, 1));
                    if (query.moveToNext()) {
                        zzbsz().zzbtr().log("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzak;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzak;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzbsz().zzbtr().zzd("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzbsz().zzbtr().zzd("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    Map<Integer, List<com.google.android.gms.internal.zzun.zzb>> zzat(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzhs(str2);
        Map<Integer, List<com.google.android.gms.internal.zzun.zzb>> arrayMap = new ArrayMap();
        try {
            query = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        zzaou zzaz = zzaou.zzaz(query.getBlob(1));
                        com.google.android.gms.internal.zzun.zzb com_google_android_gms_internal_zzun_zzb = new com.google.android.gms.internal.zzun.zzb();
                        try {
                            com.google.android.gms.internal.zzun.zzb com_google_android_gms_internal_zzun_zzb2 = (com.google.android.gms.internal.zzun.zzb) com_google_android_gms_internal_zzun_zzb.zzb(zzaz);
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(com_google_android_gms_internal_zzun_zzb);
                        } catch (IOException e2) {
                            zzbsz().zzbtr().zze("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map<Integer, List<com.google.android.gms.internal.zzun.zzb>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzbsz().zzbtr().zzj("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<com.google.android.gms.internal.zzun.zze>> zzau(String str, String str2) {
        Object e;
        Throwable th;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzhs(str2);
        Map<Integer, List<com.google.android.gms.internal.zzun.zze>> arrayMap = new ArrayMap();
        Cursor query;
        try {
            query = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        zzaou zzaz = zzaou.zzaz(query.getBlob(1));
                        com.google.android.gms.internal.zzun.zze com_google_android_gms_internal_zzun_zze = new com.google.android.gms.internal.zzun.zze();
                        try {
                            com.google.android.gms.internal.zzun.zze com_google_android_gms_internal_zzun_zze2 = (com.google.android.gms.internal.zzun.zze) com_google_android_gms_internal_zzun_zze.zzb(zzaz);
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(com_google_android_gms_internal_zzun_zze);
                        } catch (IOException e2) {
                            zzbsz().zzbtr().zze("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            }
            Map<Integer, List<com.google.android.gms.internal.zzun.zze>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzbsz().zzbtr().zzj("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public long zzb(com.google.android.gms.internal.zzup.zze com_google_android_gms_internal_zzup_zze) throws IOException {
        zzwu();
        zzzg();
        zzab.zzaa(com_google_android_gms_internal_zzup_zze);
        zzab.zzhs(com_google_android_gms_internal_zzup_zze.zzck);
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzup_zze.ao()];
            zzaov zzba = zzaov.zzba(bArr);
            com_google_android_gms_internal_zzup_zze.zza(zzba);
            zzba.ab();
            long zzad = zzbsv().zzad(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzup_zze.zzck);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzad));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return zzad;
            } catch (SQLiteException e) {
                zzbsz().zzbtr().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzbsz().zzbtr().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    @WorkerThread
    Object zzb(Cursor cursor, int i) {
        int zza = zza(cursor, i);
        switch (zza) {
            case ConnectionResult.SUCCESS /*0*/:
                zzbsz().zzbtr().log("Loaded invalid null value from database");
                return null;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return Long.valueOf(cursor.getLong(i));
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return Double.valueOf(cursor.getDouble(i));
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return cursor.getString(i);
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                zzbsz().zzbtr().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzbsz().zzbtr().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(zza));
                return null;
        }
    }

    @WorkerThread
    void zzb(String str, com.google.android.gms.internal.zzun.zza[] com_google_android_gms_internal_zzun_zzaArr) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        zzab.zzaa(com_google_android_gms_internal_zzun_zzaArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzlr(str);
            for (com.google.android.gms.internal.zzun.zza zza : com_google_android_gms_internal_zzun_zzaArr) {
                zza(str, zza);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void zzbg(long j) {
        zzwu();
        zzzg();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzbsz().zzbtr().log("Deleted fewer rows from queue than expected");
        }
    }

    public String zzbh(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        zzwu();
        zzzg();
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    zzbsz().zzbty().log("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsz().zzbtr().zzj("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            zzbsz().zzbtr().zzj("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    @WorkerThread
    public String zzbtc() {
        Object e;
        Throwable th;
        String str = null;
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsz().zzbtr().zzj("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzbsz().zzbtr().zzj("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    @WorkerThread
    void zzbtd() {
        zzwu();
        zzzg();
        if (zzbti()) {
            long j = zzbta().aly.get();
            long elapsedRealtime = zzyw().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzbtb().zzbsc()) {
                zzbta().aly.set(elapsedRealtime);
                zzbte();
            }
        }
    }

    @WorkerThread
    void zzbte() {
        zzwu();
        zzzg();
        if (zzbti()) {
            int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzyw().currentTimeMillis()), String.valueOf(zzbtb().zzbsb())});
            if (delete > 0) {
                zzbsz().zzbty().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    @WorkerThread
    public long zzbtf() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @WorkerThread
    public long zzbtg() {
        return zza("select max(timestamp) from raw_events", null, 0);
    }

    public boolean zzbth() {
        return zzb("select count(1) > 0 from raw_events", null) != 0;
    }

    @WorkerThread
    public void zzd(String str, byte[] bArr) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzbsz().zzbtr().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error storing remote config", e);
        }
    }

    @WorkerThread
    public List<zzak> zzln(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        List<zzak> arrayList = new ArrayList();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", "set_timestamp", Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzbtb().zzbrv()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object zzb = zzb(query, 2);
                        if (zzb == null) {
                            zzbsz().zzbtr().log("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new zzak(str, string, j, zzb));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzbsz().zzbtr().zze("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public zza zzlo(String str) {
        Object e;
        Throwable th;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        Cursor query;
        try {
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zza com_google_android_gms_measurement_internal_zza = new zza(this.aja, str);
                    com_google_android_gms_measurement_internal_zza.zzkz(query.getString(0));
                    com_google_android_gms_measurement_internal_zza.zzla(query.getString(1));
                    com_google_android_gms_measurement_internal_zza.zzlb(query.getString(2));
                    com_google_android_gms_measurement_internal_zza.zzay(query.getLong(3));
                    com_google_android_gms_measurement_internal_zza.zzat(query.getLong(4));
                    com_google_android_gms_measurement_internal_zza.zzau(query.getLong(5));
                    com_google_android_gms_measurement_internal_zza.setAppVersion(query.getString(6));
                    com_google_android_gms_measurement_internal_zza.zzld(query.getString(7));
                    com_google_android_gms_measurement_internal_zza.zzaw(query.getLong(8));
                    com_google_android_gms_measurement_internal_zza.zzax(query.getLong(9));
                    com_google_android_gms_measurement_internal_zza.setMeasurementEnabled((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    com_google_android_gms_measurement_internal_zza.zzbb(query.getLong(11));
                    com_google_android_gms_measurement_internal_zza.zzbc(query.getLong(12));
                    com_google_android_gms_measurement_internal_zza.zzbd(query.getLong(13));
                    com_google_android_gms_measurement_internal_zza.zzbe(query.getLong(14));
                    com_google_android_gms_measurement_internal_zza.zzaz(query.getLong(15));
                    com_google_android_gms_measurement_internal_zza.zzba(query.getLong(16));
                    com_google_android_gms_measurement_internal_zza.zzav(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    com_google_android_gms_measurement_internal_zza.zzlc(query.getString(18));
                    com_google_android_gms_measurement_internal_zza.zzbf(query.getLong(19));
                    com_google_android_gms_measurement_internal_zza.zzbqn();
                    if (query.moveToNext()) {
                        zzbsz().zzbtr().log("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zza;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zza;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsz().zzbtr().zze("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzbsz().zzbtr().zze("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public long zzlp(String str) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(zzbtb().zzlm(str));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Error deleting over the limit events", e);
            return 0;
        }
    }

    @WorkerThread
    public byte[] zzlq(String str) {
        Cursor query;
        Object e;
        Throwable th;
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzbsz().zzbtr().log("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsz().zzbtr().zze("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzbsz().zzbtr().zze("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    void zzlr(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=?", new String[]{str});
        writableDatabase.delete("event_filters", "app_id=?", new String[]{str});
    }

    Map<Integer, zzf> zzls(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        zzzg();
        zzwu();
        zzab.zzhs(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, zzf> arrayMap = new ArrayMap();
                    do {
                        int i = query.getInt(0);
                        zzaou zzaz = zzaou.zzaz(query.getBlob(1));
                        zzf com_google_android_gms_internal_zzup_zzf = new zzf();
                        try {
                            zzf com_google_android_gms_internal_zzup_zzf2 = (zzf) com_google_android_gms_internal_zzup_zzf.zzb(zzaz);
                            arrayMap.put(Integer.valueOf(i), com_google_android_gms_internal_zzup_zzf);
                        } catch (IOException e2) {
                            zzbsz().zzbtr().zzd("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayMap;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzbsz().zzbtr().zzj("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    @WorkerThread
    void zzlt(String str) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + (((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                zzbsz().zzbty().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Error deleting application data. appId, error", str, e);
        }
    }

    public void zzlu(String str) {
        try {
            getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzlv(String str) {
        zzab.zzhs(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.WorkerThread
    public java.util.List<android.util.Pair<com.google.android.gms.internal.zzup.zze, java.lang.Long>> zzn(java.lang.String r12, int r13, int r14) {
        /*
        r11 = this;
        r10 = 0;
        r1 = 1;
        r9 = 0;
        r11.zzwu();
        r11.zzzg();
        if (r13 <= 0) goto L_0x004e;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        com.google.android.gms.common.internal.zzab.zzbn(r0);
        if (r14 <= 0) goto L_0x0050;
    L_0x0011:
        com.google.android.gms.common.internal.zzab.zzbn(r1);
        com.google.android.gms.common.internal.zzab.zzhs(r12);
        r0 = r11.getWritableDatabase();	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r1 = "queue";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r3 = 0;
        r4 = "rowid";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r3 = 1;
        r4 = "data";
        r2[r3] = r4;	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r3 = "app_id=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r5 = 0;
        r4[r5] = r12;	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r5 = 0;
        r6 = 0;
        r7 = "rowid";
        r8 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
        r0 = r2.moveToFirst();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        if (r0 != 0) goto L_0x0052;
    L_0x0044:
        r0 = java.util.Collections.emptyList();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        if (r2 == 0) goto L_0x004d;
    L_0x004a:
        r2.close();
    L_0x004d:
        return r0;
    L_0x004e:
        r0 = r9;
        goto L_0x000c;
    L_0x0050:
        r1 = r9;
        goto L_0x0011;
    L_0x0052:
        r1 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r1.<init>();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r3 = r9;
    L_0x0058:
        r0 = 0;
        r4 = r2.getLong(r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = 1;
        r0 = r2.getBlob(r0);	 Catch:{ IOException -> 0x007b }
        r6 = r11.zzbsv();	 Catch:{ IOException -> 0x007b }
        r6 = r6.zzab(r0);	 Catch:{ IOException -> 0x007b }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        if (r0 != 0) goto L_0x0094;
    L_0x0070:
        r0 = r6.length;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = r0 + r3;
        if (r0 <= r14) goto L_0x0094;
    L_0x0074:
        if (r2 == 0) goto L_0x0079;
    L_0x0076:
        r2.close();
    L_0x0079:
        r0 = r1;
        goto L_0x004d;
    L_0x007b:
        r0 = move-exception;
        r4 = r11.zzbsz();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r4 = r4.zzbtr();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r5 = "Failed to unzip queued bundle";
        r4.zze(r5, r12, r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = r3;
    L_0x008a:
        r3 = r2.moveToNext();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        if (r3 == 0) goto L_0x0074;
    L_0x0090:
        if (r0 > r14) goto L_0x0074;
    L_0x0092:
        r3 = r0;
        goto L_0x0058;
    L_0x0094:
        r0 = com.google.android.gms.internal.zzaou.zzaz(r6);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r7 = new com.google.android.gms.internal.zzup$zze;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r7.<init>();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = r7.zzb(r0);	 Catch:{ IOException -> 0x00ca }
        r0 = (com.google.android.gms.internal.zzup.zze) r0;	 Catch:{ IOException -> 0x00ca }
        r0 = r6.length;	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = r0 + r3;
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r3 = android.util.Pair.create(r7, r3);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r1.add(r3);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        goto L_0x008a;
    L_0x00b1:
        r0 = move-exception;
        r1 = r2;
    L_0x00b3:
        r2 = r11.zzbsz();	 Catch:{ all -> 0x00e4 }
        r2 = r2.zzbtr();	 Catch:{ all -> 0x00e4 }
        r3 = "Error querying bundles";
        r2.zze(r3, r12, r0);	 Catch:{ all -> 0x00e4 }
        r0 = java.util.Collections.emptyList();	 Catch:{ all -> 0x00e4 }
        if (r1 == 0) goto L_0x004d;
    L_0x00c6:
        r1.close();
        goto L_0x004d;
    L_0x00ca:
        r0 = move-exception;
        r4 = r11.zzbsz();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r4 = r4.zzbtr();	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r5 = "Failed to merge queued bundle";
        r4.zze(r5, r12, r0);	 Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
        r0 = r3;
        goto L_0x008a;
    L_0x00da:
        r0 = move-exception;
        r2 = r10;
    L_0x00dc:
        if (r2 == 0) goto L_0x00e1;
    L_0x00de:
        r2.close();
    L_0x00e1:
        throw r0;
    L_0x00e2:
        r0 = move-exception;
        goto L_0x00dc;
    L_0x00e4:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00dc;
    L_0x00e7:
        r0 = move-exception;
        r1 = r10;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzn(java.lang.String, int, int):java.util.List<android.util.Pair<com.google.android.gms.internal.zzup$zze, java.lang.Long>>");
    }

    protected void zzwv() {
    }

    @WorkerThread
    public void zzy(String str, int i) {
        zzab.zzhs(str);
        zzwu();
        zzzg();
        try {
            getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzbsz().zzbtr().zze("Error pruning currencies", str, e);
        }
    }

    void zzz(String str, int i) {
        zzzg();
        zzwu();
        zzab.zzhs(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        writableDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }
}
