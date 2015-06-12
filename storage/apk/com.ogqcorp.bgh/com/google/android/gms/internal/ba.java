// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.a.a.g;
import com.google.a.a.j;
import android.os.Bundle;
import com.google.android.gms.ads.c.b;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Map;

public final class ba extends bc
{
    private Map<Class<? extends NetworkExtras>, NetworkExtras> a;
    private Map<Class<? extends b>, Bundle> b;
    
    private <NETWORK_EXTRAS extends j, SERVER_PARAMETERS extends g> be b(final String str) {
        try {
            final Class<?> forName = Class.forName(str, false, ba.class.getClassLoader());
            if (com.google.a.a.b.class.isAssignableFrom(forName)) {
                final com.google.a.a.b b = (com.google.a.a.b)forName.newInstance();
                return new bn<Object, Object>(b, (j)this.a.get(b.b()));
            }
            if (b.class.isAssignableFrom(forName)) {
                return new bl((b)forName.newInstance(), this.b.get(forName));
            }
            en.e("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
            throw new RemoteException();
        }
        catch (Throwable t) {
            en.e("Could not instantiate mediation adapter: " + str + ". " + t.getMessage());
            throw new RemoteException();
        }
    }
    
    public be a(final String s) {
        return this.b(s);
    }
    
    public void a(final Map<Class<? extends NetworkExtras>, NetworkExtras> a) {
        this.a = a;
    }
    
    public void b(final Map<Class<? extends b>, Bundle> b) {
        this.b = b;
    }
}
