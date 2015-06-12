// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.b.w;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class FacebookBroadcastReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        final String stringExtra2 = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        if (stringExtra != null && stringExtra2 != null) {
            intent.getExtras();
            w.a(intent);
        }
    }
}
