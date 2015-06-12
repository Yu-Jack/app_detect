// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public abstract class ed
{
    private final Runnable a;
    private volatile Thread b;
    
    public ed() {
        this.a = new Runnable() {
            @Override
            public final void run() {
                ed.this.b = Thread.currentThread();
                ed.this.a();
            }
        };
    }
    
    public abstract void a();
    
    public abstract void b();
    
    public final void e() {
        ee.a(this.a);
    }
    
    public final void f() {
        this.b();
        if (this.b != null) {
            this.b.interrupt();
        }
    }
}
