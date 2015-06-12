// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b.a;

import java.util.Map;

final class l extends j
{
    final Object c;
    
    public l(final j j, final Object o, final Object c) {
        super(j, o);
        this.c = c;
    }
    
    @Override
    public void a(final Object o) {
        ((Map)o).put(this.c, this.b);
    }
}
