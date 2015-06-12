// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.mediation.MediationInterstitialAdapter;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationBannerListener;

public final class ca implements MediationBannerListener, MediationInterstitialListener
{
    private final bv nT;
    
    public ca(final bv nt) {
        this.nT = nt;
    }
    
    @Override
    public void onClick(final MediationBannerAdapter mediationBannerAdapter) {
        eu.z("Adapter called onClick.");
        if (!et.bW()) {
            eu.D("onClick must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$1(this));
            return;
        }
        try {
            this.nT.onAdClicked();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClicked.", (Throwable)ex);
        }
    }
    
    @Override
    public void onDismissScreen(final MediationBannerAdapter mediationBannerAdapter) {
        eu.z("Adapter called onDismissScreen.");
        if (!et.bW()) {
            eu.D("onDismissScreen must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$4(this));
            return;
        }
        try {
            this.nT.onAdClosed();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void onDismissScreen(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        eu.z("Adapter called onDismissScreen.");
        if (!et.bW()) {
            eu.D("onDismissScreen must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$9(this));
            return;
        }
        try {
            this.nT.onAdClosed();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdClosed.", (Throwable)ex);
        }
    }
    
    @Override
    public void onFailedToReceiveAd(final MediationBannerAdapter mediationBannerAdapter, final AdRequest$ErrorCode obj) {
        eu.z("Adapter called onFailedToReceiveAd with error. " + obj);
        if (!et.bW()) {
            eu.D("onFailedToReceiveAd must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$5(this, obj));
            return;
        }
        try {
            this.nT.onAdFailedToLoad(cb.a(obj));
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void onFailedToReceiveAd(final MediationInterstitialAdapter mediationInterstitialAdapter, final AdRequest$ErrorCode obj) {
        eu.z("Adapter called onFailedToReceiveAd with error " + obj + ".");
        if (!et.bW()) {
            eu.D("onFailedToReceiveAd must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$10(this, obj));
            return;
        }
        try {
            this.nT.onAdFailedToLoad(cb.a(obj));
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdFailedToLoad.", (Throwable)ex);
        }
    }
    
    @Override
    public void onLeaveApplication(final MediationBannerAdapter mediationBannerAdapter) {
        eu.z("Adapter called onLeaveApplication.");
        if (!et.bW()) {
            eu.D("onLeaveApplication must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$6(this));
            return;
        }
        try {
            this.nT.onAdLeftApplication();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void onLeaveApplication(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        eu.z("Adapter called onLeaveApplication.");
        if (!et.bW()) {
            eu.D("onLeaveApplication must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$11(this));
            return;
        }
        try {
            this.nT.onAdLeftApplication();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLeftApplication.", (Throwable)ex);
        }
    }
    
    @Override
    public void onPresentScreen(final MediationBannerAdapter mediationBannerAdapter) {
        eu.z("Adapter called onPresentScreen.");
        if (!et.bW()) {
            eu.D("onPresentScreen must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$7(this));
            return;
        }
        try {
            this.nT.onAdOpened();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
    
    @Override
    public void onPresentScreen(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        eu.z("Adapter called onPresentScreen.");
        if (!et.bW()) {
            eu.D("onPresentScreen must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$2(this));
            return;
        }
        try {
            this.nT.onAdOpened();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdOpened.", (Throwable)ex);
        }
    }
    
    @Override
    public void onReceivedAd(final MediationBannerAdapter mediationBannerAdapter) {
        eu.z("Adapter called onReceivedAd.");
        if (!et.bW()) {
            eu.D("onReceivedAd must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$8(this));
            return;
        }
        try {
            this.nT.onAdLoaded();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
    
    @Override
    public void onReceivedAd(final MediationInterstitialAdapter mediationInterstitialAdapter) {
        eu.z("Adapter called onReceivedAd.");
        if (!et.bW()) {
            eu.D("onReceivedAd must be called on the main UI thread.");
            et.sv.post((Runnable)new ca$3(this));
            return;
        }
        try {
            this.nT.onAdLoaded();
        }
        catch (RemoteException ex) {
            eu.c("Could not call onAdLoaded.", (Throwable)ex);
        }
    }
}
