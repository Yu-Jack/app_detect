// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.concurrent.TimeUnit;
import java.net.SocketPermission;
import java.net.InetSocketAddress;
import java.security.Permission;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.io.InputStream;
import java.io.Closeable;
import com.squareup.okhttp.internal.Platform;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import com.squareup.okhttp.internal.Util;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import java.net.ProtocolException;
import com.squareup.okhttp.Connection;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.URL;
import java.net.Proxy;
import java.io.IOException;
import com.squareup.okhttp.OkHttpClient;
import java.net.HttpURLConnection;

public class HttpURLConnectionImpl extends HttpURLConnection implements Policy
{
    public static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    final OkHttpClient client;
    private long fixedContentLength;
    protected HttpEngine httpEngine;
    protected IOException httpEngineFailure;
    private final RawHeaders rawRequestHeaders;
    private int redirectionCount;
    private Proxy selectedProxy;
    
    public HttpURLConnectionImpl(final URL u, final OkHttpClient client) {
        super(u);
        this.rawRequestHeaders = new RawHeaders();
        this.fixedContentLength = -1L;
        this.client = client;
    }
    
    private boolean execute(final boolean b) throws IOException {
        try {
            this.httpEngine.sendRequest();
            if (b) {
                this.httpEngine.readResponse();
            }
            return true;
        }
        catch (IOException ex) {
            if (this.handleFailure(ex)) {
                return false;
            }
            throw ex;
        }
    }
    
