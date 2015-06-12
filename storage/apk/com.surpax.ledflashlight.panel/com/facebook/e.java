// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.b.aj;
import java.io.Serializable;

final class e implements Serializable
{
    private final String a;
    private final String b;
    
    e(final bc bc) {
        this(bc.d(), bc.c());
    }
    
    e(String a, final String b) {
        if (aj.a(a)) {
            a = null;
        }
        this.a = a;
        this.b = b;
    }
    
    final String a() {
        return this.a;
    }
    
    final String b() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof e) {
            final e e = (e)o;
            if (aj.a(e.a, (Object)this.a) && aj.a(e.b, (Object)this.b)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        int hashCode;
        if (this.a == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.a.hashCode();
        }
        final String b = this.b;
        int hashCode2 = 0;
        if (b != null) {
            hashCode2 = this.b.hashCode();
        }
        return hashCode ^ hashCode2;
    }
}
