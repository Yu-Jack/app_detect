// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.g.d;

public class o extends d
{
    public o(final d d) {
        super(d);
    }
    
    public o(final d d, final ad<Object> ad) {
        super(d, ad);
    }
    
    @Override
    protected ad<Object> a(final org.codehaus.jackson.c.g.a.d d, final Class<?> clazz, final ax ax) {
        ad<Object> ad;
        if (this.o != null) {
            ad = ax.a(ax.a(this.o, clazz), this);
        }
        else {
            ad = ax.a(clazz, this);
        }
        if (!ad.b()) {
            ad = ad.a();
        }
        this.j = this.j.a(clazz, ad);
        return ad;
    }
    
    @Override
    public d a(ad<Object> a) {
        if (this.getClass() != o.class) {
            throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
        }
        if (!a.b()) {
            a = a.a();
        }
        return new o(this, a);
    }
    
    @Override
    public void a(final Object o, final org.codehaus.jackson.f f, final ax ax) {
        final Object a = this.a(o);
        if (a != null) {
            if (a == o) {
                this.b(o);
            }
            if (this.l == null || !this.l.equals(a)) {
                ad<Object> ad = this.i;
                if (ad == null) {
                    final Class<?> class1 = a.getClass();
                    final org.codehaus.jackson.c.g.a.d j = this.j;
                    ad = j.a(class1);
                    if (ad == null) {
                        ad = this.a(j, class1, ax);
                    }
                }
                if (!ad.b()) {
                    f.a(this.g);
                }
                if (this.n == null) {
                    ad.a(a, f, ax);
                    return;
                }
                ad.a(a, f, ax, this.n);
            }
        }
    }
}
