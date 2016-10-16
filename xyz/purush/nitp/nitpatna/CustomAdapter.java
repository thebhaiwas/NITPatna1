package xyz.purush.nitp.nitpatna;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;

public class CustomAdapter extends BaseAdapter {
    Activity activity;
    Context context;
    download_handler dh;
    String[] file_name;
    String[] file_type;
    String[] file_upload_date;
    String[] file_url;
    LayoutInflater inflater;
    String[] notice_name;
    int which_feature;

    /* renamed from: xyz.purush.nitp.nitpatna.CustomAdapter.1 */
    class C03311 implements OnClickListener {
        final /* synthetic */ int val$position;

        C03311(int i) {
            this.val$position = i;
        }

        public void onClick(View v) {
            Log.d("Download", "Clicled");
            new download_handler().download_handler(CustomAdapter.this.context, CustomAdapter.this.which_feature, this.val$position, CustomAdapter.this.file_name[this.val$position], CustomAdapter.this.file_url[this.val$position], CustomAdapter.this.file_type[this.val$position], CustomAdapter.this.notice_name[this.val$position]);
            Log.d("Download", "after Clicled");
        }
    }

    public static class ViewHolder {
        public ImageView iv;
        public ImageView iv2;
        public TextView tv;
        public TextView tv_upload_date;
    }

    public CustomAdapter(Context c, int _which_feature, String[] _notice_name, String[] _file_name, String[] _file_type, String[] _file_url, String[] _file_upload_date) {
        this.inflater = null;
        this.which_feature = _which_feature;
        this.notice_name = _notice_name;
        this.file_name = _file_name;
        this.file_type = _file_type;
        this.file_upload_date = _file_upload_date;
        this.file_url = _file_url;
        this.context = c;
        this.inflater = (LayoutInflater) c.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.file_name.length;
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
            vi = this.inflater.inflate(C0337R.layout.notices_itemlistrow, null);
            holder = new ViewHolder();
            holder.tv = (TextView) vi.findViewById(C0337R.id.file_name);
            holder.tv_upload_date = (TextView) vi.findViewById(C0337R.id.file_upload_date);
            holder.iv = (ImageView) vi.findViewById(C0337R.id.img_file_type);
            holder.iv2 = (ImageView) vi.findViewById(C0337R.id.file_status);
            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }
        holder.tv.setText(this.notice_name[position]);
        holder.tv_upload_date.setText(this.file_upload_date[position]);
        if (this.file_type[position].equals("pdf")) {
            holder.iv.setImageResource(C0337R.drawable.pdf);
        } else if (this.file_type[position].equals("png")) {
            holder.iv.setImageResource(C0337R.drawable.png);
        } else if (this.file_type[position].equals("jpeg") || this.file_type[position].equals("jpg")) {
            holder.iv.setImageResource(C0337R.drawable.jpg);
        }
        Log.d("MTAG", this.file_name[position] + "file name is ");
        String _temp_file_name = this.file_name[position];
        if (new File(Environment.getExternalStoragePublicDirectory("/nitp").getAbsolutePath() + "/" + _temp_file_name).exists()) {
            holder.iv2.setImageResource(C0337R.drawable.ic_folder);
            Log.d("MTAG", "File exist " + _temp_file_name);
        }
        Log.d("XTAG", "Position is " + position);
        vi.setOnClickListener(new C03311(position));
        return vi;
    }
}
