// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import com.facebook.bq;
import java.util.concurrent.Executor;

final class ao implements an
{
    static final /* synthetic */ boolean b;
    final /* synthetic */ am a;
    private final Runnable c;
    private ao d;
    private ao e;
    private boolean f;
    
    static {
        b = !am.class.desiredAssertionStatus();
    }
    
    ao(final am a, final Runnable c) {
        this.a = a;
        this.c = c;
    }
    
    final ao a(ao d) {
        if (!ao.b && this.d == null) {
            throw new AssertionError();
        }
        if (!ao.b && this.e == null) {
            throw new AssertionError();
        }
        if (d == this) {
            if (this.d == this) {
                d = null;
            }
            else {
                d = this.d;
            }
        }
        this.d.e = this.e;
        this.e.d = this.d;
        this.e = null;
        this.d = null;
        return d;
    }
    
    final ao a(final ao d, final boolean b) {
        if (!ao.b && this.d != null) {
            throw new AssertionError();
        }
        if (!ao.b && this.e != null) {
            throw new AssertionError();
        }
        ao ao;
        if (d == null) {
            this.e = this;
            this.d = this;
            ao = this;
        }
        else {
            this.d = d;
            this.e = d.e;
            final ao d2 = this.d;
            this.e.d = this;
            d2.e = this;
            ao = d;
        }
        if (b) {
            return this;
        }
        return ao;
    }
    
    @Override
    public final boolean a() {
        synchronized (this.a.b) {
            if (!this.f) {
                am.a(this.a, this.a(this.a.c));
                return true;
            }
            return false;
        }
    }
    
    @Override
    public final void b() {
        synchronized (this.a.b) {
            if (!this.f) {
                am.a(this.a, this.a(this.a.c));
                am.a(this.a, this.a(this.a.c, true));
            }
        }
    }
    
    final Runnable c() {
        return this.c;
    }
    
    final void d() {
        this.f = true;
    }
}
