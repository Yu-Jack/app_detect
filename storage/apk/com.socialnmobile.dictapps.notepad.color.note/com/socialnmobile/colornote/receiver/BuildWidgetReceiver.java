// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class BuildWidgetReceiver extends BroadcastReceiver
{
    public static void a(final Context context, final int[] array, final int n, final int n2) {
        final Intent intent = new Intent("note.socialnmobile.intent.action.BUILD_WIDGET");
        intent.setClass(context, (Class)BuildWidgetReceiver.class);
        intent.putExtra("WIDGET_IDS", array);
        intent.putExtra("WIDGET_TYPE", n);
        intent.putExtra("RETRY", n2);
        final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
        try {
            go.a().a(context, 1, 60000L + System.currentTimeMillis(), broadcast);
        }
        catch (SecurityException ex) {
            adl.a.a(context, ex, "GALAXY LOLLIPOP ALARM (BUILD WIDGET)");
        }
    }
    
    public void onReceive(final Context context, final Intent intent) {
        rq.a(context, intent.getIntArrayExtra("WIDGET_IDS"), intent.getIntExtra("WIDGET_TYPE", 1), -1 + intent.getIntExtra("RETRY", 0));
    }
}
