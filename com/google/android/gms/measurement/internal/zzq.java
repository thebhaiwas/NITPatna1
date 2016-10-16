package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzq extends zzaa {

    @WorkerThread
    interface zza {
        void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    @WorkerThread
    private static class zzb implements Runnable {
        private final String aQ;
        private final zza ala;
        private final Throwable alb;
        private final byte[] alc;
        private final Map<String, List<String>> ald;
        private final int zzblz;

        private zzb(String str, zza com_google_android_gms_measurement_internal_zzq_zza, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            zzab.zzaa(com_google_android_gms_measurement_internal_zzq_zza);
            this.ala = com_google_android_gms_measurement_internal_zzq_zza;
            this.zzblz = i;
            this.alb = th;
            this.alc = bArr;
            this.aQ = str;
            this.ald = map;
        }

        public void run() {
            this.ala.zza(this.aQ, this.zzblz, this.alb, this.alc, this.ald);
        }
    }

    @WorkerThread
    private class zzc implements Runnable {
        private final String aQ;
        private final byte[] ale;
        private final zza alf;
        private final Map<String, String> alg;
        final /* synthetic */ zzq alh;
        private final URL zzbin;

        public zzc(zzq com_google_android_gms_measurement_internal_zzq, String str, URL url, byte[] bArr, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
            this.alh = com_google_android_gms_measurement_internal_zzq;
            zzab.zzhs(str);
            zzab.zzaa(url);
            zzab.zzaa(com_google_android_gms_measurement_internal_zzq_zza);
            this.zzbin = url;
            this.ale = bArr;
            this.alf = com_google_android_gms_measurement_internal_zzq_zza;
            this.aQ = str;
            this.alg = map;
        }

        public void run() {
            HttpURLConnection zzc;
            OutputStream outputStream;
            Throwable e;
            Map map;
            int i;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            this.alh.zzbso();
            int i2 = 0;
            try {
                this.alh.zzeu(this.aQ);
                zzc = this.alh.zzc(this.zzbin);
                try {
                    if (this.alg != null) {
                        for (Entry entry : this.alg.entrySet()) {
                            zzc.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.ale != null) {
                        byte[] zzj = this.alh.zzbsv().zzj(this.ale);
                        this.alh.zzbsz().zzbty().zzj("Uploading data. size", Integer.valueOf(zzj.length));
                        zzc.setDoOutput(true);
                        zzc.addRequestProperty("Content-Encoding", "gzip");
                        zzc.setFixedLengthStreamingMode(zzj.length);
                        zzc.connect();
                        outputStream = zzc.getOutputStream();
                        try {
                            outputStream.write(zzj);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            httpURLConnection = zzc;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.alh.zzbsz().zzbtr().zzj("Error closing HTTP compressed POST connection output stream", e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.alh.zzrq();
                            this.alh.zzbsy().zzl(new zzb(this.alf, i, e, null, map, null));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.alh.zzbsz().zzbtr().zzj("Error closing HTTP compressed POST connection output stream", e32);
                                }
                            }
                            if (zzc != null) {
                                zzc.disconnect();
                            }
                            this.alh.zzrq();
                            this.alh.zzbsy().zzl(new zzb(this.alf, i2, null, null, map2, null));
                            throw th;
                        }
                    }
                    i2 = zzc.getResponseCode();
                    map2 = zzc.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = zzc;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.alh.zzrq();
                    this.alh.zzbsy().zzl(new zzb(this.alf, i, e, null, map, null));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.alh.zzrq();
                    this.alh.zzbsy().zzl(new zzb(this.alf, i2, null, null, map2, null));
                    throw th;
                }
                try {
                    byte[] zza = this.alh.zzc(zzc);
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.alh.zzrq();
                    this.alh.zzbsy().zzl(new zzb(this.alf, i2, null, zza, map2, null));
                } catch (IOException e5) {
                    e = e5;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = zzc;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.alh.zzrq();
                    this.alh.zzbsy().zzl(new zzb(this.alf, i, e, null, map, null));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (zzc != null) {
                        zzc.disconnect();
                    }
                    this.alh.zzrq();
                    this.alh.zzbsy().zzl(new zzb(this.alf, i2, null, null, map2, null));
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.alh.zzrq();
                this.alh.zzbsy().zzl(new zzb(this.alf, i, e, null, map, null));
            } catch (Throwable th322) {
                th = th322;
                map2 = null;
                zzc = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzc != null) {
                    zzc.disconnect();
                }
                this.alh.zzrq();
                this.alh.zzbsy().zzl(new zzb(this.alf, i2, null, null, map2, null));
                throw th;
            }
        }
    }

    public zzq(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    @WorkerThread
    private byte[] zzc(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public void zza(String str, URL url, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
        zzwu();
        zzzg();
        zzab.zzaa(url);
        zzab.zzaa(com_google_android_gms_measurement_internal_zzq_zza);
        zzbsy().zzm(new zzc(this, str, url, null, map, com_google_android_gms_measurement_internal_zzq_zza));
    }

    @WorkerThread
    public void zza(String str, URL url, byte[] bArr, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
        zzwu();
        zzzg();
        zzab.zzaa(url);
        zzab.zzaa(bArr);
        zzab.zzaa(com_google_android_gms_measurement_internal_zzq_zza);
        zzbsy().zzm(new zzc(this, str, url, bArr, map, com_google_android_gms_measurement_internal_zzq_zza));
    }

    public boolean zzadj() {
        NetworkInfo activeNetworkInfo;
        zzzg();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public /* bridge */ /* synthetic */ void zzbso() {
        super.zzbso();
    }

    public /* bridge */ /* synthetic */ zzc zzbsp() {
        return super.zzbsp();
    }

    public /* bridge */ /* synthetic */ zzac zzbsq() {
        return super.zzbsq();
    }

    public /* bridge */ /* synthetic */ zzn zzbsr() {
        return super.zzbsr();
    }

    public /* bridge */ /* synthetic */ zzg zzbss() {
        return super.zzbss();
    }

    public /* bridge */ /* synthetic */ zzad zzbst() {
        return super.zzbst();
    }

    public /* bridge */ /* synthetic */ zze zzbsu() {
        return super.zzbsu();
    }

    public /* bridge */ /* synthetic */ zzal zzbsv() {
        return super.zzbsv();
    }

    public /* bridge */ /* synthetic */ zzv zzbsw() {
        return super.zzbsw();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsx() {
        return super.zzbsx();
    }

    public /* bridge */ /* synthetic */ zzw zzbsy() {
        return super.zzbsy();
    }

    public /* bridge */ /* synthetic */ zzp zzbsz() {
        return super.zzbsz();
    }

    public /* bridge */ /* synthetic */ zzt zzbta() {
        return super.zzbta();
    }

    public /* bridge */ /* synthetic */ zzd zzbtb() {
        return super.zzbtb();
    }

    @WorkerThread
    protected HttpURLConnection zzc(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) zzbtb().zzbrx());
            httpURLConnection.setReadTimeout((int) zzbtb().zzbry());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void zzeu(String str) {
    }

    protected void zzrq() {
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    protected void zzwv() {
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
