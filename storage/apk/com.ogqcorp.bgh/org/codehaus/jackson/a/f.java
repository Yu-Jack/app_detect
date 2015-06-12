// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.g.e;
import org.codehaus.jackson.h;
import org.codehaus.jackson.o;

public final class f extends o
{
    protected final f c;
    protected int d;
    protected int e;
    protected String f;
    protected f g;
    
    public f(final f c, final int a, final int d, final int e) {
        this.g = null;
        this.a = a;
        this.c = c;
        this.d = d;
        this.e = e;
        this.b = -1;
    }
    
    public static f a(final int n, final int n2) {
        return new f(null, 0, n, n2);
    }
    
    public static f g() {
        return new f(null, 0, 1, 0);
    }
    
    public final h a(final Object o) {
        return new h(o, -1L, this.d, this.e);
    }
    
    protected final void a(final int a, final int d, final int e) {
        this.a = a;
        this.b = -1;
        this.d = d;
        this.e = e;
        this.f = null;
    }
    
    public void a(final String f) {
        this.f = f;
    }
    
    public final f b(final int n, final int n2) {
        final f g = this.g;
        if (g == null) {
            return this.g = new f(this, 1, n, n2);
        }
        g.a(1, n, n2);
        return g;
    }
    
    public final f c(final int n, final int n2) {
        final f g = this.g;
        if (g == null) {
            return this.g = new f(this, 2, n, n2);
        }
        g.a(2, n, n2);
        return g;
    }
    
    public final String h() {
        return this.f;
    }
    
    public final f i() {
        return this.c;
    }
    
    public final boolean j() {
        final int b = 1 + this.b;
        this.b = b;
        return this.a != 0 && b > 0;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(64);
        switch (this.a) {
            case 0: {
                sb.append("/");
                break;
            }
            case 1: {
                sb.append('[');
                sb.append(this.f());
                sb.append(']');
                break;
            }
            case 2: {
                sb.append('{');
                if (this.f != null) {
                    sb.append('\"');
                    org.codehaus.jackson.g.e.a(sb, this.f);
                    sb.append('\"');
                }
                else {
                    sb.append('?');
                }
                sb.append('}');
                break;
            }
        }
        return sb.toString();
    }
}
