// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.URL;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import java.io.InputStream;
import java.net.CacheRequest;
import java.io.IOException;
import java.io.OutputStream;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import com.squareup.okhttp.internal.spdy.SpdyConnection;

public final class SpdyTransport implements Transport
{
    private final HttpEngine httpEngine;
    private final SpdyConnection spdyConnection;
    private SpdyStream stream;
    
    public SpdyTransport(final HttpEngine httpEngine, final SpdyConnection spdyConnection) {
        this.httpEngine = httpEngine;
        this.spdyConnection = spdyConnection;
    }
    
    @Override
    public OutputStream createRequestBody() throws IOException {
        final long fixedContentLength = this.httpEngine.policy.getFixedContentLength();
        if (fixedContentLength != -1L) {
            this.httpEngine.requestHeaders.setContentLength(fixedContentLength);
        }
        this.writeRequestHeaders();
        return this.stream.getOutputStream();
    }
    
    @Override
    public void flushRequest() throws IOException {
        this.stream.getOutputStream().close();
    }
    
    @Override
    public InputStream getTransferStream(final CacheRequest cacheRequest) throws IOException {
        return new UnknownLengthHttpInputStream(this.stream.getInputStream(), cacheRequest, this.httpEngine);
    }
    
    @Override
    public boolean makeReusable(final boolean b, final OutputStream outputStream, final InputStream inputStream) {
        if (b) {
            if (this.stream == null) {
                return false;
            }
            this.stream.closeLater(ErrorCode.CANCEL);
        }
        return true;
    }
    
    @Override
    public ResponseHeaders readResponseHeaders() throws IOException {
        final RawHeaders fromNameValueBlock = RawHeaders.fromNameValueBlock(this.stream.getResponseHeaders());
        this.httpEngine.receiveHeaders(fromNameValueBlock);
        final ResponseHeaders responseHeaders = new ResponseHeaders(this.httpEngine.uri, fromNameValueBlock);
        responseHeaders.setTransport("spdy/3");
        return responseHeaders;
    }
    
    @Override
    public void writeRequestBody(final RetryableOutputStream retryableOutputStream) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void writeRequestHeaders() throws IOException {
        if (this.stream != null) {
            return;
        }
        this.httpEngine.writingRequestHeaders();
        final RawHeaders headers = this.httpEngine.requestHeaders.getHeaders();
        String s;
        if (this.httpEngine.connection.getHttpMinorVersion() == 1) {
            s = "HTTP/1.1";
        }
        else {
            s = "HTTP/1.0";
        }
        final URL url = this.httpEngine.policy.getURL();
        headers.addSpdyRequestHeaders(this.httpEngine.method, HttpEngine.requestPath(url), s, HttpEngine.getOriginAddress(url), this.httpEngine.uri.getScheme());
        (this.stream = this.spdyConnection.newStream(headers.toNameValueBlock(), this.httpEngine.hasRequestBody(), true)).setReadTimeout(this.httpEngine.client.getReadTimeout());
    }
}
