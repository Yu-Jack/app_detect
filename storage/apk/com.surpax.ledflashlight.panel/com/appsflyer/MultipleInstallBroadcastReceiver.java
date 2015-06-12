// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import java.util.Iterator;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        Log.i("AppsFlyer_1.5.2", "MultipleInstallBroadcastReceiver called");
        for (final ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0)) {
            final String action = intent.getAction();
            if (resolveInfo.activityInfo.packageName.equals(context.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(action) && !this.getClass().getName().equals(resolveInfo.activityInfo.name)) {
                Log.i("AppsFlyer_1.5.2", "trigger onReceive: class: " + resolveInfo.activityInfo.name);
                try {
                    ((BroadcastReceiver)Class.forName(resolveInfo.activityInfo.name).newInstance()).onReceive(context, intent);
                }
                catch (Throwable t) {
                    Log.e("AppsFlyer_1.5.2", "error in BroadcastReceiver " + resolveInfo.activityInfo.name, t);
                }
            }
        }
        new AppsFlyerLib().onReceive(context, intent);
    }
}
