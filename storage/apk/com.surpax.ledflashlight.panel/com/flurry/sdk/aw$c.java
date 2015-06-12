// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.io.OutputStream;
import java.io.Closeable;

public class aw$c implements Closeable
{
    final /* synthetic */ aw a;
    private final fh$a b;
    private final OutputStream c;
    private final GZIPOutputStream d;
    private final aw$a e;
    private boolean f;
    
    private aw$c(final aw a, final fh$a b, final boolean b2) {
        this.a = a;
        if (b == null) {
            throw new IllegalArgumentException("Editor cannot be null");
        }
        this.b = b;
        this.c = this.b.a(0);
        if (this.b == null) {
            throw new IOException("Editor outputstream is null");
        }
        if (!b2) {
            this.d = null;
            this.e = new aw$a(this.c, null);
            return;
        }
        this.d = new GZIPOutputStream(this.c);
        if (this.d == null) {
            throw new IOException("Gzip outputstream is null");
        }
        this.e = new aw$a(this.d, null);
    }
    
    public OutputStream a() {
        return this.e;
    }
    
    @Override
    public void close() {
        boolean a = true;
        if (!this.f) {
            this.f = a;
            fe.a(this.e);
            fe.a(this.d);
            fe.a(this.c);
            if (this.b != null) {
                while (true) {
                    Label_0094: {
                        if (this.e != null) {
                            break Label_0094;
                        }
                        if (!a) {
                            this.b.a();
                            return;
                        }
                        try {
                            this.b.b();
                            return;
                        }
                        catch (IOException ex) {
                            eo.a(3, aw.a, "Exception closing editor for cache: " + this.a.b, ex);
                            return;
                        }
                    }
                    a = this.e.a();
                    continue;
                }
            }
        }
    }
    
    @Override
    protected void finalize() {
        super.finalize();
        this.close();
    }
}
