// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.app;

import com.actionbarsherlock.app.ActionBar$OnNavigationListener;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.os.Build$VERSION;
import android.content.res.Configuration;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet$Builder;
import com.actionbarsherlock.internal.nineoldandroids.animation.ObjectAnimator;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorSet;
import android.view.ContextThemeWrapper;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.internal.ResourcesCompat;
import com.actionbarsherlock.R$bool;
import com.actionbarsherlock.R$id;
import com.actionbarsherlock.app.ActionBar$Tab;
import android.app.Dialog;
import android.view.View;
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener;
import java.util.ArrayList;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import android.os.Handler;
import com.actionbarsherlock.view.ActionMode$Callback;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import android.content.Context;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import android.app.Activity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.app.ActionBar;

public class ActionBarImpl extends ActionBar
{
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionBarImpl$ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private Activity mActivity;
    private ActionBarContainer mContainerView;
    private NineFrameLayout mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private Animator mCurrentModeAnim;
    private Animator mCurrentShowAnim;
    ActionMode mDeferredDestroyActionMode;
    ActionMode$Callback mDeferredModeDestroyCallback;
    final Handler mHandler;
    private boolean mHasEmbeddedTabs;
    final Animator$AnimatorListener mHideListener;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar$OnMenuVisibilityListener> mMenuVisibilityListeners;
    private int mSavedTabPosition;
    private ActionBarImpl$TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    final Animator$AnimatorListener mShowListener;
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<ActionBarImpl$TabImpl> mTabs;
    private Context mThemedContext;
    boolean mWasHiddenBeforeMode;
    
