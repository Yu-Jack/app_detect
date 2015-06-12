// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;

public final class by implements MediationBannerListener, MediationInterstitialListener
{
    private final bv nT;
    
    public by(final bv nt) {
        this.nT = nt;
    }
    
    @Override
    public void onAdClicked(final MediationBannerAdapter mediationBannerAdapter) {
        hm.ay("onAdClicked must be called on the main UI thread.");
        eu.z("Adapter called onAdClicked.");
        try {
            this.nT.onAdClicked();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClicked.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdClicked(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        hm.ay("onAdClicked must be called on the main UI thread.");
        eu.z("Adapter called onAdClicked.");
        try {
            this.nT.onAdClicked();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClicked.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdClosed(final MediationBannerAdapter mediationBannerAdapter) {
        hm.ay("onAdClosed must be called on the main UI thread.");
        eu.z("Adapter called onAdClosed.");
        try {
            this.nT.onAdClosed();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdClosed(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        hm.ay("onAdClosed must be called on the main UI thread.");
        eu.z("Adapter called onAdClosed.");
        try {
            this.nT.onAdClosed();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdFailedToLoad(final MediationBannerAdapter mediationBannerAdapter, final int i) {
        hm.ay("onAdFailedToLoad must be called on the main UI thread.");
        eu.z("Adapter called onAdFailedToLoad with error. " + i);
        try {
            this.nT.onAdFailedToLoad(i);
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdFailedToLoad(final MediationInterstitialAdapter mediationInterstitialAdapter, final int i) {
        hm.ay("onAdFailedToLoad must be called on the main UI thread.");
        eu.z("Adapter called onAdFailedToLoad with error " + i + ".");
        try {
            this.nT.onAdFailedToLoad(i);
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdLeftApplication(final MediationBannerAdapter mediationBannerAdapter) {
        hm.ay("onAdLeftApplication must be called on the main UI thread.");
        eu.z("Adapter called onAdLeftApplication.");
        try {
            this.nT.onAdLeftApplication();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdLeftApplication(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        hm.ay("onAdLeftApplication must be called on the main UI thread.");
        eu.z("Adapter called onAdLeftApplication.");
        try {
            this.nT.onAdLeftApplication();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdLoaded(final MediationBannerAdapter mediationBannerAdapter) {
        hm.ay("onAdLoaded must be called on the main UI thread.");
        eu.z("Adapter called onAdLoaded.");
        try {
            this.nT.onAdLoaded();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdLoaded(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        hm.ay("onAdLoaded must be called on the main UI thread.");
        eu.z("Adapter called onAdLoaded.");
        try {
            this.nT.onAdLoaded();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdOpened(final MediationBannerAdapter mediationBannerAdapter) {
        hm.ay("onAdOpened must be called on the main UI thread.");
        eu.z("Adapter called onAdOpened.");
        try {
            this.nT.onAdOpened();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
    
    @Override
    public void onAdOpened(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        hm.ay("onAdOpened must be called on the main UI thread.");
        eu.z("Adapter called onAdOpened.");
        try {
            this.nT.onAdOpened();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
}
