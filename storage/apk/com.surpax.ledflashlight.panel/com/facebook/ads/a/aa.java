// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.apache.http.client.HttpClient;
import java.util.Iterator;
import android.util.Log;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.net.URLEncoder;
import java.util.Map;
import android.os.AsyncTask;

public class aa extends AsyncTask
{
    private static final String a;
    private Map b;
    
    static {
        a = aa.class.getSimpleName();
    }
    
    public aa() {
        this.b = null;
    }
    
    private static String a(final String s) {
        try {
            return a(s, "analog", r.a(com.facebook.ads.a.a.a()));
        }
        catch (Exception ex) {
            d.a(c.a(ex));
            return s;
        }
    }
    
    private static String a(final String str, final String str2, final String s) {
        if (ab.a(str) || ab.a(str2) || ab.a(s)) {
            return str;
        }
        String str3;
        if (str.contains("?")) {
            str3 = "&";
        }
        else {
            str3 = "?";
        }
        return str + str3 + str2 + "=" + URLEncoder.encode(s);
    }
    
    private Void a(final String... array) {
        final String s = array[0];
        if (ab.a(s) || s.equals("#")) {
            return null;
        }
        final String a = a(s);
        String a2;
        if (this.b != null) {
            final Iterator<String> iterator = this.b.keySet().iterator();
            a2 = a;
            while (iterator.hasNext()) {
                final String s2 = iterator.next();
                a2 = a(a2, s2, (String)this.b.get(s2));
            }
        }
        else {
            a2 = a;
        }
        final DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        final HttpGet httpGet = new HttpGet(a2);
        try {
            ((HttpClient)defaultHttpClient).execute((HttpUriRequest)httpGet);
            return null;
        }
        catch (Exception ex) {
            Log.e(aa.a, "Error opening url: " + a2, (Throwable)ex);
            d.a(c.a(ex));
            return null;
        }
    }
}
