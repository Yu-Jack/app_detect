// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.HashSet;

public final class b
{
    d a;
    e b;
    j c;
    h d;
    i e;
    g f;
    f g;
    
    public b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }
    
    public static <T> HashSet<T> a(final T[] array) {
        final HashSet<T> set = new HashSet<T>();
        if (array != null) {
            for (int length = array.length, i = 0; i < length; ++i) {
                set.add(array[i]);
            }
        }
        return set;
    }
    
    public static <T> Iterable<T> b(final T[] array) {
        return new c<T>(array);
    }
    
    public d a() {
        if (this.a == null) {
            this.a = new d();
        }
        return this.a;
    }
    
    public e b() {
        if (this.b == null) {
            this.b = new e();
        }
        return this.b;
    }
    
    public j c() {
        if (this.c == null) {
            this.c = new j();
        }
        return this.c;
    }
    
    public h d() {
        if (this.d == null) {
            this.d = new h();
        }
        return this.d;
    }
    
    public i e() {
        if (this.e == null) {
            this.e = new i();
        }
        return this.e;
    }
    
    public g f() {
        if (this.f == null) {
            this.f = new g();
        }
        return this.f;
    }
    
    public f g() {
        if (this.g == null) {
            this.g = new f();
        }
        return this.g;
    }
}
