// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.b.i;
import org.codehaus.jackson.c.b.h;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;

public final class n
{
    final k a;
    final p b;
    final Object[] c;
    private int d;
    private j e;
    
    public n(final k a, final p b, final int d) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.c = new Object[d];
    }
    
    protected j a() {
        return this.e;
    }
    
    public void a(final Object o, final Object o2) {
        this.e = new l(this.e, o2, o);
    }
    
    public void a(final h h, final String s, final Object o) {
        this.e = new org.codehaus.jackson.c.b.a.k(this.e, o, h, s);
    }
    
    public void a(final i i, final Object o) {
        this.e = new m(this.e, o, i);
    }
    
    public void a(final i[] array) {
        for (int i = 0; i < array.length; ++i) {
            final i j = array[i];
            if (j != null) {
                this.c[i] = this.b.a(j.k(), j, null);
            }
        }
    }
    
    public boolean a(final int n, final Object o) {
        this.c[n] = o;
        final int d = -1 + this.d;
        this.d = d;
        return d <= 0;
    }
    
    protected final Object[] a(final Object[] array) {
        if (array != null) {
            for (int i = 0; i < this.c.length; ++i) {
                if (this.c[i] == null) {
                    final Object o = array[i];
                    if (o != null) {
                        this.c[i] = o;
                    }
                }
            }
        }
        return this.c;
    }
}
