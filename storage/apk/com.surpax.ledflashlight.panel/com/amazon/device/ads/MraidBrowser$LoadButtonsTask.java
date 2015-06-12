// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Build$VERSION;
import android.webkit.WebChromeClient;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.webkit.WebViewClient;
import android.annotation.SuppressLint;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.WindowManager;
import android.util.DisplayMetrics;
import android.view.View$OnClickListener;
import android.webkit.CookieSyncManager;
import android.widget.ImageView$ScaleType;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.AsyncTask;

class MraidBrowser$LoadButtonsTask extends AsyncTask
{
    private final int buttonHeight;
    private final int buttonWidth;
    private final Intent intent;
    private final ViewGroup layout;
    final /* synthetic */ MraidBrowser this$0;
    
    public MraidBrowser$LoadButtonsTask(final MraidBrowser this$0, final Intent intent, final ViewGroup layout, final int buttonWidth, final int buttonHeight) {
        this.this$0 = this$0;
        this.intent = intent;
        this.layout = layout;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
    }
    
    protected Void doInBackground(final Void... array) {
        this.this$0.mBrowserBackButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_leftarrow.png"), 9, -1, this.buttonWidth, this.buttonHeight);
        this.this$0.mBrowserBackButton.setId(10537);
        this.this$0.mBrowserForwardButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_rightarrow.png"), 1, this.this$0.mBrowserBackButton.getId(), this.buttonWidth, this.buttonHeight);
        this.this$0.mBrowserForwardButton.setId(10794);
        this.this$0.mCloseButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_close.png"), 11, -1, this.buttonWidth, this.buttonHeight);
        if (this.this$0.showOpenExternalBrowserButton) {
            this.this$0.mOpenExternalBrowserButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_open_external_browser.png"), 1, this.this$0.mBrowserForwardButton.getId(), this.buttonWidth, this.buttonHeight);
            this.this$0.mOpenExternalBrowserButton.setId(10795);
            this.this$0.mRefreshButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, this.this$0.mOpenExternalBrowserButton.getId(), this.buttonWidth, this.buttonHeight);
        }
        else {
            this.this$0.mRefreshButton = this.this$0.createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, this.this$0.mBrowserForwardButton.getId(), this.buttonWidth, this.buttonHeight);
        }
        return null;
    }
    
    protected void onPostExecute(final Void void1) {
        this.layout.addView((View)this.this$0.mBrowserBackButton);
        this.layout.addView((View)this.this$0.mBrowserForwardButton);
        this.layout.addView((View)this.this$0.mRefreshButton);
        this.layout.addView((View)this.this$0.mCloseButton);
        if (this.this$0.showOpenExternalBrowserButton) {
            this.layout.addView((View)this.this$0.mOpenExternalBrowserButton);
        }
        this.this$0.initializeButtons(this.intent);
    }
}
