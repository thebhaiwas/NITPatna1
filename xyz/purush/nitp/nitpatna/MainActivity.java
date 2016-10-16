package xyz.purush.nitp.nitpatna;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    public static int current_frag;
    private GoogleApiClient client;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int my_prem;
    View vv;

    public MainActivity() {
        this.vv = null;
    }

    static {
        current_frag = 0;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0337R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(C0337R.id.toolbar);
        setSupportActionBar(toolbar);
        FirebaseMessaging.getInstance().subscribeToTopic("test");
        FirebaseInstanceId.getInstance().getToken();
        DrawerLayout drawer = (DrawerLayout) findViewById(C0337R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0337R.string.navigation_drawer_open, C0337R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        ((NavigationView) findViewById(C0337R.id.nav_view)).setNavigationItemSelectedListener(this);
        checkPermission();
        this.client = new Builder(this).addApi(AppIndex.API).build();
    }

    protected void onResume() {
        this.fragmentManager = getFragmentManager();
        this.fragmentTransaction = this.fragmentManager.beginTransaction();
        if (this.fragmentManager.findFragmentById(C0337R.id.wrapper_container) != null) {
            Log.d("Frag", "not null");
        } else {
            current_frag = 0;
            Log.d("Frag", "null");
            this.fragmentTransaction.add(C0337R.id.wrapper_container, new Frag_home(), "frag");
            this.fragmentTransaction.commit();
        }
        super.onResume();
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(C0337R.id.drawer_layout);
        if (drawer.isDrawerOpen((int) GravityCompat.START)) {
            drawer.closeDrawer((int) GravityCompat.START);
        } else if (current_frag != 0) {
            home();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0337R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id != C0337R.id.action_settings) {
            if (id != C0337R.id.action_terms_of_use) {
                if (id != C0337R.id.check_for_update_item) {
                    if (id == C0337R.id.action_refresh) {
                        Log.d("refresh", "onNavigationItemSelected: " + current_frag);
                        switch (current_frag) {
                            case ConnectionResult.SUCCESS /*0*/:
                                home();
                                break;
                            case ConnectionResult.SERVICE_MISSING /*1*/:
                                open_news(this.vv);
                                break;
                            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                                open_notices(this.vv);
                                break;
                            case ConnectionResult.SERVICE_DISABLED /*3*/:
                                open_downloads(this.vv);
                                break;
                            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                                open_events(this.vv);
                                break;
                            default:
                                break;
                        }
                    }
                }
                extra_methods.check_for_update(this);
            } else {
                extra_methods.terms_of_use(this);
            }
        } else {
            extra_methods.feedback(this);
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0337R.id.nav_home) {
            set_view(0);
        } else if (id == C0337R.id.nav_news) {
            if (current_frag != 1) {
                set_view(1);
            }
        } else if (id == C0337R.id.nav_notices) {
            if (current_frag != 2) {
                set_view(2);
            }
        } else if (id == C0337R.id.nav_downloads) {
            if (current_frag != 3) {
                set_view(3);
            }
        } else if (id == C0337R.id.nav_events) {
            if (current_frag != 4) {
                set_view(4);
            }
        } else if (id == C0337R.id.nav_quespapers) {
            set_view(5);
        } else if (id == C0337R.id.Chanakya_Portal) {
            extra_methods.open_chanakya_portal(this);
        } else if (id == C0337R.id.College_website) {
            extra_methods.open_college_website(this);
        } else if (id == C0337R.id.about_us) {
            extra_methods.about_us(this);
        } else if (id == C0337R.id.corona) {
            extra_methods.corona(this);
        } else if (id == C0337R.id.melange) {
            extra_methods.melange(this);
        }
        ((DrawerLayout) findViewById(C0337R.id.drawer_layout)).closeDrawer((int) GravityCompat.START);
        return true;
    }

    public void set_view(int which) {
        switch (which) {
            case ConnectionResult.SUCCESS /*0*/:
                getSupportActionBar().setTitle((CharSequence) "NIT PATNA");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(C0337R.id.wrapper_container, new Frag_home());
                ft.commit();
            case ConnectionResult.SERVICE_MISSING /*1*/:
                getSupportActionBar().setTitle((CharSequence) "NEWS");
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(C0337R.id.wrapper_container, new Frag_news(), "frag_news");
                ft1.commit();
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                getSupportActionBar().setTitle((CharSequence) "NOTICES");
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(C0337R.id.wrapper_container, new Frag_notice(), "frag_notice");
                ft2.commit();
            case ConnectionResult.SERVICE_DISABLED /*3*/:
                getSupportActionBar().setTitle((CharSequence) "DOWNLOADS");
                FragmentTransaction ft3 = getFragmentManager().beginTransaction();
                ft3.replace(C0337R.id.wrapper_container, new Frag_downloads(), "frag_downloads");
                ft3.commit();
            case ConnectionResult.SIGN_IN_REQUIRED /*4*/:
                getSupportActionBar().setTitle((CharSequence) "EVENTS");
                FragmentTransaction ft4 = getFragmentManager().beginTransaction();
                ft4.replace(C0337R.id.wrapper_container, new Frag_events(), "frag_events");
                ft4.commit();
            case ConnectionResult.INVALID_ACCOUNT /*5*/:
                getSupportActionBar().setTitle((CharSequence) "QUESTION PAPERS");
                FragmentTransaction ft5 = getFragmentManager().beginTransaction();
                ft5.replace(C0337R.id.wrapper_container, new Frag_quespaper(), "frag_ques_papaer");
                ft5.commit();
            default:
                Toast.makeText(this, "Application Internal error!", 0).show();
        }
    }

    public void open_notices(View view) {
        NavigationView navigationView = (NavigationView) findViewById(C0337R.id.nav_view);
        set_view(2);
        navigationView.getMenu().getItem(2).setChecked(true);
    }

    public void open_downloads(View view) {
        NavigationView navigationView = (NavigationView) findViewById(C0337R.id.nav_view);
        set_view(3);
        navigationView.getMenu().getItem(3).setChecked(true);
    }

    public void open_events(View view) {
        NavigationView navigationView = (NavigationView) findViewById(C0337R.id.nav_view);
        set_view(4);
        navigationView.getMenu().getItem(4).setChecked(true);
    }

    public void open_news(View view) {
        NavigationView navigationView = (NavigationView) findViewById(C0337R.id.nav_view);
        set_view(1);
        navigationView.getMenu().getItem(1).setChecked(true);
    }

    public void home() {
        NavigationView navigationView = (NavigationView) findViewById(C0337R.id.nav_view);
        set_view(0);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            Log.d("TAG", "Requesting Permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, this.my_prem);
        } else {
            Log.d("TAG", "Permissions Already Granted");
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            Log.d("TAG", "Requesting Permission");
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, this.my_prem);
            return;
        }
        Log.d("TAG", "Permissions Already Granted");
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            Log.d("TAG", "Permission Denied");
        } else {
            Log.d("TAG", "Permission Granted");
        }
    }

    public void onStart() {
        super.onStart();
        this.client.connect();
        AppIndex.AppIndexApi.start(this.client, Action.newAction(Action.TYPE_VIEW, "Main Page", Uri.parse("http://host/path"), Uri.parse("android-app://xyz.purush.nitp.nitpatna/http/host/path")));
    }

    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(this.client, Action.newAction(Action.TYPE_VIEW, "Main Page", Uri.parse("http://host/path"), Uri.parse("android-app://xyz.purush.nitp.nitpatna/http/host/path")));
        this.client.disconnect();
    }

    protected void onPause() {
        super.onPause();
    }
}
