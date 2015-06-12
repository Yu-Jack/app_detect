// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import android.database.sqlite.SQLiteException;
import android.app.PendingIntent;
import com.socialnmobile.colornote.ColorNote;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class TimeChangedReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        if (context.getContentResolver() == null) {
            ColorNote.a("Alarm Init Resolver Error");
        }
        else {
            final String action = intent.getAction();
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                try {
                    final long currentTimeMillis = System.currentTimeMillis();
                    gu.a(context, currentTimeMillis, true);
                    final long b = jo.b(context, "TIME_ALARM_SCHEDULE");
                    final long b2 = jo.b(context, "TIME_ALARM_ID");
                    if (b > currentTimeMillis) {
                        gu.a(context, b2, b, gu.a(context, b2, b));
                    }
                    AutoSyncReceiver.b(context);
                    gu.a(context);
                    return;
                }
                catch (SQLiteException ex) {
                    final Intent intent2 = new Intent("note.socialnmobile.intent.action.RENEW_ALARM");
                    intent2.setClass(context, (Class)TimeChangedReceiver.class);
                    go.a().a(context, 0, 150000L + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 0, intent2, 134217728));
                    ColorNote.a("Can't schedule alarms, job delayed" + action);
                    return;
                }
            }
            Label_0225: {
                if (!action.equals("android.intent.action.TIMEZONE_CHANGED") && !action.equals("android.intent.action.DATE_CHANGED") && !action.equals("android.intent.action.TIME_SET")) {
                    if (!action.equals("android.intent.action.MEDIA_SCANNER_FINISHED")) {
                        break Label_0225;
                    }
                }
                try {
                    AutoSyncReceiver.a(context);
                    gu.a(context);
                    return;
                }
                catch (SQLiteException ex2) {
                    ColorNote.a("Can't schedule alarms" + action);
                    return;
                }
            }
            if (action.equals("note.socialnmobile.intent.action.RENEW_ALARM")) {
                try {
                    AutoSyncReceiver.a(context);
                    gu.a(context);
                }
                catch (SQLiteException ex3) {
                    ColorNote.a("Can't schedule alarms" + action);
                }
            }
        }
    }
}
