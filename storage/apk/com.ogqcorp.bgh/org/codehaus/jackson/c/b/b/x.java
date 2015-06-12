// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.d.a;
import org.codehaus.jackson.d.o;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.i;

public class x extends c<i>
{
    private static final x a;
    
    static {
        a = new x();
    }
    
    protected x() {
        super(i.class);
    }
    
    public static org.codehaus.jackson.c.x<? extends i> a(final Class<?> clazz) {
        if (clazz == o.class) {
            return z.d();
        }
        if (clazz == a.class) {
            return y.d();
        }
        return x.a;
    }
    
    public i b(final k k, final p p2) {
        switch (x$1.a[k.e().ordinal()]) {
            default: {
                return this.c(k, p2, p2.e());
            }
            case 1: {
                return this.a(k, p2, p2.e());
            }
            case 2: {
                return this.b(k, p2, p2.e());
            }
        }
    }
}
