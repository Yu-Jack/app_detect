// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.util.Map;

final class k implements Entry
{
    private final String a;
    private final Object b;
    
    k(final String a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object getValue() {
        return this.b;
    }
    
    @Override
    public final Object setValue(final Object o) {
        throw new UnsupportedOperationException("JSONObjectEntry is immutable");
    }
}
