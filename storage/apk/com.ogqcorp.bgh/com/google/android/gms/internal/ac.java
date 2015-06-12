// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.d.b;
import com.google.android.gms.ads.a;
import android.content.Context;

public final class ac
{
    private final ba a;
    private final Context b;
    private final j c;
    private a d;
    private q e;
    private String f;
    private com.google.android.gms.ads.a.a g;
    private b h;
    
    public ac(final Context context) {
        this(context, j.a());
    }
    
    public ac(final Context b, final j c) {
        this.a = new ba();
        this.b = b;
        this.c = c;
    }
    
    private void b(final String s) {
        if (this.f == null) {
            this.c(s);
        }
        this.e = com.google.android.gms.internal.h.a(this.b, new ak(), this.f, this.a);
        if (this.d != null) {
            this.e.a(new g(this.d));
        }
        if (this.g != null) {
            this.e.a(new l(this.g));
        }
        if (this.h != null) {
            this.e.a(new ct(this.h));
        }
    }
    
    private void c(final String str) {
        if (this.e == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }
    
    public void a() {
        try {
            this.c("show");
            this.e.f();
        }
        catch (RemoteException ex) {
            en.c("Failed to show interstitial.", (Throwable)ex);
        }
    }
    
    public void a(final a d) {
        try {
            this.d = d;
            if (this.e != null) {
                final q e = this.e;
                g g;
                if (d != null) {
                    g = new g(d);
                }
                else {
                    g = null;
                }
                e.a(g);
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to set the AdListener.", (Throwable)ex);
        }
    }
    
    public void a(final z z) {
        try {
            if (this.e == null) {
                this.b("loadAd");
            }
            if (this.e.a(this.c.a(this.b, z))) {
                this.a.a(z.i());
                this.a.b(z.j());
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to load ad.", (Throwable)ex);
        }
    }
    
    public void a(final String f) {
        if (this.f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f = f;
    }
}
