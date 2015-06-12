// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;

public final class e extends r
{
    public static final e c;
    public static final e d;
    
    static {
        c = new e();
        d = new e();
    }
    
    public static e d() {
        return e.c;
    }
    
    public static e e() {
        return e.d;
    }
    
    @Override
    public String a() {
        if (this == e.c) {
            return "true";
        }
        return "false";
    }
    
    @Override
    public final void a(final f f, final ax ax) {
        f.a(this == e.c);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this;
    }
}
