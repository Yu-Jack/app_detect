// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.net.URI;

final class o
{
    URI a;
    Object b;
    
    o(final URI a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        boolean b = false;
        if (o != null) {
            final boolean b2 = o instanceof o;
            b = false;
            if (b2) {
                final o o2 = (o)o;
                final URI a = o2.a;
                final URI a2 = this.a;
                b = false;
                if (a == a2) {
                    final Object b3 = o2.b;
                    final Object b4 = this.b;
                    b = false;
                    if (b3 == b4) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public final int hashCode() {
        return 37 * (1073 + this.a.hashCode()) + this.b.hashCode();
    }
}
