// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Collection;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.i.a;

public final class l extends i
{
    protected final String i;
    protected final boolean j;
    protected final i k;
    protected final i l;
    
    public l(final String i, final i k, final i l, final a a, final boolean j) {
        super(k.c(), k.a(), k.e, a);
        this.i = i;
        this.k = k;
        this.l = l;
        this.j = j;
    }
    
    protected l(final l l, final x<Object> x) {
        super(l, x);
        this.i = l.i;
        this.j = l.j;
        this.k = l.k;
        this.l = l.l;
    }
    
    @Override
    public final void a(final Object o, final Object o2) {
        this.k.a(o, o2);
        if (o2 != null) {
            if (this.j) {
                if (o2 instanceof Object[]) {
                    for (final Object o3 : (Object[])o2) {
                        if (o3 != null) {
                            this.l.a(o3, o);
                        }
                    }
                }
                else if (o2 instanceof Collection) {
                    for (final Object next : (Collection)o2) {
                        if (next != null) {
                            this.l.a(next, o);
                        }
                    }
                }
                else {
                    if (!(o2 instanceof Map)) {
                        throw new IllegalStateException("Unsupported container type (" + o2.getClass().getName() + ") when resolving reference '" + this.i + "'");
                    }
                    for (final Object next2 : ((Map)o2).values()) {
                        if (next2 != null) {
                            this.l.a(next2, o);
                        }
                    }
                }
            }
            else {
                this.l.a(o2, o);
            }
        }
    }
    
    @Override
    public void a(final k k, final p p3, final Object o) {
        this.a(o, this.k.a(k, p3));
    }
    
    public l b(final x<Object> x) {
        return new l(this, x);
    }
    
    @Override
    public e b() {
        return this.k.b();
    }
}
