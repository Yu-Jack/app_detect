// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

import com.flurry.sdk.cy;
import com.flurry.sdk.fe;
import com.flurry.sdk.eo;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class InstallReceiver extends BroadcastReceiver
{
    static final String a;
    
    static {
        a = InstallReceiver.class.getSimpleName();
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        eo.a(4, InstallReceiver.a, "Received an Install nofication of " + intent.getAction());
        String str = intent.getExtras().getString("referrer");
        eo.a(4, InstallReceiver.a, "Received an Install referrer of " + str);
        if (str == null || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            eo.a(5, InstallReceiver.a, "referrer is null");
            return;
        }
        if (!str.contains("=")) {
            eo.a(4, InstallReceiver.a, "referrer is before decoding: " + str);
            str = fe.c(str);
            eo.a(4, InstallReceiver.a, "referrer is: " + str);
        }
        new cy(context).a(str);
    }
}
