// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class CampaignTrackingReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || stringExtra == null) {
            return;
        }
        final Intent intent2 = new Intent(context, (Class)CampaignTrackingService.class);
        intent2.putExtra("referrer", stringExtra);
        context.startService(intent2);
    }
}
