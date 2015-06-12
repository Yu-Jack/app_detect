// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase
{
    private final Set<Route> failedRoutes;
    
    public RouteDatabase() {
        this.failedRoutes = new LinkedHashSet<Route>();
    }
    
    public void connected(final Route route) {
        synchronized (this) {
            this.failedRoutes.remove(route);
        }
    }
    
    public void failed(final Route route, final IOException ex) {
        synchronized (this) {
            this.failedRoutes.add(route);
            if (!(ex instanceof SSLHandshakeException)) {
                this.failedRoutes.add(route.flipTlsMode());
            }
        }
    }
    
    public int failedRoutesCount() {
        synchronized (this) {
            return this.failedRoutes.size();
        }
    }
    
    public boolean shouldPostpone(final Route route) {
        synchronized (this) {
            return this.failedRoutes.contains(route);
        }
    }
}
