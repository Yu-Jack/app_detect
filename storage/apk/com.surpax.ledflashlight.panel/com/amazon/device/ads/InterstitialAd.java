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

public class InterstitialAd implements Ad
{
    protected static final String ACTION_INTERSTITIAL_DISMISSED = "dismissed";
    protected static final String ACTION_INTERSTITIAL_FINISHED_LOADING = "finished";
    protected static final String BROADCAST_ACTION = "action";
    protected static final String BROADCAST_CREATIVE = "creative";
    protected static final String BROADCAST_INTENT = "amazon.mobile.ads.interstitial";
    protected static final String BROADCAST_UNIQUE_IDENTIFIER_KEY = "uniqueIdentifier";
    private static final String LOG_TAG = "InterstitialAd";
    protected static final String MSG_PREPARE_AD_DESTROYED = "This interstitial ad has been destroyed and can no longer be used. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_PREPARE_AD_LOADING = "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
    protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.";
    protected static final String MSG_PREPARE_AD_SHOWING = "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
    protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.";
    protected static final String MSG_SHOW_AD_DESTROYED = "The interstitial ad cannot be shown because it has been destroyed. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_SHOW_AD_DISMISSED = "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
    protected static final String MSG_SHOW_AD_EXPIRED = "This interstitial ad has expired. Please load another ad.";
    protected static final String MSG_SHOW_AD_LOADING = "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
    protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
    protected static final String MSG_SHOW_AD_SHOWING = "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.";
    private static final AtomicBoolean isAdShowing;
    private final Activity activity;
    private AdData adData;
    private AdListener adListener;
    private IAdLoaderCallback adLoaderCallback;
    private BroadcastReceiver broadcastReceiver;
    private final AtomicBoolean hasFinishedLoading;
    private boolean hasPassedActivityValidationCheck;
    private final AtomicBoolean isPrerendering;
    private MraidView mraidView;
    private InterstitialAd$State state;
    private int timeout;
    private Timer timer;
    private final String uniqueIdentifier;
    
    static {
        isAdShowing = new AtomicBoolean(false);
    }
    
    public InterstitialAd(final Activity activity) {
        this(activity, generateUniqueIdentifier());
    }
    
    InterstitialAd(final Activity activity, final String uniqueIdentifier) {
        this.adListener = null;
        this.adData = null;
        this.timeout = 20000;
        this.broadcastReceiver = null;
        this.isPrerendering = new AtomicBoolean(false);
        this.hasFinishedLoading = new AtomicBoolean(false);
        if (activity == null) {
            throw new IllegalArgumentException("InterstitialAd requires a non-null Activity");
        }
        this.activity = activity;
        this.uniqueIdentifier = uniqueIdentifier;
        this.adLoaderCallback = new InterstitialAd$InterstitialAdLoaderCallback(this, this);
        this.initialize();
    }
    
