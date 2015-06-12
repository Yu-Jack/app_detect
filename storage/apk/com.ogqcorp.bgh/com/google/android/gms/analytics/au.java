// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.content.IntentFilter;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

class au extends BroadcastReceiver
{
    static final String a;
    private final v b;
    
    static {
        a = au.class.getName();
    }
    
    au(final v b) {
        this.b = b;
    }
    
    public static void b(final Context context) {
        final Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(au.a, true);
        context.sendBroadcast(intent);
    }
    
    public void a(final Context context) {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver((BroadcastReceiver)this, intentFilter);
        final IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver((BroadcastReceiver)this, intentFilter2);
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            final v b = this.b;
            boolean b2 = false;
            if (!booleanExtra) {
                b2 = true;
            }
            b.a(b2);
        }
        else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(au.a)) {
            this.b.b();
        }
    }
}
