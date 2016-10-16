package xyz.purush.nitp.nitpatna;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        Log.d("TAG", "This called");
        registerToken(FirebaseInstanceId.getInstance().getToken());
    }

    private void registerToken(String token) {
        try {
            new OkHttpClient().newCall(new Builder().url("http://nitp.purush.xyz/app/register.php").post(new FormBody.Builder().add("token", token).build()).build()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
