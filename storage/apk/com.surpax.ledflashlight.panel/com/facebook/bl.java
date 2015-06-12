// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.os.RemoteException;
import android.os.IBinder;
import android.content.ComponentName;
import android.os.Messenger;
import android.content.ActivityNotFoundException;
import android.content.Intent;
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
import java.util.ArrayList;
import com.facebook.b.al;
import com.facebook.b.aj;
import java.util.HashSet;
import java.util.List;
import android.os.Bundle;
import java.util.Date;
import java.util.Set;
import android.content.Context;
import java.io.Serializable;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.Looper;
import java.lang.ref.WeakReference;
import android.os.Handler;

final class bl extends Handler
{
    private WeakReference a;
    private WeakReference b;
    
    bl(final bc referent, final bk referent2) {
        super(Looper.getMainLooper());
        this.a = new WeakReference((T)referent);
        this.b = new WeakReference((T)referent2);
    }
    
    public final void handleMessage(final Message message) {
        final String string = message.getData().getString("access_token");
        final bc bc = (bc)this.a.get();
        if (bc != null && string != null) {
            bc.a(message.getData());
        }
        final bk bk = (bk)this.b.get();
        if (bk != null) {
            com.facebook.bc.d.unbindService((ServiceConnection)bk);
            bk.b();
        }
    }
}
