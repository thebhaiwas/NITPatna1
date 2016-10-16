package xyz.purush.nitp.nitpatna;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EventAdapter extends BaseAdapter {
    Context context;
    String[] event_date;
    String[] event_title;
    String[] event_venue;
    LayoutInflater inflater;

    /* renamed from: xyz.purush.nitp.nitpatna.EventAdapter.1 */
    class C03321 implements OnClickListener {
        C03321() {
        }

        public void onClick(View v) {
            Log.d("Download", "Clicled");
            Log.d("Download", "after Clicled");
        }
    }

    public static class ViewHolder {
        public TextView event_date;
        public TextView event_title;
        public TextView event_venue;
    }

    public EventAdapter(Context c, String[] _event_title, String[] _event_date, String[] _event_venue) {
        this.inflater = null;
        this.event_title = _event_title;
        this.event_date = _event_date;
        this.event_venue = _event_venue;
        this.context = c;
        this.inflater = (LayoutInflater) c.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.event_date.length;
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
            vi = this.inflater.inflate(C0337R.layout.events_itemlistrow, null);
            holder = new ViewHolder();
            holder.event_date = (TextView) vi.findViewById(C0337R.id.event_date);
            holder.event_title = (TextView) vi.findViewById(C0337R.id.event_title);
            holder.event_venue = (TextView) vi.findViewById(C0337R.id.event_venue);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
        holder.event_date.setText(this.event_date[position]);
        holder.event_title.setText(this.event_title[position]);
        holder.event_venue.setText(this.event_venue[position]);
        vi.setOnClickListener(new C03321());
        return vi;
    }
}
