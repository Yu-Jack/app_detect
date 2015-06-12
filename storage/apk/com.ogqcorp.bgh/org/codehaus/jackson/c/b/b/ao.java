// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;
import java.math.BigDecimal;

@b
public class ao extends bt<BigDecimal>
{
    public ao() {
        super(BigDecimal.class);
    }
    
    public BigDecimal b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i || e == org.codehaus.jackson.p.j) {
            return k.y();
        }
        if (e == org.codehaus.jackson.p.h) {
            final String trim = k.k().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigDecimal(trim);
            }
            catch (IllegalArgumentException ex) {
                throw p2.b(this.q, "not a valid representation");
            }
        }
        throw p2.a(this.q, e);
    }
}
