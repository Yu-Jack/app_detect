// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.URL;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.TunnelRequest;
import java.net.SecureCacheResponse;
import java.net.CacheResponse;
import java.io.IOException;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import javax.net.ssl.SSLSocket;

public final class HttpsEngine extends HttpEngine
{
    private SSLSocket sslSocket;
    
    public HttpsEngine(final OkHttpClient okHttpClient, final Policy policy, final String s, final RawHeaders rawHeaders, final Connection connection, final RetryableOutputStream retryableOutputStream) throws IOException {
        super(okHttpClient, policy, s, rawHeaders, connection, retryableOutputStream);
        SSLSocket sslSocket;
        if (connection != null) {
            sslSocket = (SSLSocket)connection.getSocket();
        }
        else {
            sslSocket = null;
        }
        this.sslSocket = sslSocket;
    }
    
    @Override
    protected boolean acceptCacheResponseType(final CacheResponse cacheResponse) {
        return cacheResponse instanceof SecureCacheResponse;
    }
    
    @Override
    protected void connected(final Connection connection) {
        this.sslSocket = (SSLSocket)connection.getSocket();
        super.connected(connection);
    }
    
    public SSLSocket getSslSocket() {
        return this.sslSocket;
    }
    
    @Override
    protected TunnelRequest getTunnelConfig() {
        String s = this.requestHeaders.getUserAgent();
        if (s == null) {
            s = HttpEngine.getDefaultUserAgent();
        }
        final URL url = this.policy.getURL();
        return new TunnelRequest(url.getHost(), Util.getEffectivePort(url), s, this.requestHeaders.getProxyAuthorization());
    }
    
    @Override
    protected boolean includeAuthorityInRequestLine() {
        return false;
    }
}
