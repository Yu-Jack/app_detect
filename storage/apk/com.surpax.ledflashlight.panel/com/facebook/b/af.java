// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.content.IntentFilter;
import android.content.Context;
import android.support.v4.content.e;
import android.content.BroadcastReceiver;
import com.facebook.bj;
import com.facebook.bc;

public final class af
{
    private bc a;
    private final bj b;
    private final BroadcastReceiver c;
    private final e d;
    private boolean e;
    
    public af(final Context context, final bj bj) {
        this.e = false;
        this.b = new ah(this, bj);
        this.a = null;
        this.c = new ag(this, (byte)0);
        this.d = android.support.v4.content.e.a(context);
    }
    
    private void g() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.d.a(this.c, intentFilter);
    }
    
    public final bc a() {
        if (this.a == null) {
            return bc.f();
        }
        return this.a;
    }
    
    public final bc b() {
        final bc a = this.a();
        if (a != null && a.a()) {
            return a;
        }
        return null;
    }
    
    public final void c() {
        if (this.a != null) {
            this.a.b(this.b);
            this.a = null;
            this.g();
            if (this.a() != null) {
                this.a().a(this.b);
            }
        }
    }
    
    public final void d() {
        if (this.e) {
            return;
        }
        if (this.a == null) {
            this.g();
        }
        if (this.a() != null) {
            this.a().a(this.b);
        }
        this.e = true;
    }
    
    public final void e() {
        if (!this.e) {
            return;
        }
        final bc a = this.a();
        if (a != null) {
            a.b(this.b);
        }
        this.d.a(this.c);
        this.e = false;
    }
    
    public final boolean f() {
        return this.e;
    }
}
