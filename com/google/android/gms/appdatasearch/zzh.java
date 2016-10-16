package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh {
    private static final String[] bi;
    private static final Map<String, Integer> bj;

    static {
        int i = 0;
        bi = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        bj = new HashMap(bi.length);
        while (i < bi.length) {
            bj.put(bi[i], Integer.valueOf(i));
            i++;
        }
    }

    public static int zzaep() {
        return bi.length;
    }

    public static String zzce(int i) {
        return (i < 0 || i >= bi.length) ? null : bi[i];
    }

    public static int zzfg(String str) {
        Integer num = (Integer) bj.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 44).append("[").append(str).append("] is not a valid global search section name").toString());
    }
}
