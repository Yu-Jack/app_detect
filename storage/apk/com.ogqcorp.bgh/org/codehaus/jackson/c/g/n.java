// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.util.Map;
import org.codehaus.jackson.c.a.i;
import org.codehaus.jackson.c.i.n;
import org.codehaus.jackson.c.e.f;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ad;
import java.util.Collection;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.f.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.b;
import org.codehaus.jackson.c.a.h;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.at;

public class n
{
    protected final at a;
    protected final k b;
    protected final h c;
    protected final b d;
    protected Object e;
    
    public n(final at a, final k b) {
        this.a = a;
        this.b = b;
        this.c = b.a(a.g());
        this.d = this.a.a();
    }
    
    protected Object a(final Exception ex, final String str, final Object o) {
        Throwable cause;
        for (cause = ex; cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + o.getClass().getName() + " instance");
    }
    
    protected Object a(final String s, final Method method, final Field field) {
        final Object b = this.b();
        Label_0021: {
            if (method == null) {
                break Label_0021;
            }
            try {
                return method.invoke(b, new Object[0]);
                return field.get(b);
            }
            catch (Exception ex) {
                return this.a(ex, s, b);
            }
        }
    }
    
    protected Object a(final String s, final a a) {
        if (!this.a.a(au.w)) {
            if (a.b()) {
                return new o();
            }
            if (Collection.class.isAssignableFrom(a.p())) {
                return new p();
            }
        }
        return null;
    }
    
    protected d a(final String str, final a a, final ad<Object> ad, final ba ba, final ba ba2, final e e, final boolean b) {
        Method e2;
        Field e3;
        if (e instanceof org.codehaus.jackson.c.e.d) {
            e2 = null;
            e3 = ((org.codehaus.jackson.c.e.d)e).e();
        }
        else {
            e2 = ((f)e).e();
            e3 = null;
        }
        a a2 = this.a(e, b, a);
        a e4;
        if (ba2 != null) {
            if (a2 == null) {
                a2 = a;
            }
            if (a2.g() == null) {
                throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + str + "' (of type " + this.b.a() + "); serialization type " + a2 + " has no content");
            }
            e4 = a2.e(ba2);
            e4.g();
        }
        else {
            e4 = a2;
        }
        final h a3 = this.d.a(e, this.c);
        boolean b2 = false;
        Object o = null;
        boolean b3 = false;
        Label_0220: {
            if (a3 != null) {
                final int n = n$1.a[a3.ordinal()];
                o = null;
                b2 = false;
                switch (n) {
                    case 1: {
                        o = this.a(str, e2, e3);
                        if (o == null) {
                            b3 = true;
                            break Label_0220;
                        }
                        final boolean array = o.getClass().isArray();
                        b2 = false;
                        if (array) {
                            o = org.codehaus.jackson.c.i.n.a(o);
                            b3 = false;
                            break Label_0220;
                        }
                        break;
                    }
                    case 2: {
                        o = this.b(str, a);
                        b3 = true;
                        break Label_0220;
                    }
                    case 3: {
                        b2 = true;
                    }
                    case 4: {
                        final boolean f = a.f();
                        o = null;
                        if (f) {
                            o = this.a(str, a);
                            b3 = b2;
                            break Label_0220;
                        }
                        break;
                    }
                }
            }
            b3 = b2;
        }
        d c = new d(e, this.b.i(), str, a, ad, ba, e4, e2, e3, b3, o);
        final Boolean b4 = this.d.b(e);
        if (b4 != null && b4) {
            c = c.c();
        }
        return c;
    }
    
    public org.codehaus.jackson.c.i.a a() {
        return this.b.i();
    }
    
    protected a a(final org.codehaus.jackson.c.e.a a, boolean b, final a a2) {
        boolean b2 = true;
        final Class<?> e = this.d.e(a);
        a a3;
        if (e != null) {
            final Class<?> p3 = a2.p();
            if (e.isAssignableFrom(p3)) {
                a3 = a2.h(e);
            }
            else {
                if (!p3.isAssignableFrom(e)) {
                    throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + a.b() + "': class " + e.getName() + " not a super-type of (declared) class " + p3.getName());
                }
                a3 = this.a.a(a2, e);
            }
            b = b2;
        }
        else {
            a3 = a2;
        }
        final a b3 = b.b(this.a, a, a3);
        boolean b4;
        if (b3 != a3) {
            a3 = b3;
            b4 = b2;
        }
        else {
            b4 = b;
        }
        while (true) {
            Label_0197: {
                if (b4) {
                    break Label_0197;
                }
                final i f = this.d.f(a);
                if (f == null) {
                    break Label_0197;
                }
                if (f != i.b) {
                    b2 = false;
                }
                if (b2) {
                    return a3;
                }
                return null;
            }
            b2 = b4;
            continue;
        }
    }
    
    protected Object b() {
        if (this.e == null) {
            this.e = this.b.a(this.a.a(au.e));
            if (this.e == null) {
                throw new IllegalArgumentException("Class " + this.b.c().e().getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        return this.e;
    }
    
    protected Object b(final String s, final a a) {
        final Class<?> p2 = a.p();
        if (p2 == String.class) {
            return new r();
        }
        if (a.b()) {
            return new o();
        }
        if (Collection.class.isAssignableFrom(p2)) {
            return new p();
        }
        if (Map.class.isAssignableFrom(p2)) {
            return new q();
        }
        return null;
    }
}
