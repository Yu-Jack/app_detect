// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ad;
import java.util.Date;

public class av extends v<Date>
{
    protected static final ad<?> a;
    
    static {
        a = new av();
    }
    
    public av() {
        super(Date.class);
    }
    
    @Override
    public void a(final Date date, final f f, final ax ax) {
        ax.b(date, f);
    }
}
