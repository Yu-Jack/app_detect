// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.ad;

final class e extends d
{
    private final Class<?> a;
    private final Class<?> b;
    private final ad<Object> c;
    private final ad<Object> d;
    
    public e(final Class<?> a, final ad<Object> c, final Class<?> b, final ad<Object> d) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    @Override
    public ad<Object> a(final Class<?> clazz) {
        if (clazz == this.a) {
            return this.c;
        }
        if (clazz == this.b) {
            return this.d;
        }
        return null;
    }
    
    @Override
    public d a(final Class<?> clazz, final ad<Object> ad) {
        return new g(new j[] { new j(this.a, this.c), new j(this.b, this.d) });
    }
}
