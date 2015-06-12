// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class hk$a
{
    private final List GJ;
    private final Object GK;
    
    private hk$a(final Object o) {
        this.GK = hm.f(o);
        this.GJ = new ArrayList();
    }
    
    public hk$a a(final String s, final Object obj) {
        this.GJ.add((String)hm.f(s) + "=" + String.valueOf(obj));
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder(100).append(this.GK.getClass().getSimpleName()).append('{');
        for (int size = this.GJ.size(), i = 0; i < size; ++i) {
            append.append((String)this.GJ.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
