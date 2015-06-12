// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import android.os.IBinder;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Looper;
import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.api.a$d;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast$Listener;
import com.google.android.gms.cast.Cast$MessageReceivedCallback;

class gh$1$4 implements Runnable
{
    final /* synthetic */ gh$1 Ce;
    final /* synthetic */ String Ch;
    final /* synthetic */ String zU;
    
    gh$1$4(final gh$1 ce, final String zu, final String ch) {
        this.Ce = ce;
        this.zU = zu;
        this.Ch = ch;
    }
    
    @Override
    public void run() {
        synchronized (this.Ce.Cc.BK) {
            final Cast$MessageReceivedCallback cast$MessageReceivedCallback = this.Ce.Cc.BK.get(this.zU);
            // monitorexit(gh.f(this.Ce.Cc))
            if (cast$MessageReceivedCallback != null) {
                cast$MessageReceivedCallback.onMessageReceived(this.Ce.Cc.BI, this.zU, this.Ch);
                return;
            }
        }
        gh.BG.b("Discarded message for unknown namespace '%s'", this.zU);
    }
}
