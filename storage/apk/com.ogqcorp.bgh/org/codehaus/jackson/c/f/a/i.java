// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import java.util.Map;
import java.util.EnumMap;
import java.util.Collection;
import java.util.EnumSet;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.f.a;

public class i extends n
{
    public i(final a a, final k k) {
        super(a, k);
    }
    
    @Override
    public String a(final Object o) {
        return this.b(o, o.getClass());
    }
    
    @Override
    public String a(final Object o, final Class<?> clazz) {
        return this.b(o, clazz);
    }
    
    @Override
    public a a(final String s) {
        if (s.indexOf(60) > 0) {
            return k.a(s);
        }
        try {
            return this.c.a(this.d, l.a(s));
        }
        catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Invalid type id '" + s + "' (for id type 'Id.class'): no such class found");
        }
        catch (Exception cause) {
            throw new IllegalArgumentException("Invalid type id '" + s + "' (for id type 'Id.class'): " + cause.getMessage(), cause);
        }
    }
    
    protected final String b(final Object o, Class<?> superclass) {
        if (Enum.class.isAssignableFrom(superclass) && !superclass.isEnum()) {
            superclass = superclass.getSuperclass();
        }
        String s = superclass.getName();
        if (s.startsWith("java.util")) {
            if (o instanceof EnumSet) {
                s = k.a().b(EnumSet.class, l.a((EnumSet<?>)o)).m();
            }
            else {
                if (o instanceof EnumMap) {
                    return k.a().a(EnumMap.class, l.a((EnumMap<?, ?>)o), Object.class).m();
                }
                final String substring = s.substring(9);
                if ((substring.startsWith(".Arrays$") || substring.startsWith(".Collections$")) && s.indexOf("List") >= 0) {
                    return "java.util.ArrayList";
                }
            }
        }
        else if (s.indexOf(36) >= 0 && l.b(superclass) != null && l.b(this.d.p()) == null) {
            return this.d.p().getName();
        }
        return s;
    }
}
