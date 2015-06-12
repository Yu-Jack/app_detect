// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.net.UnknownHostException;
import com.squareup.okhttp.internal.Util;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;

public final class Address
{
    final OkAuthenticator authenticator;
    final HostnameVerifier hostnameVerifier;
    final Proxy proxy;
    final SSLSocketFactory sslSocketFactory;
    final List<String> transports;
    final String uriHost;
    final int uriPort;
    
    public Address(final String uriHost, final int n, final SSLSocketFactory sslSocketFactory, final HostnameVerifier hostnameVerifier, final OkAuthenticator authenticator, final Proxy proxy, final List<String> list) throws UnknownHostException {
        if (uriHost == null) {
            throw new NullPointerException("uriHost == null");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("uriPort <= 0: " + n);
        }
        if (authenticator == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        if (list == null) {
            throw new IllegalArgumentException("transports == null");
        }
        this.proxy = proxy;
        this.uriHost = uriHost;
        this.uriPort = n;
        this.sslSocketFactory = sslSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.authenticator = authenticator;
        this.transports = Util.immutableList(list);
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof Address;
        boolean b2 = false;
        if (b) {
            final Address address = (Address)o;
            final boolean equal = Util.equal(this.proxy, address.proxy);
            b2 = false;
            if (equal) {
                final boolean equals = this.uriHost.equals(address.uriHost);
                b2 = false;
                if (equals) {
                    final int uriPort = this.uriPort;
                    final int uriPort2 = address.uriPort;
                    b2 = false;
                    if (uriPort == uriPort2) {
                        final boolean equal2 = Util.equal(this.sslSocketFactory, address.sslSocketFactory);
                        b2 = false;
                        if (equal2) {
                            final boolean equal3 = Util.equal(this.hostnameVerifier, address.hostnameVerifier);
                            b2 = false;
                            if (equal3) {
                                final boolean equal4 = Util.equal(this.authenticator, address.authenticator);
                                b2 = false;
                                if (equal4) {
                                    final boolean equal5 = Util.equal(this.transports, address.transports);
                                    b2 = false;
                                    if (equal5) {
                                        b2 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public OkAuthenticator getAuthenticator() {
        return this.authenticator;
    }
    
    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }
    
    public List<String> getTransports() {
        return this.transports;
    }
    
    public String getUriHost() {
        return this.uriHost;
    }
    
    public int getUriPort() {
        return this.uriPort;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (527 + this.uriHost.hashCode()) + this.uriPort);
        int hashCode;
        if (this.sslSocketFactory != null) {
            hashCode = this.sslSocketFactory.hashCode();
        }
        else {
            hashCode = 0;
        }
        final int n2 = 31 * (n + hashCode);
        int hashCode2;
        if (this.hostnameVerifier != null) {
            hashCode2 = this.hostnameVerifier.hashCode();
        }
        else {
            hashCode2 = 0;
        }
        final int n3 = 31 * (n2 + hashCode2);
        int hashCode3;
        if (this.authenticator != null) {
            hashCode3 = this.authenticator.hashCode();
        }
        else {
            hashCode3 = 0;
        }
        final int n4 = 31 * (n3 + hashCode3);
        final Proxy proxy = this.proxy;
        int hashCode4 = 0;
        if (proxy != null) {
            hashCode4 = this.proxy.hashCode();
        }
        return 31 * (n4 + hashCode4) + this.transports.hashCode();
    }
}
