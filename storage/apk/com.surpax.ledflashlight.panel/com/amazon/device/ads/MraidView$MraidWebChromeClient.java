// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import java.util.ArrayList;
import android.os.Build$VERSION;
import android.view.View;
import android.webkit.WebViewClient;
import android.content.Context;
import java.util.HashMap;
import android.annotation.SuppressLint;
import android.widget.FrameLayout;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.webkit.WebChromeClient;

public class MraidView$MraidWebChromeClient extends WebChromeClient
{
    final /* synthetic */ MraidView this$0;
    
    protected MraidView$MraidWebChromeClient(final MraidView this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onJsAlert(final WebView webView, final String s, final String s2, final JsResult jsResult) {
        Log.d(MraidView.LOGTAG, s2);
        return false;
    }
}
