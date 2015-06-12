// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.Context;
import android.webkit.WebView;

class AdRendererFactory
{
    public static final String LOG_TAG = "AdRendererFactory";
    
    protected AdRenderer createHtmlRenderer(final AdData adData, final AdController adController, final WebView webView, final Context context) {
        return new HtmlRenderer(adData, adController, webView, context);
    }
    
    protected AdRenderer createMraidRenderer(final AdData adData, final AdController adController, final WebView webView, final Context context) {
        return new MraidRenderer(adData, adController, webView, context);
    }
    
    public AdRenderer getAdRenderer(final AdData$AAXCreative adData$AAXCreative, final AdData adData, final AdController adController, final WebView webView, final Context context) {
        switch (adData$AAXCreative) {
            default: {
                return null;
            }
            case HTML: {
                return this.createHtmlRenderer(adData, adController, webView, context);
            }
            case MRAID1: {
                return this.createMraidRenderer(adData, adController, webView, context);
            }
        }
    }
    
    protected Class getAdRendererClass(final AdData$AAXCreative adData$AAXCreative) {
        switch (adData$AAXCreative) {
            default: {
                return null;
            }
            case HTML: {
                return HtmlRenderer.class;
            }
            case MRAID1: {
                return MraidRenderer.class;
            }
        }
    }
    
    public boolean shouldCreateNewRenderer(final AdData$AAXCreative adData$AAXCreative, final AdRenderer adRenderer) {
        return adRenderer == null || !adRenderer.shouldReuse() || adRenderer.getClass() != this.getAdRendererClass(adData$AAXCreative);
    }
}
