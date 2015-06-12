// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

abstract class a extends Reader
{
    protected final c a;
    protected InputStream b;
    protected byte[] c;
    protected int d;
    protected int e;
    protected char[] f;
    
    protected a(final c a, final InputStream b, final byte[] c, final int d, final int e) {
        this.f = null;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final void a() {
        final byte[] c = this.c;
        if (c != null) {
            this.c = null;
            this.a.a(c);
        }
    }
    
    protected void a(final char[] array, final int i, final int j) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i + "," + j + "), cbuf[" + array.length + "]");
    }
    
    protected void b() {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }
    
    @Override
    public void close() {
        final InputStream b = this.b;
        if (b != null) {
            this.b = null;
            this.a();
            b.close();
        }
    }
    
    @Override
    public int read() {
        if (this.f == null) {
            this.f = new char[1];
        }
        if (this.read(this.f, 0, 1) < 1) {
            return -1;
        }
        return this.f[0];
    }
}
