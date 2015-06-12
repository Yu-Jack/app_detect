// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.e;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class af extends ad<byte[]>
{
    public af() {
        super(byte[].class);
    }
    
    private final byte[] c(final k k, final p p2) {
        if (k.e() == org.codehaus.jackson.p.h && p2.a(o.q) && k.k().length() == 0) {
            return null;
        }
        if (!p2.a(o.o)) {
            throw p2.b(this.q);
        }
        final org.codehaus.jackson.p e = k.e();
        byte r;
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            r = k.r();
        }
        else {
            if (e != org.codehaus.jackson.p.m) {
                throw p2.b(this.q.getComponentType());
            }
            r = 0;
        }
        return new byte[] { r };
    }
    
    public byte[] b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.h) {
            return k.a(p2.c());
        }
        if (e == org.codehaus.jackson.p.g) {
            final Object z = k.z();
            if (z == null) {
                return null;
            }
            if (z instanceof byte[]) {
                return (byte[])z;
            }
        }
        if (!k.j()) {
            return this.c(k, p2);
        }
        final e b = p2.h().b();
        byte[] array = b.a();
        int n = 0;
        while (true) {
            final org.codehaus.jackson.p b2 = k.b();
            if (b2 == org.codehaus.jackson.p.e) {
                return b.b(array, n);
            }
            byte r;
            if (b2 == org.codehaus.jackson.p.i || b2 == org.codehaus.jackson.p.j) {
                r = k.r();
            }
            else {
                if (b2 != org.codehaus.jackson.p.m) {
                    throw p2.b(this.q.getComponentType());
                }
                r = 0;
            }
            int n2;
            if (n >= array.length) {
                final byte[] array2 = b.a(array, n);
                n2 = 0;
                array = array2;
            }
            else {
                n2 = n;
            }
            n = n2 + 1;
            array[n2] = r;
        }
    }
}
