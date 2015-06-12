// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.dynamic.d;
import android.os.RemoteException;
import com.google.android.gms.dynamic.e;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;

public final class au
{
    private AdListener lQ;
    private ViewGroup mA;
    private InAppPurchaseListener mB;
    private PlayStorePurchaseListener mC;
    private AppEventListener mh;
    private AdSize[] mi;
    private String mj;
    private final bs mw;
    private final ak mx;
    private aq my;
    private String mz;
    
    public au(final ViewGroup viewGroup) {
        this(viewGroup, null, false, ak.aF());
    }
    
    public au(final ViewGroup viewGroup, final AttributeSet set, final boolean b) {
        this(viewGroup, set, b, ak.aF());
    }
    
    au(final ViewGroup ma, final AttributeSet set, final boolean b, final ak mx) {
        this.mw = new bs();
        this.mA = ma;
        this.mx = mx;
        if (set == null) {
            return;
        }
        final Context context = ma.getContext();
        try {
            final ao ao = new ao(context, set);
            this.mi = ao.f(b);
            this.mj = ao.getAdUnitId();
            if (ma.isInEditMode()) {
                et.a(ma, new al(context, this.mi[0]), "Ads by Google");
            }
        }
        catch (IllegalArgumentException ex) {
            et.a(ma, new al(context, AdSize.BANNER), ex.getMessage(), ex.getMessage());
        }
    }
    
    private void aL() {
        try {
            final d u = this.my.U();
            if (u == null) {
                return;
            }
            this.mA.addView((View)e.e(u));
        }
        catch (RemoteException ex) {
            eu.c("Failed to get an ad frame.", (Throwable)ex);
        }
    }
    
    private void aM() {
        if ((this.mi == null || this.mj == null) && this.my == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        final Context context = this.mA.getContext();
        this.my = ah.a(context, new al(context, this.mi), this.mj, this.mw);
        if (this.lQ != null) {
            this.my.a(new ag(this.lQ));
        }
        if (this.mh != null) {
            this.my.a(new an(this.mh));
        }
        if (this.mB != null) {
            this.my.a(new dh(this.mB));
        }
        if (this.mC != null) {
            this.my.a(new dl(this.mC), this.mz);
        }
        this.aL();
    }
    
    public void a(final at at) {
        try {
            if (this.my == null) {
                this.aM();
            }
            if (this.my.a(this.mx.a(this.mA.getContext(), at))) {
                this.mw.c(at.aI());
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to load ad.", (Throwable)ex);
        }
    }
    
    public void a(final AdSize... mi) {
        this.mi = mi;
        while (true) {
            try {
                if (this.my != null) {
                    this.my.a(new al(this.mA.getContext(), this.mi));
                }
                this.mA.requestLayout();
            }
            catch (RemoteException ex) {
                eu.c("Failed to set the ad size.", (Throwable)ex);
                continue;
            }
            break;
        }
    }
    
    public void destroy() {
        try {
            if (this.my != null) {
                this.my.destroy();
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to destroy AdView.", (Throwable)ex);
        }
    }
    
    public AdListener getAdListener() {
        return this.lQ;
    }
    
    public AdSize getAdSize() {
        try {
            if (this.my != null) {
                return this.my.V().aG();
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to get the current AdSize.", (Throwable)ex);
        }
        if (this.mi != null) {
            return this.mi[0];
        }
        return null;
    }
    
    public AdSize[] getAdSizes() {
        return this.mi;
    }
    
    public String getAdUnitId() {
        return this.mj;
    }
    
    public AppEventListener getAppEventListener() {
        return this.mh;
    }
    
    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mB;
    }
    
    public void pause() {
        try {
            if (this.my != null) {
                this.my.pause();
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to call pause.", (Throwable)ex);
        }
    }
    
    public void recordManualImpression() {
        try {
            this.my.ag();
        }
        catch (RemoteException ex) {
            eu.c("Failed to record impression.", (Throwable)ex);
        }
    }
    
    public void resume() {
        try {
            if (this.my != null) {
                this.my.resume();
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to call resume.", (Throwable)ex);
        }
    }
    
    public void setAdListener(final AdListener lq) {
        try {
            this.lQ = lq;
            if (this.my != null) {
                final aq my = this.my;
                ag ag;
                if (lq != null) {
                    ag = new ag(lq);
                }
                else {
                    ag = null;
                }
                my.a(ag);
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to set the AdListener.", (Throwable)ex);
        }
    }
    
    public void setAdSizes(final AdSize... array) {
        if (this.mi != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.a(array);
    }
    
    public void setAdUnitId(final String mj) {
        if (this.mj != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.mj = mj;
    }
    
    public void setAppEventListener(final AppEventListener mh) {
        try {
            this.mh = mh;
            if (this.my != null) {
                final aq my = this.my;
                an an;
                if (mh != null) {
                    an = new an(mh);
                }
                else {
                    an = null;
                }
                my.a(an);
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to set the AppEventListener.", (Throwable)ex);
        }
    }
    
    public void setInAppPurchaseListener(final InAppPurchaseListener mb) {
        if (this.mC != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.mB = mb;
            if (this.my != null) {
                final aq my = this.my;
                dh dh;
                if (mb != null) {
                    dh = new dh(mb);
                }
                else {
                    dh = null;
                }
                my.a(dh);
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to set the InAppPurchaseListener.", (Throwable)ex);
        }
    }
    
    public void setPlayStorePurchaseParams(final PlayStorePurchaseListener mc, final String mz) {
        if (this.mB != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.mC = mc;
            this.mz = mz;
            if (this.my != null) {
                final aq my = this.my;
                dl dl;
                if (mc != null) {
                    dl = new dl(mc);
                }
                else {
                    dl = null;
                }
                my.a(dl, mz);
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to set the play store purchase parameter.", (Throwable)ex);
        }
    }
}
