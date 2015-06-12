// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import java.io.InputStream;

public final class f extends InputStream
{
    protected final c a;
    final InputStream b;
    byte[] c;
    int d;
    final int e;
    
    public f(final c a, final InputStream b, final byte[] c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    private void a() {
        final byte[] c = this.c;
        if (c != null) {
            this.c = null;
            if (this.a != null) {
                this.a.a(c);
            }
        }
    }
    
    @Override
    public int available() {
        if (this.c != null) {
            return this.e - this.d;
        }
        return this.b.available();
    }
    
    @Override
    public void close() {
        this.a();
        this.b.close();
    }
    
    @Override
    public void mark(final int readlimit) {
        if (this.c == null) {
            this.b.mark(readlimit);
        }
    }
    
    @Override
    public boolean markSupported() {
        return this.c == null && this.b.markSupported();
    }
    
    @Override
    public int read() {
        if (this.c != null) {
            final int n = 0xFF & this.c[this.d++];
            if (this.d >= this.e) {
                this.a();
            }
            return n;
        }
        return this.b.read();
    }
    
    @Override
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] b, final int off, int len) {
        if (this.c != null) {
            final int n = this.e - this.d;
            if (len > n) {
                len = n;
            }
            System.arraycopy(this.c, this.d, b, off, len);
            this.d += len;
            if (this.d >= this.e) {
                this.a();
            }
            return len;
        }
        return this.b.read(b, off, len);
    }
    
    @Override
    public void reset() {
        if (this.c == null) {
            this.b.reset();
        }
    }
    
    @Override
    public long skip(long n) {
        long n3;
        if (this.c != null) {
            final int n2 = this.e - this.d;
            if (n2 > n) {
                this.d += (int)n;
                return n;
            }
            this.a();
            n3 = 0L + n2;
            n -= n2;
        }
        else {
            n3 = 0L;
        }
        if (n > 0L) {
            n3 += this.b.skip(n);
        }
        return n3;
    }
}
