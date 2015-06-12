// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.lang.reflect.Array;

public class o
{
    @Override
    public boolean equals(final Object o) {
        return o == null || Array.getLength(o) == 0;
    }
}
