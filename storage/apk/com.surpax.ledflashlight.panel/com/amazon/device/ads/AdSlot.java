// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AdSlot
{
    private AdError adError;
    private final AdTargetingOptions adOptions;
    private final AdWrapper adWrapper;
    private int slotNumber;
    
    public AdSlot(final Ad ad, final AdTargetingOptions adTargetingOptions) {
        this(createAdWrapper(ad), adTargetingOptions);
    }
    
    AdSlot(final AdWrapper adWrapper, final AdTargetingOptions adOptions) {
        this.adWrapper = adWrapper;
        if (adOptions == null) {
            this.adOptions = new AdTargetingOptions();
            return;
        }
        this.adOptions = adOptions;
    }
    
    static AdWrapper createAdWrapper(final Ad ad) {
        if (ad instanceof AdLayout) {
            return new AdLayoutWrapper((AdLayout)ad);
        }
        if (ad instanceof InterstitialAd) {
            return new InterstitialAdWrapper((InterstitialAd)ad);
        }
        return null;
    }
    
    public Ad getAd() {
        return this.adWrapper.getAd();
    }
    
    AdData getAdData() {
        return this.adWrapper.getAdData();
    }
    
    AdError getAdError() {
        return this.adError;
    }
    
    IAdLoaderCallback getAdLoaderCallback() {
        return this.adWrapper.getAdLoaderCallback();
    }
    
    public AdTargetingOptions getAdTargetingOptions() {
        return this.adOptions;
    }
    
    AdWrapper getAdWrapper() {
        return this.adWrapper;
    }
    
    int getSlotNumber() {
        return this.slotNumber;
    }
    
    void setAdError(final AdError adError) {
        this.adError = adError;
    }
    
    void setSlotNumber(final int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
