// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.net.URL;

public class u extends m<URL>
{
    public u() {
        super(URL.class);
    }
    
    protected URL b(final String spec, final p p2) {
        return new URL(spec);
    }
}
