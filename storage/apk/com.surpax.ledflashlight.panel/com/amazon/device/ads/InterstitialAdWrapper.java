// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class InterstitialAdWrapper implements AdWrapper
{
    private final InterstitialAd interstitialAd;
    
    InterstitialAdWrapper(final InterstitialAd interstitialAd) {
        this.interstitialAd = interstitialAd;
    }
    
    @Override
    public Ad getAd() {
        return this.interstitialAd;
    }
    
    @Override
    public AdData getAdData() {
        return this.interstitialAd.getAdData();
    }
    
    @Override
    public IAdLoaderCallback getAdLoaderCallback() {
        return this.interstitialAd.getAdLoaderCallback();
    }
    
    @Override
    public int prepareAd(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        return this.interstitialAd.prepareAd(adLoader$AdReadyToLoadListener);
    }
}
