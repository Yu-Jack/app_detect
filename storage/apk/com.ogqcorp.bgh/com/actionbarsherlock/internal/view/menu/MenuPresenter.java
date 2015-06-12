// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.os.Parcelable;
import android.content.Context;
import android.view.ViewGroup;

public interface MenuPresenter
{
    boolean collapseItemActionView(MenuBuilder p0, MenuItemImpl p1);
    
    boolean expandItemActionView(MenuBuilder p0, MenuItemImpl p1);
    
    boolean flagActionItems();
    
    int getId();
    
    MenuView getMenuView(ViewGroup p0);
    
    void initForMenu(Context p0, MenuBuilder p1);
    
    void onCloseMenu(MenuBuilder p0, boolean p1);
    
    void onRestoreInstanceState(Parcelable p0);
    
    Parcelable onSaveInstanceState();
    
    boolean onSubMenuSelected(SubMenuBuilder p0);
    
    void setCallback(MenuPresenter$Callback p0);
    
    void updateMenuView(boolean p0);
}
