// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.Proxy;
import com.squareup.okhttp.TunnelRequest;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.Address;
import java.net.UnknownHostException;
import java.net.CookieHandler;
import java.util.Date;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import com.squareup.okhttp.OkResponseCache;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;
import java.net.URL;
import java.net.URISyntaxException;
import com.squareup.okhttp.internal.Platform;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import com.squareup.okhttp.internal.Util;
import java.net.URI;
import com.squareup.okhttp.ResponseSource;
import java.io.OutputStream;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.CacheResponse;

public class HttpEngine
{
    private static final CacheResponse GATEWAY_TIMEOUT_RESPONSE;
    public static final int HTTP_CONTINUE = 100;
    private boolean automaticallyReleaseConnectionToPool;
    private CacheRequest cacheRequest;
    private CacheResponse cacheResponse;
    private InputStream cachedResponseBody;
    private ResponseHeaders cachedResponseHeaders;
    protected final OkHttpClient client;
    boolean connected;
    protected Connection connection;
    private boolean connectionReleased;
    protected final String method;
    protected final Policy policy;
    private OutputStream requestBodyOut;
    final RequestHeaders requestHeaders;
    private InputStream responseBodyIn;
    ResponseHeaders responseHeaders;
    private ResponseSource responseSource;
    private InputStream responseTransferIn;
    protected RouteSelector routeSelector;
    long sentRequestMillis;
    private boolean transparentGzip;
    private Transport transport;
    final URI uri;
    
