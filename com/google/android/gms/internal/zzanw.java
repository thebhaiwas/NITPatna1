package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzanw<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator<Comparable> bfg;
    Comparator<? super K> aQi;
    zzd<K, V> bfh;
    final zzd<K, V> bfi;
    private zza bfj;
    private zzb bfk;
    int modCount;
    int size;

    /* renamed from: com.google.android.gms.internal.zzanw.1 */
    static class C02361 implements Comparator<Comparable> {
        C02361() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((Comparable) obj, (Comparable) obj2);
        }

        public int zza(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class zza extends AbstractSet<Entry<K, V>> {
        final /* synthetic */ zzanw bfl;

        /* renamed from: com.google.android.gms.internal.zzanw.zza.1 */
        class C04631 extends zzc<Entry<K, V>> {
            final /* synthetic */ zza bfm;

            C04631(zza com_google_android_gms_internal_zzanw_zza) {
                this.bfm = com_google_android_gms_internal_zzanw_zza;
                super(null);
            }

            public Entry<K, V> next() {
                return m13c();
            }
        }

        zza(zzanw com_google_android_gms_internal_zzanw) {
            this.bfl = com_google_android_gms_internal_zzanw;
        }

        public void clear() {
            this.bfl.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Entry) && this.bfl.zzc((Entry) obj) != null;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C04631(this);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            zzd zzc = this.bfl.zzc((Entry) obj);
            if (zzc == null) {
                return false;
            }
            this.bfl.zza(zzc, true);
            return true;
        }

        public int size() {
            return this.bfl.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        final /* synthetic */ zzanw bfl;

        /* renamed from: com.google.android.gms.internal.zzanw.zzb.1 */
        class C04641 extends zzc<K> {
            final /* synthetic */ zzb bfn;

            C04641(zzb com_google_android_gms_internal_zzanw_zzb) {
                this.bfn = com_google_android_gms_internal_zzanw_zzb;
                super(null);
            }

            public K next() {
                return m13c().aQw;
            }
        }

        zzb(zzanw com_google_android_gms_internal_zzanw) {
            this.bfl = com_google_android_gms_internal_zzanw;
        }

        public void clear() {
            this.bfl.clear();
        }

        public boolean contains(Object obj) {
            return this.bfl.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new C04641(this);
        }

        public boolean remove(Object obj) {
            return this.bfl.zzcp(obj) != null;
        }

        public int size() {
            return this.bfl.size;
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        final /* synthetic */ zzanw bfl;
        zzd<K, V> bfo;
        zzd<K, V> bfp;
        int bfq;

        private zzc(zzanw com_google_android_gms_internal_zzanw) {
            this.bfl = com_google_android_gms_internal_zzanw;
            this.bfo = this.bfl.bfi.bfo;
            this.bfp = null;
            this.bfq = this.bfl.modCount;
        }

        final zzd<K, V> m13c() {
            zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V = this.bfo;
            if (com_google_android_gms_internal_zzanw_zzd_K__V == this.bfl.bfi) {
                throw new NoSuchElementException();
            } else if (this.bfl.modCount != this.bfq) {
                throw new ConcurrentModificationException();
            } else {
                this.bfo = com_google_android_gms_internal_zzanw_zzd_K__V.bfo;
                this.bfp = com_google_android_gms_internal_zzanw_zzd_K__V;
                return com_google_android_gms_internal_zzanw_zzd_K__V;
            }
        }

        public final boolean hasNext() {
            return this.bfo != this.bfl.bfi;
        }

        public final void remove() {
            if (this.bfp == null) {
                throw new IllegalStateException();
            }
            this.bfl.zza(this.bfp, true);
            this.bfp = null;
            this.bfq = this.bfl.modCount;
        }
    }

    static final class zzd<K, V> implements Entry<K, V> {
        final K aQw;
        V aQx;
        zzd<K, V> bfo;
        zzd<K, V> bfr;
        zzd<K, V> bfs;
        zzd<K, V> bft;
        zzd<K, V> bfu;
        int height;

        zzd() {
            this.aQw = null;
            this.bfu = this;
            this.bfo = this;
        }

        zzd(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V, K k, zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V2, zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V3) {
            this.bfr = com_google_android_gms_internal_zzanw_zzd_K__V;
            this.aQw = k;
            this.height = 1;
            this.bfo = com_google_android_gms_internal_zzanw_zzd_K__V2;
            this.bfu = com_google_android_gms_internal_zzanw_zzd_K__V3;
            com_google_android_gms_internal_zzanw_zzd_K__V3.bfo = this;
            com_google_android_gms_internal_zzanw_zzd_K__V2.bfu = this;
        }

        public zzd<K, V> m14d() {
            zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V;
            for (zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V2 = this.bfs; com_google_android_gms_internal_zzanw_zzd_K__V2 != null; com_google_android_gms_internal_zzanw_zzd_K__V2 = com_google_android_gms_internal_zzanw_zzd_K__V2.bfs) {
                com_google_android_gms_internal_zzanw_zzd_K__V = com_google_android_gms_internal_zzanw_zzd_K__V2;
            }
            return com_google_android_gms_internal_zzanw_zzd_K__V;
        }

        public zzd<K, V> m15e() {
            zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V;
            for (zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V2 = this.bft; com_google_android_gms_internal_zzanw_zzd_K__V2 != null; com_google_android_gms_internal_zzanw_zzd_K__V2 = com_google_android_gms_internal_zzanw_zzd_K__V2.bft) {
                com_google_android_gms_internal_zzanw_zzd_K__V = com_google_android_gms_internal_zzanw_zzd_K__V2;
            }
            return com_google_android_gms_internal_zzanw_zzd_K__V;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (this.aQw == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!this.aQw.equals(entry.getKey())) {
                return false;
            }
            if (this.aQx == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!this.aQx.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.aQw;
        }

        public V getValue() {
            return this.aQx;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.aQw == null ? 0 : this.aQw.hashCode();
            if (this.aQx != null) {
                i = this.aQx.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.aQx;
            this.aQx = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.aQw);
            String valueOf2 = String.valueOf(this.aQx);
            return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        }
    }

    static {
        $assertionsDisabled = !zzanw.class.desiredAssertionStatus();
        bfg = new C02361();
    }

    public zzanw() {
        this(bfg);
    }

    public zzanw(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.size = 0;
        this.modCount = 0;
        this.bfi = new zzd();
        if (comparator == null) {
            comparator2 = bfg;
        }
        this.aQi = comparator2;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V) {
        int i = 0;
        zzd com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd_K__V.bfs;
        zzd com_google_android_gms_internal_zzanw_zzd2 = com_google_android_gms_internal_zzanw_zzd_K__V.bft;
        zzd com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd2.bfs;
        zzd com_google_android_gms_internal_zzanw_zzd4 = com_google_android_gms_internal_zzanw_zzd2.bft;
        com_google_android_gms_internal_zzanw_zzd_K__V.bft = com_google_android_gms_internal_zzanw_zzd3;
        if (com_google_android_gms_internal_zzanw_zzd3 != null) {
            com_google_android_gms_internal_zzanw_zzd3.bfr = com_google_android_gms_internal_zzanw_zzd_K__V;
        }
        zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, com_google_android_gms_internal_zzanw_zzd2);
        com_google_android_gms_internal_zzanw_zzd2.bfs = com_google_android_gms_internal_zzanw_zzd_K__V;
        com_google_android_gms_internal_zzanw_zzd_K__V.bfr = com_google_android_gms_internal_zzanw_zzd2;
        com_google_android_gms_internal_zzanw_zzd_K__V.height = Math.max(com_google_android_gms_internal_zzanw_zzd != null ? com_google_android_gms_internal_zzanw_zzd.height : 0, com_google_android_gms_internal_zzanw_zzd3 != null ? com_google_android_gms_internal_zzanw_zzd3.height : 0) + 1;
        int i2 = com_google_android_gms_internal_zzanw_zzd_K__V.height;
        if (com_google_android_gms_internal_zzanw_zzd4 != null) {
            i = com_google_android_gms_internal_zzanw_zzd4.height;
        }
        com_google_android_gms_internal_zzanw_zzd2.height = Math.max(i2, i) + 1;
    }

    private void zza(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V, zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V2) {
        zzd com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd_K__V.bfr;
        com_google_android_gms_internal_zzanw_zzd_K__V.bfr = null;
        if (com_google_android_gms_internal_zzanw_zzd_K__V2 != null) {
            com_google_android_gms_internal_zzanw_zzd_K__V2.bfr = com_google_android_gms_internal_zzanw_zzd;
        }
        if (com_google_android_gms_internal_zzanw_zzd == null) {
            this.bfh = com_google_android_gms_internal_zzanw_zzd_K__V2;
        } else if (com_google_android_gms_internal_zzanw_zzd.bfs == com_google_android_gms_internal_zzanw_zzd_K__V) {
            com_google_android_gms_internal_zzanw_zzd.bfs = com_google_android_gms_internal_zzanw_zzd_K__V2;
        } else if ($assertionsDisabled || com_google_android_gms_internal_zzanw_zzd.bft == com_google_android_gms_internal_zzanw_zzd_K__V) {
            com_google_android_gms_internal_zzanw_zzd.bft = com_google_android_gms_internal_zzanw_zzd_K__V2;
        } else {
            throw new AssertionError();
        }
    }

    private void zzb(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V) {
        int i = 0;
        zzd com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd_K__V.bfs;
        zzd com_google_android_gms_internal_zzanw_zzd2 = com_google_android_gms_internal_zzanw_zzd_K__V.bft;
        zzd com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd.bfs;
        zzd com_google_android_gms_internal_zzanw_zzd4 = com_google_android_gms_internal_zzanw_zzd.bft;
        com_google_android_gms_internal_zzanw_zzd_K__V.bfs = com_google_android_gms_internal_zzanw_zzd4;
        if (com_google_android_gms_internal_zzanw_zzd4 != null) {
            com_google_android_gms_internal_zzanw_zzd4.bfr = com_google_android_gms_internal_zzanw_zzd_K__V;
        }
        zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, com_google_android_gms_internal_zzanw_zzd);
        com_google_android_gms_internal_zzanw_zzd.bft = com_google_android_gms_internal_zzanw_zzd_K__V;
        com_google_android_gms_internal_zzanw_zzd_K__V.bfr = com_google_android_gms_internal_zzanw_zzd;
        com_google_android_gms_internal_zzanw_zzd_K__V.height = Math.max(com_google_android_gms_internal_zzanw_zzd2 != null ? com_google_android_gms_internal_zzanw_zzd2.height : 0, com_google_android_gms_internal_zzanw_zzd4 != null ? com_google_android_gms_internal_zzanw_zzd4.height : 0) + 1;
        int i2 = com_google_android_gms_internal_zzanw_zzd_K__V.height;
        if (com_google_android_gms_internal_zzanw_zzd3 != null) {
            i = com_google_android_gms_internal_zzanw_zzd3.height;
        }
        com_google_android_gms_internal_zzanw_zzd.height = Math.max(i2, i) + 1;
    }

    private void zzb(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V, boolean z) {
        zzd com_google_android_gms_internal_zzanw_zzd;
        while (com_google_android_gms_internal_zzanw_zzd != null) {
            zzd com_google_android_gms_internal_zzanw_zzd2 = com_google_android_gms_internal_zzanw_zzd.bfs;
            zzd com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd.bft;
            int i = com_google_android_gms_internal_zzanw_zzd2 != null ? com_google_android_gms_internal_zzanw_zzd2.height : 0;
            int i2 = com_google_android_gms_internal_zzanw_zzd3 != null ? com_google_android_gms_internal_zzanw_zzd3.height : 0;
            int i3 = i - i2;
            zzd com_google_android_gms_internal_zzanw_zzd4;
            if (i3 == -2) {
                com_google_android_gms_internal_zzanw_zzd2 = com_google_android_gms_internal_zzanw_zzd3.bfs;
                com_google_android_gms_internal_zzanw_zzd4 = com_google_android_gms_internal_zzanw_zzd3.bft;
                i2 = (com_google_android_gms_internal_zzanw_zzd2 != null ? com_google_android_gms_internal_zzanw_zzd2.height : 0) - (com_google_android_gms_internal_zzanw_zzd4 != null ? com_google_android_gms_internal_zzanw_zzd4.height : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    zza(com_google_android_gms_internal_zzanw_zzd);
                } else if ($assertionsDisabled || i2 == 1) {
                    zzb(com_google_android_gms_internal_zzanw_zzd3);
                    zza(com_google_android_gms_internal_zzanw_zzd);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd2.bfs;
                com_google_android_gms_internal_zzanw_zzd4 = com_google_android_gms_internal_zzanw_zzd2.bft;
                i2 = (com_google_android_gms_internal_zzanw_zzd3 != null ? com_google_android_gms_internal_zzanw_zzd3.height : 0) - (com_google_android_gms_internal_zzanw_zzd4 != null ? com_google_android_gms_internal_zzanw_zzd4.height : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    zzb(com_google_android_gms_internal_zzanw_zzd);
                } else if ($assertionsDisabled || i2 == -1) {
                    zza(com_google_android_gms_internal_zzanw_zzd2);
                    zzb(com_google_android_gms_internal_zzanw_zzd);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                com_google_android_gms_internal_zzanw_zzd.height = i + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                com_google_android_gms_internal_zzanw_zzd.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd.bfr;
        }
    }

    public void clear() {
        this.bfh = null;
        this.size = 0;
        this.modCount++;
        zzd com_google_android_gms_internal_zzanw_zzd = this.bfi;
        com_google_android_gms_internal_zzanw_zzd.bfu = com_google_android_gms_internal_zzanw_zzd;
        com_google_android_gms_internal_zzanw_zzd.bfo = com_google_android_gms_internal_zzanw_zzd;
    }

    public boolean containsKey(Object obj) {
        return zzco(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.bfj;
        if (set != null) {
            return set;
        }
        set = new zza(this);
        this.bfj = set;
        return set;
    }

    public V get(Object obj) {
        zzd zzco = zzco(obj);
        return zzco != null ? zzco.aQx : null;
    }

    public Set<K> keySet() {
        Set set = this.bfk;
        if (set != null) {
            return set;
        }
        set = new zzb(this);
        this.bfk = set;
        return set;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        zzd zza = zza((Object) k, true);
        V v2 = zza.aQx;
        zza.aQx = v;
        return v2;
    }

    public V remove(Object obj) {
        zzd zzcp = zzcp(obj);
        return zzcp != null ? zzcp.aQx : null;
    }

    public int size() {
        return this.size;
    }

    zzd<K, V> zza(K k, boolean z) {
        int i;
        Comparator comparator = this.aQi;
        zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V = this.bfh;
        if (com_google_android_gms_internal_zzanw_zzd_K__V != null) {
            int compareTo;
            Comparable comparable = comparator == bfg ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(com_google_android_gms_internal_zzanw_zzd_K__V.aQw) : comparator.compare(k, com_google_android_gms_internal_zzanw_zzd_K__V.aQw);
                if (compareTo == 0) {
                    return com_google_android_gms_internal_zzanw_zzd_K__V;
                }
                zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V2 = compareTo < 0 ? com_google_android_gms_internal_zzanw_zzd_K__V.bfs : com_google_android_gms_internal_zzanw_zzd_K__V.bft;
                if (com_google_android_gms_internal_zzanw_zzd_K__V2 == null) {
                    break;
                }
                com_google_android_gms_internal_zzanw_zzd_K__V = com_google_android_gms_internal_zzanw_zzd_K__V2;
            }
            int i2 = compareTo;
            zzd com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd_K__V;
            i = i2;
        } else {
            zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V3 = com_google_android_gms_internal_zzanw_zzd_K__V;
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> com_google_android_gms_internal_zzanw_zzd2;
        zzd com_google_android_gms_internal_zzanw_zzd3 = this.bfi;
        if (com_google_android_gms_internal_zzanw_zzd != null) {
            com_google_android_gms_internal_zzanw_zzd2 = new zzd(com_google_android_gms_internal_zzanw_zzd, k, com_google_android_gms_internal_zzanw_zzd3, com_google_android_gms_internal_zzanw_zzd3.bfu);
            if (i < 0) {
                com_google_android_gms_internal_zzanw_zzd.bfs = com_google_android_gms_internal_zzanw_zzd2;
            } else {
                com_google_android_gms_internal_zzanw_zzd.bft = com_google_android_gms_internal_zzanw_zzd2;
            }
            zzb(com_google_android_gms_internal_zzanw_zzd, true);
        } else if (comparator != bfg || (k instanceof Comparable)) {
            com_google_android_gms_internal_zzanw_zzd2 = new zzd(com_google_android_gms_internal_zzanw_zzd, k, com_google_android_gms_internal_zzanw_zzd3, com_google_android_gms_internal_zzanw_zzd3.bfu);
            this.bfh = com_google_android_gms_internal_zzanw_zzd2;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return com_google_android_gms_internal_zzanw_zzd2;
    }

    void zza(zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V, boolean z) {
        int i = 0;
        if (z) {
            com_google_android_gms_internal_zzanw_zzd_K__V.bfu.bfo = com_google_android_gms_internal_zzanw_zzd_K__V.bfo;
            com_google_android_gms_internal_zzanw_zzd_K__V.bfo.bfu = com_google_android_gms_internal_zzanw_zzd_K__V.bfu;
        }
        zzd com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd_K__V.bfs;
        zzd com_google_android_gms_internal_zzanw_zzd2 = com_google_android_gms_internal_zzanw_zzd_K__V.bft;
        zzd com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd_K__V.bfr;
        if (com_google_android_gms_internal_zzanw_zzd == null || com_google_android_gms_internal_zzanw_zzd2 == null) {
            if (com_google_android_gms_internal_zzanw_zzd != null) {
                zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, com_google_android_gms_internal_zzanw_zzd);
                com_google_android_gms_internal_zzanw_zzd_K__V.bfs = null;
            } else if (com_google_android_gms_internal_zzanw_zzd2 != null) {
                zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, com_google_android_gms_internal_zzanw_zzd2);
                com_google_android_gms_internal_zzanw_zzd_K__V.bft = null;
            } else {
                zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, null);
            }
            zzb(com_google_android_gms_internal_zzanw_zzd3, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        com_google_android_gms_internal_zzanw_zzd = com_google_android_gms_internal_zzanw_zzd.height > com_google_android_gms_internal_zzanw_zzd2.height ? com_google_android_gms_internal_zzanw_zzd.m15e() : com_google_android_gms_internal_zzanw_zzd2.m14d();
        zza(com_google_android_gms_internal_zzanw_zzd, false);
        com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd_K__V.bfs;
        if (com_google_android_gms_internal_zzanw_zzd3 != null) {
            i2 = com_google_android_gms_internal_zzanw_zzd3.height;
            com_google_android_gms_internal_zzanw_zzd.bfs = com_google_android_gms_internal_zzanw_zzd3;
            com_google_android_gms_internal_zzanw_zzd3.bfr = com_google_android_gms_internal_zzanw_zzd;
            com_google_android_gms_internal_zzanw_zzd_K__V.bfs = null;
        } else {
            i2 = 0;
        }
        com_google_android_gms_internal_zzanw_zzd3 = com_google_android_gms_internal_zzanw_zzd_K__V.bft;
        if (com_google_android_gms_internal_zzanw_zzd3 != null) {
            i = com_google_android_gms_internal_zzanw_zzd3.height;
            com_google_android_gms_internal_zzanw_zzd.bft = com_google_android_gms_internal_zzanw_zzd3;
            com_google_android_gms_internal_zzanw_zzd3.bfr = com_google_android_gms_internal_zzanw_zzd;
            com_google_android_gms_internal_zzanw_zzd_K__V.bft = null;
        }
        com_google_android_gms_internal_zzanw_zzd.height = Math.max(i2, i) + 1;
        zza((zzd) com_google_android_gms_internal_zzanw_zzd_K__V, com_google_android_gms_internal_zzanw_zzd);
    }

    zzd<K, V> zzc(Entry<?, ?> entry) {
        zzd<K, V> zzco = zzco(entry.getKey());
        Object obj = (zzco == null || !equal(zzco.aQx, entry.getValue())) ? null : 1;
        return obj != null ? zzco : null;
    }

    zzd<K, V> zzco(Object obj) {
        zzd<K, V> com_google_android_gms_internal_zzanw_zzd_K__V = null;
        if (obj != null) {
            try {
                com_google_android_gms_internal_zzanw_zzd_K__V = zza(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return com_google_android_gms_internal_zzanw_zzd_K__V;
    }

    zzd<K, V> zzcp(Object obj) {
        zzd zzco = zzco(obj);
        if (zzco != null) {
            zza(zzco, true);
        }
        return zzco;
    }
}
