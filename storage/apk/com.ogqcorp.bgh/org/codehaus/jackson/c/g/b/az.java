// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g.b;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import java.util.TimeZone;

public class az extends s<TimeZone>
{
    public static final az a;
    
    static {
        a = new az();
    }
    
    public az() {
        super(TimeZone.class);
    }
    
    @Override
    public void a(final TimeZone timeZone, final f f, final ax ax) {
        f.b(timeZone.getID());
    }
    
    @Override
    public void a(final TimeZone timeZone, final f f, final ax ax, final ba ba) {
        ba.a(timeZone, f, TimeZone.class);
        this.a(timeZone, f, ax);
        ba.d(timeZone, f);
    }
}
