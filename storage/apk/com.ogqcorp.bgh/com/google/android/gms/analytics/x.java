// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import java.util.List;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import java.net.MalformedURLException;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpHost;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import android.text.TextUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import android.os.Build;
import java.util.Locale;
import android.os.Build$VERSION;
import java.net.URL;
import android.content.Context;
import org.apache.http.client.HttpClient;

class x implements as
{
    private final String a;
    private final HttpClient b;
    private final Context c;
    private c d;
    private URL e;
    
    x(final HttpClient httpClient, final Context context) {
        this(httpClient, com.google.android.gms.analytics.c.a(context), context);
    }
    
    x(final HttpClient b, final c d, final Context context) {
        this.c = context.getApplicationContext();
        this.a = this.a("GoogleAnalytics", "3.0", Build$VERSION.RELEASE, ab.a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.b = b;
        this.d = d;
    }
    
    private HttpEntityEnclosingRequest a(final String str, final String str2) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            p.d("Empty hit, discarding.");
            return null;
        }
        final String string = str2 + "?" + str;
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        if (string.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", string);
        }
        else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).setEntity((HttpEntity)new StringEntity(str));
            }
            catch (UnsupportedEncodingException ex) {
                p.d("Encoding error, discarding hit");
                return null;
            }
        }
        ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).addHeader("User-Agent", this.a);
        return (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest;
    }
    
    private void a(final q q, final URL url, final boolean b) {
        if (!TextUtils.isEmpty((CharSequence)q.a()) && this.b()) {
            while (true) {
                Label_0273: {
                    if (url != null) {
                        break Label_0273;
                    }
                    try {
                        if (this.e == null) {
                            goto Label_0216;
                        }
                        final URL e = this.e;
                        final HttpHost httpHost = new HttpHost(e.getHost(), e.getPort(), e.getProtocol());
                        try {
                            final HttpEntityEnclosingRequest a = this.a(q.a(), e.getPath());
                            if (a == null) {
                                return;
                            }
                            a.addHeader("Host", httpHost.toHostString());
                            if (p.a()) {
                                this.a(a);
                            }
                            if (b) {
                                au.b(this.c);
                            }
                            final HttpResponse execute = this.b.execute(httpHost, (HttpRequest)a);
                            final int statusCode = execute.getStatusLine().getStatusCode();
                            final HttpEntity entity = execute.getEntity();
                            if (entity != null) {
                                entity.consumeContent();
                            }
                            if (statusCode != 200) {
                                p.d("Bad response: " + execute.getStatusLine().getStatusCode());
                            }
                            return;
                        }
                        catch (ClientProtocolException ex2) {
                            p.d("ClientProtocolException sending monitoring hit.");
                            return;
                        }
                        catch (IOException ex) {
                            p.d("Exception sending monitoring hit: " + ex.getClass().getSimpleName());
                            p.d(ex.getMessage());
                            return;
                        }
                    }
                    catch (MalformedURLException ex3) {}
                }
                final URL e = url;
                continue;
            }
        }
    }
    
    private void a(final HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        final StringBuffer sb = new StringBuffer();
        final Header[] allHeaders = httpEntityEnclosingRequest.getAllHeaders();
        for (int length = allHeaders.length, i = 0; i < length; ++i) {
            sb.append(allHeaders[i].toString()).append("\n");
        }
        sb.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        while (true) {
            if (httpEntityEnclosingRequest.getEntity() == null) {
                break Label_0151;
            }
            try {
                final InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    final int available = content.available();
                    if (available > 0) {
                        final byte[] array = new byte[available];
                        content.read(array);
                        sb.append("POST:\n");
                        sb.append(new String(array)).append("\n");
                    }
                }
                p.c(sb.toString());
            }
            catch (IOException ex) {
                p.c("Error Writing hit to log...");
                continue;
            }
            break;
        }
    }
    
    @Override
    public int a(final List<bi> list, final q q, final boolean b) {
        int n = 0;
        final int min = Math.min(list.size(), 40);
        q.a("_hr", list.size());
        int n2 = 0;
        URL url = null;
        boolean b2 = true;
        int n4;
        URL url3;
        for (int i = 0; i < min; ++i, n = n4, url = url3) {
            final bi bi = list.get(i);
            final URL a = this.a(bi);
            if (a == null) {
                if (p.a()) {
                    p.d("No destination: discarding hit: " + bi.a());
                }
                else {
                    p.d("No destination: discarding hit.");
                }
                final int n3 = n + 1;
                ++n2;
                final URL url2 = url;
                n4 = n3;
                url3 = url2;
            }
            else {
                final HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                final String path = a.getPath();
                String a2;
                if (TextUtils.isEmpty((CharSequence)bi.a())) {
                    a2 = "";
                }
                else {
                    a2 = bj.a(bi, System.currentTimeMillis());
                }
                final HttpEntityEnclosingRequest a3 = this.a(a2, path);
                if (a3 == null) {
                    final int n5 = n + 1;
                    ++n2;
                    n4 = n5;
                    url3 = a;
                }
                else {
                    a3.addHeader("Host", httpHost.toHostString());
                    if (p.a()) {
                        this.a(a3);
                    }
                    Label_0292: {
                        if (a2.length() > 8192) {
                            p.d("Hit too long (> 8192 bytes)--not sent");
                            ++n2;
                        }
                        else if (this.d.b()) {
                            p.b("Dry run enabled. Hit not actually sent.");
                        }
                        else {
                            while (true) {
                                if (b2) {
                                    try {
                                        au.b(this.c);
                                        b2 = false;
                                        final HttpResponse execute = this.b.execute(httpHost, (HttpRequest)a3);
                                        final int statusCode = execute.getStatusLine().getStatusCode();
                                        final HttpEntity entity = execute.getEntity();
                                        if (entity != null) {
                                            entity.consumeContent();
                                        }
                                        if (statusCode != 200) {
                                            p.d("Bad response: " + execute.getStatusLine().getStatusCode());
                                        }
                                        break Label_0292;
                                    }
                                    catch (ClientProtocolException ex2) {
                                        p.d("ClientProtocolException sending hit; discarding hit...");
                                        q.a("_hd", n2);
                                        break Label_0292;
                                    }
                                    catch (IOException ex) {
                                        p.d("Exception sending hit: " + ex.getClass().getSimpleName());
                                        p.d(ex.getMessage());
                                        q.a("_de", 1);
                                        q.a("_hd", n2);
                                        q.a("_hs", n);
                                        this.a(q, a, b2);
                                        return n;
                                    }
                                    break;
                                }
                                continue;
                            }
                        }
                    }
                    q.a("_td", a2.getBytes().length);
                    n4 = n + 1;
                    url3 = a;
                }
            }
        }
        q.a("_hd", n2);
        q.a("_hs", n);
        if (b) {
            this.a(q, url, b2);
        }
        return n;
    }
    
    String a(final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", s, s2, s3, s4, s5, s6);
    }
    
    URL a(final bi bi) {
        if (this.e != null) {
            return this.e;
        }
        while (true) {
            final String d = bi.d();
            while (true) {
                try {
                    if ("http:".equals(d)) {
                        final String spec = "http://www.google-analytics.com/collect";
                        return new URL(spec);
                    }
                }
                catch (MalformedURLException ex) {
                    p.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
                    return null;
                }
                final String spec = "https://ssl.google-analytics.com/collect";
                continue;
            }
        }
    }
    
    @Override
    public void a(final String spec) {
        try {
            this.e = new URL(spec);
        }
        catch (MalformedURLException ex) {
            this.e = null;
        }
    }
    
    @Override
    public boolean a() {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            p.c("...no network connectivity");
            return false;
        }
        return true;
    }
    
    boolean b() {
        return 100.0 * Math.random() <= 1.0;
    }
}
