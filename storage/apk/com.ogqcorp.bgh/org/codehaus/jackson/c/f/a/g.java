// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;
import org.codehaus.jackson.f.a;

public class g extends m
{
    public g(final a a, final c c, final f f, final Class<?> clazz) {
        super(a, c, f, null);
    }
    
    private final Object e(final k k, final p p2) {
        if (k.e() != org.codehaus.jackson.p.b) {
            throw p2.a(k, org.codehaus.jackson.p.b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + this.c());
        }
        if (k.b() != org.codehaus.jackson.p.f) {
            throw p2.a(k, org.codehaus.jackson.p.f, "need JSON String that contains type id (for subtype of " + this.c() + ")");
        }
        final x<Object> a = this.a(p2, k.k());
        k.b();
        final Object a2 = a.a(k, p2);
        if (k.b() != org.codehaus.jackson.p.c) {
            throw p2.a(k, org.codehaus.jackson.p.c, "expected closing END_OBJECT after type information and deserialized value");
        }
        return a2;
    }
    
    @Override
    public Object a(final k k, final p p2) {
        return this.e(k, p2);
    }
    
    @Override
    public JsonTypeInfo$As a() {
        return JsonTypeInfo$As.WRAPPER_OBJECT;
    }
    
    @Override
    public Object b(final k k, final p p2) {
        return this.e(k, p2);
    }
    
    @Override
    public Object c(final k k, final p p2) {
        return this.e(k, p2);
    }
    
    @Override
    public Object d(final k k, final p p2) {
        return this.e(k, p2);
    }
}
