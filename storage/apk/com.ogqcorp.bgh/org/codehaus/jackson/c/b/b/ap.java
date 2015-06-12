// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;
import java.math.BigInteger;

@b
public class ap extends bt<BigInteger>
{
    public ap() {
        super(BigInteger.class);
    }
    
    public BigInteger b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i) {
            switch (an$1.b[k.q().ordinal()]) {
                case 1:
                case 2: {
                    return BigInteger.valueOf(k.u());
                }
            }
        }
        else {
            if (e == org.codehaus.jackson.p.j) {
                return k.y().toBigInteger();
            }
            if (e != org.codehaus.jackson.p.h) {
                throw p2.a(this.q, e);
            }
        }
        final String trim = k.k().trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            return new BigInteger(trim);
        }
        catch (IllegalArgumentException ex) {
            throw p2.b(this.q, "not a valid representation");
        }
    }
}
