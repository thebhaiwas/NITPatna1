package xyz.purush.nitp.nitpatna;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class about_us extends AppCompatActivity {
    Context f18c;

    /* renamed from: xyz.purush.nitp.nitpatna.about_us.1 */
    class C03391 implements OnClickListener {
        C03391() {
        }

        public void onClick(View v) {
            extra_methods.check_for_update(about_us.this.f18c);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        this.f18c = this;
        super.onCreate(savedInstanceState);
        setContentView((int) C0337R.layout.activity_about_us);
        ((Button) findViewById(C0337R.id.check_for_update)).setOnClickListener(new C03391());
    }
}
