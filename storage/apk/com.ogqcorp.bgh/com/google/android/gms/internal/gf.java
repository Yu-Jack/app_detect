// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

final class gf implements ServiceConnection
{
    final /* synthetic */ fy a;
    
    gf(final fy a) {
        this.a = a;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.a.c(binder);
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.a.b.sendMessage(this.a.b.obtainMessage(4, (Object)1));
    }
}
