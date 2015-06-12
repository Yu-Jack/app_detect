// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.lang.reflect.Method;

final class bp extends bc
{
    final Method b;
    
    public bp(final Method b) {
        super(b.getDeclaringClass());
        this.b = b;
    }
    
    public Object b(final String s, final p p2) {
        return this.b.invoke(null, s);
    }
}
