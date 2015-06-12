// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpEntity;
import java.io.IOException;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import com.socialnmobile.colornote.receiver.AutoSyncReceiver;
import android.util.Log;
import java.util.Locale;
import android.text.format.Time;
import java.util.Map;
import java.util.HashMap;
import android.content.Context;
import android.text.format.DateUtils;
import android.os.Handler;
import android.app.Application;

public class ColorNote extends Application
{
    static String a;
    public static ColorNote b;
    Handler c;
    
    public ColorNote() {
        this.c = new Handler();
    }
    
    public static String a(final long n) {
        return DateUtils.formatDateTime((Context)ColorNote.b, n, 17);
    }
    
    public static final void a() {
    }
    
    public static final void a(final Context context, final String obj, final String str) {
        try {
            final HashMap hashMap = new HashMap();
            a(context, hashMap);
            eg.a(String.valueOf(obj) + " " + str, hashMap);
        }
        catch (RuntimeException ex) {}
    }
    
    public static final void a(final Context context, final String s, final String s2, final String s3, final String s4) {
        try {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put(s3, s4);
            a(context, s, s2, hashMap);
        }
        catch (RuntimeException ex) {}
    }
    
    public static final void a(final Context context, final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        try {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put(s3, s4);
            hashMap.put(s5, s6);
            a(context, s, s2, hashMap);
        }
        catch (RuntimeException ex) {}
    }
    
    public static final void a(final Context context, final String obj, final String str, final Map map) {
        try {
            a(context, map);
            eg.a(String.valueOf(obj) + " " + str, map);
        }
        catch (RuntimeException ex) {}
    }
    
    private static void a(final Context context, final Map map) {
        if (context != null && ColorNote.a == null) {
            final long b = jo.b(context, "APP_INSTALL_TIME_MILLIS");
            if (b != 0L) {
                final Time time = new Time();
                time.set(b);
                ColorNote.a = String.format(Locale.US, "%d-%02d", time.year, 1 + time.month);
            }
        }
        if (ColorNote.a != null) {
            map.put("installMonth", ColorNote.a);
        }
    }
    
    public static final void a(final String s) {
        Log.e("ColorNote", s);
    }
    
    public static final void b() {
    }
    
    public static void b(final String s) {
        if (ColorNote.b != null && ColorNote.b.c != null) {
            ColorNote.b.c.post((Runnable)new gp(s));
        }
    }
    
    public static final void c() {
    }
    
    public static final void d() {
    }
    
    public static ColorNote e() {
        return ColorNote.b;
    }
    
    public static void f() {
        new gq((byte)0).execute((Object[])new String[0]);
    }
    
    public static void g() {
        kr.a();
        gu.a((Context)ColorNote.b);
        AutoSyncReceiver.a((Context)ColorNote.b);
    }
    
    public static void h() {
        final ColorNote b = ColorNote.b;
        long n = jo.b((Context)b, "CLIENT_RELEASES_SAVE_TIME");
        if (n == 0L) {
            n = jo.b((Context)b, "APP_INSTALL_TIME_MILLIS");
        }
        if (System.currentTimeMillis() - n > 1296000000L && n != 0L) {
            try {
                final HttpEntity entity = ((HttpClient)new tr((Context)ColorNote.b).b()).execute(new wv().b(), (HttpRequest)new HttpGet("/support/client-releases-v8")).getEntity();
                to to;
                if (entity == null) {
                    to = null;
                }
                else {
                    final String string = EntityUtils.toString(entity);
                    if (string == null) {
                        to = null;
                    }
                    else {
                        final xj a = to.a(string);
                        if (a == null) {
                            to = null;
                        }
                        else {
                            to = new to(a);
                        }
                    }
                }
                if (to != null) {
                    jo.a((Context)ColorNote.b, to);
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            catch (ux ux) {
                ux.printStackTrace();
            }
            catch (RuntimeException ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    public void onCreate() {
        (ColorNote.b = this).onCreate();
        kr.a(new Handler());
        gw.a();
        this.getContentResolver().getType(kf.a);
        eg.d();
        eg.c();
        eg.b();
    }
}
