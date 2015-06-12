// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class InstallReferrerReceiver extends BroadcastReceiver
{
    static final String INSTALL_ACTION = "com.android.vending.INSTALL_REFERRER";
    
    public void onReceive(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || stringExtra == null) {
            return;
        }
        InstallReferrerUtil.cacheInstallReferrer(stringExtra);
        final Intent intent2 = new Intent(context, (Class)InstallReferrerService.class);
        intent2.putExtra("referrer", stringExtra);
        context.startService(intent2);
    }
}
