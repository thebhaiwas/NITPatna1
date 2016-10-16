package xyz.purush.nitp.nitpatna;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String msg_body;
    int msg_id;
    String msg_title;

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("TAG", "Message received");
        this.msg_title = remoteMessage.getNotification().getTitle();
        this.msg_body = remoteMessage.getNotification().getBody();
        this.msg_id = this.msg_title.length();
        showNotification();
    }

    public void showNotification() {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(67108864);
        ((NotificationManager) getSystemService("notification")).notify(this.msg_id, new Builder(this).setAutoCancel(true).setContentTitle(this.msg_title).setContentText(this.msg_body).setSmallIcon(C0337R.mipmap.ic_launcher).setContentIntent(PendingIntent.getActivity(this, 0, i, 134217728)).build());
    }
}
