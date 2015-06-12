// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.e.h;
import org.codehaus.jackson.c.b.i;

public class e extends i
{
    protected final h i;
    protected final Object j;
    
    public e(final String s, final a a, final az az, final org.codehaus.jackson.c.i.a a2, final h i, final int h, final Object j) {
        super(s, a, az, a2);
        this.i = i;
        this.h = h;
        this.j = j;
    }
    
    protected e(final e e, final x<Object> x) {
        super(e, x);
        this.i = e.i;
        this.j = e.j;
    }
    
    @Override
    public void a(final Object o, final Object o2) {
    }
    
    @Override
    public void a(final k k, final p p3, final Object o) {
        this.a(o, this.a(k, p3));
    }
    
    public e b(final x<Object> x) {
        return new e(this, x);
    }
    
    @Override
    public org.codehaus.jackson.c.e.e b() {
        return this.i;
    }
    
    @Override
    public Object k() {
        return this.j;
    }
}
