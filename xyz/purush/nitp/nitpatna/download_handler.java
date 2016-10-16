package xyz.purush.nitp.nitpatna;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import java.io.File;

public class download_handler {
    public static String download_title;
    public static String downloaded_notice;
    public static String file_name;
    public static String file_type;
    public static String file_url;
    public static long myDownloadRefrence;
    public static String pata;
    Context context;
    int position;
    int which_feature;

    public void download_handler(Context c, int _which_feature, int _position, String _file_name, String _file_url, String _file_type, String _download_title) {
        Log.d("TAG", "Download Request");
        this.position = _position;
        this.which_feature = _which_feature;
        this.context = c;
        downloaded_notice = _file_name;
        downloaded_notice = _file_name;
        file_name = _file_name;
        file_url = _file_url;
        file_url = file_url.replaceAll(" ", "%20");
        file_type = _file_type;
        download_title = _download_title;
        Log.d("DOWNLOAD", "position is " + this.position + " and feature is " + this.which_feature);
        String str = BuildConfig.FLAVOR + this.which_feature + this.position;
        Log.d("DOWNLOAD", str);
        Log.d("DOWNLOAD", "fin is " + Integer.parseInt(str.toString()));
        Download();
        Log.d("DOWNLOAD", "MY Download Refrence is " + myDownloadRefrence);
    }

    public boolean does_file_exist(String _temp_file_name) {
        String location_ex = Environment.getExternalStorageDirectory().getAbsolutePath();
        String location_in = Environment.getExternalStorageState();
        location_ex = location_ex + "/nitp/";
        Log.d("TAG", "Location_ex is " + location_ex);
        Log.d("TAG", "Location_in is " + location_in);
        String pata = "file:///" + location_ex + "/" + _temp_file_name;
        if (new File(Environment.getExternalStoragePublicDirectory("/nitp").getAbsolutePath() + "/" + _temp_file_name).exists()) {
            return true;
        }
        return false;
    }

    public void Download() {
        Log.d("TAG", "Permission called");
        String location_ex = Environment.getExternalStorageDirectory().getAbsolutePath();
        String location_in = Environment.getExternalStorageState();
        location_ex = location_ex + "/nitp/";
        Log.d("TAG", "Location_ex is " + location_ex);
        Log.d("TAG", "Location_in is " + location_in);
        pata = "file:///" + location_ex + "/" + file_name;
        if (new File(Environment.getExternalStoragePublicDirectory("/nitp").getAbsolutePath() + "/" + file_name).exists()) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            if (file_type.equals("pdf")) {
                intent.setDataAndType(Uri.parse(pata), "application/pdf");
            } else {
                intent.setDataAndType(Uri.parse(pata), "image/*");
            }
            this.context.startActivity(intent);
            return;
        }
        Toast.makeText(this.context, "Downloading", 1).show();
        Context context = this.context;
        Context context2 = this.context;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        Request request = new Request(Uri.parse(file_url));
        request.setDescription("Downloading").setTitle(file_name);
        request.setDestinationInExternalPublicDir("/nitp", file_name);
        request.setVisibleInDownloadsUi(true);
        myDownloadRefrence = downloadManager.enqueue(request);
        Intent intent2 = new Intent(this.context, NotificationService.class);
        intent2.putExtra("download_title", download_title);
        intent2.putExtra("file", pata);
        intent2.putExtra("file_type", file_type);
        intent2.putExtra("download_reference", myDownloadRefrence);
        intent2.putExtra("which_feature", this.which_feature);
        this.context.startService(intent2);
    }
}
