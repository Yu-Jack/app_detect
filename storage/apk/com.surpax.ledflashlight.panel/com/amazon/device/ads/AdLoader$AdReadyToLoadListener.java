// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.concurrent.atomic.AtomicInteger;

public class AdLoader$AdReadyToLoadListener
{
    private final AdSlot[] adSlots;
    private final AdTargetingOptions requestOptions;
    private final int timeout;
    private final AtomicInteger waitCount;
    
    public AdLoader$AdReadyToLoadListener(final int timeout, final AtomicInteger waitCount, final AdTargetingOptions requestOptions, final AdSlot... adSlots) {
        this.waitCount = waitCount;
        this.requestOptions = requestOptions;
        this.adSlots = adSlots;
        this.timeout = timeout;
    }
    
    public void onAdReady(final Ad ad) {
        AdLoader.decrementCount(this.timeout, this.waitCount, this.requestOptions, this.adSlots);
    }
}
