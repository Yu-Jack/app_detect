// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.net.HttpURLConnection;
import java.net.CacheRequest;
import java.net.URLConnection;
import java.io.IOException;
import java.net.CacheResponse;
import java.util.List;
import java.util.Map;
import java.net.URI;

public interface OkResponseCache
{
    CacheResponse get(URI p0, String p1, Map<String, List<String>> p2) throws IOException;
    
    void maybeRemove(String p0, URI p1) throws IOException;
    
    CacheRequest put(URI p0, URLConnection p1) throws IOException;
    
    void trackConditionalCacheHit();
    
    void trackResponse(ResponseSource p0);
    
    void update(CacheResponse p0, HttpURLConnection p1) throws IOException;
}
