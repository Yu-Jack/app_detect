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
import java.lang.reflect.Field;
import org.codehaus.jackson.c.e.d;

public final class j extends i
{
    protected final d i;
    protected final Field j;
    
    public j(final String s, final a a, final az az, final org.codehaus.jackson.c.i.a a2, final d i) {
        super(s, a, az, a2);
        this.i = i;
        this.j = i.e();
    }
    
    protected j(final j j, final x<Object> x) {
        super(j, x);
        this.i = j.i;
        this.j = j.j;
    }
    
    @Override
    public final void a(final Object obj, final Object value) {
        try {
            this.j.set(obj, value);
        }
        catch (Exception ex) {
            this.a(ex, value);
        }
    }
    
    @Override
    public void a(final k k, final p p3, final Object o) {
        this.a(o, this.a(k, p3));
    }
    
    public j b(final x<Object> x) {
        return new j(this, x);
    }
    
    @Override
    public e b() {
        return this.i;
    }
}
