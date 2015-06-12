// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import android.os.SystemClock;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

class z
{
    public static final boolean a;
    private final List<aa> b;
    private boolean c;
    
    static {
        a = y.b;
    }
    
    z() {
        this.b = new ArrayList<aa>();
        this.c = false;
    }
    
    private long a() {
        if (this.b.size() == 0) {
            return 0L;
        }
        return this.b.get(-1 + this.b.size()).c - this.b.get(0).c;
    }
    
    public void a(final String s) {
        synchronized (this) {
            this.c = true;
            final long a = this.a();
            if (a > 0L) {
                final long c = this.b.get(0).c;
                y.b("(%-4d ms) %s", a, s);
                final Iterator<aa> iterator = this.b.iterator();
                long n = c;
                while (iterator.hasNext()) {
                    final aa aa = iterator.next();
                    final long c2 = aa.c;
                    y.b("(+%-4d) [%2d] %s", c2 - n, aa.b, aa.a);
                    n = c2;
                }
            }
        }
    }
    
    public void a(final String s, final long n) {
        synchronized (this) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
        }
        this.b.add(new aa(s, n, SystemClock.elapsedRealtime()));
    }
    // monitorexit(this)
    
    @Override
    protected void finalize() {
        if (!this.c) {
            this.a("Request on the loose");
            y.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
