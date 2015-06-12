// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.Proxy;
import java.net.URL;
import java.net.HttpURLConnection;

public interface Policy
{
    int getChunkLength();
    
    long getFixedContentLength();
    
    HttpURLConnection getHttpConnectionToCache();
    
    long getIfModifiedSince();
    
    URL getURL();
    
    boolean getUseCaches();
    
    void setSelectedProxy(Proxy p0);
    
    boolean usingProxy();
}
