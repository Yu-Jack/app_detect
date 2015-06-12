// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
public final class ax extends bt<Number>
{
    public ax() {
        super(Number.class);
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        switch (an$1.a[k.e().ordinal()]) {
            default: {
                return az.c(k, p3);
            }
            case 1:
            case 2:
            case 3: {
                return this.b(k, p3);
            }
        }
    }
    
    public Number b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.i) {
            if (p2.a(o.h)) {
                return k.v();
            }
            return k.p();
        }
        else if (e == org.codehaus.jackson.p.j) {
            if (p2.a(o.g)) {
                return k.y();
            }
            return k.x();
        }
        else {
            if (e != org.codehaus.jackson.p.h) {
                throw p2.a(this.q, e);
            }
            final String trim = k.k().trim();
            Label_0135: {
                try {
                    if (trim.indexOf(46) < 0) {
                        break Label_0135;
                    }
                    if (p2.a(o.g)) {
                        return new BigDecimal(trim);
                    }
                }
                catch (IllegalArgumentException ex) {
                    throw p2.b(this.q, "not a valid number");
                }
                return new Double(trim);
            }
            if (p2.a(o.h)) {
                return new BigInteger(trim);
            }
            final long long1 = Long.parseLong(trim);
            if (long1 <= 2147483647L && long1 >= -2147483648L) {
                return (int)long1;
            }
            return long1;
        }
    }
}
