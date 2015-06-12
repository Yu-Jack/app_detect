// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class az extends FilterInputStream
{
    private final long a;
    private long b;
    
    public az(final InputStream in, final long a) {
        super(in);
        this.a = a;
    }
    
    private int a(final int n) {
        this.b += n;
        if (this.b > this.a) {
            throw new IOException("Size limit exceeded: " + this.a + " bytes, read " + this.b + " bytes!");
        }
        return n;
    }
    
    @Override
    public void close() {
        this.in = null;
    }
    
    @Override
    public int read() {
        return this.a(super.read());
    }
    
    @Override
    public int read(final byte[] b) {
        return this.a(super.read(b));
    }
    
    @Override
    public int read(final byte[] b, final int off, final int len) {
        return this.a(super.read(b, off, len));
    }
}
