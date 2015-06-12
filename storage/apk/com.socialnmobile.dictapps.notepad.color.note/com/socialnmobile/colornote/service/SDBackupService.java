// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.service;

import com.socialnmobile.colornote.ColorNote;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import android.app.Service;

public class SDBackupService extends Service
{
    public static void a(final Context context) {
        boolean b;
        if (System.currentTimeMillis() - jp.a(context, "PREF_LAST_AUTO_SDBACKUP_TIME") < 64800000L) {
            b = false;
        }
        else {
            b = true;
        }
        if (b && jp.a(context, "pref_enable_auto_backup", context.getResources().getBoolean(2131296266))) {
            gw.a(context);
            context.startService(new Intent(context, (Class)SDBackupService.class));
            return;
        }
        gw.b();
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public void onCreate() {
        super.onCreate();
        gw.a((Context)this);
    }
    
    public void onDestroy() {
        super.onDestroy();
        ColorNote.c();
        gw.b();
    }
    
    public void onStart(final Intent intent, final int n) {
        super.onStart(intent, n);
        ColorNote.c();
        new rr(this).execute((Object[])new String[0]);
    }
}
