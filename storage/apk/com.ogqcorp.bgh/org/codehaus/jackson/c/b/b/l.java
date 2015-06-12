// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.x;
import java.util.EnumSet;

public class l extends an<EnumSet<?>>
{
    protected final Class<Enum> a;
    protected final x<Enum<?>> b;
    
    public l(final Class<?> a, final x<?> b) {
        super(EnumSet.class);
        this.a = (Class<Enum>)a;
        this.b = (x<Enum<?>>)b;
    }
    
    private EnumSet d() {
        return EnumSet.noneOf(this.a);
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        return az.b(k, p3);
    }
    
    public EnumSet<?> b(final k k, final p p2) {
        if (!k.j()) {
            throw p2.b(EnumSet.class);
        }
        final EnumSet d = this.d();
        while (true) {
            final org.codehaus.jackson.p b = k.b();
            if (b == org.codehaus.jackson.p.e) {
                return (EnumSet<?>)d;
            }
            if (b == org.codehaus.jackson.p.m) {
                throw p2.b(this.a);
            }
            d.add(this.b.a(k, p2));
        }
    }
}
