// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import com.actionbarsherlock.view.CollapsibleActionView;
import android.view.ContextMenu$ContextMenuInfo;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.actionbarsherlock.internal.widget.CollapsibleActionViewWrapper;
import android.view.View;
import com.actionbarsherlock.internal.view.ActionProviderWrapper;
import com.actionbarsherlock.view.ActionProvider;
import com.actionbarsherlock.view.SubMenu;
import com.actionbarsherlock.view.MenuItem$OnActionExpandListener;
import com.actionbarsherlock.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

public class MenuItemWrapper implements MenuItem$OnMenuItemClickListener, MenuItem
{
    private MenuItem$OnActionExpandListener mActionExpandListener;
    private com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener mMenuItemClickListener;
    private android.view.MenuItem$OnActionExpandListener mNativeActionExpandListener;
    private final android.view.MenuItem mNativeItem;
    private SubMenu mSubMenu;
    
    public MenuItemWrapper(final android.view.MenuItem mNativeItem) {
        this.mSubMenu = null;
        this.mMenuItemClickListener = null;
        this.mActionExpandListener = null;
        this.mNativeActionExpandListener = null;
        if (mNativeItem == null) {
            throw new IllegalStateException("Wrapped menu item cannot be null.");
        }
        this.mNativeItem = mNativeItem;
    }
    
    public boolean collapseActionView() {
        return this.mNativeItem.collapseActionView();
    }
    
    public boolean expandActionView() {
        return this.mNativeItem.expandActionView();
    }
    
