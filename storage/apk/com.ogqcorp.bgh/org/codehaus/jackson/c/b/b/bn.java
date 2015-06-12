// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;

final class bn extends bc
{
    bn() {
        super(Integer.class);
    }
    
    public Short c(final String s, final p p2) {
        final int a = this.a(s);
        if (a < -32768 || a > 32767) {
            throw p2.a(this.a, s, "overflow, value can not be represented as 16-bit value");
        }
        return (short)a;
    }
}
