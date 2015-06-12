// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

@Deprecated
public class p implements s
{
    @Override
    public boolean a(final Method method) {
        if (Modifier.isStatic(method.getModifiers())) {
            return false;
        }
        switch (method.getParameterTypes().length) {
            default: {
                return false;
            }
            case 1: {
                return true;
            }
            case 2: {
                return true;
            }
        }
    }
}
