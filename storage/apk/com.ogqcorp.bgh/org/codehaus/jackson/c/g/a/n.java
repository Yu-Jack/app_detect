// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.a;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.z;
import org.codehaus.jackson.c.g.b.v;

public class n extends v<Object>
{
    public n() {
        super(Object.class);
    }
    
    protected void a(final Object o) {
        throw new z("No serializer found for class " + o.getClass().getName() + " and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )");
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax) {
        if (ax.a(au.m)) {
            this.a(o);
        }
        f.d();
        f.e();
    }
    
    @Override
    public final void a(final Object o, final f f, final ax ax, final ba ba) {
        if (ax.a(au.m)) {
            this.a(o);
        }
        ba.b(o, f);
        ba.e(o, f);
    }
}
