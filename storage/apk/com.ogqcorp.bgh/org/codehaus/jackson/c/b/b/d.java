// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import java.util.Date;
import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.a.b;
import java.util.Calendar;

@b
public class d extends bt<Calendar>
{
    protected final Class<? extends Calendar> a;
    
    public d() {
        this((Class<? extends Calendar>)null);
    }
    
    public d(final Class<? extends Calendar> a) {
        super(Calendar.class);
        this.a = a;
    }
    
    public Calendar b(final k k, final p p2) {
        final Date b = this.B(k, p2);
        if (b == null) {
            return null;
        }
        if (this.a == null) {
            return p2.a(b);
        }
        try {
            final Calendar calendar = (Calendar)this.a.newInstance();
            calendar.setTimeInMillis(b.getTime());
            return calendar;
        }
        catch (Exception ex) {
            throw p2.a(this.a, ex);
        }
    }
}