    private HttpEngine getResponse() throws IOException {
        this.initHttpEngine();
        if (this.httpEngine.hasResponse()) {
            return this.httpEngine;
        }
        while (true) {
            if (this.execute(true)) {
                final Retry processResponseHeaders = this.processResponseHeaders();
                if (processResponseHeaders == Retry.NONE) {
                    this.httpEngine.automaticallyReleaseConnectionToPool();
                    return this.httpEngine;
                }
                String method = this.method;
                OutputStream requestBody = this.httpEngine.getRequestBody();
                final int responseCode = this.httpEngine.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303) {
                    method = "GET";
                    requestBody = null;
                }
                if (requestBody != null && !(requestBody instanceof RetryableOutputStream)) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
                }
                if (processResponseHeaders == Retry.DIFFERENT_CONNECTION) {
                    this.httpEngine.automaticallyReleaseConnectionToPool();
                }
                this.httpEngine.release(false);
                this.httpEngine = this.newHttpEngine(method, this.rawRequestHeaders, this.httpEngine.getConnection(), (RetryableOutputStream)requestBody);
                if (requestBody != null) {
                    continue;
                }
                this.httpEngine.getRequestHeaders().removeContentLength();
            }
        }
    }
    
    private boolean handleFailure(final IOException httpEngineFailure) throws IOException {
        final RouteSelector routeSelector = this.httpEngine.routeSelector;
        if (routeSelector != null && this.httpEngine.connection != null) {
            routeSelector.connectFailed(this.httpEngine.connection, httpEngineFailure);
        }
        final OutputStream requestBody = this.httpEngine.getRequestBody();
        boolean b;
        if (requestBody != null && !(requestBody instanceof RetryableOutputStream)) {
            b = false;
        }
        else {
            b = true;
        }
        if ((routeSelector == null && this.httpEngine.connection == null) || (routeSelector != null && !routeSelector.hasNext()) || !this.isRecoverable(httpEngineFailure) || !b) {
            this.httpEngineFailure = httpEngineFailure;
            return false;
        }
        this.httpEngine.release(true);
        this.httpEngine = this.newHttpEngine(this.method, this.rawRequestHeaders, null, (RetryableOutputStream)requestBody);
        this.httpEngine.routeSelector = routeSelector;
        return true;
    }
    
    private void initHttpEngine() throws IOException {
        if (this.httpEngineFailure != null) {
            throw this.httpEngineFailure;
        }
        if (this.httpEngine != null) {
            return;
        }
        while (true) {
            this.connected = true;
            while (true) {
                Label_0077: {
                    try {
                        if (this.doOutput) {
                            if (!this.method.equals("GET")) {
                                break Label_0077;
                            }
                            this.method = "POST";
                        }
                        this.httpEngine = this.newHttpEngine(this.method, this.rawRequestHeaders, null, null);
                        return;
                    }
                    catch (IOException httpEngineFailure) {
                        throw this.httpEngineFailure = httpEngineFailure;
                    }
                }
                if (!this.method.equals("POST") && !this.method.equals("PUT") && !this.method.equals("PATCH")) {
                    break;
                }
                continue;
            }
        }
        throw new ProtocolException(String.valueOf(this.method) + " does not support writing");
    }
    
    private boolean isRecoverable(final IOException ex) {
        boolean b;
        if (ex instanceof SSLHandshakeException && ex.getCause() instanceof CertificateException) {
            b = true;
        }
        else {
            b = false;
        }
        final boolean b2 = ex instanceof ProtocolException;
        return !b && !b2;
    }
    
    private static boolean isValidNonDirectProxy(final Proxy proxy) {
        return proxy != null && proxy.type() != Proxy.Type.DIRECT;
    }
    
    private HttpEngine newHttpEngine(final String s, final RawHeaders rawHeaders, final Connection connection, final RetryableOutputStream retryableOutputStream) throws IOException {
        if (this.url.getProtocol().equals("http")) {
            return new HttpEngine(this.client, this, s, rawHeaders, connection, retryableOutputStream);
        }
        if (this.url.getProtocol().equals("https")) {
            return new HttpsEngine(this.client, this, s, rawHeaders, connection, retryableOutputStream);
        }
        throw new AssertionError();
    }
    
    private Retry processResponseHeaders() throws IOException {
        Proxy proxy;
        if (this.httpEngine.connection != null) {
            proxy = this.httpEngine.connection.getRoute().getProxy();
        }
        else {
            proxy = this.client.getProxy();
        }
        final int responseCode = this.getResponseCode();
        switch (responseCode) {
            default: {
                return Retry.NONE;
            }
            case 407: {
                if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            case 401: {
                if (HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), this.getResponseCode(), this.httpEngine.getResponseHeaders().getHeaders(), this.rawRequestHeaders, proxy, this.url)) {
                    return Retry.SAME_CONNECTION;
                }
                return Retry.NONE;
            }
            case 300:
            case 301:
            case 302:
            case 303:
            case 307: {
                if (!this.getInstanceFollowRedirects()) {
                    return Retry.NONE;
                }
                if (++this.redirectionCount > 20) {
                    throw new ProtocolException("Too many redirects: " + this.redirectionCount);
                }
                if (responseCode == 307 && !this.method.equals("GET") && !this.method.equals("HEAD")) {
                    return Retry.NONE;
                }
                final String headerField = this.getHeaderField("Location");
                if (headerField == null) {
                    return Retry.NONE;
                }
                final URL url = this.url;
                this.url = new URL(url, headerField);
                if (!this.url.getProtocol().equals("https") && !this.url.getProtocol().equals("http")) {
                    return Retry.NONE;
                }
                final boolean equals = url.getProtocol().equals(this.url.getProtocol());
                if (!equals && !this.client.getFollowProtocolRedirects()) {
                    return Retry.NONE;
                }
                final boolean equals2 = url.getHost().equals(this.url.getHost());
                int n;
                if (Util.getEffectivePort(url) == Util.getEffectivePort(this.url)) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (equals2 && n != 0 && equals) {
                    return Retry.SAME_CONNECTION;
                }
                return Retry.DIFFERENT_CONNECTION;
            }
        }
    }
    
    private void setTransports(final String s, final boolean b) {
        final ArrayList<Object> transports = new ArrayList<Object>();
        if (b) {
            transports.addAll(this.client.getTransports());
        }
        final String[] split = s.split(",", -1);
        for (int length = split.length, i = 0; i < length; ++i) {
            transports.add(split[i]);
        }
        this.client.setTransports((List<String>)transports);
    }
    
    @Override
    public final void addRequestProperty(final String s, final String s2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s == null) {
            throw new NullPointerException("field == null");
        }
        if (s2 == null) {
            Platform.get().logW("Ignoring header " + s + " because its value was null.");
            return;
        }
        if ("X-Android-Transports".equals(s)) {
            this.setTransports(s2, true);
            return;
        }
        this.rawRequestHeaders.add(s, s2);
    }
    
    @Override
    public final void connect() throws IOException {
        this.initHttpEngine();
        while (!this.execute(false)) {}
    }
    
    @Override
    public final void disconnect() {
        if (this.httpEngine != null) {
            if (this.httpEngine.hasResponse()) {
                Util.closeQuietly(this.httpEngine.getResponseBody());
            }
            this.httpEngine.release(true);
        }
    }
    
    @Override
    public final int getChunkLength() {
        return this.chunkLength;
    }
    
    @Override
    public int getConnectTimeout() {
        return this.client.getConnectTimeout();
    }
    
    @Override
    public final InputStream getErrorStream() {
        try {
            final HttpEngine response = this.getResponse();
            final boolean hasResponseBody = response.hasResponseBody();
            InputStream responseBody = null;
            if (hasResponseBody) {
                final int responseCode = response.getResponseCode();
                responseBody = null;
                if (responseCode >= 400) {
                    responseBody = response.getResponseBody();
                }
            }
            return responseBody;
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public final long getFixedContentLength() {
        return this.fixedContentLength;
    }
    
    @Override
    public final String getHeaderField(final int n) {
        try {
            return this.getResponse().getResponseHeaders().getHeaders().getValue(n);
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public final String getHeaderField(final String s) {
        try {
            final RawHeaders headers = this.getResponse().getResponseHeaders().getHeaders();
            if (s == null) {
                return headers.getStatusLine();
            }
            return headers.get(s);
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public final String getHeaderFieldKey(final int n) {
        try {
            return this.getResponse().getResponseHeaders().getHeaders().getFieldName(n);
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    @Override
    public final Map<String, List<String>> getHeaderFields() {
        try {
            return this.getResponse().getResponseHeaders().getHeaders().toMultimap(true);
        }
        catch (IOException ex) {
            return Collections.emptyMap();
        }
    }
    
    @Override
    public HttpURLConnection getHttpConnectionToCache() {
        return this;
    }
    
    public HttpEngine getHttpEngine() {
        return this.httpEngine;
    }
    
    @Override
    public final InputStream getInputStream() throws IOException {
        if (!this.doInput) {
            throw new ProtocolException("This protocol does not support input");
        }
        final HttpEngine response = this.getResponse();
        if (this.getResponseCode() >= 400) {
            throw new FileNotFoundException(this.url.toString());
        }
        final InputStream responseBody = response.getResponseBody();
        if (responseBody == null) {
            throw new ProtocolException("No response body exists; responseCode=" + this.getResponseCode());
        }
        return responseBody;
    }
    
    @Override
    public final OutputStream getOutputStream() throws IOException {
        this.connect();
        final OutputStream requestBody = this.httpEngine.getRequestBody();
        if (requestBody == null) {
            throw new ProtocolException("method does not support a request body: " + this.method);
        }
        if (this.httpEngine.hasResponse()) {
            throw new ProtocolException("cannot write request body after response has been read");
        }
        return requestBody;
    }
    
    @Override
    public final Permission getPermission() throws IOException {
        String obj = this.getURL().getHost();
        int i = Util.getEffectivePort(this.getURL());
        if (this.usingProxy()) {
            final InetSocketAddress inetSocketAddress = (InetSocketAddress)this.client.getProxy().address();
            obj = inetSocketAddress.getHostName();
            i = inetSocketAddress.getPort();
        }
        return new SocketPermission(String.valueOf(obj) + ":" + i, "connect, resolve");
    }
    
    @Override
    public int getReadTimeout() {
        return this.client.getReadTimeout();
    }
    
    @Override
    public final Map<String, List<String>> getRequestProperties() {
        if (this.connected) {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        }
        return this.rawRequestHeaders.toMultimap(false);
    }
    
    @Override
    public final String getRequestProperty(final String s) {
        if (s == null) {
            return null;
        }
        return this.rawRequestHeaders.get(s);
    }
    
    @Override
    public final int getResponseCode() throws IOException {
        return this.getResponse().getResponseCode();
    }
    
    @Override
    public String getResponseMessage() throws IOException {
        return this.getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }
    
    @Override
    public void setConnectTimeout(final int n) {
        this.client.setConnectTimeout(n, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public void setFixedLengthStreamingMode(final int n) {
        this.setFixedLengthStreamingMode((long)n);
    }
    
    @Override
    public void setFixedLengthStreamingMode(final long n) {
        if (super.connected) {
            throw new IllegalStateException("Already connected");
        }
        if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (n < 0L) {
            throw new IllegalArgumentException("contentLength < 0");
        }
        this.fixedContentLength = n;
        super.fixedContentLength = (int)Math.min(n, 2147483647L);
    }
    
    @Override
    public void setReadTimeout(final int n) {
        this.client.setReadTimeout(n, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public final void setRequestProperty(final String s, final String s2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s == null) {
            throw new NullPointerException("field == null");
        }
        if (s2 == null) {
            Platform.get().logW("Ignoring header " + s + " because its value was null.");
            return;
        }
        if ("X-Android-Transports".equals(s)) {
            this.setTransports(s2, false);
            return;
        }
        this.rawRequestHeaders.set(s, s2);
    }
    
    @Override
    public final void setSelectedProxy(final Proxy selectedProxy) {
        this.selectedProxy = selectedProxy;
    }
    
    @Override
    public final boolean usingProxy() {
        if (this.selectedProxy != null) {
            return isValidNonDirectProxy(this.selectedProxy);
        }
        return isValidNonDirectProxy(this.client.getProxy());
    }
    
    enum Retry
    {
        DIFFERENT_CONNECTION("DIFFERENT_CONNECTION", 2), 
        NONE("NONE", 0), 
        SAME_CONNECTION("SAME_CONNECTION", 1);
        
        private Retry(final String name, final int ordinal) {
        }
    }
}
