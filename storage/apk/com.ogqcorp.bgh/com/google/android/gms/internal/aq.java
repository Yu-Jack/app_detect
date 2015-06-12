// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import android.os.RemoteException;
import android.content.Context;

public final class aq
{
    private final cx a;
    private final bb b;
    private final Context c;
    private final Object d;
    private final as e;
    private boolean f;
    private aw g;
    
    public aq(final Context c, final cx a, final bb b, final as e) {
        this.d = new Object();
        this.f = false;
        this.c = c;
        this.a = a;
        this.b = b;
        this.e = e;
    }
    
    public ax a(final long n, final long n2) {
        en.a("Starting mediation.");
        for (final ar ar : this.e.a) {
            en.c("Trying mediation network: " + ar.b);
            for (final String s : ar.c) {
                final ax a;
                synchronized (this.d) {
                    if (this.f) {
                        return new ax(-1);
                    }
                    this.g = new aw(this.c, s, this.b, this.e, ar, this.a.c, this.a.d, this.a.k);
                    // monitorexit(this.d)
                    a = this.g.a(n, n2);
                    if (a.a == 0) {
                        en.a("Adapter succeeded.");
                        return a;
                    }
                }
                if (a.c != null) {
                    em.a.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            try {
                                a.c.c();
                            }
                            catch (RemoteException ex) {
                                en.c("Could not destroy mediation adapter.", (Throwable)ex);
                            }
                        }
                    });
                }
            }
        }
        return new ax(1);
    }
    
    public void a() {
        synchronized (this.d) {
            this.f = true;
            if (this.g != null) {
                this.g.a();
            }
        }
    }
}
