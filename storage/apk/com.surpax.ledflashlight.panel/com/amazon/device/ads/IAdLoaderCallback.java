// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

interface IAdLoaderCallback
{
    void adFailed(AdError p0);
    
    void adShown();
    
    int getTimeout();
    
    void handleResponse();
}
