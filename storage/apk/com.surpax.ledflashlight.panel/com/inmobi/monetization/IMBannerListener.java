// 
// Decompiled by Procyon v0.5.29
// 

package com.inmobi.monetization;

import java.util.Map;

public interface IMBannerListener
{
    void onBannerInteraction(IMBanner p0, Map p1);
    
    void onBannerRequestFailed(IMBanner p0, IMErrorCode p1);
    
    void onBannerRequestSucceeded(IMBanner p0);
    
    void onDismissBannerScreen(IMBanner p0);
    
    void onLeaveApplication(IMBanner p0);
    
    void onShowBannerScreen(IMBanner p0);
}
