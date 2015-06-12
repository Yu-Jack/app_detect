// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Message;
import android.content.ServiceConnection;
import android.content.Intent;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gf;
import android.os.Handler;
import java.util.HashMap;
import android.content.Context;
import android.os.Handler$Callback;

public final class gm implements Handler$Callback
{
    private static final Object a;
    private static gm b;
    private final Context c;
    private final HashMap<String, gn> d;
    private final Handler e;
    
    static {
        a = new Object();
    }
    
    private gm(final Context context) {
        this.e = new Handler(context.getMainLooper(), (Handler$Callback)this);
        this.d = new HashMap<String, gn>();
        this.c = context.getApplicationContext();
    }
    
    public static gm a(final Context context) {
        synchronized (gm.a) {
            if (gm.b == null) {
                gm.b = new gm(context.getApplicationContext());
            }
            return gm.b;
        }
    }
    
    public boolean a(final String str, final gf gf) {
        while (true) {
            while (true) {
                gn value;
                synchronized (this.d) {
                    value = this.d.get(str);
                    if (value == null) {
                        value = new gn(this, str);
                        value.a((com.google.android.gms.internal.gf)gf);
                        value.a(this.c.bindService(new Intent(str).setPackage("com.google.android.gms"), (ServiceConnection)value.a(), 129));
                        this.d.put(str, value);
                        return value.c();
                    }
                    this.e.removeMessages(0, (Object)value);
                    if (value.c((com.google.android.gms.internal.gf)gf)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                    }
                }
                value.a((com.google.android.gms.internal.gf)gf);
                switch (value.d()) {
                    case 1: {
                        ((com.google.android.gms.internal.gf)gf).onServiceConnected(value.g(), value.f());
                        continue;
                    }
                    case 2: {
                        value.a(this.c.bindService(new Intent(str).setPackage("com.google.android.gms"), (ServiceConnection)value.a(), 129));
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
    
    public void b(final String str, final gf gf) {
        final gn gn;
        synchronized (this.d) {
            gn = this.d.get(str);
            if (gn == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            }
        }
        if (!gn.c((com.google.android.gms.internal.gf)gf)) {
            throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
        }
        gn.b((com.google.android.gms.internal.gf)gf);
        if (gn.e()) {
            this.e.sendMessageDelayed(this.e.obtainMessage(0, (Object)gn), 5000L);
        }
    }
    // monitorexit(hashMap)
    
    public boolean handleMessage(final Message message) {
        switch (message.what) {
            default: {
                return false;
            }
            case 0: {
                final gn gn = (gn)message.obj;
                synchronized (this.d) {
                    if (gn.e()) {
                        this.c.unbindService((ServiceConnection)gn.a());
                        this.d.remove(gn.b());
                    }
                    return true;
                }
                break;
            }
        }
    }
}
