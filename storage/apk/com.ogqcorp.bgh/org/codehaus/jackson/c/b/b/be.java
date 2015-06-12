// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;

final class be extends bc
{
    be() {
        super(Byte.class);
    }
    
    public Byte c(final String s, final p p2) {
        final int a = this.a(s);
        if (a < -128 || a > 255) {
            throw p2.a(this.a, s, "overflow, value can not be represented as 8-bit value");
        }
        return (byte)a;
    }
}
