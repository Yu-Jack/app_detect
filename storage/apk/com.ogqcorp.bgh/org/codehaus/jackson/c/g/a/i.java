// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.ad;

final class i extends d
{
    private final Class<?> a;
    private final ad<Object> b;
    
    public i(final Class<?> a, final ad<Object> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public ad<Object> a(final Class<?> clazz) {
        if (clazz == this.a) {
            return this.b;
        }
        return null;
    }
    
    @Override
    public d a(final Class<?> clazz, final ad<Object> ad) {
        return new e(this.a, this.b, clazz, ad);
    }
}
