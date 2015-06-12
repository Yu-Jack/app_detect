// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.graphics.drawable.Drawable;

public interface MenuView$ItemView
{
    MenuItemImpl getItemData();
    
    void initialize(MenuItemImpl p0, int p1);
    
    boolean prefersCondensedTitle();
    
    void setCheckable(boolean p0);
    
    void setChecked(boolean p0);
    
    void setEnabled(boolean p0);
    
    void setIcon(Drawable p0);
    
    void setShortcut(boolean p0, char p1);
    
    void setTitle(CharSequence p0);
    
    boolean showsIcon();
}
