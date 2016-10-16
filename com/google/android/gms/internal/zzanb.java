package com.google.android.gms.internal;

import java.util.Map.Entry;
import java.util.Set;

public final class zzanb extends zzamy {
    private final zzanw<String, zzamy> bet;

    public zzanb() {
        this.bet = new zzanw();
    }

    public Set<Entry<String, zzamy>> entrySet() {
        return this.bet.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof zzanb) && ((zzanb) obj).bet.equals(this.bet));
    }

    public boolean has(String str) {
        return this.bet.containsKey(str);
    }

    public int hashCode() {
        return this.bet.hashCode();
    }

    public void zza(String str, zzamy com_google_android_gms_internal_zzamy) {
        Object obj;
        if (com_google_android_gms_internal_zzamy == null) {
            obj = zzana.bes;
        }
        this.bet.put(str, obj);
    }

    public zzamy zzsx(String str) {
        return (zzamy) this.bet.get(str);
    }
}
