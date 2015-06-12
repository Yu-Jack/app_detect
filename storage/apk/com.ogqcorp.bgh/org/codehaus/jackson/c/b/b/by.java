// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import org.codehaus.jackson.k;
import java.sql.Timestamp;

public class by extends bt<Timestamp>
{
    public by() {
        super(Timestamp.class);
    }
    
    public Timestamp b(final k k, final p p2) {
        return new Timestamp(this.B(k, p2).getTime());
    }
}
