// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.lang.reflect.Constructor;

final class bo extends bc
{
    protected final Constructor<?> b;
    
    public bo(final Constructor<?> b) {
        super(b.getDeclaringClass());
        this.b = b;
    }
    
    public Object b(final String s, final p p2) {
        return this.b.newInstance(s);
    }
}
