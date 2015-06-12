// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.ad;

final class g extends d
{
    private final j[] a;
    
    public g(final j[] a) {
        this.a = a;
    }
    
    @Override
    public ad<Object> a(final Class<?> clazz) {
        for (int i = 0; i < this.a.length; ++i) {
            final j j = this.a[i];
            if (j.a == clazz) {
                return j.b;
            }
        }
        return null;
    }
    
    @Override
    public d a(final Class<?> clazz, final ad<Object> ad) {
        final int length = this.a.length;
        if (length == 8) {
            return this;
        }
        final j[] array = new j[length + 1];
        System.arraycopy(this.a, 0, array, 0, length);
        array[length] = new j(clazz, ad);
        return new g(array);
    }
}
