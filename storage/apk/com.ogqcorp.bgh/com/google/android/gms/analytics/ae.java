// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.ef;
import java.util.List;
import java.util.Map;
import com.google.android.gms.internal.ey;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.ez;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

final class ae implements ServiceConnection
{
    final /* synthetic */ ad a;
    
    ae(final ad a) {
        this.a = a;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder obj) {
        p.c("service connected, binder: " + obj);
        try {
            if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(obj.getInterfaceDescriptor())) {
                p.c("bound to service");
                this.a.e = ez.a(obj);
                this.a.g();
                return;
            }
        }
        catch (RemoteException ex) {}
        this.a.d.unbindService((ServiceConnection)this);
        this.a.a = null;
        this.a.c.a(2, null);
    }
    
    public void onServiceDisconnected(final ComponentName obj) {
        p.c("service disconnected: " + obj);
        this.a.a = null;
        this.a.b.e();
    }
}
