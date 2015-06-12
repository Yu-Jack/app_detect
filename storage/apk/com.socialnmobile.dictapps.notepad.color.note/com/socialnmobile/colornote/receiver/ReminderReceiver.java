// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class ReminderReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final long currentTimeMillis = System.currentTimeMillis();
        if ("note.socialnmobile.intent.action.TIME_REMINDER".equals(intent.getAction())) {
            gu.d(context, intent.getLongExtra("alarm_id", 0L));
            gu.a(context, currentTimeMillis);
            gu.c(context, currentTimeMillis);
        }
        else if ("note.socialnmobile.intent.action.DAY_REMINDER".equals(intent.getAction())) {
            gu.b(context, currentTimeMillis);
        }
    }
}
