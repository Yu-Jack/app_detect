// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.e.f;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.i.o;
import org.codehaus.jackson.c.a.c;

@c
public class i extends bt<Enum<?>>
{
    protected final o<?> a;
    
    public i(final o<?> a) {
        super(Enum.class);
        this.a = a;
    }
    
    public static x<?> a(final n n, final Class<?> clazz, final f obj) {
        final Class<?> a = obj.a(0);
        Class<?> clazz2;
        if (a == String.class) {
            clazz2 = null;
        }
        else if (a == Integer.TYPE || a == Integer.class) {
            clazz2 = Integer.class;
        }
        else {
            if (a != Long.TYPE && a != Long.class) {
                throw new IllegalArgumentException("Parameter #0 type for factory method (" + obj + ") not suitable, must be java.lang.String or int/Integer/long/Long");
            }
            clazz2 = Long.class;
        }
        if (n.a(org.codehaus.jackson.c.o.f)) {
            l.a(obj.i());
        }
        return new j(clazz, obj, clazz2);
    }
    
    public Enum<?> b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        Object o;
        if (e == org.codehaus.jackson.p.h || e == org.codehaus.jackson.p.f) {
            o = this.a.a(k.k());
            if (o == null) {
                throw p2.b(this.a.a(), "value not one of declared Enum instance names");
            }
        }
        else {
            if (e != org.codehaus.jackson.p.i) {
                throw p2.b(this.a.a());
            }
            if (p2.a(org.codehaus.jackson.c.o.m)) {
                throw p2.b("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
            }
            o = this.a.a(k.t());
            if (o == null) {
                throw p2.c(this.a.a(), "index value outside legal index range [0.." + this.a.b() + "]");
            }
        }
        return (Enum<?>)o;
    }
}
