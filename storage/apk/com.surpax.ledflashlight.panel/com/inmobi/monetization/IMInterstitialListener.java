// 
// Decompiled by Procyon v0.5.29
// 

package com.inmobi.monetization;

import java.util.Map;

public interface IMInterstitialListener
{
    void onDismissInterstitialScreen(IMInterstitial p0);
    
    void onInterstitialFailed(IMInterstitial p0, IMErrorCode p1);
    
    void onInterstitialInteraction(IMInterstitial p0, Map p1);
    
    void onInterstitialLoaded(IMInterstitial p0);
    
    void onLeaveApplication(IMInterstitial p0);
    
    void onShowInterstitialScreen(IMInterstitial p0);
}
