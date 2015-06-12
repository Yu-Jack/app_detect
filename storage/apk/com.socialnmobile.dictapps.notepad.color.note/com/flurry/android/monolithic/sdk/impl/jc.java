// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.monolithic.sdk.impl;

import java.util.Iterator;
import java.util.Collection;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import android.content.BroadcastReceiver;

public class jc extends BroadcastReceiver
{
    private static jc d;
    boolean a;
    private List b;
    private boolean c;
    
    public jc() {
        this.c = false;
        this.b = new LinkedList();
    }
    
    public static jc a() {
        synchronized (jc.class) {
            if (jc.d == null) {
                jc.d = new jc();
            }
            return jc.d;
        }
    }
    
    private boolean a(final Context context) {
        if (!this.c || context == null) {
            return true;
        }
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    
    public final void a(final gk referent) {
        // monitorenter(this)
        if (referent != null) {
            try {
                this.b.add(new WeakReference<gk>(referent));
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    // monitorexit(this)
    
    public final void b() {
        synchronized (this) {
            final Context b = fq.a.b;
            this.c = (b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
            this.a = this.a(b);
            if (this.c) {
                final Context b2 = fq.a.b;
                this.a = this.a(b2);
                b2.registerReceiver((BroadcastReceiver)this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
    }
    
    public final boolean c() {
        return this.a;
    }
    
    public void onReceive(final Context context, final Intent intent) {
        final boolean a = this.a(context);
        if (this.a != a) {
            this.a = a;
            final Iterator<WeakReference<gk>> iterator = new LinkedList<WeakReference<gk>>(this.b).iterator();
            while (iterator.hasNext()) {
                final gk gk = iterator.next().get();
                if (gk != null) {
                    gk.a(this.a);
                }
            }
        }
    }
}
