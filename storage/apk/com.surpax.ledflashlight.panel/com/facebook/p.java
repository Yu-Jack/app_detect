// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.List;
import java.io.Serializable;

final class p implements Serializable
{
    private final transient x a;
    private final bn b;
    private final int c;
    private boolean d;
    private List e;
    private final bm f;
    private final String g;
    private final String h;
    private final String i;
    private boolean j;
    
    p(final bn b, final int c, final boolean d, final List e, final bm f, final String g, final String h, final x a, final String i) {
        this.d = false;
        this.j = false;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.a = a;
        this.i = i;
    }
    
    final x a() {
        return this.a;
    }
    
    final void a(final List e) {
        this.e = e;
    }
    
    final List b() {
        return this.e;
    }
    
    final bn c() {
        return this.b;
    }
    
    final int d() {
        return this.c;
    }
    
    final bm e() {
        return this.f;
    }
    
    final String f() {
        return this.g;
    }
    
    final boolean g() {
        return this.d;
    }
    
    final String h() {
        return this.h;
    }
    
    final boolean i() {
        return this.h != null && !this.d;
    }
    
    final String j() {
        return this.i;
    }
    
    final boolean k() {
        return this.j;
    }
}
