// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.o;

public class g extends o
{
    protected final g c;
    protected String d;
    protected g e;
    
    protected g(final int a, final g c) {
        this.e = null;
        this.a = a;
        this.c = c;
        this.b = -1;
    }
    
    private final g a(final int a) {
        this.a = a;
        this.b = -1;
        this.d = null;
        return this;
    }
    
    public static g g() {
        return new g(0, null);
    }
    
    public final int a(final String d) {
        if (this.a != 2 || this.d != null) {
            return 4;
        }
        this.d = d;
        if (this.b < 0) {
            return 0;
        }
        return 1;
    }
    
    protected final void a(final StringBuilder sb) {
        if (this.a == 2) {
            sb.append('{');
            if (this.d != null) {
                sb.append('\"');
                sb.append(this.d);
                sb.append('\"');
            }
            else {
                sb.append('?');
            }
            sb.append('}');
            return;
        }
        if (this.a == 1) {
            sb.append('[');
            sb.append(this.f());
            sb.append(']');
            return;
        }
        sb.append("/");
    }
    
    public final g h() {
        final g e = this.e;
        if (e == null) {
            return this.e = new g(1, this);
        }
        return e.a(1);
    }
    
    public final g i() {
        final g e = this.e;
        if (e == null) {
            return this.e = new g(2, this);
        }
        return e.a(2);
    }
    
    public final g j() {
        return this.c;
    }
    
    public final int k() {
        int n;
        if (this.a == 2) {
            if (this.d != null) {
                this.d = null;
                ++this.b;
                return 2;
            }
            n = 5;
        }
        else if (this.a == 1) {
            final int b = this.b;
            ++this.b;
            n = 0;
            if (b >= 0) {
                return 1;
            }
        }
        else {
            ++this.b;
            final int b2 = this.b;
            n = 0;
            if (b2 != 0) {
                return 3;
            }
        }
        return n;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(64);
        this.a(sb);
        return sb.toString();
    }
}
