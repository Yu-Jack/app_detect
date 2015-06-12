// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.a.b;
import java.sql.Date;
import org.codehaus.jackson.c.g.b.s;

@b
public final class ad extends s<Date>
{
    public ad() {
        super(Date.class);
    }
    
    @Override
    public void a(final Date date, final f f, final ax ax) {
        f.b(date.toString());
    }
}
