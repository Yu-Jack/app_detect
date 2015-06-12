// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.content.Context;
import android.os.Handler;

public abstract class f
{
    protected final g a;
    protected e b;
    private final long c;
    private final Handler d;
    private final Runnable e;
    private Context f;
    private volatile boolean g;
    private volatile boolean h;
    
    public f(final g a, final Context f) {
        this.e = new Runnable() {
            @Override
            public final void run() {
                com.facebook.ads.a.f.this.h = false;
                com.facebook.ads.a.f.this.d();
            }
        };
        this.f = f;
        this.a = a;
        this.c = 1000L;
        this.d = new Handler();
    }
    
    public final e a() {
        return this.b;
    }
    
    public final void a(final e b) {
        this.b = b;
        this.g = false;
        this.h = false;
    }
    
    public final void b() {
        synchronized (this) {
            if ((this.g || this.h) && this.b != null) {
                this.d.postDelayed(this.e, this.c);
                this.h = true;
            }
        }
    }
    
    public final void c() {
        synchronized (this) {
            if (this.h) {
                this.d.removeCallbacks(this.e);
                this.h = false;
            }
        }
    }
    
    public final void d() {
        while (true) {
            Label_0052: {
                synchronized (this) {
                    if (this.b != null && !this.g) {
                        if (this.a == null || this.a.a()) {
                            break Label_0052;
                        }
                        this.b();
                    }
                    return;
                }
            }
            this.e();
            this.g = true;
            r.a(this.f, "Impression logged");
        }
    }
    
    protected abstract void e();
}
