// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import java.util.Date;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;

public class as extends v<Object>
{
    static final as a;
    
    static {
        a = new as();
    }
    
    public as() {
        super(Object.class);
    }
    
    @Override
    public void a(final Object o, final f f, final ax ax) {
        if (o instanceof Date) {
            ax.b((Date)o, f);
            return;
        }
        f.a(o.toString());
    }
}
