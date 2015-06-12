// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.lang.reflect.Type;
import org.codehaus.jackson.c.g.a.o;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.g.a.h;
import org.codehaus.jackson.c.ax;
import java.util.Map;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.g.a.d;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.b.k;
import java.util.HashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.i.a;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.f;

public class d implements f
{
    protected final e a;
    protected final a b;
    protected final org.codehaus.jackson.f.a c;
    protected final Method d;
    protected final Field e;
    protected HashMap<Object, Object> f;
    protected final k g;
    protected final org.codehaus.jackson.f.a h;
    protected final ad<Object> i;
    protected org.codehaus.jackson.c.g.a.d j;
    protected final boolean k;
    protected final Object l;
    protected Class<?>[] m;
    protected ba n;
    protected org.codehaus.jackson.f.a o;
    
    public d(final e e, final a a, final String s, final org.codehaus.jackson.f.a a2, final ad<Object> ad, final ba ba, final org.codehaus.jackson.f.a a3, final Method method, final Field field, final boolean b, final Object o) {
        this(e, a, new k(s), a2, ad, ba, a3, method, field, b, o);
    }
    
    public d(final e a, final a b, final k g, final org.codehaus.jackson.f.a c, final ad<Object> i, final ba n, final org.codehaus.jackson.f.a h, final Method d, final Field e, final boolean k, final Object l) {
        this.a = a;
        this.b = b;
        this.g = g;
        this.c = c;
        this.i = i;
        org.codehaus.jackson.c.g.a.d a2;
        if (i == null) {
            a2 = org.codehaus.jackson.c.g.a.d.a();
        }
        else {
            a2 = null;
        }
        this.j = a2;
        this.n = n;
        this.h = h;
        this.d = d;
        this.e = e;
        this.k = k;
        this.l = l;
    }
    
    protected d(final d d) {
        this(d, d.i);
    }
    
    protected d(final d d, final ad<Object> i) {
        this.i = i;
        this.a = d.a;
        this.b = d.b;
        this.c = d.c;
        this.d = d.d;
        this.e = d.e;
        if (d.f != null) {
            this.f = new HashMap<Object, Object>(d.f);
        }
        this.g = d.g;
        this.h = d.h;
        this.j = d.j;
        this.k = d.k;
        this.l = d.l;
        this.m = d.m;
        this.n = d.n;
        this.o = d.o;
    }
    
    public final Object a(final Object o) {
        if (this.d != null) {
            return this.d.invoke(o, new Object[0]);
        }
        return this.e.get(o);
    }
    
    protected ad<Object> a(final org.codehaus.jackson.c.g.a.d d, final Class<?> clazz, final ax ax) {
        h h;
        if (this.o != null) {
            h = d.a(ax.a(this.o, clazz), ax, this);
        }
        else {
            h = d.a(clazz, ax, this);
        }
        if (d != h.b) {
            this.j = h.b;
        }
        return h.a;
    }
    
    public d a(final ad<Object> ad) {
        if (this.getClass() != d.class) {
            throw new IllegalStateException("BeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
        }
        return new d(this, ad);
    }
    
    @Override
    public org.codehaus.jackson.f.a a() {
        return this.c;
    }
    
    public void a(final Object o, final org.codehaus.jackson.f f, final ax ax) {
        final Object a = this.a(o);
        if (a == null) {
            if (!this.k) {
                f.a(this.g);
                ax.a(f);
            }
        }
        else {
            if (a == o) {
                this.b(o);
            }
            if (this.l == null || !this.l.equals(a)) {
                ad<Object> ad = this.i;
                if (ad == null) {
                    final Class<?> class1 = a.getClass();
                    final org.codehaus.jackson.c.g.a.d j = this.j;
                    ad = j.a(class1);
                    if (ad == null) {
                        ad = this.a(j, class1, ax);
                    }
                }
                f.a(this.g);
                if (this.n == null) {
                    ad.a(a, f, ax);
                    return;
                }
                ad.a(a, f, ax, this.n);
            }
        }
    }
    
    public void a(final org.codehaus.jackson.f.a o) {
        this.o = o;
    }
    
    public void a(final Class<?>[] m) {
        this.m = m;
    }
    
    @Override
    public e b() {
        return this.a;
    }
    
    protected void b(final Object o) {
        throw new z("Direct self-reference leading to cycle");
    }
    
    public d c() {
        return new o(this);
    }
    
    public String d() {
        return this.g.a();
    }
    
    public boolean e() {
        return this.i != null;
    }
    
    public org.codehaus.jackson.f.a f() {
        return this.h;
    }
    
    public Type g() {
        if (this.d != null) {
            return this.d.getGenericReturnType();
        }
        return this.e.getGenericType();
    }
    
    public Class<?>[] h() {
        return this.m;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(40);
        sb.append("property '").append(this.d()).append("' (");
        if (this.d != null) {
            sb.append("via method ").append(this.d.getDeclaringClass().getName()).append("#").append(this.d.getName());
        }
        else {
            sb.append("field \"").append(this.e.getDeclaringClass().getName()).append("#").append(this.e.getName());
        }
        if (this.i == null) {
            sb.append(", no static serializer");
        }
        else {
            sb.append(", static serializer of type " + this.i.getClass().getName());
        }
        sb.append(')');
        return sb.toString();
    }
}
