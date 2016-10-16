package xyz.purush.nitp.nitpatna;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
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

public class Frag_events extends Fragment {
    Context context;
    String[] event_date;
    String[] event_title;
    String[] event_venue;
    int is_active;
    boolean is_first_time;
    private ProgressDialog pD;
    private RequestQueue queue;
    String saved_event_date;
    String saved_event_title;
    String saved_event_venue;
    View f7v;

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_events.1 */
    class C05471 implements Listener<JSONArray> {
        C05471() {
        }

        public void onResponse(JSONArray response) {
            Log.d("TAG", "respones");
            if (response.length() > 0) {
                int size = response.length() - 1;
                Frag_events.this.event_title = new String[size];
                Frag_events.this.event_date = new String[size];
                Frag_events.this.event_venue = new String[size];
                int j = 0;
                while (j < size) {
                    try {
                        Log.d("TAG", "loop " + j);
                        JSONObject myObj = (JSONObject) response.get(j);
                        Frag_events.this.event_title[j] = myObj.getString("event_title");
                        Frag_events.this.event_date[j] = myObj.getString("event_date");
                        Frag_events.this.event_venue[j] = myObj.getString("event_venue");
                        Log.d("TAG", Frag_events.this.event_date[j]);
                        Log.d("TAG", Frag_events.this.event_title[j]);
                        Log.d("TAG", Frag_events.this.event_venue[j]);
                        j++;
                    } catch (JSONException e) {
                        Log.e("TAG", "Error Event catch");
                        e.printStackTrace();
                    }
                }
                if (Frag_events.this.is_active == 1) {
                    Frag_events.this.load_view();
                    Toast.makeText(Frag_events.this.getActivity(), "Events Updated", 0).show();
                }
            }
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_events.2 */
    class C05482 implements ErrorListener {
        C05482() {
        }

        public void onErrorResponse(VolleyError error) {
            if (Frag_events.this.is_active == 1) {
                Toast.makeText(Frag_events.this.getActivity(), "Couldn't update.Check your internet connection and try again", 0).show();
            }
            if (Frag_events.this.pD.isShowing()) {
                Frag_events.this.pD.hide();
            }
        }
    }

    public Frag_events() {
        this.is_active = 1;
        this.is_first_time = true;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.current_frag = 4;
        this.f7v = inflater.inflate(C0337R.layout.content_events, container, false);
        return this.f7v;
    }

    public void onResume() {
        if (this.is_first_time) {
            this.pD = new ProgressDialog(getActivity());
            this.pD.setMessage("Please wait...");
            this.pD.setCancelable(true);
            this.pD.show();
        }
        this.is_active = 1;
        load_saved_data();
        download_request();
        super.onResume();
    }

    public void onPause() {
        this.is_first_time = false;
        this.pD.dismiss();
        this.is_active = 0;
        Log.d("TAG", "On Pause");
        if (this.event_title != null && this.event_title.length > 0) {
            save_data();
        }
        super.onPause();
    }

    public void onDestroy() {
        this.is_first_time = false;
        this.pD.dismiss();
        super.onDestroy();
    }

    public void download_request() {
        String url = "http://nitp.purush.xyz/app/events.php";
        if (this.queue == null) {
            this.queue = Volley.newRequestQueue(getActivity());
        }
        this.queue.add(new JsonArrayRequest(url, new C05471(), new C05482()));
    }

    public void load_view() {
        ListView lv = (ListView) this.f7v.findViewById(C0337R.id.events_list);
        this.context = getActivity();
        lv.setAdapter(new EventAdapter(this.context, this.event_title, this.event_date, this.event_venue));
        if (this.pD.isShowing()) {
            this.pD.hide();
        }
    }

    public void save_data() {
        Log.d("TAG", "Save data called");
        Editor editor = getActivity().getSharedPreferences("MY_PREFS_EVENTS", 0).edit();
        StringBuilder save_event_title = new StringBuilder();
        StringBuilder save_event_date = new StringBuilder();
        StringBuilder save_event_venue = new StringBuilder();
        for (int i = 0; i < this.event_date.length; i++) {
            save_event_title.append(this.event_title[i]).append("#");
            save_event_date.append(this.event_date[i]).append("#");
            save_event_venue.append(this.event_venue[i]).append("#");
        }
        editor.putString("event_title", save_event_title.toString());
        editor.putString("event_date", save_event_date.toString());
        editor.putString("event_venue", save_event_venue.toString());
        editor.commit();
    }

    public void load_saved_data() {
        SharedPreferences myshare = getActivity().getSharedPreferences("MY_PREFS_EVENTS", 0);
        this.saved_event_title = myshare.getString("event_title", BuildConfig.FLAVOR);
        this.saved_event_date = myshare.getString("event_date", BuildConfig.FLAVOR);
        this.saved_event_venue = myshare.getString("event_venue", BuildConfig.FLAVOR);
        if (this.saved_event_title.length() > 0) {
            this.event_title = this.saved_event_title.split("#");
            this.event_date = this.saved_event_date.split("#");
            this.event_venue = this.saved_event_venue.split("#");
            for (int i = 0; i < this.event_title.length; i++) {
                Log.d("TAG", "i is " + i);
                Log.d("TAG", this.event_title[i]);
                Log.d("TAG", this.event_date[i]);
                Log.d("TAG", this.event_venue[i]);
            }
            if (this.is_active == 1) {
                load_view();
            }
        }
    }
}