    private void failAd(final AdError adError) {
        this.setState(InterstitialAd$State.READY_TO_LOAD);
        final long nanoTime = System.nanoTime();
        if (this.getAdData() != null && this.getAdData().getMetricsCollector() != null) {
            this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, nanoTime);
            this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, nanoTime);
            this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, nanoTime);
            if (adError != null && (adError.getCode() == AdError$ErrorCode.NO_FILL || adError.getCode() == AdError$ErrorCode.NETWORK_ERROR || adError.getCode() == AdError$ErrorCode.NETWORK_TIMEOUT)) {
                this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED);
                if (adError.getCode() == AdError$ErrorCode.NETWORK_TIMEOUT) {
                    this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT);
                }
            }
        }
        this.callOnAdFailedToLoadOnMainThread(adError);
    }
    
    private static String generateUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }
    
    private void initialize() {
        InternalAdRegistration.getInstance().contextReceived(this.activity.getApplicationContext());
        this.setState(InterstitialAd$State.READY_TO_LOAD);
        this.adListener = new DefaultAdListener("InterstitialAd");
        this.hasPassedActivityValidationCheck = AdUtils.checkDefinedActivities(this.activity.getApplicationContext());
    }
    
    public static boolean isAdShowing() {
        return InterstitialAd.isAdShowing.get();
    }
    
    private void onRequestError(final String s) {
        Log.e("InterstitialAd", s);
        this.getAdLoaderCallback().adFailed(new AdError(AdError$ErrorCode.REQUEST_ERROR, s));
    }
    
    static void resetIsAdShowing() {
        InterstitialAd.isAdShowing.set(false);
    }
    
    private void setAdditionalMetrics() {
        this.getAdData().getMetricsCollector().setAdType(AdProperties$AdType.INTERSTITIAL);
        this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_IS_INTERSTITIAL);
        AdUtils.setConnectionMetrics(this.getAdData());
    }
    
    void callOnAdDismissed() {
        this.adListener.onAdDismissed(this);
    }
    
    void callOnAdDismissedOnMainThread() {
        new Handler(this.activity.getApplicationContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                InterstitialAd.this.callOnAdDismissed();
                InterstitialAd.this.submitAndResetMetrics();
            }
        });
    }
    
    void callOnAdFailedToLoad(final AdError adError) {
        this.adListener.onAdFailedToLoad(this, adError);
    }
    
    void callOnAdFailedToLoadOnMainThread(final AdError adError) {
        new Handler(this.activity.getApplicationContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                InterstitialAd.this.callOnAdFailedToLoad(adError);
                InterstitialAd.this.submitAndResetMetrics();
            }
        });
    }
    
    void callOnAdLoaded() {
        this.adListener.onAdLoaded(this, this.adData.getProperties());
    }
    
    void callOnAdLoadedOnMainThread() {
        new Handler(this.activity.getApplicationContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                InterstitialAd.this.callOnAdLoaded();
            }
        });
    }
    
    void cancelTimer() {
        this.timer.cancel();
    }
    
    MraidView constructMraidView(final WebView webView) {
        return new MraidView(new AdView() {
            @Override
            public int getHeight() {
                return 0;
            }
            
            @Override
            public AdWebViewClient$UrlExecutor getSpecialUrlExecutor() {
                return null;
            }
            
            @Override
            public boolean isAdViewRenderable() {
                return true;
            }
            
            @Override
            public boolean launchExternalBrowserForLink(final String s) {
                return false;
            }
            
            @Override
            public void onPageFinished() {
                final long nanoTime = System.nanoTime();
                InterstitialAd.this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, nanoTime);
                InterstitialAd.this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, nanoTime);
                InterstitialAd.this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, nanoTime);
                InterstitialAd.this.onAdPrerendered();
            }
            
            @Override
            public boolean shouldDisableWebViewHardwareAcceleration() {
                return false;
            }
        }, (Context)this.activity, webView);
    }
    
    void executePostActivityShown() {
        this.getAdLoaderCallback().adShown();
    }
    
    AdData getAdData() {
        return this.adData;
    }
    
    IAdLoaderCallback getAdLoaderCallback() {
        return this.adLoaderCallback;
    }
    
    boolean getAndSetHasFinishedLoading(final boolean newValue) {
        return this.hasFinishedLoading.getAndSet(newValue);
    }
    
    InterstitialAd$State getState() {
        return this.state;
    }
    
    @Override
    public int getTimeout() {
        return this.timeout;
    }
    
    void handleDismissed() {
        this.getAdData().getMetricsCollector().stopMetric(Metrics$MetricType.AD_SHOW_DURATION);
        this.setState(InterstitialAd$State.DISMISSED);
        InterstitialAd.isAdShowing.set(false);
        this.callOnAdDismissedOnMainThread();
        this.unregisterBroadcastReceiver();
    }
    
    void handlePageFinished() {
        this.getAdData().getMetricsCollector().stopMetric(Metrics$MetricType.AD_SHOW_LATENCY);
        this.executePostActivityShown();
        this.submitAndResetMetricsOnMainThreadAndStartMetric(Metrics$MetricType.AD_SHOW_DURATION, System.nanoTime());
    }
    
    boolean hasDismissed() {
        return this.getState() == InterstitialAd$State.DISMISSED;
    }
    
    boolean isExpired() {
        return this.getAdData().isExpired();
    }
    
    @Override
    public boolean isLoading() {
        return this.getState() == InterstitialAd$State.LOADING;
    }
    
    boolean isReadyToLoad() {
        return this.getState() == InterstitialAd$State.READY_TO_LOAD || this.hasDismissed();
    }
    
    boolean isReadyToShow() {
        return this.getState() == InterstitialAd$State.READY_TO_SHOW;
    }
    
    public boolean isShowing() {
        return this.getState() == InterstitialAd$State.SHOWING;
    }
    
    @Override
    public boolean loadAd() {
        return this.loadAd(null);
    }
    
    @Override
    public boolean loadAd(final AdTargetingOptions adTargetingOptions) {
        return AdLoader.loadAds(this.getTimeout(), adTargetingOptions, new AdSlot(this, adTargetingOptions))[0];
    }
    
    void loadHtml(final String s) {
        this.mraidView.loadHtmlData("http://amazon-adsystem.amazon.com/", s);
    }
    
    void onAdPrerendered() {
        if (this.mraidView != null) {
            this.mraidView.unregisterReceivers();
        }
        if (!this.getAndSetHasFinishedLoading(true)) {
            this.isPrerendering.set(false);
            this.cancelTimer();
            this.setState(InterstitialAd$State.READY_TO_SHOW);
            this.callOnAdLoadedOnMainThread();
            this.submitAndResetMetricsOnMainThreadAndStartMetric(Metrics$MetricType.AD_LOADED_TO_AD_SHOW_TIME, System.nanoTime());
        }
    }
    
    void onAdTimedOut() {
        final boolean value = this.isPrerendering.get();
        final MraidView removeCachedMraidView = MraidView.removeCachedMraidView(this.uniqueIdentifier);
        if (removeCachedMraidView != null) {
            new Handler(this.activity.getApplicationContext().getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public void run() {
                    removeCachedMraidView.destroy();
                }
            });
        }
        if (value) {
            this.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT);
        }
        this.failAd(new AdError(AdError$ErrorCode.NETWORK_ERROR, "Ad Load Timed Out"));
    }
    
    void onBroadcastReceived(final Intent intent) {
        if (this.uniqueIdentifier.equals(intent.getStringExtra("uniqueIdentifier")) && "amazon.mobile.ads.interstitial".equals(intent.getAction())) {
            final String stringExtra = intent.getStringExtra("action");
            if ("dismissed".equals(stringExtra)) {
                this.handleDismissed();
            }
            else if ("finished".equals(stringExtra)) {
                this.handlePageFinished();
            }
        }
    }
    
    int prepareAd(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        int n = 1;
        final long nanoTime = System.nanoTime();
        if (!this.hasPassedActivityValidationCheck) {
            this.onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return n;
        }
        if (!this.isReadyToLoad()) {
            if (this.isShowing()) {
                Log.e("InterstitialAd", "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.");
            }
            else if (this.isReadyToShow()) {
                if (this.getAdData() != null && this.getAdData().isExpired()) {
                    n = 0;
                }
                else {
                    Log.e("InterstitialAd", "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.");
                }
            }
            else if (this.isLoading()) {
                Log.e("InterstitialAd", "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.");
            }
            if (n != 0) {
                return -1;
            }
        }
        this.isPrerendering.set(false);
        this.setHasFinishedLoading(false);
        if (this.timer != null) {
            this.timer.purge();
        }
        (this.timer = new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                if (!InterstitialAd.this.getAndSetHasFinishedLoading(true)) {
                    InterstitialAd.this.onAdTimedOut();
                }
            }
        }, this.getTimeout());
        this.setState(InterstitialAd$State.LOADING);
        this.setAdData(new AdData(AdSize.SIZE_INTERSTITIAL));
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL, nanoTime);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_FAILURE, nanoTime);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_TOTAL_SUCCESS, nanoTime);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, nanoTime);
        adLoader$AdReadyToLoadListener.onAdReady(this);
        return 0;
    }
    
    void prerenderHtml() {
        this.isPrerendering.set(true);
        final String replace = AdUtils.encloseHtml(this.adData.getCreative(), true).replace("<head>", "<head>\n  <script type='text/javascript'>\n  var connectionType=\"" + this.adData.getConnectionType() + "\";\n  var screenWidth=" + this.adData.getScreenWidth() + ";\n  var screenHeight=" + this.adData.getScreenHeight() + ";\n  </script>\n");
        this.adData.setCreative(replace);
        final WebView webView = WebViewFactory.getInstance().createWebView((Context)this.activity);
        webView.setBackgroundColor(0);
        this.mraidView = this.constructMraidView(webView);
        final long nanoTime = System.nanoTime();
        this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, nanoTime);
        this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LATENCY_RENDER, nanoTime);
        this.loadHtml(replace);
    }
    
    void registerBroadcastReceiver() {
        this.broadcastReceiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                InterstitialAd.this.onBroadcastReceived(intent);
            }
        };
        this.activity.getApplicationContext().registerReceiver(this.broadcastReceiver, new IntentFilter("amazon.mobile.ads.interstitial"));
    }
    
    void setAdData(final AdData adData) {
        this.adData = adData;
    }
    
    void setAdLoaderCallback(final IAdLoaderCallback adLoaderCallback) {
        this.adLoaderCallback = adLoaderCallback;
    }
    
    void setHasFinishedLoading(final boolean newValue) {
        this.hasFinishedLoading.set(newValue);
    }
    
    @Override
    public void setListener(final AdListener adListener) {
        if (adListener == null) {
            this.adListener = new DefaultAdListener("InterstitialAd");
            return;
        }
        this.adListener = adListener;
    }
    
    void setState(final InterstitialAd$State state) {
        this.state = state;
    }
    
    @Override
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
    
    public boolean showAd() {
        final long nanoTime = System.nanoTime();
        if (this.isReadyToShow()) {
            if (this.isExpired()) {
                Log.w("InterstitialAd", "This interstitial ad has expired. Please load another ad.");
                this.setState(InterstitialAd$State.READY_TO_LOAD);
            }
            else {
                if (InterstitialAd.isAdShowing.getAndSet(true)) {
                    Log.w("InterstitialAd", "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.");
                    return false;
                }
                this.getAdData().getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_LOADED_TO_AD_SHOW_TIME, nanoTime);
                this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics$MetricType.AD_SHOW_LATENCY, nanoTime);
                this.registerBroadcastReceiver();
                MraidView.cacheMraidView(this.uniqueIdentifier, this.mraidView);
                this.mraidView = null;
                final boolean showAdInActivity = this.showAdInActivity();
                if (showAdInActivity) {
                    this.setState(InterstitialAd$State.SHOWING);
                }
                else {
                    MraidView.removeCachedMraidView(this.uniqueIdentifier);
                    this.unregisterBroadcastReceiver();
                    this.setState(InterstitialAd$State.READY_TO_LOAD);
                    InterstitialAd.isAdShowing.set(false);
                    this.getAdData().getMetricsCollector().stopMetric(Metrics$MetricType.AD_LATENCY_RENDER_FAILED);
                }
                return showAdInActivity;
            }
        }
        else {
            if (this.hasDismissed()) {
                Log.w("InterstitialAd", "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.");
                return false;
            }
            if (this.isReadyToLoad()) {
                Log.w("InterstitialAd", "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.");
                return false;
            }
            if (this.isLoading()) {
                Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.");
                return false;
            }
            if (this.isShowing()) {
                Log.w("InterstitialAd", "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.");
                return false;
            }
        }
        return false;
    }
    
    boolean showAdInActivity() {
        try {
            final Intent intent = new Intent(this.activity.getApplicationContext(), (Class)AdActivity.class);
            intent.putExtra("adapter", InterstitialAdActivityAdapter.class.getName());
            intent.putExtra("uniqueIdentifier", this.uniqueIdentifier);
            intent.putExtra("creative", this.adData.getCreative());
            this.activity.startActivity(intent);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            Log.e("InterstitialAd", "Failed to show the interstitial ad because AdActivity could not be found.");
            return false;
        }
    }
    
    protected void submitAndResetMetrics() {
        if (this.getAdData() != null && this.getAdData().getMetricsCollector() != null && !this.getAdData().getMetricsCollector().isMetricsCollectorEmpty()) {
            this.setAdditionalMetrics();
            Metrics.getInstance().submitAndResetMetrics(this.getAdData());
        }
    }
    
    void submitAndResetMetricsOnMainThread() {
        this.submitAndResetMetricsOnMainThreadAndStartMetric(null, 0L);
    }
    
    void submitAndResetMetricsOnMainThreadAndStartMetric(final Metrics$MetricType metrics$MetricType, final long n) {
        new Handler(this.activity.getApplicationContext().getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                InterstitialAd.this.submitAndResetMetrics();
                if (metrics$MetricType != null) {
                    InterstitialAd.this.getAdData().getMetricsCollector().startMetricInMillisecondsFromNanoseconds(metrics$MetricType, n);
                }
            }
        });
    }
    
    void unregisterBroadcastReceiver() {
        this.activity.getApplicationContext().unregisterReceiver(this.broadcastReceiver);
        this.broadcastReceiver = null;
    }
}
