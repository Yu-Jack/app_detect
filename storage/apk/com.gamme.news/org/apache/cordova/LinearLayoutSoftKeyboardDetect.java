// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.view.View$MeasureSpec;
import android.content.Context;
import android.widget.LinearLayout;

public class LinearLayoutSoftKeyboardDetect extends LinearLayout
{
    private static final String TAG = "SoftKeyboardDetect";
    private CordovaActivity app;
    private int oldHeight;
    private int oldWidth;
    private int screenHeight;
    private int screenWidth;
    
    public LinearLayoutSoftKeyboardDetect(final Context context, final int screenWidth, final int screenHeight) {
        super(context);
        this.oldHeight = 0;
        this.oldWidth = 0;
        this.screenWidth = 0;
        this.screenHeight = 0;
        this.app = null;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.app = (CordovaActivity)context;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        LOG.v("SoftKeyboardDetect", "We are in our onMeasure method");
        final int size = View$MeasureSpec.getSize(n2);
        final int size2 = View$MeasureSpec.getSize(n);
        LOG.v("SoftKeyboardDetect", "Old Height = %d", this.oldHeight);
        LOG.v("SoftKeyboardDetect", "Height = %d", size);
        LOG.v("SoftKeyboardDetect", "Old Width = %d", this.oldWidth);
        LOG.v("SoftKeyboardDetect", "Width = %d", size2);
        if (this.oldHeight == 0 || this.oldHeight == size) {
            LOG.d("SoftKeyboardDetect", "Ignore this event");
        }
        else if (this.screenHeight == size2) {
            final int screenHeight = this.screenHeight;
            this.screenHeight = this.screenWidth;
            this.screenWidth = screenHeight;
            LOG.v("SoftKeyboardDetect", "Orientation Change");
        }
        else if (size > this.oldHeight) {
            if (this.app != null) {
                this.app.appView.sendJavascript("cordova.fireDocumentEvent('hidekeyboard');");
            }
        }
        else if (size < this.oldHeight && this.app != null) {
            this.app.appView.sendJavascript("cordova.fireDocumentEvent('showkeyboard');");
        }
        this.oldHeight = size;
        this.oldWidth = size2;
    }
}
