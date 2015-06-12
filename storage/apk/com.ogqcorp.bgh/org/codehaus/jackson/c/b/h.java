// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.io.IOException;
import org.codehaus.jackson.h;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.f;

public final class h
{
    protected final f a;
    protected final Method b;
    protected final a c;
    protected x<Object> d;
    
    public h(final f a, final Method b, final a c, final x<Object> d) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    public h(final f f, final org.codehaus.jackson.c.e.f f2, final a a, final x<Object> x) {
        this(f, f2.e(), a, x);
    }
    
    private String d() {
        return this.b.getDeclaringClass().getName();
    }
    
    public final Object a(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.m) {
            return null;
        }
        return this.d.a(k, p2);
    }
    
    public h a(final x<Object> x) {
        return new h(this.a, this.b, this.c, x);
    }
    
    public f a() {
        return this.a;
    }
    
    protected void a(Exception cause, final String str, final Object o) {
        if (cause instanceof IllegalArgumentException) {
            String name;
            if (o == null) {
                name = "[NULL]";
            }
            else {
                name = o.getClass().getName();
            }
            final StringBuilder append = new StringBuilder("Problem deserializing \"any\" property '").append(str);
            append.append("' of class " + this.d() + " (expected type: ").append(this.c);
            append.append("; actual type: ").append(name).append(")");
            final String message = cause.getMessage();
            if (message != null) {
                append.append(", problem: ").append(message);
            }
            else {
                append.append(" (no error message provided)");
            }
            throw new z(append.toString(), null, cause);
        }
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
    
    public final void a(final Object obj, final String s, final Object o) {
        try {
            this.b.invoke(obj, s, o);
        }
        catch (Exception ex) {
            this.a(ex, s, o);
        }
    }
    
    public final void a(final k k, final p p4, final Object o, final String s) {
        this.a(o, s, this.a(k, p4));
    }
    
    public boolean b() {
        return this.d != null;
    }
    
    public a c() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return "[any property on class " + this.d() + "]";
    }
}
