// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class bz
{
    private final Runnable a;
    private volatile boolean b;
    
    public bz(final by by) {
        this.b = false;
        this.a = new Runnable() {
            private final WeakReference<by> c = new WeakReference<by>(by);
            
            @Override
            public void run() {
                final by by = this.c.get();
                if (!bz.this.b && by != null) {
                    by.e();
                    bz.this.b();
                }
            }
        };
    }
    
    public void a() {
        this.b = true;
        em.a.removeCallbacks(this.a);
    }
    
    public void b() {
        em.a.postDelayed(this.a, 250L);
    }
}
