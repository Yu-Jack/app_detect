// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import com.actionbarsherlock.view.ActionMode$Callback;
import android.os.Bundle;
import com.actionbarsherlock.view.MenuItem;
import android.view.Menu;
import android.content.res.Configuration;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock$OnPreparePanelListener;
import com.actionbarsherlock.ActionBarSherlock$OnMenuItemSelectedListener;
import com.actionbarsherlock.ActionBarSherlock$OnCreatePanelMenuListener;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeFinishedListener;
import android.app.ListActivity;

public abstract class SherlockListActivity extends ListActivity implements ActionBarSherlock$OnActionModeFinishedListener, ActionBarSherlock$OnActionModeStartedListener, ActionBarSherlock$OnCreatePanelMenuListener, ActionBarSherlock$OnMenuItemSelectedListener, ActionBarSherlock$OnPreparePanelListener
{
    private ActionBarSherlock mSherlock;
    
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.getSherlock().addContentView(view, viewGroup$LayoutParams);
    }
    
    public void closeOptionsMenu() {
        if (!this.getSherlock().dispatchCloseOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        return this.getSherlock().dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }
    
    public View findViewById(final int n) {
        this.getSherlock().ensureActionBar();
        return super.findViewById(n);
    }
    
    protected final ActionBarSherlock getSherlock() {
        if (this.mSherlock == null) {
            this.mSherlock = ActionBarSherlock.wrap((Activity)this, 1);
        }
        return this.mSherlock;
    }
    
    public ActionBar getSupportActionBar() {
        return this.getSherlock().getActionBar();
    }
    
    public MenuInflater getSupportMenuInflater() {
        return this.getSherlock().getMenuInflater();
    }
    
    public void invalidateOptionsMenu() {
        this.getSherlock().dispatchInvalidateOptionsMenu();
    }
    
    public void onActionModeFinished(final ActionMode actionMode) {
    }
    
    public void onActionModeStarted(final ActionMode actionMode) {
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.getSherlock().dispatchConfigurationChanged(configuration);
    }
    
    public final boolean onCreateOptionsMenu(final Menu menu) {
        return this.getSherlock().dispatchCreateOptionsMenu(menu);
    }
    
    public boolean onCreateOptionsMenu(final com.actionbarsherlock.view.Menu menu) {
        return true;
    }
    
    public boolean onCreatePanelMenu(final int n, final com.actionbarsherlock.view.Menu menu) {
        return n == 0 && this.onCreateOptionsMenu(menu);
    }
    
    protected void onDestroy() {
        this.getSherlock().dispatchDestroy();
        super.onDestroy();
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return n == 0 && this.onOptionsItemSelected(menuItem);
    }
    
    public final boolean onMenuOpened(final int n, final Menu menu) {
        return this.getSherlock().dispatchMenuOpened(n, menu) || super.onMenuOpened(n, menu);
    }
    
    public final boolean onOptionsItemSelected(final android.view.MenuItem menuItem) {
        return this.getSherlock().dispatchOptionsItemSelected(menuItem);
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        this.getSherlock().dispatchPanelClosed(n, menu);
        super.onPanelClosed(n, menu);
    }
    
    protected void onPause() {
        this.getSherlock().dispatchPause();
        super.onPause();
    }
    
    protected void onPostCreate(final Bundle bundle) {
        this.getSherlock().dispatchPostCreate(bundle);
        super.onPostCreate(bundle);
    }
    
    protected void onPostResume() {
        super.onPostResume();
        this.getSherlock().dispatchPostResume();
    }
    
    public final boolean onPrepareOptionsMenu(final Menu menu) {
        return this.getSherlock().dispatchPrepareOptionsMenu(menu);
    }
    
    public boolean onPrepareOptionsMenu(final com.actionbarsherlock.view.Menu menu) {
        return true;
    }
    
    public boolean onPreparePanel(final int n, final View view, final com.actionbarsherlock.view.Menu menu) {
        return n == 0 && this.onPrepareOptionsMenu(menu);
    }
    
    protected void onRestoreInstanceState(final Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.getSherlock().dispatchRestoreInstanceState(bundle);
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.getSherlock().dispatchSaveInstanceState(bundle);
    }
    
    protected void onStop() {
        this.getSherlock().dispatchStop();
        super.onStop();
    }
    
    protected void onTitleChanged(final CharSequence charSequence, final int n) {
        this.getSherlock().dispatchTitleChanged(charSequence, n);
        super.onTitleChanged(charSequence, n);
    }
    
    public void openOptionsMenu() {
        if (!this.getSherlock().dispatchOpenOptionsMenu()) {
            super.openOptionsMenu();
        }
    }
    
    public void requestWindowFeature(final long n) {
        this.getSherlock().requestFeature((int)n);
    }
    
    public void setContentView(final int contentView) {
        this.getSherlock().setContentView(contentView);
    }
    
    public void setContentView(final View contentView) {
        this.getSherlock().setContentView(contentView);
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.getSherlock().setContentView(view, viewGroup$LayoutParams);
    }
    
    public void setSupportProgress(final int progress) {
        this.getSherlock().setProgress(progress);
    }
    
    public void setSupportProgressBarIndeterminate(final boolean progressBarIndeterminate) {
        this.getSherlock().setProgressBarIndeterminate(progressBarIndeterminate);
    }
    
    public void setSupportProgressBarIndeterminateVisibility(final boolean progressBarIndeterminateVisibility) {
        this.getSherlock().setProgressBarIndeterminateVisibility(progressBarIndeterminateVisibility);
    }
    
    public void setSupportProgressBarVisibility(final boolean progressBarVisibility) {
        this.getSherlock().setProgressBarVisibility(progressBarVisibility);
    }
    
    public void setSupportSecondaryProgress(final int secondaryProgress) {
        this.getSherlock().setSecondaryProgress(secondaryProgress);
    }
    
    public ActionMode startActionMode(final ActionMode$Callback actionMode$Callback) {
        return this.getSherlock().startActionMode(actionMode$Callback);
    }
    
    public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }
}
