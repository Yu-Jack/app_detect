// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.x;

public class a extends x<Object>
{
    protected final org.codehaus.jackson.f.a a;
    protected final boolean b;
    protected final boolean c;
    protected final boolean d;
    protected final boolean e;
    
    public a(final org.codehaus.jackson.f.a a) {
        this.a = a;
        final Class<?> p = a.p();
        this.b = p.isAssignableFrom(String.class);
        this.c = (p == Boolean.TYPE || p.isAssignableFrom(Boolean.class));
        this.d = (p == Integer.TYPE || p.isAssignableFrom(Integer.class));
        boolean e = false;
        Label_0098: {
            if (p != Double.TYPE) {
                final boolean assignable = p.isAssignableFrom(Double.class);
                e = false;
                if (!assignable) {
                    break Label_0098;
                }
            }
            e = true;
        }
        this.e = e;
    }
    
    @Override
    public Object a(final k k, final p p2) {
        throw p2.a(this.a.p(), "abstract types can only be instantiated with additional type information");
    }
    
    @Override
    public Object a(final k k, final p p3, final az az) {
        final Object b = this.b(k, p3);
        if (b != null) {
            return b;
        }
        return az.a(k, p3);
    }
    
    protected Object b(final k k, final p p2) {
        switch (a$1.a[k.e().ordinal()]) {
            case 1: {
                if (this.b) {
                    return k.k();
                }
                break;
            }
            case 2: {
                if (this.d) {
                    return k.t();
                }
                break;
            }
            case 3: {
                if (this.e) {
                    return k.x();
                }
                break;
            }
            case 4: {
                if (this.c) {
                    return Boolean.TRUE;
                }
                break;
            }
            case 5: {
                if (this.c) {
                    return Boolean.FALSE;
                }
                break;
            }
        }
        return null;
    }
}
