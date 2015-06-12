// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.i;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class ak extends ad<long[]>
{
    public ak() {
        super(long[].class);
    }
    
    private final long[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new long[] { this.w(k, p2) };
    }
    
    public long[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final i e = p2.h().e();
        long[] array = e.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final long w = this.w(k, p2);
            int n2;
            if (n >= array.length) {
                final long[] array2 = e.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = w;
        }
        return e.b(array, n);
    }
}
