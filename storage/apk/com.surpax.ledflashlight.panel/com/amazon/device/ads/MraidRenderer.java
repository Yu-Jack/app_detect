// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import android.annotation.SuppressLint;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.webkit.WebView;

class MraidRenderer extends AdRenderer implements MraidView$OnCloseListener, MraidView$OnExpandListener, MraidView$OnReadyListener, MraidView$OnSpecialUrlClickListener
{
    private static final String LOG_TAG = "MraidRenderer";
    protected MraidView mraidView_;
    private WebView webView_;
    
    protected MraidRenderer(final AdData adData, final IAdController adController, final WebView webView_, final Context context) {
        super(adData, adController, context);
        this.webView_ = webView_;
    }
    
    @Override
    protected void adLoaded(final AdProperties adProperties) {
        super.adLoaded(adProperties);
    }
    
    protected MraidView createNewMraidView() {
        return new MraidView(this, this.controller.getWindowWidth(), this.controller.getWindowHeight(), this.getScalingMultiplier(), this.context, this.webView_);
    }
    
    @Override
    protected void destroy() {
        if (this.mraidView_ != null) {
            this.mraidView_.destroy();
            this.mraidView_ = null;
            this.isDestroyed = true;
        }
        this.webView_ = null;
    }
    
    @Override
    protected boolean getAdState(final AdRenderer$AdState adRenderer$AdState) {
        if (this.mraidView_ == null) {
            Log.w("MraidRenderer", "Unable to retrieve ad state.");
            return false;
        }
        switch (adRenderer$AdState) {
            default: {
                return false;
            }
            case EXPANDED: {
                return this.mraidView_.getDisplayController().isExpanded();
            }
        }
    }
    
    @Override
    public boolean launchExternalBrowserForLink(final String s) {
        return this.isAdViewRenderable() && AdUtils.launchActivityForIntentLink(s, this.context);
    }
    
    @Override
    public void onClose(final MraidView mraidView, final MraidView$ViewState mraidView$ViewState) {
        if (!this.isAdViewRemoved()) {
            this.controller.adClosedExpansion();
        }
    }
    
    @Override
    public void onExpand(final MraidView mraidView) {
        if (!this.isAdViewRemoved()) {
            this.controller.adExpanded();
        }
    }
    
    @Override
    public void onPageFinished() {
        if (this.mraidView_ == null) {
            Log.w("MraidRenderer", "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.mraidView_.onPageFinished();
    }
    
    @Override
    public void onReady(final MraidView mraidView) {
        this.adLoaded(this.adData.getProperties());
    }
    
    @Override
    public void onSpecialUrlClick(final MraidView mraidView, final String s) {
        if (this.isAdViewRenderable()) {
            this.getSpecialUrlExecutor().execute(s);
        }
    }
    
    @Override
    protected void prepareToGoAway() {
        if (this.mraidView_ != null) {
            this.mraidView_.prepareToGoAway();
        }
    }
    
    @Override
    protected void removeView() {
        if (this.viewRemoved || this.isDestroyed) {
            return;
        }
        while (true) {
            try {
                this.controller.getAdLayout().removeAllViews();
                this.viewRemoved = true;
            }
            catch (NullPointerException ex) {
                continue;
            }
            break;
        }
    }
    
    @Override
    protected boolean render() {
        if (!this.isAdViewDestroyed()) {
            this.mraidView_ = this.createNewMraidView();
            if (!this.mraidView_.getShouldForceRenderFailure() && this.mraidView_.loadHtmlData(this.adData.getCreative())) {
                this.renderMraidView();
                return true;
            }
        }
        return false;
    }
    
    @SuppressLint({ "InlinedApi" })
    protected void renderMraidView() {
        this.mraidView_.setOnReadyListener(this);
        this.mraidView_.setOnSpecialUrlClickListener(this);
        this.mraidView_.setOnExpandListener(this);
        this.mraidView_.setOnCloseListener(this);
        this.controller.getAdLayout().removeAllViews();
        this.controller.getAdLayout().addView((View)this.mraidView_, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1, 17));
    }
    
    @Override
    protected boolean sendCommand(final String s, final Map map) {
        Log.d("MraidRenderer", "sendCommand: %s", s);
        if (s.equals("close") && this.mraidView_ != null && this.mraidView_.getDisplayController().isExpanded()) {
            this.mraidView_.getDisplayController().close();
            return true;
        }
        return false;
    }
    
    @Override
    protected boolean shouldReuse() {
        return false;
    }
}
