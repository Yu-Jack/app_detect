// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import java.sql.Time;
import org.codehaus.jackson.c.g.b.s;

@b
public final class ae extends s<Time>
{
    public ae() {
        super(Time.class);
    }
    
    @Override
    public void a(final Time time, final f f, final ax ax) {
        f.b(time.toString());
    }
}
