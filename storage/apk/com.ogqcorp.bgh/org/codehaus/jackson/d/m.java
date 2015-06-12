// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;

public final class m extends r
{
    public static final m c;
    
    static {
        c = new m();
    }
    
    public static m d() {
        return m.c;
    }
    
    @Override
    public String a() {
        return "null";
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.f();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this;
    }
}
