// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

class bk implements t
{
    private final long a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;
    
    public bk(final int b, final long a, final String f) {
        this.e = new Object();
        this.b = b;
        this.c = this.b;
        this.a = a;
        this.f = f;
    }
    
    public bk(final String s) {
        this(60, 2000L, s);
    }
    
    @Override
    public boolean a() {
        synchronized (this.e) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (this.c < this.b) {
                final double n = (currentTimeMillis - this.d) / this.a;
                if (n > 0.0) {
                    this.c = Math.min(this.b, n + this.c);
                }
            }
            this.d = currentTimeMillis;
            if (this.c >= 1.0) {
                --this.c;
                return true;
            }
            p.d("Excessive " + this.f + " detected; call ignored.");
            return false;
        }
    }
}
