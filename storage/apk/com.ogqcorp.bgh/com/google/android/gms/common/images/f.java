// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import com.google.android.gms.internal.gw;
import android.net.Uri;

final class f
{
    public final Uri a;
    
    public f(final Uri a) {
        this.a = a;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof f && (this == o || gw.a(((f)o).a, this.a));
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.a });
    }
}
