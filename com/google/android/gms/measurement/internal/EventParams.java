package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final zzj CREATOR;
    private final Bundle akc;
    public final int versionCode;

    /* renamed from: com.google.android.gms.measurement.internal.EventParams.1 */
    class C02561 implements Iterator<String> {
        Iterator<String> akd;
        final /* synthetic */ EventParams ake;

        C02561(EventParams eventParams) {
            this.ake = eventParams;
            this.akd = this.ake.akc.keySet().iterator();
        }

        public boolean hasNext() {
            return this.akd.hasNext();
        }

        public String next() {
            return (String) this.akd.next();
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    static {
        CREATOR = new zzj();
    }

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.akc = bundle;
    }

    EventParams(Bundle bundle) {
        zzab.zzaa(bundle);
        this.akc = bundle;
        this.versionCode = 1;
    }

    Object get(String str) {
        return this.akc.get(str);
    }

    public Iterator<String> iterator() {
        return new C02561(this);
    }

    public int size() {
        return this.akc.size();
    }

    public String toString() {
        return this.akc.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public Bundle zzbto() {
        return new Bundle(this.akc);
    }
}
