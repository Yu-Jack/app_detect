// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.g;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class ai extends ad<float[]>
{
    public ai() {
        super(float[].class);
    }
    
    private final float[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new float[] { this.y(k, p2) };
    }
    
    public float[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final g f = p2.h().f();
        float[] array = f.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final float y = this.y(k, p2);
            int n2;
            if (n >= array.length) {
                final float[] array2 = f.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = y;
        }
        return f.b(array, n);
    }
}
