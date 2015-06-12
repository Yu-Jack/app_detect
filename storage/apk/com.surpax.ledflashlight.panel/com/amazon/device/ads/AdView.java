// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

interface AdView
{
    int getHeight();
    
    AdWebViewClient$UrlExecutor getSpecialUrlExecutor();
    
    boolean isAdViewRenderable();
    
    boolean launchExternalBrowserForLink(String p0);
    
    void onPageFinished();
    
    boolean shouldDisableWebViewHardwareAcceleration();
}
