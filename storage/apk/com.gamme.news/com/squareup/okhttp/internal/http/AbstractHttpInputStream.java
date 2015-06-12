// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.CacheRequest;
import java.io.OutputStream;
import java.io.InputStream;

abstract class AbstractHttpInputStream extends InputStream
{
    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    protected boolean closed;
    protected final HttpEngine httpEngine;
    protected final InputStream in;
    
    AbstractHttpInputStream(final InputStream in, final HttpEngine httpEngine, CacheRequest cacheRequest) throws IOException {
        this.in = in;
        this.httpEngine = httpEngine;
        OutputStream body;
        if (cacheRequest != null) {
            body = cacheRequest.getBody();
        }
        else {
            body = null;
        }
        if (body == null) {
            cacheRequest = null;
        }
        this.cacheBody = body;
        this.cacheRequest = cacheRequest;
    }
    
    protected final void cacheWrite(final byte[] b, final int off, final int len) throws IOException {
        if (this.cacheBody != null) {
            this.cacheBody.write(b, off, len);
        }
    }
    
    protected final void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
    }
    
    protected final void endOfInput() throws IOException {
        if (this.cacheRequest != null) {
            this.cacheBody.close();
        }
        this.httpEngine.release(false);
    }
    
    @Override
    public final int read() throws IOException {
        return Util.readSingleByte(this);
    }
    
    protected final void unexpectedEndOfInput() {
        if (this.cacheRequest != null) {
            this.cacheRequest.abort();
        }
        this.httpEngine.release(true);
    }
}
