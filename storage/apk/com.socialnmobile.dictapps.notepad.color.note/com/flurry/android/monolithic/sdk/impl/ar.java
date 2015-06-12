// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.monolithic.sdk.impl;

import android.view.View;
import android.webkit.WebView;
import android.annotation.SuppressLint;
import android.view.View$OnClickListener;
import android.widget.RelativeLayout;

@SuppressLint({ "SetJavaScriptEnabled" })
public final class ar extends RelativeLayout implements View$OnClickListener
{
    private WebView a;
    private ek b;
    private eh c;
    private ei d;
    
    public final void onClick(final View view) {
        switch (view.getId()) {
            case 0: {
                if (this.c != null) {
                    final eh c = this.c;
                    final ej c2 = ej.c;
                    return;
                }
                break;
            }
            case 2: {
                if (this.a != null && this.a.canGoForward()) {
                    this.a.goForward();
                    return;
                }
                break;
            }
            case 1: {
                if (this.a != null && this.a.canGoBack()) {
                    this.a.goBack();
                    return;
                }
                if (this.c != null) {
                    final eh c3 = this.c;
                    final ej b = ej.b;
                    return;
                }
                break;
            }
        }
    }
    
    public final void setBasicWebViewClosingHandler(final eh c) {
        this.c = c;
    }
    
    public final void setBasicWebViewFullScreenTransitionHandler(final ei d) {
        this.d = d;
    }
    
    public final void setBasicWebViewUrlLoadingHandler(final ek b) {
        this.b = b;
    }
}
