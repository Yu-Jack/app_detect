// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.HttpURLConnection;
import com.squareup.okhttp.ResponseSource;
import java.net.CacheRequest;
import java.net.URLConnection;
import java.io.IOException;
import java.net.CacheResponse;
import java.util.List;
import java.util.Map;
import java.net.URI;
import java.net.ResponseCache;
import com.squareup.okhttp.OkResponseCache;

public final class OkResponseCacheAdapter implements OkResponseCache
{
    private final ResponseCache responseCache;
    
    public OkResponseCacheAdapter(final ResponseCache responseCache) {
        this.responseCache = responseCache;
    }
    
    @Override
    public CacheResponse get(final URI uri, final String s, final Map<String, List<String>> map) throws IOException {
        return this.responseCache.get(uri, s, map);
    }
    
    @Override
    public void maybeRemove(final String s, final URI uri) throws IOException {
    }
    
    @Override
    public CacheRequest put(final URI uri, final URLConnection urlConnection) throws IOException {
        return this.responseCache.put(uri, urlConnection);
    }
    
    @Override
    public void trackConditionalCacheHit() {
    }
    
    @Override
    public void trackResponse(final ResponseSource responseSource) {
    }
    
    @Override
    public void update(final CacheResponse cacheResponse, final HttpURLConnection httpURLConnection) throws IOException {
    }
}
