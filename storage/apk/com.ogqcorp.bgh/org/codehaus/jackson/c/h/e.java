// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class e
{
    protected final Type a;
    protected final Class<?> b;
    protected final ParameterizedType c;
    protected e d;
    protected e e;
    
    public e(final Type a) {
        this.a = a;
        if (a instanceof Class) {
            this.b = (Class<?>)a;
            this.c = null;
            return;
        }
        if (a instanceof ParameterizedType) {
            this.c = (ParameterizedType)a;
            this.b = (Class<?>)this.c.getRawType();
            return;
        }
        throw new IllegalArgumentException("Type " + a.getClass().getName() + " can not be used to construct HierarchicType");
    }
    
    private e(final Type a, final Class<?> b, final ParameterizedType c, final e d, final e e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public e a() {
        e a;
        if (this.d == null) {
            a = null;
        }
        else {
            a = this.d.a();
        }
        final e e = new e(this.a, this.b, this.c, a, null);
        if (a != null) {
            a.b(e);
        }
        return e;
    }
    
    public void a(final e d) {
        this.d = d;
    }
    
    public final e b() {
        return this.d;
    }
    
    public void b(final e e) {
        this.e = e;
    }
    
    public final boolean c() {
        return this.c != null;
    }
    
    public final ParameterizedType d() {
        return this.c;
    }
    
    public final Class<?> e() {
        return this.b;
    }
    
    @Override
    public String toString() {
        if (this.c != null) {
            return this.c.toString();
        }
        return this.b.getName();
    }
}
