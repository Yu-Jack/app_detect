// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Build$VERSION;
import android.webkit.WebView;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.ImageView$ScaleType;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.view.WindowManager;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.app.Activity;

class InterstitialAdActivityAdapter implements AdView, IAdActivityAdapter
{
    private final int CLOSE_BUTTON_SIZE_DP;
    private final int CLOSE_BUTTON_TAP_TARGET_SIZE_DP;
    private Activity activity;
    private String uniqueId;
    
    InterstitialAdActivityAdapter() {
        this.activity = null;
        this.uniqueId = null;
        this.CLOSE_BUTTON_SIZE_DP = 60;
        this.CLOSE_BUTTON_TAP_TARGET_SIZE_DP = 80;
    }
    
    private void addNativeCloseButton(final FrameLayout frameLayout) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)this.activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        ThreadUtils.executeAsyncTask(new AsyncTask() {
            final /* synthetic */ int val$buttonSize = (int)(0.5f + 60.0f * displayMetrics.density);
            final /* synthetic */ BitmapDrawable val$closeNormal = AndroidTargetUtils.getNewBitmapDrawable(InterstitialAdActivityAdapter.this.activity.getResources(), Assets.getInstance().getFilePath("amazon_ads_interstitial_close_normal.png"));
            final /* synthetic */ BitmapDrawable val$closePressed = AndroidTargetUtils.getNewBitmapDrawable(InterstitialAdActivityAdapter.this.activity.getResources(), Assets.getInstance().getFilePath("amazon_ads_interstitial_close_pressed.png"));
            final /* synthetic */ int val$tapTargetSize = (int)(0.5f + 80.0f * displayMetrics.density);
            
            protected RelativeLayout doInBackground(final Void... array) {
                final RelativeLayout relativeLayout = new RelativeLayout(frameLayout.getContext());
                final ImageButton imageButton = new ImageButton(frameLayout.getContext());
                ((ImageView)imageButton).setImageDrawable((Drawable)this.val$closeNormal);
                ((ImageView)imageButton).setScaleType(ImageView$ScaleType.FIT_CENTER);
                ((ImageView)imageButton).setBackgroundDrawable((Drawable)null);
                final View$OnClickListener view$OnClickListener = (View$OnClickListener)new View$OnClickListener() {
                    public void onClick(final View view) {
                        InterstitialAdActivityAdapter.this.activity.finish();
                    }
                };
                ((ImageView)imageButton).setOnClickListener((View$OnClickListener)view$OnClickListener);
                relativeLayout.setOnClickListener((View$OnClickListener)view$OnClickListener);
                final View$OnTouchListener view$OnTouchListener = (View$OnTouchListener)new View$OnTouchListener() {
                    public boolean onTouch(final View view, final MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0: {
                                ((ImageView)imageButton).setImageDrawable((Drawable)AsyncTask.this.val$closePressed);
                                break;
                            }
                            case 1: {
                                ((ImageView)imageButton).setImageDrawable((Drawable)AsyncTask.this.val$closeNormal);
                                break;
                            }
                        }
                        return false;
                    }
                };
                relativeLayout.setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
                ((ImageView)imageButton).setOnTouchListener((View$OnTouchListener)view$OnTouchListener);
                final RelativeLayout$LayoutParams relativeLayout$LayoutParams = new RelativeLayout$LayoutParams(this.val$buttonSize, this.val$buttonSize);
                relativeLayout$LayoutParams.addRule(13);
                relativeLayout.addView((View)imageButton, (ViewGroup$LayoutParams)relativeLayout$LayoutParams);
                return relativeLayout;
            }
            
            protected void onPostExecute(final RelativeLayout relativeLayout) {
                final FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(this.val$tapTargetSize, this.val$tapTargetSize, 5);
                frameLayout$LayoutParams.topMargin = 0;
                frameLayout$LayoutParams.rightMargin = 0;
                frameLayout.addView((View)relativeLayout, (ViewGroup$LayoutParams)frameLayout$LayoutParams);
            }
        }, (Object[])new Void[0]);
    }
    
    private void sendBroadcast(final String s) {
        final Intent intent = new Intent("amazon.mobile.ads.interstitial");
        intent.putExtra("action", s);
        intent.putExtra("uniqueIdentifier", this.uniqueId);
        this.activity.sendBroadcast(intent);
    }
    
    Activity getActivity() {
        return this.activity;
    }
    
    @Override
    public int getHeight() {
        return 0;
    }
    
    @Override
    public AdWebViewClient$UrlExecutor getSpecialUrlExecutor() {
        return new AdWebViewClient$AmazonMobileExecutor(this, (Context)this.activity);
    }
    
    @Override
    public boolean isAdViewRenderable() {
        return true;
    }
    
    @Override
    public boolean launchExternalBrowserForLink(final String s) {
        return this.isAdViewRenderable() && AdUtils.launchActivityForIntentLink(s, (Context)this.activity);
    }
    
    @Override
    public void onCreate() {
        final WebView webView = WebViewFactory.getInstance().createWebView((Context)this.activity);
        if (DeviceInfo.getUserAgentString() == null) {
            DeviceInfo.setUserAgentString(webView.getSettings().getUserAgentString());
        }
        this.uniqueId = this.activity.getIntent().getStringExtra("uniqueIdentifier");
        final String replace = this.activity.getIntent().getStringExtra("creative").replace("<head>", "<head>\n  <script type='text/javascript'>\n  function fireImpression(a) {\n    var container = document.createElement('div');\n    var pix = document.createElement('img');\n    pix.setAttribute('src', a);\n    pix.style.position = 'absolute';\n    pix.style.top = '0px';\n    pix.style.right = '0px';\n    pix.style.display = 'none';\n    container.appendChild(pix);\n    document.body.appendChild(container);\n  }\n  </script>\n");
        MraidView removeCachedMraidView = MraidView.removeCachedMraidView(this.uniqueId);
        if (removeCachedMraidView == null) {
            webView.setBackgroundColor(0);
            removeCachedMraidView = new MraidView(this, (Context)this.activity, webView);
        }
        else {
            removeCachedMraidView.registerReceivers();
            removeCachedMraidView.setAdView(this);
        }
        removeCachedMraidView.loadHtmlData("http://amazon-adsystem.amazon.com/", replace);
        this.addNativeCloseButton(removeCachedMraidView);
        this.activity.setContentView((View)removeCachedMraidView);
    }
    
    @Override
    public void onPageFinished() {
        this.sendBroadcast("finished");
    }
    
    @Override
    public void onPause() {
    }
    
    @Override
    public void onResume() {
    }
    
    @Override
    public void onStop() {
        if (this.activity.isFinishing()) {
            this.sendBroadcast("dismissed");
        }
    }
    
    @Override
    public void preOnCreate() {
        this.activity.requestWindowFeature(1);
        this.activity.getWindow().setFlags(1024, 1024);
        if (Build$VERSION.SDK_INT > 11) {
            AndroidTargetUtils.hideActionAndStatusBars(this.activity);
        }
    }
    
    @Override
    public void setActivity(final Activity activity) {
        this.activity = activity;
    }
    
    @Override
    public boolean shouldDisableWebViewHardwareAcceleration() {
        return false;
    }
}
