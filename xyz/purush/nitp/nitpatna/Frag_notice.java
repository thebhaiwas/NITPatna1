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
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Frag_notice extends Fragment {
    Context context;
    BroadcastReceiver downloadCompleteReceiver;
    BroadcastReceiver download_completed;
    String[] file_name;
    String[] file_type;
    String[] file_upload_date;
    String[] file_url;
    int internet_status;
    int is_active;
    boolean is_first_time;
    String[] notice_name;
    private ProgressDialog pD;
    String saved_notice_name;
    View f11v;
    int which_feature;

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_notice.3 */
    class C03343 extends BroadcastReceiver {
        C03343() {
        }

        public void onReceive(Context context, Intent intent) {
            Frag_notice.this.load_notices();
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_notice.1 */
    class C05511 implements Listener<JSONArray> {
        C05511() {
        }

        public void onResponse(JSONArray response) {
            if (response.length() > 0) {
                Log.d("TAG", "respones");
                int size = response.length() - 1;
                Frag_notice.this.notice_name = new String[size];
                Frag_notice.this.file_name = new String[size];
                Frag_notice.this.file_url = new String[size];
                Frag_notice.this.file_type = new String[size];
                Frag_notice.this.file_upload_date = new String[size];
                int j = 0;
                while (j < size) {
                    try {
                        Log.d("TAG", "loop " + j);
                        JSONObject myObj = (JSONObject) response.get(j);
                        Frag_notice.this.notice_name[j] = myObj.getString("notice_name");
                        Frag_notice.this.file_name[j] = myObj.getString("file_name");
                        Frag_notice.this.file_url[j] = myObj.getString("file_url");
                        Frag_notice.this.file_upload_date[j] = myObj.getString("file_upload_date");
                        Frag_notice.this.file_type[j] = myObj.getString("file_type");
                        Log.d("TAG", Frag_notice.this.file_name[j] + Frag_notice.this.file_type[j] + Frag_notice.this.file_url[j]);
                        j++;
                    } catch (JSONException e) {
                        Log.d("TAG", "ERror catch");
                        e.printStackTrace();
                        return;
                    }
                }
                if (Frag_notice.this.is_active == 1) {
                    Toast.makeText(Frag_notice.this.getActivity(), "Notices updated", 0).show();
                    Frag_notice.this.load_notices();
                }
            }
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_notice.2 */
    class C05522 implements ErrorListener {
        C05522() {
        }

        public void onErrorResponse(VolleyError error) {
            Log.d("TAG", "no net err");
            Frag_notice.this.internet_status = 0;
            if (Frag_notice.this.is_active == 1) {
                Toast.makeText(Frag_notice.this.getActivity(), "Couldn't update.Check your internet connection and try again", 1).show();
            }
            if (Frag_notice.this.pD.isShowing()) {
                Frag_notice.this.pD.hide();
            }
        }
    }

    public Frag_notice() {
        this.is_first_time = true;
        this.is_active = 1;
        this.internet_status = 1;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f11v = inflater.inflate(C0337R.layout.content_notices, container, false);
        MainActivity.current_frag = 2;
        return this.f11v;
    }

    public void onPause() {
        this.is_first_time = false;
        this.pD.dismiss();
        unregister_receiver();
        Log.d("TAG", "On Pause called");
        this.is_active = 0;
        if (!(this.notice_name == null || this.notice_name.length == 0)) {
            Log.d("TAG", "saving data");
            save_data();
        }
        super.onPause();
    }

    public void onDestroy() {
        this.is_first_time = false;
        this.pD.dismiss();
        super.onDestroy();
    }

    public void onResume() {
        if (this.is_first_time) {
            this.pD = new ProgressDialog(getActivity());
            this.pD.setMessage("Please wait..");
            this.pD.setCancelable(false);
            this.pD.show();
        }
        this.which_feature = 1;
        load_saved_data();
        download_request();
        register_receiver();
        super.onResume();
    }

    public void download_request() {
        Log.d("TAG", "Functiona Called");
        Log.d("TAG", "Step 1");
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        Log.d("TAG", "Step 2");
        queue.add(new JsonArrayRequest("http://nitp.purush.xyz/app/notices.php", new C05511(), new C05522()));
        Log.d("TAG", "end");
    }

    public void load_notices() {
        Log.d("TAG", "load notices");
        ListView lv = (ListView) this.f11v.findViewById(C0337R.id.notices_list);
        this.context = getActivity();
        lv.setAdapter(new CustomAdapter(this.context, this.which_feature, this.notice_name, this.file_name, this.file_type, this.file_url, this.file_upload_date));
        if (this.pD.isShowing()) {
            this.pD.hide();
        }
    }

    public void save_data() {
        Editor editor = getActivity().getSharedPreferences("MY_PREFS", 0).edit();
        StringBuilder save_file_name = new StringBuilder();
        StringBuilder save_file_type = new StringBuilder();
        StringBuilder save_file_upload_date = new StringBuilder();
        StringBuilder save_file_url = new StringBuilder();
        StringBuilder save_notice_name = new StringBuilder();
        for (int i = 0; i < this.file_name.length; i++) {
            save_notice_name.append(this.notice_name[i]).append("#");
            save_file_name.append(this.file_name[i]).append("#");
            save_file_type.append(this.file_type[i]).append("#");
            save_file_url.append(this.file_url[i]).append("#");
            save_file_upload_date.append(this.file_upload_date[i]).append("#");
        }
        editor.putString("file_name", save_file_name.toString());
        editor.putString("notice_name", save_notice_name.toString());
        editor.putString("file_type", save_file_type.toString());
        editor.putString("file_url", save_file_url.toString());
        editor.putString("file_upload_date", save_file_upload_date.toString());
        editor.commit();
    }

    public void load_saved_data() {
        Log.d("TAG", "load_saved_data() called");
        SharedPreferences myshare = getActivity().getSharedPreferences("MY_PREFS", 0);
        this.saved_notice_name = myshare.getString("notice_name", BuildConfig.FLAVOR);
        String saved_file_name = myshare.getString("file_name", BuildConfig.FLAVOR);
        String saved_file_type = myshare.getString("file_type", BuildConfig.FLAVOR);
        String saved_file_url = myshare.getString("file_url", BuildConfig.FLAVOR);
        String saved_file_upload_date = myshare.getString("file_upload_date", BuildConfig.FLAVOR);
        Log.d("TAG", "saved_file_name.length() is " + saved_file_name.length());
        if (this.saved_notice_name.length() != 0) {
            this.notice_name = this.saved_notice_name.split("#");
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
                load_notices();
            }
        }
    }

    public void register_receiver() {
        Log.d("Broadcast", "Registering Receiver");
        IntentFilter intentFilter = new IntentFilter("xyz.purush.nitp.nitpatna.CUSTOM_INTENT");
        this.downloadCompleteReceiver = new C03343();
        getActivity().registerReceiver(this.downloadCompleteReceiver, intentFilter);
    }

    public void unregister_receiver() {
        Log.d("Broadcast", "Unregistering Receiver");
        getActivity().unregisterReceiver(this.downloadCompleteReceiver);
    }
}
