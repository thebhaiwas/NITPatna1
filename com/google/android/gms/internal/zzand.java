package com.google.android.gms.internal;

import java.io.Reader;
import java.io.StringReader;

public final class zzand {
    public zzamy zza(Reader reader) throws zzamz, zzanh {
        try {
            zzaop com_google_android_gms_internal_zzaop = new zzaop(reader);
            zzamy zzh = zzh(com_google_android_gms_internal_zzaop);
            if (zzh.zzczp() || com_google_android_gms_internal_zzaop.m29h() == zzaoq.END_DOCUMENT) {
                return zzh;
            }
            throw new zzanh("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new zzanh(e);
        } catch (Throwable e2) {
            throw new zzamz(e2);
        } catch (Throwable e22) {
            throw new zzanh(e22);
        }
    }

    public zzamy zzh(zzaop com_google_android_gms_internal_zzaop) throws zzamz, zzanh {
        String valueOf;
        boolean isLenient = com_google_android_gms_internal_zzaop.isLenient();
        com_google_android_gms_internal_zzaop.setLenient(true);
        try {
            zzamy zzh = zzanz.zzh(com_google_android_gms_internal_zzaop);
            com_google_android_gms_internal_zzaop.setLenient(isLenient);
            return zzh;
        } catch (Throwable e) {
            valueOf = String.valueOf(com_google_android_gms_internal_zzaop);
            throw new zzanc(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(com_google_android_gms_internal_zzaop);
            throw new zzanc(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaop.setLenient(isLenient);
        }
    }

    public zzamy zzsy(String str) throws zzanh {
        return zza(new StringReader(str));
    }
}
