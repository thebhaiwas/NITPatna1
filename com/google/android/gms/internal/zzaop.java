package com.google.android.gms.internal;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.ConnectionResult;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import xyz.purush.nitp.nitpatna.C0337R;

public class zzaop implements Closeable {
    private static final char[] bhm;
    private int aYn;
    private boolean bhn;
    private final char[] bho;
    private int bhp;
    private int bhq;
    private int bhr;
    private long bhs;
    private int bht;
    private String bhu;
    private int[] bhv;
    private int bhw;
    private String[] bhx;
    private int[] bhy;
    private final Reader in;
    private int pos;

    /* renamed from: com.google.android.gms.internal.zzaop.1 */
    static class C04851 extends zzanu {
        C04851() {
        }

        public void zzi(zzaop com_google_android_gms_internal_zzaop) throws IOException {
            if (com_google_android_gms_internal_zzaop instanceof zzaof) {
                ((zzaof) com_google_android_gms_internal_zzaop).m78k();
                return;
            }
            int zzag = com_google_android_gms_internal_zzaop.bhr;
            if (zzag == 0) {
                zzag = com_google_android_gms_internal_zzaop.m23u();
            }
            if (zzag == 13) {
                com_google_android_gms_internal_zzaop.bhr = 9;
            } else if (zzag == 12) {
                com_google_android_gms_internal_zzaop.bhr = 8;
            } else if (zzag == 14) {
                com_google_android_gms_internal_zzaop.bhr = 10;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzaop.m29h());
                int zzai = com_google_android_gms_internal_zzaop.getLineNumber();
                int zzaj = com_google_android_gms_internal_zzaop.getColumnNumber();
                String path = com_google_android_gms_internal_zzaop.getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(zzai).append(" column ").append(zzaj).append(" path ").append(path).toString());
            }
        }
    }

    static {
        bhm = ")]}'\n".toCharArray();
        zzanu.bff = new C04851();
    }

    public zzaop(Reader reader) {
        this.bhn = false;
        this.bho = new char[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
        this.pos = 0;
        this.aYn = 0;
        this.bhp = 0;
        this.bhq = 0;
        this.bhr = 0;
        this.bhv = new int[32];
        this.bhw = 0;
        int[] iArr = this.bhv;
        int i = this.bhw;
        this.bhw = i + 1;
        iArr[i] = 6;
        this.bhx = new String[32];
        this.bhy = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    private void m20A() throws IOException {
        char c;
        do {
            if (this.pos < this.aYn || zzaed(1)) {
                char[] cArr = this.bho;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.bhp++;
                    this.bhq = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char m21B() throws IOException {
        if (this.pos != this.aYn || zzaed(1)) {
            char[] cArr = this.bho;
            int i = this.pos;
            this.pos = i + 1;
            char c = cArr[i];
            switch (c) {
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    this.bhp++;
                    this.bhq = this.pos;
                    return c;
                case C0337R.styleable.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                    return '\b';
                case C0337R.styleable.AppCompatTheme_checkboxStyle /*102*/:
                    return '\f';
                case C0337R.styleable.AppCompatTheme_spinnerStyle /*110*/:
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.pos + 4 <= this.aYn || zzaed(4)) {
                        int i2 = this.pos;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.bho[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                String str = "\\u";
                                String valueOf = String.valueOf(new String(this.bho, this.pos, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.pos += 4;
                        return c;
                    }
                    throw zztd("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw zztd("Unterminated escape sequence");
    }

    private void m22C() throws IOException {
        zzda(true);
        this.pos--;
        if (this.pos + bhm.length <= this.aYn || zzaed(bhm.length)) {
            int i = 0;
            while (i < bhm.length) {
                if (this.bho[this.pos + i] == bhm[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += bhm.length;
        }
    }

    private int getColumnNumber() {
        return (this.pos - this.bhq) + 1;
    }

    private int getLineNumber() {
        return this.bhp + 1;
    }

    private int m23u() throws IOException {
        int zzda;
        int i = this.bhv[this.bhw - 1];
        if (i == 1) {
            this.bhv[this.bhw - 1] = 2;
        } else if (i == 2) {
            switch (zzda(true)) {
                case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    break;
                case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    m28z();
                    break;
                case C0337R.styleable.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    this.bhr = 4;
                    return 4;
                default:
                    throw zztd("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.bhv[this.bhw - 1] = 4;
            if (i == 5) {
                switch (zzda(true)) {
                    case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                        break;
                    case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                        m28z();
                        break;
                    case 125:
                        this.bhr = 2;
                        return 2;
                    default:
                        throw zztd("Unterminated object");
                }
            }
            zzda = zzda(true);
            switch (zzda) {
                case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.bhr = 13;
                    return 13;
                case C0337R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    m28z();
                    this.bhr = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.bhr = 2;
                        return 2;
                    }
                    throw zztd("Expected name");
                default:
                    m28z();
                    this.pos--;
                    if (zze((char) zzda)) {
                        this.bhr = 14;
                        return 14;
                    }
                    throw zztd("Expected name");
            }
        } else if (i == 4) {
            this.bhv[this.bhw - 1] = 5;
            switch (zzda(true)) {
                case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                    break;
                case C0337R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
                    m28z();
                    if ((this.pos < this.aYn || zzaed(1)) && this.bho[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw zztd("Expected ':'");
            }
        } else if (i == 6) {
            if (this.bhn) {
                m22C();
            }
            this.bhv[this.bhw - 1] = 7;
        } else if (i == 7) {
            if (zzda(false) == -1) {
                this.bhr = 17;
                return 17;
            }
            m28z();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (zzda(true)) {
            case C0337R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                if (this.bhw == 1) {
                    m28z();
                }
                this.bhr = 9;
                return 9;
            case C0337R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                m28z();
                this.bhr = 8;
                return 8;
            case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                break;
            case C0337R.styleable.AppCompatTheme_alertDialogStyle /*91*/:
                this.bhr = 3;
                return 3;
            case C0337R.styleable.AppCompatTheme_alertDialogCenterButtons /*93*/:
                if (i == 1) {
                    this.bhr = 4;
                    return 4;
                }
                break;
            case 123:
                this.bhr = 1;
                return 1;
            default:
                this.pos--;
                if (this.bhw == 1) {
                    m28z();
                }
                zzda = m24v();
                if (zzda != 0) {
                    return zzda;
                }
                zzda = m25w();
                if (zzda != 0) {
                    return zzda;
                }
                if (zze(this.bho[this.pos])) {
                    m28z();
                    this.bhr = 10;
                    return 10;
                }
                throw zztd("Expected value");
        }
        if (i == 1 || i == 2) {
            m28z();
            this.pos--;
            this.bhr = 7;
            return 7;
        }
        throw zztd("Unexpected value");
    }

    private int m24v() throws IOException {
        String str;
        int i;
        char c = this.bho[this.pos];
        String str2;
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.pos + i2 >= this.aYn && !zzaed(i2 + 1)) {
                return 0;
            }
            char c2 = this.bho[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.pos + length < this.aYn || zzaed(length + 1)) && zze(this.bho[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.bhr = i;
        return i;
    }

    private int m25w() throws IOException {
        char[] cArr = this.bho;
        int i = this.pos;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.aYn;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (zzaed(i4 + 1)) {
                    i6 = this.pos;
                    i5 = this.aYn;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.bhs = j;
                    this.pos += i4;
                    this.bhr = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.bht = i4;
                    this.bhr = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case C0337R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0337R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case C0337R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case C0337R.styleable.AppCompatTheme_listPreferredItemHeight /*69*/:
                case C0337R.styleable.AppCompatTheme_buttonStyleSmall /*101*/:
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (zze(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.bht = i4;
            this.bhr = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private String m26x() throws IOException {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case ConnectionResult.SERVICE_INVALID /*9*/:
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    case C0337R.styleable.Toolbar_titleMargins /*12*/:
                    case ConnectionResult.CANCELED /*13*/:
                    case ItemTouchHelper.END /*32*/:
                    case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogStyle /*91*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0337R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0337R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    case C0337R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                        m28z();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.bho.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.bho, this.pos, i);
                this.pos = i + this.pos;
                i = !zzaed(1) ? 0 : 0;
            } else if (zzaed(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.bho, this.pos, i);
            } else {
                stringBuilder.append(this.bho, this.pos, i);
                str = stringBuilder.toString();
            }
            this.pos = i + this.pos;
            return str;
        }
    }

    private void m27y() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.aYn) {
                switch (this.bho[this.pos + i]) {
                    case ConnectionResult.SERVICE_INVALID /*9*/:
                    case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    case C0337R.styleable.Toolbar_titleMargins /*12*/:
                    case ConnectionResult.CANCELED /*13*/:
                    case ItemTouchHelper.END /*32*/:
                    case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogStyle /*91*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    case '{':
                    case '}':
                        break;
                    case C0337R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case C0337R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                    case C0337R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
                    case C0337R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                        m28z();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zzaed(1));
    }

    private void m28z() throws IOException {
        if (!this.bhn) {
            throw zztd("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void zzaec(int i) {
        if (this.bhw == this.bhv.length) {
            Object obj = new int[(this.bhw * 2)];
            Object obj2 = new int[(this.bhw * 2)];
            Object obj3 = new String[(this.bhw * 2)];
            System.arraycopy(this.bhv, 0, obj, 0, this.bhw);
            System.arraycopy(this.bhy, 0, obj2, 0, this.bhw);
            System.arraycopy(this.bhx, 0, obj3, 0, this.bhw);
            this.bhv = obj;
            this.bhy = obj2;
            this.bhx = obj3;
        }
        int[] iArr = this.bhv;
        int i2 = this.bhw;
        this.bhw = i2 + 1;
        iArr[i2] = i;
    }

    private boolean zzaed(int i) throws IOException {
        Object obj = this.bho;
        this.bhq -= this.pos;
        if (this.aYn != this.pos) {
            this.aYn -= this.pos;
            System.arraycopy(obj, this.pos, obj, 0, this.aYn);
        } else {
            this.aYn = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(obj, this.aYn, obj.length - this.aYn);
            if (read == -1) {
                return false;
            }
            this.aYn = read + this.aYn;
            if (this.bhp == 0 && this.bhq == 0 && this.aYn > 0 && obj[0] == '\ufeff') {
                this.pos++;
                this.bhq++;
                i++;
            }
        } while (this.aYn < i);
        return true;
    }

    private int zzda(boolean z) throws IOException {
        char[] cArr = this.bho;
        int i = this.pos;
        int i2 = this.aYn;
        while (true) {
            int lineNumber;
            if (i == i2) {
                this.pos = i;
                if (zzaed(1)) {
                    i = this.pos;
                    i2 = this.aYn;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    lineNumber = getLineNumber();
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(lineNumber).append(" column ").append(getColumnNumber()).toString());
                }
            }
            lineNumber = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.bhp++;
                this.bhq = lineNumber;
                i = lineNumber;
            } else if (c == ' ' || c == '\r') {
                i = lineNumber;
            } else if (c == '\t') {
                i = lineNumber;
            } else if (c == '/') {
                this.pos = lineNumber;
                if (lineNumber == i2) {
                    this.pos--;
                    boolean zzaed = zzaed(2);
                    this.pos++;
                    if (!zzaed) {
                        return c;
                    }
                }
                m28z();
                switch (cArr[this.pos]) {
                    case C0337R.styleable.AppCompatTheme_dialogTheme /*42*/:
                        this.pos++;
                        if (zztc("*/")) {
                            i = this.pos + 2;
                            i2 = this.aYn;
                            break;
                        }
                        throw zztd("Unterminated comment");
                    case C0337R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                        this.pos++;
                        m20A();
                        i = this.pos;
                        i2 = this.aYn;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = lineNumber;
                m28z();
                m20A();
                i = this.pos;
                i2 = this.aYn;
            } else {
                this.pos = lineNumber;
                return c;
            }
        }
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
            case C0337R.styleable.Toolbar_titleMargins /*12*/:
            case ConnectionResult.CANCELED /*13*/:
            case ItemTouchHelper.END /*32*/:
            case C0337R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case C0337R.styleable.AppCompatTheme_toolbarStyle /*58*/:
            case C0337R.styleable.AppCompatTheme_alertDialogStyle /*91*/:
            case C0337R.styleable.AppCompatTheme_alertDialogCenterButtons /*93*/:
            case '{':
            case '}':
                break;
            case C0337R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case C0337R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
            case C0337R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
            case C0337R.styleable.AppCompatTheme_popupWindowStyle /*61*/:
            case C0337R.styleable.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                m28z();
                break;
            default:
                return true;
        }
        return false;
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.bho;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m21B());
                    i = this.pos;
                    i2 = this.aYn;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.bhp++;
                    this.bhq = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.bho;
        do {
            int i = this.pos;
            int i2 = this.aYn;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i;
                    m21B();
                    i = this.pos;
                    i2 = this.aYn;
                } else if (c2 == '\n') {
                    this.bhp++;
                    this.bhq = i;
                }
                i3 = i;
            }
            this.pos = i3;
        } while (zzaed(1));
        throw zztd("Unterminated string");
    }

    private boolean zztc(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.aYn && !zzaed(str.length())) {
                return false;
            }
            if (this.bho[this.pos] == '\n') {
                this.bhp++;
                this.bhq = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.bho[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zztd(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzaos(new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginArray() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 3) {
            zzaec(1);
            this.bhy[this.bhw - 1] = 0;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(m29h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 74) + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginObject() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 1) {
            zzaec(3);
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(m29h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 75) + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void close() throws IOException {
        this.bhr = 0;
        this.bhv[0] = 8;
        this.bhw = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 4) {
            this.bhw--;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(m29h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void endObject() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 2) {
            this.bhw--;
            this.bhx[this.bhw] = null;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bhr = 0;
            return;
        }
        String valueOf = String.valueOf(m29h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 73) + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.bhw;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bhv[i2]) {
                case ConnectionResult.SERVICE_MISSING /*1*/:
                case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                    append.append('[').append(this.bhy[i2]).append(']');
                    break;
                case ConnectionResult.SERVICE_DISABLED /*3*/:
                case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                case ConnectionResult.INVALID_ACCOUNT /*5*/:
                    append.append('.');
                    if (this.bhx[i2] == null) {
                        break;
                    }
                    append.append(this.bhx[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    public zzaoq m29h() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        switch (i) {
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return zzaoq.BEGIN_OBJECT;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return zzaoq.END_OBJECT;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return zzaoq.BEGIN_ARRAY;
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                return zzaoq.END_ARRAY;
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
            case ConnectionResult.RESOLUTION_REQUIRED /*6*/:
                return zzaoq.BOOLEAN;
            case ConnectionResult.NETWORK_ERROR /*7*/:
                return zzaoq.NULL;
            case ConnectionResult.INTERNAL_ERROR /*8*/:
            case ConnectionResult.SERVICE_INVALID /*9*/:
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzaoq.STRING;
            case C0337R.styleable.Toolbar_titleMargins /*12*/:
            case ConnectionResult.CANCELED /*13*/:
            case ConnectionResult.TIMEOUT /*14*/:
                return zzaoq.NAME;
            case ConnectionResult.INTERRUPTED /*15*/:
            case ConnectionResult.API_UNAVAILABLE /*16*/:
                return zzaoq.NUMBER;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                return zzaoq.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public boolean hasNext() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.bhn;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 5) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            i = this.bhw - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.bhr = 0;
            int[] iArr2 = this.bhy;
            r2 = this.bhw - 1;
            iArr2[r2] = iArr2[r2] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(m29h());
            r2 = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(r2).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.bhs;
        }
        if (i == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (i == 8 || i == 9) {
            this.bhu = zzf(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.bhu = m26x();
        } else if (i != 11) {
            String valueOf = String.valueOf(m29h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 11;
        double parseDouble = Double.parseDouble(this.bhu);
        if (this.bhn || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.bhu = null;
            this.bhr = 0;
            int[] iArr2 = this.bhy;
            columnNumber = this.bhw - 1;
            iArr2[columnNumber] = iArr2[columnNumber] + 1;
            return parseDouble;
        }
        columnNumber = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        throw new zzaos(new StringBuilder(String.valueOf(path2).length() + C0337R.styleable.AppCompatTheme_checkboxStyle).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(columnNumber).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
    }

    public int nextInt() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.bhs;
            if (this.bhs != ((long) i)) {
                long j = this.bhs;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.bhr = 0;
            iArr = this.bhy;
            i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            String valueOf;
            int columnNumber2;
            String path2;
            if (i == 16) {
                this.bhu = new String(this.bho, this.pos, this.bht);
                this.pos += this.bht;
            } else if (i == 8 || i == 9) {
                this.bhu = zzf(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.bhu);
                    this.bhr = 0;
                    iArr = this.bhy;
                    i2 = this.bhw - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                valueOf = String.valueOf(m29h());
                i2 = getLineNumber();
                columnNumber2 = getColumnNumber();
                path2 = getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
            }
            this.bhr = 11;
            double parseDouble = Double.parseDouble(this.bhu);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                valueOf = this.bhu;
                i2 = getLineNumber();
                columnNumber2 = getColumnNumber();
                path2 = getPath();
                throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
            }
            this.bhu = null;
            this.bhr = 0;
            iArr = this.bhy;
            i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public long nextLong() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 15) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bhs;
        }
        long parseLong;
        int i3;
        if (i == 16) {
            this.bhu = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else if (i == 8 || i == 9) {
            this.bhu = zzf(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.bhu);
                this.bhr = 0;
                int[] iArr2 = this.bhy;
                i3 = this.bhw - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(m29h());
            int lineNumber = getLineNumber();
            i3 = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.bhr = 11;
        double parseDouble = Double.parseDouble(this.bhu);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            valueOf = this.bhu;
            lineNumber = getLineNumber();
            i3 = getColumnNumber();
            path = getPath();
            throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.bhu = null;
        this.bhr = 0;
        iArr2 = this.bhy;
        i3 = this.bhw - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    public String nextName() throws IOException {
        String x;
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 14) {
            x = m26x();
        } else if (i == 12) {
            x = zzf('\'');
        } else if (i == 13) {
            x = zzf('\"');
        } else {
            String valueOf = String.valueOf(m29h());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 0;
        this.bhx[this.bhw - 1] = x;
        return x;
    }

    public void nextNull() throws IOException {
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 7) {
            this.bhr = 0;
            int[] iArr = this.bhy;
            int i2 = this.bhw - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(m29h());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String x;
        int lineNumber;
        int i = this.bhr;
        if (i == 0) {
            i = m23u();
        }
        if (i == 10) {
            x = m26x();
        } else if (i == 8) {
            x = zzf('\'');
        } else if (i == 9) {
            x = zzf('\"');
        } else if (i == 11) {
            x = this.bhu;
            this.bhu = null;
        } else if (i == 15) {
            x = Long.toString(this.bhs);
        } else if (i == 16) {
            x = new String(this.bho, this.pos, this.bht);
            this.pos += this.bht;
        } else {
            String valueOf = String.valueOf(m29h());
            lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.bhr = 0;
        int[] iArr = this.bhy;
        lineNumber = this.bhw - 1;
        iArr[lineNumber] = iArr[lineNumber] + 1;
        return x;
    }

    public final void setLenient(boolean z) {
        this.bhn = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.bhr;
            if (i2 == 0) {
                i2 = m23u();
            }
            if (i2 == 3) {
                zzaec(1);
                i++;
            } else if (i2 == 1) {
                zzaec(3);
                i++;
            } else if (i2 == 4) {
                this.bhw--;
                i--;
            } else if (i2 == 2) {
                this.bhw--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m27y();
            } else if (i2 == 8 || i2 == 12) {
                zzg('\'');
            } else if (i2 == 9 || i2 == 13) {
                zzg('\"');
            } else if (i2 == 16) {
                this.pos += this.bht;
            }
            this.bhr = 0;
        } while (i != 0);
        int[] iArr = this.bhy;
        int i3 = this.bhw - 1;
        iArr[i3] = iArr[i3] + 1;
        this.bhx[this.bhw - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }
}
