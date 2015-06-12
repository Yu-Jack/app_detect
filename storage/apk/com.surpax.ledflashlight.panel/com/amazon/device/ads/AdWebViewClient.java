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

class AdWebViewClient extends WebViewClient
{
    public static final String AMAZON_MOBILE = "amazonmobile";
    public static final String GEO = "geo";
    public static final String GOOGLE_STREETVIEW = "google.streetview";
    private static final String LOG_TAG;
    public static final String MAILTO = "mailto";
    public static final String MOPUB = "mopub";
    public static final String MRAID = "mraid";
    public static final String SMS = "sms";
    public static final String TELEPHONE = "tel";
    public static final String VOICEMAIL = "voicemail";
    protected static final HashSet intentSchemes;
    protected static Set redirectHosts;
    private final AdView adView;
    private final Context context;
    private final HashMap urlExecutors;
    
    static {
        LOG_TAG = AdWebViewClient.class.getSimpleName();
        (intentSchemes = new HashSet()).add("tel");
        AdWebViewClient.intentSchemes.add("voicemail");
        AdWebViewClient.intentSchemes.add("sms");
        AdWebViewClient.intentSchemes.add("mailto");
        AdWebViewClient.intentSchemes.add("geo");
        AdWebViewClient.intentSchemes.add("google.streetview");
        (AdWebViewClient.redirectHosts = new HashSet()).add("aax-us-east.amazon-adsystem.com");
        AdWebViewClient.redirectHosts.add("aax-us-east.amazon-adsystem.com");
        AdWebViewClient.redirectHosts.add("aax-beta.integ.amazon.com");
        AdWebViewClient.redirectHosts.add("pda-bes.amazon.com");
        AdWebViewClient.redirectHosts.add("d16g-cornerstone-bes.integ.amazon.com");
    }
    
    public AdWebViewClient(final AdView adView, final Context context) {
        this.context = context;
        this.adView = adView;
        this.urlExecutors = new HashMap();
        this.setupUrlExecutors();
    }
    
    private static boolean isHoneycombVersion() {
        return Build$VERSION.SDK_INT >= 11 && Build$VERSION.SDK_INT <= 13;
    }
    
    private void setupUrlExecutors() {
        this.urlExecutors.put("mopub", new AdWebViewClient$MopubExecutor(this));
        this.urlExecutors.put("amazonmobile", new AdWebViewClient$AmazonMobileExecutor(this.adView, this.context));
        final AdWebViewClient$IntentExecutor adWebViewClient$IntentExecutor = new AdWebViewClient$IntentExecutor(this);
        final Iterator<String> iterator = (Iterator<String>)AdWebViewClient.intentSchemes.iterator();
        while (iterator.hasNext()) {
            this.putUrlExecutor(iterator.next(), adWebViewClient$IntentExecutor);
        }
    }
    
    protected String getScheme(final String s) {
        return Uri.parse(s).getScheme();
    }
    
    protected boolean interpretScheme(final String s, final String s2) {
        boolean execute = false;
        if (s2 != null) {
            if (!this.urlExecutors.containsKey(s2)) {
                Log.d(AdWebViewClient.LOG_TAG, "Scheme %s unrecognized. Launching external browser.", s2);
                return this.adView.launchExternalBrowserForLink(s);
            }
            execute = this.urlExecutors.get(s2).execute(s);
        }
        return execute;
    }
    
    public void onLoadResource(final WebView webView, final String s) {
        Log.d(AdWebViewClient.LOG_TAG, "Loaded resource: %s", s);
    }
    
    public void onPageFinished(final WebView webView, final String s) {
        if (this.adView == null) {
            Log.w(AdWebViewClient.LOG_TAG, "Call to onPageFinished() ignored because view is null.");
            return;
        }
        this.adView.onPageFinished();
    }
    
    public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {
        Log.e(AdWebViewClient.LOG_TAG, "Error: %s", s);
        super.onReceivedError(webView, n, s, s2);
    }
    
    public void putUrlExecutor(final String key, final AdWebViewClient$UrlExecutor value) {
        this.urlExecutors.put(key, value);
    }
    
    public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {
        final AdView adView = this.adView;
        boolean b = false;
        if (adView != null) {
            if (!this.adView.isAdViewRenderable()) {
                return true;
            }
            while (true) {
                Label_0079: {
                    if (!AdWebViewClient.redirectHosts.contains(Uri.parse(s).getHost())) {
                        break Label_0079;
                    }
                    final boolean honeycombVersion = isHoneycombVersion();
                    b = false;
                    if (honeycombVersion) {
                        break Label_0079;
                    }
                    if (this.interpretScheme(s, this.getScheme(s))) {
                        return true;
                    }
                    return b;
                }
                b = true;
                continue;
            }
        }
        return b;
    }
}
