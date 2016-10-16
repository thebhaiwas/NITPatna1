package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import xyz.purush.nitp.nitpatna.BuildConfig;

public final class zzamt {
    private final List<zzanl> bea;
    private zzant bek;
    private zzani bel;
    private zzamr bem;
    private final Map<Type, zzamu<?>> ben;
    private final List<zzanl> beo;
    private int bep;
    private int beq;
    private boolean ber;

    public zzamt() {
        this.bek = zzant.beU;
        this.bel = zzani.DEFAULT;
        this.bem = zzamq.IDENTITY;
        this.ben = new HashMap();
        this.bea = new ArrayList();
        this.beo = new ArrayList();
        this.bep = 2;
        this.beq = 2;
        this.ber = true;
    }

    private void zza(String str, int i, int i2, List<zzanl> list) {
        Object com_google_android_gms_internal_zzamn;
        if (str != null && !BuildConfig.FLAVOR.equals(str.trim())) {
            com_google_android_gms_internal_zzamn = new zzamn(str);
        } else if (i != 2 && i2 != 2) {
            com_google_android_gms_internal_zzamn = new zzamn(i, i2);
        } else {
            return;
        }
        list.add(zzanj.zza(zzaoo.zzr(Date.class), com_google_android_gms_internal_zzamn));
        list.add(zzanj.zza(zzaoo.zzr(Timestamp.class), com_google_android_gms_internal_zzamn));
        list.add(zzanj.zza(zzaoo.zzr(java.sql.Date.class), com_google_android_gms_internal_zzamn));
    }

    public zzamt zza(Type type, Object obj) {
        boolean z = (obj instanceof zzang) || (obj instanceof zzamx) || (obj instanceof zzamu) || (obj instanceof zzank);
        zzanq.zzbn(z);
        if (obj instanceof zzamu) {
            this.ben.put(type, (zzamu) obj);
        }
        if ((obj instanceof zzang) || (obj instanceof zzamx)) {
            this.bea.add(zzanj.zzb(zzaoo.zzl(type), obj));
        }
        if (obj instanceof zzank) {
            this.bea.add(zzaon.zza(zzaoo.zzl(type), (zzank) obj));
        }
        return this;
    }

    public zzamt zza(zzamo... com_google_android_gms_internal_zzamoArr) {
        for (zzamo zza : com_google_android_gms_internal_zzamoArr) {
            this.bek = this.bek.zza(zza, true, true);
        }
        return this;
    }

    public zzamt zzcze() {
        this.ber = false;
        return this;
    }

    public zzams zzczf() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.bea);
        Collections.reverse(arrayList);
        arrayList.addAll(this.beo);
        zza(null, this.bep, this.beq, arrayList);
        return new zzams(this.bek, this.bem, this.ben, false, false, false, this.ber, false, false, this.bel, arrayList);
    }

    public zzamt zzd(int... iArr) {
        this.bek = this.bek.zze(iArr);
        return this;
    }
}
