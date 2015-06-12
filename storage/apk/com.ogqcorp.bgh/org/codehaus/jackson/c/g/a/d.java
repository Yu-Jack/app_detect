// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;

public abstract class d
{
    public static d a() {
        return f.a;
    }
    
    public abstract ad<Object> a(final Class<?> p0);
    
    public abstract d a(final Class<?> p0, final ad<Object> p1);
    
    public final h a(final Class<?> clazz, final ax ax, final org.codehaus.jackson.c.f f) {
        final ad<Object> a = ax.a(clazz, f);
        return new h(a, this.a(clazz, a));
    }
    
    public final h a(final a a, final ax ax, final org.codehaus.jackson.c.f f) {
        final ad<Object> a2 = ax.a(a, f);
        return new h(a2, this.a(a.p(), a2));
    }
}
