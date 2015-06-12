// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.OutputStream;

final class e extends OutputStream
{
    final OutputStream a;
    final i b;
    
    e(final OutputStream a, final i b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void close() {
        try {
            this.a.close();
        }
        finally {
            this.b.a();
        }
    }
    
    @Override
    public final void flush() {
        this.a.flush();
    }
    
    @Override
    public final void write(final int n) {
        this.a.write(n);
    }
    
    @Override
    public final void write(final byte[] b) {
        this.a.write(b);
    }
    
    @Override
    public final void write(final byte[] b, final int off, final int len) {
        this.a.write(b, off, len);
    }
}
