// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import java.util.EnumMap;

public class k extends an<EnumMap<?, ?>>
{
    protected final Class<?> a;
    protected final x<Enum<?>> b;
    protected final x<Object> c;
    
    public k(final Class<?> a, final x<?> b, final x<Object> c) {
        super(EnumMap.class);
        this.a = a;
        this.b = (x<Enum<?>>)b;
        this.c = c;
    }
    
    private EnumMap<?, ?> d() {
        return new EnumMap<Object, Object>(this.a);
    }
    
    @Override
    public Object a(final org.codehaus.jackson.k k, final p p3, final az az) {
        return az.a(k, p3);
    }
    
    public EnumMap<?, ?> b(final org.codehaus.jackson.k k, final p p2) {
        if (k.e() != org.codehaus.jackson.p.b) {
            throw p2.b(EnumMap.class);
        }
        final EnumMap<?, ?> d = this.d();
        while (k.b() != org.codehaus.jackson.p.c) {
            final Enum<?> key = this.b.a(k, p2);
            if (key == null) {
                throw p2.b(this.a, "value not one of declared Enum instance names");
            }
            Object a;
            if (k.b() == org.codehaus.jackson.p.m) {
                a = null;
            }
            else {
                a = this.c.a(k, p2);
            }
            d.put(key, a);
        }
        return d;
    }
}
