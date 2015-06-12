// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.lang.reflect.Type;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.f.a;
import java.util.HashMap;

public class ac
{
    static final ac b;
    HashMap<a, x<Object>> a;
    
    static {
        b = new ac();
    }
    
    protected ac() {
        this.a = new HashMap<a, x<Object>>();
        this.a(Boolean.TYPE, new ae());
        this.a(Byte.TYPE, new af());
        this.a(Short.TYPE, new al());
        this.a(Integer.TYPE, new aj());
        this.a(Long.TYPE, new ak());
        this.a(Float.TYPE, new ai());
        this.a(Double.TYPE, new ah());
        this.a(String.class, new am());
        this.a(Character.TYPE, new ag());
    }
    
    public static HashMap<a, x<Object>> a() {
        return ac.b.a;
    }
    
    private void a(final Class<?> clazz, final x<?> value) {
        this.a.put(k.a().a((Type)clazz), (x<Object>)value);
    }
}
