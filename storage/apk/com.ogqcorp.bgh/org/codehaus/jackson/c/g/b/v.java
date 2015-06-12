// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.z;
import java.io.IOException;
import org.codehaus.jackson.c.au;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ad;

public abstract class v<T> extends ad<T>
{
    protected final Class<T> k;
    
    protected v(final Class<T> k) {
        this.k = k;
    }
    
    protected v(final Class<?> k, final boolean b) {
        this.k = (Class<T>)k;
    }
    
    protected v(final a a) {
        this.k = (Class<T>)a.p();
    }
    
    @Override
    public abstract void a(final T p0, final f p1, final ax p2);
    
    public void a(final ax ax, final Throwable t, final Object o, final int n) {
        Throwable cause;
        for (cause = t; cause instanceof InvocationTargetException && cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        boolean b;
        if (ax == null || ax.a(au.n)) {
            b = true;
        }
        else {
            b = false;
        }
        if (cause instanceof IOException) {
            if (!b || !(cause instanceof z)) {
                throw (IOException)cause;
            }
        }
        else if (!b && cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw z.a(cause, o, n);
    }
    
    public void a(final ax ax, final Throwable t, final Object o, final String s) {
        Throwable cause;
        for (cause = t; cause instanceof InvocationTargetException && cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        boolean b;
        if (ax == null || ax.a(au.n)) {
            b = true;
        }
        else {
            b = false;
        }
        if (cause instanceof IOException) {
            if (!b || !(cause instanceof z)) {
                throw (IOException)cause;
            }
        }
        else if (!b && cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw z.a(cause, o, s);
    }
    
    protected boolean a(final ad<?> ad) {
        return ad != null && ad.getClass().getAnnotation(b.class) != null;
    }
    
    @Override
    public final Class<T> c() {
        return this.k;
    }
}
