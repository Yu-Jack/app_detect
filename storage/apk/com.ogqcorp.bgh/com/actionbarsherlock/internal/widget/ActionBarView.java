// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.LinearLayout$LayoutParams;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.R$bool;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.internal.view.menu.MenuPresenter$Callback;
import com.actionbarsherlock.view.Menu;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.content.res.Configuration;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import com.actionbarsherlock.R$id;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.actionbarsherlock.R$string;
import android.view.ViewGroup;
import com.actionbarsherlock.R$layout;
import android.view.LayoutInflater;
import com.actionbarsherlock.internal.ResourcesCompat;
import android.app.Activity;
import android.os.Build$VERSION;
import com.actionbarsherlock.R$attr;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import android.util.AttributeSet;
import android.content.Context;
import com.actionbarsherlock.view.Window$Callback;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import android.graphics.drawable.Drawable;
import android.view.View$OnClickListener;
import android.view.View;
import com.actionbarsherlock.app.ActionBar$OnNavigationListener;

public class ActionBarView extends AbsActionBarView
{
    private static final int DEFAULT_CUSTOM_GRAVITY = 19;
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK = 31;
    private static final String TAG = "ActionBarView";
    private ActionBar$OnNavigationListener mCallback;
    private ActionBarContextView mContextView;
    private View mCustomNavView;
    private int mDisplayOptions;
    View mExpandedActionView;
    private final View$OnClickListener mExpandedActionViewUpListener;
    private ActionBarView$HomeView mExpandedHomeLayout;
    private ActionBarView$ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private ActionBarView$HomeView mHomeLayout;
    private Drawable mIcon;
    private boolean mIncludeTabs;
    private int mIndeterminateProgressStyle;
    private IcsProgressBar mIndeterminateProgressView;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private int mItemPadding;
    private IcsLinearLayout mListNavLayout;
    private Drawable mLogo;
    private ActionMenuItem mLogoNavItem;
    private final IcsAdapterView$OnItemSelectedListener mNavItemSelectedListener;
    private int mNavigationMode;
    private MenuBuilder mOptionsMenu;
    private int mProgressBarPadding;
    private int mProgressStyle;
    private IcsProgressBar mProgressView;
    private IcsSpinner mSpinner;
    private SpinnerAdapter mSpinnerAdapter;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private ScrollingTabContainerView mTabScrollView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private View mTitleUpView;
    private TextView mTitleView;
    private final View$OnClickListener mUpClickListener;
    private boolean mUserTitle;
    Window$Callback mWindowCallback;
    
