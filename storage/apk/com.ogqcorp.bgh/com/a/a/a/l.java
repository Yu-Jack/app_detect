// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.io.ByteArrayOutputStream;

public class l extends ByteArrayOutputStream
{
    private final b a;
    
    public l(final b a, final int a2) {
        this.a = a;
        this.buf = this.a.a(Math.max(a2, 256));
    }
    
    private void a(final int n) {
        if (n + this.count <= this.buf.length) {
            return;
        }
        final byte[] a = this.a.a(2 * (n + this.count));
        System.arraycopy(this.buf, 0, a, 0, this.count);
        this.a.a(this.buf);
        this.buf = a;
    }
    
    @Override
    public void close() {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }
    
    public void finalize() {
        this.a.a(this.buf);
    }
    
    @Override
    public void write(final int b) {
        synchronized (this) {
            this.a(1);
            super.write(b);
        }
    }
    
    @Override
    public void write(final byte[] b, final int off, final int len) {
        synchronized (this) {
            this.a(len);
            super.write(b, off, len);
        }
    }
}
