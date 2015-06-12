// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Set;
import java.util.Date;
import com.google.android.gms.ads.c.a;

public final class bk implements a
{
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final int e;
    
    public bk(final Date a, final int b, final Set<String> c, final boolean d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public Date a() {
        return this.a;
    }
    
    @Override
    public int b() {
        return this.b;
    }
    
    @Override
    public Set<String> c() {
        return this.c;
    }
    
    @Override
    public boolean d() {
        return this.d;
    }
}
