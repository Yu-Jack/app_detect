// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.HashMap;

interface IAdController
{
    void adClosedExpansion();
    
    void adExpanded();
    
    void adLoaded(AdProperties p0);
    
    void destroy();
    
    AdLayout getAdLayout();
    
    AdSize getAdSize();
    
    String getMaxSize();
    
    AdWebViewClient$UrlExecutor getSpecialUrlExecutor();
    
    int getTimeout();
    
    int getWindowHeight();
    
    int getWindowWidth();
    
    boolean isAdExpanded();
    
    boolean isAdLoading();
    
    void prepareAd(long p0);
    
    void prepareToGoAway();
    
    boolean sendCommand(String p0, HashMap p1);
    
    void setListener(AdListener p0);
    
    void setTimeout(int p0);
    
    void setWindowDimensions(int p0, int p1);
    
    boolean shouldDisableWebViewHardwareAcceleration();
}
