// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

final class ag
{
    private final int a;
    private final int b;
    
    private ag(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    final boolean a(final int n) {
        return this.a <= n && n <= this.b;
    }
}
