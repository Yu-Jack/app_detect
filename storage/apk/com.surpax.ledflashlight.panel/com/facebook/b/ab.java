// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.os.RemoteException;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Handler;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class ab implements ServiceConnection
{
    private final Context a;
    private final Handler b;
    private ac c;
    private boolean d;
    private Messenger e;
    private int f;
    private int g;
    private final String h;
    private final int i;
    
    public ab(Context a, final String h) {
        final Context applicationContext = a.getApplicationContext();
        if (applicationContext != null) {
            a = applicationContext;
        }
        this.a = a;
        this.f = 65536;
        this.g = 65537;
        this.h = h;
        this.i = 20121101;
        this.b = new Handler() {
            public final void handleMessage(final Message message) {
                ab.this.a(message);
            }
        };
    }
    
    private void a(final Bundle bundle) {
        if (this.d) {
            this.d = false;
            final ac c = this.c;
            if (c != null) {
                c.a(bundle);
            }
        }
    }
    
    protected final void a(final Message message) {
        if (message.what == this.g) {
            final Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                this.a((Bundle)null);
            }
            else {
                this.a(data);
            }
            this.a.unbindService((ServiceConnection)this);
        }
    }
    
    public final void a(final ac c) {
        this.c = c;
    }
    
    public final boolean a() {
        if (!this.d && w.a(this.a, this.i) != -1) {
            final Intent b = w.b(this.a);
            if (b != null) {
                this.d = true;
                this.a.bindService(b, (ServiceConnection)this, 1);
                return true;
            }
        }
        return false;
    }
    
    public final void b() {
        this.d = false;
    }
    
    public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.e = new Messenger(binder);
        final Bundle data = new Bundle();
        data.putString("com.facebook.platform.extra.APPLICATION_ID", this.h);
        final Message obtain = Message.obtain((Handler)null, this.f);
        obtain.arg1 = this.i;
        obtain.setData(data);
        obtain.replyTo = new Messenger(this.b);
        try {
            this.e.send(obtain);
        }
        catch (RemoteException ex) {
            this.a((Bundle)null);
        }
    }
    
    public void onServiceDisconnected(final ComponentName componentName) {
        this.e = null;
        this.a.unbindService((ServiceConnection)this);
        this.a((Bundle)null);
    }
}
