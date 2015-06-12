// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Iterator;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.ad;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.a.b;

@b
public class l extends a<Iterable<?>>
{
    public l(final org.codehaus.jackson.f.a a, final boolean b, final ba ba, final f f) {
        super(Iterable.class, a, b, ba, f, null);
    }
    
    @Override
    public e<?> a(final ba ba) {
        return new l(this.b, this.a, ba, this.e);
    }
    
    @Override
    public void a(final Iterable<?> iterable, final org.codehaus.jackson.f f, final ax ax) {
        Class<?> clazz = null;
        final Iterator<?> iterator = iterable.iterator();
        if (iterator.hasNext()) {
            final ba c = this.c;
            ad<Object> a = null;
            do {
                final Object next = iterator.next();
                if (next == null) {
                    ax.a(f);
                }
                else {
                    final Class<?> class1 = next.getClass();
                    ad<Object> ad;
                    if (class1 == clazz) {
                        ad = a;
                    }
                    else {
                        a = ax.a(class1, this.e);
                        clazz = class1;
                        ad = a;
                    }
                    if (c == null) {
                        ad.a(next, f, ax);
                    }
                    else {
                        ad.a(next, f, ax, c);
                    }
                }
            } while (iterator.hasNext());
        }
    }
}
