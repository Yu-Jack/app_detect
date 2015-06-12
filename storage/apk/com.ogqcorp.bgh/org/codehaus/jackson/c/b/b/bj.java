// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.c.e.f;
import org.codehaus.jackson.c.i.o;

final class bj extends bc
{
    protected final o<?> b;
    protected final f c;
    
    protected bj(final o<?> b, final f c) {
        super(b.a());
        this.b = b;
        this.c = c;
    }
    
    public Object b(final String s, final p p2) {
        Label_0029: {
            if (this.c == null) {
                break Label_0029;
            }
            try {
                return this.c.a(s);
            }
            catch (Exception ex) {
                l.c(ex);
            }
        }
        final Object o = this.b.a(s);
        if (o == null) {
            throw p2.a(this.a, s, "not one of values for Enum class");
        }
        return o;
    }
}
