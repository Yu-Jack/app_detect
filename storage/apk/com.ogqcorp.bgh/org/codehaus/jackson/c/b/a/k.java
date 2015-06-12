// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import org.codehaus.jackson.c.b.h;

final class k extends j
{
    final h c;
    final String d;
    
    public k(final j j, final Object o, final h c, final String d) {
        super(j, o);
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void a(final Object o) {
        this.c.a(o, this.d, this.b);
    }
}
