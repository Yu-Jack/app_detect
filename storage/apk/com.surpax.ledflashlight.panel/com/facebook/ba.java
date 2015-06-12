// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.os.Handler;

final class ba
{
    private final Request a;
    private final Handler b;
    private final long c;
    private long d;
    private long e;
    private long f;
    
    ba(final Handler b, final Request a) {
        this.a = a;
        this.b = b;
        this.c = bq.f();
    }
    
    final void a() {
        if (this.d > this.e) {
            final aq d = this.a.d();
            if (this.f > 0L && d instanceof at) {
                final long d2 = this.d;
                final long f = this.f;
                final at at = (at)d;
                if (this.b != null) {
                    this.b.post((Runnable)new Runnable() {
                        @Override
                        public final void run() {
                            final at b = at;
                            final long c = d2;
                            final long d = f;
                        }
                    });
                }
                this.e = this.d;
            }
        }
    }
    
    final void a(final long n) {
        this.d += n;
        if (this.d >= this.e + this.c || this.d >= this.f) {
            this.a();
        }
    }
    
    final void b(final long n) {
        this.f += n;
    }
}
