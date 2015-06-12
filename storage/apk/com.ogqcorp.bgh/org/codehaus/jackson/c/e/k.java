// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.HashMap;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.util.Collections;
import org.codehaus.jackson.f.a;
import java.util.Set;
import java.util.Map;
import org.codehaus.jackson.c.h;
import java.util.List;
import org.codehaus.jackson.c.h.j;
import org.codehaus.jackson.c.b;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.e;

public class k extends e
{
    protected final ai<?> b;
    protected final b c;
    protected final org.codehaus.jackson.c.e.b d;
    protected j e;
    protected final List<h> f;
    protected f g;
    protected Map<Object, org.codehaus.jackson.c.e.e> h;
    protected Set<String> i;
    protected Set<String> j;
    protected f k;
    protected f l;
    
    protected k(final ai<?> b, final a a, final org.codehaus.jackson.c.e.b d, final List<h> f) {
        super(a);
        this.b = b;
        b a2;
        if (b == null) {
            a2 = null;
        }
        else {
            a2 = b.a();
        }
        this.c = a2;
        this.d = d;
        this.f = f;
    }
    
    public static k a(final ai<?> ai, final a a, final org.codehaus.jackson.c.e.b b) {
        return new k(ai, a, b, Collections.emptyList());
    }
    
    public static k a(final u u) {
        final k k = new k(u.a(), u.b(), u.c(), u.d());
        k.g = u.h();
        k.i = u.i();
        k.j = u.j();
        k.h = u.e();
        return k;
    }
    
    public static k b(final u u) {
        final k k = new k(u.a(), u.b(), u.c(), u.d());
        k.k = u.f();
        k.l = u.g();
        return k;
    }
    
    public Object a(final boolean b) {
        final c h = this.d.h();
        if (h == null) {
            return null;
        }
        if (b) {
            h.k();
        }
        while (true) {
            try {
                return h.e().newInstance(new Object[0]);
                final Throwable cause;
                Label_0077: {
                    throw new IllegalArgumentException("Failed to instantiate bean of type " + this.d.e().getName() + ": (" + ((Exception)cause).getClass().getName() + ") " + cause.getMessage(), cause);
                }
                // iftrue(Label_0053:, cause.getCause() == null)
                cause = cause.getCause();
                continue;
                Label_0053:
                // iftrue(Label_0065:, !cause instanceof Error)
                throw (Error)cause;
                Label_0065:
                // iftrue(Label_0077:, !cause instanceof RuntimeException)
                throw (RuntimeException)cause;
            }
            catch (Exception cause) {
                continue;
            }
            break;
        }
    }
    
    public Constructor<?> a(final Class<?>... array) {
        for (final c c : this.d.i()) {
            if (c.f() == 1) {
                final Class<?> a = c.a(0);
                for (int length = array.length, i = 0; i < length; ++i) {
                    if (array[i] == a) {
                        return c.e();
                    }
                }
            }
        }
        return null;
    }
    
    public org.codehaus.jackson.c.a.h a(final org.codehaus.jackson.c.a.h h) {
        if (this.c == null) {
            return h;
        }
        return this.c.a(this.d, h);
    }
    
    public f a(final String s, final Class<?>[] array) {
        return this.d.a(s, array);
    }
    
    public a a(final Type type) {
        if (type == null) {
            return null;
        }
        return this.j().a(type);
    }
    
    protected boolean a(final f f) {
        if (this.b().isAssignableFrom(f.d())) {
            if (this.c.k(f)) {
                return true;
            }
            if ("valueOf".equals(f.b())) {
                return true;
            }
        }
        return false;
    }
    
    public Method b(final Class<?>... array) {
        for (final f f : this.d.j()) {
            if (this.a(f)) {
                final Class<?> a = f.a(0);
                for (int length = array.length, i = 0; i < length; ++i) {
                    if (a.isAssignableFrom(array[i])) {
                        return f.e();
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public org.codehaus.jackson.c.e.b c() {
        return this.d;
    }
    
    public List<h> d() {
        return this.f;
    }
    
    public f e() {
        return this.k;
    }
    
    public Set<String> f() {
        if (this.i == null) {
            return Collections.emptySet();
        }
        return this.i;
    }
    
    public Set<String> g() {
        return this.j;
    }
    
    public boolean h() {
        return this.d.g();
    }
    
    public org.codehaus.jackson.c.i.a i() {
        return this.d.f();
    }
    
    public j j() {
        if (this.e == null) {
            this.e = new j(this.b.m(), this.a);
        }
        return this.e;
    }
    
    public c k() {
        return this.d.h();
    }
    
    public f l() {
        if (this.g != null) {
            final Class<?> a = this.g.a(0);
            if (a != String.class && a != Object.class) {
                throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + this.g.b() + "(): first argument not of type String or Object, but " + a.getName());
            }
        }
        return this.g;
    }
    
    public Map<Object, org.codehaus.jackson.c.e.e> m() {
        return this.h;
    }
    
    public List<c> n() {
        return this.d.i();
    }
    
    public List<f> o() {
        final List<f> j = this.d.j();
        if (j.isEmpty()) {
            return j;
        }
        final ArrayList<f> list = new ArrayList<f>();
        for (final f e : j) {
            if (this.a(e)) {
                list.add(e);
            }
        }
        return list;
    }
    
    public f p() {
        if (this.l != null && !Map.class.isAssignableFrom(this.l.d())) {
            throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + this.l.b() + "(): return type is not instance of java.util.Map");
        }
        return this.l;
    }
    
    public Map<String, org.codehaus.jackson.c.e.e> q() {
        HashMap<String, org.codehaus.jackson.c.e.e> hashMap = null;
        final Iterator<h> iterator = this.f.iterator();
        while (iterator.hasNext()) {
            final org.codehaus.jackson.c.e.e l = iterator.next().l();
            if (l != null) {
                final org.codehaus.jackson.c.c a = this.c.a(l);
                if (a == null || !a.c()) {
                    continue;
                }
                HashMap<String, org.codehaus.jackson.c.e.e> hashMap2;
                if (hashMap == null) {
                    hashMap2 = new HashMap<String, org.codehaus.jackson.c.e.e>();
                }
                else {
                    hashMap2 = hashMap;
                }
                final String a2 = a.a();
                if (hashMap2.put(a2, l) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + a2 + "'");
                }
                hashMap = hashMap2;
            }
        }
        return hashMap;
    }
}
