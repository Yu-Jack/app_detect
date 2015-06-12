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
import com.actionbarsherlock.internal.nineoldandroids.animation.AnimatorListenerAdapter;
import com.actionbarsherlock.internal.widget.ScrollingTabContainerView;
import com.actionbarsherlock.app.ActionBar$OnMenuVisibilityListener;
import java.util.ArrayList;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator$AnimatorListener;
import android.os.Handler;
import com.actionbarsherlock.internal.nineoldandroids.animation.Animator;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import android.content.Context;
import com.actionbarsherlock.internal.nineoldandroids.widget.NineFrameLayout;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import android.app.Activity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import android.view.View;
import java.lang.ref.WeakReference;
import com.actionbarsherlock.view.ActionMode$Callback;
import com.actionbarsherlock.internal.view.menu.MenuBuilder$Callback;
import com.actionbarsherlock.view.ActionMode;

public class ActionBarImpl$ActionModeImpl extends ActionMode implements MenuBuilder$Callback
{
    private ActionMode$Callback mCallback;
    private WeakReference<View> mCustomView;
    private MenuBuilder mMenu;
    final /* synthetic */ ActionBarImpl this$0;
    
    public ActionBarImpl$ActionModeImpl(final ActionBarImpl this$0, final ActionMode$Callback mCallback) {
        this.this$0 = this$0;
        this.mCallback = mCallback;
        (this.mMenu = new MenuBuilder(this$0.getThemedContext()).setDefaultShowAsAction(1)).setCallback(this);
    }
    
    public boolean dispatchOnCreate() {
        this.mMenu.stopDispatchingItemsChanged();
        try {
            return this.mCallback.onCreateActionMode(this, this.mMenu);
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }
    
    @Override
    public void finish() {
        if (this.this$0.mActionMode == this) {
            if (this.this$0.mWasHiddenBeforeMode) {
                this.this$0.mDeferredDestroyActionMode = this;
                this.this$0.mDeferredModeDestroyCallback = this.mCallback;
            }
            else {
                this.mCallback.onDestroyActionMode(this);
            }
            this.mCallback = null;
            this.this$0.animateToMode(false);
            this.this$0.mContextView.closeMode();
            this.this$0.mActionView.sendAccessibilityEvent(32);
            this.this$0.mActionMode = null;
            if (this.this$0.mWasHiddenBeforeMode) {
                this.this$0.hide();
            }
        }
    }
    
    @Override
    public View getCustomView() {
        if (this.mCustomView != null) {
            return this.mCustomView.get();
        }
        return null;
    }
    
    @Override
    public Menu getMenu() {
        return this.mMenu;
    }
    
    @Override
    public MenuInflater getMenuInflater() {
        return new MenuInflater(this.this$0.getThemedContext());
    }
    
    @Override
    public CharSequence getSubtitle() {
        return this.this$0.mContextView.getSubtitle();
    }
    
    @Override
    public CharSequence getTitle() {
        return this.this$0.mContextView.getTitle();
    }
    
    @Override
    public void invalidate() {
        this.mMenu.stopDispatchingItemsChanged();
        try {
            this.mCallback.onPrepareActionMode(this, this.mMenu);
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return this.mCallback != null && this.mCallback.onActionItemClicked(this, menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (this.mCallback == null) {
            return;
        }
        this.invalidate();
        this.this$0.mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        boolean b = true;
        if (this.mCallback == null) {
            b = false;
        }
        else if (subMenuBuilder.hasVisibleItems()) {
            new MenuPopupHelper(this.this$0.getThemedContext(), subMenuBuilder).show();
            return b;
        }
        return b;
    }
    
    @Override
    public void setCustomView(final View view) {
        this.this$0.mContextView.setCustomView(view);
        this.mCustomView = new WeakReference<View>(view);
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(this.this$0.mContext.getResources().getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        this.this$0.mContextView.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(this.this$0.mContext.getResources().getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.this$0.mContextView.setTitle(title);
    }
}
