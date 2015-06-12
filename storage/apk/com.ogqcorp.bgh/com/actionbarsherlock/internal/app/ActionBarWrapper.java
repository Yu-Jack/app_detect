// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.app;

import android.widget.SpinnerAdapter;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import android.content.Context;
import android.view.View;
import com.actionbarsherlock.app.ActionBar$Tab;
import java.util.HashSet;
import java.util.Set;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
import android.app.ActionBar$OnNavigationListener;
import android.app.ActionBar$OnMenuVisibilityListener;
import com.actionbarsherlock.app.ActionBar;

public class ActionBarWrapper extends ActionBar implements ActionBar$OnMenuVisibilityListener, ActionBar$OnNavigationListener
{
    private final android.app.ActionBar mActionBar;
    private final Activity mActivity;
    private FragmentTransaction mFragmentTransaction;
    private Set<com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener> mMenuVisibilityListeners;
    private com.actionbarsherlock.app.ActionBar$OnNavigationListener mNavigationListener;
    
    public ActionBarWrapper(final Activity mActivity) {
        boolean b = true;
        this.mMenuVisibilityListeners = new HashSet<com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener>(b ? 1 : 0);
        this.mActivity = mActivity;
        this.mActionBar = mActivity.getActionBar();
        if (this.mActionBar != null) {
            this.mActionBar.addOnMenuVisibilityListener((ActionBar$OnMenuVisibilityListener)this);
            final int displayOptions = this.mActionBar.getDisplayOptions();
            final android.app.ActionBar mActionBar = this.mActionBar;
            if ((displayOptions & 0x4) == 0x0) {
                b = false;
            }
            mActionBar.setHomeButtonEnabled(b);
        }
    }
    
