// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ad;

public class at
{
    protected static final ad<Object> a;
    protected static final ad<Object> b;
    
    static {
        a = new as();
        b = new aw();
    }
    
    public static ad<Object> a(final a a) {
        if (a == null) {
            return at.a;
        }
        final Class<?> p = a.p();
        if (p == String.class) {
            return at.b;
        }
        if (p == Object.class) {
            return at.a;
        }
        if (Date.class.isAssignableFrom(p)) {
            return (ad<Object>)av.a;
        }
        if (Calendar.class.isAssignableFrom(p)) {
            return (ad<Object>)au.a;
        }
        return at.a;
    }
}
