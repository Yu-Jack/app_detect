// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.g.a.p;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.g.b.b;

public class e extends b
{
    public e(final Class<?> clazz, final d[] array, final d[] array2, final a a, final Object o) {
        super(clazz, array, array2, a, o);
    }
    
    public e(final org.codehaus.jackson.f.a a, final d[] array, final d[] array2, final a a2, final Object o) {
        super(a, array, array2, a2, o);
    }
    
    public static e a(final Class<?> clazz) {
        return new e(clazz, e.a, null, null, null);
    }
    
    @Override
    public ad<Object> a() {
        return new p(this);
    }
    
    @Override
    public final void a(final Object o, final f f, final ax ax) {
        f.d();
        if (this.e != null) {
            this.c(o, f, ax);
        }
        else {
            this.b(o, f, ax);
        }
        f.e();
    }
    
    @Override
    public String toString() {
        return "BeanSerializer for " + this.c().getName();
    }
}
