package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder xA;

    /* renamed from: com.google.android.gms.common.internal.BinderWrapper.1 */
    class C02241 implements Creator<BinderWrapper> {
        C02241() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzce(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzfz(i);
        }

        public BinderWrapper zzce(Parcel parcel) {
            return new BinderWrapper(null);
        }

        public BinderWrapper[] zzfz(int i) {
            return new BinderWrapper[i];
        }
    }

    static {
        CREATOR = new C02241();
    }

    public BinderWrapper() {
        this.xA = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.xA = null;
        this.xA = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.xA = null;
        this.xA = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.xA);
    }
}
