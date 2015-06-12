// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.net.Proxy;
import java.net.InetSocketAddress;

public class Route
{
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final boolean modernTls;
    final Proxy proxy;
    
    public Route(final Address address, final Proxy proxy, final InetSocketAddress inetSocketAddress, final boolean modernTls) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
        this.modernTls = modernTls;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof Route;
        boolean b2 = false;
        if (b) {
            final Route route = (Route)o;
            final boolean equals = this.address.equals(route.address);
            b2 = false;
            if (equals) {
                final boolean equals2 = this.proxy.equals(route.proxy);
                b2 = false;
                if (equals2) {
                    final boolean equals3 = this.inetSocketAddress.equals(route.inetSocketAddress);
                    b2 = false;
                    if (equals3) {
                        final boolean modernTls = this.modernTls;
                        final boolean modernTls2 = route.modernTls;
                        b2 = false;
                        if (modernTls == modernTls2) {
                            b2 = true;
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    Route flipTlsMode() {
        return new Route(this.address, this.proxy, this.inetSocketAddress, !this.modernTls);
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public InetSocketAddress getSocketAddress() {
        return this.inetSocketAddress;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (527 + this.address.hashCode()) + this.proxy.hashCode()) + this.inetSocketAddress.hashCode();
        int n2;
        if (this.modernTls) {
            n2 = n * 31;
        }
        else {
            n2 = 0;
        }
        return n + n2;
    }
    
    public boolean isModernTls() {
        return this.modernTls;
    }
}
