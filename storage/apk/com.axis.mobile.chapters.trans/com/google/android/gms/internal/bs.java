// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.MediationAdapter;
import java.util.Map;

public final class bs extends bt$a
{
    private Map nQ;
    
    private bu n(final String str) {
        try {
            final Class<?> forName = Class.forName(str, false, bs.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(forName)) {
                final MediationAdapter mediationAdapter = (MediationAdapter)forName.newInstance();
                return new bz(mediationAdapter, (NetworkExtras)this.nQ.get(mediationAdapter.getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(forName)) {
                return new bx((com.google.android.gms.ads.mediation.MediationAdapter)forName.newInstance());
            }
            eu.D("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
            throw new RemoteException();
        }
        catch (Throwable t) {
            eu.D("Could not instantiate mediation adapter: " + str + ". " + t.getMessage());
            throw new RemoteException();
        }
    }
    
    public void c(final Map nq) {
        this.nQ = nq;
    }
    
    public bu m(final String s) {
        return this.n(s);
    }
}
