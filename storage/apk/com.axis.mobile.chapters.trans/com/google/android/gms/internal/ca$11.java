// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationBannerListener;
import android.os.RemoteException;

class ca$11 implements Runnable
{
    final /* synthetic */ ca nW;
    
    ca$11(final ca nw) {
        this.nW = nw;
    }
    
    @Override
    public void run() {
        try {
            this.nW.nT.onAdLeftApplication();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
}
