// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.j;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class al extends ad<short[]>
{
    public al() {
        super(short[].class);
    }
    
    private final short[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        return new short[] { this.s(k, p2) };
    }
    
    public short[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final j c = p2.h().c();
        short[] array = c.a();
        int n = 0;
        while (k.b() != org.codehaus.jackson.p.e) {
            final short s = this.s(k, p2);
            int n2;
            if (n >= array.length) {
                final short[] array2 = c.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = s;
        }
        return c.b(array, n);
    }
}
