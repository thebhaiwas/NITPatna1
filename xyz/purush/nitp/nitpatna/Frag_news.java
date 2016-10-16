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

public class Frag_news extends Fragment {
    Context context;
    String[] date;
    int is_active;
    boolean is_first_time;
    String[] news_title;
    private ProgressDialog pD;
    private RequestQueue queue;
    String saved_news_title;
    View f10v;

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_news.1 */
    class C05491 implements Listener<JSONArray> {
        C05491() {
        }

        public void onResponse(JSONArray response) {
            if (response.length() > 0) {
                int size = response.length() - 1;
                Frag_news.this.news_title = new String[size];
                Frag_news.this.date = new String[size];
                int j = 0;
                while (j < size) {
                    try {
                        Log.d("TAG", "loop " + j);
                        JSONObject myObj = (JSONObject) response.get(j);
                        Frag_news.this.news_title[j] = myObj.getString("news_title");
                        Frag_news.this.date[j] = myObj.getString("date");
                        Log.d("TAG", Frag_news.this.date[j]);
                        Log.d("TAG", Frag_news.this.news_title[j]);
                        j++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (Frag_news.this.is_active == 1) {
                    Frag_news.this.load_view();
                    Toast.makeText(Frag_news.this.getActivity(), "News Updated", 0).show();
                }
            }
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Frag_news.2 */
    class C05502 implements ErrorListener {
        C05502() {
        }

        public void onErrorResponse(VolleyError error) {
            if (Frag_news.this.is_active == 1) {
                Toast.makeText(Frag_news.this.getActivity(), "Couldn't update.Check your internet connection and try again", 0).show();
            }
            if (Frag_news.this.pD.isShowing()) {
                Frag_news.this.pD.hide();
            }
        }
    }

    public Frag_news() {
        this.is_first_time = true;
        this.is_active = 1;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.current_frag = 1;
        this.f10v = inflater.inflate(C0337R.layout.content_news, container, false);
        return this.f10v;
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
        if (this.news_title != null && this.news_title.length > 0) {
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
        String url = "http://nitp.purush.xyz/app/news.php";
        if (this.queue == null) {
            this.queue = Volley.newRequestQueue(getActivity());
        }
        this.queue.add(new JsonArrayRequest(url, new C05491(), new C05502()));
    }

    public void load_view() {
        ListView lv = (ListView) this.f10v.findViewById(C0337R.id.news_list);
        this.context = getActivity();
        lv.setAdapter(new NewsAdapter(this.context, this.news_title, this.date));
        if (this.pD.isShowing()) {
            this.pD.hide();
        }
    }

    public void save_data() {
        Editor editor = getActivity().getSharedPreferences("MY_PREFS_NEWS", 0).edit();
        StringBuilder save_news_title = new StringBuilder();
        StringBuilder save_news_date = new StringBuilder();
        for (int i = 0; i < this.date.length; i++) {
            save_news_title.append(this.news_title[i]).append("#");
            save_news_date.append(this.date[i]).append("#");
        }
        editor.putString("news_title", save_news_title.toString());
        editor.putString("news_date", save_news_date.toString());
        editor.commit();
    }

    public void load_saved_data() {
        SharedPreferences myshare = getActivity().getSharedPreferences("MY_PREFS_NEWS", 0);
        this.saved_news_title = myshare.getString("news_title", BuildConfig.FLAVOR);
        String saved_news_date = myshare.getString("news_date", BuildConfig.FLAVOR);
        if (this.saved_news_title.length() != 0) {
            this.news_title = this.saved_news_title.split("#");
            this.date = saved_news_date.split("#");
            for (int i = 0; i < this.news_title.length; i++) {
                Log.d("TAG", "i is " + i);
                Log.d("TAG", this.news_title[i]);
                Log.d("TAG", this.date[i]);
            }
            if (this.is_active == 1) {
                load_view();
            }
        }
    }
}
