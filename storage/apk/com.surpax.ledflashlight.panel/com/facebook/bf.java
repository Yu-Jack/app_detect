// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.Context;

public final class bf
{
    private final Context a;
    private String b;
    private bs c;
    
    public bf(final Context a) {
        this.a = a;
    }
    
    public final bc a() {
        return new bc(this.a, this.b, this.c);
    }
    
    public final bf a(final String b) {
        this.b = b;
        return this;
    }
}
