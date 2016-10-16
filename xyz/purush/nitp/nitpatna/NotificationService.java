package xyz.purush.nitp.nitpatna;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;

public class NotificationService extends Service {
    int counter;
    private BroadcastReceiver downloadComp;
    long[] download_reference;
    String[] download_title;
    String[] file;
    String[] file_type;
    int[] which_feature;

    /* renamed from: xyz.purush.nitp.nitpatna.NotificationService.1 */
    class C03361 extends BroadcastReceiver {
        C03361() {
        }

        public void onReceive(Context context, Intent intent) {
            long _reference = intent.getLongExtra("extra_download_id", -1);
            Log.d("Service", "Received reference is " + _reference + " and my refrence is " + NotificationService.this.download_reference[NotificationService.this.counter]);
            for (int j = 0; j < NotificationService.this.counter; j++) {
                if (_reference == NotificationService.this.download_reference[j]) {
                    DownloadManager downloadManager = (DownloadManager) NotificationService.this.getSystemService("download");
                    Query query = new Query();
                    query.setFilterById(new long[]{_reference});
                    Cursor cursor = downloadManager.query(query);
                    cursor.moveToFirst();
                    if (cursor.getInt(cursor.getColumnIndex(NotificationCompatApi21.CATEGORY_STATUS)) == 8) {
                        NotificationService.this.download_completed(j);
                    } else {
                        NotificationService.this.download_failed();
                    }
                }
            }
        }
    }

    public NotificationService() {
        this.counter = 0;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            Log.d("Service", "yes");
            Log.d("Service", "onStartCommand counter is " + this.counter);
            if (extras != null) {
                this.download_title[this.counter] = extras.getString("download_title");
                this.file_type[this.counter] = extras.getString("file_type");
                this.file[this.counter] = extras.getString("file");
                this.download_reference[this.counter] = extras.getLong("download_reference");
                this.which_feature[this.counter] = extras.getInt("which_feature");
                Log.d("Service", "extra data is " + this.download_title[this.counter] + " " + this.file_type[this.counter] + " " + this.file[this.counter] + " " + this.download_reference[this.counter] + " " + this.which_feature[this.counter]);
                this.counter++;
            } else {
                Log.d("Service", "null");
            }
        } else {
            Log.d("TAG", "Intent null");
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void onCreate() {
        this.download_title = new String[100];
        this.file = new String[100];
        this.file_type = new String[100];
        this.download_reference = new long[100];
        this.which_feature = new int[100];
        Log.d("Service", "Service Started couter is " + this.counter);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        this.downloadComp = new C03361();
        registerReceiver(this.downloadComp, intentFilter);
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.downloadComp);
        this.counter = 0;
        Log.d("Service", "Destroyed");
    }

    public void download_completed(int j) {
        Intent i = new Intent();
        i.setAction("android.intent.action.VIEW");
        if (this.file_type[j].equals("pdf")) {
            i.setDataAndType(Uri.parse(this.file[j]), "application/pdf");
        } else {
            i.setDataAndType(Uri.parse(this.file[j]), "image/*");
        }
        i.addFlags(67108864);
        ((NotificationManager) getSystemService("notification")).notify((int) this.download_reference[j], new Builder(this).setAutoCancel(true).setContentTitle("Download Complete").setContentText(this.download_title[j]).setSmallIcon(C0337R.mipmap.ic_launcher).setContentIntent(PendingIntent.getActivity(this, 0, i, 134217728)).build());
        send_custom_broadcast(j);
    }

    public void download_failed() {
        ((NotificationManager) getSystemService("notification")).notify(this.counter, new Builder(this).setAutoCancel(true).setContentTitle("Download Failed").setContentText("check your connection and retry").setSmallIcon(C0337R.mipmap.ic_launcher).build());
    }

    public void send_custom_broadcast(int j) {
        Log.d("Broadcast", "Broadcast sent " + this.which_feature[j]);
        Intent i = new Intent();
        i.putExtra("which_feature", this.which_feature[j]);
        i.setAction("xyz.purush.nitp.nitpatna.CUSTOM_INTENT");
        sendBroadcast(i);
    }
}
