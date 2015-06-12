// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.util.Date;
import org.codehaus.jackson.c.p;
import java.util.Calendar;

final class bf extends bc
{
    protected bf() {
        super(Calendar.class);
    }
    
    public Calendar c(final String s, final p p2) {
        final Date a = p2.a(s);
        if (a == null) {
            return null;
        }
        return p2.a(a);
    }
}
