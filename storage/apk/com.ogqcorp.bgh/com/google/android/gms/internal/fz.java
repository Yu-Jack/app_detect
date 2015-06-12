// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.g;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.c;
import com.google.android.gms.internal.fy$com.google.android.gms.internal.gf;
import java.util.ArrayList;
import android.content.Context;
import com.google.android.gms.common.b;
import android.util.Log;
import android.app.PendingIntent;
import com.google.android.gms.common.a;
import android.os.IInterface;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class fz extends Handler
{
    final /* synthetic */ fy a;
    
    public fz(final fy a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (message.what == 1 && !this.a.h()) {
            final gb gb = (gb)message.obj;
            gb.a();
            gb.c();
            return;
        }
        if (message.what == 3) {
            this.a.k.a(new a((int)message.obj, null));
            return;
        }
        if (message.what == 4) {
            this.a.a(1);
            this.a.f = null;
            this.a.k.a((int)message.obj);
            return;
        }
        if (message.what == 2 && !this.a.g()) {
            final gb gb2 = (gb)message.obj;
            gb2.a();
            gb2.c();
            return;
        }
        if (message.what == 2 || message.what == 1) {
            ((gb)message.obj).b();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
}
