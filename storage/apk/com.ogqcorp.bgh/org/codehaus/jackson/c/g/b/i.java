// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Iterator;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.f;
import java.util.EnumSet;

public class i extends a<EnumSet<? extends Enum<?>>>
{
    public i(final org.codehaus.jackson.f.a a, final f f) {
        super(EnumSet.class, a, true, null, f, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return this;
    }
    
    @Override
    public void a(final EnumSet<? extends Enum<?>> set, final org.codehaus.jackson.f f, final ax ax) {
        final ad<Object> d = this.d;
        final Iterator<Enum<?>> iterator = set.iterator();
        ad<Object> a = d;
        while (iterator.hasNext()) {
            final Enum<?> enum1 = iterator.next();
            if (a == null) {
                a = ax.a(enum1.getDeclaringClass(), this.e);
            }
            a.a(enum1, f, ax);
        }
    }
}
