package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzapc;
import java.util.List;
import java.util.zip.CRC32;
import xyz.purush.nitp.nitpatna.BuildConfig;

public class UsageInfo extends AbstractSafeParcelable {
    public static final zzj CREATOR;
    int bA;
    final DocumentContents bB;
    final boolean bC;
    int bD;
    int bE;
    final DocumentId by;
    final long bz;
    final int mVersionCode;
    public final String zzaxj;

    public static final class zza {
        private int bA;
        private DocumentContents bB;
        private boolean bC;
        private int bD;
        private int bE;
        private DocumentId by;
        private long bz;

        public zza() {
            this.bz = -1;
            this.bA = -1;
            this.bD = -1;
            this.bC = false;
            this.bE = 0;
        }

        public zza zza(DocumentContents documentContents) {
            this.bB = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.by = documentId;
            return this;
        }

        public UsageInfo zzaer() {
            return new UsageInfo(this.bz, this.bA, null, this.bB, this.bC, this.bD, this.bE, null);
        }

        public zza zzax(boolean z) {
            this.bC = z;
            return this;
        }

        public zza zzch(int i) {
            this.bA = i;
            return this;
        }

        public zza zzci(int i) {
            this.bE = i;
            return this;
        }

        public zza zzy(long j) {
            this.bz = j;
            return this;
        }
    }

    static {
        CREATOR = new zzj();
    }

    UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.mVersionCode = i;
        this.by = documentId;
        this.bz = j;
        this.bA = i2;
        this.zzaxj = str;
        this.bB = documentContents;
        this.bC = z;
        this.bD = i3;
        this.bE = i4;
    }

    private UsageInfo(DocumentId documentId, long j, int i, String str, DocumentContents documentContents, boolean z, int i2, int i3) {
        this(1, documentId, j, i, str, documentContents, z, i2, i3);
    }

    public UsageInfo(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list, int i) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, null, zza(intent, str2, uri, str3, list).zzaen(), false, -1, i);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza com_google_android_gms_appdatasearch_DocumentContents_zza = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzfj(str));
        if (uri != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzj(uri));
        }
        if (list != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzu(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzu("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzu("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzu("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_appdatasearch_DocumentContents_zza.zza(zzu("intent_extra_data", action));
            }
        }
        return com_google_android_gms_appdatasearch_DocumentContents_zza.zzff(str2).zzau(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzt(str, zzg(intent));
    }

    private static DocumentSection zzfj(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("title").zzcf(1).zzaw(true).zzfi("name").zzaeq(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzj(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzcf(4).zzav(true).zzfi("url").zzaeq());
    }

    private static DocumentId zzt(String str, String str2) {
        return new DocumentId(str, BuildConfig.FLAVOR, str2);
    }

    private static DocumentSection zzu(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzav(true).zzaeq(), str);
    }

    private static DocumentSection zzu(List<AppIndexingLink> list) {
        zzapc com_google_android_gms_internal_zzuj_zza = new com.google.android.gms.internal.zzuj.zza();
        com.google.android.gms.internal.zzuj.zza.zza[] com_google_android_gms_internal_zzuj_zza_zzaArr = new com.google.android.gms.internal.zzuj.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzuj_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzuj_zza_zzaArr[i] = new com.google.android.gms.internal.zzuj.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzuj_zza_zzaArr[i].abp = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzuj_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzuj_zza_zzaArr[i].abq = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzuj_zza.abn = com_google_android_gms_internal_zzuj_zza_zzaArr;
        return new DocumentSection(zzapc.zzf(com_google_android_gms_internal_zzuj_zza), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzav(true).zzfi(".private:outLinks").zzfh("blob").zzaeq());
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.by, Long.valueOf(this.bz), Integer.valueOf(this.bA), Integer.valueOf(this.bE)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj com_google_android_gms_appdatasearch_zzj = CREATOR;
        zzj.zza(this, parcel, i);
    }
}
