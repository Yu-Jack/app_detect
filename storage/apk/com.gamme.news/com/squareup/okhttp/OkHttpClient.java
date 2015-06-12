// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.util.concurrent.TimeUnit;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import java.net.HttpURLConnection;
import com.squareup.okhttp.internal.http.OkResponseCacheAdapter;
import java.net.URLConnection;
import java.net.URL;
import java.net.URLStreamHandler;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import javax.net.ssl.SSLSocketFactory;
import java.net.ResponseCache;
import java.net.ProxySelector;
import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import java.net.CookieHandler;
import java.util.List;
import java.net.URLStreamHandlerFactory;

public final class OkHttpClient implements URLStreamHandlerFactory
{
    private static final List<String> DEFAULT_TRANSPORTS;
    private OkAuthenticator authenticator;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private CookieHandler cookieHandler;
    private final Dispatcher dispatcher;
    private boolean followProtocolRedirects;
    private HostnameVerifier hostnameVerifier;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private ResponseCache responseCache;
    private final RouteDatabase routeDatabase;
    private SSLSocketFactory sslSocketFactory;
    private List<String> transports;
    
    static {
        DEFAULT_TRANSPORTS = Util.immutableList((List<String>)Arrays.asList("spdy/3", "http/1.1"));
    }
    
    public OkHttpClient() {
        this.followProtocolRedirects = true;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }
    
    private OkHttpClient(final OkHttpClient okHttpClient) {
        this.followProtocolRedirects = true;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
    }
    
    private OkHttpClient copyWithDefaults() {
        final OkHttpClient okHttpClient = new OkHttpClient(this);
        okHttpClient.proxy = this.proxy;
        ProxySelector proxySelector;
        if (this.proxySelector != null) {
            proxySelector = this.proxySelector;
        }
        else {
            proxySelector = ProxySelector.getDefault();
        }
        okHttpClient.proxySelector = proxySelector;
        CookieHandler cookieHandler;
        if (this.cookieHandler != null) {
            cookieHandler = this.cookieHandler;
        }
        else {
            cookieHandler = CookieHandler.getDefault();
        }
        okHttpClient.cookieHandler = cookieHandler;
        ResponseCache responseCache;
        if (this.responseCache != null) {
            responseCache = this.responseCache;
        }
        else {
            responseCache = ResponseCache.getDefault();
        }
        okHttpClient.responseCache = responseCache;
        SSLSocketFactory sslSocketFactory;
        if (this.sslSocketFactory != null) {
            sslSocketFactory = this.sslSocketFactory;
        }
        else {
            sslSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        }
        okHttpClient.sslSocketFactory = sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        if (this.hostnameVerifier != null) {
            hostnameVerifier = this.hostnameVerifier;
        }
        else {
            hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        okHttpClient.hostnameVerifier = hostnameVerifier;
        OkAuthenticator authenticator;
        if (this.authenticator != null) {
            authenticator = this.authenticator;
        }
        else {
            authenticator = HttpAuthenticator.SYSTEM_DEFAULT;
        }
        okHttpClient.authenticator = authenticator;
        ConnectionPool connectionPool;
        if (this.connectionPool != null) {
            connectionPool = this.connectionPool;
        }
        else {
            connectionPool = ConnectionPool.getDefault();
        }
        okHttpClient.connectionPool = connectionPool;
        okHttpClient.followProtocolRedirects = this.followProtocolRedirects;
        List<String> transports;
        if (this.transports != null) {
            transports = this.transports;
        }
        else {
            transports = OkHttpClient.DEFAULT_TRANSPORTS;
        }
        okHttpClient.transports = transports;
        okHttpClient.connectTimeout = this.connectTimeout;
        okHttpClient.readTimeout = this.readTimeout;
        return okHttpClient;
    }
    
    void cancel(final Object o) {
        this.dispatcher.cancel(o);
    }
    
    @Override
    public URLStreamHandler createURLStreamHandler(final String s) {
        if (!s.equals("http") && !s.equals("https")) {
            return null;
        }
        return new URLStreamHandler() {
            @Override
            protected int getDefaultPort() {
                if (s.equals("http")) {
                    return 80;
                }
                if (s.equals("https")) {
                    return 443;
                }
                throw new AssertionError();
            }
            
            @Override
            protected URLConnection openConnection(final URL url) {
                return OkHttpClient.this.open(url);
            }
            
            @Override
            protected URLConnection openConnection(final URL url, final Proxy proxy) {
                return OkHttpClient.this.open(url, proxy);
            }
        };
    }
    
    void enqueue(final Request request, final Response.Receiver receiver) {
        this.dispatcher.enqueue(this.copyWithDefaults(), request, receiver);
    }
    
    public OkAuthenticator getAuthenticator() {
        return this.authenticator;
    }
    
    public int getConnectTimeout() {
        return this.connectTimeout;
    }
    
    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }
    
