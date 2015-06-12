// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class DefaultAdListener implements AdListener
{
    final String LOG_TAG;
    
    public DefaultAdListener() {
        this(DefaultAdListener.class.getSimpleName());
    }
    
    DefaultAdListener(final String log_TAG) {
        this.LOG_TAG = log_TAG;
    }
    
    @Override
    public void onAdCollapsed(final Ad ad) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Collapsed.");
    }
    
    @Override
    public void onAdDismissed(final Ad ad) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Dismissed.");
    }
    
    @Override
    public void onAdExpanded(final Ad ad) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Will Expand.");
    }
    
    @Override
    public void onAdFailedToLoad(final Ad ad, final AdError adError) {
        Log.d(this.LOG_TAG, "Default ad listener called - Ad Failed to Load. Error code: %s, Error Message: %s", adError.getCode(), adError.getMessage());
    }
    
    @Override
    public void onAdLoaded(final Ad ad, final AdProperties adProperties) {
        Log.d(this.LOG_TAG, "Default ad listener called - AdLoaded.");
    }
}
