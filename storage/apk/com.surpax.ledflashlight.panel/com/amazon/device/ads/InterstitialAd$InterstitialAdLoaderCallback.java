// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.IntentFilter;
import java.util.TimerTask;
import android.content.Intent;
import android.content.Context;
import android.webkit.WebView;
import android.os.Handler;
import java.util.UUID;
import java.util.Timer;
import android.content.BroadcastReceiver;
import android.app.Activity;
import java.util.concurrent.atomic.AtomicBoolean;

class InterstitialAd$InterstitialAdLoaderCallback implements IAdLoaderCallback
{
    private final InterstitialAd interstitialAd;
    final /* synthetic */ InterstitialAd this$0;
    
    public InterstitialAd$InterstitialAdLoaderCallback(final InterstitialAd this$0, final InterstitialAd interstitialAd) {
        this.this$0 = this$0;
        this.interstitialAd = interstitialAd;
    }
    
    @Override
    public void adFailed(final AdError adError) {
        if (!this.this$0.getAndSetHasFinishedLoading(true)) {
            this.this$0.failAd(adError);
        }
    }
    
    @Override
    public void adShown() {
        WebRequest.executeWebRequestInThread(this.this$0.getAdData().getImpressionPixelUrl());
    }
    
    @Override
    public int getTimeout() {
        return this.interstitialAd.getTimeout();
    }
    
    @Override
    public void handleResponse() {
        this.this$0.prerenderHtml();
    }
}