    @Override
    public void addOnMenuVisibilityListener(final com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(actionBar$OnMenuVisibilityListener);
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab) {
        this.mActionBar.addTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab);
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n) {
        this.mActionBar.addTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab, n);
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final int n, final boolean b) {
        this.mActionBar.addTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab, n, b);
    }
    
    @Override
    public void addTab(final ActionBar$Tab actionBar$Tab, final boolean b) {
        this.mActionBar.addTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab, b);
    }
    
    @Override
    public View getCustomView() {
        return this.mActionBar.getCustomView();
    }
    
    @Override
    public int getDisplayOptions() {
        return this.mActionBar.getDisplayOptions();
    }
    
    @Override
    public int getHeight() {
        return this.mActionBar.getHeight();
    }
    
    @Override
    public int getNavigationItemCount() {
        return this.mActionBar.getNavigationItemCount();
    }
    
    @Override
    public int getNavigationMode() {
        return this.mActionBar.getNavigationMode();
    }
    
    @Override
    public int getSelectedNavigationIndex() {
        return this.mActionBar.getSelectedNavigationIndex();
    }
    
    @Override
    public ActionBar$Tab getSelectedTab() {
        final android.app.ActionBar$Tab selectedTab = this.mActionBar.getSelectedTab();
        if (selectedTab != null) {
            return (ActionBar$Tab)selectedTab.getTag();
        }
        return null;
    }
    
    @Override
    public CharSequence getSubtitle() {
        return this.mActionBar.getSubtitle();
    }
    
    @Override
    public ActionBar$Tab getTabAt(final int n) {
        final android.app.ActionBar$Tab tab = this.mActionBar.getTabAt(n);
        if (tab != null) {
            return (ActionBar$Tab)tab.getTag();
        }
        return null;
    }
    
    @Override
    public int getTabCount() {
        return this.mActionBar.getTabCount();
    }
    
    @Override
    public Context getThemedContext() {
        return this.mActionBar.getThemedContext();
    }
    
    @Override
    public CharSequence getTitle() {
        return this.mActionBar.getTitle();
    }
    
    @Override
    public void hide() {
        this.mActionBar.hide();
    }
    
    @Override
    public boolean isShowing() {
        return this.mActionBar.isShowing();
    }
    
    @Override
    public ActionBar$Tab newTab() {
        return new ActionBarWrapper$TabWrapper(this, this.mActionBar.newTab());
    }
    
    public void onMenuVisibilityChanged(final boolean b) {
        final Iterator<com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener> iterator = this.mMenuVisibilityListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().onMenuVisibilityChanged(b);
        }
    }
    
    public boolean onNavigationItemSelected(final int n, final long n2) {
        return this.mNavigationListener.onNavigationItemSelected(n, n2);
    }
    
    @Override
    public void removeAllTabs() {
        this.mActionBar.removeAllTabs();
    }
    
    @Override
    public void removeOnMenuVisibilityListener(final com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(actionBar$OnMenuVisibilityListener);
    }
    
    @Override
    public void removeTab(final ActionBar$Tab actionBar$Tab) {
        this.mActionBar.removeTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab);
    }
    
    @Override
    public void removeTabAt(final int n) {
        this.mActionBar.removeTabAt(n);
    }
    
    @Override
    public void selectTab(final ActionBar$Tab actionBar$Tab) {
        this.mActionBar.selectTab(((ActionBarWrapper$TabWrapper)actionBar$Tab).mNativeTab);
    }
    
    @Override
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        this.mActionBar.setBackgroundDrawable(backgroundDrawable);
    }
    
    @Override
    public void setCustomView(final int customView) {
        this.mActionBar.setCustomView(customView);
    }
    
    @Override
    public void setCustomView(final View customView) {
        this.mActionBar.setCustomView(customView);
    }
    
    @Override
    public void setCustomView(final View view, final ActionBar$LayoutParams actionBar$LayoutParams) {
        final android.app.ActionBar$LayoutParams actionBar$LayoutParams2 = new android.app.ActionBar$LayoutParams((ViewGroup$LayoutParams)actionBar$LayoutParams);
        actionBar$LayoutParams2.gravity = actionBar$LayoutParams.gravity;
        actionBar$LayoutParams2.bottomMargin = actionBar$LayoutParams.bottomMargin;
        actionBar$LayoutParams2.topMargin = actionBar$LayoutParams.topMargin;
        actionBar$LayoutParams2.leftMargin = actionBar$LayoutParams.leftMargin;
        actionBar$LayoutParams2.rightMargin = actionBar$LayoutParams.rightMargin;
        this.mActionBar.setCustomView(view, actionBar$LayoutParams2);
    }
    
    @Override
    public void setDisplayHomeAsUpEnabled(final boolean displayHomeAsUpEnabled) {
        this.mActionBar.setDisplayHomeAsUpEnabled(displayHomeAsUpEnabled);
    }
    
    @Override
    public void setDisplayOptions(final int displayOptions) {
        this.mActionBar.setDisplayOptions(displayOptions);
        this.mActionBar.setHomeButtonEnabled((displayOptions & 0x4) != 0x0);
    }
    
    @Override
    public void setDisplayOptions(final int n, final int n2) {
        this.mActionBar.setDisplayOptions(n, n2);
        if ((n2 & 0x4) != 0x0) {
            this.mActionBar.setHomeButtonEnabled((n & 0x4) != 0x0);
        }
    }
    
    @Override
    public void setDisplayShowCustomEnabled(final boolean displayShowCustomEnabled) {
        this.mActionBar.setDisplayShowCustomEnabled(displayShowCustomEnabled);
    }
    
    @Override
    public void setDisplayShowHomeEnabled(final boolean displayShowHomeEnabled) {
        this.mActionBar.setDisplayShowHomeEnabled(displayShowHomeEnabled);
    }
    
    @Override
    public void setDisplayShowTitleEnabled(final boolean displayShowTitleEnabled) {
        this.mActionBar.setDisplayShowTitleEnabled(displayShowTitleEnabled);
    }
    
    @Override
    public void setDisplayUseLogoEnabled(final boolean displayUseLogoEnabled) {
        this.mActionBar.setDisplayUseLogoEnabled(displayUseLogoEnabled);
    }
    
    @Override
    public void setHomeButtonEnabled(final boolean homeButtonEnabled) {
        this.mActionBar.setHomeButtonEnabled(homeButtonEnabled);
    }
    
    @Override
    public void setIcon(final int icon) {
        this.mActionBar.setIcon(icon);
    }
    
    @Override
    public void setIcon(final Drawable icon) {
        this.mActionBar.setIcon(icon);
    }
    
    @Override
    public void setListNavigationCallbacks(final SpinnerAdapter spinnerAdapter, final com.actionbarsherlock.app.ActionBar$OnNavigationListener mNavigationListener) {
        this.mNavigationListener = mNavigationListener;
        final android.app.ActionBar mActionBar = this.mActionBar;
        final ActionBar$OnNavigationListener actionBar$OnNavigationListener;
        if (mNavigationListener == null) {
            actionBar$OnNavigationListener = null;
        }
        mActionBar.setListNavigationCallbacks(spinnerAdapter, actionBar$OnNavigationListener);
    }
    
    @Override
    public void setLogo(final int logo) {
        this.mActionBar.setLogo(logo);
    }
    
    @Override
    public void setLogo(final Drawable logo) {
        this.mActionBar.setLogo(logo);
    }
    
    @Override
    public void setNavigationMode(final int navigationMode) {
        this.mActionBar.setNavigationMode(navigationMode);
    }
    
    @Override
    public void setSelectedNavigationItem(final int selectedNavigationItem) {
        this.mActionBar.setSelectedNavigationItem(selectedNavigationItem);
    }
    
    @Override
    public void setSplitBackgroundDrawable(final Drawable splitBackgroundDrawable) {
        this.mActionBar.setSplitBackgroundDrawable(splitBackgroundDrawable);
    }
    
    @Override
    public void setStackedBackgroundDrawable(final Drawable stackedBackgroundDrawable) {
        this.mActionBar.setStackedBackgroundDrawable(stackedBackgroundDrawable);
    }
    
    @Override
    public void setSubtitle(final int subtitle) {
        this.mActionBar.setSubtitle(subtitle);
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        this.mActionBar.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int title) {
        this.mActionBar.setTitle(title);
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.mActionBar.setTitle(title);
    }
    
    @Override
    public void show() {
        this.mActionBar.show();
    }
}
