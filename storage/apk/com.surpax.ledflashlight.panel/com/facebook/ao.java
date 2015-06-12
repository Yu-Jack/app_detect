// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.os.Handler;
import java.util.Iterator;
import java.io.OutputStream;
import java.util.Map;
import java.io.FilterOutputStream;

final class ao extends FilterOutputStream implements az
{
    private final Map a;
    private final aw b;
    private final long c;
    private long d;
    private long e;
    private long f;
    private ba g;
    
    ao(final OutputStream out, final aw b, final Map a, final long f) {
        super(out);
        this.b = b;
        this.a = a;
        this.f = f;
        this.c = bq.f();
    }
    
    private void a() {
        if (this.d > this.e) {
            for (final ax ax : this.b.e()) {
                if (ax instanceof ay) {
                    final Handler c = this.b.c();
                    final ay ay = (ay)ax;
                    if (c == null) {
                        final aw b = this.b;
                        final long d = this.d;
                        final long f = this.f;
                    }
                    else {
                        c.post((Runnable)new Runnable() {
                            @Override
                            public final void run() {
                                final ay b = ay;
                                ao.this.b;
                                ao.this.d;
                                ao.this.f;
                            }
                        });
                    }
                }
            }
            this.e = this.d;
        }
    }
    
    private void a(final long n) {
        if (this.g != null) {
            this.g.a(n);
        }
        this.d += n;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            this.a();
        }
    }
    
    @Override
    public final void a(final Request request) {
        ba g;
        if (request != null) {
            g = this.a.get(request);
        }
        else {
            g = null;
        }
        this.g = g;
    }
    
    @Override
    public final void close() {
        super.close();
        final Iterator<ba> iterator = this.a.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
        this.a();
    }
    
    @Override
    public final void write(final int n) {
        this.out.write(n);
        this.a(1L);
    }
    
    @Override
    public final void write(final byte[] b) {
        this.out.write(b);
        this.a(b.length);
    }
    
    @Override
    public final void write(final byte[] b, final int off, final int len) {
        this.out.write(b, off, len);
        this.a(len);
    }
}
