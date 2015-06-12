// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.LinearLayout$LayoutParams;
import com.actionbarsherlock.internal.view.menu.ActionMenuView;
import com.actionbarsherlock.R$bool;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import com.actionbarsherlock.view.Menu;
import android.view.View$MeasureSpec;
import android.view.ViewParent;
import android.content.res.Configuration;
import com.actionbarsherlock.app.ActionBar$LayoutParams;
import android.view.ViewGroup$LayoutParams;
import android.text.TextUtils;
import com.actionbarsherlock.R$id;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.actionbarsherlock.R$string;
import com.actionbarsherlock.R$layout;
import android.view.LayoutInflater;
import com.actionbarsherlock.internal.ResourcesCompat;
import android.app.Activity;
import android.os.Build$VERSION;
import com.actionbarsherlock.R$attr;
import com.actionbarsherlock.R$styleable;
import com.actionbarsherlock.view.MenuItem;
import android.util.AttributeSet;
import com.actionbarsherlock.view.Window$Callback;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.SpinnerAdapter;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import android.view.View$OnClickListener;
import com.actionbarsherlock.app.ActionBar$OnNavigationListener;
import com.actionbarsherlock.internal.view.menu.MenuPresenter$Callback;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import android.os.Parcelable;
import android.content.Context;
import com.actionbarsherlock.internal.view.menu.MenuView;
import android.view.ViewGroup;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.actionbarsherlock.view.CollapsibleActionView;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import com.actionbarsherlock.internal.view.menu.MenuPresenter;

class ActionBarView$ExpandedActionViewMenuPresenter implements MenuPresenter
{
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;
    final /* synthetic */ ActionBarView this$0;
    
    private ActionBarView$ExpandedActionViewMenuPresenter(final ActionBarView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean collapseItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
        }
        this.this$0.removeView(this.this$0.mExpandedActionView);
        this.this$0.removeView((View)this.this$0.mExpandedHomeLayout);
        this.this$0.mExpandedActionView = null;
        if ((0x2 & this.this$0.mDisplayOptions) != 0x0) {
            this.this$0.mHomeLayout.setVisibility(0);
        }
        if ((0x8 & this.this$0.mDisplayOptions) != 0x0) {
            if (this.this$0.mTitleLayout == null) {
                this.this$0.initTitle();
            }
            else {
                this.this$0.mTitleLayout.setVisibility(0);
            }
        }
        if (this.this$0.mTabScrollView != null && this.this$0.mNavigationMode == 2) {
            this.this$0.mTabScrollView.setVisibility(0);
        }
        if (this.this$0.mSpinner != null && this.this$0.mNavigationMode == 1) {
            this.this$0.mSpinner.setVisibility(0);
        }
        if (this.this$0.mCustomNavView != null && (0x10 & this.this$0.mDisplayOptions) != 0x0) {
            this.this$0.mCustomNavView.setVisibility(0);
        }
        this.this$0.mExpandedHomeLayout.setIcon(null);
        this.mCurrentExpandedItem = null;
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }
    
    @Override
    public boolean expandItemActionView(final MenuBuilder menuBuilder, final MenuItemImpl mCurrentExpandedItem) {
        this.this$0.mExpandedActionView = mCurrentExpandedItem.getActionView();
        this.this$0.mExpandedHomeLayout.setIcon(this.this$0.mIcon.getConstantState().newDrawable());
        this.mCurrentExpandedItem = mCurrentExpandedItem;
        if (this.this$0.mExpandedActionView.getParent() != this.this$0) {
            this.this$0.addView(this.this$0.mExpandedActionView);
        }
        if (this.this$0.mExpandedHomeLayout.getParent() != this.this$0) {
            this.this$0.addView((View)this.this$0.mExpandedHomeLayout);
        }
        this.this$0.mHomeLayout.setVisibility(8);
        if (this.this$0.mTitleLayout != null) {
            this.this$0.mTitleLayout.setVisibility(8);
        }
        if (this.this$0.mTabScrollView != null) {
            this.this$0.mTabScrollView.setVisibility(8);
        }
        if (this.this$0.mSpinner != null) {
            this.this$0.mSpinner.setVisibility(8);
        }
        if (this.this$0.mCustomNavView != null) {
            this.this$0.mCustomNavView.setVisibility(8);
        }
        this.this$0.requestLayout();
        mCurrentExpandedItem.setActionViewExpanded(true);
        if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
            ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
        }
        return true;
    }
    
    @Override
    public boolean flagActionItems() {
        return false;
    }
    
    @Override
    public int getId() {
        return 0;
    }
    
    @Override
    public MenuView getMenuView(final ViewGroup viewGroup) {
        return null;
    }
    
    @Override
    public void initForMenu(final Context context, final MenuBuilder mMenu) {
        if (this.mMenu != null && this.mCurrentExpandedItem != null) {
            this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
        }
        this.mMenu = mMenu;
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    @Override
    public void onRestoreInstanceState(final Parcelable parcelable) {
    }
    
    @Override
    public Parcelable onSaveInstanceState() {
        return null;
    }
    
    @Override
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        return false;
    }
    
    @Override
    public void setCallback(final MenuPresenter$Callback menuPresenter$Callback) {
    }
    
    @Override
    public void updateMenuView(final boolean b) {
        if (this.mCurrentExpandedItem != null) {
            final MenuBuilder mMenu = this.mMenu;
            boolean b2 = false;
            if (mMenu != null) {
                final int size = this.mMenu.size();
                int n = 0;
                while (true) {
                    b2 = false;
                    if (n >= size) {
                        break;
                    }
                    if (this.mMenu.getItem(n) == this.mCurrentExpandedItem) {
                        b2 = true;
                        break;
                    }
                    ++n;
                }
            }
            if (!b2) {
                this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }
}
