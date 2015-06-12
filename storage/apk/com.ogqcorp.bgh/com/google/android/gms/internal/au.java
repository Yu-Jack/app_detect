// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class au extends bi
{
    private final Object a;
    private ay b;
    private at c;
    
    public au() {
        this.a = new Object();
    }
    
    public void a() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.j();
            }
        }
    }
    
    public void a(final int n) {
        while (true) {
            while (true) {
                Label_0046: {
                    synchronized (this.a) {
                        if (this.b != null) {
                            if (n != 3) {
                                break Label_0046;
                            }
                            final int n2 = 1;
                            this.b.a(n2);
                            this.b = null;
                        }
                        return;
                    }
                }
                final int n2 = 2;
                continue;
            }
        }
    }
    
    public void a(final at c) {
        synchronized (this.a) {
            this.c = c;
        }
    }
    
    public void a(final ay b) {
        synchronized (this.a) {
            this.b = b;
        }
    }
    
    public void b() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.k();
            }
        }
    }
    
    public void c() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.l();
            }
        }
    }
    
    public void d() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c.m();
            }
        }
    }
    
    public void e() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a(0);
                this.b = null;
                return;
            }
            if (this.c != null) {
                this.c.n();
            }
        }
    }
}
