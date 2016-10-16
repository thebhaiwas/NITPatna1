package xyz.purush.nitp.nitpatna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Welcome extends AppCompatActivity {
    boolean all_ok;
    boolean is_active;
    int my_prem;
    private ProgressDialog pD;
    String register_response;
    String s_email;
    String s_name;
    String s_roll_no;
    String ss_email;
    String ss_name;
    String ss_roll_no;

    /* renamed from: xyz.purush.nitp.nitpatna.Welcome.1 */
    class C03381 implements OnClickListener {
        C03381() {
        }

        public void onClick(View v) {
            Log.d("TAG", "onClick: onclick");
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://nitp.purush.xyz/terms_of_use"));
            Welcome.this.startActivity(intent);
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Welcome.2 */
    class C05532 implements Listener<String> {
        C05532() {
        }

        public void onResponse(String response) {
            Welcome.this.register_response = response;
            Log.d("TAG", "onResponse: " + Welcome.this.register_response);
            if (Welcome.this.register_response.equals("1")) {
                Log.d("TAG", "Response 1");
                Welcome.this.register_success();
                return;
            }
            if (Welcome.this.pD.isShowing()) {
                Welcome.this.pD.hide();
            }
            Log.d("TAG", "Response not 1");
            if (Welcome.this.is_active) {
                Toast.makeText(Welcome.this, "Error. Please Try Again Later", 0).show();
            }
        }
    }

    /* renamed from: xyz.purush.nitp.nitpatna.Welcome.3 */
    class C05543 implements ErrorListener {
        C05543() {
        }

        public void onErrorResponse(VolleyError error) {
            if (Welcome.this.pD.isShowing()) {
                Welcome.this.pD.hide();
            }
            Log.d("TAG", "Can not register. Please try Again");
            if (Welcome.this.is_active) {
                Toast.makeText(Welcome.this, "Please Try Again2", 0).show();
            }
        }
    }

    public Welcome() {
        this.all_ok = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0337R.layout.activity_welcome);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_PHONE_STATE") == -1) {
            Log.d("TAG", "Requesting Permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_PHONE_STATE"}, this.my_prem);
        } else {
            Log.d("TAG", "Permissions Already Granted");
        }
        Log.d("TAG", "onCreate: pD");
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            Log.d("TAG", "Permission Denied");
            finish();
            return;
        }
        Log.d("TAG", "Permission Granted");
    }

    public void next(View v) {
        Log.d("TAG", "next: called");
        EditText roll_no = (EditText) findViewById(C0337R.id.roll_no);
        EditText email = (EditText) findViewById(C0337R.id.email);
        this.s_name = ((EditText) findViewById(C0337R.id.name)).getText().toString();
        this.s_roll_no = roll_no.getText().toString();
        this.s_email = email.getText().toString();
        if (this.s_name.length() <= 0 || this.s_email.length() <= 0) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Please fill all information.");
        } else if (this.s_email.length() < 6) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Incorrect email.");
        } else if (!this.s_email.contains(".")) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Incorrect email.");
        } else if (!this.s_email.contains("@")) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Incorrect email.");
        } else if (this.s_name.length() < 6) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Please provide full name.");
        } else if (this.s_email.contains(" ")) {
            ((TextView) findViewById(C0337R.id.error_msg)).setText("Incorrect email.");
        } else {
            this.all_ok = true;
        }
        if (this.all_ok) {
            this.pD.setMessage("Please wait...");
            this.pD.setCancelable(true);
            this.pD.show();
            this.ss_name = this.s_name.replaceAll(" ", "%20");
            this.ss_email = this.s_email.replaceAll(" ", "%20");
            this.ss_roll_no = this.s_roll_no.replaceAll(" ", "%20");
            register();
        }
    }

    protected void onResume() {
        this.pD = new ProgressDialog(this);
        this.is_active = true;
        ((TextView) findViewById(C0337R.id.text_v2)).setOnClickListener(new C03381());
        super.onResume();
    }

    protected void onPause() {
        this.pD.dismiss();
        this.is_active = false;
        super.onPause();
    }

    protected void onDestroy() {
        this.pD.dismiss();
        super.onDestroy();
    }

    public void register() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://nitp.purush.xyz/user/register.php?name=" + this.ss_name + "&&roll_no=" + this.ss_roll_no + "&&email=" + this.ss_email + "&&device_id=" + ((TelephonyManager) getBaseContext().getSystemService("phone")).getDeviceId();
        Log.d("TAG", "register: " + url);
        queue.add(new StringRequest(url, new C05532(), new C05543()));
        Log.d("TAG", "end");
    }

    private void register_success() {
        if (this.pD.isShowing()) {
            this.pD.hide();
        }
        Log.d("TAG", "register_success: ");
        Editor editor = getSharedPreferences("FIRST_TIME_DATA", 0).edit();
        editor.putInt("FIRST_TIME", 0);
        editor.commit();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
