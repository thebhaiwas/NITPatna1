package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzf;
import java.util.regex.Pattern;

public class FirebaseMessaging {
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final Pattern baY;
    private static FirebaseMessaging baZ;
    private final FirebaseInstanceId baD;
    private PendingIntent bba;

    static {
        baY = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    }

    private FirebaseMessaging(FirebaseInstanceId firebaseInstanceId) {
        this.baD = firebaseInstanceId;
    }

    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            if (baZ == null) {
                baZ = new FirebaseMessaging(FirebaseInstanceId.getInstance());
            }
            firebaseMessaging = baZ;
        }
        return firebaseMessaging;
    }

    private synchronized void zzk(Context context, Intent intent) {
        if (this.bba == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.bba = PendingIntent.getBroadcast(context, 0, intent2, 0);
        }
        intent.putExtra("app", this.bba);
    }

    public void send(RemoteMessage remoteMessage) {
        if (TextUtils.isEmpty(remoteMessage.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        zzk(applicationContext, intent);
        intent.setPackage(zzf.zzdi(applicationContext));
        remoteMessage.zzaf(intent);
        applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void subscribeToTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            Object substring = str.substring("/topics/".length());
        }
        if (substring == null || !baY.matcher(substring).matches()) {
            String valueOf = String.valueOf("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(substring).length() + 55) + String.valueOf(valueOf).length()).append("Invalid topic name: ").append(substring).append(" does not match the allowed format ").append(valueOf).toString());
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        String valueOf2 = String.valueOf("S!");
        String valueOf3 = String.valueOf(substring);
        instance.zzsf(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
    }

    public void unsubscribeFromTopic(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
            Object substring = str.substring("/topics/".length());
        }
        if (substring == null || !baY.matcher(substring).matches()) {
            String valueOf = String.valueOf("[a-zA-Z0-9-_.~%]{1,900}");
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(substring).length() + 55) + String.valueOf(valueOf).length()).append("Invalid topic name: ").append(substring).append(" does not match the allowed format ").append(valueOf).toString());
        }
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        String valueOf2 = String.valueOf("U!");
        String valueOf3 = String.valueOf(substring);
        instance.zzsf(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
    }
}