    public ActionProvider getActionProvider() {
        final android.view.ActionProvider actionProvider = this.mNativeItem.getActionProvider();
        if (actionProvider != null && actionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper)actionProvider).unwrap();
        }
        return null;
    }
    
    public View getActionView() {
        View view = this.mNativeItem.getActionView();
        if (view instanceof CollapsibleActionViewWrapper) {
            view = ((CollapsibleActionViewWrapper)view).unwrap();
        }
        return view;
    }
    
    public char getAlphabeticShortcut() {
        return this.mNativeItem.getAlphabeticShortcut();
    }
    
    public int getGroupId() {
        return this.mNativeItem.getGroupId();
    }
    
    public Drawable getIcon() {
        return this.mNativeItem.getIcon();
    }
    
    public Intent getIntent() {
        return this.mNativeItem.getIntent();
    }
    
    public int getItemId() {
        return this.mNativeItem.getItemId();
    }
    
    public ContextMenu$ContextMenuInfo getMenuInfo() {
        return this.mNativeItem.getMenuInfo();
    }
    
    public char getNumericShortcut() {
        return this.mNativeItem.getNumericShortcut();
    }
    
    public int getOrder() {
        return this.mNativeItem.getOrder();
    }
    
    public SubMenu getSubMenu() {
        if (this.hasSubMenu() && this.mSubMenu == null) {
            this.mSubMenu = new SubMenuWrapper(this.mNativeItem.getSubMenu());
        }
        return this.mSubMenu;
    }
    
    public CharSequence getTitle() {
        return this.mNativeItem.getTitle();
    }
    
    public CharSequence getTitleCondensed() {
        return this.mNativeItem.getTitleCondensed();
    }
    
    public boolean hasSubMenu() {
        return this.mNativeItem.hasSubMenu();
    }
    
    public boolean isActionViewExpanded() {
        return this.mNativeItem.isActionViewExpanded();
    }
    
    public boolean isCheckable() {
        return this.mNativeItem.isCheckable();
    }
    
    public boolean isChecked() {
        return this.mNativeItem.isChecked();
    }
    
    public boolean isEnabled() {
        return this.mNativeItem.isEnabled();
    }
    
    public boolean isVisible() {
        return this.mNativeItem.isVisible();
    }
    
    public boolean onMenuItemClick(final android.view.MenuItem menuItem) {
        return this.mMenuItemClickListener != null && this.mMenuItemClickListener.onMenuItemClick(this);
    }
    
    public MenuItem setActionProvider(final ActionProvider actionProvider) {
        this.mNativeItem.setActionProvider((android.view.ActionProvider)new ActionProviderWrapper(actionProvider));
        return this;
    }
    
    public MenuItem setActionView(final int actionView) {
        this.mNativeItem.setActionView(actionView);
        if (actionView != 0) {
            final View actionView2 = this.mNativeItem.getActionView();
            if (actionView2 instanceof CollapsibleActionView) {
                this.mNativeItem.setActionView((View)new CollapsibleActionViewWrapper(actionView2));
            }
        }
        return this;
    }
    
    public MenuItem setActionView(View actionView) {
        if (actionView != null && actionView instanceof CollapsibleActionView) {
            actionView = (View)new CollapsibleActionViewWrapper(actionView);
        }
        this.mNativeItem.setActionView(actionView);
        return this;
    }
    
    public MenuItem setAlphabeticShortcut(final char alphabeticShortcut) {
        this.mNativeItem.setAlphabeticShortcut(alphabeticShortcut);
        return this;
    }
    
    public MenuItem setCheckable(final boolean checkable) {
        this.mNativeItem.setCheckable(checkable);
        return this;
    }
    
    public MenuItem setChecked(final boolean checked) {
        this.mNativeItem.setChecked(checked);
        return this;
    }
    
    public MenuItem setEnabled(final boolean enabled) {
        this.mNativeItem.setEnabled(enabled);
        return this;
    }
    
    public MenuItem setIcon(final int icon) {
        this.mNativeItem.setIcon(icon);
        return this;
    }
    
    public MenuItem setIcon(final Drawable icon) {
        this.mNativeItem.setIcon(icon);
        return this;
    }
    
    public MenuItem setIntent(final Intent intent) {
        this.mNativeItem.setIntent(intent);
        return this;
    }
    
    public MenuItem setNumericShortcut(final char numericShortcut) {
        this.mNativeItem.setNumericShortcut(numericShortcut);
        return this;
    }
    
    public MenuItem setOnActionExpandListener(final MenuItem$OnActionExpandListener mActionExpandListener) {
        this.mActionExpandListener = mActionExpandListener;
        if (this.mNativeActionExpandListener == null) {
            this.mNativeActionExpandListener = (android.view.MenuItem$OnActionExpandListener)new android.view.MenuItem$OnActionExpandListener() {
                public boolean onMenuItemActionCollapse(final android.view.MenuItem menuItem) {
                    return MenuItemWrapper.this.mActionExpandListener != null && MenuItemWrapper.this.mActionExpandListener.onMenuItemActionCollapse(MenuItemWrapper.this);
                }
                
                public boolean onMenuItemActionExpand(final android.view.MenuItem menuItem) {
                    return MenuItemWrapper.this.mActionExpandListener != null && MenuItemWrapper.this.mActionExpandListener.onMenuItemActionExpand(MenuItemWrapper.this);
                }
            };
            this.mNativeItem.setOnActionExpandListener(this.mNativeActionExpandListener);
        }
        return this;
    }
    
    public MenuItem setOnMenuItemClickListener(final com.actionbarsherlock.view.MenuItem$OnMenuItemClickListener mMenuItemClickListener) {
        this.mMenuItemClickListener = mMenuItemClickListener;
        this.mNativeItem.setOnMenuItemClickListener((MenuItem$OnMenuItemClickListener)this);
        return this;
    }
    
    public MenuItem setShortcut(final char c, final char c2) {
        this.mNativeItem.setShortcut(c, c2);
        return this;
    }
    
    public void setShowAsAction(final int showAsAction) {
        this.mNativeItem.setShowAsAction(showAsAction);
    }
    
    public MenuItem setShowAsActionFlags(final int showAsActionFlags) {
        this.mNativeItem.setShowAsActionFlags(showAsActionFlags);
        return this;
    }
    
    public MenuItem setTitle(final int title) {
        this.mNativeItem.setTitle(title);
        return this;
    }
    
    public MenuItem setTitle(final CharSequence title) {
        this.mNativeItem.setTitle(title);
        return this;
    }
    
    public MenuItem setTitleCondensed(final CharSequence titleCondensed) {
        this.mNativeItem.setTitleCondensed(titleCondensed);
        return this;
    }
    
    public MenuItem setVisible(final boolean visible) {
        this.mNativeItem.setVisible(visible);
        return this;
    }
}
