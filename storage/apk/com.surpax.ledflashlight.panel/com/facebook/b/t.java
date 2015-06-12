// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import com.facebook.ak;
import java.net.URI;
import java.net.URL;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import android.content.Context;

class t
{
    static final String a;
    private static volatile c b;
    
    static {
        a = t.class.getSimpleName();
    }
    
    static InputStream a(final Context context, final HttpURLConnection httpURLConnection) {
        final int responseCode = httpURLConnection.getResponseCode();
        InputStream inputStream = null;
        if (responseCode != 200) {
            return inputStream;
        }
        final URL url = httpURLConnection.getURL();
        inputStream = httpURLConnection.getInputStream();
        try {
            if (a(url.toURI())) {
                inputStream = b(context).a(url.toString(), new u(inputStream, httpURLConnection));
            }
            return inputStream;
        }
        catch (URISyntaxException ex) {
            return inputStream;
        }
        catch (IOException ex2) {
            return inputStream;
        }
    }
    
    static InputStream a(final URI uri, final Context context) {
        InputStream a = null;
        if (uri == null) {
            return a;
        }
        final boolean a2 = a(uri);
        a = null;
        if (!a2) {
            return a;
        }
        try {
            a = b(context).a(uri.toString());
            return a;
        }
        catch (IOException ex) {
            v.a(ak.d, 5, t.a, ex.toString());
            return null;
        }
    }
    
    static void a(final Context context) {
        try {
            b(context).a();
        }
        catch (IOException ex) {
            v.a(ak.d, 5, t.a, "clearCache failed " + ex.getMessage());
        }
    }
    
    private static boolean a(final URI uri) {
        if (uri != null) {
            final String host = uri.getHost();
            if (host.endsWith("fbcdn.net") || (host.startsWith("fbcdn") && host.endsWith("akamaihd.net"))) {
                return true;
            }
        }
        return false;
    }
    
    private static c b(final Context context) {
        synchronized (t.class) {
            if (t.b == null) {
                t.b = new c(context.getApplicationContext(), t.a, new g());
            }
            return t.b;
        }
    }
}
