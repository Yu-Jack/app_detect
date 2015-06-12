// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpsEngine;
import com.squareup.okhttp.internal.http.RetryableOutputStream;
import java.net.HttpURLConnection;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.net.URL;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import java.net.ProtocolException;
import java.net.Proxy;
import java.io.IOException;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Policy;

final class Job implements Runnable, Policy
{
    private final OkHttpClient client;
    private final Dispatcher dispatcher;
    private Request request;
    private final Response.Receiver responseReceiver;
    
    public Job(final Dispatcher dispatcher, final OkHttpClient client, final Request request, final Response.Receiver responseReceiver) {
        this.dispatcher = dispatcher;
        this.client = client;
        this.request = request;
        this.responseReceiver = responseReceiver;
    }
    
    private Response execute() throws IOException {
        Connection connection = null;
        Response response = null;
        while (true) {
            final HttpEngine engine = this.newEngine(connection);
            final Request.Body body = this.request.body();
            if (body != null) {
                final MediaType contentType = body.contentType();
                if (contentType == null) {
                    throw new IllegalStateException("contentType == null");
                }
                if (engine.getRequestHeaders().getContentType() == null) {
                    engine.getRequestHeaders().setContentType(contentType.toString());
                }
            }
            engine.sendRequest();
            if (body != null) {
                body.writeTo(engine.getRequestBody());
            }
            engine.readResponse();
            final Response build = new Response.Builder(this.request, engine.getResponseCode()).rawHeaders(engine.getResponseHeaders().getHeaders()).body(new Dispatcher.RealResponseBody(engine.getResponseHeaders(), engine.getResponseBody())).redirectedBy(response).build();
            final Request processResponse = this.processResponse(engine, build);
            if (processResponse == null) {
                engine.automaticallyReleaseConnectionToPool();
                return build;
            }
            if (this.sameConnection(this.request, processResponse)) {
                connection = engine.getConnection();
            }
            else {
                connection = null;
            }
            response = build;
            this.request = processResponse;
        }
    }
    
    private Request processResponse(final HttpEngine httpEngine, final Response response) throws IOException {
        final Request request = response.request();
        Proxy proxy;
        if (httpEngine.getConnection() != null) {
            proxy = httpEngine.getConnection().getRoute().getProxy();
        }
        else {
            proxy = this.client.getProxy();
        }
        final int code = response.code();
        switch (code) {
            case 407: {
                if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            case 401: {
                final RawHeaders rawHeaders = request.rawHeaders();
                Request build;
                if (HttpAuthenticator.processAuthHeader(this.client.getAuthenticator(), response.code(), response.rawHeaders(), rawHeaders, proxy, this.request.url())) {
                    build = request.newBuilder().rawHeaders(rawHeaders).build();
                }
                else {
                    build = null;
                }
                return build;
            }
            case 300:
            case 301:
            case 302:
            case 303:
            case 307: {
                final String method = request.method();
                if (code == 307 && !method.equals("GET") && !method.equals("HEAD")) {
                    break;
                }
                final String header = response.header("Location");
                if (header == null) {
                    break;
                }
                final URL url = new URL(request.url(), header);
                if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                    return this.request.newBuilder().url(url).build();
                }
                break;
            }
        }
        return null;
    }
    
    private boolean sameConnection(final Request request, final Request request2) {
        return request.url().getHost().equals(request2.url().getHost()) && Util.getEffectivePort(request.url()) == Util.getEffectivePort(request2.url()) && request.url().getProtocol().equals(request2.url().getProtocol());
    }
    
    @Override
    public int getChunkLength() {
        if (this.request.body().contentLength() == -1L) {
            return 1024;
        }
        return -1;
    }
    
    @Override
    public long getFixedContentLength() {
        return this.request.body().contentLength();
    }
    
    @Override
    public HttpURLConnection getHttpConnectionToCache() {
        return null;
    }
    
    @Override
    public long getIfModifiedSince() {
        return 0L;
    }
    
    @Override
    public URL getURL() {
        return this.request.url();
    }
    
    @Override
    public boolean getUseCaches() {
        return false;
    }
    
    HttpEngine newEngine(final Connection connection) throws IOException {
        final String protocol = this.request.url().getProtocol();
        final RawHeaders rawHeaders = this.request.rawHeaders();
        if (protocol.equals("http")) {
            return new HttpEngine(this.client, this, this.request.method(), rawHeaders, connection, null);
        }
        if (protocol.equals("https")) {
            return new HttpsEngine(this.client, this, this.request.method(), rawHeaders, connection, null);
        }
        throw new AssertionError();
    }
    
    @Override
    public void run() {
        try {
            this.responseReceiver.onResponse(this.execute());
        }
        catch (IOException ex) {
            this.responseReceiver.onFailure(new Failure.Builder().request(this.request).exception(ex).build());
        }
        finally {
            this.dispatcher.finished(this);
        }
    }
    
    @Override
    public void setSelectedProxy(final Proxy proxy) {
    }
    
    Object tag() {
        return this.request.tag();
    }
    
    @Override
    public boolean usingProxy() {
        return false;
    }
}
