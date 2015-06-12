// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebViewClient;
import java.util.Map;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.os.Build$VERSION;
import android.content.Context;
import android.webkit.WebView;

class HtmlRenderer extends AdRenderer
{
    public static final String LOG_TAG;
    protected WebView adView_;
    protected boolean hasLoadedAd;
    protected boolean shouldForceRenderFailure;
    
    static {
        LOG_TAG = HtmlRenderer.class.getSimpleName();
    }
    
    protected HtmlRenderer(final AdData adData, final IAdController adController, final WebView adView_, final Context context) {
        super(adData, adController, context);
        this.hasLoadedAd = false;
        this.shouldForceRenderFailure = false;
        this.adView_ = adView_;
        this.setupAdView();
        if (Build$VERSION.SDK_INT >= 11 && this.controller.shouldDisableWebViewHardwareAcceleration()) {
            this.disableHardwareAcceleration();
        }
    }
    
    @Override
    protected void adLoaded(final AdProperties adProperties) {
        this.controller.getAdLayout().addView((View)this.adView_, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-2, -2, 17));
        super.adLoaded(adProperties);
    }
    
    @Override
    protected void destroy() {
        if (this.isAdViewNull()) {
            Log.w(HtmlRenderer.LOG_TAG, "Called destroy(), but view is already null.");
        }
        else {
            this.adView_.destroy();
            this.adView_ = null;
        }
        this.isDestroyed = true;
    }
    
    protected void disableHardwareAcceleration() {
        AndroidTargetUtils.disableHardwareAcceleration((View)this.adView_);
    }
    
    @Override
    protected boolean getAdState(final AdRenderer$AdState adRenderer$AdState) {
        return false;
    }
    
    @Override
    public void initialize() {
        this.setupAdView();
        super.initialize();
    }
    
    protected boolean isAdViewNull() {
        return this.adView_ == null;
    }
    
    @Override
    public boolean launchExternalBrowserForLink(final String s) {
        AdUtils.launchActivityForIntentLink(s, this.context);
        return true;
    }
    
    @Override
    public void onPageFinished() {
        if (!this.isDestroyed && !this.hasLoadedAd) {
            this.hasLoadedAd = true;
            this.adLoaded(this.adData.getProperties());
        }
    }
    
    @Override
    protected void prepareToGoAway() {
    }
    
    @Override
    protected void removeView() {
        if (this.controller.getAdLayout() != null) {
            this.controller.getAdLayout().removeView((View)this.adView_);
        }
        this.viewRemoved = true;
    }
    
    @Override
    protected boolean render() {
        if (this.isAdViewNull() || this.isAdViewDestroyed() || this.shouldForceRenderFailure) {
            return false;
        }
        this.renderAdView();
        return true;
    }
    
    protected void renderAdView() {
        this.adView_.loadUrl("about:blank");
        this.hasLoadedAd = false;
        this.adView_.loadDataWithBaseURL("http://amazon-adsystem.amazon.com/", ("<html><meta name=\"viewport\" content=\"width=" + this.controller.getWindowWidth() + ", height=" + this.controller.getWindowHeight() + ", initial-scale=" + AdUtils.getViewportInitialScale(this.getScalingMultiplier()) + ", minimum-scale=" + this.getScalingMultiplier() + ", maximum-scale=" + this.getScalingMultiplier() + "\">" + this.adData.getCreative() + "</html>").replace("<head>", "<head><script type=\"text/javascript\">htmlWillCallFinishLoad = 1;</script>"), "text/html", "utf-8", (String)null);
    }
    
    @Override
    protected boolean sendCommand(final String s, final Map map) {
        return true;
    }
    
    protected void setupAdView() {
        boolean shouldForceRenderFailure = true;
        this.adView_.setHorizontalScrollBarEnabled(false);
        this.adView_.setHorizontalScrollbarOverlay(false);
        this.adView_.setVerticalScrollBarEnabled(false);
        this.adView_.setVerticalScrollbarOverlay(false);
        this.adView_.getSettings().setSupportZoom(false);
        if (WebViewFactory.setJavaScriptEnabledForWebView(shouldForceRenderFailure, this.adView_, HtmlRenderer.LOG_TAG)) {
            shouldForceRenderFailure = false;
        }
        this.shouldForceRenderFailure = shouldForceRenderFailure;
        this.adView_.setBackgroundColor(0);
        final AdWebViewClient webViewClient = new AdWebViewClient(this, this.context);
        webViewClient.putUrlExecutor("amazonmobile", this.controller.getSpecialUrlExecutor());
        this.adView_.setWebViewClient((WebViewClient)webViewClient);
    }
    
    @Override
    protected boolean shouldReuse() {
        return true;
    }
}
