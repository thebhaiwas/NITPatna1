package okhttp3;

import com.google.android.gms.common.ConnectionResult;

public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String javaName;

    private TlsVersion(String javaName) {
        this.javaName = javaName;
    }

    public static TlsVersion forJavaName(String javaName) {
        Object obj = -1;
        switch (javaName.hashCode()) {
            case -503070503:
                if (javaName.equals("TLSv1.1")) {
                    obj = 1;
                    break;
                }
                break;
            case -503070502:
                if (javaName.equals("TLSv1.2")) {
                    obj = null;
                    break;
                }
                break;
            case 79201641:
                if (javaName.equals("SSLv3")) {
                    obj = 3;
                    break;
                }
                break;
            case 79923350:
                if (javaName.equals("TLSv1")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case ConnectionResult.SUCCESS /*0*/:
                return TLS_1_2;
            case ConnectionResult.SERVICE_MISSING /*1*/:
                return TLS_1_1;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return TLS_1_0;
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }
    }

    public String javaName() {
        return this.javaName;
    }
}
