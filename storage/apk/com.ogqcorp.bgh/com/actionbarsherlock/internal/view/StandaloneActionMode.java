// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view;

import com.actionbarsherlock.internal.view.menu.MenuPopupHelper;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.internal.view.menu.SubMenuBuilder;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import android.view.View;
import java.lang.ref.WeakReference;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import android.content.Context;
import com.actionbarsherlock.view.ActionMode$Callback;
import com.actionbarsherlock.internal.view.menu.MenuBuilder$Callback;
import com.actionbarsherlock.view.ActionMode;

public class StandaloneActionMode extends ActionMode implements MenuBuilder$Callback
{
    private ActionMode$Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;
    
    public StandaloneActionMode(final Context mContext, final ActionBarContextView mContextView, final ActionMode$Callback mCallback, final boolean mFocusable) {
        this.mContext = mContext;
        this.mContextView = mContextView;
        this.mCallback = mCallback;
        (this.mMenu = new MenuBuilder(mContext).setDefaultShowAsAction(1)).setCallback(this);
        this.mFocusable = mFocusable;
    }
    
    @Override
    public void finish() {
        if (this.mFinished) {
            return;
        }
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
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
        return new MenuInflater(this.mContext);
    }
    
    @Override
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }
    
    @Override
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }
    
    @Override
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }
    
    @Override
    public boolean isUiFocusable() {
        return this.mFocusable;
    }
    
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    public void onCloseSubMenu(final SubMenuBuilder subMenuBuilder) {
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        this.invalidate();
        this.mContextView.showOverflowMenu();
    }
    
    public boolean onSubMenuSelected(final SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.mContext, subMenuBuilder).show();
        return true;
    }
    
    @Override
    public void setCustomView(final View view) {
        this.mContextView.setCustomView(view);
        WeakReference<View> mCustomView;
        if (view != null) {
            mCustomView = new WeakReference<View>(view);
        }
        else {
            mCustomView = null;
        }
        this.mCustomView = mCustomView;
    }
    
    @Override
    public void setSubtitle(final int n) {
        this.setSubtitle(this.mContext.getString(n));
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        this.mContextView.setSubtitle(subtitle);
    }
    
    @Override
    public void setTitle(final int n) {
        this.setTitle(this.mContext.getString(n));
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.mContextView.setTitle(title);
    }
}
