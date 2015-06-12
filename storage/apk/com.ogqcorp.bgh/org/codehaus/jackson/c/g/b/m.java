// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.f.a;
import java.lang.reflect.Modifier;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.z;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.jackson.c.ba;
import java.io.IOException;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.ad;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.a.b;
import org.codehaus.jackson.c.as;

@b
public class m extends v<Object> implements as
{
    protected final Method a;
    protected ad<Object> b;
    protected final f c;
    protected boolean d;
    
    public m(final Method a, final ad<Object> b, final f c) {
        super(Object.class);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void a(final Object obj, final org.codehaus.jackson.f f, final ax ax) {
        try {
            final Object invoke = this.a.invoke(obj, new Object[0]);
            if (invoke == null) {
                ax.a(f);
                return;
            }
            ad<Object> ad = this.b;
            if (ad == null) {
                ad = ax.a(invoke.getClass(), true, this.c);
            }
            ad.a(invoke, f, ax);
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (Exception t) {
            goto Label_0067;
        }
    }
    
    @Override
    public void a(final Object obj, final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        try {
            final Object invoke = this.a.invoke(obj, new Object[0]);
            if (invoke == null) {
                ax.a(f);
                return;
            }
            final ad<Object> b = this.b;
            if (b == null) {
                goto Label_0081;
            }
            if (this.d) {
                ba.a(obj, f);
            }
            b.a(invoke, f, ax, ba);
            if (this.d) {
                ba.d(obj, f);
            }
        }
        catch (IOException ex) {
            throw ex;
        }
        catch (Exception cause) {
            while (cause instanceof InvocationTargetException && cause.getCause() != null) {
                cause = cause.getCause();
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw z.a(cause, obj, this.a.getName() + "()");
        }
    }
    
    @Override
    public void a(final ax ax) {
        if (this.b == null && (ax.a(au.h) || Modifier.isFinal(this.a.getReturnType().getModifiers()))) {
            final a a = ax.a(this.a.getGenericReturnType());
            this.b = ax.a(a, false, this.c);
            this.d = this.a(a, this.b);
        }
    }
    
    protected boolean a(final a a, final ad<?> ad) {
        final Class<?> p2 = a.p();
        Label_0059: {
            if (a.t()) {
                if (p2 == Integer.TYPE || p2 == Boolean.TYPE || p2 == Double.TYPE) {
                    break Label_0059;
                }
            }
            else if (p2 == String.class || p2 == Integer.class || p2 == Boolean.class || p2 == Double.class) {
                break Label_0059;
            }
            return false;
        }
        if (ad.getClass().getAnnotation(b.class) != null) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(@JsonValue serializer for method " + this.a.getDeclaringClass() + "#" + this.a.getName() + ")";
    }
}
