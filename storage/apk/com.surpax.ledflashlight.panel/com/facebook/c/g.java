// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.lang.reflect.Proxy;
import com.facebook.ac;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

abstract class g implements InvocationHandler
{
    protected final Object a;
    
    protected g(final Object a) {
        this.a = a;
    }
    
    protected final Object a(final Method method) {
        throw new ac(String.valueOf(this.getClass().getName()) + " got an unexpected method signature: " + method.toString());
    }
    
    protected final Object a(final Method method, final Object[] args) {
        final String name = method.getName();
        if (name.equals("equals")) {
            final Object proxy = args[0];
            if (proxy == null) {
                return false;
            }
            final InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
            if (!(invocationHandler instanceof f)) {
                return false;
            }
            return this.a.equals(((f)invocationHandler).a);
        }
        else {
            if (name.equals("toString")) {
                return this.toString();
            }
            return method.invoke(this.a, args);
        }
    }
}
