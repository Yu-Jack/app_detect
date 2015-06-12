// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import com.a.a.n;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.HttpClient;

public class f implements i
{
    protected final HttpClient a;
    
    public f(final HttpClient a) {
        this.a = a;
    }
    
    private static void a(final HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, final n<?> n) {
        final byte[] p2 = n.p();
        if (p2 != null) {
            httpEntityEnclosingRequestBase.setEntity((HttpEntity)new ByteArrayEntity(p2));
        }
    }
    
    private static void a(final HttpUriRequest httpUriRequest, final Map<String, String> map) {
        for (final String s : map.keySet()) {
            httpUriRequest.setHeader(s, (String)map.get(s));
        }
    }
    
    static HttpUriRequest b(final n<?> n, final Map<String, String> map) {
        switch (n.a()) {
            default: {
                throw new IllegalStateException("Unknown request method.");
            }
            case -1: {
                final byte[] l = n.l();
                if (l != null) {
                    final HttpPost httpPost = new HttpPost(n.c());
                    httpPost.addHeader("Content-Type", n.k());
                    httpPost.setEntity((HttpEntity)new ByteArrayEntity(l));
                    return (HttpUriRequest)httpPost;
                }
                return (HttpUriRequest)new HttpGet(n.c());
            }
            case 0: {
                return (HttpUriRequest)new HttpGet(n.c());
            }
            case 3: {
                return (HttpUriRequest)new HttpDelete(n.c());
            }
            case 1: {
                final HttpPost httpPost2 = new HttpPost(n.c());
                httpPost2.addHeader("Content-Type", n.o());
                a((HttpEntityEnclosingRequestBase)httpPost2, n);
                return (HttpUriRequest)httpPost2;
            }
            case 2: {
                final HttpPut httpPut = new HttpPut(n.c());
                httpPut.addHeader("Content-Type", n.o());
                a((HttpEntityEnclosingRequestBase)httpPut, n);
                return (HttpUriRequest)httpPut;
            }
            case 4: {
                return (HttpUriRequest)new HttpHead(n.c());
            }
            case 5: {
                return (HttpUriRequest)new HttpOptions(n.c());
            }
            case 6: {
                return (HttpUriRequest)new HttpTrace(n.c());
            }
            case 7: {
                final g g = new g(n.c());
                g.addHeader("Content-Type", n.o());
                a(g, n);
                return (HttpUriRequest)g;
            }
        }
    }
    
    @Override
    public HttpResponse a(final n<?> n, final Map<String, String> map) {
        final HttpUriRequest b = b(n, map);
        a(b, map);
        a(b, n.h());
        this.a(b);
        final HttpParams params = b.getParams();
        final int s = n.s();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, s);
        return this.a.execute(b);
    }
    
    protected void a(final HttpUriRequest httpUriRequest) {
    }
}
