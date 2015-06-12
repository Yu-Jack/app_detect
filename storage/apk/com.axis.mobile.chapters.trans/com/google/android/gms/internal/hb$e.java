// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class hb$e extends hh$a
{
    private hb Gl;
    
    public hb$e(final hb gl) {
        this.Gl = gl;
    }
    
    public void b(final int n, final IBinder binder, final Bundle bundle) {
        hm.b((Object)"onPostInitComplete can be called only once per call to getServiceFromBroker", this.Gl);
        this.Gl.a(n, binder, bundle);
        this.Gl = null;
    }
}
