// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import android.widget.SpinnerAdapter;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.view.View;

public abstract class ActionBar
{
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;
    
    public abstract void addOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener p0);
    
    public abstract void addTab(final ActionBar$Tab p0);
    
    public abstract void addTab(final ActionBar$Tab p0, final int p1);
    
    public abstract void addTab(final ActionBar$Tab p0, final int p1, final boolean p2);
    
    public abstract void addTab(final ActionBar$Tab p0, final boolean p1);
    
    public abstract View getCustomView();
    
    public abstract int getDisplayOptions();
    
    public abstract int getHeight();
    
    public abstract int getNavigationItemCount();
    
    public abstract int getNavigationMode();
    
    public abstract int getSelectedNavigationIndex();
    
    public abstract ActionBar$Tab getSelectedTab();
    
    public abstract CharSequence getSubtitle();
    
    public abstract ActionBar$Tab getTabAt(final int p0);
    
    public abstract int getTabCount();
    
    public Context getThemedContext() {
        return null;
    }
    
    public abstract CharSequence getTitle();
    
    public abstract void hide();
    
    public abstract boolean isShowing();
    
    public abstract ActionBar$Tab newTab();
    
    public abstract void removeAllTabs();
    
    public abstract void removeOnMenuVisibilityListener(final ActionBar$OnMenuVisibilityListener p0);
    
    public abstract void removeTab(final ActionBar$Tab p0);
    
    public abstract void removeTabAt(final int p0);
    
    public abstract void selectTab(final ActionBar$Tab p0);
    
    public abstract void setBackgroundDrawable(final Drawable p0);
    
    public abstract void setCustomView(final int p0);
    
    public abstract void setCustomView(final View p0);
    
    public abstract void setCustomView(final View p0, final ActionBar$LayoutParams p1);
    
    public abstract void setDisplayHomeAsUpEnabled(final boolean p0);
    
    public abstract void setDisplayOptions(final int p0);
    
    public abstract void setDisplayOptions(final int p0, final int p1);
    
    public abstract void setDisplayShowCustomEnabled(final boolean p0);
    
    public abstract void setDisplayShowHomeEnabled(final boolean p0);
    
    public abstract void setDisplayShowTitleEnabled(final boolean p0);
    
    public abstract void setDisplayUseLogoEnabled(final boolean p0);
    
    public void setHomeButtonEnabled(final boolean b) {
    }
    
    public abstract void setIcon(final int p0);
    
    public abstract void setIcon(final Drawable p0);
    
    public abstract void setListNavigationCallbacks(final SpinnerAdapter p0, final ActionBar$OnNavigationListener p1);
    
    public abstract void setLogo(final int p0);
    
    public abstract void setLogo(final Drawable p0);
    
    public abstract void setNavigationMode(final int p0);
    
    public abstract void setSelectedNavigationItem(final int p0);
    
    public void setSplitBackgroundDrawable(final Drawable drawable) {
    }
    
    public void setStackedBackgroundDrawable(final Drawable drawable) {
    }
    
    public abstract void setSubtitle(final int p0);
    
    public abstract void setSubtitle(final CharSequence p0);
    
    public abstract void setTitle(final int p0);
    
    public abstract void setTitle(final CharSequence p0);
    
    public abstract void show();
}
