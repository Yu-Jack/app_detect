// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.SystemClock;
import android.os.RemoteException;
import com.google.android.gms.a.d;
import android.content.Context;

public final class aw implements ay
{
    private final String a;
    private final bb b;
    private final long c;
    private final ar d;
    private final ah e;
    private final ak f;
    private final Context g;
    private final Object h;
    private final dx i;
    private be j;
    private int k;
    
    public aw(final Context g, final String a, final bb b, final as as, final ar d, final ah e, final ak f, final dx i) {
        this.h = new Object();
        this.k = -2;
        this.g = g;
        this.a = a;
        this.b = b;
        long b2;
        if (as.b != -1L) {
            b2 = as.b;
        }
        else {
            b2 = 10000L;
        }
        this.c = b2;
        this.d = d;
        this.e = e;
        this.f = f;
        this.i = i;
    }
    
    private void a(final long n, final long n2, final long n3, final long n4) {
        while (this.k == -2) {
            this.b(n, n2, n3, n4);
        }
    }
    
    private void a(final au au) {
        try {
            if (this.i.d < 4100000) {
                if (this.f.e) {
                    this.j.a(com.google.android.gms.a.d.a(this.g), this.e, this.d.f, au);
                    return;
                }
                this.j.a(com.google.android.gms.a.d.a(this.g), this.f, this.e, this.d.f, au);
                return;
            }
        }
        catch (RemoteException ex) {
            en.c("Could not request ad from mediation adapter.", (Throwable)ex);
            this.a(5);
            return;
        }
        if (this.f.e) {
            this.j.a(com.google.android.gms.a.d.a(this.g), this.e, this.d.f, this.d.a, au);
            return;
        }
        this.j.a(com.google.android.gms.a.d.a(this.g), this.f, this.e, this.d.f, this.d.a, au);
    }
    
    private be b() {
        en.c("Instantiating mediation adapter: " + this.a);
        try {
            return this.b.a(this.a);
        }
        catch (RemoteException ex) {
            en.a("Could not instantiate mediation adapter: " + this.a, (Throwable)ex);
            return null;
        }
    }
    
    private void b(final long n, final long n2, final long n3, final long n4) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long a = n2 - (elapsedRealtime - n);
        final long b = n4 - (elapsedRealtime - n3);
        if (a <= 0L || b <= 0L) {
            en.c("Timed out waiting for adapter.");
            this.k = 3;
            return;
        }
        try {
            this.h.wait(Math.min(a, b));
        }
        catch (InterruptedException ex) {
            this.k = -1;
        }
    }
    
    public ax a(final long n, final long n2) {
        synchronized (this.h) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final au au = new au();
            em.a.post((Runnable)new Runnable() {
                @Override
                public void run() {
                    synchronized (aw.this.h) {
                        if (aw.this.k != -2) {
                            return;
                        }
                        aw.this.j = aw.this.b();
                        if (aw.this.j == null) {
                            aw.this.a(4);
                            return;
                        }
                    }
                    au.a(aw.this);
                    aw.this.a(au);
                }
                // monitorexit(o)
            });
            this.a(elapsedRealtime, this.c, n, n2);
            return new ax(this.d, this.j, this.a, au, this.k);
        }
    }
    
    public void a() {
        synchronized (this.h) {
            while (true) {
                try {
                    if (this.j != null) {
                        this.j.c();
                    }
                    this.k = -1;
                    this.h.notify();
                }
                catch (RemoteException ex) {
                    en.c("Could not destroy mediation adapter.", (Throwable)ex);
                    continue;
                }
                break;
            }
        }
    }
    
    @Override
    public void a(final int k) {
        synchronized (this.h) {
            this.k = k;
            this.h.notify();
        }
    }
}
