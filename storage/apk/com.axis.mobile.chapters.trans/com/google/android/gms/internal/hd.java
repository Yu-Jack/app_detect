// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Message;
import android.content.ServiceConnection;
import android.content.Intent;
import android.os.Handler;
import android.content.Context;
import java.util.HashMap;
import android.os.Handler$Callback;

public final class hd implements Handler$Callback
{
    private static final Object Gv;
    private static hd Gw;
    private final HashMap Gx;
    private final Context lz;
    private final Handler mHandler;
    
    static {
        Gv = new Object();
    }
    
    private hd(final Context context) {
        this.mHandler = new Handler(context.getMainLooper(), (Handler$Callback)this);
        this.Gx = new HashMap();
        this.lz = context.getApplicationContext();
    }
    
    public static hd E(final Context context) {
        synchronized (hd.Gv) {
            if (hd.Gw == null) {
                hd.Gw = new hd(context.getApplicationContext());
            }
            return hd.Gw;
        }
    }
    
    public boolean a(final String str, final hb$f hb$f) {
        while (true) {
            while (true) {
                hd$a value;
                synchronized (this.Gx) {
                    value = this.Gx.get(str);
                    if (value == null) {
                        value = new hd$a(this, str);
                        value.a(hb$f);
                        value.B(this.lz.bindService(new Intent(str).setPackage("com.google.android.gms"), (ServiceConnection)value.fx(), 129));
                        this.Gx.put(str, value);
                        return value.isBound();
                    }
                    this.mHandler.removeMessages(0, (Object)value);
                    if (value.c(hb$f)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                    }
                }
                value.a(hb$f);
                switch (value.getState()) {
                    case 1: {
                        hb$f.onServiceConnected(value.getComponentName(), value.getBinder());
                        continue;
                    }
                    case 2: {
                        value.B(this.lz.bindService(new Intent(str).setPackage("com.google.android.gms"), (ServiceConnection)value.fx(), 129));
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    public void b(final String str, final hb$f hb$f) {
        final hd$a hd$a;
        synchronized (this.Gx) {
            hd$a = this.Gx.get(str);
            if (hd$a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            }
        }
        if (!hd$a.c(hb$f)) {
            throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
        }
        hd$a.b(hb$f);
        if (hd$a.fz()) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, (Object)hd$a), 5000L);
        }
    }
    // monitorexit(hashMap)
    
    public boolean handleMessage(final Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: {
                final hd$a hd$a = (hd$a)message.obj;
                synchronized (this.Gx) {
                    if (hd$a.fz()) {
                        this.lz.unbindService((ServiceConnection)hd$a.fx());
                        this.Gx.remove(hd$a.fy());
                    }
                    return true;
                }
                break;
            }
        }
    }
}
