// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.util.TimeZone;

public class s extends m<TimeZone>
{
    public s() {
        super(TimeZone.class);
    }
    
    protected TimeZone b(final String id, final p p2) {
        return TimeZone.getTimeZone(id);
    }
}
