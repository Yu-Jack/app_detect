// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.service;

import android.content.ServiceConnection;
import com.socialnmobile.colornote.sync.SyncService$BackgroundSyncConnection;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.ColorNote;
import android.os.IBinder;
import android.content.Intent;
import android.content.Context;
import android.app.Service;

public class AutoSyncService extends Service
{
    public static void a(final Context context) {
        final long a = jp.a(context, "PREF_LAST_AUTO_SYNC_TIME");
        final long currentTimeMillis = System.currentTimeMillis();
        final long n = lcmp(currentTimeMillis - a, 64800000L);
        int n2 = 0;
        Label_0028: {
            if (n >= 0) {
                if (!rt.d(context)) {
                    final long n3 = (currentTimeMillis - jp.a(context, "LAST_SYNC_CHECKOUT_TIME_MILLIS")) / 86400000L;
                    final long n4 = (currentTimeMillis - jp.a(context, "LAST_SYNC_TIME_MILLIS")) / 86400000L;
                    if (n3 > 50L) {
                        final long n5 = lcmp(n4, 6L);
                        n2 = 0;
                        if (n5 < 0) {
                            break Label_0028;
                        }
                    }
                    if (n3 > 30L) {
                        final long n6 = lcmp(n4, 4L);
                        n2 = 0;
                        if (n6 < 0) {
                            break Label_0028;
                        }
                    }
                    if (n3 > 10L) {
                        final long n7 = lcmp(n4, 2L);
                        n2 = 0;
                        if (n7 < 0) {
                            break Label_0028;
                        }
                    }
                }
                n2 = 1;
            }
        }
        if (n2 != 0) {
            gw.a(context);
            final Intent intent = new Intent(context, (Class)AutoSyncService.class);
            intent.putExtra("START_PARAM", 1);
            context.startService(intent);
            return;
        }
        gw.b();
    }
    
    public static void b(final Context context) {
        final Intent intent = new Intent(context, (Class)AutoSyncService.class);
        intent.putExtra("START_PARAM", 2);
        context.startService(intent);
    }
    
    public IBinder onBind(final Intent intent) {
        return null;
    }
    
    public void onCreate() {
        super.onCreate();
        gw.a((Context)this);
    }
    
    public void onDestroy() {
        ColorNote.c();
        super.onDestroy();
    }
    
    public void onStart(final Intent intent, final int n) {
        super.onStart(intent, n);
        ColorNote.c();
        if (intent == null) {
            ColorNote.a("AutoSyncService intent error");
            gw.b();
            this.stopSelf();
        }
        else {
            final int intExtra = intent.getIntExtra("START_PARAM", 1);
            final Intent intent2 = new Intent((Context)this, (Class)SyncService.class);
            Object o;
            if (intExtra == 1) {
                o = new SyncService$BackgroundSyncConnection((Context)this, true, true);
            }
            else if (intExtra == 2) {
                o = new SyncService$BackgroundSyncConnection((Context)this, false, false);
            }
            else {
                o = null;
                if (intExtra == 3) {
                    o = new SyncService$BackgroundSyncConnection((Context)this, false, false);
                }
            }
            if (!this.bindService(intent2, (ServiceConnection)o, 1)) {
                ColorNote.a("AutoSync on exit bind SyncService FAILED");
            }
        }
    }
}
