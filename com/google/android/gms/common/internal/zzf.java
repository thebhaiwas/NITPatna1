package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzf {
    public static final zzf xC;
    public static final zzf xD;
    public static final zzf xE;
    public static final zzf xF;
    public static final zzf xG;
    public static final zzf xH;
    public static final zzf xI;
    public static final zzf xJ;
    public static final zzf xK;
    public static final zzf xL;
    public static final zzf xM;
    public static final zzf xN;
    public static final zzf xO;
    public static final zzf xP;
    public static final zzf xQ;

    /* renamed from: com.google.android.gms.common.internal.zzf.11 */
    class AnonymousClass11 extends zzf {
        final /* synthetic */ char xW;

        AnonymousClass11(char c) {
            this.xW = c;
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            return com_google_android_gms_common_internal_zzf.zzd(this.xW) ? com_google_android_gms_common_internal_zzf : super.zza(com_google_android_gms_common_internal_zzf);
        }

        public boolean zzd(char c) {
            return c == this.xW;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.1 */
    class C04261 extends zzf {
        C04261() {
        }

        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.2 */
    class C04272 extends zzf {
        final /* synthetic */ char xR;
        final /* synthetic */ char xS;

        C04272(char c, char c2) {
            this.xR = c;
            this.xS = c2;
        }

        public boolean zzd(char c) {
            return c == this.xR || c == this.xS;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.3 */
    class C04283 extends zzf {
        final /* synthetic */ char[] xT;

        C04283(char[] cArr) {
            this.xT = cArr;
        }

        public boolean zzd(char c) {
            return Arrays.binarySearch(this.xT, c) >= 0;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.4 */
    class C04294 extends zzf {
        final /* synthetic */ char xU;
        final /* synthetic */ char xV;

        C04294(char c, char c2) {
            this.xU = c;
            this.xV = c2;
        }

        public boolean zzd(char c) {
            return this.xU <= c && c <= this.xV;
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.5 */
    class C04305 extends zzf {
        C04305() {
        }

        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.6 */
    class C04316 extends zzf {
        C04316() {
        }

        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.7 */
    class C04327 extends zzf {
        C04327() {
        }

        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.8 */
    class C04338 extends zzf {
        C04338() {
        }

        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.zzf.9 */
    class C04349 extends zzf {
        C04349() {
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            zzab.zzaa(com_google_android_gms_common_internal_zzf);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzab.zzaa(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    }

    private static class zza extends zzf {
        List<zzf> xX;

        zza(List<zzf> list) {
            this.xX = list;
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            List arrayList = new ArrayList(this.xX);
            arrayList.add((zzf) zzab.zzaa(com_google_android_gms_common_internal_zzf));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zzf zzd : this.xX) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        xC = zza((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000\u00a0\u180e\u202f").zza(zza('\u2000', '\u200a'));
        xD = zza((CharSequence) "\t\n\u000b\f\r \u0085\u1680\u2028\u2029\u205f\u3000").zza(zza('\u2000', '\u2006')).zza(zza('\u2008', '\u200a'));
        xE = zza('\u0000', '\u007f');
        zzf zza = zza('0', '9');
        zzf com_google_android_gms_common_internal_zzf = zza;
        for (char c : "\u0660\u06f0\u07c0\u0966\u09e6\u0a66\u0ae6\u0b66\u0be6\u0c66\u0ce6\u0d66\u0e50\u0ed0\u0f20\u1040\u1090\u17e0\u1810\u1946\u19d0\u1b50\u1bb0\u1c40\u1c50\ua620\ua8d0\ua900\uaa50\uff10".toCharArray()) {
            com_google_android_gms_common_internal_zzf = com_google_android_gms_common_internal_zzf.zza(zza(c, (char) (c + 9)));
        }
        xF = com_google_android_gms_common_internal_zzf;
        xG = zza('\t', '\r').zza(zza('\u001c', ' ')).zza(zzc('\u1680')).zza(zzc('\u180e')).zza(zza('\u2000', '\u2006')).zza(zza('\u2008', '\u200b')).zza(zza('\u2028', '\u2029')).zza(zzc('\u205f')).zza(zzc('\u3000'));
        xH = new C04261();
        xI = new C04305();
        xJ = new C04316();
        xK = new C04327();
        xL = new C04338();
        xM = zza('\u0000', '\u001f').zza(zza('\u007f', '\u009f'));
        xN = zza('\u0000', ' ').zza(zza('\u007f', '\u00a0')).zza(zzc('\u00ad')).zza(zza('\u0600', '\u0603')).zza(zza((CharSequence) "\u06dd\u070f\u1680\u17b4\u17b5\u180e")).zza(zza('\u2000', '\u200f')).zza(zza('\u2028', '\u202f')).zza(zza('\u205f', '\u2064')).zza(zza('\u206a', '\u206f')).zza(zzc('\u3000')).zza(zza('\ud800', '\uf8ff')).zza(zza((CharSequence) "\ufeff\ufff9\ufffa\ufffb"));
        xO = zza('\u0000', '\u04f9').zza(zzc('\u05be')).zza(zza('\u05d0', '\u05ea')).zza(zzc('\u05f3')).zza(zzc('\u05f4')).zza(zza('\u0600', '\u06ff')).zza(zza('\u0750', '\u077f')).zza(zza('\u0e00', '\u0e7f')).zza(zza('\u1e00', '\u20af')).zza(zza('\u2100', '\u213a')).zza(zza('\ufb50', '\ufdff')).zza(zza('\ufe70', '\ufeff')).zza(zza('\uff61', '\uffdc'));
        xP = new C04349();
        xQ = new zzf() {
            public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
                return (zzf) zzab.zzaa(com_google_android_gms_common_internal_zzf);
            }

            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            public boolean zzd(char c) {
                return false;
            }
        };
    }

    public static zzf zza(char c, char c2) {
        zzab.zzbn(c2 >= c);
        return new C04294(c, c2);
    }

    public static zzf zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case ConnectionResult.SUCCESS /*0*/:
                return xQ;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return zzc(charSequence.charAt(0));
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return new C04272(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new C04283(toCharArray);
        }
    }

    public static zzf zzc(char c) {
        return new AnonymousClass11(c);
    }

    public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
        return new zza(Arrays.asList(new zzf[]{this, (zzf) zzab.zzaa(com_google_android_gms_common_internal_zzf)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
