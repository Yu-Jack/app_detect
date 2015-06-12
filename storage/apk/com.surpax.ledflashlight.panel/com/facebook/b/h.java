// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.File;

final class h implements Comparable
{
    private final File a;
    private final long b;
    
    h(final File a) {
        this.a = a;
        this.b = a.lastModified();
    }
    
    private int a(final h h) {
        if (this.b < h.b) {
            return -1;
        }
        if (this.b > h.b) {
            return 1;
        }
        return this.a.compareTo(h.a);
    }
    
    final File a() {
        return this.a;
    }
    
    final long b() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof h && this.a((h)o) == 0;
    }
    
    @Override
    public final int hashCode() {
        return 37 * (1073 + this.a.hashCode()) + (int)(this.b % 2147483647L);
    }
}