    public ActionBarView(final Context context, final AttributeSet set) {
        super(context, set);
        this.mDisplayOptions = -1;
        this.mNavItemSelectedListener = new IcsAdapterView$OnItemSelectedListener() {
            @Override
            public void onItemSelected(final IcsAdapterView icsAdapterView, final View view, final int n, final long n2) {
                if (ActionBarView.this.mCallback != null) {
                    ActionBarView.this.mCallback.onNavigationItemSelected(n, n2);
                }
            }
            
            @Override
            public void onNothingSelected(final IcsAdapterView icsAdapterView) {
            }
        };
        this.mExpandedActionViewUpListener = (View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                final MenuItemImpl mCurrentExpandedItem = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
                if (mCurrentExpandedItem != null) {
                    mCurrentExpandedItem.collapseActionView();
                }
            }
        };
        this.mUpClickListener = (View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
            }
        };
        this.setBackgroundResource(0);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R$styleable.SherlockActionBar, R$attr.actionBarStyle, 0);
        final ApplicationInfo applicationInfo = context.getApplicationInfo();
        final PackageManager packageManager = context.getPackageManager();
        this.mNavigationMode = obtainStyledAttributes.getInt(6, 0);
        this.mTitle = obtainStyledAttributes.getText(8);
        this.mSubtitle = obtainStyledAttributes.getText(9);
        this.mLogo = obtainStyledAttributes.getDrawable(11);
        Label_0492: {
            if (this.mLogo == null) {
                if (Build$VERSION.SDK_INT >= 11) {
                    break Label_0492;
                }
                if (context instanceof Activity) {
                    final int loadLogoFromManifest = ResourcesCompat.loadLogoFromManifest((Activity)context);
                    if (loadLogoFromManifest != 0) {
                        this.mLogo = context.getResources().getDrawable(loadLogoFromManifest);
                    }
                }
            }
        Label_0207_Outer:
            while (true) {
                this.mIcon = obtainStyledAttributes.getDrawable(10);
                Label_0225: {
                    if (this.mIcon != null) {
                        break Label_0225;
                    }
                    while (true) {
                        if (!(context instanceof Activity)) {
                            break Label_0207;
                        }
                        try {
                            this.mIcon = packageManager.getActivityIcon(((Activity)context).getComponentName());
                            if (this.mIcon == null) {
                                this.mIcon = applicationInfo.loadIcon(packageManager);
                            }
                            final LayoutInflater from = LayoutInflater.from(context);
                            final int resourceId = obtainStyledAttributes.getResourceId(14, R$layout.abs__action_bar_home);
                            this.mHomeLayout = (ActionBarView$HomeView)from.inflate(resourceId, (ViewGroup)this, false);
                            (this.mExpandedHomeLayout = (ActionBarView$HomeView)from.inflate(resourceId, (ViewGroup)this, false)).setUp(true);
                            this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
                            this.mExpandedHomeLayout.setContentDescription(this.getResources().getText(R$string.abs__action_bar_up_description));
                            this.mTitleStyleRes = obtainStyledAttributes.getResourceId(0, 0);
                            this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(1, 0);
                            this.mProgressStyle = obtainStyledAttributes.getResourceId(15, 0);
                            this.mIndeterminateProgressStyle = obtainStyledAttributes.getResourceId(16, 0);
                            this.mProgressBarPadding = obtainStyledAttributes.getDimensionPixelOffset(17, 0);
                            this.mItemPadding = obtainStyledAttributes.getDimensionPixelOffset(18, 0);
                            this.setDisplayOptions(obtainStyledAttributes.getInt(7, 0));
                            final int resourceId2 = obtainStyledAttributes.getResourceId(13, 0);
                            if (resourceId2 != 0) {
                                this.mCustomNavView = from.inflate(resourceId2, (ViewGroup)this, false);
                                this.mNavigationMode = 0;
                                this.setDisplayOptions(0x10 | this.mDisplayOptions);
                            }
                            this.mContentHeight = obtainStyledAttributes.getLayoutDimension(4, 0);
                            obtainStyledAttributes.recycle();
                            this.mLogoNavItem = new ActionMenuItem(context, 0, 16908332, 0, 0, this.mTitle);
                            this.mHomeLayout.setOnClickListener(this.mUpClickListener);
                            this.mHomeLayout.setClickable(true);
                            this.mHomeLayout.setFocusable(true);
                            return;
                            // iftrue(Label_0515:, !context instanceof Activity)
                            try {
                                this.mLogo = packageManager.getActivityLogo(((Activity)context).getComponentName());
                                Label_0515: {
                                    if (this.mLogo == null) {
                                        this.mLogo = applicationInfo.loadLogo(packageManager);
                                    }
                                }
                                continue Label_0207_Outer;
                            }
                            catch (PackageManager$NameNotFoundException ex) {
                                Log.e("ActionBarView", "Activity component name not found!", (Throwable)ex);
                            }
                        }
                        catch (PackageManager$NameNotFoundException ex2) {
                            Log.e("ActionBarView", "Activity component name not found!", (Throwable)ex2);
                            continue;
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    private void configPresenters(final MenuBuilder menuBuilder) {
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter);
            return;
        }
        this.mActionMenuPresenter.initForMenu(this.mContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mContext, null);
        this.mActionMenuPresenter.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
    }
    
    private void initTitle() {
        boolean enabled = true;
        if (this.mTitleLayout == null) {
            this.mTitleLayout = (LinearLayout)LayoutInflater.from(this.getContext()).inflate(R$layout.abs__action_bar_title_item, (ViewGroup)this, false);
            this.mTitleView = (TextView)this.mTitleLayout.findViewById(R$id.abs__action_bar_title);
            this.mSubtitleView = (TextView)this.mTitleLayout.findViewById(R$id.abs__action_bar_subtitle);
            this.mTitleUpView = this.mTitleLayout.findViewById(R$id.abs__up);
            this.mTitleLayout.setOnClickListener(this.mUpClickListener);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mTitle != null) {
                this.mTitleView.setText(this.mTitle);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
            if (this.mSubtitle != null) {
                this.mSubtitleView.setText(this.mSubtitle);
                this.mSubtitleView.setVisibility(0);
            }
            final boolean b = (0x4 & this.mDisplayOptions) != 0x0 && enabled;
            final boolean b2 = (0x2 & this.mDisplayOptions) != 0x0 && enabled;
            final View mTitleUpView = this.mTitleUpView;
            int visibility;
            if (!b2) {
                if (b) {
                    visibility = 0;
                }
                else {
                    visibility = 4;
                }
            }
            else {
                visibility = 8;
            }
            mTitleUpView.setVisibility(visibility);
            final LinearLayout mTitleLayout = this.mTitleLayout;
            if (!b || b2) {
                enabled = false;
            }
            mTitleLayout.setEnabled(enabled);
        }
        this.addView((View)this.mTitleLayout);
        if (this.mExpandedActionView != null || (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mSubtitle))) {
            this.mTitleLayout.setVisibility(8);
        }
    }
    
    private void setTitleImpl(final CharSequence title) {
        this.mTitle = title;
        if (this.mTitleView != null) {
            this.mTitleView.setText(title);
            int n;
            if (this.mExpandedActionView == null && (0x8 & this.mDisplayOptions) != 0x0 && (!TextUtils.isEmpty(this.mTitle) || !TextUtils.isEmpty(this.mSubtitle))) {
                n = 1;
            }
            else {
                n = 0;
            }
            final LinearLayout mTitleLayout = this.mTitleLayout;
            int visibility = 0;
            if (n == 0) {
                visibility = 8;
            }
            mTitleLayout.setVisibility(visibility);
        }
        if (this.mLogoNavItem != null) {
            this.mLogoNavItem.setTitle(title);
        }
    }
    
    public void collapseActionView() {
        MenuItemImpl mCurrentExpandedItem;
        if (this.mExpandedMenuPresenter == null) {
            mCurrentExpandedItem = null;
        }
        else {
            mCurrentExpandedItem = this.mExpandedMenuPresenter.mCurrentExpandedItem;
        }
        if (mCurrentExpandedItem != null) {
            mCurrentExpandedItem.collapseActionView();
        }
    }
    
    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return (ViewGroup$LayoutParams)new ActionBar$LayoutParams(19);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(final AttributeSet set) {
        return (ViewGroup$LayoutParams)new ActionBar$LayoutParams(this.getContext(), set);
    }
    
    public ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams generateDefaultLayoutParams) {
        if (generateDefaultLayoutParams == null) {
            generateDefaultLayoutParams = this.generateDefaultLayoutParams();
        }
        return generateDefaultLayoutParams;
    }
    
    public View getCustomNavigationView() {
        return this.mCustomNavView;
    }
    
    public int getDisplayOptions() {
        return this.mDisplayOptions;
    }
    
    public SpinnerAdapter getDropdownAdapter() {
        return this.mSpinnerAdapter;
    }
    
    public int getDropdownSelectedPosition() {
        return this.mSpinner.getSelectedItemPosition();
    }
    
    public int getNavigationMode() {
        return this.mNavigationMode;
    }
    
    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }
    
    public CharSequence getTitle() {
        return this.mTitle;
    }
    
    public boolean hasEmbeddedTabs() {
        return this.mIncludeTabs;
    }
    
    public boolean hasExpandedActionView() {
        return this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null;
    }
    
    public void initIndeterminateProgress() {
        (this.mIndeterminateProgressView = new IcsProgressBar(this.mContext, null, 0, this.mIndeterminateProgressStyle)).setId(R$id.abs__progress_circular);
        this.addView((View)this.mIndeterminateProgressView);
    }
    
    public void initProgress() {
        (this.mProgressView = new IcsProgressBar(this.mContext, null, 0, this.mProgressStyle)).setId(R$id.abs__progress_horizontal);
        this.mProgressView.setMax(10000);
        this.addView((View)this.mProgressView);
    }
    
    public boolean isCollapsed() {
        return this.mIsCollapsed;
    }
    
    public boolean isSplitActionBar() {
        return this.mSplitActionBar;
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mTitleView = null;
        this.mSubtitleView = null;
        this.mTitleUpView = null;
        if (this.mTitleLayout != null && this.mTitleLayout.getParent() == this) {
            this.removeView((View)this.mTitleLayout);
        }
        this.mTitleLayout = null;
        if ((0x8 & this.mDisplayOptions) != 0x0) {
            this.initTitle();
        }
        if (this.mTabScrollView != null && this.mIncludeTabs) {
            final ViewGroup$LayoutParams layoutParams = this.mTabScrollView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
            this.mTabScrollView.setAllowCollapse(true);
        }
    }
    
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.addView((View)this.mHomeLayout);
        if (this.mCustomNavView != null && (0x10 & this.mDisplayOptions) != 0x0) {
            final ViewParent parent = this.mCustomNavView.getParent();
            if (parent != this) {
                if (parent instanceof ViewGroup) {
                    ((ActionBarView)parent).removeView(this.mCustomNavView);
                }
                this.addView(this.mCustomNavView);
            }
        }
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final int paddingLeft = this.getPaddingLeft();
        final int paddingTop = this.getPaddingTop();
        final int n5 = n4 - n2 - this.getPaddingTop() - this.getPaddingBottom();
        if (n5 > 0) {
            ActionBarView$HomeView actionBarView$HomeView;
            if (this.mExpandedActionView != null) {
                actionBarView$HomeView = this.mExpandedHomeLayout;
            }
            else {
                actionBarView$HomeView = this.mHomeLayout;
            }
            int n6;
            if (actionBarView$HomeView.getVisibility() != 8) {
                final int leftOffset = actionBarView$HomeView.getLeftOffset();
                n6 = paddingLeft + (leftOffset + this.positionChild((View)actionBarView$HomeView, paddingLeft + leftOffset, paddingTop, n5));
            }
            else {
                n6 = paddingLeft;
            }
            int n7 = 0;
            Label_0184: {
                if (this.mExpandedActionView == null) {
                    boolean b2;
                    if (this.mTitleLayout != null && this.mTitleLayout.getVisibility() != 8 && (0x8 & this.mDisplayOptions) != 0x0) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    if (b2) {
                        n6 += this.positionChild((View)this.mTitleLayout, n6, paddingTop, n5);
                    }
                    switch (this.mNavigationMode) {
                        case 0: {
                            n7 = n6;
                            break Label_0184;
                        }
                        case 1: {
                            if (this.mListNavLayout != null) {
                                if (b2) {
                                    n6 += this.mItemPadding;
                                }
                                n7 = n6 + (this.positionChild((View)this.mListNavLayout, n6, paddingTop, n5) + this.mItemPadding);
                                break Label_0184;
                            }
                            break;
                        }
                        case 2: {
                            if (this.mTabScrollView != null) {
                                if (b2) {
                                    n6 += this.mItemPadding;
                                }
                                n7 = n6 + (this.positionChild((View)this.mTabScrollView, n6, paddingTop, n5) + this.mItemPadding);
                                break Label_0184;
                            }
                            break;
                        }
                    }
                }
                n7 = n6;
            }
            int n8 = n3 - n - this.getPaddingRight();
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                this.positionChildInverse((View)this.mMenuView, n8, paddingTop, n5);
                n8 -= this.mMenuView.getMeasuredWidth();
            }
            int n9;
            if (this.mIndeterminateProgressView != null && this.mIndeterminateProgressView.getVisibility() != 8) {
                this.positionChildInverse(this.mIndeterminateProgressView, n8, paddingTop, n5);
                n9 = n8 - this.mIndeterminateProgressView.getMeasuredWidth();
            }
            else {
                n9 = n8;
            }
            View view;
            if (this.mExpandedActionView != null) {
                view = this.mExpandedActionView;
            }
            else if ((0x10 & this.mDisplayOptions) != 0x0 && this.mCustomNavView != null) {
                view = this.mCustomNavView;
            }
            else {
                view = null;
            }
            if (view != null) {
                final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
                ActionBar$LayoutParams actionBar$LayoutParams;
                if (layoutParams instanceof ActionBar$LayoutParams) {
                    actionBar$LayoutParams = (ActionBar$LayoutParams)layoutParams;
                }
                else {
                    actionBar$LayoutParams = null;
                }
                int gravity;
                if (actionBar$LayoutParams != null) {
                    gravity = actionBar$LayoutParams.gravity;
                }
                else {
                    gravity = 19;
                }
                final int measuredWidth = view.getMeasuredWidth();
                int n12;
                int n13;
                int n14;
                int n15;
                if (actionBar$LayoutParams != null) {
                    final int n10 = n7 + actionBar$LayoutParams.leftMargin;
                    final int n11 = n9 - actionBar$LayoutParams.rightMargin;
                    final int topMargin = actionBar$LayoutParams.topMargin;
                    final int bottomMargin = actionBar$LayoutParams.bottomMargin;
                    n12 = topMargin;
                    n13 = n11;
                    n14 = n10;
                    n15 = bottomMargin;
                }
                else {
                    n13 = n9;
                    n14 = n7;
                    n15 = 0;
                    n12 = 0;
                }
                int n16 = gravity & 0x7;
                int n18;
                if (n16 == 1) {
                    final int n17 = (this.getRight() - this.getLeft() - measuredWidth) / 2;
                    if (n17 < n14) {
                        n16 = 3;
                    }
                    else if (n17 + measuredWidth > n13) {
                        n16 = 5;
                    }
                    n18 = n16;
                }
                else if (gravity == -1) {
                    n18 = 3;
                }
                else {
                    n18 = n16;
                }
                int n19 = 0;
                switch (n18) {
                    default: {
                        n19 = 0;
                        break;
                    }
                    case 1: {
                        n19 = (this.getRight() - this.getLeft() - measuredWidth) / 2;
                        break;
                    }
                    case 3: {
                        n19 = n14;
                        break;
                    }
                    case 5: {
                        n19 = n13 - measuredWidth;
                        break;
                    }
                }
                int n20 = gravity & 0x70;
                if (gravity == -1) {
                    n20 = 16;
                }
                int n21 = 0;
                switch (n20) {
                    case 16: {
                        n21 = (this.getBottom() - this.getTop() - this.getPaddingBottom() - this.getPaddingTop() - view.getMeasuredHeight()) / 2;
                        break;
                    }
                    case 48: {
                        n21 = n12 + this.getPaddingTop();
                        break;
                    }
                    case 80: {
                        n21 = this.getHeight() - this.getPaddingBottom() - view.getMeasuredHeight() - n15;
                        break;
                    }
                }
                view.layout(n19, n21, n19 + view.getMeasuredWidth(), n21 + view.getMeasuredHeight());
            }
            if (this.mProgressView != null) {
                this.mProgressView.bringToFront();
                final int n22 = this.mProgressView.getMeasuredHeight() / 2;
                this.mProgressView.layout(this.mProgressBarPadding, -n22, this.mProgressBarPadding + this.mProgressView.getMeasuredWidth(), n22);
            }
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final int childCount = this.getChildCount();
        Label_0087: {
            if (!this.mIsCollapsable) {
                break Label_0087;
            }
            int n3 = 0;
            for (int i = 0; i < childCount; ++i) {
                final View child = this.getChildAt(i);
                if (child.getVisibility() != 8 && (child != this.mMenuView || this.mMenuView.getChildCount() != 0)) {
                    ++n3;
                }
            }
            if (n3 != 0) {
                break Label_0087;
            }
            this.setMeasuredDimension(0, 0);
            this.mIsCollapsed = true;
            return;
        }
        this.mIsCollapsed = false;
        if (View$MeasureSpec.getMode(n) != 1073741824) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View$MeasureSpec.getMode(n2) != Integer.MIN_VALUE) {
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
        final int paddingLeft = this.getPaddingLeft();
        final int paddingRight = this.getPaddingRight();
        int min = n4 - n5;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE);
        final int n6 = size - paddingLeft - paddingRight;
        int b = n6 / 2;
        ActionBarView$HomeView actionBarView$HomeView;
        if (this.mExpandedActionView != null) {
            actionBarView$HomeView = this.mExpandedHomeLayout;
        }
        else {
            actionBarView$HomeView = this.mHomeLayout;
        }
        int n9;
        int max;
        if (actionBarView$HomeView.getVisibility() != 8) {
            final ViewGroup$LayoutParams layoutParams = actionBarView$HomeView.getLayoutParams();
            int n7;
            if (layoutParams.width < 0) {
                n7 = View$MeasureSpec.makeMeasureSpec(n6, Integer.MIN_VALUE);
            }
            else {
                n7 = View$MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            actionBarView$HomeView.measure(n7, View$MeasureSpec.makeMeasureSpec(min, 1073741824));
            final int n8 = actionBarView$HomeView.getMeasuredWidth() + actionBarView$HomeView.getLeftOffset();
            n9 = Math.max(0, n6 - n8);
            max = Math.max(0, n9 - n8);
        }
        else {
            max = b;
            n9 = n6;
        }
        if (this.mMenuView != null && this.mMenuView.getParent() == this) {
            n9 = this.measureChildView((View)this.mMenuView, n9, measureSpec, 0);
            b = Math.max(0, b - this.mMenuView.getMeasuredWidth());
        }
        if (this.mIndeterminateProgressView != null && this.mIndeterminateProgressView.getVisibility() != 8) {
            n9 = this.measureChildView(this.mIndeterminateProgressView, n9, measureSpec, 0);
            b = Math.max(0, b - this.mIndeterminateProgressView.getMeasuredWidth());
        }
        boolean b2;
        if (this.mTitleLayout != null && this.mTitleLayout.getVisibility() != 8 && (0x8 & this.mDisplayOptions) != 0x0) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        int a = 0;
        int b3 = 0;
        Label_0536: {
            if (this.mExpandedActionView == null) {
                switch (this.mNavigationMode) {
                    case 1: {
                        if (this.mListNavLayout != null) {
                            int mItemPadding;
                            if (b2) {
                                mItemPadding = 2 * this.mItemPadding;
                            }
                            else {
                                mItemPadding = this.mItemPadding;
                            }
                            final int max2 = Math.max(0, n9 - mItemPadding);
                            final int max3 = Math.max(0, max - mItemPadding);
                            this.mListNavLayout.measure(View$MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE), View$MeasureSpec.makeMeasureSpec(min, 1073741824));
                            final int measuredWidth = this.mListNavLayout.getMeasuredWidth();
                            final int max4 = Math.max(0, max2 - measuredWidth);
                            a = Math.max(0, max3 - measuredWidth);
                            b3 = max4;
                            break Label_0536;
                        }
                        break;
                    }
                    case 2: {
                        if (this.mTabScrollView != null) {
                            int mItemPadding2;
                            if (b2) {
                                mItemPadding2 = 2 * this.mItemPadding;
                            }
                            else {
                                mItemPadding2 = this.mItemPadding;
                            }
                            final int max5 = Math.max(0, n9 - mItemPadding2);
                            final int max6 = Math.max(0, max - mItemPadding2);
                            this.mTabScrollView.measure(View$MeasureSpec.makeMeasureSpec(max5, Integer.MIN_VALUE), View$MeasureSpec.makeMeasureSpec(min, 1073741824));
                            final int measuredWidth2 = this.mTabScrollView.getMeasuredWidth();
                            final int max7 = Math.max(0, max5 - measuredWidth2);
                            a = Math.max(0, max6 - measuredWidth2);
                            b3 = max7;
                            break Label_0536;
                        }
                        break;
                    }
                }
            }
            a = max;
            b3 = n9;
        }
        View view;
        if (this.mExpandedActionView != null) {
            view = this.mExpandedActionView;
        }
        else if ((0x10 & this.mDisplayOptions) != 0x0 && this.mCustomNavView != null) {
            view = this.mCustomNavView;
        }
        else {
            view = null;
        }
        if (view != null) {
            final ViewGroup$LayoutParams generateLayoutParams = this.generateLayoutParams(view.getLayoutParams());
            ActionBar$LayoutParams actionBar$LayoutParams;
            if (generateLayoutParams instanceof ActionBar$LayoutParams) {
                actionBar$LayoutParams = (ActionBar$LayoutParams)generateLayoutParams;
            }
            else {
                actionBar$LayoutParams = null;
            }
            int n10 = 0;
            int n11 = 0;
            if (actionBar$LayoutParams != null) {
                n11 = actionBar$LayoutParams.leftMargin + actionBar$LayoutParams.rightMargin;
                n10 = actionBar$LayoutParams.topMargin + actionBar$LayoutParams.bottomMargin;
            }
            int n12;
            if (this.mContentHeight <= 0) {
                n12 = Integer.MIN_VALUE;
            }
            else if (generateLayoutParams.height != -2) {
                n12 = 1073741824;
            }
            else {
                n12 = Integer.MIN_VALUE;
            }
            if (generateLayoutParams.height >= 0) {
                min = Math.min(generateLayoutParams.height, min);
            }
            final int max8 = Math.max(0, min - n10);
            int n13;
            if (generateLayoutParams.width != -2) {
                n13 = 1073741824;
            }
            else {
                n13 = Integer.MIN_VALUE;
            }
            int min2;
            if (generateLayoutParams.width >= 0) {
                min2 = Math.min(generateLayoutParams.width, b3);
            }
            else {
                min2 = b3;
            }
            final int max9 = Math.max(0, min2 - n11);
            int gravity;
            if (actionBar$LayoutParams != null) {
                gravity = actionBar$LayoutParams.gravity;
            }
            else {
                gravity = 19;
            }
            int n14;
            if ((gravity & 0x7) == 0x1 && generateLayoutParams.width == -1) {
                n14 = 2 * Math.min(a, b);
            }
            else {
                n14 = max9;
            }
            view.measure(View$MeasureSpec.makeMeasureSpec(n14, n13), View$MeasureSpec.makeMeasureSpec(max8, n12));
            b3 -= n11 + view.getMeasuredWidth();
        }
        if (this.mExpandedActionView == null && b2) {
            this.measureChildView((View)this.mTitleLayout, b3, View$MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824), 0);
            Math.max(0, a - this.mTitleLayout.getMeasuredWidth());
        }
        if (this.mContentHeight <= 0) {
            int n15 = 0;
            int n16;
            for (int j = 0; j < childCount; ++j, n15 = n16) {
                n16 = n5 + this.getChildAt(j).getMeasuredHeight();
                if (n16 <= n15) {
                    n16 = n15;
                }
            }
            this.setMeasuredDimension(size, n15);
        }
        else {
            this.setMeasuredDimension(size, n4);
        }
        if (this.mContextView != null) {
            this.mContextView.setContentHeight(this.getMeasuredHeight());
        }
        if (this.mProgressView != null && this.mProgressView.getVisibility() != 8) {
            this.mProgressView.measure(View$MeasureSpec.makeMeasureSpec(size - 2 * this.mProgressBarPadding, 1073741824), View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final ActionBarView$SavedState actionBarView$SavedState = (ActionBarView$SavedState)parcelable;
        super.onRestoreInstanceState(actionBarView$SavedState.getSuperState());
        if (actionBarView$SavedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && this.mOptionsMenu != null) {
            final MenuItem item = this.mOptionsMenu.findItem(actionBarView$SavedState.expandedMenuItemId);
            if (item != null) {
                item.expandActionView();
            }
        }
        if (actionBarView$SavedState.isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }
    
    public Parcelable onSaveInstanceState() {
        final ActionBarView$SavedState actionBarView$SavedState = new ActionBarView$SavedState(super.onSaveInstanceState());
        if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            actionBarView$SavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        actionBarView$SavedState.isOverflowOpen = this.isOverflowMenuShowing();
        return (Parcelable)actionBarView$SavedState;
    }
    
    public void setCallback(final ActionBar$OnNavigationListener mCallback) {
        this.mCallback = mCallback;
    }
    
    public void setCollapsable(final boolean mIsCollapsable) {
        this.mIsCollapsable = mIsCollapsable;
    }
    
    public void setContextView(final ActionBarContextView mContextView) {
        this.mContextView = mContextView;
    }
    
    public void setCustomNavigationView(final View mCustomNavView) {
        boolean b;
        if ((0x10 & this.mDisplayOptions) != 0x0) {
            b = true;
        }
        else {
            b = false;
        }
        if (this.mCustomNavView != null && b) {
            this.removeView(this.mCustomNavView);
        }
        this.mCustomNavView = mCustomNavView;
        if (this.mCustomNavView != null && b) {
            this.addView(this.mCustomNavView);
        }
    }
    
    public void setDisplayOptions(final int mDisplayOptions) {
        int visibility = 8;
        int n = -1;
        boolean b = true;
        if (this.mDisplayOptions != n) {
            n = (mDisplayOptions ^ this.mDisplayOptions);
        }
        this.mDisplayOptions = mDisplayOptions;
        if ((n & 0x1F) != 0x0) {
            final boolean b2 = (mDisplayOptions & 0x2) != 0x0 && b;
            int visibility2;
            if (b2 && this.mExpandedActionView == null) {
                visibility2 = 0;
            }
            else {
                visibility2 = visibility;
            }
            this.mHomeLayout.setVisibility(visibility2);
            if ((n & 0x4) != 0x0) {
                final boolean up = (mDisplayOptions & 0x4) != 0x0 && b;
                this.mHomeLayout.setUp(up);
                if (up) {
                    this.setHomeButtonEnabled(b);
                }
            }
            if ((n & 0x1) != 0x0) {
                final boolean b3 = this.mLogo != null && (mDisplayOptions & 0x1) != 0x0 && b;
                final ActionBarView$HomeView mHomeLayout = this.mHomeLayout;
                Drawable icon;
                if (b3) {
                    icon = this.mLogo;
                }
                else {
                    icon = this.mIcon;
                }
                mHomeLayout.setIcon(icon);
            }
            if ((n & 0x8) != 0x0) {
                if ((mDisplayOptions & 0x8) != 0x0) {
                    this.initTitle();
                }
                else {
                    this.removeView((View)this.mTitleLayout);
                }
            }
            if (this.mTitleLayout != null && (n & 0x6) != 0x0) {
                final boolean b4 = (0x4 & this.mDisplayOptions) != 0x0 && b;
                final View mTitleUpView = this.mTitleUpView;
                if (!b2) {
                    if (b4) {
                        visibility = 0;
                    }
                    else {
                        visibility = 4;
                    }
                }
                mTitleUpView.setVisibility(visibility);
                final LinearLayout mTitleLayout = this.mTitleLayout;
                if (b2 || !b4) {
                    b = false;
                }
                mTitleLayout.setEnabled(b);
            }
            if ((n & 0x10) != 0x0 && this.mCustomNavView != null) {
                if ((mDisplayOptions & 0x10) != 0x0) {
                    this.addView(this.mCustomNavView);
                }
                else {
                    this.removeView(this.mCustomNavView);
                }
            }
            this.requestLayout();
        }
        else {
            this.invalidate();
        }
        if (!this.mHomeLayout.isEnabled()) {
            this.mHomeLayout.setContentDescription((CharSequence)null);
            return;
        }
        if ((mDisplayOptions & 0x4) != 0x0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R$string.abs__action_bar_up_description));
            return;
        }
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R$string.abs__action_bar_home_description));
    }
    
    public void setDropdownAdapter(final SpinnerAdapter spinnerAdapter) {
        this.mSpinnerAdapter = spinnerAdapter;
        if (this.mSpinner != null) {
            this.mSpinner.setAdapter(spinnerAdapter);
        }
    }
    
    public void setDropdownSelectedPosition(final int selection) {
        this.mSpinner.setSelection(selection);
    }
    
    public void setEmbeddedTabView(final ScrollingTabContainerView mTabScrollView) {
        if (this.mTabScrollView != null) {
            this.removeView((View)this.mTabScrollView);
        }
        this.mTabScrollView = mTabScrollView;
        this.mIncludeTabs = (mTabScrollView != null);
        if (this.mIncludeTabs && this.mNavigationMode == 2) {
            this.addView((View)this.mTabScrollView);
            final ViewGroup$LayoutParams layoutParams = this.mTabScrollView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            mTabScrollView.setAllowCollapse(true);
        }
    }
    
    public void setHomeButtonEnabled(final boolean b) {
        this.mHomeLayout.setEnabled(b);
        this.mHomeLayout.setFocusable(b);
        if (!b) {
            this.mHomeLayout.setContentDescription((CharSequence)null);
            return;
        }
        if ((0x4 & this.mDisplayOptions) != 0x0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R$string.abs__action_bar_up_description));
            return;
        }
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R$string.abs__action_bar_home_description));
    }
    
    public void setIcon(final int n) {
        this.setIcon(this.mContext.getResources().getDrawable(n));
    }
    
    public void setIcon(final Drawable drawable) {
        this.mIcon = drawable;
        if (drawable != null && ((0x1 & this.mDisplayOptions) == 0x0 || this.mLogo == null)) {
            this.mHomeLayout.setIcon(drawable);
        }
    }
    
    public void setLogo(final int n) {
        this.setLogo(this.mContext.getResources().getDrawable(n));
    }
    
    public void setLogo(final Drawable drawable) {
        this.mLogo = drawable;
        if (drawable != null && (0x1 & this.mDisplayOptions) != 0x0) {
            this.mHomeLayout.setIcon(drawable);
        }
    }
    
    public void setMenu(final Menu menu, final MenuPresenter$Callback callback) {
        if (menu == this.mOptionsMenu) {
            return;
        }
        if (this.mOptionsMenu != null) {
            this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
            this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        final MenuBuilder mOptionsMenu = (MenuBuilder)menu;
        this.mOptionsMenu = mOptionsMenu;
        if (this.mMenuView != null) {
            final ViewGroup viewGroup = (ViewGroup)this.mMenuView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView((View)this.mMenuView);
            }
        }
        if (this.mActionMenuPresenter == null) {
            (this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext)).setCallback(callback);
            this.mActionMenuPresenter.setId(R$id.abs__action_menu_presenter);
            this.mExpandedMenuPresenter = new ActionBarView$ExpandedActionViewMenuPresenter(this, null);
        }
        final ViewGroup$LayoutParams layoutParams = new ViewGroup$LayoutParams(-2, -1);
        ActionMenuView mMenuView;
        if (!this.mSplitActionBar) {
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(ResourcesCompat.getResources_getBoolean(this.getContext(), R$bool.abs__action_bar_expanded_action_views_exclusive));
            this.configPresenters(mOptionsMenu);
            mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
            final ViewGroup viewGroup2 = (ViewGroup)mMenuView.getParent();
            if (viewGroup2 != null && viewGroup2 != this) {
                viewGroup2.removeView((View)mMenuView);
            }
            this.addView((View)mMenuView, layoutParams);
        }
        else {
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            this.mActionMenuPresenter.setWidthLimit(this.getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            layoutParams.width = -1;
            this.configPresenters(mOptionsMenu);
            mMenuView = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
            if (this.mSplitView != null) {
                final ViewGroup viewGroup3 = (ViewGroup)mMenuView.getParent();
                if (viewGroup3 != null && viewGroup3 != this.mSplitView) {
                    viewGroup3.removeView((View)mMenuView);
                }
                mMenuView.setVisibility(this.getAnimatedVisibility());
                this.mSplitView.addView((View)mMenuView, layoutParams);
            }
            else {
                mMenuView.setLayoutParams(layoutParams);
            }
        }
        this.mMenuView = mMenuView;
    }
    
    public void setNavigationMode(final int mNavigationMode) {
        final int mNavigationMode2 = this.mNavigationMode;
        if (mNavigationMode != mNavigationMode2) {
            switch (mNavigationMode2) {
                case 1: {
                    if (this.mListNavLayout != null) {
                        this.removeView((View)this.mListNavLayout);
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        this.removeView((View)this.mTabScrollView);
                        break;
                    }
                    break;
                }
            }
            switch (mNavigationMode) {
                case 1: {
                    if (this.mSpinner == null) {
                        this.mSpinner = new IcsSpinner(this.mContext, null, R$attr.actionDropDownStyle);
                        this.mListNavLayout = (IcsLinearLayout)LayoutInflater.from(this.mContext).inflate(R$layout.abs__action_bar_tab_bar_view, (ViewGroup)null);
                        final LinearLayout$LayoutParams linearLayout$LayoutParams = new LinearLayout$LayoutParams(-2, -1);
                        linearLayout$LayoutParams.gravity = 17;
                        this.mListNavLayout.addView((View)this.mSpinner, (ViewGroup$LayoutParams)linearLayout$LayoutParams);
                    }
                    if (this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
                        this.mSpinner.setAdapter(this.mSpinnerAdapter);
                    }
                    this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
                    this.addView((View)this.mListNavLayout);
                    break;
                }
                case 2: {
                    if (this.mTabScrollView != null && this.mIncludeTabs) {
                        this.addView((View)this.mTabScrollView);
                        break;
                    }
                    break;
                }
            }
            this.mNavigationMode = mNavigationMode;
            this.requestLayout();
        }
    }
    
    @Override
    public void setSplitActionBar(final boolean splitActionBar) {
        if (this.mSplitActionBar != splitActionBar) {
            if (this.mMenuView != null) {
                final ViewGroup viewGroup = (ViewGroup)this.mMenuView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView((View)this.mMenuView);
                }
                if (splitActionBar) {
                    if (this.mSplitView != null) {
                        this.mSplitView.addView((View)this.mMenuView);
                    }
                }
                else {
                    this.addView((View)this.mMenuView);
                }
            }
            if (this.mSplitView != null) {
                final ActionBarContainer mSplitView = this.mSplitView;
                int visibility;
                if (splitActionBar) {
                    visibility = 0;
                }
                else {
                    visibility = 8;
                }
                mSplitView.setVisibility(visibility);
            }
            super.setSplitActionBar(splitActionBar);
        }
    }
    
    public void setSubtitle(final CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if (this.mSubtitleView != null) {
            this.mSubtitleView.setText(charSequence);
            final TextView mSubtitleView = this.mSubtitleView;
            int visibility;
            if (charSequence != null) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            mSubtitleView.setVisibility(visibility);
            int n;
            if (this.mExpandedActionView == null && (0x8 & this.mDisplayOptions) != 0x0 && (!TextUtils.isEmpty(this.mTitle) || !TextUtils.isEmpty(this.mSubtitle))) {
                n = 1;
            }
            else {
                n = 0;
            }
            final LinearLayout mTitleLayout = this.mTitleLayout;
            int visibility2 = 0;
            if (n == 0) {
                visibility2 = 8;
            }
            mTitleLayout.setVisibility(visibility2);
        }
    }
    
    public void setTitle(final CharSequence titleImpl) {
        this.mUserTitle = true;
        this.setTitleImpl(titleImpl);
    }
    
    public void setWindowCallback(final Window$Callback mWindowCallback) {
        this.mWindowCallback = mWindowCallback;
    }
    
    public void setWindowTitle(final CharSequence titleImpl) {
        if (!this.mUserTitle) {
            this.setTitleImpl(titleImpl);
        }
    }
    
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
