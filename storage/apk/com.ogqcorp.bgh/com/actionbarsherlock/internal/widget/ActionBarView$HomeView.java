// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.os.Build$VERSION;
import android.view.View$MeasureSpec;
import android.widget.FrameLayout$LayoutParams;
import com.actionbarsherlock.R$id;
import android.view.accessibility.AccessibilityEvent;
import android.view.MotionEvent;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.FrameLayout;

public class ActionBarView$HomeView extends FrameLayout
{
    private ImageView mIconView;
    private View mUpView;
    private int mUpWidth;
    
    public ActionBarView$HomeView(final Context context) {
        this(context, null);
    }
    
    public ActionBarView$HomeView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public boolean dispatchHoverEvent(final MotionEvent motionEvent) {
        return this.onHoverEvent(motionEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }
    
    public int getLeftOffset() {
        if (this.mUpView.getVisibility() == 8) {
            return this.mUpWidth;
        }
        return 0;
    }
    
    protected void onFinishInflate() {
        this.mUpView = this.findViewById(R$id.abs__up);
        this.mIconView = (ImageView)this.findViewById(R$id.abs__home);
    }
    
    protected void onLayout(final boolean b, int n, final int n2, final int n3, final int n4) {
        final int n5 = (n4 - n2) / 2;
        final int visibility = this.mUpView.getVisibility();
        int n6 = 0;
        if (visibility != 8) {
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)this.mUpView.getLayoutParams();
            final int measuredHeight = this.mUpView.getMeasuredHeight();
            final int measuredWidth = this.mUpView.getMeasuredWidth();
            final int n7 = n5 - measuredHeight / 2;
            this.mUpView.layout(0, n7, measuredWidth, measuredHeight + n7);
            final int n8 = measuredWidth + frameLayout$LayoutParams.leftMargin + frameLayout$LayoutParams.rightMargin;
            n += n8;
            n6 = n8;
        }
        final FrameLayout$LayoutParams frameLayout$LayoutParams2 = (FrameLayout$LayoutParams)this.mIconView.getLayoutParams();
        final int measuredHeight2 = this.mIconView.getMeasuredHeight();
        final int measuredWidth2 = this.mIconView.getMeasuredWidth();
        final int n9 = n6 + Math.max(frameLayout$LayoutParams2.leftMargin, (n3 - n) / 2 - measuredWidth2 / 2);
        final int max = Math.max(frameLayout$LayoutParams2.topMargin, n5 - measuredHeight2 / 2);
        this.mIconView.layout(n9, max, measuredWidth2 + n9, measuredHeight2 + max);
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.measureChildWithMargins(this.mUpView, n, 0, n2, 0);
        final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)this.mUpView.getLayoutParams();
        this.mUpWidth = frameLayout$LayoutParams.leftMargin + this.mUpView.getMeasuredWidth() + frameLayout$LayoutParams.rightMargin;
        int mUpWidth;
        if (this.mUpView.getVisibility() == 8) {
            mUpWidth = 0;
        }
        else {
            mUpWidth = this.mUpWidth;
        }
        final int a = frameLayout$LayoutParams.topMargin + this.mUpView.getMeasuredHeight() + frameLayout$LayoutParams.bottomMargin;
        this.measureChildWithMargins((View)this.mIconView, n, mUpWidth, n2, 0);
        final FrameLayout$LayoutParams frameLayout$LayoutParams2 = (FrameLayout$LayoutParams)this.mIconView.getLayoutParams();
        final int a2 = mUpWidth + (frameLayout$LayoutParams2.leftMargin + this.mIconView.getMeasuredWidth() + frameLayout$LayoutParams2.rightMargin);
        final int max = Math.max(a, frameLayout$LayoutParams2.topMargin + this.mIconView.getMeasuredHeight() + frameLayout$LayoutParams2.bottomMargin);
        final int mode = View$MeasureSpec.getMode(n);
        final int mode2 = View$MeasureSpec.getMode(n2);
        int b = View$MeasureSpec.getSize(n);
        int b2 = View$MeasureSpec.getSize(n2);
        switch (mode) {
            case Integer.MIN_VALUE: {
                b = Math.min(a2, b);
            }
            default: {
                b = a2;
            }
            case 1073741824: {
                switch (mode2) {
                    case Integer.MIN_VALUE: {
                        b2 = Math.min(max, b2);
                    }
                    default: {
                        b2 = max;
                    }
                    case 1073741824: {
                        this.setMeasuredDimension(b, b2);
                        return;
                    }
                }
                break;
            }
        }
    }
    
    public void onPopulateAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.onPopulateAccessibilityEvent(accessibilityEvent);
        }
        final CharSequence contentDescription = this.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            accessibilityEvent.getText().add(contentDescription);
        }
    }
    
    public void setIcon(final Drawable imageDrawable) {
        this.mIconView.setImageDrawable(imageDrawable);
    }
    
    public void setUp(final boolean b) {
        final View mUpView = this.mUpView;
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        mUpView.setVisibility(visibility);
    }
}
