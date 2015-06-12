// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.a;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Collection;
import android.content.Context;
import com.google.android.gms.common.d;
import java.util.ArrayList;
import android.util.Log;
import com.google.android.gms.common.api.c;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class gk extends Handler
{
    final /* synthetic */ gj a;
    
    public gk(final gj a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    public void handleMessage(final Message message) {
        if (message.what == 1) {
            synchronized (this.a.c) {
                if (this.a.b.n() && this.a.b.g() && this.a.c.contains(message.obj)) {
                    ((c)message.obj).a(this.a.b.l());
                }
                return;
            }
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    }
}
