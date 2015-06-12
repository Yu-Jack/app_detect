// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;

public final class TunnelRequest
{
    final String host;
    final int port;
    final String proxyAuthorization;
    final String userAgent;
    
    public TunnelRequest(final String host, final int port, final String userAgent, final String proxyAuthorization) {
        if (host == null) {
            throw new NullPointerException("host == null");
        }
        if (userAgent == null) {
            throw new NullPointerException("userAgent == null");
        }
        this.host = host;
        this.port = port;
        this.userAgent = userAgent;
        this.proxyAuthorization = proxyAuthorization;
    }
    
    RawHeaders getRequestHeaders() {
        final RawHeaders rawHeaders = new RawHeaders();
        rawHeaders.setRequestLine("CONNECT " + this.host + ":" + this.port + " HTTP/1.1");
        String s;
        if (this.port == Util.getDefaultPort("https")) {
            s = this.host;
        }
        else {
            s = String.valueOf(this.host) + ":" + this.port;
        }
        rawHeaders.set("Host", s);
        rawHeaders.set("User-Agent", this.userAgent);
        if (this.proxyAuthorization != null) {
            rawHeaders.set("Proxy-Authorization", this.proxyAuthorization);
        }
        rawHeaders.set("Proxy-Connection", "Keep-Alive");
        return rawHeaders;
    }
}
