// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.ViewParent;
import android.text.TextUtils$TruncateAt;
import com.actionbarsherlock.R$attr;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.util.AttributeSet;
import android.content.Context;
import com.actionbarsherlock.app.ActionBar$Tab;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;

public class ScrollingTabContainerView$TabView extends LinearLayout
{
    private View mCustomView;
    private ImageView mIconView;
    private ScrollingTabContainerView mParent;
    private ActionBar$Tab mTab;
    private CapitalizingTextView mTextView;
    
    public ScrollingTabContainerView$TabView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public void bindTab(final ActionBar$Tab mTab) {
        this.mTab = mTab;
        this.update();
    }
    
    public ActionBar$Tab getTab() {
        return this.mTab;
    }
    
    public void init(final ScrollingTabContainerView mParent, final ActionBar$Tab mTab, final boolean b) {
        this.mParent = mParent;
        this.mTab = mTab;
        if (b) {
            this.setGravity(19);
        }
        this.update();
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mParent.mMaxTabWidth > 0 && this.getMeasuredWidth() > this.mParent.mMaxTabWidth) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(this.mParent.mMaxTabWidth, 1073741824), n2);
        }
    }
    
    public void update() {
        final ActionBar$Tab mTab = this.mTab;
        final View customView = mTab.getCustomView();
        if (customView != null) {
            final ViewParent parent = customView.getParent();
            if (parent != this) {
                if (parent != null) {
                    ((ViewGroup)parent).removeView(customView);
                }
                this.addView(customView);
            }
            this.mCustomView = customView;
            if (this.mTextView != null) {
                this.mTextView.setVisibility(8);
            }
            if (this.mIconView != null) {
                this.mIconView.setVisibility(8);
                this.mIconView.setImageDrawable((Drawable)null);
            }
        }
        else {
            if (this.mCustomView != null) {
                this.removeView(this.mCustomView);
                this.mCustomView = null;
            }
            final Drawable icon = mTab.getIcon();
            final CharSequence text = mTab.getText();
            if (icon != null) {
                if (this.mIconView == null) {
                    final ImageView mIconView = new ImageView(this.getContext());
                    final LinearLayout$LayoutParams layoutParams = new LinearLayout$LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    mIconView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                    this.addView((View)mIconView, 0);
                    this.mIconView = mIconView;
                }
                this.mIconView.setImageDrawable(icon);
                this.mIconView.setVisibility(0);
            }
            else if (this.mIconView != null) {
                this.mIconView.setVisibility(8);
                this.mIconView.setImageDrawable((Drawable)null);
            }
            if (text != null) {
                if (this.mTextView == null) {
                    final CapitalizingTextView mTextView = new CapitalizingTextView(this.getContext(), null, R$attr.actionBarTabTextStyle);
                    mTextView.setEllipsize(TextUtils$TruncateAt.END);
                    final LinearLayout$LayoutParams layoutParams2 = new LinearLayout$LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    mTextView.setLayoutParams((ViewGroup$LayoutParams)layoutParams2);
                    this.addView((View)mTextView);
                    this.mTextView = mTextView;
                }
                this.mTextView.setTextCompat(text);
                this.mTextView.setVisibility(0);
            }
            else if (this.mTextView != null) {
                this.mTextView.setVisibility(8);
                this.mTextView.setText((CharSequence)null);
            }
            if (this.mIconView != null) {
                this.mIconView.setContentDescription(mTab.getContentDescription());
            }
        }
    }
}
