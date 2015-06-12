// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.net.URI;
import android.content.Context;

public final class q
{
    private Context a;
    private URI b;
    private r c;
    private boolean d;
    private Object e;
    
    public q(final Context a, final URI b) {
        al.a(b, "imageUrl");
        this.a = a;
        this.b = b;
    }
    
    public final p a() {
        return new p(this, (byte)0);
    }
    
    public final q a(final r c) {
        this.c = c;
        return this;
    }
    
    public final q a(final Object e) {
        this.e = e;
        return this;
    }
    
    public final q a(final boolean d) {
        this.d = d;
        return this;
    }
}
