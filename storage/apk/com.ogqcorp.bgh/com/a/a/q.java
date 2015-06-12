// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

public class q<T>
{
    public final T a;
    public final c b;
    public final x c;
    public boolean d;
    
    private q(final x c) {
        this.d = false;
        this.a = null;
        this.b = null;
        this.c = c;
    }
    
    private q(final T a, final c b) {
        this.d = false;
        this.a = a;
        this.b = b;
        this.c = null;
    }
    
    public static <T> q<T> a(final x x) {
        return new q<T>(x);
    }
    
    public static <T> q<T> a(final T t, final c c) {
        return new q<T>(t, c);
    }
    
    public boolean a() {
        return this.c == null;
    }
}
