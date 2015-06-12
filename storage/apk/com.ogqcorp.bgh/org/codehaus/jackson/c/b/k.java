// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import java.lang.reflect.Constructor;

public final class k extends i
{
    protected final i i;
    protected final Constructor<?> j;
    
    public k(final i i, final Constructor<?> j) {
        super(i);
        this.i = i;
        this.j = j;
    }
    
    protected k(final k k, final x<Object> x) {
        super(k, x);
        this.i = k.i.a(x);
        this.j = k.j;
    }
    
    @Override
    public final void a(final Object o, final Object o2) {
        this.i.a(o, o2);
    }
    
    @Override
    public void a(final org.codehaus.jackson.k k, final p p3, final Object o) {
        Object o2;
        if (k.e() == org.codehaus.jackson.p.m) {
            final n f = this.f;
            o2 = null;
            if (f != null) {
                o2 = this.f.a(p3);
            }
        }
        else if (this.e != null) {
            o2 = this.d.a(k, p3, this.e);
        }
        else {
            while (true) {
                try {
                    o2 = this.j.newInstance(o);
                    this.d.a(k, p3, o2);
                }
                catch (Exception ex) {
                    l.b(ex, "Failed to instantiate class " + this.j.getDeclaringClass().getName() + ", problem: " + ex.getMessage());
                    o2 = null;
                    continue;
                }
                break;
            }
        }
        this.a(o, o2);
    }
    
    public k b(final x<Object> x) {
        return new k(this, x);
    }
    
    @Override
    public e b() {
        return this.i.b();
    }
}
