// 
// Decompiled by Procyon v0.5.29
// 

package com.plugin.gcm;

import android.content.Context;
import com.google.android.gcm.GCMBroadcastReceiver;

public class CordovaGCMBroadcastReceiver extends GCMBroadcastReceiver
{
    @Override
    protected String getGCMIntentServiceClassName(final Context context) {
        return "com.plugin.gcm.GCMIntentService";
    }
}
