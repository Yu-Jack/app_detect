// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import com.google.android.gms.internal.gw;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public final class g extends e
{
    private WeakReference<a> d;
    
    @Override
    protected void a(final Drawable drawable, final boolean b, final boolean b2, final boolean b3) {
        if (!b2) {
            final a a = this.d.get();
            if (a != null) {
                a.a(this.a.a, drawable, b3);
            }
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof g)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final g g = (g)o;
        final a a = this.d.get();
        final a a2 = g.d.get();
        return a2 != null && a != null && gw.a(a2, a) && gw.a(g.a, this.a);
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.a });
    }
}
