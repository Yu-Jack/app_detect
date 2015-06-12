// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.net.URI;

public class t extends m<URI>
{
    public t() {
        super(URI.class);
    }
    
    protected URI b(final String str, final p p2) {
        return URI.create(str);
    }
}
