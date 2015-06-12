// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import android.view.View$OnClickListener;
import com.actionbarsherlock.view.ActionMode;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet$Builder;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import android.view.animation.Interpolator;
import android.view.animation.DecelerateInterpolator;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import android.view.ViewGroup$MarginLayoutParams;
import android.text.TextUtils;
import com.actionbarsherlock.R$id;
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.view.LayoutInflater;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.R$attr;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineLinearLayout;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;

public class ActionBarContextView extends AbsActionBarView implements Animator$AnimatorListener
{
    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    private NineLinearLayout mClose;
    private Animator mCurrentAnimation;
    private View mCustomView;
    private Drawable mSplitBackground;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private TextView mTitleView;
    
    public ActionBarContextView(final Context context) {
        this(context, null);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set) {
        this(context, set, R$attr.actionModeStyle);
    }
    
    public ActionBarContextView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockActionMode, n, 0);
        this.setBackgroundDrawable(obtainStyledAttributes.getDrawable(2));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(0, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(1, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(4, 0);
        this.mSplitBackground = obtainStyledAttributes.getDrawable(3);
        obtainStyledAttributes.recycle();
    }
    
    private void finishAnimation() {
        final Animator mCurrentAnimation = this.mCurrentAnimation;
        if (mCurrentAnimation != null) {
            this.mCurrentAnimation = null;
            mCurrentAnimation.end();
        }
    }
    
    private void initTitle() {
        int visibility = 8;
        int n = 1;
        if (this.mTitleLayout == null) {
            LayoutInflater.from(this.getContext()).inflate(R$layout.abs__action_bar_title_item, (ViewGroup)this);
            this.mTitleLayout = (LinearLayout)this.getChildAt(-1 + this.getChildCount());
            this.mTitleView = (TextView)this.mTitleLayout.findViewById(R$id.abs__action_bar_title);
            this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(R$id.abs__action_bar_subtitle);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        int n2;
        if (!TextUtils.isEmpty(this.mTitle)) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if (TextUtils.isEmpty(this.mSubtitle)) {
            n = 0;
        }
        final TextView mSubtitleView = this.mSubtitleView;
        int visibility2;
        if (n != 0) {
            visibility2 = 0;
        }
        else {
            visibility2 = visibility;
        }
        mSubtitleView.setVisibility(visibility2);
        final LinearLayout mTitleLayout = this.mTitleLayout;
        if (n2 != 0 || n != 0) {
            visibility = 0;
        }
        mTitleLayout.setVisibility(visibility);
        if (this.mTitleLayout.getParent() == null) {
            this.addView((View)this.mTitleLayout);
        }
    }
    
    private Animator makeInAnimation() {
        this.mClose.setTranslationX(-this.mClose.getWidth() - ((ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mClose, "translationX", 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addListener(this);
        ofFloat.setInterpolator((Interpolator)new DecelerateInterpolator());
        final AnimatorSet set = new AnimatorSet();
        final AnimatorSet$Builder play = set.play(ofFloat);
        if (this.mMenuView != null) {
            final int childCount = this.mMenuView.getChildCount();
            if (childCount > 0) {
                for (int i = childCount - 1, n = 0; i >= 0; --i, ++n) {
                    final AnimatorProxy wrap = AnimatorProxy.wrap(this.mMenuView.getChildAt(i));
                    wrap.setScaleY(0.0f);
                    final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(wrap, "scaleY", 0.0f, 1.0f);
                    ofFloat2.setDuration(100L);
                    ofFloat2.setStartDelay(n * 70);
                    play.with(ofFloat2);
                }
            }
        }
        return set;
    }
    
    private Animator makeOutAnimation() {
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mClose, "translationX", -this.mClose.getWidth() - ((ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams()).leftMargin);
        ofFloat.setDuration(200L);
        ofFloat.addListener(this);
        ofFloat.setInterpolator((Interpolator)new DecelerateInterpolator());
        final AnimatorSet set = new AnimatorSet();
        set.play(ofFloat);
        if (this.mMenuView == null || this.mMenuView.getChildCount() > 0) {
            return set;
        }
        return set;
    }
    
    public void closeMode() {
        if (this.mAnimationMode == 2) {
            return;
        }
        if (this.mClose == null) {
            this.killMode();
            return;
        }
        this.finishAnimation();
        this.mAnimationMode = 2;
        (this.mCurrentAnimation = this.makeOutAnimation()).start();
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(-1, -2);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new ViewGroup$MarginLayoutParams(this.getContext(), set);
    }
    
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    @Override
    public boolean hideOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.hideOverflowMenu();
    }
    
    public void initForMode(final ActionMode actionMode) {
        if (this.mClose == null) {
            this.addView((View)(this.mClose = (NineLinearLayout)LayoutInflater.from(this.mContext).inflate(R$layout.abs__action_mode_close_item, (ViewGroup)this, false)));
        }
        else if (this.mClose.getParent() == null) {
            this.addView((View)this.mClose);
        }
        this.mClose.findViewById(R$id.abs__action_mode_close_button).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                actionMode.finish();
            }
        });
        final MenuBuilder menuBuilder = (MenuBuilder)actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
        (this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext)).setReserveOverflow(true);
        final ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(-2, -1);
        if (!this.mSplitActionBar) {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            (this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this)).setBackgroundDrawable((Drawable)null);
            this.addView((View)this.mMenuView, viewGroup$LayoutParams);
        }
        else {
            this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            viewGroup$LayoutParams.width = -1;
            viewGroup$LayoutParams.height = this.mContentHeight;
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            (this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this)).setBackgroundDrawable(this.mSplitBackground);
            this.mSplitView.addView((View)this.mMenuView, viewGroup$LayoutParams);
        }
        this.mAnimateInOnLayout = true;
    }
    
    @Override
    public boolean isOverflowMenuShowing() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    
    public void killMode() {
        this.finishAnimation();
        this.removeAllViews();
        if (this.mSplitView != null) {
            this.mSplitView.removeView((View)this.mMenuView);
        }
        this.mCustomView = null;
        this.mMenuView = null;
        this.mAnimateInOnLayout = false;
    }
    
    @Override
    public void onAnimationCancel(final Animator animator) {
    }
    
    @Override
    public void onAnimationEnd(final Animator animator) {
        if (this.mAnimationMode == 2) {
            this.killMode();
        }
        this.mAnimationMode = 0;
    }
    
    @Override
    public void onAnimationRepeat(final Animator animator) {
    }
    
    @Override
    public void onAnimationStart(final Animator animator) {
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setClassName((CharSequence)this.getClass().getName());
            accessibilityEvent.setPackageName((CharSequence)this.getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.mTitle);
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int n5 = n4 - n2 - this.getPaddingTop() - this.getPaddingBottom();
        int n7;
        if (this.mClose != null && this.mClose.getVisibility() != 8) {
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams();
            final int n6 = paddingLeft + viewGroup$MarginLayoutParams.leftMargin;
            n7 = n6 + this.positionChild((View)this.mClose, n6, paddingTop, n5) + viewGroup$MarginLayoutParams.rightMargin;
            if (this.mAnimateInOnLayout) {
                this.mAnimationMode = 1;
                (this.mCurrentAnimation = this.makeInAnimation()).start();
                this.mAnimateInOnLayout = false;
            }
        }
        else {
            n7 = paddingLeft;
        }
        if (this.mTitleLayout != null && this.mCustomView == null) {
            n7 += this.positionChild((View)this.mTitleLayout, n7, paddingTop, n5);
        }
        if (this.mCustomView != null) {
            final int n8 = n7 + this.positionChild(this.mCustomView, n7, paddingTop, n5);
        }
        final int n9 = n3 - n - this.getPaddingRight();
        if (this.mMenuView != null) {
            final int n10 = n9 - this.positionChildInverse((View)this.mMenuView, n9, paddingTop, n5);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        int n3 = 1073741824;
        if (View$MeasureSpec.getMode(n) != n3) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View$MeasureSpec.getMode(n2) == 0) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }
        final int size = View$MeasureSpec.getSize(n);
        int n4;
        if (this.mContentHeight > 0) {
            n4 = this.mContentHeight;
        }
        else {
            n4 = View$MeasureSpec.getSize(n2);
        }
        final int n5 = this.getPaddingTop() + this.getPaddingBottom();
        int b = size - this.getPaddingLeft() - this.getPaddingRight();
        final int b2 = n4 - n5;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(b2, Integer.MIN_VALUE);
        if (this.mClose != null) {
            final int measureChildView = this.measureChildView((View)this.mClose, b, measureSpec, 0);
            final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams)this.mClose.getLayoutParams();
            b = measureChildView - (viewGroup$MarginLayoutParams.leftMargin + viewGroup$MarginLayoutParams.rightMargin);
        }
        if (this.mMenuView != null && this.mMenuView.getParent() == this) {
            b = this.measureChildView((View)this.mMenuView, b, measureSpec, 0);
        }
        if (this.mTitleLayout != null && this.mCustomView == null) {
            b = this.measureChildView((View)this.mTitleLayout, b, measureSpec, 0);
        }
        if (this.mCustomView != null) {
            final ViewGroup$LayoutParams layoutParams = this.mCustomView.getLayoutParams();
            int n6;
            if (layoutParams.width != -2) {
                n6 = n3;
            }
            else {
                n6 = Integer.MIN_VALUE;
            }
            if (layoutParams.width >= 0) {
                b = Math.min(layoutParams.width, b);
            }
            if (layoutParams.height == -2) {
                n3 = Integer.MIN_VALUE;
            }
            int min;
            if (layoutParams.height >= 0) {
                min = Math.min(layoutParams.height, b2);
            }
            else {
                min = b2;
            }
            this.mCustomView.measure(View$MeasureSpec.makeMeasureSpec(b, n6), View$MeasureSpec.makeMeasureSpec(min, n3));
        }
        if (this.mContentHeight <= 0) {
            final int childCount = this.getChildCount();
            int i = 0;
            int n7 = 0;
            while (i < childCount) {
                int n8 = n5 + this.getChildAt(i).getMeasuredHeight();
                if (n8 <= n7) {
                    n8 = n7;
                }
                ++i;
                n7 = n8;
            }
            this.setMeasuredDimension(size, n7);
            return;
        }
        this.setMeasuredDimension(size, n4);
    }
    
    @Override
    public void setContentHeight(final int mContentHeight) {
        this.mContentHeight = mContentHeight;
    }
    
    public void setCustomView(final View mCustomView) {
        if (this.mCustomView != null) {
            this.removeView(this.mCustomView);
        }
        this.mCustomView = mCustomView;
        if (this.mTitleLayout != null) {
            this.removeView((View)this.mTitleLayout);
            this.mTitleLayout = null;
        }
        if (mCustomView != null) {
            this.addView(mCustomView);
        }
        this.requestLayout();
    }
    
    @Override
    public void setSplitActionBar(final boolean splitActionBar) {
        if (this.mSplitActionBar != splitActionBar) {
            if (this.mActionMenuPresenter != null) {
                final ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(-2, -1);
                if (!splitActionBar) {
                    (this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this)).setBackgroundDrawable((Drawable)null);
                    final ViewGroup viewGroup = (ViewGroup)this.mMenuView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView((View)this.mMenuView);
                    }
                    this.addView((View)this.mMenuView, viewGroup$LayoutParams);
                }
                else {
                    this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
                    viewGroup$LayoutParams.width = -1;
                    viewGroup$LayoutParams.height = this.mContentHeight;
                    (this.mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this)).setBackgroundDrawable(this.mSplitBackground);
                    final ViewGroup viewGroup2 = (ViewGroup)this.mMenuView.getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView((View)this.mMenuView);
                    }
                    this.mSplitView.addView((View)this.mMenuView, viewGroup$LayoutParams);
                }
            }
            super.setSplitActionBar(splitActionBar);
        }
    }
    
    public void setSubtitle(final CharSequence mSubtitle) {
        this.mSubtitle = mSubtitle;
        this.initTitle();
    }
    
    public void setTitle(final CharSequence mTitle) {
        this.mTitle = mTitle;
        this.initTitle();
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
    
    @Override
    public boolean showOverflowMenu() {
        return this.mActionMenuPresenter != null && this.mActionMenuPresenter.showOverflowMenu();
    }
}
