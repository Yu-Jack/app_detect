// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
final class ag extends ad<char[]>
{
    public ag() {
        super(char[].class);
    }
    
    public char[] b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.h) {
            final char[] l = k.l();
            final int n = k.n();
            final int m = k.m();
            final char[] array = new char[m];
            System.arraycopy(l, n, array, 0, m);
            return array;
        }
        if (!k.j()) {
            if (e == org.codehaus.jackson.p.g) {
                final Object z = k.z();
                if (z == null) {
                    return null;
                }
                if (z instanceof char[]) {
                    return (char[])z;
                }
                if (z instanceof String) {
                    return ((String)z).toCharArray();
                }
                if (z instanceof byte[]) {
                    return org.codehaus.jackson.b.a().a((byte[])z, false).toCharArray();
                }
            }
            throw p2.b(this.q);
        }
        final StringBuilder sb = new StringBuilder(64);
        while (true) {
            final org.codehaus.jackson.p b = k.b();
            if (b == org.codehaus.jackson.p.e) {
                return sb.toString().toCharArray();
            }
            if (b != org.codehaus.jackson.p.h) {
                throw p2.b(Character.TYPE);
            }
            final String i = k.k();
            if (i.length() != 1) {
                throw z.a(k, "Can not convert a JSON String of length " + i.length() + " into a char element of char array");
            }
            sb.append(i.charAt(0));
        }
    }
}
