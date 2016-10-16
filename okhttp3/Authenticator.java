package okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE;

    /* renamed from: okhttp3.Authenticator.1 */
    static class C05151 implements Authenticator {
        C05151() {
        }

        public Request authenticate(Route route, Response response) {
            return null;
        }
    }

    Request authenticate(Route route, Response response) throws IOException;

    static {
        NONE = new C05151();
    }
}
