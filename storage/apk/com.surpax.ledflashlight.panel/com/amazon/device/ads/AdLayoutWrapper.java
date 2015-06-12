// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

class AdLayoutWrapper implements AdWrapper
{
    private final AdLayout adLayout;
    
    AdLayoutWrapper(final AdLayout adLayout) {
        this.adLayout = adLayout;
    }
    
    @Override
    public Ad getAd() {
        return this.adLayout;
    }
    
    @Override
    public AdData getAdData() {
        return this.adLayout.getAdController().getAdData();
    }
    
    @Override
    public IAdLoaderCallback getAdLoaderCallback() {
        return this.adLayout.getAdController();
    }
    
    @Override
    public int prepareAd(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        return this.adLayout.prepareAd(adLoader$AdReadyToLoadListener);
    }
}
