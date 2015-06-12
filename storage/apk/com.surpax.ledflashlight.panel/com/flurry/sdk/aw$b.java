// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.IOException;
import java.io.BufferedInputStream;
import java.util.zip.GZIPInputStream;
import java.io.InputStream;
import java.io.Closeable;

public class aw$b implements Closeable
{
    final /* synthetic */ aw a;
    private final fh$c b;
    private final InputStream c;
    private final GZIPInputStream d;
    private final BufferedInputStream e;
    private boolean f;
    
    private aw$b(final aw a, final fh$c b, final boolean b2) {
        this.a = a;
        if (b == null) {
            throw new IllegalArgumentException("Snapshot cannot be null");
        }
        this.b = b;
        this.c = this.b.a(0);
        if (this.c == null) {
            throw new IOException("Snapshot inputstream is null");
        }
        if (!b2) {
            this.d = null;
            this.e = new BufferedInputStream(this.c);
            return;
        }
        this.d = new GZIPInputStream(this.c);
        if (this.d == null) {
            throw new IOException("Gzip inputstream is null");
        }
        this.e = new BufferedInputStream(this.d);
    }
    
    public InputStream a() {
        return this.e;
    }
    
    @Override
    public void close() {
        if (this.f) {
            return;
        }
        this.f = true;
        fe.a(this.e);
        fe.a(this.d);
        fe.a(this.c);
        fe.a(this.b);
    }
    
    @Override
    protected void finalize() {
        super.finalize();
        this.close();
    }
}
