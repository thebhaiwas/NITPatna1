package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzun.zza;
import com.google.android.gms.internal.zzun.zzb;
import com.google.android.gms.internal.zzun.zze;
import com.google.android.gms.internal.zzup;
import com.google.android.gms.internal.zzup.zzf;
import com.google.android.gms.internal.zzup.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.zzd;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class zzc extends zzaa {
    zzc(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private Boolean zza(zzb com_google_android_gms_internal_zzun_zzb, zzup.zzb com_google_android_gms_internal_zzup_zzb, long j) {
        Boolean zzbj;
        if (com_google_android_gms_internal_zzun_zzb.aoe != null) {
            zzbj = new zzs(com_google_android_gms_internal_zzun_zzb.aoe).zzbj(j);
            if (zzbj == null) {
                return null;
            }
            if (!zzbj.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (com.google.android.gms.internal.zzun.zzc com_google_android_gms_internal_zzun_zzc : com_google_android_gms_internal_zzun_zzb.aoc) {
            if (TextUtils.isEmpty(com_google_android_gms_internal_zzun_zzc.aoj)) {
                zzbsz().zzbtt().zzj("null or empty param name in filter. event", com_google_android_gms_internal_zzup_zzb.name);
                return null;
            }
            hashSet.add(com_google_android_gms_internal_zzun_zzc.aoj);
        }
        Map arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.zzup.zzc com_google_android_gms_internal_zzup_zzc : com_google_android_gms_internal_zzup_zzb.aoK) {
            if (hashSet.contains(com_google_android_gms_internal_zzup_zzc.name)) {
                if (com_google_android_gms_internal_zzup_zzc.aoO != null) {
                    arrayMap.put(com_google_android_gms_internal_zzup_zzc.name, com_google_android_gms_internal_zzup_zzc.aoO);
                } else if (com_google_android_gms_internal_zzup_zzc.anT != null) {
                    arrayMap.put(com_google_android_gms_internal_zzup_zzc.name, com_google_android_gms_internal_zzup_zzc.anT);
                } else if (com_google_android_gms_internal_zzup_zzc.zr != null) {
                    arrayMap.put(com_google_android_gms_internal_zzup_zzc.name, com_google_android_gms_internal_zzup_zzc.zr);
                } else {
                    zzbsz().zzbtt().zze("Unknown value for param. event, param", com_google_android_gms_internal_zzup_zzb.name, com_google_android_gms_internal_zzup_zzc.name);
                    return null;
                }
            }
        }
        for (com.google.android.gms.internal.zzun.zzc com_google_android_gms_internal_zzun_zzc2 : com_google_android_gms_internal_zzun_zzb.aoc) {
            boolean equals = Boolean.TRUE.equals(com_google_android_gms_internal_zzun_zzc2.aoi);
            CharSequence charSequence = com_google_android_gms_internal_zzun_zzc2.aoj;
            if (TextUtils.isEmpty(charSequence)) {
                zzbsz().zzbtt().zzj("Event has empty param name. event", com_google_android_gms_internal_zzup_zzb.name);
                return null;
            }
            Object obj = arrayMap.get(charSequence);
            if (obj instanceof Long) {
                if (com_google_android_gms_internal_zzun_zzc2.aoh == null) {
                    zzbsz().zzbtt().zze("No number filter for long param. event, param", com_google_android_gms_internal_zzup_zzb.name, charSequence);
                    return null;
                }
                zzbj = new zzs(com_google_android_gms_internal_zzun_zzc2.aoh).zzbj(((Long) obj).longValue());
                if (zzbj == null) {
                    return null;
                }
                if (((!zzbj.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (com_google_android_gms_internal_zzun_zzc2.aoh == null) {
                    zzbsz().zzbtt().zze("No number filter for double param. event, param", com_google_android_gms_internal_zzup_zzb.name, charSequence);
                    return null;
                }
                zzbj = new zzs(com_google_android_gms_internal_zzun_zzc2.aoh).zzj(((Double) obj).doubleValue());
                if (zzbj == null) {
                    return null;
                }
                if (((!zzbj.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (com_google_android_gms_internal_zzun_zzc2.aog == null) {
                    zzbsz().zzbtt().zze("No string filter for String param. event, param", com_google_android_gms_internal_zzup_zzb.name, charSequence);
                    return null;
                }
                zzbj = new zzag(com_google_android_gms_internal_zzun_zzc2.aog).zzmj((String) obj);
                if (zzbj == null) {
                    return null;
                }
                if (((!zzbj.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                zzbsz().zzbty().zze("Missing param for filter. event, param", com_google_android_gms_internal_zzup_zzb.name, charSequence);
                return Boolean.valueOf(false);
            } else {
                zzbsz().zzbtt().zze("Unknown param type. event, param", com_google_android_gms_internal_zzup_zzb.name, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean zza(zze com_google_android_gms_internal_zzun_zze, zzg com_google_android_gms_internal_zzup_zzg) {
        Boolean bool = null;
        com.google.android.gms.internal.zzun.zzc com_google_android_gms_internal_zzun_zzc = com_google_android_gms_internal_zzun_zze.aor;
        if (com_google_android_gms_internal_zzun_zzc == null) {
            zzbsz().zzbtt().zzj("Missing property filter. property", com_google_android_gms_internal_zzup_zzg.name);
            return bool;
        }
        boolean equals = Boolean.TRUE.equals(com_google_android_gms_internal_zzun_zzc.aoi);
        if (com_google_android_gms_internal_zzup_zzg.aoO != null) {
            if (com_google_android_gms_internal_zzun_zzc.aoh != null) {
                return zza(new zzs(com_google_android_gms_internal_zzun_zzc.aoh).zzbj(com_google_android_gms_internal_zzup_zzg.aoO.longValue()), equals);
            }
            zzbsz().zzbtt().zzj("No number filter for long property. property", com_google_android_gms_internal_zzup_zzg.name);
            return bool;
        } else if (com_google_android_gms_internal_zzup_zzg.anT != null) {
            if (com_google_android_gms_internal_zzun_zzc.aoh != null) {
                return zza(new zzs(com_google_android_gms_internal_zzun_zzc.aoh).zzj(com_google_android_gms_internal_zzup_zzg.anT.doubleValue()), equals);
            }
            zzbsz().zzbtt().zzj("No number filter for double property. property", com_google_android_gms_internal_zzup_zzg.name);
            return bool;
        } else if (com_google_android_gms_internal_zzup_zzg.zr == null) {
            zzbsz().zzbtt().zzj("User property has no value, property", com_google_android_gms_internal_zzup_zzg.name);
            return bool;
        } else if (com_google_android_gms_internal_zzun_zzc.aog != null) {
            return zza(new zzag(com_google_android_gms_internal_zzun_zzc.aog).zzmj(com_google_android_gms_internal_zzup_zzg.zr), equals);
        } else {
            if (com_google_android_gms_internal_zzun_zzc.aoh == null) {
                zzbsz().zzbtt().zzj("No string or number filter defined. property", com_google_android_gms_internal_zzup_zzg.name);
                return bool;
            }
            zzs com_google_android_gms_measurement_internal_zzs = new zzs(com_google_android_gms_internal_zzun_zzc.aoh);
            if (com_google_android_gms_internal_zzun_zzc.aoh.aol == null || !com_google_android_gms_internal_zzun_zzc.aoh.aol.booleanValue()) {
                if (zzle(com_google_android_gms_internal_zzup_zzg.zr)) {
                    try {
                        return zza(com_google_android_gms_measurement_internal_zzs.zzbj(Long.parseLong(com_google_android_gms_internal_zzup_zzg.zr)), equals);
                    } catch (NumberFormatException e) {
                        zzbsz().zzbtt().zze("User property value exceeded Long value range. property, value", com_google_android_gms_internal_zzup_zzg.name, com_google_android_gms_internal_zzup_zzg.zr);
                        return bool;
                    }
                }
                zzbsz().zzbtt().zze("Invalid user property value for Long number filter. property, value", com_google_android_gms_internal_zzup_zzg.name, com_google_android_gms_internal_zzup_zzg.zr);
                return bool;
            } else if (zzlf(com_google_android_gms_internal_zzup_zzg.zr)) {
                try {
                    double parseDouble = Double.parseDouble(com_google_android_gms_internal_zzup_zzg.zr);
                    if (!Double.isInfinite(parseDouble)) {
                        return zza(com_google_android_gms_measurement_internal_zzs.zzj(parseDouble), equals);
                    }
                    zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", com_google_android_gms_internal_zzup_zzg.name, com_google_android_gms_internal_zzup_zzg.zr);
                    return bool;
                } catch (NumberFormatException e2) {
                    zzbsz().zzbtt().zze("User property value exceeded Double value range. property, value", com_google_android_gms_internal_zzup_zzg.name, com_google_android_gms_internal_zzup_zzg.zr);
                    return bool;
                }
            } else {
                zzbsz().zzbtt().zze("Invalid user property value for Double number filter. property, value", com_google_android_gms_internal_zzup_zzg.name, com_google_android_gms_internal_zzup_zzg.zr);
                return bool;
            }
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @WorkerThread
    void zza(String str, zza[] com_google_android_gms_internal_zzun_zzaArr) {
        zzab.zzaa(com_google_android_gms_internal_zzun_zzaArr);
        for (zza com_google_android_gms_internal_zzun_zza : com_google_android_gms_internal_zzun_zzaArr) {
            for (zzb com_google_android_gms_internal_zzun_zzb : com_google_android_gms_internal_zzun_zza.anY) {
                String str2 = (String) AppMeasurement.zza.ajb.get(com_google_android_gms_internal_zzun_zzb.aob);
                if (str2 != null) {
                    com_google_android_gms_internal_zzun_zzb.aob = str2;
                }
                for (com.google.android.gms.internal.zzun.zzc com_google_android_gms_internal_zzun_zzc : com_google_android_gms_internal_zzun_zzb.aoc) {
                    str2 = (String) zzd.ajc.get(com_google_android_gms_internal_zzun_zzc.aoj);
                    if (str2 != null) {
                        com_google_android_gms_internal_zzun_zzc.aoj = str2;
                    }
                }
            }
            for (zze com_google_android_gms_internal_zzun_zze : com_google_android_gms_internal_zzun_zza.anX) {
                str2 = (String) AppMeasurement.zze.ajd.get(com_google_android_gms_internal_zzun_zze.aoq);
                if (str2 != null) {
                    com_google_android_gms_internal_zzun_zze.aoq = str2;
                }
            }
        }
        zzbsu().zzb(str, com_google_android_gms_internal_zzun_zzaArr);
    }

    @WorkerThread
    zzup.zza[] zza(String str, zzup.zzb[] com_google_android_gms_internal_zzup_zzbArr, zzg[] com_google_android_gms_internal_zzup_zzgArr) {
        int intValue;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        Boolean zza;
        Object obj;
        zzab.zzhs(str);
        Set hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map zzls = zzbsu().zzls(str);
        if (zzls != null) {
            for (Integer intValue2 : zzls.keySet()) {
                intValue = intValue2.intValue();
                zzf com_google_android_gms_internal_zzup_zzf = (zzf) zzls.get(Integer.valueOf(intValue));
                bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < com_google_android_gms_internal_zzup_zzf.apq.length * 64; i++) {
                    if (zzal.zza(com_google_android_gms_internal_zzup_zzf.apq, i)) {
                        zzbsz().zzbty().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzal.zza(com_google_android_gms_internal_zzup_zzf.apr, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzup.zza com_google_android_gms_internal_zzup_zza = new zzup.zza();
                arrayMap.put(Integer.valueOf(intValue), com_google_android_gms_internal_zzup_zza);
                com_google_android_gms_internal_zzup_zza.aoI = Boolean.valueOf(false);
                com_google_android_gms_internal_zzup_zza.aoH = com_google_android_gms_internal_zzup_zzf;
                com_google_android_gms_internal_zzup_zza.aoG = new zzf();
                com_google_android_gms_internal_zzup_zza.aoG.apr = zzal.zza(bitSet);
                com_google_android_gms_internal_zzup_zza.aoG.apq = zzal.zza(bitSet2);
            }
        }
        if (com_google_android_gms_internal_zzup_zzbArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            for (zzup.zzb com_google_android_gms_internal_zzup_zzb : com_google_android_gms_internal_zzup_zzbArr) {
                zzi com_google_android_gms_measurement_internal_zzi;
                zzi zzaq = zzbsu().zzaq(str, com_google_android_gms_internal_zzup_zzb.name);
                if (zzaq == null) {
                    zzbsz().zzbtt().zzj("Event aggregate wasn't created during raw event logging. event", com_google_android_gms_internal_zzup_zzb.name);
                    com_google_android_gms_measurement_internal_zzi = new zzi(str, com_google_android_gms_internal_zzup_zzb.name, 1, 1, com_google_android_gms_internal_zzup_zzb.aoL.longValue());
                } else {
                    com_google_android_gms_measurement_internal_zzi = zzaq.zzbtn();
                }
                zzbsu().zza(com_google_android_gms_measurement_internal_zzi);
                long j = com_google_android_gms_measurement_internal_zzi.ajZ;
                map = (Map) arrayMap4.get(com_google_android_gms_internal_zzup_zzb.name);
                if (map == null) {
                    map = zzbsu().zzat(str, com_google_android_gms_internal_zzup_zzb.name);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap4.put(com_google_android_gms_internal_zzup_zzb.name, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                zzbsz().zzbty().zze("event, affected audience count", com_google_android_gms_internal_zzup_zzb.name, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue3));
                        if (((zzup.zza) arrayMap.get(Integer.valueOf(intValue3))) == null) {
                            zzup.zza com_google_android_gms_internal_zzup_zza2 = new zzup.zza();
                            arrayMap.put(Integer.valueOf(intValue3), com_google_android_gms_internal_zzup_zza2);
                            com_google_android_gms_internal_zzup_zza2.aoI = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (zzb com_google_android_gms_internal_zzun_zzb : (List) map2.get(Integer.valueOf(intValue3))) {
                            if (zzbsz().zzaz(2)) {
                                zzbsz().zzbty().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), com_google_android_gms_internal_zzun_zzb.aoa, com_google_android_gms_internal_zzun_zzb.aob);
                                zzbsz().zzbty().zzj("Filter definition", zzal.zza(com_google_android_gms_internal_zzun_zzb));
                            }
                            if (com_google_android_gms_internal_zzun_zzb.aoa == null || com_google_android_gms_internal_zzun_zzb.aoa.intValue() > AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                                zzbsz().zzbtt().zzj("Invalid event filter ID. id", String.valueOf(com_google_android_gms_internal_zzun_zzb.aoa));
                            } else if (bitSet.get(com_google_android_gms_internal_zzun_zzb.aoa.intValue())) {
                                zzbsz().zzbty().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), com_google_android_gms_internal_zzun_zzb.aoa);
                            } else {
                                zza = zza(com_google_android_gms_internal_zzun_zzb, com_google_android_gms_internal_zzup_zzb, j);
                                zzp.zza zzbty = zzbsz().zzbty();
                                String str2 = "Event filter result";
                                if (zza == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = zza;
                                }
                                zzbty.zzj(str2, obj);
                                if (zza == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(com_google_android_gms_internal_zzun_zzb.aoa.intValue());
                                    if (zza.booleanValue()) {
                                        bitSet.set(com_google_android_gms_internal_zzun_zzb.aoa.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (com_google_android_gms_internal_zzup_zzgArr != null) {
            Map arrayMap5 = new ArrayMap();
            for (zzg com_google_android_gms_internal_zzup_zzg : com_google_android_gms_internal_zzup_zzgArr) {
                map = (Map) arrayMap5.get(com_google_android_gms_internal_zzup_zzg.name);
                if (map == null) {
                    map = zzbsu().zzau(str, com_google_android_gms_internal_zzup_zzg.name);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap5.put(com_google_android_gms_internal_zzup_zzg.name, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                zzbsz().zzbty().zze("property, affected audience count", com_google_android_gms_internal_zzup_zzg.name, Integer.valueOf(map2.size()));
                for (Integer intValue222 : map2.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzbsz().zzbty().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (((zzup.zza) arrayMap.get(Integer.valueOf(intValue4))) == null) {
                            com_google_android_gms_internal_zzup_zza2 = new zzup.zza();
                            arrayMap.put(Integer.valueOf(intValue4), com_google_android_gms_internal_zzup_zza2);
                            com_google_android_gms_internal_zzup_zza2.aoI = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (zze com_google_android_gms_internal_zzun_zze : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzbsz().zzaz(2)) {
                                zzbsz().zzbty().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), com_google_android_gms_internal_zzun_zze.aoa, com_google_android_gms_internal_zzun_zze.aoq);
                                zzbsz().zzbty().zzj("Filter definition", zzal.zza(com_google_android_gms_internal_zzun_zze));
                            }
                            if (com_google_android_gms_internal_zzun_zze.aoa == null || com_google_android_gms_internal_zzun_zze.aoa.intValue() > AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY) {
                                zzbsz().zzbtt().zzj("Invalid property filter ID. id", String.valueOf(com_google_android_gms_internal_zzun_zze.aoa));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(com_google_android_gms_internal_zzun_zze.aoa.intValue())) {
                                zzbsz().zzbty().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), com_google_android_gms_internal_zzun_zze.aoa);
                            } else {
                                zza = zza(com_google_android_gms_internal_zzun_zze, com_google_android_gms_internal_zzup_zzg);
                                zzp.zza zzbty2 = zzbsz().zzbty();
                                String str3 = "Property filter result";
                                if (zza == null) {
                                    obj = "null";
                                } else {
                                    bool = zza;
                                }
                                zzbty2.zzj(str3, obj);
                                if (zza == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(com_google_android_gms_internal_zzun_zze.aoa.intValue());
                                    if (zza.booleanValue()) {
                                        bitSet.set(com_google_android_gms_internal_zzun_zze.aoa.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zzup.zza[] com_google_android_gms_internal_zzup_zzaArr = new zzup.zza[arrayMap2.size()];
        int i2 = 0;
        for (Integer intValue2222 : arrayMap2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                com_google_android_gms_internal_zzup_zza2 = (zzup.zza) arrayMap.get(Integer.valueOf(intValue));
                com_google_android_gms_internal_zzup_zza = com_google_android_gms_internal_zzup_zza2 == null ? new zzup.zza() : com_google_android_gms_internal_zzup_zza2;
                int i3 = i2 + 1;
                com_google_android_gms_internal_zzup_zzaArr[i2] = com_google_android_gms_internal_zzup_zza;
                com_google_android_gms_internal_zzup_zza.anW = Integer.valueOf(intValue);
                com_google_android_gms_internal_zzup_zza.aoG = new zzf();
                com_google_android_gms_internal_zzup_zza.aoG.apr = zzal.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue)));
                com_google_android_gms_internal_zzup_zza.aoG.apq = zzal.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue)));
                zzbsu().zza(str, intValue, com_google_android_gms_internal_zzup_zza.aoG);
                i2 = i3;
            }
        }
        return (zzup.zza[]) Arrays.copyOf(com_google_android_gms_internal_zzup_zzaArr, i2);
    }

    boolean zzle(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    boolean zzlf(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }

    protected void zzwv() {
    }
}
