// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class TestReciever extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        Log.i("AppsFlyer_1.5.2", "test dummy receiver - in onReceive");
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
