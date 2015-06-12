// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
public class bw extends bt<String>
{
    public bw() {
        super(String.class);
    }
    
    public String b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.h) {
            return k.k();
        }
        if (e == org.codehaus.jackson.p.g) {
            final Object z = k.z();
            if (z == null) {
                return null;
            }
            if (z instanceof byte[]) {
                return org.codehaus.jackson.b.a().a((byte[])z, false);
            }
            return z.toString();
        }
        else {
            if (e.d()) {
                return k.k();
            }
            throw p2.a(this.q, e);
        }
    }
    
    public String b(final k k, final p p3, final az az) {
        return this.b(k, p3);
    }
}
