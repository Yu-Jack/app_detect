// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import org.codehaus.jackson.f;
import org.codehaus.jackson.a.b;
import org.codehaus.jackson.r;

public class f implements r
{
    protected b a;
    protected b b;
    protected boolean c;
    protected int d;
    
    public f() {
        this.a = new g();
        this.b = new h();
        this.c = true;
        this.d = 0;
    }
    
    @Override
    public void a(final org.codehaus.jackson.f f) {
        f.a(' ');
    }
    
    @Override
    public void a(final org.codehaus.jackson.f f, final int n) {
        if (!this.b.a()) {
            --this.d;
        }
        if (n > 0) {
            this.b.a(f, this.d);
        }
        else {
            f.a(' ');
        }
        f.a('}');
    }
    
    @Override
    public void b(final org.codehaus.jackson.f f) {
        f.a('{');
        if (!this.b.a()) {
            ++this.d;
        }
    }
    
    @Override
    public void b(final org.codehaus.jackson.f f, final int n) {
        if (!this.a.a()) {
            --this.d;
        }
        if (n > 0) {
            this.a.a(f, this.d);
        }
        else {
            f.a(' ');
        }
        f.a(']');
    }
    
    @Override
    public void c(final org.codehaus.jackson.f f) {
        f.a(',');
        this.b.a(f, this.d);
    }
    
    @Override
    public void d(final org.codehaus.jackson.f f) {
        if (this.c) {
            f.c(" : ");
            return;
        }
        f.a(':');
    }
    
    @Override
    public void e(final org.codehaus.jackson.f f) {
        if (!this.a.a()) {
            ++this.d;
        }
        f.a('[');
    }
    
    @Override
    public void f(final org.codehaus.jackson.f f) {
        f.a(',');
        this.a.a(f, this.d);
    }
    
    @Override
    public void g(final org.codehaus.jackson.f f) {
        this.a.a(f, this.d);
    }
    
    @Override
    public void h(final org.codehaus.jackson.f f) {
        this.b.a(f, this.d);
    }
}
