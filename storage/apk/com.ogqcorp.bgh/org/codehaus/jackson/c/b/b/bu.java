// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.b.a.e;
import org.codehaus.jackson.c.e.i;
import org.codehaus.jackson.c.b.t;

public class bu extends t
{
    protected final String a;
    protected final boolean b;
    protected i c;
    protected e[] d;
    protected i e;
    protected a f;
    protected i g;
    protected i h;
    protected i i;
    protected i j;
    protected i k;
    protected i l;
    
    public bu(final n n, final a a) {
        this.b = (n != null && n.a(o.q));
        String string;
        if (a == null) {
            string = "UNKNOWN TYPE";
        }
        else {
            string = a.toString();
        }
        this.a = string;
    }
    
    @Override
    public Object a(final double d) {
        try {
            if (this.k != null) {
                return this.k.a(d);
            }
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
        throw new z("Can not instantiate value of type " + this.a() + " from JSON floating-point number; no one-double/Double-arg constructor/factory method");
    }
    
    @Override
    public Object a(final int i) {
        try {
            if (this.i != null) {
                return this.i.a(i);
            }
            if (this.j != null) {
                return this.j.a((long)i);
            }
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
        throw new z("Can not instantiate value of type " + this.a() + " from JSON integral number; no single-int-arg constructor/factory method");
    }
    
    @Override
    public Object a(final long l) {
        try {
            if (this.j != null) {
                return this.j.a(l);
            }
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
        throw new z("Can not instantiate value of type " + this.a() + " from JSON long integral number; no single-long-arg constructor/factory method");
    }
    
    @Override
    public Object a(final Object o) {
        if (this.g == null) {
            throw new IllegalStateException("No delegate constructor for " + this.a());
        }
        try {
            return this.g.a(o);
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            throw this.a(exceptionInInitializerError);
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
    }
    
    @Override
    public Object a(final String s) {
        if (this.h != null) {
            try {
                return this.h.a(s);
            }
            catch (Exception ex) {
                throw this.a(ex);
            }
        }
        return this.b(s);
    }
    
    @Override
    public Object a(final boolean b) {
        try {
            if (this.l != null) {
                return this.l.a(b);
            }
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
        throw new z("Can not instantiate value of type " + this.a() + " from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method");
    }
    
    @Override
    public Object a(final Object[] array) {
        if (this.e == null) {
            throw new IllegalStateException("No with-args constructor for " + this.a());
        }
        try {
            return this.e.a(array);
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            throw this.a(exceptionInInitializerError);
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
    }
    
    @Override
    public String a() {
        return this.a;
    }
    
    protected z a(Throwable cause) {
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return new z("Instantiation of " + this.a() + " value failed: " + cause.getMessage(), cause);
    }
    
    public void a(final i h) {
        this.h = h;
    }
    
    public void a(final i c, final i g, final a f, final i e, final e[] d) {
        this.c = c;
        this.g = g;
        this.f = f;
        this.e = e;
        this.d = d;
    }
    
    protected Object b(final String s) {
        if (this.l != null) {
            final String trim = s.trim();
            if ("true".equals(trim)) {
                return this.a(true);
            }
            if ("false".equals(trim)) {
                return this.a(false);
            }
        }
        if (this.b && s.length() == 0) {
            return null;
        }
        throw new z("Can not instantiate value of type " + this.a() + " from JSON String; no single-String constructor/factory method");
    }
    
    public void b(final i i) {
        this.i = i;
    }
    
    public void c(final i j) {
        this.j = j;
    }
    
    @Override
    public boolean c() {
        return this.h != null;
    }
    
    public void d(final i k) {
        this.k = k;
    }
    
    @Override
    public boolean d() {
        return this.i != null;
    }
    
    public void e(final i l) {
        this.l = l;
    }
    
    @Override
    public boolean e() {
        return this.j != null;
    }
    
    @Override
    public boolean f() {
        return this.k != null;
    }
    
    @Override
    public boolean g() {
        return this.l != null;
    }
    
    @Override
    public boolean h() {
        return this.c != null;
    }
    
    @Override
    public boolean j() {
        return this.e != null;
    }
    
    @Override
    public org.codehaus.jackson.c.b.i[] k() {
        return this.d;
    }
    
    @Override
    public a l() {
        return this.f;
    }
    
    @Override
    public Object m() {
        if (this.c == null) {
            throw new IllegalStateException("No default constructor for " + this.a());
        }
        try {
            return this.c.g();
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            throw this.a(exceptionInInitializerError);
        }
        catch (Exception ex) {
            throw this.a(ex);
        }
    }
    
    @Override
    public i n() {
        return this.c;
    }
    
    @Override
    public i o() {
        return this.g;
    }
}