    static {
        GATEWAY_TIMEOUT_RESPONSE = new CacheResponse() {
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(Util.EMPTY_BYTE_ARRAY);
            }
            
            @Override
            public Map<String, List<String>> getHeaders() throws IOException {
                final HashMap<Object, List<String>> hashMap = (HashMap<Object, List<String>>)new HashMap<String, List<String>>();
                hashMap.put(null, Collections.singletonList("HTTP/1.1 504 Gateway Timeout"));
                return (Map<String, List<String>>)hashMap;
            }
        };
    }
    
    public HttpEngine(final OkHttpClient client, final Policy policy, final String method, final RawHeaders rawHeaders, final Connection connection, final RetryableOutputStream requestBodyOut) throws IOException {
        this.sentRequestMillis = -1L;
        this.client = client;
        this.policy = policy;
        this.method = method;
        this.connection = connection;
        this.requestBodyOut = requestBodyOut;
        try {
            this.uri = Platform.get().toUriLenient(policy.getURL());
            this.requestHeaders = new RequestHeaders(this.uri, new RawHeaders(rawHeaders));
        }
        catch (URISyntaxException ex) {
            throw new IOException(ex.getMessage());
        }
    }
    
    public static String getDefaultUserAgent() {
        final String property = System.getProperty("http.agent");
        if (property != null) {
            return property;
        }
        return "Java" + System.getProperty("java.version");
    }
    
    public static String getOriginAddress(final URL url) {
        final int port = url.getPort();
        String obj = url.getHost();
        if (port > 0 && port != Util.getDefaultPort(url.getProtocol())) {
            obj = String.valueOf(obj) + ":" + port;
        }
        return obj;
    }
    
    private void initContentStream(final InputStream responseBodyIn) throws IOException {
        this.responseTransferIn = responseBodyIn;
        if (this.transparentGzip && this.responseHeaders.isContentEncodingGzip()) {
            this.responseHeaders.stripContentEncoding();
            this.responseHeaders.stripContentLength();
            this.responseBodyIn = new GZIPInputStream(responseBodyIn);
            return;
        }
        this.responseBodyIn = responseBodyIn;
    }
    
    private void initResponseSource() throws IOException {
        this.responseSource = ResponseSource.NETWORK;
        if (this.policy.getUseCaches()) {
            final OkResponseCache okResponseCache = this.client.getOkResponseCache();
            if (okResponseCache != null) {
                final CacheResponse value = okResponseCache.get(this.uri, this.method, this.requestHeaders.getHeaders().toMultimap(false));
                if (value != null) {
                    final Map<String, List<String>> headers = value.getHeaders();
                    this.cachedResponseBody = value.getBody();
                    if (!this.acceptCacheResponseType(value) || headers == null || this.cachedResponseBody == null) {
                        Util.closeQuietly(this.cachedResponseBody);
                        return;
                    }
                    this.cachedResponseHeaders = new ResponseHeaders(this.uri, RawHeaders.fromMultimap(headers, true));
                    this.responseSource = this.cachedResponseHeaders.chooseResponseSource(System.currentTimeMillis(), this.requestHeaders);
                    if (this.responseSource == ResponseSource.CACHE) {
                        this.cacheResponse = value;
                        this.setResponse(this.cachedResponseHeaders, this.cachedResponseBody);
                        return;
                    }
                    if (this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                        this.cacheResponse = value;
                        return;
                    }
                    if (this.responseSource == ResponseSource.NETWORK) {
                        Util.closeQuietly(this.cachedResponseBody);
                        return;
                    }
                    throw new AssertionError();
                }
            }
        }
    }
    
    private void maybeCache() throws IOException {
        if (this.policy.getUseCaches()) {
            final OkResponseCache okResponseCache = this.client.getOkResponseCache();
            if (okResponseCache != null) {
                final HttpURLConnection httpConnectionToCache = this.policy.getHttpConnectionToCache();
                if (!this.responseHeaders.isCacheable(this.requestHeaders)) {
                    okResponseCache.maybeRemove(httpConnectionToCache.getRequestMethod(), this.uri);
                    return;
                }
                this.cacheRequest = okResponseCache.put(this.uri, httpConnectionToCache);
            }
        }
    }
    
    private void prepareRawRequestHeaders() throws IOException {
        this.requestHeaders.getHeaders().setRequestLine(this.getRequestLine());
        if (this.requestHeaders.getUserAgent() == null) {
            this.requestHeaders.setUserAgent(getDefaultUserAgent());
        }
        if (this.requestHeaders.getHost() == null) {
            this.requestHeaders.setHost(getOriginAddress(this.policy.getURL()));
        }
        if ((this.connection == null || this.connection.getHttpMinorVersion() != 0) && this.requestHeaders.getConnection() == null) {
            this.requestHeaders.setConnection("Keep-Alive");
        }
        if (this.requestHeaders.getAcceptEncoding() == null) {
            this.transparentGzip = true;
            this.requestHeaders.setAcceptEncoding("gzip");
        }
        if (this.hasRequestBody() && this.requestHeaders.getContentType() == null) {
            this.requestHeaders.setContentType("application/x-www-form-urlencoded");
        }
        final long ifModifiedSince = this.policy.getIfModifiedSince();
        if (ifModifiedSince != 0L) {
            this.requestHeaders.setIfModifiedSince(new Date(ifModifiedSince));
        }
        final CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            this.requestHeaders.addCookies(cookieHandler.get(this.uri, this.requestHeaders.getHeaders().toMultimap(false)));
        }
    }
    
    public static String requestPath(final URL url) {
        String file = url.getFile();
        if (file == null) {
            file = "/";
        }
        else if (!file.startsWith("/")) {
            return "/" + file;
        }
        return file;
    }
    
    private String requestString() {
        final URL url = this.policy.getURL();
        if (this.includeAuthorityInRequestLine()) {
            return url.toString();
        }
        return requestPath(url);
    }
    
    private void sendSocketRequest() throws IOException {
        if (this.connection == null) {
            this.connect();
        }
        if (this.transport != null) {
            throw new IllegalStateException();
        }
        this.transport = (Transport)this.connection.newTransport(this);
        if (this.hasRequestBody() && this.requestBodyOut == null) {
            this.requestBodyOut = this.transport.createRequestBody();
        }
    }
    
    private void setResponse(final ResponseHeaders responseHeaders, final InputStream inputStream) throws IOException {
        if (this.responseBodyIn != null) {
            throw new IllegalStateException();
        }
        this.responseHeaders = responseHeaders;
        if (inputStream != null) {
            this.initContentStream(inputStream);
        }
    }
    
    protected boolean acceptCacheResponseType(final CacheResponse cacheResponse) {
        return true;
    }
    
    public final void automaticallyReleaseConnectionToPool() {
        this.automaticallyReleaseConnectionToPool = true;
        if (this.connection != null && this.connectionReleased) {
            this.client.getConnectionPool().recycle(this.connection);
            this.connection = null;
        }
    }
    
    protected final void connect() throws IOException {
        if (this.connection == null) {
            if (this.routeSelector == null) {
                final String host = this.uri.getHost();
                if (host == null) {
                    throw new UnknownHostException(this.uri.toString());
                }
                final boolean equalsIgnoreCase = this.uri.getScheme().equalsIgnoreCase("https");
                SSLSocketFactory sslSocketFactory = null;
                HostnameVerifier hostnameVerifier = null;
                if (equalsIgnoreCase) {
                    sslSocketFactory = this.client.getSslSocketFactory();
                    hostnameVerifier = this.client.getHostnameVerifier();
                }
                this.routeSelector = new RouteSelector(new Address(host, Util.getEffectivePort(this.uri), sslSocketFactory, hostnameVerifier, this.client.getAuthenticator(), this.client.getProxy(), this.client.getTransports()), this.uri, this.client.getProxySelector(), this.client.getConnectionPool(), Dns.DEFAULT, this.client.getRoutesDatabase());
            }
            this.connection = this.routeSelector.next(this.method);
            if (!this.connection.isConnected()) {
                this.connection.connect(this.client.getConnectTimeout(), this.client.getReadTimeout(), this.getTunnelConfig());
                this.client.getConnectionPool().maybeShare(this.connection);
                this.client.getRoutesDatabase().connected(this.connection.getRoute());
            }
            else if (!this.connection.isSpdy()) {
                this.connection.updateReadTimeout(this.client.getReadTimeout());
            }
            this.connected(this.connection);
            if (this.connection.getRoute().getProxy() != this.client.getProxy()) {
                this.requestHeaders.getHeaders().setRequestLine(this.getRequestLine());
            }
        }
    }
    
    protected void connected(final Connection connection) {
        this.policy.setSelectedProxy(connection.getRoute().getProxy());
        this.connected = true;
    }
    
    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }
    
    public final Connection getConnection() {
        return this.connection;
    }
    
    public final OutputStream getRequestBody() {
        if (this.responseSource == null) {
            throw new IllegalStateException();
        }
        return this.requestBodyOut;
    }
    
    public final RequestHeaders getRequestHeaders() {
        return this.requestHeaders;
    }
    
    String getRequestLine() {
        String str;
        if (this.connection == null || this.connection.getHttpMinorVersion() != 0) {
            str = "HTTP/1.1";
        }
        else {
            str = "HTTP/1.0";
        }
        return String.valueOf(this.method) + " " + this.requestString() + " " + str;
    }
    
    public final InputStream getResponseBody() {
        if (this.responseHeaders == null) {
            throw new IllegalStateException();
        }
        return this.responseBodyIn;
    }
    
    public final int getResponseCode() {
        if (this.responseHeaders == null) {
            throw new IllegalStateException();
        }
        return this.responseHeaders.getHeaders().getResponseCode();
    }
    
    public final ResponseHeaders getResponseHeaders() {
        if (this.responseHeaders == null) {
            throw new IllegalStateException();
        }
        return this.responseHeaders;
    }
    
    protected TunnelRequest getTunnelConfig() {
        return null;
    }
    
    public URI getUri() {
        return this.uri;
    }
    
    boolean hasRequestBody() {
        return this.method.equals("POST") || this.method.equals("PUT") || this.method.equals("PATCH");
    }
    
    public final boolean hasResponse() {
        return this.responseHeaders != null;
    }
    
    public final boolean hasResponseBody() {
        final int responseCode = this.responseHeaders.getHeaders().getResponseCode();
        if (!this.method.equals("HEAD")) {
            if ((responseCode < 100 || responseCode >= 200) && responseCode != 204 && responseCode != 304) {
                return true;
            }
            if (this.responseHeaders.getContentLength() != -1L || this.responseHeaders.isChunked()) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean includeAuthorityInRequestLine() {
        if (this.connection == null) {
            return this.policy.usingProxy();
        }
        return this.connection.getRoute().getProxy().type() == Proxy.Type.HTTP;
    }
    
    public final void readResponse() throws IOException {
        if (this.hasResponse()) {
            this.responseHeaders.setResponseSource(this.responseSource);
        }
        else {
            if (this.responseSource == null) {
                throw new IllegalStateException("readResponse() without sendRequest()");
            }
            if (this.responseSource.requiresConnection()) {
                if (this.sentRequestMillis == -1L) {
                    if (this.requestBodyOut instanceof RetryableOutputStream) {
                        this.requestHeaders.setContentLength(((RetryableOutputStream)this.requestBodyOut).contentLength());
                    }
                    this.transport.writeRequestHeaders();
                }
                if (this.requestBodyOut != null) {
                    this.requestBodyOut.close();
                    if (this.requestBodyOut instanceof RetryableOutputStream) {
                        this.transport.writeRequestBody((RetryableOutputStream)this.requestBodyOut);
                    }
                }
                this.transport.flushRequest();
                (this.responseHeaders = this.transport.readResponseHeaders()).setLocalTimestamps(this.sentRequestMillis, System.currentTimeMillis());
                this.responseHeaders.setResponseSource(this.responseSource);
                if (this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                    if (this.cachedResponseHeaders.validate(this.responseHeaders)) {
                        this.release(false);
                        this.responseHeaders = this.cachedResponseHeaders.combine(this.responseHeaders);
                        final OkResponseCache okResponseCache = this.client.getOkResponseCache();
                        okResponseCache.trackConditionalCacheHit();
                        okResponseCache.update(this.cacheResponse, this.policy.getHttpConnectionToCache());
                        this.initContentStream(this.cachedResponseBody);
                        return;
                    }
                    Util.closeQuietly(this.cachedResponseBody);
                }
                if (this.hasResponseBody()) {
                    this.maybeCache();
                }
                this.initContentStream(this.transport.getTransferStream(this.cacheRequest));
            }
        }
    }
    
    public void receiveHeaders(final RawHeaders rawHeaders) throws IOException {
        final CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.uri, rawHeaders.toMultimap(true));
        }
    }
    
    public final void release(final boolean b) {
        if (this.responseBodyIn == this.cachedResponseBody) {
            Util.closeQuietly(this.responseBodyIn);
        }
        if (!this.connectionReleased && this.connection != null) {
            this.connectionReleased = true;
            if (this.transport == null || !this.transport.makeReusable(b, this.requestBodyOut, this.responseTransferIn)) {
                Util.closeQuietly(this.connection);
                this.connection = null;
            }
            else if (this.automaticallyReleaseConnectionToPool) {
                this.client.getConnectionPool().recycle(this.connection);
                this.connection = null;
            }
        }
    }
    
    public final void sendRequest() throws IOException {
        if (this.responseSource == null) {
            this.prepareRawRequestHeaders();
            this.initResponseSource();
            final OkResponseCache okResponseCache = this.client.getOkResponseCache();
            if (okResponseCache != null) {
                okResponseCache.trackResponse(this.responseSource);
            }
            if (this.requestHeaders.isOnlyIfCached() && this.responseSource.requiresConnection()) {
                if (this.responseSource == ResponseSource.CONDITIONAL_CACHE) {
                    Util.closeQuietly(this.cachedResponseBody);
                }
                this.responseSource = ResponseSource.CACHE;
                this.cacheResponse = HttpEngine.GATEWAY_TIMEOUT_RESPONSE;
                this.setResponse(new ResponseHeaders(this.uri, RawHeaders.fromMultimap(this.cacheResponse.getHeaders(), true)), this.cacheResponse.getBody());
            }
            if (this.responseSource.requiresConnection()) {
                this.sendSocketRequest();
                return;
            }
            if (this.connection != null) {
                this.client.getConnectionPool().recycle(this.connection);
                this.connection = null;
            }
        }
    }
    
    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1L) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }
}
