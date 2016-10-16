package xyz.purush.nitp.nitpatna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0337R.layout.activity_home);
        int is_first_time = getSharedPreferences("FIRST_TIME_DATA", 0).getInt("FIRST_TIME", 1);
        Log.d("TAG", "onCreate: " + is_first_time);
        if (is_first_time == 1) {
            startActivity(new Intent(this, Welcome.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        finish();
    }
}
