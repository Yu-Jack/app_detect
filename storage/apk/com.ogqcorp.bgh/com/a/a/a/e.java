// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.io.InputStream;
import java.io.FilterInputStream;

class e extends FilterInputStream
{
    private int a;
    
    private e(final InputStream in) {
        super(in);
        this.a = 0;
    }
    
    @Override
    public int read() {
        final int read = super.read();
        if (read != -1) {
            ++this.a;
        }
        return read;
    }
    
    @Override
    public int read(final byte[] b, final int off, final int len) {
        final int read = super.read(b, off, len);
        if (read != -1) {
            this.a += read;
        }
        return read;
    }
}
