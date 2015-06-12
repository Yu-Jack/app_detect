// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.a;
import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.common.d;
import com.google.android.gms.common.c;

public final class dh extends df implements c, d
{
    private final de a;
    private final di b;
    private final Object c;
    
    public dh(final Context context, final cx cx, final de a) {
        super(cx, a);
        this.c = new Object();
        this.a = a;
        (this.b = new di(context, this, this, cx.k.d)).f();
    }
    
    @Override
    public void a(final Bundle bundle) {
        this.e();
    }
    
    @Override
    public void a(final a a) {
        this.a.a(new cz(0));
    }
    
    @Override
    public void a_() {
        en.a("Disconnected from remote ad request service.");
    }
    
    @Override
    public void c() {
        synchronized (this.c) {
            if (this.b.g() || this.b.h()) {
                this.b.i();
            }
        }
    }
    
    @Override
    public dm d() {
        synchronized (this.c) {
            try {
                return this.b.c();
            }
            catch (IllegalStateException ex) {
                return null;
            }
        }
    }
}
