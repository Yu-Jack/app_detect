// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.Map;
import java.util.Collection;
import org.codehaus.jackson.c.i.l;
import java.lang.reflect.Method;

@Deprecated
public final class o extends p
{
    @Override
    public boolean a(final Method method) {
        if (!super.a(method)) {
            if (!l.a(method)) {
                return false;
            }
            final Class<?> returnType = method.getReturnType();
            if (!Collection.class.isAssignableFrom(returnType) && !Map.class.isAssignableFrom(returnType)) {
                return false;
            }
        }
        return true;
    }
}
