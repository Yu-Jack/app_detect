// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.IntentFilter;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.BroadcastReceiver;

class NetworkReceiver extends BroadcastReceiver
{
    @VisibleForTesting
    static final String SELF_IDENTIFYING_EXTRA;
    private final ServiceManager mManager;
    
    static {
        SELF_IDENTIFYING_EXTRA = NetworkReceiver.class.getName();
    }
    
    NetworkReceiver(final ServiceManager mManager) {
        this.mManager = mManager;
    }
    
    public static void sendRadioPoweredBroadcast(final Context context) {
        final Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(NetworkReceiver.SELF_IDENTIFYING_EXTRA, true);
        context.sendBroadcast(intent);
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final Bundle extras = intent.getExtras();
            Boolean b = Boolean.FALSE;
            if (extras != null) {
                b = intent.getExtras().getBoolean("noConnectivity");
            }
            this.mManager.updateConnectivityStatus(!b);
        }
        else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(NetworkReceiver.SELF_IDENTIFYING_EXTRA)) {
            this.mManager.onRadioPowered();
        }
    }
    
    public void register(final Context context) {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver((BroadcastReceiver)this, intentFilter);
        final IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver((BroadcastReceiver)this, intentFilter2);
    }
}
