// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.at;
import org.codehaus.jackson.c.i.p;
import org.codehaus.jackson.c.a.b;

@b
public class h extends s<Enum<?>>
{
    protected final p a;
    
    public h(final p a) {
        super(Enum.class, false);
        this.a = a;
    }
    
    public static h a(final Class<Enum<?>> clazz, final at at, final k k) {
        final org.codehaus.jackson.c.b a = at.a();
        p p3;
        if (at.a(au.t)) {
            p3 = p.c(clazz, a);
        }
        else {
            p3 = p.b(clazz, a);
        }
        return new h(p3);
    }
    
    @Override
    public final void a(final Enum<?> enum1, final f f, final ax ax) {
        if (ax.a(au.u)) {
            f.b(enum1.ordinal());
            return;
        }
        f.b(this.a.a(enum1));
    }
    
    public p d() {
        return this.a;
    }
}
