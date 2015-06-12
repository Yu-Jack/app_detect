// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationBannerListener;
import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;

class ca$5 implements Runnable
{
    final /* synthetic */ ca nW;
    final /* synthetic */ AdRequest$ErrorCode nX;
    
    ca$5(final ca nw, final AdRequest$ErrorCode nx) {
        this.nW = nw;
        this.nX = nx;
    }
    
    @Override
    public void run() {
        try {
            this.nW.nT.onAdFailedToLoad(cb.a(this.nX));
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
}
