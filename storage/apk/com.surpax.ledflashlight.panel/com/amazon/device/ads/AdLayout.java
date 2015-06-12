// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebViewDatabase;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.IntentFilter;
import java.util.HashMap;
import android.content.Intent;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.widget.TextView;
import java.util.Locale;
import android.util.AttributeSet;
import android.app.Activity;
import java.util.concurrent.TimeUnit;
import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import android.widget.FrameLayout;

public class AdLayout extends FrameLayout implements Ad
{
    public static final int DEFAULT_TIMEOUT = 20000;
    private static final String LOG_TAG = "AdLayout";
    private static ScheduledThreadPoolExecutor threadPool;
    private View activityRootView;
    private AdSize adSize;
    private boolean attached;
    private Context context;
    private IAdController controller;
    private boolean hasPassedActivityValidationCheck;
    private boolean hasRegisterBroadcastReciever;
    private boolean isInForeground;
    private boolean isParentViewMissingAtLoadTime;
    private int lastVisibility;
    private AdLoader$AdReadyToLoadListener listenerOnLayout;
    private long loadAdStartTime;
    private AtomicBoolean needsToLoadAdOnLayout;
    private BroadcastReceiver screenStateReceiver;
    private boolean shouldDisableWebViewHardwareAcceleration;
    
    static {
        (AdLayout.threadPool = new ScheduledThreadPoolExecutor(1)).setKeepAliveTime(60L, TimeUnit.SECONDS);
    }
    
    public AdLayout(final Activity activity) {
        this(activity, AdSize.SIZE_AUTO);
    }
    
    public AdLayout(final Activity activity, final AdSize adSize) {
        super((Context)activity);
        this.hasRegisterBroadcastReciever = false;
        this.attached = false;
        this.lastVisibility = 8;
        this.needsToLoadAdOnLayout = new AtomicBoolean(false);
        this.listenerOnLayout = null;
        this.isParentViewMissingAtLoadTime = false;
        this.activityRootView = null;
        this.hasPassedActivityValidationCheck = false;
        this.loadAdStartTime = 0L;
        this.initialize((Context)activity, adSize);
    }
    
    public AdLayout(final Context context, final AttributeSet set) {
        super(context, set);
        this.hasRegisterBroadcastReciever = false;
        this.attached = false;
        this.lastVisibility = 8;
        this.needsToLoadAdOnLayout = new AtomicBoolean(false);
        this.listenerOnLayout = null;
        this.isParentViewMissingAtLoadTime = false;
        this.activityRootView = null;
        this.hasPassedActivityValidationCheck = false;
        this.loadAdStartTime = 0L;
        this.initialize(context, set);
    }
    
    public AdLayout(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.hasRegisterBroadcastReciever = false;
        this.attached = false;
        this.lastVisibility = 8;
        this.needsToLoadAdOnLayout = new AtomicBoolean(false);
        this.listenerOnLayout = null;
        this.isParentViewMissingAtLoadTime = false;
        this.activityRootView = null;
        this.hasPassedActivityValidationCheck = false;
        this.loadAdStartTime = 0L;
        this.initialize(context, set);
    }
    
    AdLayout(final IAdController controller) {
        super((Context)null);
        this.hasRegisterBroadcastReciever = false;
        this.attached = false;
        this.lastVisibility = 8;
        this.needsToLoadAdOnLayout = new AtomicBoolean(false);
        this.listenerOnLayout = null;
        this.isParentViewMissingAtLoadTime = false;
        this.activityRootView = null;
        this.hasPassedActivityValidationCheck = false;
        this.loadAdStartTime = 0L;
        this.controller = controller;
        this.initialize(null, (AdSize)null);
    }
    
    private static String getAttributeValue(final AttributeSet set, final String s, final String s2) {
        return set.getAttributeValue(s, s2);
    }
    
