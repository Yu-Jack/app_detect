// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import java.util.HashMap;
import android.os.Looper;
import android.os.Handler;
import android.webkit.WebView;
import android.content.Context;

class AdController implements IAdController, IAdLoaderCallback
{
    private static final String LOG_TAG = "AdController";
    private AdData adData;
    private final AdLayout adLayout;
    private AdListener adListener;
    private final AdSize adSize;
    private int adWindowHeight;
    private int adWindowWidth;
    private final Context context;
    private AdRenderer currentAdRenderer;
    private boolean isLoading;
    private int timeout;
    private WebView webView;
    
    protected AdController() {
        this.timeout = 20000;
        this.adLayout = null;
        this.context = null;
        this.adSize = null;
    }
    
    AdController(final AdLayout adLayout, final AdSize adSize, final Context context) {
        this.timeout = 20000;
        this.adLayout = adLayout;
        this.context = context;
        this.adSize = adSize;
        this.adListener = this.createAdListener();
    }
    
    private void createAndCacheWebView() {
        this.webView = WebViewFactory.getInstance().createWebView(this.context);
    }
    
    private void destroyCurrentAdRenderer() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.removeView();
            this.currentAdRenderer.destroy();
            this.currentAdRenderer = null;
        }
    }
    
    protected static String getAsSizeString(final int i, final int j) {
        return Integer.toString(i) + "x" + Integer.toString(j);
    }
    
    private void prepareRenderer(final AdData$AAXCreative adData$AAXCreative) {
        this.currentAdRenderer = this.createAdRendererFromFactory(adData$AAXCreative, this.currentAdRenderer);
        if (this.currentAdRenderer == null) {
            Log.d("AdController", "No renderer returned, not loading an ad");
            this.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "No renderer returned, not loading an ad"));
        }
        else {
            this.currentAdRenderer.initialize();
            this.getAdData().setIsRendering(true);
            final long nanoTime = System.nanoTime();
            this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, nanoTime);
            this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, nanoTime);
            this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER_FAILED, nanoTime);
            if (!this.currentAdRenderer.render()) {
                this.destroyCurrentAdRenderer();
                Log.d("AdController", "Ad could not render");
                this.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Ad could not render"));
            }
        }
    }
    
    private void processAdFailure() {
        if (this.webView != null) {
            this.webView.destroy();
            this.webView = null;
        }
        this.isLoading = false;
    }
    
    private void retrieveAndSetUserAgentString() {
        this.createAndCacheWebView();
        DeviceInfo.setUserAgentString(this.webView.getSettings().getUserAgentString());
    }
    
    private void submitAndResetMetricsIfNecessary(final boolean b) {
        if (b) {
            Metrics.getInstance().submitAndResetMetrics(this.getAdData());
        }
    }
    
    protected void accumulateAdFailureMetrics(final AdError adError) {
        final long nanoTime = System.nanoTime();
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER_FAILED, nanoTime);
        if (adError.getCode() != AdError$ErrorCode.NO_FILL) {
            this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED);
        }
        if (this.getAdData().getIsRendering()) {
            this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_RENDERING_FATAL);
            this.getAdData().setIsRendering(false);
        }
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, nanoTime);
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, nanoTime);
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, nanoTime);
        this.setAdditionalMetrics();
    }
    
    @Override
    public void adClosedExpansion() {
        new Handler(this.context.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                AdController.this.adListener.onAdCollapsed(AdController.this.adLayout);
            }
        });
    }
    
    @Override
    public void adExpanded() {
        new Handler(this.context.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                AdController.this.adListener.onAdExpanded(AdController.this.adLayout);
            }
        });
    }
    
    @Override
    public void adFailed(final AdError adError) {
        if (this.getAdData() == null || this.getAdData().getMetricsCollector().isMetricsCollectorEmpty()) {
            this.adFailedBeforeAdMetricsStart(adError);
            return;
        }
        this.adFailedAfterAdMetricsStart(adError);
    }
    
    protected void adFailedAfterAdMetricsStart(final AdError adError) {
        this.processAdFailure();
        this.accumulateAdFailureMetrics(adError);
        this.callListenerOnAdFailedToLoad(adError, true);
    }
    
    protected void adFailedBeforeAdMetricsStart(final AdError adError) {
        this.processAdFailure();
        this.callListenerOnAdFailedToLoad(adError, false);
    }
    
    @Override
    public void adLoaded(final AdProperties adProperties) {
        final long nanoTime = System.nanoTime();
        this.adShown();
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, nanoTime);
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, nanoTime);
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, nanoTime);
        this.setAdditionalMetrics();
        this.getAdData().setIsRendering(false);
        this.isLoading = false;
        new Handler(this.context.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                AdController.this.adListener.onAdLoaded(AdController.this.adLayout, adProperties);
                AdController.this.submitAndResetMetricsIfNecessary(true);
            }
        });
    }
    
    @Override
    public void adShown() {
        WebRequest.executeWebRequestInThread(this.getAdData().getImpressionPixelUrl());
    }
    
    protected void callListenerOnAdFailedToLoad(final AdError adError, final boolean b) {
        new Handler(this.context.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                AdController.this.adListener.onAdFailedToLoad(AdController.this.adLayout, adError);
                AdController.this.submitAndResetMetricsIfNecessary(b);
            }
        });
    }
    
    protected AdListener createAdListener() {
        return new DefaultAdListener("AdController");
    }
    
    protected AdRenderer createAdRendererFromFactory(final AdData$AAXCreative adData$AAXCreative, final AdRenderer adRenderer) {
        final AdRendererFactory adRendererFactory = new AdRendererFactory();
        if (adRendererFactory.shouldCreateNewRenderer(adData$AAXCreative, adRenderer)) {
            Log.d("AdController", "Creating new renderer");
            if (adRenderer != null) {
                adRenderer.destroy();
            }
            if (this.webView == null) {
                this.createAndCacheWebView();
            }
            final AdRenderer adRenderer2 = adRendererFactory.getAdRenderer(adData$AAXCreative, this.adData, this, this.webView, this.context);
            this.webView = null;
            return adRenderer2;
        }
        Log.d("AdController", "Re-using renderer");
        adRenderer.setAd(this.adData);
        return adRenderer;
    }
    
    @Override
    public void destroy() {
        this.destroyCurrentAdRenderer();
    }
    
    protected AdData getAdData() {
        return this.adData;
    }
    
    @Override
    public AdLayout getAdLayout() {
        return this.adLayout;
    }
    
    protected AdListener getAdListener() {
        return this.adListener;
    }
    
    @Override
    public AdSize getAdSize() {
        return this.adSize;
    }
    
    protected Context getContext() {
        return this.context;
    }
    
    protected AdRenderer getCurrentAdRenderer() {
        return this.currentAdRenderer;
    }
    
    @Override
    public String getMaxSize() {
        if (!this.adSize.isAuto()) {
            return null;
        }
        return getAsSizeString(this.getWindowWidth(), this.getWindowHeight());
    }
    
    @Override
    public AdWebViewClient$UrlExecutor getSpecialUrlExecutor() {
        return new AdWebViewClient$AmazonMobileExecutor(this.currentAdRenderer, this.context);
    }
    
    @Override
    public int getTimeout() {
        return this.timeout;
    }
    
    @Override
    public int getWindowHeight() {
        return this.adWindowHeight;
    }
    
    @Override
    public int getWindowWidth() {
        return this.adWindowWidth;
    }
    
    @Override
    public void handleResponse() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.removeView();
        }
        if (this.adData == null) {
            Log.d("AdController", "We are unable to load the ad due to an internal error.");
            this.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "We are unable to load the ad due to an internal error."));
            return;
        }
        if (this.adData.getCreativeTypes() != null && !this.adData.getCreativeTypes().isEmpty()) {
            final AdData$AAXCreative topCreative = AdData$AAXCreative.getTopCreative(this.adData.getCreativeTypes());
            if (topCreative != null) {
                this.prepareRenderer(topCreative);
                return;
            }
        }
        Log.d("AdController", "There were no valid creative types returned, and we are unable to load the ad.");
        this.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "There were no valid creative types returned, and we are unable to load the ad."));
    }
    
    @Override
    public boolean isAdExpanded() {
        return this.currentAdRenderer != null && this.currentAdRenderer.getAdState(AdRenderer$AdState.valueOf("EXPANDED"));
    }
    
    @Override
    public boolean isAdLoading() {
        return this.isLoading;
    }
    
    @Override
    public void prepareAd(final long n) {
        this.setNewAdData();
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, n);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, n);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, n);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, n);
        if (this.adSize.isAuto()) {
            this.getAdData().setMaxSize(this.getMaxSize());
        }
        this.isLoading = true;
        if (DeviceInfo.getUserAgentString() == null) {
            final Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (DeviceInfo.getUserAgentString() == null) {
                            AdController.this.retrieveAndSetUserAgentString();
                        }
                    }
                });
                return;
            }
            this.retrieveAndSetUserAgentString();
        }
    }
    
    @Override
    public void prepareToGoAway() {
        if (this.currentAdRenderer != null) {
            this.currentAdRenderer.prepareToGoAway();
        }
    }
    
    @Override
    public boolean sendCommand(final String s, final HashMap hashMap) {
        return this.currentAdRenderer != null && this.currentAdRenderer.sendCommand(s, hashMap);
    }
    
    protected void setAdData(final AdData adData) {
        this.adData = adData;
    }
    
    protected void setAdditionalMetrics() {
        AdUtils.setConnectionMetrics(this.getAdData());
        if (this.getAdLayout().isParentViewMissingAtLoadTime()) {
            this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_PARENT_VIEW_MISSING);
        }
        if (this.getWindowHeight() == 0) {
            this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.ADLAYOUT_HEIGHT_ZERO);
        }
        if (this.currentAdRenderer != null) {
            this.getAdData().getMetricsCollector().setMetricString(Metrics$MetricType.VIEWPORT_SCALE, this.currentAdRenderer.getScalingMultiplierDescription());
        }
    }
    
    @Override
    public void setListener(final AdListener adListener) {
        if (adListener == null) {
            this.adListener = this.createAdListener();
            return;
        }
        this.adListener = adListener;
    }
    
    protected void setNewAdData() {
        this.setAdData(new AdData(this.adSize));
    }
    
    @Override
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
    
    @Override
    public void setWindowDimensions(final int adWindowWidth, final int adWindowHeight) {
        this.adWindowWidth = adWindowWidth;
        this.adWindowHeight = adWindowHeight;
    }
    
    @Override
    public boolean shouldDisableWebViewHardwareAcceleration() {
        return this.getAdLayout().shouldDisableWebViewHardwareAcceleration();
    }
}
