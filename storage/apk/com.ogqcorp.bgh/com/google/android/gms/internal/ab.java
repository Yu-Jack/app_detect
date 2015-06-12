// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.d.b;
import android.view.ViewGroup;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.a;

public final class ab
{
    private final ba a;
    private final j b;
    private a c;
    private q d;
    private d[] e;
    private String f;
    private ViewGroup g;
    private com.google.android.gms.ads.a.a h;
    private b i;
    
    public ab(final ViewGroup viewGroup) {
        this(viewGroup, null, false, j.a());
    }
    
    ab(final ViewGroup g, final AttributeSet set, final boolean b, final j b2) {
        this.a = new ba();
        this.g = g;
        this.b = b2;
        if (set == null) {
            return;
        }
        final Context context = g.getContext();
        try {
            final m m = new m(context, set);
            this.e = m.a(b);
            this.f = m.a();
            if (g.isInEditMode()) {
                em.a(g, new ak(context, this.e[0]), "Ads by Google");
            }
        }
        catch (IllegalArgumentException ex) {
            em.a(g, new ak(context, com.google.android.gms.ads.d.a), ex.getMessage(), ex.getMessage());
        }
    }
    
    private void h() {
        try {
            final com.google.android.gms.a.a a = this.d.a();
            if (a == null) {
                return;
            }
            this.g.addView((View)com.google.android.gms.a.d.a(a));
        }
        catch (RemoteException ex) {
            en.c("Failed to get an ad frame.", (Throwable)ex);
        }
    }
    
    private void i() {
        if ((this.e == null || this.f == null) && this.d == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        final Context context = this.g.getContext();
        this.d = com.google.android.gms.internal.h.a(context, new ak(context, this.e), this.f, this.a);
        if (this.c != null) {
            this.d.a(new g(this.c));
        }
        if (this.h != null) {
            this.d.a(new l(this.h));
        }
        if (this.i != null) {
            this.d.a(new ct(this.i));
        }
        this.h();
    }
    
    public void a() {
        try {
            if (this.d != null) {
                this.d.b();
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to destroy AdView.", (Throwable)ex);
        }
    }
    
    public void a(final a c) {
        try {
            this.c = c;
            if (this.d != null) {
                final q d = this.d;
                g g;
                if (c != null) {
                    g = new g(c);
                }
                else {
                    g = null;
                }
                d.a(g);
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to set the AdListener.", (Throwable)ex);
        }
    }
    
    public void a(final b i) {
        try {
            this.i = i;
            if (this.d != null) {
                final q d = this.d;
                ct ct;
                if (i != null) {
                    ct = new ct(i);
                }
                else {
                    ct = null;
                }
                d.a(ct);
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to set the InAppPurchaseListener.", (Throwable)ex);
        }
    }
    
    public void a(final z z) {
        try {
            if (this.d == null) {
                this.i();
            }
            if (this.d.a(this.b.a(this.g.getContext(), z))) {
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
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f = f;
    }
    
    public void a(final d... array) {
        if (this.e != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.b(array);
    }
    
    public a b() {
        return this.c;
    }
    
    public void b(final d... e) {
        this.e = e;
        while (true) {
            try {
                if (this.d != null) {
                    this.d.a(new ak(this.g.getContext(), this.e));
                }
                this.g.requestLayout();
            }
            catch (RemoteException ex) {
                en.c("Failed to set the ad size.", (Throwable)ex);
                continue;
            }
            break;
        }
    }
    
    public d c() {
        try {
            if (this.d != null) {
                return this.d.i().a();
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to get the current AdSize.", (Throwable)ex);
        }
        if (this.e != null) {
            return this.e[0];
        }
        return null;
    }
    
    public String d() {
        return this.f;
    }
    
    public b e() {
        return this.i;
    }
    
    public void f() {
        try {
            if (this.d != null) {
                this.d.d();
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to call pause.", (Throwable)ex);
        }
    }
    
    public void g() {
        try {
            if (this.d != null) {
                this.d.e();
            }
        }
        catch (RemoteException ex) {
            en.c("Failed to call resume.", (Throwable)ex);
        }
    }
}
