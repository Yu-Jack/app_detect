// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.a.i;
import org.codehaus.jackson.c.e.f;
import java.lang.annotation.Annotation;
import org.codehaus.jackson.c.f.d;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.c.e.e;
import java.util.List;
import org.codehaus.jackson.c.e.h;
import org.codehaus.jackson.c.e.a;
import org.codehaus.jackson.c.e.b;
import org.codehaus.jackson.c.e.t;

public abstract class b
{
    public static b a() {
        return t.a;
    }
    
    public Boolean a(final org.codehaus.jackson.c.e.b b) {
        return null;
    }
    
    public Class<?> a(final a a, final org.codehaus.jackson.f.a a2) {
        return null;
    }
    
    public abstract Class<?> a(final a p0, final org.codehaus.jackson.f.a p1, final String p2);
    
    public abstract String a(final Enum<?> p0);
    
    public abstract String a(final h p0);
    
    public List<org.codehaus.jackson.c.f.a> a(final a a) {
        return null;
    }
    
    public org.codehaus.jackson.c.a.h a(final a a, final org.codehaus.jackson.c.a.h h) {
        return h;
    }
    
    public c a(final e e) {
        return null;
    }
    
    public x<?> a(final org.codehaus.jackson.c.e.b b, final x<?> x) {
        return x;
    }
    
    public d<?> a(final ai<?> ai, final org.codehaus.jackson.c.e.b b, final org.codehaus.jackson.f.a a) {
        return null;
    }
    
    public d<?> a(final ai<?> ai, final e e, final org.codehaus.jackson.f.a a) {
        return null;
    }
    
    public abstract boolean a(final Annotation p0);
    
    public abstract boolean a(final org.codehaus.jackson.c.e.c p0);
    
    public abstract boolean a(final org.codehaus.jackson.c.e.d p0);
    
    public abstract boolean a(final f p0);
    
    public Boolean b(final e e) {
        return null;
    }
    
    public Class<?> b(final a a, final org.codehaus.jackson.f.a a2) {
        return null;
    }
    
    public abstract Class<?> b(final a p0, final org.codehaus.jackson.f.a p1, final String p2);
    
    public abstract Object b(final a p0);
    
    public abstract String b(final org.codehaus.jackson.c.e.b p0);
    
    public abstract String b(final org.codehaus.jackson.c.e.d p0);
    
    public abstract String b(final f p0);
    
    public d<?> b(final ai<?> ai, final e e, final org.codehaus.jackson.f.a a) {
        return null;
    }
    
    public Class<? extends ad<?>> c(final a a) {
        return null;
    }
    
    public abstract Class<?> c(final a p0, final org.codehaus.jackson.f.a p1, final String p2);
    
    public abstract String c(final org.codehaus.jackson.c.e.d p0);
    
    public boolean c(final e e) {
        if (e instanceof f) {
            return this.a((f)e);
        }
        if (e instanceof org.codehaus.jackson.c.e.d) {
            return this.a((org.codehaus.jackson.c.e.d)e);
        }
        return e instanceof org.codehaus.jackson.c.e.c && this.a((org.codehaus.jackson.c.e.c)e);
    }
    
    public abstract boolean c(final f p0);
    
    public abstract String[] c(final org.codehaus.jackson.c.e.b p0);
    
    public abstract Boolean d(final org.codehaus.jackson.c.e.b p0);
    
    public Class<? extends ad<?>> d(final a a) {
        return null;
    }
    
    public Object d(final e e) {
        return null;
    }
    
    public abstract String d(final f p0);
    
    public Boolean e(final org.codehaus.jackson.c.e.b b) {
        return null;
    }
    
    public abstract Class<?> e(final a p0);
    
    public boolean e(final f f) {
        return false;
    }
    
    public Object f(final org.codehaus.jackson.c.e.b b) {
        return null;
    }
    
    public abstract i f(final a p0);
    
    public boolean f(final f f) {
        return false;
    }
    
    public String g(final org.codehaus.jackson.c.e.b b) {
        return null;
    }
    
    public abstract Class<?>[] g(final a p0);
    
    public abstract Object h(final a p0);
    
    public abstract String[] h(final org.codehaus.jackson.c.e.b p0);
    
    public abstract Boolean i(final org.codehaus.jackson.c.e.b p0);
    
    public abstract Class<? extends af> i(final a p0);
    
    public abstract Class<? extends org.codehaus.jackson.c.x<?>> j(final a p0);
    
    public Object j(final org.codehaus.jackson.c.e.b b) {
        return null;
    }
    
    public boolean k(final a a) {
        return false;
    }
}
