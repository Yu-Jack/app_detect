// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.a$d;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks;
import android.os.Looper;
import android.content.Context;

public final class ga extends hb
{
    private final String yQ;
    
    public ga(final Context context, final Looper looper, final GoogleApiClient$ConnectionCallbacks googleApiClient$ConnectionCallbacks, final GoogleApiClient$OnConnectionFailedListener googleApiClient$OnConnectionFailedListener, final String s, final String[] array) {
        super(context, looper, googleApiClient$ConnectionCallbacks, googleApiClient$OnConnectionFailedListener, array);
        this.yQ = (String)hm.f(s);
    }
    
    protected gc D(final IBinder binder) {
        return gc$a.F(binder);
    }
    
    public void a(final a$d a$d) {
        try {
            ((gc)this.ft()).a(new ga$c(a$d));
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
        }
    }
    
    public void a(final a$d a$d, final int n) {
        try {
            ((gc)this.ft()).b(new ga$a(a$d), n);
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
        }
    }
    
    public void a(final a$d a$d, final int n, final String s, final byte[] array) {
        try {
            ((gc)this.ft()).a(new ga$e(a$d), n, s, array);
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
        }
    }
    
    public void a(final a$d a$d, final int n, final byte[] array) {
        Label_0024: {
            if (a$d != null) {
                break Label_0024;
            }
            gb gb = null;
            try {
                while (true) {
                    ((gc)this.ft()).a(gb, n, array);
                    return;
                    gb = new ga$e(a$d);
                    continue;
                }
            }
            catch (RemoteException ex) {
                Log.w("AppStateClient", "service died");
            }
        }
    }
    
    @Override
    protected void a(final hi hi, final hb$e hb$e) {
        hi.a(hb$e, 5089000, this.getContext().getPackageName(), this.yQ, this.fs());
    }
    
    public void b(final a$d a$d) {
        try {
            ((gc)this.ft()).b(new ga$g(a$d));
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
        }
    }
    
    public void b(final a$d a$d, final int n) {
        try {
            ((gc)this.ft()).a(new ga$e(a$d), n);
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
        }
    }
    
    @Override
    protected void b(final String... array) {
        int i = 0;
        boolean b = false;
        while (i < array.length) {
            if (array[i].equals("https://www.googleapis.com/auth/appstate")) {
                b = true;
            }
            ++i;
        }
        hm.a(b, (Object)String.format("App State APIs requires %s to function.", "https://www.googleapis.com/auth/appstate"));
    }
    
    @Override
    protected String bu() {
        return "com.google.android.gms.appstate.service.START";
    }
    
    @Override
    protected String bv() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }
    
    public int dU() {
        try {
            return ((gc)this.ft()).dU();
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
    
    public int dV() {
        try {
            return ((gc)this.ft()).dV();
        }
        catch (RemoteException ex) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
