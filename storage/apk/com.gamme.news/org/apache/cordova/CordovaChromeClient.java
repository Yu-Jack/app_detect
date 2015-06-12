// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.content.Intent;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.widget.EditText;
import android.webkit.JsPromptResult;
import android.view.KeyEvent;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions$Callback;
import android.webkit.WebStorage$QuotaUpdater;
import android.annotation.TargetApi;
import android.webkit.ConsoleMessage;
import android.os.Build$VERSION;
import android.widget.LinearLayout$LayoutParams;
import android.widget.ProgressBar;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.widget.LinearLayout;
import android.view.View;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;

public class CordovaChromeClient extends WebChromeClient
{
    public static final int FILECHOOSER_RESULTCODE = 5173;
    private long MAX_QUOTA;
    private String TAG;
    protected CordovaWebView appView;
    protected CordovaInterface cordova;
    public ValueCallback<Uri> mUploadMessage;
    private View mVideoProgressView;
    
    public CordovaChromeClient(final CordovaInterface cordova) {
        this.TAG = "CordovaLog";
        this.MAX_QUOTA = 104857600L;
        this.cordova = cordova;
    }
    
    public CordovaChromeClient(final CordovaInterface cordova, final CordovaWebView appView) {
        this.TAG = "CordovaLog";
        this.MAX_QUOTA = 104857600L;
        this.cordova = cordova;
        this.appView = appView;
    }
    
    public ValueCallback<Uri> getValueCallback() {
        return this.mUploadMessage;
    }
    
    public View getVideoLoadingProgressView() {
        if (this.mVideoProgressView == null) {
            final LinearLayout mVideoProgressView = new LinearLayout(this.appView.getContext());
            mVideoProgressView.setOrientation(1);
            final RelativeLayout$LayoutParams layoutParams = new RelativeLayout$LayoutParams(-2, -2);
            layoutParams.addRule(13);
            mVideoProgressView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            final ProgressBar progressBar = new ProgressBar(this.appView.getContext());
            final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            progressBar.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
            mVideoProgressView.addView((View)progressBar);
            this.mVideoProgressView = (View)mVideoProgressView;
        }
        return this.mVideoProgressView;
    }
    
    public void onConsoleMessage(final String s, final int i, final String s2) {
        if (Build$VERSION.SDK_INT == 7) {
            LOG.d(this.TAG, "%s: Line %d : %s", s2, i, s);
            super.onConsoleMessage(s, i, s2);
        }
    }
    
    @TargetApi(8)
    public boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
        if (consoleMessage.message() != null) {
            LOG.d(this.TAG, "%s: Line %d : %s", consoleMessage.sourceId(), consoleMessage.lineNumber(), consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }
    
    public void onExceededDatabaseQuota(final String s, final String s2, final long l, final long i, final long j, final WebStorage$QuotaUpdater webStorage$QuotaUpdater) {
        LOG.d(this.TAG, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", i, l, j);
        webStorage$QuotaUpdater.updateQuota(this.MAX_QUOTA);
    }
    
    public void onGeolocationPermissionsShowPrompt(final String s, final GeolocationPermissions$Callback geolocationPermissions$Callback) {
        super.onGeolocationPermissionsShowPrompt(s, geolocationPermissions$Callback);
        geolocationPermissions$Callback.invoke(s, true, false);
    }
    
    public void onHideCustomView() {
        this.appView.hideCustomView();
    }
    
    public boolean onJsAlert(final WebView webView, final String s, final String message, final JsResult jsResult) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.cordova.getActivity());
        alertDialog$Builder.setMessage((CharSequence)message);
        alertDialog$Builder.setTitle((CharSequence)"Alert");
        alertDialog$Builder.setCancelable(true);
        alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                jsResult.confirm();
            }
        });
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        alertDialog$Builder.setOnKeyListener((DialogInterface$OnKeyListener)new DialogInterface$OnKeyListener() {
            public boolean onKey(final DialogInterface dialogInterface, final int n, final KeyEvent keyEvent) {
                if (n == 4) {
                    jsResult.confirm();
                    return false;
                }
                return true;
            }
        });
        alertDialog$Builder.show();
        return true;
    }
    
    public boolean onJsConfirm(final WebView webView, final String s, final String message, final JsResult jsResult) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.cordova.getActivity());
        alertDialog$Builder.setMessage((CharSequence)message);
        alertDialog$Builder.setTitle((CharSequence)"Confirm");
        alertDialog$Builder.setCancelable(true);
        alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                jsResult.confirm();
            }
        });
        alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                jsResult.cancel();
            }
        });
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        });
        alertDialog$Builder.setOnKeyListener((DialogInterface$OnKeyListener)new DialogInterface$OnKeyListener() {
            public boolean onKey(final DialogInterface dialogInterface, final int n, final KeyEvent keyEvent) {
                if (n == 4) {
                    jsResult.cancel();
                    return false;
                }
                return true;
            }
        });
        alertDialog$Builder.show();
        return true;
    }
    
    public boolean onJsPrompt(final WebView webView, final String s, final String message, final String text, final JsPromptResult jsPromptResult) {
        final String promptOnJsPrompt = this.appView.bridge.promptOnJsPrompt(s, message, text);
        if (promptOnJsPrompt != null) {
            jsPromptResult.confirm(promptOnJsPrompt);
        }
        else {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.cordova.getActivity());
            alertDialog$Builder.setMessage((CharSequence)message);
            final EditText view = new EditText((Context)this.cordova.getActivity());
            if (text != null) {
                view.setText((CharSequence)text);
            }
            alertDialog$Builder.setView((View)view);
            alertDialog$Builder.setCancelable(false);
            alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    jsPromptResult.confirm(view.getText().toString());
                }
            });
            alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    jsPromptResult.cancel();
                }
            });
            alertDialog$Builder.show();
        }
        return true;
    }
    
    public void onShowCustomView(final View view, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback) {
        this.appView.showCustomView(view, webChromeClient$CustomViewCallback);
    }
    
    public void openFileChooser(final ValueCallback<Uri> valueCallback) {
        this.openFileChooser(valueCallback, "*/*");
    }
    
    public void openFileChooser(final ValueCallback<Uri> valueCallback, final String s) {
        this.openFileChooser(valueCallback, s, null);
    }
    
    public void openFileChooser(final ValueCallback<Uri> mUploadMessage, final String s, final String s2) {
        this.mUploadMessage = mUploadMessage;
        final Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.cordova.getActivity().startActivityForResult(Intent.createChooser(intent, (CharSequence)"File Browser"), 5173);
    }
    
    @Deprecated
    public void setWebView(final CordovaWebView appView) {
        this.appView = appView;
    }
}
