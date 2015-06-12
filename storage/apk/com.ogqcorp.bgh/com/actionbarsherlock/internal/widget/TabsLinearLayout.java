// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View;
import android.view.View$MeasureSpec;
import android.widget.LinearLayout$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;

public class TabsLinearLayout extends IcsLinearLayout
{
    private static final int LinearLayout_measureWithLargestChild;
    private static final int[] R_styleable_LinearLayout;
    private boolean mUseLargestChild;
    
    static {
        R_styleable_LinearLayout = new int[] { 16843476 };
    }
    
    public TabsLinearLayout(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, TabsLinearLayout.R_styleable_LinearLayout);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }
    
    private void useLargestChildHorizontal() {
        final int childCount = this.getChildCount();
        int i = 0;
        int b = 0;
        while (i < childCount) {
            final int max = Math.max(this.getChildAt(i).getMeasuredWidth(), b);
            ++i;
            b = max;
        }
        int j = 0;
        int n = 0;
        while (j < childCount) {
            final View child = this.getChildAt(j);
            int n2;
            if (child != null) {
                if (child.getVisibility() == 8) {
                    n2 = n;
                }
                else {
                    final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)child.getLayoutParams();
                    int n3;
                    if (linearLayout$LayoutParams.weight > 0.0f) {
                        child.measure(View$MeasureSpec.makeMeasureSpec(b, 1073741824), View$MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), 1073741824));
                        n3 = n + b;
                    }
                    else {
                        n3 = n + child.getMeasuredWidth();
                    }
                    n2 = n3 + (linearLayout$LayoutParams.leftMargin + linearLayout$LayoutParams.rightMargin);
                }
            }
            else {
                n2 = n;
            }
            ++j;
            n = n2;
        }
        this.setMeasuredDimension(n + (this.getPaddingLeft() + this.getPaddingRight()), this.getMeasuredHeight());
    }
    
    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.getChildCount() > 2) {
            final int mode = View$MeasureSpec.getMode(n);
            if (this.mUseLargestChild && mode == 0 && this.getOrientation() == 0) {
                this.useLargestChildHorizontal();
            }
        }
    }
    
    public void setMeasureWithLargestChildEnabled(final boolean mUseLargestChild) {
        this.mUseLargestChild = mUseLargestChild;
    }
}
