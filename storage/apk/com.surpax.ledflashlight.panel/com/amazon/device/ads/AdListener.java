// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public interface AdListener
{
    void onAdCollapsed(Ad p0);
    
    void onAdDismissed(Ad p0);
    
    void onAdExpanded(Ad p0);
    
    void onAdFailedToLoad(Ad p0, AdError p1);
    
    void onAdLoaded(Ad p0, AdProperties p1);
}
