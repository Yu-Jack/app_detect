// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public interface Ad
{
    int getTimeout();
    
    boolean isLoading();
    
    boolean loadAd();
    
    boolean loadAd(AdTargetingOptions p0);
    
    void setListener(AdListener p0);
    
    void setTimeout(int p0);
}
