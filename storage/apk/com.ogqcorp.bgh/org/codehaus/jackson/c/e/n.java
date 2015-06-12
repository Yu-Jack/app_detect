// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

class n implements s
{
    @Override
    public boolean a(final Method method) {
        return !Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length <= 2;
    }
}
