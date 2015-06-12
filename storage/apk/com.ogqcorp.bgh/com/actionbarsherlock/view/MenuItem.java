// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;

public interface MenuItem
{
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    
    boolean collapseActionView();
    
    boolean expandActionView();
    
    ActionProvider getActionProvider();
    
    View getActionView();
    
    char getAlphabeticShortcut();
    
    int getGroupId();
    
    Drawable getIcon();
    
    Intent getIntent();
    
    int getItemId();
    
    ContextMenu$ContextMenuInfo getMenuInfo();
    
    char getNumericShortcut();
    
    int getOrder();
    
    SubMenu getSubMenu();
    
    CharSequence getTitle();
    
    CharSequence getTitleCondensed();
    
    boolean hasSubMenu();
    
    boolean isActionViewExpanded();
    
    boolean isCheckable();
    
    boolean isChecked();
    
    boolean isEnabled();
    
    boolean isVisible();
    
    MenuItem setActionProvider(ActionProvider p0);
    
    MenuItem setActionView(int p0);
    
    MenuItem setActionView(View p0);
    
    MenuItem setAlphabeticShortcut(char p0);
    
    MenuItem setCheckable(boolean p0);
    
    MenuItem setChecked(boolean p0);
    
    MenuItem setEnabled(boolean p0);
    
    MenuItem setIcon(int p0);
    
    MenuItem setIcon(Drawable p0);
    
    MenuItem setIntent(Intent p0);
    
    MenuItem setNumericShortcut(char p0);
    
    MenuItem setOnActionExpandListener(MenuItem$OnActionExpandListener p0);
    
    MenuItem setOnMenuItemClickListener(MenuItem$OnMenuItemClickListener p0);
    
    MenuItem setShortcut(char p0, char p1);
    
    void setShowAsAction(int p0);
    
    MenuItem setShowAsActionFlags(int p0);
    
    MenuItem setTitle(int p0);
    
    MenuItem setTitle(CharSequence p0);
    
    MenuItem setTitleCondensed(CharSequence p0);
    
    MenuItem setVisible(boolean p0);
}
