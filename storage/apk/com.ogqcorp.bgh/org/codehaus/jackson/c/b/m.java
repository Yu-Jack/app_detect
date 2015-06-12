// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.f.a;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.e.f;

public final class m extends i
{
    protected final org.codehaus.jackson.c.e.f i;
    protected final Method j;
    
    public m(final String s, final a a, final az az, final org.codehaus.jackson.c.i.a a2, final org.codehaus.jackson.c.e.f i) {
        super(s, a, az, a2);
        this.i = i;
        this.j = i.e();
    }
    
    protected m(final m m, final x<Object> x) {
        super(m, x);
        this.i = m.i;
        this.j = m.j;
    }
    
    @Override
    public final void a(final Object obj, final Object o) {
        try {
            this.j.invoke(obj, o);
        }
        catch (Exception ex) {
            this.a(ex, o);
        }
    }
    
    @Override
    public void a(final k k, final p p3, final Object o) {
        this.a(o, this.a(k, p3));
    }
    
    public m b(final x<Object> x) {
        return new m(this, x);
    }
    
    @Override
    public e b() {
        return this.i;
    }
}
