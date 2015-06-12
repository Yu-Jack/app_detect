// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.io.OutputStream;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.ProtocolException;
import java.io.ByteArrayOutputStream;
import com.squareup.okhttp.internal.AbstractOutputStream;

final class RetryableOutputStream extends AbstractOutputStream
{
    private final ByteArrayOutputStream content;
    private final int limit;
    
    public RetryableOutputStream() {
        this.limit = -1;
        this.content = new ByteArrayOutputStream();
    }
    
    public RetryableOutputStream(final int n) {
        this.limit = n;
        this.content = new ByteArrayOutputStream(n);
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.closed = true;
                if (this.content.size() < this.limit) {
                    throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.size());
                }
            }
        }
    }
    
    public int contentLength() throws IOException {
        synchronized (this) {
            this.close();
            return this.content.size();
        }
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) throws IOException {
        synchronized (this) {
            this.checkNotClosed();
            Util.checkOffsetAndCount(b.length, off, len);
            if (this.limit != -1 && this.content.size() > this.limit - len) {
                throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
            }
        }
        this.content.write(b, off, len);
    }
    // monitorexit(this)
    
    public void writeToSocket(final OutputStream out) throws IOException {
        this.content.writeTo(out);
    }
}
