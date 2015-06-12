// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Build$VERSION;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout$LayoutParams;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;

public class IcsLinearLayout extends NineLinearLayout
{
    private static final int LinearLayout_divider = 0;
    private static final int LinearLayout_dividerPadding = 2;
    private static final int LinearLayout_showDividers = 1;
    private static final int[] R_styleable_LinearLayout;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mShowDividers;
    
    static {
        R_styleable_LinearLayout = new int[] { 16843049, 16843561, 16843562 };
    }
    
    public IcsLinearLayout(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, IcsLinearLayout.R_styleable_LinearLayout);
        this.setDividerDrawable(obtainStyledAttributes.getDrawable(0));
        this.mShowDividers = obtainStyledAttributes.getInt(1, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }
    
    void drawDividersHorizontal(final Canvas canvas) {
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child != null && child.getVisibility() != 8 && this.hasDividerBeforeChildAt(i)) {
                this.drawVerticalDivider(canvas, child.getLeft() - ((LinearLayout$LayoutParams)child.getLayoutParams()).leftMargin);
            }
        }
        if (this.hasDividerBeforeChildAt(childCount)) {
            final View child2 = this.getChildAt(childCount - 1);
            int right;
            if (child2 == null) {
                right = this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
            }
            else {
                right = child2.getRight();
            }
            this.drawVerticalDivider(canvas, right);
        }
    }
    
    void drawDividersVertical(final Canvas canvas) {
        final int childCount = this.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            if (child != null && child.getVisibility() != 8 && this.hasDividerBeforeChildAt(i)) {
                this.drawHorizontalDivider(canvas, child.getTop() - ((LinearLayout$LayoutParams)child.getLayoutParams()).topMargin);
            }
        }
        if (this.hasDividerBeforeChildAt(childCount)) {
            final View child2 = this.getChildAt(childCount - 1);
            int bottom;
            if (child2 == null) {
                bottom = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
            }
            else {
                bottom = child2.getBottom();
            }
            this.drawHorizontalDivider(canvas, bottom);
        }
    }
    
    void drawHorizontalDivider(final Canvas canvas, final int n) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, n, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, n + this.mDividerHeight);
        this.mDivider.draw(canvas);
    }
    
    void drawVerticalDivider(final Canvas canvas, final int n) {
        this.mDivider.setBounds(n, this.getPaddingTop() + this.mDividerPadding, n + this.mDividerWidth, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }
    
    public int getDividerPadding() {
        return this.mDividerPadding;
    }
    
    public int getDividerWidth() {
        return this.mDividerWidth;
    }
    
    public int getShowDividers() {
        return this.mShowDividers;
    }
    
    protected boolean hasDividerBeforeChildAt(final int n) {
        if (n == 0) {
            if ((0x1 & this.mShowDividers) == 0x0) {
                return false;
            }
        }
        else if (n == this.getChildCount()) {
            if ((0x4 & this.mShowDividers) == 0x0) {
                return false;
            }
        }
        else {
            if ((0x2 & this.mShowDividers) != 0x0) {
                for (int i = n - 1; i >= 0; --i) {
                    if (this.getChildAt(i).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return true;
    }
    
    protected void measureChildWithMargins(final View view, final int n, final int n2, final int n3, final int n4) {
        final int indexOfChild = this.indexOfChild(view);
        final int orientation = this.getOrientation();
        final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)view.getLayoutParams();
        if (this.hasDividerBeforeChildAt(indexOfChild)) {
            if (orientation == 1) {
                linearLayout$LayoutParams.topMargin = this.mDividerHeight;
            }
            else {
                linearLayout$LayoutParams.leftMargin = this.mDividerWidth;
            }
        }
        final int childCount = this.getChildCount();
        if (indexOfChild == childCount - 1 && this.hasDividerBeforeChildAt(childCount)) {
            if (orientation == 1) {
                linearLayout$LayoutParams.bottomMargin = this.mDividerHeight;
            }
            else {
                linearLayout$LayoutParams.rightMargin = this.mDividerWidth;
            }
        }
        super.measureChildWithMargins(view, n, n2, n3, n4);
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.mDivider != null) {
            if (this.getOrientation() == 1) {
                this.drawDividersVertical(canvas);
            }
            else {
                this.drawDividersHorizontal(canvas);
            }
        }
        super.onDraw(canvas);
    }
    
    public void setDividerDrawable(Drawable mDivider) {
        if (mDivider == this.mDivider) {
            return;
        }
        if (mDivider instanceof ColorDrawable && Build$VERSION.SDK_INT < 11) {
            mDivider = new IcsColorDrawable((ColorDrawable)mDivider);
        }
        if ((this.mDivider = mDivider) != null) {
            this.mDividerWidth = mDivider.getIntrinsicWidth();
            this.mDividerHeight = mDivider.getIntrinsicHeight();
        }
        else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        this.setWillNotDraw(mDivider == null);
        this.requestLayout();
    }
    
    public void setDividerPadding(final int mDividerPadding) {
        this.mDividerPadding = mDividerPadding;
    }
    
    public void setShowDividers(final int mShowDividers) {
        if (mShowDividers != this.mShowDividers) {
            this.requestLayout();
            this.invalidate();
        }
        this.mShowDividers = mShowDividers;
    }
}
