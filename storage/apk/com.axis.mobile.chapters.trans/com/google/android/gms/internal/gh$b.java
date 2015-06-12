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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;

class gh$b implements GoogleApiClient$OnConnectionFailedListener
{
    final /* synthetic */ gh Cc;
    
    private gh$b(final gh cc) {
        this.Cc = cc;
    }
    
    @Override
    public void onConnectionFailed(final ConnectionResult connectionResult) {
        this.Cc.ei();
    }
}
