// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import java.sql.Date;

public class ba extends bt<Date>
{
    public ba() {
        super(Date.class);
    }
    
    public Date b(final k k, final p p2) {
        final java.util.Date b = this.B(k, p2);
        if (b == null) {
            return null;
        }
        return new Date(b.getTime());
    }
}
