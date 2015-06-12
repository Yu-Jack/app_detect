// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import com.actionbarsherlock.internal.view.StandaloneActionMode;
import android.view.ViewStub;
import android.util.AndroidRuntimeException;
import com.actionbarsherlock.app.ActionBar;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import com.actionbarsherlock.internal.view.menu.ActionMenuPresenter;
import java.util.Iterator;
import java.util.List;
import android.util.Log;
import com.actionbarsherlock.internal.widget.ActionBarContainer;
import com.actionbarsherlock.R$bool;
import android.view.View;
import java.util.ArrayList;
import android.view.ContextThemeWrapper;
import com.actionbarsherlock.R$attr;
import android.util.TypedValue;
import android.view.animation.Animation;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.content.res.TypedArray;
import com.actionbarsherlock.R$id;
import android.view.ViewGroup$LayoutParams;
import com.actionbarsherlock.R$layout;
import com.actionbarsherlock.R$styleable;
import android.app.Activity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import java.util.HashMap;
import android.os.Bundle;
import com.actionbarsherlock.internal.view.menu.MenuBuilder;
import android.view.ViewGroup;
import com.actionbarsherlock.internal.widget.IcsProgressBar;
import com.actionbarsherlock.internal.widget.ActionBarContextView;
import com.actionbarsherlock.internal.app.ActionBarImpl;
import com.actionbarsherlock.ActionBarSherlock$Implementation;
import com.actionbarsherlock.view.Window$Callback;
import com.actionbarsherlock.internal.view.menu.MenuPresenter$Callback;
import com.actionbarsherlock.internal.view.menu.MenuBuilder$Callback;
import android.view.MenuItem$OnMenuItemClickListener;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeFinishedListener;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode$Callback;

class ActionBarSherlockCompat$ActionModeCallbackWrapper implements ActionMode$Callback
{
    private final ActionMode$Callback mWrapped;
    final /* synthetic */ ActionBarSherlockCompat this$0;
    
    public ActionBarSherlockCompat$ActionModeCallbackWrapper(final ActionBarSherlockCompat this$0, final ActionMode$Callback mWrapped) {
        this.this$0 = this$0;
        this.mWrapped = mWrapped;
    }
    
    @Override
    public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }
    
    @Override
    public boolean onCreateActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrapped.onCreateActionMode(actionMode, menu);
    }
    
    @Override
    public void onDestroyActionMode(final ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        if (this.this$0.mActionModeView != null) {
            this.this$0.mActionModeView.setVisibility(8);
            this.this$0.mActionModeView.removeAllViews();
        }
        if (this.this$0.mActivity instanceof ActionBarSherlock$OnActionModeFinishedListener) {
            ((ActionBarSherlock$OnActionModeFinishedListener)this.this$0.mActivity).onActionModeFinished(this.this$0.mActionMode);
        }
        this.this$0.mActionMode = null;
    }
    
    @Override
    public boolean onPrepareActionMode(final ActionMode actionMode, final Menu menu) {
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }
}
