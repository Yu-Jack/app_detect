// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.inappbrowser;

import android.content.Context;
import android.app.Dialog;

public class InAppBrowserDialog extends Dialog
{
    Context context;
    InAppBrowser inAppBrowser;
    
    public InAppBrowserDialog(final Context context, final int n) {
        super(context, n);
        this.inAppBrowser = null;
        this.context = context;
    }
    
    public void onBackPressed() {
        if (this.inAppBrowser == null) {
            this.dismiss();
            return;
        }
        this.inAppBrowser.closeDialog();
    }
    
    public void setInAppBroswer(final InAppBrowser inAppBrowser) {
        this.inAppBrowser = inAppBrowser;
    }
}
