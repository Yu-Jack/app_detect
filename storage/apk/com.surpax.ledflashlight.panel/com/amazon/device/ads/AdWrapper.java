// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

interface AdWrapper
{
    Ad getAd();
    
    AdData getAdData();
    
    IAdLoaderCallback getAdLoaderCallback();
    
    int prepareAd(AdLoader$AdReadyToLoadListener p0);
}
