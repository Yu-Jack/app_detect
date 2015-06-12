// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f.a;

import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.f.c;

public class d extends p
{
    protected final String a;
    
    public d(final c c, final f f, final String a) {
        super(c, f);
        this.a = a;
    }
    
    @Override
    public void a(final Object o, final org.codehaus.jackson.f f) {
        this.g(o, f);
    }
    
    @Override
    public void a(final Object o, final org.codehaus.jackson.f f, final Class<?> clazz) {
        this.b(o, f, clazz);
    }
    
    @Override
    public void b(final Object o, final org.codehaus.jackson.f f) {
        this.g(o, f);
    }
    
    protected final void b(final Object o, final org.codehaus.jackson.f f, final Class<?> clazz) {
        f.d();
    }
    
    @Override
    public void c(final Object o, final org.codehaus.jackson.f f) {
        this.g(o, f);
    }
    
    @Override
    public void d(final Object o, final org.codehaus.jackson.f f) {
        this.h(o, f);
    }
    
    @Override
    public void e(final Object o, final org.codehaus.jackson.f f) {
        this.h(o, f);
    }
    
    @Override
    public void f(final Object o, final org.codehaus.jackson.f f) {
        this.h(o, f);
    }
    
    protected final void g(final Object o, final org.codehaus.jackson.f f) {
        f.d();
    }
    
    protected final void h(final Object o, final org.codehaus.jackson.f f) {
        f.e();
        f.a(this.a, this.b.a(o));
    }
}
