// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.view.View;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class SubMenuWrapper extends MenuWrapper implements SubMenu
{
    private MenuItem mItem;
    private final android.view.SubMenu mNativeSubMenu;
    
    public SubMenuWrapper(final android.view.SubMenu mNativeSubMenu) {
        super((android.view.Menu)mNativeSubMenu);
        this.mItem = null;
        this.mNativeSubMenu = mNativeSubMenu;
    }
    
    @Override
    public void clearHeader() {
        this.mNativeSubMenu.clearHeader();
    }
    
    @Override
    public MenuItem getItem() {
        if (this.mItem == null) {
            this.mItem = new MenuItemWrapper(this.mNativeSubMenu.getItem());
        }
        return this.mItem;
    }
    
    @Override
    public SubMenu setHeaderIcon(final int headerIcon) {
        this.mNativeSubMenu.setHeaderIcon(headerIcon);
        return this;
    }
    
    @Override
    public SubMenu setHeaderIcon(final Drawable headerIcon) {
        this.mNativeSubMenu.setHeaderIcon(headerIcon);
        return this;
    }
    
    @Override
    public SubMenu setHeaderTitle(final int headerTitle) {
        this.mNativeSubMenu.setHeaderTitle(headerTitle);
        return this;
    }
    
    @Override
    public SubMenu setHeaderTitle(final CharSequence headerTitle) {
        this.mNativeSubMenu.setHeaderTitle(headerTitle);
        return this;
    }
    
    @Override
    public SubMenu setHeaderView(final View headerView) {
        this.mNativeSubMenu.setHeaderView(headerView);
        return this;
    }
    
    @Override
    public SubMenu setIcon(final int icon) {
        this.mNativeSubMenu.setIcon(icon);
        return this;
    }
    
    @Override
    public SubMenu setIcon(final Drawable icon) {
        this.mNativeSubMenu.setIcon(icon);
        return this;
    }
}
