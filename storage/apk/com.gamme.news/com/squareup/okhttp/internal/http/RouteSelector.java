// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.NoSuchElementException;
import java.io.IOException;
import com.squareup.okhttp.Connection;
import java.net.SocketAddress;
import com.squareup.okhttp.internal.Util;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.net.URI;
import java.net.InetAddress;
import com.squareup.okhttp.RouteDatabase;
import java.util.Iterator;
import java.net.ProxySelector;
import com.squareup.okhttp.Route;
import java.util.List;
import com.squareup.okhttp.ConnectionPool;
import java.net.Proxy;
import java.net.InetSocketAddress;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.Address;

public final class RouteSelector
{
    private static final int TLS_MODE_COMPATIBLE = 0;
    private static final int TLS_MODE_MODERN = 1;
    private static final int TLS_MODE_NULL = -1;
    private final Address address;
    private final Dns dns;
    private boolean hasNextProxy;
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private int nextSocketAddressIndex;
    private int nextTlsMode;
    private final ConnectionPool pool;
    private final List<Route> postponedRoutes;
    private final ProxySelector proxySelector;
    private Iterator<Proxy> proxySelectorProxies;
    private final RouteDatabase routeDatabase;
    private InetAddress[] socketAddresses;
    private int socketPort;
    private final URI uri;
    private Proxy userSpecifiedProxy;
    
    public RouteSelector(final Address address, final URI uri, final ProxySelector proxySelector, final ConnectionPool pool, final Dns dns, final RouteDatabase routeDatabase) {
        this.nextTlsMode = -1;
        this.address = address;
        this.uri = uri;
        this.proxySelector = proxySelector;
        this.pool = pool;
        this.dns = dns;
        this.routeDatabase = routeDatabase;
        this.postponedRoutes = new LinkedList<Route>();
        this.resetNextProxy(uri, address.getProxy());
    }
    
    private boolean hasNextInetSocketAddress() {
        return this.socketAddresses != null;
    }
    
    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }
    
    private boolean hasNextProxy() {
        return this.hasNextProxy;
    }
    
    private boolean hasNextTlsMode() {
        return this.nextTlsMode != -1;
    }
    
    private InetSocketAddress nextInetSocketAddress() throws UnknownHostException {
        final InetSocketAddress inetSocketAddress = new InetSocketAddress(this.socketAddresses[this.nextSocketAddressIndex++], this.socketPort);
        if (this.nextSocketAddressIndex == this.socketAddresses.length) {
            this.socketAddresses = null;
            this.nextSocketAddressIndex = 0;
        }
        return inetSocketAddress;
    }
    
    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }
    
    private Proxy nextProxy() {
        if (this.userSpecifiedProxy != null) {
            this.hasNextProxy = false;
            return this.userSpecifiedProxy;
        }
        if (this.proxySelectorProxies != null) {
            while (this.proxySelectorProxies.hasNext()) {
                final Proxy proxy = this.proxySelectorProxies.next();
                if (proxy.type() != Proxy.Type.DIRECT) {
                    return proxy;
                }
            }
        }
        this.hasNextProxy = false;
        return Proxy.NO_PROXY;
    }
    
    private int nextTlsMode() {
        if (this.nextTlsMode == 1) {
            this.nextTlsMode = 0;
            return 1;
        }
        if (this.nextTlsMode == 0) {
            this.nextTlsMode = -1;
            return 0;
        }
        throw new AssertionError();
    }
    
    private void resetNextInetSocketAddress(final Proxy proxy) throws UnknownHostException {
        this.socketAddresses = null;
        String s;
        if (proxy.type() == Proxy.Type.DIRECT) {
            s = this.uri.getHost();
            this.socketPort = Util.getEffectivePort(this.uri);
        }
        else {
            final SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + ((InetSocketAddress)address).getClass());
            }
            final InetSocketAddress inetSocketAddress = (InetSocketAddress)address;
            s = inetSocketAddress.getHostName();
            this.socketPort = inetSocketAddress.getPort();
        }
        this.socketAddresses = this.dns.getAllByName(s);
        this.nextSocketAddressIndex = 0;
    }
    
    private void resetNextProxy(final URI uri, final Proxy userSpecifiedProxy) {
        this.hasNextProxy = true;
        if (userSpecifiedProxy != null) {
            this.userSpecifiedProxy = userSpecifiedProxy;
        }
        else {
            final List<Proxy> select = this.proxySelector.select(uri);
            if (select != null) {
                this.proxySelectorProxies = select.iterator();
            }
        }
    }
    
    private void resetNextTlsMode() {
        int nextTlsMode;
        if (this.address.getSslSocketFactory() != null) {
            nextTlsMode = 1;
        }
        else {
            nextTlsMode = 0;
        }
        this.nextTlsMode = nextTlsMode;
    }
    
    public void connectFailed(final Connection connection, final IOException ex) {
        final Route route = connection.getRoute();
        if (route.getProxy().type() != Proxy.Type.DIRECT && this.proxySelector != null) {
            this.proxySelector.connectFailed(this.uri, route.getProxy().address(), ex);
        }
        this.routeDatabase.failed(route, ex);
    }
    
    public boolean hasNext() {
        return this.hasNextTlsMode() || this.hasNextInetSocketAddress() || this.hasNextProxy() || this.hasNextPostponed();
    }
    
    public Connection next(final String s) throws IOException {
        boolean b = true;
        while (true) {
            final Connection value = this.pool.get(this.address);
            if (value == null) {
                if (!this.hasNextTlsMode()) {
                    if (!this.hasNextInetSocketAddress()) {
                        if (!this.hasNextProxy()) {
                            if (!this.hasNextPostponed()) {
                                throw new NoSuchElementException();
                            }
                            return new Connection(this.nextPostponed());
                        }
                        else {
                            this.resetNextInetSocketAddress(this.lastProxy = this.nextProxy());
                        }
                    }
                    this.lastInetSocketAddress = this.nextInetSocketAddress();
                    this.resetNextTlsMode();
                }
                if (this.nextTlsMode() != (b ? 1 : 0)) {
                    b = false;
                }
                final Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, b);
                if (this.routeDatabase.shouldPostpone(route)) {
                    this.postponedRoutes.add(route);
                    return this.next(s);
                }
                return new Connection(route);
            }
            else {
                if (s.equals("GET") || value.isReadable()) {
                    return value;
                }
                value.close();
            }
        }
    }
}
