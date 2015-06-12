// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.CacheRequest;
import java.io.InputStream;

final class UnknownLengthHttpInputStream extends AbstractHttpInputStream
{
    private boolean inputExhausted;
    
    UnknownLengthHttpInputStream(final InputStream inputStream, final CacheRequest cacheRequest, final HttpEngine httpEngine) throws IOException {
        super(inputStream, httpEngine, cacheRequest);
    }
    
    @Override
    public int available() throws IOException {
        this.checkNotClosed();
        if (this.in == null) {
            return 0;
        }
        return this.in.available();
    }
    
    @Override
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (!this.inputExhausted) {
                this.unexpectedEndOfInput();
            }
        }
    }
    
    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        Util.checkOffsetAndCount(b.length, off, len);
        this.checkNotClosed();
        if (this.in == null || this.inputExhausted) {
            return -1;
        }
        final int read = this.in.read(b, off, len);
        if (read == -1) {
            this.inputExhausted = true;
            this.endOfInput();
            return -1;
        }
        this.cacheWrite(b, off, read);
        return read;
    }
}
