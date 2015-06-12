// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import android.content.Context;

abstract class AdRenderer implements AdView
{
    protected static final String AAX_REDIRECT_BETA = "aax-beta.integ.amazon.com";
    protected static final String AAX_REDIRECT_GAMMA = "aax-us-east.amazon-adsystem.com";
    protected static final String AAX_REDIRECT_PROD = "aax-us-east.amazon-adsystem.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_BETA = "d16g-cornerstone-bes.integ.amazon.com";
    protected static final String CORNERSTONE_BEST_ENDPOINT_PROD = "pda-bes.amazon.com";
    private static final String LOG_TAG = "AdRenderer";
    protected AdData adData;
    protected final Context context;
    protected final IAdController controller;
    protected boolean isDestroyed;
    protected boolean isInitialized;
    private double scalingMultiplier;
    protected boolean viewRemoved;
    
    protected AdRenderer(final AdData adData, final IAdController controller, final Context context) {
        this.viewRemoved = false;
        this.isDestroyed = false;
        this.isInitialized = false;
        this.scalingMultiplier = 1.0;
        this.adData = adData;
        this.controller = controller;
        this.context = context;
    }
    
    protected static double calculateScalingMultiplier(final int n, final int n2, final int n3, final int n4) {
        double n5 = n3 / n;
        final double n6 = n4 / n2;
        if ((n6 < n5 || n5 == 0.0) && n6 != 0.0) {
            n5 = n6;
        }
        if (n5 == 0.0) {
            n5 = 1.0;
        }
        return n5;
    }
    
    protected static double determineScalingMultiplier(final AdData adData, final IAdController adController) {
        final float scalingFactorAsFloat = InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat();
        final int i = (int)(scalingFactorAsFloat * adData.getWidth());
        final int j = (int)(scalingFactorAsFloat * adData.getHeight());
        final double calculateScalingMultiplier = calculateScalingMultiplier(i, j, adController.getWindowWidth(), adController.getWindowHeight());
        Log.d("AdRenderer", "Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", scalingFactorAsFloat, adController.getWindowWidth(), adController.getWindowHeight(), i, j, calculateScalingMultiplier);
        return calculateScalingMultiplier;
    }
    
    protected void adLoaded(final AdProperties adProperties) {
        this.controller.adLoaded(adProperties);
    }
    
    protected abstract void destroy();
    
    protected abstract boolean getAdState(final AdRenderer$AdState p0);
    
    @Override
    public int getHeight() {
        return this.adData.getHeight();
    }
    
    protected double getScalingMultiplier() {
        return this.scalingMultiplier;
    }
    
    public String getScalingMultiplierDescription() {
        if (this.getScalingMultiplier() > 1.0) {
            return "u";
        }
        if (this.getScalingMultiplier() < 1.0 && this.getScalingMultiplier() > 0.0) {
            return "d";
        }
        return "n";
    }
    
    @Override
    public AdWebViewClient$UrlExecutor getSpecialUrlExecutor() {
        return this.controller.getSpecialUrlExecutor();
    }
    
    public void initialize() {
        this.scalingMultiplier = determineScalingMultiplier(this.adData, this.controller);
        this.isInitialized = true;
    }
    
    protected boolean isAdViewDestroyed() {
        return !this.isInitialized() || this.isDestroyed;
    }
    
    protected boolean isAdViewRemoved() {
        return !this.isInitialized() || this.viewRemoved;
    }
    
    @Override
    public boolean isAdViewRenderable() {
        return this.isInitialized() && !this.isAdViewRemoved() && !this.isAdViewDestroyed();
    }
    
    public boolean isInitialized() {
        return this.isInitialized;
    }
    
    protected abstract void prepareToGoAway();
    
    protected abstract void removeView();
    
    protected abstract boolean render();
    
    protected abstract boolean sendCommand(final String p0, final Map p1);
    
    protected void setAd(final AdData adData) {
        this.adData = adData;
    }
    
    @Override
    public boolean shouldDisableWebViewHardwareAcceleration() {
        return this.controller.shouldDisableWebViewHardwareAcceleration();
    }
    
    protected abstract boolean shouldReuse();
}
