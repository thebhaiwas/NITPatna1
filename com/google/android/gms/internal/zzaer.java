package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzaer {
    public static final Uri CONTENT_URI;
    public static final Uri aLW;
    public static final Pattern aLX;
    public static final Pattern aLY;
    private static HashMap<String, String> aLZ;
    private static Object aMa;
    private static String[] aMb;
    private static Context aMc;

    /* renamed from: com.google.android.gms.internal.zzaer.1 */
    class C02341 extends Thread {
        final /* synthetic */ ContentResolver aMd;

        /* renamed from: com.google.android.gms.internal.zzaer.1.1 */
        class C02331 extends ContentObserver {
            final /* synthetic */ C02341 aMe;

            C02331(C02341 c02341, Handler handler) {
                this.aMe = c02341;
                super(handler);
            }

            public void onChange(boolean z) {
                synchronized (zzaer.class) {
                    zzaer.aLZ.clear();
                    zzaer.aMa = new Object();
                    if (zzaer.aMb.length > 0) {
                        zzaer.zzb(this.aMe.aMd, zzaer.aMb);
                    }
                }
            }
        }

        C02341(String str, ContentResolver contentResolver) {
            this.aMd = contentResolver;
            super(str);
        }

        public void run() {
            Looper.prepare();
            this.aMd.registerContentObserver(zzaer.CONTENT_URI, true, new C02331(this, new Handler(Looper.myLooper())));
            Looper.loop();
        }
    }

    static {
        CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
        aLW = Uri.parse("content://com.google.android.gsf.gservices/prefix");
        aLX = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        aLY = Pattern.compile("^(0|false|f|off|no|n)$", 2);
        aMb = new String[0];
        aMc = null;
    }

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                j = Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaer.class) {
            zza(contentResolver);
            Object obj = aMa;
            String str3;
            if (aLZ.containsKey(str)) {
                str3 = (String) aLZ.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                for (String startsWith : aMb) {
                    if (str.startsWith(startsWith)) {
                        break;
                    }
                }
                Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            synchronized (zzaer.class) {
                                if (obj == aMa) {
                                    aLZ.put(str, str3);
                                }
                            }
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                aLZ.put(str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(aLW, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (aLZ == null) {
            aLZ = new HashMap();
            aMa = new Object();
            new C02341("Gservices", contentResolver).start();
        }
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map zza = zza(contentResolver, strArr);
        synchronized (zzaer.class) {
            zza(contentResolver);
            aMb = strArr;
            for (Entry entry : zza.entrySet()) {
                aLZ.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
