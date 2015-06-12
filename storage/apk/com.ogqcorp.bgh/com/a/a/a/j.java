// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import java.util.List;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.ProtocolVersion;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import java.util.Map;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.HttpEntity;
import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import com.a.a.n;
import java.net.URL;
import javax.net.ssl.SSLSocketFactory;

public class j implements i
{
    private final k a;
    private final SSLSocketFactory b;
    
    public j() {
        this(null);
    }
    
    public j(final k k) {
        this(k, null);
    }
    
    public j(final k a, final SSLSocketFactory b) {
        this.a = a;
        this.b = b;
    }
    
    private HttpURLConnection a(final URL url, final n<?> n) {
        final HttpURLConnection a = this.a(url);
        final int s = n.s();
        a.setConnectTimeout(s);
        a.setReadTimeout(s);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.b != null) {
            ((HttpsURLConnection)a).setSSLSocketFactory(this.b);
        }
        return a;
    }
    
    private static HttpEntity a(final HttpURLConnection httpURLConnection) {
        final BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        while (true) {
            try {
                final InputStream content = httpURLConnection.getInputStream();
                basicHttpEntity.setContent(content);
                basicHttpEntity.setContentLength((long)httpURLConnection.getContentLength());
                basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
                basicHttpEntity.setContentType(httpURLConnection.getContentType());
                return (HttpEntity)basicHttpEntity;
            }
            catch (IOException ex) {
                final InputStream content = httpURLConnection.getErrorStream();
                continue;
            }
            break;
        }
    }
    
    static void a(final HttpURLConnection httpURLConnection, final n<?> n) {
        switch (n.a()) {
            default: {
                throw new IllegalStateException("Unknown method type.");
            }
            case -1: {
                final byte[] l = n.l();
                if (l != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", n.k());
                    final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(l);
                    dataOutputStream.close();
                }
            }
            case 0: {
                httpURLConnection.setRequestMethod("GET");
            }
            case 3: {
                httpURLConnection.setRequestMethod("DELETE");
            }
            case 1: {
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, n);
            }
            case 2: {
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, n);
            }
            case 4: {
                httpURLConnection.setRequestMethod("HEAD");
            }
            case 5: {
                httpURLConnection.setRequestMethod("OPTIONS");
            }
            case 6: {
                httpURLConnection.setRequestMethod("TRACE");
            }
            case 7: {
                b(httpURLConnection, n);
                httpURLConnection.setRequestMethod("PATCH");
            }
        }
    }
    
    private static void b(final HttpURLConnection httpURLConnection, final n<?> n) {
        final byte[] p2 = n.p();
        if (p2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", n.o());
            final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(p2);
            dataOutputStream.close();
        }
    }
    
    protected HttpURLConnection a(final URL url) {
        return (HttpURLConnection)url.openConnection();
    }
    
    @Override
    public HttpResponse a(final n<?> n, final Map<String, String> m) {
        final String c = n.c();
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.putAll(n.h());
        hashMap.putAll(m);
        String a;
        if (this.a != null) {
            a = this.a.a(c);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + c);
            }
        }
        else {
            a = c;
        }
        final HttpURLConnection a2 = this.a(new URL(a), n);
        for (final String s : hashMap.keySet()) {
            a2.addRequestProperty(s, hashMap.get(s));
        }
        a(a2, n);
        final ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        final BasicHttpResponse basicHttpResponse = new BasicHttpResponse((StatusLine)new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(a(a2));
        for (final Map.Entry<String, List<String>> entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader((Header)new BasicHeader((String)entry.getKey(), (String)entry.getValue().get(0)));
            }
        }
        return (HttpResponse)basicHttpResponse;
    }
}
