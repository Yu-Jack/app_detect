// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import android.os.Handler;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public class SyncService$BackgroundSyncConnection extends SyncService$BackgroundSyncListener implements ServiceConnection
{
    public SyncService$BackgroundSyncConnection(final Context context, final boolean b, final boolean b2) {
        super(context, b, b2);
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        ((wc)binder).a().a(this);
        new Handler().post((Runnable)new wb(this));
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
    }
    
    public void unbind() {
        this.context.unbindService((ServiceConnection)this);
    }
}
