// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;

final class bq extends bc
{
    private static final bq b;
    private static final bq c;
    
    static {
        b = new bq(String.class);
        c = new bq(Object.class);
    }
    
    private bq(final Class<?> clazz) {
        super(clazz);
    }
    
    public static bq a(final Class<?> clazz) {
        if (clazz == String.class) {
            return bq.b;
        }
        if (clazz == Object.class) {
            return bq.c;
        }
        return new bq(clazz);
    }
    
    public String c(final String s, final p p2) {
        return s;
    }
}
