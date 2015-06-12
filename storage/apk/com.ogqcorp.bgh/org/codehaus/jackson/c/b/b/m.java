// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.k;
import java.util.ArrayList;

public abstract class m<T> extends bt<T>
{
    protected m(final Class<?> clazz) {
        super(clazz);
    }
    
    public static Iterable<m<?>> d() {
        final ArrayList<v> list = (ArrayList<v>)new ArrayList<m<?>>();
        list.add(new v());
        list.add((v)new u());
        list.add((v)new t());
        list.add((v)new o());
        list.add((v)new r());
        list.add((v)new q());
        list.add((v)new p());
        list.add((v)new s());
        list.add((v)new n());
        return (Iterable<m<?>>)list;
    }
    
    protected T a(final Object o, final org.codehaus.jackson.c.p p2) {
        throw p2.b("Don't know how to convert embedded Object of type " + o.getClass().getName() + " into " + this.q.getName());
    }
    
    protected abstract T a(final String p0, final org.codehaus.jackson.c.p p1);
    
    @Override
    public final T a(final k k, final org.codehaus.jackson.c.p p2) {
        Label_0066: {
            if (k.e() != org.codehaus.jackson.p.h) {
                break Label_0066;
            }
            final String trim = k.k().trim();
            final int length = trim.length();
            T a = null;
            Label_0037: {
                if (length != 0) {
                    break Label_0037;
                }
                Label_0034: {
                    return a;
                }
                try {
                    a = this.a(trim, p2);
                    if (a == null) {
                        throw p2.b(this.q, "not a valid textual representation");
                    }
                    return a;
                    Object z = null;
                    Label_0104:
                    return this.a(z, p2);
                    Label_0111:
                    throw p2.b(this.q);
                    // iftrue(Label_0104:, !this.q.isAssignableFrom(z.getClass()))
                    // iftrue(Label_0034:, z == null)
                    while (true) {
                        while (true) {
                            return (T)z;
                            z = k.z();
                            a = null;
                            continue;
                        }
                        continue;
                    }
                }
                // iftrue(Label_0111:, k.e() != org.codehaus.jackson.p.g)
                catch (IllegalArgumentException ex) {
                    throw p2.b(this.q, "not a valid textual representation");
                }
            }
        }
    }
}
