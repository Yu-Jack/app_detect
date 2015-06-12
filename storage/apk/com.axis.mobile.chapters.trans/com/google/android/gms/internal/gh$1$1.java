// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.Cast$MessageReceivedCallback;
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

class gh$1$1 implements Runnable
{
    final /* synthetic */ int Cd;
    final /* synthetic */ gh$1 Ce;
    
    gh$1$1(final gh$1 ce, final int cd) {
        this.Ce = ce;
        this.Cd = cd;
    }
    
    @Override
    public void run() {
        if (this.Ce.Cc.Ae != null) {
            this.Ce.Cc.Ae.onApplicationDisconnected(this.Cd);
        }
    }
}
