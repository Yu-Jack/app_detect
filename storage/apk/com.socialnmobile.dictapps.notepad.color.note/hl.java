import android.content.ServiceConnection;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Handler;
import android.os.IBinder;
import android.content.ComponentName;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;

public final class hl implements Runnable
{
    final /* synthetic */ BackupLocal$SyncListener a;
    
    public hl(final BackupLocal$SyncListener a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        BackupLocal$SyncListener.access$0(this.a).unbindService((ServiceConnection)this.a);
    }
}
