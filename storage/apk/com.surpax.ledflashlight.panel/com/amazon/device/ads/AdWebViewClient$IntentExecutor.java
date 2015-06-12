// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.webkit.WebView;
import java.util.Iterator;
import android.os.Build$VERSION;
import java.util.HashMap;
import android.content.Context;
import java.util.Set;
import java.util.HashSet;
import android.webkit.WebViewClient;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;

class AdWebViewClient$IntentExecutor implements AdWebViewClient$UrlExecutor
{
    final /* synthetic */ AdWebViewClient this$0;
    
    AdWebViewClient$IntentExecutor(final AdWebViewClient this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean execute(final String s) {
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(268435456);
        try {
            this.this$0.context.startActivity(intent);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            Log.w(AdWebViewClient.LOG_TAG, "Could not handle intent with URI: %s", s);
            return true;
        }
    }
}
