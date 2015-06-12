// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.ads;

import java.util.Date;
import android.os.Bundle;
import com.google.android.gms.internal.aa;

public final class c
{
    private final aa a;
    
    public c() {
        this.a = new aa();
    }
    
    public b a() {
        return new b(this, null);
    }
    
    public c a(final int n) {
        this.a.a(n);
        return this;
    }
    
    public c a(final Class<? extends com.google.android.gms.ads.c.b> clazz, final Bundle bundle) {
        this.a.a(clazz, bundle);
        return this;
    }
    
    public c a(final String s) {
        this.a.a(s);
        return this;
    }
    
    public c a(final Date date) {
        this.a.a(date);
        return this;
    }
    
    public c a(final boolean b) {
        this.a.a(b);
        return this;
    }
    
    public c b(final String s) {
        this.a.b(s);
        return this;
    }
}
