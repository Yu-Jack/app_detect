// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.net.NetworkInfo;
import com.facebook.ads.d;
import android.net.ConnectivityManager;
import android.os.AsyncTask$Status;
import com.facebook.ads.b;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import com.facebook.ads.e;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class n extends BroadcastReceiver
{
    final /* synthetic */ m a;
    
    private n(final m a) {
        this.a = a;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            final m a = this.a;
            intent.getAction();
            a.d();
        }
        else if ("android.intent.action.SCREEN_ON".equals(action) && this.a.p == 0) {
            final m a2 = this.a;
            intent.getAction();
            a2.a();
        }
    }
}
