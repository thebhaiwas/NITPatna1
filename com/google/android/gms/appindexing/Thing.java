package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;

public class Thing {
    final Bundle bL;

    public static class Builder {
        final Bundle bM;

        public Builder() {
            this.bM = new Bundle();
        }

        public Thing build() {
            return new Thing(this.bM);
        }

        public Builder put(String str, Thing thing) {
            zzab.zzaa(str);
            if (thing != null) {
                this.bM.putParcelable(str, thing.bL);
            }
            return this;
        }

        public Builder put(String str, String str2) {
            zzab.zzaa(str);
            if (str2 != null) {
                this.bM.putString(str, str2);
            }
            return this;
        }

        public Builder put(String str, boolean z) {
            zzab.zzaa(str);
            this.bM.putBoolean(str, z);
            return this;
        }

        public Builder put(String str, Thing[] thingArr) {
            zzab.zzaa(str);
            if (thingArr != null) {
                ArrayList arrayList = new ArrayList();
                for (Thing thing : thingArr) {
                    if (thing != null) {
                        arrayList.add(thing.bL);
                    }
                }
                this.bM.putParcelableArray(str, (Parcelable[]) arrayList.toArray(new Bundle[arrayList.size()]));
            }
            return this;
        }

        public Builder put(String str, String[] strArr) {
            zzab.zzaa(str);
            if (strArr != null) {
                this.bM.putStringArray(str, strArr);
            }
            return this;
        }

        public Builder setDescription(String str) {
            put("description", str);
            return this;
        }

        public Builder setId(String str) {
            if (str != null) {
                put("id", str);
            }
            return this;
        }

        public Builder setName(String str) {
            zzab.zzaa(str);
            put("name", str);
            return this;
        }

        public Builder setType(String str) {
            put("type", str);
            return this;
        }

        public Builder setUrl(Uri uri) {
            zzab.zzaa(uri);
            put("url", uri.toString());
            return this;
        }
    }

    Thing(Bundle bundle) {
        this.bL = bundle;
    }

    public Bundle zzaet() {
        return this.bL;
    }
}
