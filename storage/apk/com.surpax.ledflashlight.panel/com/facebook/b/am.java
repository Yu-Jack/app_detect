// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import com.facebook.bq;
import java.util.concurrent.Executor;

class am
{
    private final Object b;
    private ao c;
    private final int d;
    private final Executor e;
    private ao f;
    private int g;
    
    static {
        a = !am.class.desiredAssertionStatus();
    }
    
    am() {
        this(8);
    }
    
    am(final int n) {
        this(n, bq.b());
    }
    
    private am(final int d, final Executor e) {
        this.b = new Object();
        this.f = null;
        this.g = 0;
        this.d = d;
        this.e = e;
    }
    
    private void a(final ao ao) {
        final Object b = this.b;
        // monitorenter(b)
        Label_0033: {
            if (ao == null) {
                break Label_0033;
            }
            try {
                this.f = ao.a(this.f);
                --this.g;
                final int g = this.g;
                final int d = this.d;
                ao c = null;
                if (g < d) {
                    c = this.c;
                    if (c != null) {
                        this.c = c.a(this.c);
                        this.f = c.a(this.f, false);
                        ++this.g;
                        c.d();
                    }
                }
                // monitorexit(b)
                if (c != null) {
                    this.e.execute(new Runnable() {
                        @Override
                        public final void run() {
                            try {
                                c.c().run();
                            }
                            finally {
                                am.this.a(c);
                            }
                        }
                    });
                }
            }
            finally {
            }
            // monitorexit(b)
        }
    }
    
    private an b(final Runnable runnable) {
        final ao ao = new ao(this, runnable);
        synchronized (this.b) {
            this.c = ao.a(this.c, true);
            // monitorexit(this.b)
            this.a((ao)null);
            return ao;
        }
    }
    
    final an a(final Runnable runnable) {
        return this.b(runnable);
    }
}
