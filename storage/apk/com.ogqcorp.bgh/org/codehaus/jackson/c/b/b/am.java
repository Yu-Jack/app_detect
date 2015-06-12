// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.s;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class am extends ad<String[]>
{
    public am() {
        super(String[].class);
    }
    
    private final String[] c(final k k, final p p2) {
        if (p2.a(o.o)) {
            final String[] array = { null };
            final org.codehaus.jackson.p e = k.e();
            final org.codehaus.jackson.p m = org.codehaus.jackson.p.m;
            String i = null;
            if (e != m) {
                i = k.k();
            }
            array[0] = i;
            return array;
        }
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        throw p2.b(this.q);
    }
    
    public String[] b(final k k, final p p2) {
        if (!k.j()) {
            return this.c(k, p2);
        }
        final s g = p2.g();
        Object[] array = g.a();
        int n = 0;
        while (true) {
            final org.codehaus.jackson.p b = k.b();
            if (b == org.codehaus.jackson.p.e) {
                break;
            }
            Object i;
            if (b == org.codehaus.jackson.p.m) {
                i = null;
            }
            else {
                i = k.k();
            }
            int n2;
            if (n >= array.length) {
                array = g.a(array);
                n2 = 0;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = i;
        }
        final String[] array2 = g.a(array, n, String.class);
        p2.a(g);
        return array2;
    }
}
