package xyz.purush.nitp.nitpatna;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag_home extends Fragment {
    Context f8c;
    View f9v;

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f9v = inflater.inflate(C0337R.layout.content_home, container, false);
        return this.f9v;
    }

    public void onResume() {
        MainActivity.current_frag = 0;
        super.onResume();
    }
}
