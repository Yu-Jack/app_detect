// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.HashSet;
import android.os.Message;
import android.content.Intent;
import android.os.Handler;
import android.content.Context;
import android.os.Handler$Callback;
import java.util.HashMap;
import java.util.Iterator;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.ServiceConnection;

public class hd$a$a implements ServiceConnection
{
    final /* synthetic */ hd$a GF;
    
    public hd$a$a(final hd$a gf) {
        this.GF = gf;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        synchronized (this.GF.GE.Gx) {
            this.GF.GC = binder;
            this.GF.GD = componentName;
            final Iterator<hb$f> iterator = this.GF.GA.iterator();
            while (iterator.hasNext()) {
                iterator.next().onServiceConnected(componentName, binder);
            }
        }
        this.GF.mState = 1;
    }
    // monitorexit(hashMap)
    
    public void onServiceDisconnected(final ComponentName componentName) {
        synchronized (this.GF.GE.Gx) {
            this.GF.GC = null;
            this.GF.GD = componentName;
            final Iterator<hb$f> iterator = this.GF.GA.iterator();
            while (iterator.hasNext()) {
                iterator.next().onServiceDisconnected(componentName);
            }
        }
        this.GF.mState = 2;
    }
    // monitorexit(hashMap)
}
