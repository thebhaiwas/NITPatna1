package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public final class Status extends AbstractSafeParcelable implements Result {
    public static final Creator<Status> CREATOR;
    public static final Status sg;
    public static final Status sh;
    public static final Status si;
    public static final Status sj;
    public static final Status sk;
    public static final Status sl;
    public static final Status sm;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int ob;
    private final String qS;

    static {
        sg = new Status(0);
        sh = new Status(14);
        si = new Status(8);
        sj = new Status(15);
        sk = new Status(16);
        sl = new Status(17);
        sm = new Status(18);
        CREATOR = new zzf();
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.ob = i2;
        this.qS = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzaoj() {
        return this.qS != null ? this.qS : CommonStatusCodes.getStatusCodeString(this.ob);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.ob == status.ob && zzaa.equal(this.qS, status.qS) && zzaa.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.ob;
    }

    @Nullable
    public String getStatusMessage() {
        return this.qS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.ob), this.qS, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.ob == 16;
    }

    public boolean isInterrupted() {
        return this.ob == 14;
    }

    public boolean isSuccess() {
        return this.ob <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzaa.zzz(this).zzg("statusCode", zzaoj()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    PendingIntent zzaoi() {
        return this.mPendingIntent;
    }
}
