// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class ge extends gr
{
    private fy a;
    
    public ge(final fy a) {
        this.a = a;
    }
    
    public void a(final int n, final IBinder binder, final Bundle bundle) {
        gz.a("onPostInitComplete can be called only once per call to getServiceFromBroker", this.a);
        this.a.a(n, binder, bundle);
        this.a = null;
    }
}
