// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.f.a;

public final class m
{
    protected int a;
    protected Class<?> b;
    protected a c;
    protected boolean d;
    
    public m(final Class<?> b, final boolean d) {
        this.b = b;
        this.c = null;
        this.d = d;
        this.a = a(b, d);
    }
    
    public m(final a c, final boolean d) {
        this.c = c;
        this.b = null;
        this.d = d;
        this.a = a(c, d);
    }
    
    private static final int a(final Class<?> clazz, final boolean b) {
        int hashCode = clazz.getName().hashCode();
        if (b) {
            ++hashCode;
        }
        return hashCode;
    }
    
    private static final int a(final a a, final boolean b) {
        int n = -1 + a.hashCode();
        if (b) {
            --n;
        }
        return n;
    }
    
    public void a(final Class<?> b) {
        this.c = null;
        this.b = b;
        this.d = true;
        this.a = a(b, true);
    }
    
    public void a(final a c) {
        this.c = c;
        this.b = null;
        this.d = true;
        this.a = a(c, true);
    }
    
    public void b(final Class<?> b) {
        this.c = null;
        this.b = b;
        this.d = false;
        this.a = a(b, false);
    }
    
    public void b(final a c) {
        this.c = c;
        this.b = null;
        this.d = false;
        this.a = a(c, false);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            final m m = (m)o;
            if (m.d != this.d) {
                return false;
            }
            if (this.b == null) {
                return this.c.equals(m.c);
            }
            if (m.b != this.b) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        return this.a;
    }
    
    @Override
    public final String toString() {
        if (this.b != null) {
            return "{class: " + this.b.getName() + ", typed? " + this.d + "}";
        }
        return "{type: " + this.c + ", typed? " + this.d + "}";
    }
}
