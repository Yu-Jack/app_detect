// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

final class hb$f implements ServiceConnection
{
    final /* synthetic */ hb Gi;
    
    hb$f(final hb gi) {
        this.Gi = gi;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.Gi.I(binder);
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.Gi.mHandler.sendMessage(this.Gi.mHandler.obtainMessage(4, (Object)1));
    }
}
