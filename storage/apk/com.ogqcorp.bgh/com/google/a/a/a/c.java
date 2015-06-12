// 
// Decompiled by Procyon v0.5.29
// 

package com.google.a.a.a;

import com.google.android.gms.ads.c.e;
import com.google.android.gms.ads.c.f;
import com.google.android.gms.ads.a;

final class c extends a
{
    private final com.google.a.a.a.a a;
    private final f b;
    
    public c(final com.google.a.a.a.a a, final f b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void a() {
        this.b.a(this.a);
    }
    
    @Override
    public void a(final int n) {
        this.b.a(this.a, n);
    }
    
    @Override
    public void b() {
        this.b.b(this.a);
    }
    
    @Override
    public void c() {
        this.b.c(this.a);
    }
    
    @Override
    public void d() {
        this.b.d(this.a);
    }
}
