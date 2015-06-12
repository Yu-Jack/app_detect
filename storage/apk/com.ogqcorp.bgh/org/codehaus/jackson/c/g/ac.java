// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.math.BigInteger;
import java.math.BigDecimal;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.g.b.s;

@b
public final class ac extends s<Number>
{
    public static final ac a;
    
    static {
        a = new ac();
    }
    
    public ac() {
        super(Number.class);
    }
    
    @Override
    public void a(final Number n, final f f, final ax ax) {
        if (n instanceof BigDecimal) {
            f.a((BigDecimal)n);
            return;
        }
        if (n instanceof BigInteger) {
            f.a((BigInteger)n);
            return;
        }
        if (n instanceof Integer) {
            f.b(n.intValue());
            return;
        }
        if (n instanceof Long) {
            f.a(n.longValue());
            return;
        }
        if (n instanceof Double) {
            f.a(n.doubleValue());
            return;
        }
        if (n instanceof Float) {
            f.a(n.floatValue());
            return;
        }
        if (n instanceof Byte || n instanceof Short) {
            f.b(n.intValue());
            return;
        }
        f.e(n.toString());
    }
}
