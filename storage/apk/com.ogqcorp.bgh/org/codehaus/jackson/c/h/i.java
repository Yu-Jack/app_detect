// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import org.codehaus.jackson.c.ba;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.ac;
import org.codehaus.jackson.f.a;

public abstract class i extends a implements ac
{
    volatile String c;
    
    protected i(final Class<?> clazz, final int n, final Object f, final Object g) {
        super(clazz, n);
        this.f = f;
        this.g = g;
    }
    
    protected abstract String a();
    
    @Override
    public void a(final f f, final ax ax) {
        f.b(this.m());
    }
    
    @Override
    public void a(final f f, final ax ax, final ba ba) {
        ba.a(this, f);
        this.a(f, ax);
        ba.d(this, f);
    }
    
    @Override
    public String m() {
        String s = this.c;
        if (s == null) {
            s = this.a();
        }
        return s;
    }
    
    @Override
    public <T> T n() {
        return (T)this.f;
    }
    
    @Override
    public <T> T o() {
        return (T)this.g;
    }
}
