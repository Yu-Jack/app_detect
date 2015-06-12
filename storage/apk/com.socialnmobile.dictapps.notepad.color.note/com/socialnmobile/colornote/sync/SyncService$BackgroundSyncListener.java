// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.app.Service;
import com.socialnmobile.colornote.service.AutoSyncService;
import com.socialnmobile.colornote.service.SDBackupService;
import com.socialnmobile.colornote.receiver.AutoSyncReceiver;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import com.socialnmobile.colornote.activity.SyncRelogin;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import android.content.Context;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;

public class SyncService$BackgroundSyncListener implements SyncJob$Listener
{
    private final boolean authNotification;
    private boolean autoBackUp;
    public Context context;
    
    public SyncService$BackgroundSyncListener(final Context context, final boolean authNotification, final boolean autoBackUp) {
        this.context = context;
        this.authNotification = authNotification;
        this.autoBackUp = autoBackUp;
    }
    
    @Override
    public void onError(final AuthRequired authRequired) {
        final Intent intent = new Intent(this.context, (Class)SyncRelogin.class);
        intent.putExtra("EXTRA_PROCEED", 1);
        intent.setFlags(268435456);
        if (this.authNotification) {
            final PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, 1073741824);
            final Notification notification = new Notification(17301624, (CharSequence)null, System.currentTimeMillis());
            notification.setLatestEventInfo(this.context, (CharSequence)this.context.getString(2131230728), (CharSequence)this.context.getString(2131231009), activity);
            ((NotificationManager)this.context.getSystemService("notification")).notify(21, notification);
            return;
        }
        this.context.startActivity(intent);
    }
    
    @Override
    public void onError(final UnsupportedClientVersion unsupportedClientVersion) {
    }
    
    @Override
    public void onException(final Exception ex) {
        ColorNote.a("sync background error : " + ex.getMessage());
        if (this.autoBackUp) {
            new StringBuilder("Auto sync exception :").append(ex.getMessage()).toString();
            ColorNote.c();
        }
    }
    
    @Override
    public void onFinalize() {
        AutoSyncReceiver.a(this.context);
        if (this.autoBackUp) {
            SDBackupService.a(this.context);
        }
        else {
            gw.b();
        }
        if (this.context instanceof AutoSyncService) {
            ((Service)this.context).stopSelf();
        }
    }
    
    @Override
    public void onFinished(final Object o) {
        if (this.autoBackUp) {
            final Context context = this.context;
            final long currentTimeMillis = System.currentTimeMillis();
            final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("PREF_LAST_AUTO_SYNC_TIME", currentTimeMillis);
            edit.commit();
            ColorNote.c();
        }
    }
    
    @Override
    public void onInit() {
        gw.a(this.context);
    }
    
    @Override
    public void onProgress(final int n, final int n2) {
    }
}
