// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
public final class as extends ay<Character>
{
    public as(final Class<Character> clazz, final Character c) {
        super(clazz, c);
    }
    
    public Character b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i) {
            final int t = k.t();
            if (t >= 0 && t <= 65535) {
                return (char)t;
            }
        }
        else if (e == org.codehaus.jackson.p.h) {
            final String i = k.k();
            if (i.length() == 1) {
                return i.charAt(0);
            }
            if (i.length() == 0) {
                return this.c();
            }
        }
        throw p2.a(this.q, e);
    }
}
