// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.c;

import org.codehaus.jackson.k;
import org.codehaus.jackson.h;
import org.codehaus.jackson.c.z;

public class a extends z
{
    protected final Class<?> c;
    protected final String d;
    
    public a(final String s, final h h, final Class<?> c, final String d) {
        super(s, h);
        this.c = c;
        this.d = d;
    }
    
    public static a a(final k k, final Object o, final String str) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        Class<?> class1;
        if (o instanceof Class) {
            class1 = (Class<?>)o;
        }
        else {
            class1 = o.getClass();
        }
        final a a = new a("Unrecognized field \"" + str + "\" (Class " + class1.getName() + "), not marked as ignorable", k.i(), class1, str);
        a.a(o, str);
        return a;
    }
}
