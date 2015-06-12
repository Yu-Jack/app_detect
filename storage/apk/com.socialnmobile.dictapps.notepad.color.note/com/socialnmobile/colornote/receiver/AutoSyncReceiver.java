// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.receiver;

import com.socialnmobile.colornote.service.AutoSyncService;
import com.socialnmobile.colornote.service.SDBackupService;
import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.app.AlarmManager;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.ColorNote;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import java.util.Random;
import android.content.BroadcastReceiver;

public class AutoSyncReceiver extends BroadcastReceiver
{
    private static final Random a;
    
    static {
        a = new Random(System.currentTimeMillis());
    }
    
    private static long a(final long n, final long n2) {
        if (n2 > n) {
            return n2;
        }
        return 9000000L + gw.b(n) + AutoSyncReceiver.a.nextInt(9000000);
    }
    
    public static void a(final Context context) {
        a(context, false);
    }
    
    private static void a(final Context context, final boolean b) {
        long n = 86400000L;
        final PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent("note.socialnmobile.intent.action.AUTO_SYNC"), 134217728);
        final long currentTimeMillis = System.currentTimeMillis();
        final long a = jp.a(context, "PREF_RESERVED_AUTO_SYNC_TIME");
        long lng;
        long n2;
        if (!rt.a(context) || !jp.m(context)) {
            lng = a(currentTimeMillis, a);
            new StringBuilder("schedule normal auto sync : ").append(ColorNote.a(lng)).toString();
            ColorNote.c();
            n2 = n;
        }
        else {
            if (AuthRequired.class.getSimpleName().equals(jp.a(context, "SYNC_ERROR_EXCEPTION_NAME", ""))) {
                lng = a(currentTimeMillis, a);
            }
            else {
                long n3 = currentTimeMillis + 21600000L;
                if (a > currentTimeMillis && a <= n3) {
                    n3 = a;
                }
                lng = n3;
                n = 21600000L;
            }
            new StringBuilder("schedule error auto sync : ").append(ColorNote.a(lng)).toString();
            n2 = n;
            ColorNote.c();
        }
        if (lng < currentTimeMillis) {
            new StringBuilder("AutoSync Schedule Error : ").append(lng).append(" < ").append(currentTimeMillis).toString();
            ColorNote.c();
            return;
        }
        if (lng != a || b) {
            ColorNote.c();
            try {
                final go a2 = go.a();
                final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
                alarmManager.cancel(broadcast);
                alarmManager.setInexactRepeating(0, lng, n2, broadcast);
                a2.b();
                final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putLong("PREF_RESERVED_AUTO_SYNC_TIME", lng);
                edit.commit();
                return;
            }
            catch (SecurityException ex) {
                adl.a.a(context, ex, "GALAXY LOLLIPOP ALARM AUTOSYNC");
                return;
            }
        }
        ColorNote.c();
    }
    
    public static void b(final Context context) {
        a(context, true);
    }
    
    public void onReceive(final Context context, final Intent intent) {
        if ("note.socialnmobile.intent.action.AUTO_SYNC".equals(intent.getAction())) {
            ColorNote.c();
            if (!rt.a(context)) {
                SDBackupService.a(context);
                return;
            }
            AutoSyncService.a(context);
        }
    }
}
