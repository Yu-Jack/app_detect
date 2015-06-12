// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.z;
import java.util.Map;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.c.e.f;
import org.codehaus.jackson.c.g.b.n;
import java.lang.reflect.Method;

public class a
{
    protected final Method a;
    protected final n b;
    
    public a(final f f, final n b) {
        this.a = f.e();
        this.b = b;
    }
    
    public void a(final Object obj, final org.codehaus.jackson.f f, final ax ax) {
        final Object invoke = this.a.invoke(obj, new Object[0]);
        if (invoke == null) {
            return;
        }
        if (!(invoke instanceof Map)) {
            throw new z("Value returned by 'any-getter' (" + this.a.getName() + "()) not java.util.Map but " + ((Map<?, ?>)invoke).getClass().getName());
        }
        this.b.b((Map<?, ?>)invoke, f, ax);
    }
    
    public void a(final ax ax) {
        this.b.a(ax);
    }
}
