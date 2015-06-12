// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import android.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.content.Context;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.app.Activity;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.ActionBarSherlock$Implementation;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeFinishedListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ActionMode;
import android.view.ActionMode$Callback;

class ActionBarSherlockNative$ActionModeCallbackWrapper implements ActionMode$Callback
{
    private final com.actionbarsherlock.view.ActionMode$Callback mCallback;
    final /* synthetic */ ActionBarSherlockNative this$0;
    
    public ActionBarSherlockNative$ActionModeCallbackWrapper(final ActionBarSherlockNative this$0, final com.actionbarsherlock.view.ActionMode$Callback mCallback) {
        this.this$0 = this$0;
        this.mCallback = mCallback;
    }
    
    public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this.this$0.mActionMode, this.this$0.mActionMode.getMenu().findItem(menuItem));
    }
    
    public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        this.this$0.mActionMode = new ActionBarSherlockNative$ActionModeWrapper(this.this$0, actionMode);
        return this.mCallback.onCreateActionMode(this.this$0.mActionMode, this.this$0.mActionMode.getMenu());
    }
    
    public void onDestroyActionMode(final ActionMode actionMode) {
        this.mCallback.onDestroyActionMode(this.this$0.mActionMode);
        if (this.this$0.mActivity instanceof ActionBarSherlock$OnActionModeFinishedListener) {
            ((ActionBarSherlock$OnActionModeFinishedListener)this.this$0.mActivity).onActionModeFinished(this.this$0.mActionMode);
        }
    }
    
    public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mCallback.onPrepareActionMode(this.this$0.mActionMode, this.this$0.mActionMode.getMenu());
    }
}
