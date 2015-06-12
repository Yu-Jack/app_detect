// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.net.URI;
import android.content.Context;

public final class p
{
    private Context a;
    private URI b;
    private r c;
    private boolean d;
    private Object e;
    
    private p(final q q) {
        this.a = q.a;
        this.b = q.b;
        this.c = q.c;
        this.d = q.d;
        Object e;
        if (q.e == null) {
            e = new Object();
        }
        else {
            e = q.e;
        }
        this.e = e;
    }
    
    public final Context a() {
        return this.a;
    }
    
    public final URI b() {
        return this.b;
    }
    
    public final r c() {
        return this.c;
    }
    
    public final boolean d() {
        return this.d;
    }
    
    public final Object e() {
        return this.e;
    }
}
