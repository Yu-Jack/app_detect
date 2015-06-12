// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.f;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class ah extends ad<double[]>
{
    public ah() {
        super(double[].class);
    }
    
    private final double[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new double[] { this.A(k, p2) };
    }
    
    public double[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final f g = p2.h().g();
        double[] array = g.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final double a = this.A(k, p2);
            int n2;
            if (n >= array.length) {
                final double[] array2 = g.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = a;
        }
        return g.b(array, n);
    }
}
