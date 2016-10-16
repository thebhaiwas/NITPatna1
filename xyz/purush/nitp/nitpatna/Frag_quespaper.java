package xyz.purush.nitp.nitpatna;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag_quespaper extends Fragment {
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.current_frag = 7;
        return inflater.inflate(C0337R.layout.content_quespaper, container, false);
    }
}
