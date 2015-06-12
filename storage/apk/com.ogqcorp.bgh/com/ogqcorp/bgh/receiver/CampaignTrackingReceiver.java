// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.receiver;

import com.ogqcorp.bgh.system.d;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class CampaignTrackingReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra == null) {
            return;
        }
        d.a(stringExtra);
    }
}