    public CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }
    
    public boolean getFollowProtocolRedirects() {
        return this.followProtocolRedirects;
    }
    
    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }
    
    public OkResponseCache getOkResponseCache() {
        if (this.responseCache instanceof HttpResponseCache) {
            return ((HttpResponseCache)this.responseCache).okResponseCache;
        }
        if (this.responseCache != null) {
            return new OkResponseCacheAdapter(this.responseCache);
        }
        return null;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }
    
    public int getReadTimeout() {
        return this.readTimeout;
    }
    
    public ResponseCache getResponseCache() {
        return this.responseCache;
    }
    
    public RouteDatabase getRoutesDatabase() {
        return this.routeDatabase;
    }
    
    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }
    
    public List<String> getTransports() {
        return this.transports;
    }
    
    public HttpURLConnection open(final URL url) {
        return this.open(url, this.proxy);
    }
    
    HttpURLConnection open(final URL url, final Proxy proxy) {
        final String protocol = url.getProtocol();
        final OkHttpClient copyWithDefaults = this.copyWithDefaults();
        copyWithDefaults.proxy = proxy;
        if (protocol.equals("http")) {
            return new HttpURLConnectionImpl(url, copyWithDefaults);
        }
        if (protocol.equals("https")) {
            return new HttpsURLConnectionImpl(url, copyWithDefaults);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }
    
    public OkHttpClient setAuthenticator(final OkAuthenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }
    
    public void setConnectTimeout(final long duration, final TimeUnit timeUnit) {
        if (duration < 0L) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        final long millis = timeUnit.toMillis(duration);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        this.connectTimeout = (int)millis;
    }
    
    public OkHttpClient setConnectionPool(final ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }
    
    public OkHttpClient setCookieHandler(final CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
        return this;
    }
    
    public OkHttpClient setFollowProtocolRedirects(final boolean followProtocolRedirects) {
        this.followProtocolRedirects = followProtocolRedirects;
        return this;
    }
    
    public OkHttpClient setHostnameVerifier(final HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }
    
    public OkHttpClient setProxy(final Proxy proxy) {
        this.proxy = proxy;
        return this;
    }
    
    public OkHttpClient setProxySelector(final ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }
    
    public void setReadTimeout(final long duration, final TimeUnit timeUnit) {
        if (duration < 0L) {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        final long millis = timeUnit.toMillis(duration);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException("Timeout too large.");
        }
        this.readTimeout = (int)millis;
    }
    
    public OkHttpClient setResponseCache(final ResponseCache responseCache) {
        this.responseCache = responseCache;
        return this;
    }
    
    public OkHttpClient setSslSocketFactory(final SSLSocketFactory sslSocketFactory) {
        this.sslSocketFactory = sslSocketFactory;
        return this;
    }
    
    public OkHttpClient setTransports(final List<String> list) {
        final List<String> immutableList = Util.immutableList(list);
        if (!immutableList.contains("http/1.1")) {
            throw new IllegalArgumentException("transports doesn't contain http/1.1: " + immutableList);
        }
        if (immutableList.contains(null)) {
            throw new IllegalArgumentException("transports must not contain null");
        }
        if (immutableList.contains("")) {
            throw new IllegalArgumentException("transports contains an empty string");
        }
        this.transports = immutableList;
        return this;
    }
}
