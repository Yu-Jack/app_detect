// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.g.a.h;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.g.a.d;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.as;

public abstract class a<T> extends e<T> implements as
{
    protected final boolean a;
    protected final org.codehaus.jackson.f.a b;
    protected final ba c;
    protected ad<Object> d;
    protected final f e;
    protected d f;
    
    protected a(final Class<?> clazz, final org.codehaus.jackson.f.a b, final boolean b2, final ba c, final f e, final ad<Object> d) {
        super(clazz, false);
        this.b = b;
        boolean a = false;
        Label_0039: {
            if (!b2) {
                a = false;
                if (b == null) {
                    break Label_0039;
                }
                final boolean u = b.u();
                a = false;
                if (!u) {
                    break Label_0039;
                }
            }
            a = true;
        }
        this.a = a;
        this.c = c;
        this.e = e;
        this.d = d;
        this.f = org.codehaus.jackson.c.g.a.d.a();
    }
    
    protected final ad<Object> a(final d d, final Class<?> clazz, final ax ax) {
        final h a = d.a(clazz, ax, this.e);
        if (d != a.b) {
            this.f = a.b;
        }
        return a.a;
    }
    
    protected final ad<Object> a(final d d, final org.codehaus.jackson.f.a a, final ax ax) {
        final h a2 = d.a(a, ax, this.e);
        if (d != a2.b) {
            this.f = a2.b;
        }
        return a2.a;
    }
    
    @Override
    public final void a(final T t, final org.codehaus.jackson.f f, final ax ax) {
        f.b();
        this.b(t, f, ax);
        f.c();
    }
    
    @Override
    public final void a(final T t, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.c(t, f);
        this.b(t, f, ax);
        ba.f(t, f);
    }
    
    @Override
    public void a(final ax ax) {
        if (this.a && this.b != null && this.d == null) {
            this.d = ax.a(this.b, this.e);
        }
    }
    
    protected abstract void b(final T p0, final org.codehaus.jackson.f p1, final ax p2);
}
