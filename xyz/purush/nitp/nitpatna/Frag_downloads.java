package xyz.purush.nitp.nitpatna;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frag_downloads extends Fragment {
    Context context;
    BroadcastReceiver downloadCompleteReceiver;
    BroadcastReceiver download_completed;
    String[] download_name;
    String[] file_name;
    String[] file_type;
    String[] file_upload_date;
    String[] file_url;
    boolean first_time;
    int internet_status;
    int is_active;
    private ProgressDialog pD;
    View f6v;
    int which_feature;

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_downloads.3 */
    class C03333 extends BroadcastReceiver {
        C03333() {
        }

        public void onReceive(Context context, Intent intent) {
            Frag_downloads.this.load_downloads();
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_downloads.1 */
    class C05451 implements Listener<JSONArray> {
        C05451() {
        }

        public void onResponse(JSONArray response) {
            Log.d("TAG", "respones");
            if (response.length() > 0) {
                int size = response.length() - 1;
                Frag_downloads.this.download_name = new String[size];
                Frag_downloads.this.file_name = new String[size];
                Frag_downloads.this.file_url = new String[size];
                Frag_downloads.this.file_type = new String[size];
                Frag_downloads.this.file_upload_date = new String[size];
                int j = 0;
                while (j < size) {
                    try {
                        Log.d("TAG", "loop " + j);
                        JSONObject myObj = (JSONObject) response.get(j);
                        Frag_downloads.this.download_name[j] = myObj.getString("download_name");
                        Frag_downloads.this.file_name[j] = myObj.getString("file_name");
                        Frag_downloads.this.file_url[j] = myObj.getString("file_url");
                        Frag_downloads.this.file_upload_date[j] = myObj.getString("file_upload_date");
                        Frag_downloads.this.file_type[j] = myObj.getString("file_type");
                        Log.d("TAG", Frag_downloads.this.file_name[j] + Frag_downloads.this.file_type[j] + Frag_downloads.this.file_url[j]);
                        j++;
                    } catch (JSONException e) {
                        Log.d("TAG", "ERror catch");
                        if (Frag_downloads.this.is_active == 1) {
                            Toast.makeText(Frag_downloads.this.getActivity(), "Application Internal Error", 0).show();
                        }
                        e.printStackTrace();
                        return;
                    }
                }
                if (Frag_downloads.this.is_active == 1) {
                    Toast.makeText(Frag_downloads.this.getActivity(), "Downloads updated", 0).show();
                }
                if (Frag_downloads.this.is_active == 1) {
                    Frag_downloads.this.load_downloads();
                }
            }
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_downloads.2 */
    class C05462 implements ErrorListener {
        C05462() {
        }

        public void onErrorResponse(VolleyError error) {
            Log.d("TAG", "no net err");
            if (Frag_downloads.this.is_active == 1) {
                Toast.makeText(Frag_downloads.this.getActivity(), "Couldn't update. Check internet connection", 0).show();
            }
            if (Frag_downloads.this.pD.isShowing()) {
                Frag_downloads.this.pD.hide();
            }
        }
    }

    public Frag_downloads() {
        this.first_time = true;
        this.is_active = 1;
        this.internet_status = 1;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f6v = inflater.inflate(C0337R.layout.content_downloads, container, false);
        MainActivity.current_frag = 3;
        return this.f6v;
    }

    public void onPause() {
        this.first_time = false;
        this.pD.dismiss();
        this.is_active = 0;
        if (this.download_name != null) {
            save_data();
        }
        unregister_receiver();
        super.onPause();
    }

    public void onDestroy() {
        this.pD.dismiss();
        super.onDestroy();
    }

    public void onResume() {
        if (this.first_time) {
            this.pD = new ProgressDialog(getActivity());
            this.pD.setMessage("Please wait...");
            this.pD.setCancelable(false);
            this.pD.show();
        }
        this.which_feature = 2;
        load_saved_data();
        download_request();
        register_receiver();
        super.onResume();
    }

    public void download_request() {
        Volley.newRequestQueue(getActivity()).add(new JsonArrayRequest("http://nitp.purush.xyz/app/downloads.php", new C05451(), new C05462()));
        Log.d("TAG", "end");
    }

    public void load_downloads() {
        Log.d("TAG", "load notices");
        ListView lv = (ListView) this.f6v.findViewById(C0337R.id.download_list);
        this.context = getActivity();
        lv.setAdapter(new CustomAdapter(this.context, this.which_feature, this.download_name, this.file_name, this.file_type, this.file_url, this.file_upload_date));
        if (this.pD.isShowing()) {
            this.pD.hide();
        }
    }

    public void save_data() {
        Editor editor = getActivity().getSharedPreferences("MY_PREFS_DOWNLOADS", 0).edit();
        StringBuilder save_file_name = new StringBuilder();
        StringBuilder save_file_type = new StringBuilder();
        StringBuilder save_file_upload_date = new StringBuilder();
        StringBuilder save_file_url = new StringBuilder();
        StringBuilder save_download_name = new StringBuilder();
        for (int i = 0; i < this.file_name.length; i++) {
            save_download_name.append(this.download_name[i]).append("#");
            save_file_name.append(this.file_name[i]).append("#");
            save_file_type.append(this.file_type[i]).append("#");
            save_file_url.append(this.file_url[i]).append("#");
            save_file_upload_date.append(this.file_upload_date[i]).append("#");
        }
        editor.putString("file_name", save_file_name.toString());
        editor.putString("download_name", save_download_name.toString());
        editor.putString("file_type", save_file_type.toString());
        editor.putString("file_url", save_file_url.toString());
        editor.putString("file_upload_date", save_file_upload_date.toString());
        editor.commit();
    }

    public void load_saved_data() {
        SharedPreferences myshare = getActivity().getSharedPreferences("MY_PREFS_DOWNLOADS", 0);
        String saved_download_name = myshare.getString("download_name", BuildConfig.FLAVOR);
        String saved_file_name = myshare.getString("file_name", BuildConfig.FLAVOR);
        String saved_file_type = myshare.getString("file_type", BuildConfig.FLAVOR);
        String saved_file_url = myshare.getString("file_url", BuildConfig.FLAVOR);
        String saved_file_upload_date = myshare.getString("file_upload_date", BuildConfig.FLAVOR);
        Log.d("TAG", "saved_download_name length is " + saved_download_name);
        if (saved_download_name.length() > 1) {
            this.download_name = saved_download_name.split("#");
            this.file_name = saved_file_name.split("#");
            this.file_url = saved_file_url.split("#");
            this.file_type = saved_file_type.split("#");
            this.file_upload_date = saved_file_upload_date.split("#");
            for (int i = 0; i < this.file_name.length; i++) {
                Log.d("TAG", "i is " + i);
                Log.d("TAG", this.file_name[i]);
                Log.d("TAG", this.file_type[i]);
                Log.d("TAG", this.file_upload_date[i]);
                Log.d("TAG", this.file_url[i]);
            }
            if (this.is_active == 1) {
                load_downloads();
            }
        }
    }

    public void register_receiver() {
        Log.d("Broadcast", "Registering Receiver");
        Log.d("Broadcast", "Registering Receiver");
        IntentFilter intentFilter = new IntentFilter("xyz.purush.nitp.nitpatna.CUSTOM_INTENT");
        this.downloadCompleteReceiver = new C03333();
        getActivity().registerReceiver(this.downloadCompleteReceiver, intentFilter);
    }

    public void unregister_receiver() {
        Log.d("Broadcast", "Unregistering Receiver");
        getActivity().unregisterReceiver(this.downloadCompleteReceiver);
    }
}
