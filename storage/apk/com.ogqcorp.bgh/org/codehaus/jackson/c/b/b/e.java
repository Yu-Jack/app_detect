// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;

@b
public class e extends bt<Class<?>>
{
    public e() {
        super(Class.class);
    }
    
    public Class<?> b(final k k, final p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.h) {
            final String i = k.k();
            if (i.indexOf(46) < 0) {
                if ("int".equals(i)) {
                    return Integer.TYPE;
                }
                if ("long".equals(i)) {
                    return Long.TYPE;
                }
                if ("float".equals(i)) {
                    return Float.TYPE;
                }
                if ("double".equals(i)) {
                    return Double.TYPE;
                }
                if ("boolean".equals(i)) {
                    return Boolean.TYPE;
                }
                if ("byte".equals(i)) {
                    return Byte.TYPE;
                }
                if ("char".equals(i)) {
                    return Character.TYPE;
                }
                if ("short".equals(i)) {
                    return Short.TYPE;
                }
                if ("void".equals(i)) {
                    return Void.TYPE;
                }
            }
            try {
                return Class.forName(k.k());
            }
            catch (ClassNotFoundException ex) {
                throw p2.a(this.q, ex);
            }
        }
        throw p2.a(this.q, e);
    }
}
