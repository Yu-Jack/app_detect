// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.b;

import org.codehaus.jackson.c.p;

final class bd extends bc
{
    bd() {
        super(Boolean.class);
    }
    
    public Boolean c(final String s, final p p2) {
        if ("true".equals(s)) {
            return Boolean.TRUE;
        }
        if ("false".equals(s)) {
            return Boolean.FALSE;
        }
        throw p2.a(this.a, s, "value not 'true' or 'false'");
    }
}
