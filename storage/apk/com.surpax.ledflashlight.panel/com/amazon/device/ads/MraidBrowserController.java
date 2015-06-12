// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.net.Uri;

class MraidBrowserController extends MraidAbstractController
{
    private static final String LOGTAG = "MraidBrowserController";
    
    MraidBrowserController(final MraidView mraidView) {
        super(mraidView);
    }
    
    protected void executeAmazonMobileCallback(final MraidView mraidView, final String s) {
        if (mraidView.getOnSpecialUrlClickListener() != null) {
            if (mraidView.getDisplayController().isExpanded()) {
                mraidView.getDisplayController().close();
            }
            mraidView.getOnSpecialUrlClickListener().onSpecialUrlClick(mraidView, s);
        }
    }
    
    protected void open(String s) {
        final MraidView view = this.getView();
        if (s == null || s.length() == 0) {
            Log.e("MraidBrowserController", "URI cannot be null or empty");
            return;
        }
        Log.d("MraidBrowserController", "Opening in-app browser: %s", s);
        final Uri parse = Uri.parse(s);
        if (parse.getScheme() != null && parse.getScheme().equals("amazonmobile")) {
            this.executeAmazonMobileCallback(view, s);
            return;
        }
        while (true) {
            while (true) {
                String queryParameter = null;
                Label_0192: {
                    try {
                        queryParameter = parse.getQueryParameter("d.url");
                        if (queryParameter != null) {
                            break Label_0192;
                        }
                        if (s.startsWith("amazonmobile:")) {
                            this.executeAmazonMobileCallback(view, s);
                            return;
                        }
                    }
                    catch (UnsupportedOperationException ex) {
                        Log.e("MraidBrowserController", "Could not open non-hierarchical URI: %s", s);
                        return;
                    }
                    break;
                }
                s = queryParameter;
                continue;
            }
        }
        if (view.getOnOpenListener() != null) {
            view.getOnOpenListener().onOpen(view);
        }
        if (s.startsWith("http:") || s.startsWith("https:")) {
            new MraidBrowser$MraidBrowserBuilder().withContext(this.getView().getContext()).withUrl(s).withExternalBrowserButton().show();
            return;
        }
        view.adView.launchExternalBrowserForLink(s);
    }
}
