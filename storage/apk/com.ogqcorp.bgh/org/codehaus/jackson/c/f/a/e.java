// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.q;
import org.codehaus.jackson.g.m;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;

public class e extends a
{
    protected final String a;
    
    public e(final org.codehaus.jackson.f.a a, final c c, final f f, final Class<?> clazz, final String a2) {
        super(a, c, f, clazz);
        this.a = a2;
    }
    
    @Override
    public Object a(k a, final p p2) {
        org.codehaus.jackson.p p3 = a.e();
        if (p3 == org.codehaus.jackson.p.b) {
            p3 = a.b();
        }
        else {
            if (p3 == org.codehaus.jackson.p.d) {
                return this.a(a, p2, null);
            }
            if (p3 != org.codehaus.jackson.p.f) {
                return this.a(a, p2, null);
            }
        }
        org.codehaus.jackson.p b = p3;
        org.codehaus.jackson.g.m m = null;
        while (b == org.codehaus.jackson.p.f) {
            final String g = a.g();
            a.b();
            if (this.a.equals(g)) {
                final x<Object> a2 = this.a(p2, a.k());
                if (m != null) {
                    a = org.codehaus.jackson.g.k.a(m.a(a), a);
                }
                a.b();
                return a2.a(a, p2);
            }
            if (m == null) {
                m = new org.codehaus.jackson.g.m(null);
            }
            m.a(g);
            m.c(a);
            b = a.b();
        }
        return this.a(a, p2, m);
    }
    
    protected Object a(k a, final p p3, final org.codehaus.jackson.g.m m) {
        Object o;
        if (this.e != null) {
            final x<Object> a2 = this.a(p3);
            if (m != null) {
                m.e();
                a = m.a(a);
                a.b();
            }
            o = a2.a(a, p3);
        }
        else {
            o = this.f(a, p3);
            if (o == null) {
                if (a.e() == org.codehaus.jackson.p.d) {
                    return super.d(a, p3);
                }
                throw p3.a(a, org.codehaus.jackson.p.f, "missing property '" + this.a + "' that is to contain type id  (for class " + this.c() + ")");
            }
        }
        return o;
    }
    
    @Override
    public JsonTypeInfo$As a() {
        return JsonTypeInfo$As.PROPERTY;
    }
    
    @Override
    public String b() {
        return this.a;
    }
    
    @Override
    public Object d(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.d) {
            return super.b(k, p2);
        }
        return this.a(k, p2);
    }
    
    protected Object f(final k k, final p p2) {
        switch (e$1.a[k.e().ordinal()]) {
            case 1: {
                if (this.c.p().isAssignableFrom(String.class)) {
                    return k.k();
                }
                break;
            }
            case 2: {
                if (this.c.p().isAssignableFrom(Integer.class)) {
                    return k.t();
                }
                break;
            }
            case 3: {
                if (this.c.p().isAssignableFrom(Double.class)) {
                    return k.x();
                }
                break;
            }
            case 4: {
                if (this.c.p().isAssignableFrom(Boolean.class)) {
                    return Boolean.TRUE;
                }
                break;
            }
            case 5: {
                if (this.c.p().isAssignableFrom(Boolean.class)) {
                    return Boolean.FALSE;
                }
                break;
            }
        }
        return null;
    }
}
