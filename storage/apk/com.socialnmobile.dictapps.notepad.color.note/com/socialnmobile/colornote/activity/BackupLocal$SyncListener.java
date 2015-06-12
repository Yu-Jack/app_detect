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
import android.content.ServiceConnection;

public class BackupLocal$SyncListener implements ServiceConnection, SyncJob$Listener
{
    final /* synthetic */ BackupLocal this$0;
    
    BackupLocal$SyncListener(final BackupLocal this$0) {
        this.this$0 = this$0;
    }
    
    public void onError(final AuthRequired authRequired) {
    }
    
    public void onError(final UnsupportedClientVersion unsupportedClientVersion) {
    }
    
    public void onException(final Exception ex) {
    }
    
    public void onFinalize() {
        new hi(this.this$0).execute((Object[])new String[0]);
        this.this$0.g = false;
    }
    
    public void onFinished(final Object o) {
    }
    
    public void onInit() {
        this.this$0.a();
    }
    
    public void onProgress(final int n, final int n2) {
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        ((wc)binder).a().a(this);
        new Handler().post((Runnable)new hl(this));
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
    }
}
