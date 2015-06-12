// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import java.util.Date;

@b
public class f extends s<Date>
{
    public static f a;
    
    static {
        f.a = new f();
    }
    
    public f() {
        super(Date.class);
    }
    
    @Override
    public void a(final Date date, final org.codehaus.jackson.f f, final ax ax) {
        ax.a(date, f);
    }
}
