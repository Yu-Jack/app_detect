// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractOutputStream extends OutputStream
{
    protected boolean closed;
    
    protected final void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
    }
    
    public boolean isClosed() {
        return this.closed;
    }
    
    @Override
    public final void write(final int n) throws IOException {
        this.write(new byte[] { (byte)n });
    }
}
