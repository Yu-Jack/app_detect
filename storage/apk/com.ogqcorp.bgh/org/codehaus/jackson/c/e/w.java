// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

final class w<T>
{
    public final T a;
    public final w<T> b;
    public final String c;
    public final boolean d;
    public final boolean e;
    
    public w(final T a, final w<T> b, String c, final boolean d, final boolean e) {
        this.a = a;
        this.b = b;
        if (c == null) {
            this.c = null;
        }
        else {
            if (c.length() == 0) {
                c = null;
            }
            this.c = c;
        }
        this.d = d;
        this.e = e;
    }
    
    private w<T> b(final w<T> w) {
        if (this.b == null) {
            return this.a(w);
        }
        return this.a(this.b.b(w));
    }
    
    public w<T> a() {
        if (!this.e) {
            if (this.b != null) {
                final w<T> a = this.b.a();
                if (a != this.b) {
                    return this.a(a);
                }
            }
            return this;
        }
        if (this.b == null) {
            return null;
        }
        return this.b.a();
    }
    
    public w<T> a(final T t) {
        if (t == this.a) {
            return this;
        }
        return new w<T>(t, this.b, this.c, this.d, this.e);
    }
    
    public w<T> a(final w<T> w) {
        if (w == this.b) {
            return this;
        }
        return new w<T>(this.a, w, this.c, this.d, this.e);
    }
    
    public w<T> b() {
        w w;
        if (this.b == null) {
            w = null;
        }
        else {
            w = this.b.b();
        }
        if (this.d) {
            w = this.a(w);
        }
        return w;
    }
    
    public w<T> c() {
        w c;
        if (this.b == null) {
            c = this;
        }
        else {
            c = this.b.c();
            if (this.c != null) {
                if (c.c == null) {
                    return this.a((w<T>)null);
                }
                return this.a(c);
            }
            else if (c.c == null) {
                if (this.d == c.d) {
                    return this.a(c);
                }
                if (this.d) {
                    return this.a((w<T>)null);
                }
            }
        }
        return c;
    }
    
    @Override
    public String toString() {
        String str = this.a.toString() + "[visible=" + this.d + "]";
        if (this.b != null) {
            str = str + ", " + this.b.toString();
        }
        return str;
    }
}
