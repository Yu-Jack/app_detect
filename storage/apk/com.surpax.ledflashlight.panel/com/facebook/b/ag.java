// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.content.IntentFilter;
import android.support.v4.content.e;
import com.facebook.bj;
import com.facebook.bc;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class ag extends BroadcastReceiver
{
    final /* synthetic */ af a;
    
    private ag(final af a) {
        this.a = a;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(intent.getAction())) {
            final bc f = bc.f();
            if (f != null) {
                f.a(this.a.b);
            }
        }
    }
}
