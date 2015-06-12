// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.content.IntentFilter;
import android.content.Context;
import android.support.v4.content.e;
import android.content.BroadcastReceiver;
import com.facebook.bo;
import com.facebook.bc;
import com.facebook.bj;

final class ah implements bj
{
    final /* synthetic */ af a;
    private final bj b;
    
    public ah(final af a, final bj b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final bc bc, final bo bo, final Exception ex) {
        if (this.b != null && this.a.f()) {
            this.b.a(bc, bo, ex);
        }
        if (bc == this.a.a && bo.b()) {
            this.a.c();
        }
    }
}
