// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import java.util.Calendar;

@b
public class c extends s<Calendar>
{
    public static c a;
    
    static {
        c.a = new c();
    }
    
    public c() {
        super(Calendar.class);
    }
    
    @Override
    public void a(final Calendar calendar, final f f, final ax ax) {
        ax.a(calendar.getTimeInMillis(), f);
    }
}
