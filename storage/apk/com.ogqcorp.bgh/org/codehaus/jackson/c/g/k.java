// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

public abstract class k
{
    public static d a(final d d, final Class<?>[] array) {
        if (array.length == 1) {
            return new m(d, array[0]);
        }
        return new l(d, array);
    }
}