    public ActionBarImpl(final Activity mActivity, final int n) {
        this.mTabs = new ArrayList<ActionBarImpl$TabImpl>();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList<ActionBar$OnMenuVisibilityListener>();
        this.mHandler = new Handler();
        this.mHideListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animator) {
                if (ActionBarImpl.this.mContentView != null) {
                    ActionBarImpl.this.mContentView.setTranslationY(0.0f);
                    ActionBarImpl.this.mContainerView.setTranslationY(0.0f);
                }
                if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == 1) {
                    ActionBarImpl.this.mSplitView.setVisibility(8);
                }
                ActionBarImpl.this.mContainerView.setVisibility(8);
                ActionBarImpl.this.mContainerView.setTransitioning(false);
                ActionBarImpl.this.mCurrentShowAnim = null;
                ActionBarImpl.this.completeDeferredDestroyActionMode();
            }
        };
        this.mShowListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animator) {
                ActionBarImpl.this.mCurrentShowAnim = null;
                ActionBarImpl.this.mContainerView.requestLayout();
            }
        };
        this.mActivity = mActivity;
        final View decorView = mActivity.getWindow().getDecorView();
        this.init(decorView);
        if ((n & 0x200) == 0x0) {
            this.mContentView = (NineFrameLayout)decorView.findViewById(16908290);
        }
    }
    
    public ActionBarImpl(final Dialog dialog) {
        this.mTabs = new ArrayList<ActionBarImpl$TabImpl>();
        this.mSavedTabPosition = -1;
        this.mMenuVisibilityListeners = new ArrayList<ActionBar$OnMenuVisibilityListener>();
        this.mHandler = new Handler();
        this.mHideListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animator) {
                if (ActionBarImpl.this.mContentView != null) {
                    ActionBarImpl.this.mContentView.setTranslationY(0.0f);
                    ActionBarImpl.this.mContainerView.setTranslationY(0.0f);
                }
                if (ActionBarImpl.this.mSplitView != null && ActionBarImpl.this.mContextDisplayMode == 1) {
                    ActionBarImpl.this.mSplitView.setVisibility(8);
                }
                ActionBarImpl.this.mContainerView.setVisibility(8);
                ActionBarImpl.this.mContainerView.setTransitioning(false);
                ActionBarImpl.this.mCurrentShowAnim = null;
                ActionBarImpl.this.completeDeferredDestroyActionMode();
            }
        };
        this.mShowListener = new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animator animator) {
                ActionBarImpl.this.mCurrentShowAnim = null;
                ActionBarImpl.this.mContainerView.requestLayout();
            }
        };
        this.init(dialog.getWindow().getDecorView());
    }
    
    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            this.selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }
    
    private void configureTab(final ActionBar$Tab actionBar$Tab, final int n) {
        final ActionBarImpl$TabImpl element = (ActionBarImpl$TabImpl)actionBar$Tab;
        if (element.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        element.setPosition(n);
        this.mTabs.add(n, element);
        for (int size = this.mTabs.size(), i = n + 1; i < size; ++i) {
            this.mTabs.get(i).setPosition(i);
        }
    }
    
    private void ensureTabsExist() {
        if (this.mTabScrollView != null) {
            return;
        }
        final ScrollingTabContainerView mTabScrollView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            mTabScrollView.setVisibility(0);
            this.mActionView.setEmbeddedTabView(mTabScrollView);
        }
        else {
            final int navigationMode = this.getNavigationMode();
            int visibility = 0;
            if (navigationMode != 2) {
                visibility = 8;
            }
            mTabScrollView.setVisibility(visibility);
            this.mContainerView.setTabContainer(mTabScrollView);
        }
        this.mTabScrollView = mTabScrollView;
    }
    
    private void init(final View view) {
        int n = 1;
        this.mContext = view.getContext();
        this.mActionView = (ActionBarView)view.findViewById(R$id.abs__action_bar);
        this.mContextView = (ActionBarContextView)view.findViewById(R$id.abs__action_context_bar);
        this.mContainerView = (ActionBarContainer)view.findViewById(R$id.abs__action_bar_container);
        this.mSplitView = (ActionBarContainer)view.findViewById(R$id.abs__split_action_bar);
        if (this.mActionView == null || this.mContextView == null || this.mContainerView == null) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.mActionView.setContextView(this.mContextView);
        int mContextDisplayMode;
        if (this.mActionView.isSplitActionBar()) {
            mContextDisplayMode = n;
        }
        else {
            mContextDisplayMode = 0;
        }
        this.mContextDisplayMode = mContextDisplayMode;
        int n2;
        if (this.mContext.getApplicationInfo().targetSdkVersion < 14) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        if ((0x4 & this.mActionView.getDisplayOptions()) == 0x0) {
            n = 0;
        }
        this.setHomeButtonEnabled((n2 | n) != 0x0);
        this.setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, R$bool.abs__action_bar_embed_tabs));
    }
    
    private void setHasEmbeddedTabs(final boolean mHasEmbeddedTabs) {
        boolean collapsable = true;
        if (!(this.mHasEmbeddedTabs = mHasEmbeddedTabs)) {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        }
        else {
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
        }
        final boolean b = this.getNavigationMode() == 2 && collapsable;
        if (this.mTabScrollView != null) {
            final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            mTabScrollView.setVisibility(visibility);
        }
        final ActionBarView mActionView = this.mActionView;
        if (this.mHasEmbeddedTabs || !b) {
            collapsable = false;
        }
        mActionView.setCollapsable(collapsable);
    }
    
    @Override
    public void addOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener e) {
        this.mMenuVisibilityListeners.add(e);
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab) {
        this.addTab(actionBar$Tab, this.mTabs.isEmpty());
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n) {
        this.addTab(actionBar$Tab, n, this.mTabs.isEmpty());
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(actionBar$Tab, n, b);
        this.configureTab(actionBar$Tab, n);
        if (b) {
            this.selectTab(actionBar$Tab);
        }
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(actionBar$Tab, b);
        this.configureTab(actionBar$Tab, this.mTabs.size());
        if (b) {
            this.selectTab(actionBar$Tab);
        }
    }
    
    void animateToMode(final boolean b) {
        int n = 8;
        if (b) {
            this.show(false);
        }
        if (this.mCurrentModeAnim != null) {
            this.mCurrentModeAnim.end();
        }
        final ActionBarView mActionView = this.mActionView;
        int n2;
        if (b) {
            n2 = n;
        }
        else {
            n2 = 0;
        }
        mActionView.animateToVisibility(n2);
        final ActionBarContextView mContextView = this.mContextView;
        int n3;
        if (b) {
            n3 = 0;
        }
        else {
            n3 = n;
        }
        mContextView.animateToVisibility(n3);
        if (this.mTabScrollView != null && !this.mActionView.hasEmbeddedTabs() && this.mActionView.isCollapsed()) {
            final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
            if (!b) {
                n = 0;
            }
            mTabScrollView.animateToVisibility(n);
        }
    }
    
    void completeDeferredDestroyActionMode() {
        if (this.mDeferredModeDestroyCallback != null) {
            this.mDeferredModeDestroyCallback.onDestroyActionMode(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }
    
    public void dispatchMenuVisibilityChanged(final boolean mLastMenuVisibility) {
        if (mLastMenuVisibility != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = mLastMenuVisibility;
            for (int size = this.mMenuVisibilityListeners.size(), i = 0; i < size; ++i) {
                this.mMenuVisibilityListeners.get(i).onMenuVisibilityChanged(mLastMenuVisibility);
            }
        }
    }
    
    @Override
    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }
    
    @Override
    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }
    
    @Override
    public int getHeight() {
        return this.mContainerView.getHeight();
    }
    
    @Override
    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
            case 2: {
                return this.mTabs.size();
            }
            case 1: {
                final SpinnerAdapter dropdownAdapter = this.mActionView.getDropdownAdapter();
                if (dropdownAdapter != null) {
                    return dropdownAdapter.getCount();
                }
                break;
            }
        }
        return 0;
    }
    
    @Override
    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }
    
    @Override
    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            case 2: {
                if (this.mSelectedTab != null) {
                    return this.mSelectedTab.getPosition();
                }
                break;
            }
            case 1: {
                return this.mActionView.getDropdownSelectedPosition();
            }
        }
        return -1;
    }
    
    @Override
    public ActionBar$Tab getSelectedTab() {
        return this.mSelectedTab;
    }
    
    @Override
    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }
    
    @Override
    public ActionBar$Tab getTabAt(final int index) {
        return this.mTabs.get(index);
    }
    
    @Override
    public int getTabCount() {
        return this.mTabs.size();
    }
    
    @Override
    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            final TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            final int resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                this.mThemedContext = (Context)new ContextThemeWrapper(this.mContext, resourceId);
            }
            else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }
    
    @Override
    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }
    
    @Override
    public void hide() {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() == 8) {
            return;
        }
        if (this.mShowHideAnimationEnabled) {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTransitioning(true);
            final AnimatorSet mCurrentShowAnim = new AnimatorSet();
            final AnimatorSet$Builder play = mCurrentShowAnim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 0.0f));
            if (this.mContentView != null) {
                play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", 0.0f, -this.mContainerView.getHeight()));
                play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", -this.mContainerView.getHeight()));
            }
            if (this.mSplitView != null && this.mSplitView.getVisibility() == 0) {
                this.mSplitView.setAlpha(1.0f);
                play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 0.0f));
            }
            mCurrentShowAnim.addListener(this.mHideListener);
            ((AnimatorSet)(this.mCurrentShowAnim = mCurrentShowAnim)).start();
            return;
        }
        this.mHideListener.onAnimationEnd(null);
    }
    
    @Override
    public boolean isShowing() {
        return this.mContainerView.getVisibility() == 0;
    }
    
    @Override
    public ActionBar$Tab newTab() {
        return new ActionBarImpl$TabImpl(this);
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.setHasEmbeddedTabs(ResourcesCompat.getResources_getBoolean(this.mContext, R$bool.abs__action_bar_embed_tabs));
        if (Build$VERSION.SDK_INT < 8) {
            this.mActionView.onConfigurationChanged(configuration);
            if (this.mContextView != null) {
                this.mContextView.onConfigurationChanged(configuration);
            }
        }
    }
    
    @Override
    public void removeAllTabs() {
        this.cleanupTabs();
    }
    
    @Override
    public void removeOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener o) {
        this.mMenuVisibilityListeners.remove(o);
    }
    
    @Override
    public void removeTab(final ActionBar$Tab actionBar$Tab) {
        this.removeTabAt(actionBar$Tab.getPosition());
    }
    
    @Override
    public void removeTabAt(final int index) {
        if (this.mTabScrollView != null) {
            int n;
            if (this.mSelectedTab != null) {
                n = this.mSelectedTab.getPosition();
            }
            else {
                n = this.mSavedTabPosition;
            }
            this.mTabScrollView.removeTabAt(index);
            final ActionBarImpl$TabImpl actionBarImpl$TabImpl = this.mTabs.remove(index);
            if (actionBarImpl$TabImpl != null) {
                actionBarImpl$TabImpl.setPosition(-1);
            }
            for (int size = this.mTabs.size(), i = index; i < size; ++i) {
                this.mTabs.get(i).setPosition(i);
            }
            if (n == index) {
                ActionBar$Tab actionBar$Tab;
                if (this.mTabs.isEmpty()) {
                    actionBar$Tab = null;
                }
                else {
                    actionBar$Tab = this.mTabs.get(Math.max(0, index - 1));
                }
                this.selectTab(actionBar$Tab);
            }
        }
    }
    
    @Override
    public void selectTab(final ActionBar$Tab actionBar$Tab) {
        int position = -1;
        if (this.getNavigationMode() != 2) {
            int position2;
            if (actionBar$Tab != null) {
                position2 = actionBar$Tab.getPosition();
            }
            else {
                position2 = position;
            }
            this.mSavedTabPosition = position2;
        }
        else {
            final boolean b = this.mActivity instanceof FragmentActivity;
            FragmentTransaction disallowAddToBackStack = null;
            if (b) {
                disallowAddToBackStack = ((FragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            }
            if (this.mSelectedTab == actionBar$Tab) {
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, disallowAddToBackStack);
                    this.mTabScrollView.animateToTab(actionBar$Tab.getPosition());
                }
            }
            else {
                final ScrollingTabContainerView mTabScrollView = this.mTabScrollView;
                if (actionBar$Tab != null) {
                    position = actionBar$Tab.getPosition();
                }
                mTabScrollView.setTabSelected(position);
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, disallowAddToBackStack);
                }
                this.mSelectedTab = (ActionBarImpl$TabImpl)actionBar$Tab;
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, disallowAddToBackStack);
                }
            }
            if (disallowAddToBackStack != null && !disallowAddToBackStack.isEmpty()) {
                disallowAddToBackStack.commit();
            }
        }
    }
    
    @Override
    public void setBackgroundDrawable(final Drawable primaryBackground) {
        this.mContainerView.setPrimaryBackground(primaryBackground);
    }
    
    @Override
    public void setCustomView(final int n) {
        this.setCustomView(LayoutInflater.from(this.getThemedContext()).inflate(n, (ViewGroup)this.mActionView, false));
    }
    
    @Override
    public void setCustomView(final View customNavigationView) {
        this.mActionView.setCustomNavigationView(customNavigationView);
    }
    
    @Override
    public void setCustomView(final View customNavigationView, final ActionBar$LayoutParams layoutParams) {
        customNavigationView.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.mActionView.setCustomNavigationView(customNavigationView);
    }
    
    @Override
    public void setDisplayHomeAsUpEnabled(final boolean b) {
        int n;
        if (b) {
            n = 4;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 4);
    }
    
    @Override
    public void setDisplayOptions(final int displayOptions) {
        this.mActionView.setDisplayOptions(displayOptions);
    }
    
    @Override
    public void setDisplayOptions(final int n, final int n2) {
        this.mActionView.setDisplayOptions((n & n2) | (this.mActionView.getDisplayOptions() & ~n2));
    }
    
    @Override
    public void setDisplayShowCustomEnabled(final boolean b) {
        int n;
        if (b) {
            n = 16;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 16);
    }
    
    @Override
    public void setDisplayShowHomeEnabled(final boolean b) {
        int n;
        if (b) {
            n = 2;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 2);
    }
    
    @Override
    public void setDisplayShowTitleEnabled(final boolean b) {
        int n;
        if (b) {
            n = 8;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 8);
    }
    
    @Override
    public void setDisplayUseLogoEnabled(final boolean b) {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.setDisplayOptions(n, 1);
    }
    
    @Override
    public void setHomeButtonEnabled(final boolean homeButtonEnabled) {
        this.mActionView.setHomeButtonEnabled(homeButtonEnabled);
    }
    
    @Override
    public void setIcon(final int icon) {
        this.mActionView.setIcon(icon);
    }
    
    @Override
    public void setIcon(final Drawable icon) {
        this.mActionView.setIcon(icon);
    }
    
    @Override
    public void setListNavigationCallbacks(final SpinnerAdapter dropdownAdapter, final ActionBar$OnNavigationListener callback) {
        this.mActionView.setDropdownAdapter(dropdownAdapter);
        this.mActionView.setCallback(callback);
    }
    
    @Override
    public void setLogo(final int logo) {
        this.mActionView.setLogo(logo);
    }
    
    @Override
    public void setLogo(final Drawable logo) {
        this.mActionView.setLogo(logo);
    }
    
    @Override
    public void setNavigationMode(final int navigationMode) {
        switch (this.mActionView.getNavigationMode()) {
            case 2: {
                this.mSavedTabPosition = this.getSelectedNavigationIndex();
                this.selectTab(null);
                this.mTabScrollView.setVisibility(8);
                break;
            }
        }
        this.mActionView.setNavigationMode(navigationMode);
        switch (navigationMode) {
            case 2: {
                this.ensureTabsExist();
                this.mTabScrollView.setVisibility(0);
                if (this.mSavedTabPosition != -1) {
                    this.setSelectedNavigationItem(this.mSavedTabPosition);
                    this.mSavedTabPosition = -1;
                    break;
                }
                break;
            }
        }
        final ActionBarView mActionView = this.mActionView;
        boolean collapsable = false;
        if (navigationMode == 2) {
            final boolean mHasEmbeddedTabs = this.mHasEmbeddedTabs;
            collapsable = false;
            if (!mHasEmbeddedTabs) {
                collapsable = true;
            }
        }
        mActionView.setCollapsable(collapsable);
    }
    
    @Override
    public void setSelectedNavigationItem(final int n) {
        switch (this.mActionView.getNavigationMode()) {
            default: {
                throw new IllegalStateException("setSelectedNavigationItem not valid for current navigation mode");
            }
            case 2: {
                this.selectTab(this.mTabs.get(n));
            }
            case 1: {
                this.mActionView.setDropdownSelectedPosition(n);
            }
        }
    }
    
    public void setShowHideAnimationEnabled(final boolean mShowHideAnimationEnabled) {
        this.mShowHideAnimationEnabled = mShowHideAnimationEnabled;
        if (!mShowHideAnimationEnabled && this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
    }
    
    @Override
    public void setSplitBackgroundDrawable(final Drawable splitBackground) {
        if (this.mSplitView != null) {
            this.mSplitView.setSplitBackground(splitBackground);
        }
    }
    
    @Override
    public void setStackedBackgroundDrawable(final Drawable stackedBackground) {
        this.mContainerView.setStackedBackground(stackedBackground);
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(this.mContext.getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        this.mActionView.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(this.mContext.getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.mActionView.setTitle(title);
    }
    
    @Override
    public void show() {
        this.show(true);
    }
    
    void show(final boolean b) {
        if (this.mCurrentShowAnim != null) {
            this.mCurrentShowAnim.end();
        }
        if (this.mContainerView.getVisibility() == 0) {
            if (b) {
                this.mWasHiddenBeforeMode = false;
            }
            return;
        }
        this.mContainerView.setVisibility(0);
        if (this.mShowHideAnimationEnabled) {
            this.mContainerView.setAlpha(0.0f);
            final AnimatorSet mCurrentShowAnim = new AnimatorSet();
            final AnimatorSet$Builder play = mCurrentShowAnim.play(ObjectAnimator.ofFloat(this.mContainerView, "alpha", 1.0f));
            if (this.mContentView != null) {
                play.with(ObjectAnimator.ofFloat(this.mContentView, "translationY", -this.mContainerView.getHeight(), 0.0f));
                this.mContainerView.setTranslationY(-this.mContainerView.getHeight());
                play.with(ObjectAnimator.ofFloat(this.mContainerView, "translationY", 0.0f));
            }
            if (this.mSplitView != null && this.mContextDisplayMode == 1) {
                this.mSplitView.setAlpha(0.0f);
                this.mSplitView.setVisibility(0);
                play.with(ObjectAnimator.ofFloat(this.mSplitView, "alpha", 1.0f));
            }
            mCurrentShowAnim.addListener(this.mShowListener);
            ((AnimatorSet)(this.mCurrentShowAnim = mCurrentShowAnim)).start();
            return;
        }
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTranslationY(0.0f);
        this.mShowListener.onAnimationEnd(null);
    }
    
    public ActionMode startActionMode(final ActionMode$Callback actionMode$Callback) {
        boolean mWasHiddenBeforeMode;
        if (this.mActionMode != null) {
            mWasHiddenBeforeMode = this.mWasHiddenBeforeMode;
            this.mActionMode.finish();
        }
        else {
            mWasHiddenBeforeMode = false;
        }
        this.mContextView.killMode();
        final ActionBarImpl$ActionModeImpl mActionMode = new ActionBarImpl$ActionModeImpl(this, actionMode$Callback);
        if (mActionMode.dispatchOnCreate()) {
            this.mWasHiddenBeforeMode = (!this.isShowing() || mWasHiddenBeforeMode);
            mActionMode.invalidate();
            this.mContextView.initForMode(mActionMode);
            this.animateToMode(true);
            if (this.mSplitView != null && this.mContextDisplayMode == 1) {
                this.mSplitView.setVisibility(0);
            }
            this.mContextView.sendAccessibilityEvent(32);
            return this.mActionMode = mActionMode;
        }
        return null;
    }
}
