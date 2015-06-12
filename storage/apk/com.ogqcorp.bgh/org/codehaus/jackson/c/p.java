// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import org.codehaus.jackson.c.i.b;
import org.codehaus.jackson.c.i.s;
import org.codehaus.jackson.k;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.p;
import java.util.Calendar;
import java.util.Date;

public abstract class p
{
    protected final n a;
    protected final int b;
    
    protected p(final n a) {
        this.a = a;
        this.b = a.i;
    }
    
    public abstract Object a(final Object p0, final f p1, final Object p2);
    
    public abstract Calendar a(final Date p0);
    
    public abstract Date a(final String p0);
    
    public n a() {
        return this.a;
    }
    
    public abstract z a(final Class<?> p0, final String p1);
    
    public abstract z a(final Class<?> p0, final String p1, final String p2);
    
    public abstract z a(final Class<?> p0, final Throwable p1);
    
    public abstract z a(final Class<?> p0, final org.codehaus.jackson.p p1);
    
    public abstract z a(final Object p0, final String p1);
    
    public abstract z a(final a p0, final String p1);
    
    public abstract z a(final k p0, final org.codehaus.jackson.p p1, final String p2);
    
    public a a(final Class<?> clazz) {
        return this.a.b(clazz);
    }
    
    public abstract void a(final s p0);
    
    public boolean a(final o o) {
        return (this.b & o.b()) != 0x0;
    }
    
    public abstract boolean a(final k p0, final x<?> p1, final Object p2, final String p3);
    
    public t b() {
        return null;
    }
    
    public abstract z b(final Class<?> p0);
    
    public abstract z b(final Class<?> p0, final String p1);
    
    public z b(final String s) {
        return z.a(this.d(), s);
    }
    
    public org.codehaus.jackson.a c() {
        return this.a.g();
    }
    
    public abstract z c(final Class<?> p0, final String p1);
    
    public abstract k d();
    
    public final org.codehaus.jackson.d.k e() {
        return this.a.h();
    }
    
    public org.codehaus.jackson.c.h.k f() {
        return this.a.m();
    }
    
    public abstract s g();
    
    public abstract b h();
}
