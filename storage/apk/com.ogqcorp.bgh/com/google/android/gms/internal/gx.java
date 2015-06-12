// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class gx
{
    private final List<String> a;
    private final Object b;
    
    private gx(final Object o) {
        this.b = gz.a(o);
        this.a = new ArrayList<String>();
    }
    
    public gx a(final String s, final Object obj) {
        this.a.add(gz.a(s) + "=" + String.valueOf(obj));
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
        for (int size = this.a.size(), i = 0; i < size; ++i) {
            append.append(this.a.get(i));
            if (i < size - 1) {
                append.append(", ");
            }
        }
        return append.append('}').toString();
    }
}