    private void initialize(final Context context, final AttributeSet set) {
        String s = getAttributeValue(set, "http://schemas.android.com/apk/lib/com.amazon.device.ads", "adSize");
        if (s == null) {
            s = getAttributeValue(set, "http://schemas.android.com/apk/res/" + context.getPackageName(), "adSize");
            if (s != null) {
                Log.w(true, "AdLayout", "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties.");
                if (s.toLowerCase(Locale.US).equals("custom")) {
                    Log.e(true, "AdLayout", "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                    throw new IllegalArgumentException("Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                }
            }
        }
        this.initialize(context, parseAdSize(s));
    }
    
    private void initialize(final Context context, AdSize size_AUTO) {
        InternalAdRegistration.getInstance().contextReceived(context);
        if (size_AUTO == null) {
            size_AUTO = AdSize.SIZE_AUTO;
        }
        this.adSize = size_AUTO;
        this.context = context;
        if (this.isInEditMode()) {
            final TextView textView = new TextView(this.context);
            textView.setText((CharSequence)"AdLayout");
            textView.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
            textView.setGravity(17);
            this.addView((View)textView);
            return;
        }
        this.isInForeground = (this.getVisibility() == 0);
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
        if (this.isWebViewDatabaseNull(this.context)) {
            Log.e(true, "AdLayout", "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        if (this.controller == null) {
            this.controller = this.createAdController(this.adSize, this.context);
        }
        this.hasPassedActivityValidationCheck = AdUtils.checkDefinedActivities(this.context);
    }
    
    private void loadAdWhenParentViewMissing(final AdLoader$AdReadyToLoadListener onLayoutChangeListenerForRoot) {
        if (this.getLayoutParams() == null) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_NULL_LAYOUT_PARAMS);
            this.onRequestError("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
            return;
        }
        if (!Utils.isAtLeastAndroidAPI(11)) {
            this.setFloatingWindowDimensions();
            this.loadAdFromAdController(onLayoutChangeListenerForRoot);
            return;
        }
        this.setActivityRootView();
        if (this.isActivityRootViewNull()) {
            this.onRequestError("Ad load failed because root view could not be obtained from the activity.");
            return;
        }
        if (this.isActivityRootViewLayoutRequested()) {
            this.deferAdLoadToLayoutEvent(onLayoutChangeListenerForRoot);
            this.setOnLayoutChangeListenerForRoot(onLayoutChangeListenerForRoot);
            return;
        }
        this.setFloatingWindowDimensions();
        this.loadAdFromAdController(onLayoutChangeListenerForRoot);
    }
    
    private static AdSize parseAdSize(final String s) {
        final AdSize size_AUTO = AdSize.SIZE_AUTO;
        if (s != null) {
            final String lowerCase = s.toLowerCase(Locale.US);
            if (!lowerCase.equals("auto")) {
                final String[] split = lowerCase.split("x");
                int int1;
                int int2;
                if (split.length == 2) {
                    int1 = Utils.parseInt(split[0], 0);
                    int2 = Utils.parseInt(split[1], 0);
                }
                else {
                    int2 = 0;
                    int1 = 0;
                }
                return new AdSize(int1, int2);
            }
        }
        return size_AUTO;
    }
    
    private void registerScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever) {
            return;
        }
        this.hasRegisterBroadcastReciever = true;
        this.screenStateReceiver = new BroadcastReceiver() {
            public void onReceive(final Context context, final Intent intent) {
                if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && AdLayout.this.isInForeground) {
                    AdLayout.this.controller.sendCommand("close", null);
                }
            }
        };
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.context.getApplicationContext().registerReceiver(this.screenStateReceiver, intentFilter);
    }
    
    private void unregisterScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever) {
            this.hasRegisterBroadcastReciever = false;
            this.context.getApplicationContext().unregisterReceiver(this.screenStateReceiver);
        }
    }
    
    public boolean collapseAd() {
        return this.controller.sendCommand("close", null);
    }
    
    IAdController createAdController(final AdSize adSize, final Context context) {
        return new AdController(this, adSize, context);
    }
    
    void deferAdLoadToLayoutEvent(final AdLoader$AdReadyToLoadListener listenerOnLayout) {
        this.needsToLoadAdOnLayout.set(true);
        this.listenerOnLayout = listenerOnLayout;
        this.scheduleTaskForCheckingIfLayoutHasRun();
    }
    
    public void destroy() {
        Log.d("AdLayout", "Destroying the AdLayout");
        this.unregisterScreenStateBroadcastReceiver();
        this.controller.destroy();
    }
    
    void failLoadIfLayoutHasNotRun() {
        if (this.needsToLoadAdOnLayout.getAndSet(false)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_LAYOUT_NOT_RUN);
            this.onRequestError("Can't load an ad because the view size cannot be determined.");
        }
    }
    
    View getActivityRootView() {
        return this.activityRootView;
    }
    
    int getActivityRootViewDimension(final boolean b) {
        if (b) {
            return this.activityRootView.getWidth();
        }
        return this.activityRootView.getHeight();
    }
    
    AdController getAdController() {
        return (AdController)this.controller;
    }
    
    public AdSize getAdSize() {
        return this.adSize;
    }
    
    boolean getNeedsToLoadAdOnLayout() {
        return this.needsToLoadAdOnLayout.get();
    }
    
    int getRawScreenDimension(final boolean b) {
        final WindowManager windowManager = (WindowManager)this.context.getSystemService("window");
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (b) {
            return displayMetrics.widthPixels;
        }
        return displayMetrics.heightPixels;
    }
    
    public int getTimeout() {
        return this.controller.getTimeout();
    }
    
    boolean isActivityRootViewLayoutRequested() {
        return this.activityRootView.isLayoutRequested();
    }
    
    boolean isActivityRootViewNull() {
        return this.activityRootView == null;
    }
    
    public boolean isAdLoading() {
        return this.isLoading();
    }
    
    public boolean isLoading() {
        return this.controller.isAdLoading();
    }
    
    boolean isParentViewMissingAtLoadTime() {
        return this.isParentViewMissingAtLoadTime;
    }
    
    boolean isWebViewDatabaseNull(final Context context) {
        return WebViewDatabase.getInstance(context) == null;
    }
    
    boolean isWebViewOk(final Context context) {
        return WebViewFactory.isWebViewOk(context);
    }
    
    public boolean loadAd() {
        return this.loadAd(new AdTargetingOptions());
    }
    
    public boolean loadAd(AdTargetingOptions adTargetingOptions) {
        if (adTargetingOptions == null) {
            adTargetingOptions = new AdTargetingOptions();
        }
        return AdLoader.loadAds(this.controller.getTimeout(), adTargetingOptions, new AdSlot(this, adTargetingOptions))[0];
    }
    
    void loadAdFromAdController(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        this.controller.prepareAd(this.loadAdStartTime);
        adLoader$AdReadyToLoadListener.onAdReady(this);
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isInEditMode()) {
            return;
        }
        this.attached = true;
        this.registerScreenStateBroadcastReceiver();
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
        this.unregisterScreenStateBroadcastReceiver();
        this.controller.prepareToGoAway();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int n5 = n3 - n;
        final int n6 = n4 - n2;
        super.onLayout(b, n, n2, n3, n4);
        if (!this.isInEditMode()) {
            this.controller.setWindowDimensions(n5, n6);
            if (this.needsToLoadAdOnLayout.getAndSet(false)) {
                this.loadAdFromAdController(this.listenerOnLayout);
                this.listenerOnLayout = null;
            }
        }
    }
    
    void onRequestError(final String s) {
        Log.e("AdLayout", s);
        ((IAdLoaderCallback)this.controller).adFailed(new AdError(AdError$ErrorCode.REQUEST_ERROR, s));
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        if (this.attached && this.lastVisibility != n) {
            if (n != 0) {
                this.isInForeground = false;
                this.unregisterScreenStateBroadcastReceiver();
            }
            else if (n == 0) {
                this.isInForeground = true;
            }
        }
    }
    
    protected boolean passesInternetPermissionCheck(final Context context) {
        return PermissionChecker.getInstance().passesInternetPermissionCheck(context);
    }
    
    int prepareAd(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        this.loadAdStartTime = System.nanoTime();
        if (this.controller.isAdLoading() || this.needsToLoadAdOnLayout.get()) {
            Log.e("AdLayout", "Can't load an ad because ad loading is already in progress");
            return -1;
        }
        if (this.controller.isAdExpanded()) {
            Log.e("AdLayout", "Can't load an ad because another ad is currently expanded");
            return -1;
        }
        if (!this.hasPassedActivityValidationCheck) {
            this.onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return 1;
        }
        if (!this.passesInternetPermissionCheck(this.context)) {
            this.onRequestError("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
            return 1;
        }
        if (InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey() == null) {
            this.onRequestError("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
            return 1;
        }
        if (!this.isWebViewOk(this.context)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_FAILED_UNKNOWN_WEBVIEW_ISSUE);
            this.onRequestError("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
            return 1;
        }
        if (this.adSize.isAuto()) {
            Log.d("AdLayout", "Ad size to be determined automatically.");
        }
        this.setIsParentViewMissingAtLoadTime();
        if (this.isLayoutRequested() && this.adSize.isAuto() && !this.isParentViewMissingAtLoadTime()) {
            this.deferAdLoadToLayoutEvent(adLoader$AdReadyToLoadListener);
        }
        else if (this.isParentViewMissingAtLoadTime()) {
            this.loadAdWhenParentViewMissing(adLoader$AdReadyToLoadListener);
        }
        else {
            this.loadAdFromAdController(adLoader$AdReadyToLoadListener);
        }
        return 0;
    }
    
    int resolveLayoutParamForFloatingAd(final boolean b) {
        int n;
        if (b) {
            n = this.getLayoutParams().width;
        }
        else {
            n = this.getLayoutParams().height;
        }
        if (n == -1) {
            if (!this.isActivityRootViewNull()) {
                return this.getActivityRootViewDimension(b);
            }
            n = this.getRawScreenDimension(b);
        }
        else if (n == -2) {
            return 0;
        }
        return n;
    }
    
    void scheduleTaskForCheckingIfLayoutHasRun() {
        AdLayout.threadPool.schedule(new Runnable() {
            @Override
            public void run() {
                AdLayout.this.failLoadIfLayoutHasNotRun();
            }
        }, this.getTimeout(), TimeUnit.MILLISECONDS);
    }
    
    void setActivityRootView() {
        this.activityRootView = ((Activity)this.context).getWindow().getDecorView().findViewById(16908290).getRootView();
    }
    
    void setFloatingWindowDimensions() {
        this.controller.setWindowDimensions(this.resolveLayoutParamForFloatingAd(true), this.resolveLayoutParamForFloatingAd(false));
    }
    
    void setIsParentViewMissingAtLoadTime() {
        this.isParentViewMissingAtLoadTime = (this.getParent() == null);
    }
    
    void setIsParentViewMissingAtLoadTime(final boolean isParentViewMissingAtLoadTime) {
        this.isParentViewMissingAtLoadTime = isParentViewMissingAtLoadTime;
    }
    
    public void setListener(final AdListener listener) {
        this.controller.setListener(listener);
    }
    
    void setNeedsToLoadAdOnLayout(final boolean newValue) {
        this.needsToLoadAdOnLayout.set(newValue);
    }
    
    void setOnLayoutChangeListenerForRoot(final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener) {
        AdLayout$OnLayoutChangeListenerUtil.setOnLayoutChangeListenerForRoot(this, adLoader$AdReadyToLoadListener);
    }
    
    void setShouldDisableWebViewHardwareAcceleration(final boolean shouldDisableWebViewHardwareAcceleration) {
        this.shouldDisableWebViewHardwareAcceleration = shouldDisableWebViewHardwareAcceleration;
    }
    
    public void setTimeout(final int timeout) {
        this.controller.setTimeout(timeout);
    }
    
    boolean shouldDisableWebViewHardwareAcceleration() {
        return this.shouldDisableWebViewHardwareAcceleration;
    }
}
