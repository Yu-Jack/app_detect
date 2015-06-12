// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.OutputStream;
import java.io.InputStream;

final class f extends InputStream
{
    final InputStream a;
    final OutputStream b;
    
    f(final InputStream a, final OutputStream b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final int available() {
        return this.a.available();
    }
    
    @Override
    public final void close() {
        try {
            this.a.close();
        }
        finally {
            this.b.close();
        }
    }
    
    @Override
    public final void mark(final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final boolean markSupported() {
        return false;
    }
    
    @Override
    public final int read() {
        final int read = this.a.read();
        if (read >= 0) {
            this.b.write(read);
        }
        return read;
    }
    
    @Override
    public final int read(final byte[] array) {
        final int read = this.a.read(array);
        if (read > 0) {
            this.b.write(array, 0, read);
        }
        return read;
    }
    
    @Override
    public final int read(final byte[] array, final int n, final int len) {
        final int read = this.a.read(array, n, len);
        if (read > 0) {
            this.b.write(array, n, read);
        }
        return read;
    }
    
    @Override
    public final void reset() {
        synchronized (this) {
            throw new UnsupportedOperationException();
        }
    }
    
    @Override
    public final long skip(final long n) {
        final byte[] array = new byte[1024];
        long n2;
        int read;
        for (n2 = 0L; n2 < n; n2 += read) {
            read = this.read(array, 0, (int)Math.min(n - n2, array.length));
            if (read < 0) {
                break;
            }
        }
        return n2;
    }
}
