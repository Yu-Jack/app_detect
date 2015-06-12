// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.ActivityNotFoundException;
import android.support.v4.content.e;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.b.ae;
import android.util.Log;
import java.util.Iterator;
import com.facebook.c.h;
import java.util.Map;
import com.facebook.c.c;
import com.facebook.c.b;
import android.os.Looper;
import java.util.ArrayList;
import com.facebook.b.al;
import com.facebook.b.aj;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import android.content.Context;
import java.io.Serializable;
import android.os.RemoteException;
import android.os.Message;
import android.os.Bundle;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Intent;
import java.util.Date;
import com.facebook.b.w;
import android.os.Handler;
import android.os.Messenger;
import android.content.ServiceConnection;

final class bk implements ServiceConnection
{
    final Messenger a;
    Messenger b;
    final /* synthetic */ bc c;
    
    bk(final bc c) {
        this.c = c;
        this.a = new Messenger((Handler)new bl(c, this));
        this.b = null;
    }
    
    private void b() {
        if (this.c.r == this) {
            bc.c(this.c);
        }
    }
    
    public final void a() {
        final Intent a = w.a(bc.g());
        if (a != null && bc.d.bindService(a, (ServiceConnection)this, 1)) {
            this.c.a(new Date());
            return;
        }
        this.b();
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.b = new Messenger(binder);
        final Bundle data = new Bundle();
        data.putString("access_token", this.c.i().a());
        final Message obtain = Message.obtain();
        obtain.setData(data);
        obtain.replyTo = this.a;
        try {
            this.b.send(obtain);
        }
        catch (RemoteException ex) {
            this.b();
        }
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        this.b();
        bc.d.unbindService((ServiceConnection)this);
    }
}
