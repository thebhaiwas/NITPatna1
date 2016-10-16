package xyz.purush.nitp.nitpatna;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    String[] news_date;
    String[] news_title;

    /* renamed from: xyz.purush.nitp.nitpatna.NewsAdapter.1 */
    class C03351 implements OnClickListener {
        C03351() {
        }

        public void onClick(View v) {
            Log.d("Download", "Clicled");
            Log.d("Download", "after Clicled");
        }
    }

    public static class ViewHolder {
        public TextView news_date;
        public TextView news_title;
    }

    public NewsAdapter(Context c, String[] _news_title, String[] _news_date) {
        this.inflater = null;
        this.news_title = _news_title;
        this.news_date = _news_date;
        this.context = c;
        this.inflater = (LayoutInflater) c.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.news_date.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View vi = convertView;
        if (convertView == null) {
            vi = this.inflater.inflate(C0337R.layout.news_itemlistrow, null);
            holder = new ViewHolder();
            holder.news_date = (TextView) vi.findViewById(C0337R.id.news_date);
            holder.news_title = (TextView) vi.findViewById(C0337R.id.news_title);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
        holder.news_date.setText(this.news_date[position]);
        holder.news_title.setText(this.news_title[position]);
        vi.setOnClickListener(new C03351());
        return vi;
    }
}
