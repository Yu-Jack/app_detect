// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ad;
import java.util.Calendar;

public class au extends v<Calendar>
{
    protected static final ad<?> a;
    
    static {
        a = new au();
    }
    
    public au() {
        super(Calendar.class);
    }
    
    @Override
    public void a(final Calendar calendar, final f f, final ax ax) {
        ax.b(calendar.getTimeInMillis(), f);
    }
}
