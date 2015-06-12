// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;
import org.codehaus.jackson.f.a;

public class a extends m
{
    public a(final org.codehaus.jackson.f.a a, final c c, final f f, final Class<?> clazz) {
        super(a, c, f, clazz);
    }
    
    private final Object f(final k k, final p p2) {
        final boolean j = k.j();
        final Object a = this.a(p2, this.e(k, p2)).a(k, p2);
        if (j && k.b() != org.codehaus.jackson.p.e) {
            throw p2.a(k, org.codehaus.jackson.p.e, "expected closing END_ARRAY after type information and deserialized value");
        }
        return a;
    }
    
    @Override
    public Object a(final k k, final p p2) {
        return this.f(k, p2);
    }
    
    @Override
    public JsonTypeInfo$As a() {
        return JsonTypeInfo$As.WRAPPER_ARRAY;
    }
    
    @Override
    public Object b(final k k, final p p2) {
        return this.f(k, p2);
    }
    
    @Override
    public Object c(final k k, final p p2) {
        return this.f(k, p2);
    }
    
    @Override
    public Object d(final k k, final p p2) {
        return this.f(k, p2);
    }
    
    protected final String e(final k k, final p p2) {
        if (!k.j()) {
            if (this.b instanceof n && this.e != null) {
                return ((n)this.b).a();
            }
            throw p2.a(k, org.codehaus.jackson.p.d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + this.c());
        }
        else {
            if (k.b() == org.codehaus.jackson.p.h) {
                final String i = k.k();
                k.b();
                return i;
            }
            if (this.b instanceof n && this.e != null) {
                return ((n)this.b).a();
            }
            throw p2.a(k, org.codehaus.jackson.p.h, "need JSON String that contains type id (for subtype of " + this.c() + ")");
        }
    }
}
