// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android;

public interface FlurryAdListener
{
    void onAdClicked(String p0);
    
    void onAdClosed(String p0);
    
    void onAdOpened(String p0);
    
    void onApplicationExit(String p0);
    
    void onRenderFailed(String p0);
    
    void onRendered(String p0);
    
    void onVideoCompleted(String p0);
    
    boolean shouldDisplayAd(String p0, FlurryAdType p1);
    
    void spaceDidFailToReceiveAd(String p0);
    
    void spaceDidReceiveAd(String p0);
}
