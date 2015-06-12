// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.h;
import org.codehaus.jackson.c.z;
import java.io.IOException;
import org.codehaus.jackson.g.i;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.f;

public abstract class i implements f
{
    protected final String a;
    protected final a b;
    protected final org.codehaus.jackson.c.i.a c;
    protected x<Object> d;
    protected az e;
    protected n f;
    protected String g;
    protected int h;
    
    protected i(final String s, final a b, final az e, final org.codehaus.jackson.c.i.a c) {
        this.h = -1;
        if (s == null || s.length() == 0) {
            this.a = "";
        }
        else {
            this.a = org.codehaus.jackson.g.i.a.a(s);
        }
        this.b = b;
        this.c = c;
        this.e = e;
    }
    
    protected i(final i i) {
        this.h = -1;
        this.a = i.a;
        this.b = i.b;
        this.c = i.c;
        this.d = i.d;
        this.e = i.e;
        this.f = i.f;
        this.g = i.g;
        this.h = i.h;
    }
    
    protected i(final i i, final x<Object> d) {
        this.h = -1;
        this.a = i.a;
        this.b = i.b;
        this.c = i.c;
        this.e = i.e;
        this.g = i.g;
        this.h = i.h;
        this.d = d;
        if (d == null) {
            this.f = null;
            return;
        }
        final Object b = d.b();
        n f = null;
        if (b != null) {
            f = new n(this.b, b);
        }
        this.f = f;
    }
    
    protected IOException a(Exception cause) {
        if (cause instanceof IOException) {
            throw (IOException)cause;
        }
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        while (cause.getCause() != null) {
            cause = (Exception)cause.getCause();
        }
        throw new z(cause.getMessage(), null, cause);
    }
    
    public final Object a(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.m) {
            if (this.f == null) {
                return null;
            }
            return this.f.a(p2);
        }
        else {
            if (this.e != null) {
                return this.d.a(k, p2, this.e);
            }
            return this.d.a(k, p2);
        }
    }
    
    public abstract i a(final x<Object> p0);
    
    @Override
    public a a() {
        return this.b;
    }
    
    public void a(final int n) {
        if (this.h != -1) {
            throw new IllegalStateException("Property '" + this.c() + "' already had index (" + this.h + "), trying to assign " + n);
        }
        this.h = n;
    }
    
    protected void a(final Exception ex, final Object o) {
        if (ex instanceof IllegalArgumentException) {
            String name;
            if (o == null) {
                name = "[NULL]";
            }
            else {
                name = o.getClass().getName();
            }
            final StringBuilder append = new StringBuilder("Problem deserializing property '").append(this.d());
            append.append("' (expected type: ").append(this.a());
            append.append("; actual type: ").append(name).append(")");
            final String message = ex.getMessage();
            if (message != null) {
                append.append(", problem: ").append(message);
            }
            else {
                append.append(" (no error message provided)");
            }
            throw new z(append.toString(), null, ex);
        }
        this.a(ex);
    }
    
    public abstract void a(final Object p0, final Object p1);
    
    public void a(final String g) {
        this.g = g;
    }
    
    public abstract void a(final k p0, final p p1, final Object p2);
    
    @Override
    public abstract e b();
    
    public final String c() {
        return this.a;
    }
    
    @Deprecated
    public String d() {
        return this.a;
    }
    
    public String e() {
        return this.g;
    }
    
    public boolean f() {
        return this.d != null;
    }
    
    public boolean g() {
        return this.e != null;
    }
    
    public x<Object> h() {
        return this.d;
    }
    
    public az i() {
        return this.e;
    }
    
    public int j() {
        return this.h;
    }
    
    public Object k() {
        return null;
    }
    
    @Override
    public String toString() {
        return "[property '" + this.c() + "']";
    }
}
