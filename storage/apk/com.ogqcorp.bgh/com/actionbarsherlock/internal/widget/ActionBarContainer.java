// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.ViewGroup$LayoutParams;
import android.view.View$MeasureSpec;
import android.widget.FrameLayout$LayoutParams;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$id;
import android.os.Build$VERSION;
import android.graphics.drawable.ColorDrawable;
import com.actionbarsherlock.R$styleable;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;

public class ActionBarContainer extends NineFrameLayout
{
    private ActionBarView mActionBarView;
    private Drawable mBackground;
    private boolean mIsSplit;
    private boolean mIsStacked;
    private boolean mIsTransitioning;
    private Drawable mSplitBackground;
    private Drawable mStackedBackground;
    private View mTabContainer;
    
    public ActionBarContainer(final Context context) {
        this(context, null);
    }
    
    public ActionBarContainer(final Context context, final AttributeSet set) {
        super(context, set);
        this.setBackgroundDrawable((Drawable)null);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(2);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(12);
        if (this.mStackedBackground instanceof ColorDrawable && Build$VERSION.SDK_INT < 11) {
            this.mStackedBackground = new IcsColorDrawable((ColorDrawable)this.mStackedBackground);
        }
        if (this.getId() == R$id.abs__split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(3);
        }
        obtainStyledAttributes.recycle();
        boolean willNotDraw;
        if (this.mIsSplit) {
            willNotDraw = (this.mSplitBackground == null);
        }
        else {
            willNotDraw = (this.mBackground == null && this.mStackedBackground == null);
        }
        this.setWillNotDraw(willNotDraw);
    }
    
    public View getTabContainer() {
        return this.mTabContainer;
    }
    
    public void onDraw(final Canvas canvas) {
        if (this.getWidth() != 0 && this.getHeight() != 0) {
            if (this.mIsSplit) {
                if (this.mSplitBackground != null) {
                    this.mSplitBackground.draw(canvas);
                }
            }
            else {
                if (this.mBackground != null) {
                    this.mBackground.draw(canvas);
                }
                if (this.mStackedBackground != null && this.mIsStacked) {
                    this.mStackedBackground.draw(canvas);
                }
            }
        }
    }
    
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = (ActionBarView)this.findViewById(R$id.abs__action_bar);
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }
    
    public void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        boolean b2 = true;
        super.onLayout(b, n, n2, n3, n4);
        final boolean b3 = this.mTabContainer != null && this.mTabContainer.getVisibility() != 8 && b2;
        if (this.mTabContainer != null && this.mTabContainer.getVisibility() != 8) {
            final int measuredHeight = this.getMeasuredHeight();
            final int measuredHeight2 = this.mTabContainer.getMeasuredHeight();
            if ((0x2 & this.mActionBarView.getDisplayOptions()) == 0x0) {
                for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
                    final View child = this.getChildAt(i);
                    if (child != this.mTabContainer && !this.mActionBarView.isCollapsed()) {
                        child.offsetTopAndBottom(measuredHeight2);
                    }
                }
                this.mTabContainer.layout(n, 0, n3, measuredHeight2);
            }
            else {
                this.mTabContainer.layout(n, measuredHeight - measuredHeight2, n3, measuredHeight);
            }
        }
        if (this.mIsSplit) {
            if (this.mSplitBackground != null) {
                this.mSplitBackground.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
            }
            else {
                b2 = false;
            }
        }
        else {
            boolean b4;
            if (this.mBackground != null) {
                this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                b4 = b2;
            }
            else {
                b4 = false;
            }
            boolean mIsStacked = false;
            if (b3) {
                final Drawable mStackedBackground = this.mStackedBackground;
                mIsStacked = false;
                if (mStackedBackground != null) {
                    mIsStacked = b2;
                }
            }
            if (this.mIsStacked = mIsStacked) {
                this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            }
            else {
                b2 = b4;
            }
        }
        if (b2) {
            this.invalidate();
        }
    }
    
    public void onMeasure(final int n, final int n2) {
        super.onMeasure(n, n2);
        if (this.mActionBarView != null) {
            final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)this.mActionBarView.getLayoutParams();
            int n3;
            if (this.mActionBarView.isCollapsed()) {
                n3 = 0;
            }
            else {
                n3 = this.mActionBarView.getMeasuredHeight() + frameLayout$LayoutParams.topMargin + frameLayout$LayoutParams.bottomMargin;
            }
            if (this.mTabContainer != null && this.mTabContainer.getVisibility() != 8 && View$MeasureSpec.getMode(n2) == Integer.MIN_VALUE) {
                this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(n3 + this.mTabContainer.getMeasuredHeight(), View$MeasureSpec.getSize(n2)));
            }
        }
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
    
    public void setPrimaryBackground(final Drawable mBackground) {
        this.mBackground = mBackground;
        this.invalidate();
    }
    
    public void setSplitBackground(final Drawable mSplitBackground) {
        this.mSplitBackground = mSplitBackground;
        this.invalidate();
    }
    
    public void setStackedBackground(final Drawable mStackedBackground) {
        this.mStackedBackground = mStackedBackground;
        this.invalidate();
    }
    
    public void setTabContainer(final ScrollingTabContainerView mTabContainer) {
        if (this.mTabContainer != null) {
            this.removeView(this.mTabContainer);
        }
        if ((this.mTabContainer = (View)mTabContainer) != null) {
            this.addView((View)mTabContainer);
            final ViewGroup$LayoutParams layoutParams = mTabContainer.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            mTabContainer.setAllowCollapse(false);
        }
    }
    
    public void setTransitioning(final boolean mIsTransitioning) {
        this.mIsTransitioning = mIsTransitioning;
        int descendantFocusability;
        if (mIsTransitioning) {
            descendantFocusability = 393216;
        }
        else {
            descendantFocusability = 262144;
        }
        this.setDescendantFocusability(descendantFocusability);
    }
}
