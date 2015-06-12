// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import org.apache.http.client.methods.HttpGet;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.a.b.a.a.g;
import java.util.HashMap;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.client.HttpClient;
import org.a.b.a.a.a.e;
import org.a.b.a.a.a.d;
import java.io.File;
import org.a.b.a.a.a.b;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpException;
import java.util.Locale;
import java.io.InputStream;
import org.apache.http.client.methods.HttpUriRequest;
import java.nio.charset.Charset;

public class e
{
    protected static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    private InputStream a(final String s, final HttpUriRequest httpUriRequest, final int n) {
        final HttpResponse execute = this.a(n).execute(httpUriRequest);
        final int statusCode = execute.getStatusLine().getStatusCode();
        if (execute.getStatusLine().getStatusCode() >= 400) {
            throw new HttpException(String.format(Locale.US, "StatusCode: %d, URL: %s", statusCode, s));
        }
        final InputStream content = execute.getEntity().getContent();
        final Header firstHeader = execute.getFirstHeader("Content-Encoding");
        if (firstHeader != null && firstHeader.getValue().equalsIgnoreCase("gzip")) {
            return new GZIPInputStream(content);
        }
        return content;
    }
    
    private b a(final Object o) {
        if (o instanceof File) {
            return new d((File)o);
        }
        return new org.a.b.a.a.a.e(o.toString(), "text/plain", e.a);
    }
    
    private HttpClient a(final int n) {
        final BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout((HttpParams)basicHttpParams, n);
        HttpConnectionParams.setConnectionTimeout((HttpParams)basicHttpParams, n);
        return (HttpClient)new DefaultHttpClient((HttpParams)basicHttpParams);
    }
    
    private void a(final HttpPost httpPost, final HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        final g entity = new g(org.a.b.a.a.d.b);
        for (final String key : hashMap.keySet()) {
            entity.a(key, this.a(hashMap.get(key)));
        }
        httpPost.setEntity((HttpEntity)entity);
    }
    
    public String a(final String s) {
        return this.a(s, 10000);
    }
    
    public String a(final String s, final int n) {
        return this.a(s, 10000, e.a);
    }
    
    public String a(final String s, final int n, final Charset charset) {
        return org.a.a.a.d.a(this.b(s, n), charset);
    }
    
    public String a(final String s, final HashMap<String, Object> hashMap, final int n) {
        return this.a(s, hashMap, n, e.a);
    }
    
    public String a(final String s, final HashMap<String, Object> hashMap, final int n, final Charset charset) {
        return org.a.a.a.d.a(this.b(s, hashMap, n), charset);
    }
    
    public InputStream b(final String s, final int n) {
        final HttpGet httpGet = new HttpGet(s);
        httpGet.addHeader("Accept-Encoding", "gzip");
        return this.a(s, (HttpUriRequest)httpGet, n);
    }
    
    public InputStream b(final String s, final HashMap<String, Object> hashMap, final int n) {
        final HttpPost httpPost = new HttpPost(s);
        httpPost.addHeader("Accept-Encoding", "gzip");
        httpPost.getParams().setBooleanParameter("http.protocol.expect-continue", true);
        this.a(httpPost, hashMap);
        return this.a(s, (HttpUriRequest)httpPost, n);
    }
}
