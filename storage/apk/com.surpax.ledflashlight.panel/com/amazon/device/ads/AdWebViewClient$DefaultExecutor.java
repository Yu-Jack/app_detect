// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.net.Uri;
import java.util.Iterator;
import android.os.Build$VERSION;
import java.util.HashMap;
import android.content.Context;
import java.util.Set;
import java.util.HashSet;
import android.webkit.WebViewClient;

class AdWebViewClient$DefaultExecutor implements AdWebViewClient$UrlExecutor
{
    final /* synthetic */ AdWebViewClient this$0;
    
    AdWebViewClient$DefaultExecutor(final AdWebViewClient this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean execute(final String s) {
        this.this$0.adView.launchExternalBrowserForLink(s);
        return true;
    }
}
