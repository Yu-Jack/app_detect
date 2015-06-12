// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import android.content.Context;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.AdListener;

public final class av
{
    private AdListener lQ;
    private InAppPurchaseListener mB;
    private PlayStorePurchaseListener mC;
    private final Context mContext;
    private AppEventListener mh;
    private String mj;
    private final bs mw;
    private final ak mx;
    private aq my;
    private String mz;
    
    public av(final Context context) {
        this(context, ak.aF());
    }
    
    public av(final Context mContext, final ak mx) {
        this.mw = new bs();
        this.mContext = mContext;
        this.mx = mx;
    }
    
    private void k(final String s) {
        if (this.mj == null) {
            this.l(s);
        }
        this.my = ah.a(this.mContext, new al(), this.mj, this.mw);
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
    }
    
    private void l(final String str) {
        if (this.my == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }
    
    public void a(final at at) {
        try {
            if (this.my == null) {
                this.k("loadAd");
            }
            if (this.my.a(this.mx.a(this.mContext, at))) {
                this.mw.c(at.aI());
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to load ad.", (Throwable)ex);
        }
    }
    
    public AdListener getAdListener() {
        return this.lQ;
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
    
    public boolean isLoaded() {
        try {
            return this.my != null && this.my.isReady();
        }
        catch (RemoteException ex) {
            eu.c("Failed to check if ad is ready.", (Throwable)ex);
            return false;
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
    
    public void setAdUnitId(final String mj) {
        if (this.mj != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
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
    
    public void setPlayStorePurchaseParams(final PlayStorePurchaseListener mc, final String s) {
        try {
            this.mC = mc;
            if (this.my != null) {
                final aq my = this.my;
                dl dl;
                if (mc != null) {
                    dl = new dl(mc);
                }
                else {
                    dl = null;
                }
                my.a(dl, s);
            }
        }
        catch (RemoteException ex) {
            eu.c("Failed to set the play store purchase parameter.", (Throwable)ex);
        }
    }
    
    public void show() {
        try {
            this.l("show");
            this.my.showInterstitial();
        }
        catch (RemoteException ex) {
            eu.c("Failed to show interstitial.", (Throwable)ex);
        }
    }
}
