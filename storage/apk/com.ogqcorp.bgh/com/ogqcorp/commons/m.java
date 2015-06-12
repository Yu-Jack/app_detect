// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.os.Parcelable;
import android.content.Intent;
import java.util.HashMap;
import org.codehaus.jackson.c.an;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import android.net.Uri;
import android.content.Context;
import java.util.Map;
import java.util.ArrayList;

public final class m
{
    private String a;
    private ArrayList<Map<String, String>> b;
    
    public m() {
        this.b = new ArrayList<Map<String, String>>();
    }
    
    private Uri a(final Context context) {
        final StringBuilder b = this.b(context);
        a(b, "msg", this.a);
        a(b, this.b);
        return Uri.parse(b.toString());
    }
    
    private static void a(final StringBuilder sb, final String str, final String s) {
        try {
            sb.append(str).append('=').append(URLEncoder.encode(s, "UTF-8")).append('&');
        }
        catch (UnsupportedEncodingException ex) {
            n.b(ex);
        }
    }
    
    private static void a(final StringBuilder sb, final List<Map<String, String>> list) {
        try {
            a(sb, "metainfo", "{\"metainfo\":" + new an().a(list) + "}");
        }
        catch (Exception ex) {
            n.b(ex);
        }
    }
    
    private StringBuilder b(final Context context) {
        int i = 0;
        final StringBuilder sb = new StringBuilder("kakaolink://sendurl?");
        for (String[] array = { "apiver", "2.0", "type", "app", "appid", context.getPackageName(), "appname", d(context), "appver", c(context) }; i < array.length; i += 2) {
            a(sb, array[i + 0], array[i + 1]);
        }
        return sb;
    }
    
    private static String c(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (Exception ex) {
            n.a(ex);
            return "";
        }
    }
    
    private static String d(final Context context) {
        try {
            return context.getString(context.getApplicationInfo().labelRes);
        }
        catch (Exception ex) {
            n.a(ex);
            return "";
        }
    }
    
    public m a(final String a) {
        this.a = a;
        return this;
    }
    
    public m a(final String s, final String s2, final String s3, final String s4) {
        int i = 0;
        final HashMap<String, String> e = new HashMap<String, String>();
        for (String[] array = { "os", s, "devicetype", s2, "installurl", s3, "executeurl", s4 }; i < array.length; i += 2) {
            e.put(array[i + 0], array[i + 1]);
        }
        this.b.add(e);
        return this;
    }
    
    public void a(final Context context, final Intent intent) {
        new o().a(context, "context").a(intent, "chooserIntent");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])new Intent[] { new Intent("android.intent.action.SEND", this.a(context)) });
    }
}
