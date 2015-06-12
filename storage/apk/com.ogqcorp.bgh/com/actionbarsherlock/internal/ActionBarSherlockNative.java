// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode$Callback;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.content.Context;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import android.view.MenuItem;
import android.view.Menu;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.app.Activity;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.ActionBarSherlock$Implementation;
import com.actionbarsherlock.ActionBarSherlock;

@ActionBarSherlock$Implementation(api = 14)
public class ActionBarSherlockNative extends ActionBarSherlock
{
    private ActionBarWrapper mActionBar;
    private ActionBarSherlockNative$ActionModeWrapper mActionMode;
    private MenuWrapper mMenu;
    
    public ActionBarSherlockNative(final Activity activity, final int n) {
        super(activity, n);
    }
    
    private void initActionBar() {
        if (this.mActionBar != null || this.mActivity.getActionBar() == null) {
            return;
        }
        this.mActionBar = new ActionBarWrapper(this.mActivity);
    }
    
    @Override
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.mActivity.getWindow().addContentView(view, viewGroup$LayoutParams);
        this.initActionBar();
    }
    
    @Override
    public boolean dispatchCreateOptionsMenu(final Menu menu) {
        if (this.mMenu == null || menu != this.mMenu.unwrap()) {
            this.mMenu = new MenuWrapper(menu);
        }
        return this.callbackCreateOptionsMenu(this.mMenu);
    }
    
    @Override
    public void dispatchInvalidateOptionsMenu() {
        this.mActivity.getWindow().invalidatePanelMenu(0);
        if (this.mMenu != null) {
            this.mMenu.invalidate();
        }
    }
    
    @Override
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        com.actionbarsherlock.view.MenuItem item;
        if (this.mMenu == null) {
            if (menuItem.getItemId() != 16908332) {
                throw new IllegalStateException("Non-home action item clicked before onCreateOptionsMenu with ID " + menuItem.getItemId());
            }
            item = new MenuItemWrapper(menuItem);
        }
        else {
            item = this.mMenu.findItem(menuItem);
        }
        return this.callbackOptionsItemSelected(item);
    }
    
    @Override
    public boolean dispatchPrepareOptionsMenu(final Menu menu) {
        return this.callbackPrepareOptionsMenu(this.mMenu);
    }
    
    @Override
    public ActionBar getActionBar() {
        this.initActionBar();
        return this.mActionBar;
    }
    
    @Override
    protected Context getThemedContext() {
        final Activity mActivity = this.mActivity;
        final TypedValue typedValue = new TypedValue();
        this.mActivity.getTheme().resolveAttribute(16843671, typedValue, true);
        if (typedValue.resourceId != 0) {
            return (Context)new ContextThemeWrapper((Context)mActivity, typedValue.resourceId);
        }
        return (Context)mActivity;
    }
    
    @Override
    public boolean hasFeature(final int n) {
        return this.mActivity.getWindow().hasFeature(n);
    }
    
    @Override
    public boolean requestFeature(final int n) {
        return this.mActivity.getWindow().requestFeature(n);
    }
    
    @Override
    public void setContentView(final int contentView) {
        this.mActivity.getWindow().setContentView(contentView);
        this.initActionBar();
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.mActivity.getWindow().setContentView(view, viewGroup$LayoutParams);
        this.initActionBar();
    }
    
    @Override
    public void setProgress(final int progress) {
        this.mActivity.setProgress(progress);
    }
    
    @Override
    public void setProgressBarIndeterminate(final boolean progressBarIndeterminate) {
        this.mActivity.setProgressBarIndeterminate(progressBarIndeterminate);
    }
    
    @Override
    public void setProgressBarIndeterminateVisibility(final boolean progressBarIndeterminateVisibility) {
        this.mActivity.setProgressBarIndeterminateVisibility(progressBarIndeterminateVisibility);
    }
    
    @Override
    public void setProgressBarVisibility(final boolean progressBarVisibility) {
        this.mActivity.setProgressBarVisibility(progressBarVisibility);
    }
    
    @Override
    public void setSecondaryProgress(final int secondaryProgress) {
        this.mActivity.setSecondaryProgress(secondaryProgress);
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.mActivity.getWindow().setTitle(title);
    }
    
    @Override
    public void setUiOptions(final int uiOptions) {
        this.mActivity.getWindow().setUiOptions(uiOptions);
    }
    
    @Override
    public void setUiOptions(final int n, final int n2) {
        this.mActivity.getWindow().setUiOptions(n, n2);
    }
    
    @Override
    public ActionMode startActionMode(final ActionMode$Callback actionMode$Callback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        Object o;
        if (actionMode$Callback != null) {
            o = new ActionBarSherlockNative$ActionModeCallbackWrapper(this, actionMode$Callback);
        }
        else {
            o = null;
        }
        if (this.mActivity.startActionMode((android.view.ActionMode$Callback)o) == null) {
            this.mActionMode = null;
        }
        if (this.mActivity instanceof ActionBarSherlock$OnActionModeStartedListener && this.mActionMode != null) {
            ((ActionBarSherlock$OnActionModeStartedListener)this.mActivity).onActionModeStarted(this.mActionMode);
        }
        return this.mActionMode;
    }
}
