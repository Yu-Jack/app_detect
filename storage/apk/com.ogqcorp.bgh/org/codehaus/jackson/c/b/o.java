// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.f.a;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.e.f;

public final class o extends i
{
    protected final org.codehaus.jackson.c.e.f i;
    protected final Method j;
    
    public o(final String s, final a a, final az az, final org.codehaus.jackson.c.i.a a2, final org.codehaus.jackson.c.e.f i) {
        super(s, a, az, a2);
        this.i = i;
        this.j = i.e();
    }
    
    protected o(final o o, final x<Object> x) {
        super(o, x);
        this.i = o.i;
        this.j = o.j;
    }
    
    @Override
    public final void a(final Object o, final Object o2) {
        throw new UnsupportedOperationException("Should never call 'set' on setterless property");
    }
    
    @Override
    public final void a(final k k, final p p3, final Object obj) {
        if (k.e() == org.codehaus.jackson.p.m) {
            return;
        }
        Object invoke;
        try {
            invoke = this.j.invoke(obj, new Object[0]);
            if (invoke == null) {
                throw new z("Problem deserializing 'setterless' property '" + this.c() + "': get method returned null");
            }
        }
        catch (Exception ex) {
            this.a(ex);
            return;
        }
        this.d.a(k, p3, invoke);
    }
    
    public o b(final x<Object> x) {
        return new o(this, x);
    }
    
    @Override
    public e b() {
        return this.i;
    }
}
