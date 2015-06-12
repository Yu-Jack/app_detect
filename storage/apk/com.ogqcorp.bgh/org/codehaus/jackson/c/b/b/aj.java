// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.h;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class aj extends ad<int[]>
{
    public aj() {
        super(int[].class);
    }
    
    private final int[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new int[] { this.t(k, p2) };
    }
    
    public int[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final h d = p2.h().d();
        int[] array = d.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final int t = this.t(k, p2);
            int n2;
            if (n >= array.length) {
                final int[] array2 = d.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = t;
        }
        return d.b(array, n);
    }
}
