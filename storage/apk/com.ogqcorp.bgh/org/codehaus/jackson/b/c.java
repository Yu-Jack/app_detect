// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import org.codehaus.jackson.g.l;
import org.codehaus.jackson.g.b;
import org.codehaus.jackson.g.a;
import org.codehaus.jackson.c;

public final class c
{
    protected final Object a;
    protected org.codehaus.jackson.c b;
    protected final boolean c;
    protected final a d;
    protected byte[] e;
    protected byte[] f;
    protected char[] g;
    protected char[] h;
    protected char[] i;
    
    public c(final a d, final Object a, final boolean c) {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.d = d;
        this.a = a;
        this.c = c;
    }
    
    public final Object a() {
        return this.a;
    }
    
    public void a(final org.codehaus.jackson.c b) {
        this.b = b;
    }
    
    public final void a(final byte[] array) {
        if (array != null) {
            if (array != this.e) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.e = null;
            this.d.a(org.codehaus.jackson.g.b.a, array);
        }
    }
    
    public final void a(final char[] array) {
        if (array != null) {
            if (array != this.g) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.g = null;
            this.d.a(org.codehaus.jackson.g.c.a, array);
        }
    }
    
    public final char[] a(final int n) {
        if (this.i != null) {
            throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
        }
        return this.i = this.d.a(org.codehaus.jackson.g.c.d, n);
    }
    
    public final org.codehaus.jackson.c b() {
        return this.b;
    }
    
    public final void b(final byte[] array) {
        if (array != null) {
            if (array != this.f) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.f = null;
            this.d.a(org.codehaus.jackson.g.b.b, array);
        }
    }
    
    public final void b(final char[] array) {
        if (array != null) {
            if (array != this.h) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.h = null;
            this.d.a(org.codehaus.jackson.g.c.b, array);
        }
    }
    
    public final void c(final char[] array) {
        if (array != null) {
            if (array != this.i) {
                throw new IllegalArgumentException("Trying to release buffer not owned by the context");
            }
            this.i = null;
            this.d.a(org.codehaus.jackson.g.c.d, array);
        }
    }
    
    public final boolean c() {
        return this.c;
    }
    
    public final l d() {
        return new l(this.d);
    }
    
    public final byte[] e() {
        if (this.e != null) {
            throw new IllegalStateException("Trying to call allocReadIOBuffer() second time");
        }
        return this.e = this.d.a(org.codehaus.jackson.g.b.a);
    }
    
    public final byte[] f() {
        if (this.f != null) {
            throw new IllegalStateException("Trying to call allocWriteEncodingBuffer() second time");
        }
        return this.f = this.d.a(org.codehaus.jackson.g.b.b);
    }
    
    public final char[] g() {
        if (this.g != null) {
            throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
        }
        return this.g = this.d.a(org.codehaus.jackson.g.c.a);
    }
    
    public final char[] h() {
        if (this.h != null) {
            throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
        }
        return this.h = this.d.a(org.codehaus.jackson.g.c.b);
    }
}
