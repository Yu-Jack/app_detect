// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import java.net.URLConnection;
import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.net.URI;
import java.io.IOException;
import com.facebook.LoggingBehavior;
import android.content.Context;

class ImageResponseCache
{
    static final String TAG;
    private static volatile FileLruCache imageCache;
    
    static {
        TAG = ImageResponseCache.class.getSimpleName();
    }
    
    static void clearCache(final Context context) {
        try {
            getCache(context).clearCache();
        }
        catch (IOException ex) {
            Logger.log(LoggingBehavior.CACHE, 5, ImageResponseCache.TAG, "clearCache failed " + ex.getMessage());
        }
    }
    
    static FileLruCache getCache(final Context context) throws IOException {
        synchronized (ImageResponseCache.class) {
            if (ImageResponseCache.imageCache == null) {
                ImageResponseCache.imageCache = new FileLruCache(context.getApplicationContext(), ImageResponseCache.TAG, new FileLruCache.Limits());
            }
            return ImageResponseCache.imageCache;
        }
    }
    
    static InputStream getCachedImageStream(final URI uri, final Context context) {
        InputStream value = null;
        if (uri == null) {
            return value;
        }
        final boolean cdnurl = isCDNURL(uri);
        value = null;
        if (!cdnurl) {
            return value;
        }
        try {
            value = getCache(context).get(uri.toString());
            return value;
        }
        catch (IOException ex) {
            Logger.log(LoggingBehavior.CACHE, 5, ImageResponseCache.TAG, ex.toString());
            return null;
        }
    }
    
    static InputStream interceptAndCacheImageStream(final Context context, final HttpURLConnection httpURLConnection) throws IOException {
        final int responseCode = httpURLConnection.getResponseCode();
        InputStream inputStream = null;
        if (responseCode != 200) {
            return inputStream;
        }
        final URL url = httpURLConnection.getURL();
        inputStream = httpURLConnection.getInputStream();
        try {
            if (isCDNURL(url.toURI())) {
                inputStream = getCache(context).interceptAndPut(url.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection));
            }
            return inputStream;
        }
        catch (URISyntaxException ex) {
            return inputStream;
        }
        catch (IOException ex2) {
            return inputStream;
        }
    }
    
    private static boolean isCDNURL(final URI uri) {
        if (uri != null) {
            final String host = uri.getHost();
            if (host.endsWith("fbcdn.net") || (host.startsWith("fbcdn") && host.endsWith("akamaihd.net"))) {
                return true;
            }
        }
        return false;
    }
    
    private static class BufferedHttpInputStream extends BufferedInputStream
    {
        HttpURLConnection connection;
        
        BufferedHttpInputStream(final InputStream in, final HttpURLConnection connection) {
            super(in, 8192);
            this.connection = connection;
        }
        
        @Override
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }
    }
}