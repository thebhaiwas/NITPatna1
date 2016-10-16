package xyz.purush.nitp.nitpatna;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class extra_methods {
    Context context;

    public static void open_chanakya_portal(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://exam.nitp.ac.in:9001"));
        c.startActivity(intent);
    }

    public static void open_college_website(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://nitp.ac.in"));
        c.startActivity(intent);
    }

    public static void feedback(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://nitp.purush.xyz/feedback"));
        c.startActivity(intent);
    }

    public static void terms_of_use(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://nitp.purush.xyz/terms_of_use"));
        c.startActivity(intent);
    }

    public static void corona(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://corona.nitp.ac.in"));
        c.startActivity(intent);
    }

    public static void melange(Context c) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://melange.nitp.ac.in"));
        c.startActivity(intent);
    }

    public static void check_for_update(Context c) {
        String appPackageName = c.getPackageName();
        try {
            c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + appPackageName)));
        } catch (ActivityNotFoundException e) {
            c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    public static void about_us(Context c) {
        c.startActivity(new Intent(c, about_us.class));
    }
}
