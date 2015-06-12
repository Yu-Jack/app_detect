// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

public final class lm
{
    private final ln a;
    private final Runnable b;
    private ah c;
    private boolean d;
    private boolean e;
    private long f;
    
    public lm(final li li) {
        this(li, new ln(em.a));
    }
    
    lm(final li li, final ln a) {
        this.d = false;
        this.e = false;
        this.f = 0L;
        this.a = a;
        this.b = new Runnable() {
            private final WeakReference<li> c = new WeakReference<li>(li);
            
            @Override
            public void run() {
                lm.this.d = false;
                final li li = this.c.get();
                if (li != null) {
                    li.b(lm.this.c);
                }
            }
        };
    }
    
    public void a() {
        this.d = false;
        this.a.a(this.b);
    }
    
    public void a(final ah ah) {
        this.a(ah, 60000L);
    }
    
    public void a(final ah c, final long n) {
        if (this.d) {
            en.e("An ad refresh is already scheduled.");
        }
        else {
            this.c = c;
            this.d = true;
            this.f = n;
            if (!this.e) {
                en.c("Scheduling ad refresh " + n + " milliseconds from now.");
                this.a.a(this.b, n);
            }
        }
    }
    
    public void b() {
        this.e = true;
        if (this.d) {
            this.a.a(this.b);
        }
    }
    
    public void c() {
        this.e = false;
        if (this.d) {
            this.d = false;
            this.a(this.c, this.f);
        }
    }
}
