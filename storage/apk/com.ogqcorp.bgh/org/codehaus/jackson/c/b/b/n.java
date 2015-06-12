// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;
import java.nio.charset.Charset;

public class n extends m<Charset>
{
    public n() {
        super(Charset.class);
    }
    
    protected Charset b(final String charsetName, final p p2) {
        return Charset.forName(charsetName);
    }
}
