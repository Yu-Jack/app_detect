// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.d;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class ae extends ad<boolean[]>
{
    public ae() {
        super(boolean[].class);
    }
    
    private final boolean[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new boolean[] { this.n(k, p2) };
    }
    
    public boolean[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final d a = p2.h().a();
        boolean[] array = a.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final boolean n2 = this.n(k, p2);
            int n3;
            if (n >= array.length) {
                final boolean[] array2 = a.a(array, n);
                n3 = 0;
                array = array2;
            }
            else {
                n3 = n;
            }
            n = n3 + 1;
            array[n3] = n2;
        }
        return a.b(array, n);
    }
}
