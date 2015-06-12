// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import com.actionbarsherlock.view.ActionMode$Callback;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.content.res.Configuration;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.MenuInflater;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeStartedListener;
import com.actionbarsherlock.ActionBarSherlock$OnActionModeFinishedListener;
import android.support.v4.app.Watson;

public class SherlockFragmentActivity extends Watson implements ActionBarSherlock$OnActionModeFinishedListener, ActionBarSherlock$OnActionModeStartedListener
{
    private static final String TAG = "SherlockFragmentActivity";
    private boolean mIgnoreNativeCreate;
    private boolean mIgnoreNativePrepare;
    private boolean mIgnoreNativeSelected;
    private ActionBarSherlock mSherlock;
    
    public SherlockFragmentActivity() {
        this.mIgnoreNativeCreate = false;
        this.mIgnoreNativePrepare = false;
        this.mIgnoreNativeSelected = false;
    }
    
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
            this.mSherlock = ActionBarSherlock.wrap(this, 1);
        }
        return this.mSherlock;
    }
    
    public ActionBar getSupportActionBar() {
        return this.getSherlock().getActionBar();
    }
    
    @Override
    public MenuInflater getSupportMenuInflater() {
        return this.getSherlock().getMenuInflater();
    }
    
    public void invalidateOptionsMenu() {
        this.getSherlock().dispatchInvalidateOptionsMenu();
    }
    
    @Override
    public void onActionModeFinished(final ActionMode actionMode) {
    }
    
    @Override
    public void onActionModeStarted(final ActionMode actionMode) {
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.getSherlock().dispatchConfigurationChanged(configuration);
    }
    
    public final boolean onCreateOptionsMenu(final Menu menu) {
        return true;
    }
    
    @Override
    public boolean onCreateOptionsMenu(final com.actionbarsherlock.view.Menu menu) {
        return true;
    }
    
    @Override
    public final boolean onCreatePanelMenu(final int n, final Menu menu) {
        if (n == 0 && !this.mIgnoreNativeCreate) {
            this.mIgnoreNativeCreate = true;
            final boolean dispatchCreateOptionsMenu = this.getSherlock().dispatchCreateOptionsMenu(menu);
            this.mIgnoreNativeCreate = false;
            return dispatchCreateOptionsMenu;
        }
        return super.onCreatePanelMenu(n, menu);
    }
    
    @Override
    protected void onDestroy() {
        this.getSherlock().dispatchDestroy();
        super.onDestroy();
    }
    
    @Override
    public final boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (n == 0 && !this.mIgnoreNativeSelected) {
            this.mIgnoreNativeSelected = true;
            final boolean dispatchOptionsItemSelected = this.getSherlock().dispatchOptionsItemSelected(menuItem);
            this.mIgnoreNativeSelected = false;
            return dispatchOptionsItemSelected;
        }
        return super.onMenuItemSelected(n, menuItem);
    }
    
    public final boolean onMenuOpened(final int n, final Menu menu) {
        return this.getSherlock().dispatchMenuOpened(n, menu) || super.onMenuOpened(n, menu);
    }
    
    public final boolean onOptionsItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    @Override
    public boolean onOptionsItemSelected(final com.actionbarsherlock.view.MenuItem menuItem) {
        return false;
    }
    
    @Override
    public void onPanelClosed(final int n, final Menu menu) {
        this.getSherlock().dispatchPanelClosed(n, menu);
        super.onPanelClosed(n, menu);
    }
    
    @Override
    protected void onPause() {
        this.getSherlock().dispatchPause();
        super.onPause();
    }
    
    protected void onPostCreate(final Bundle bundle) {
        this.getSherlock().dispatchPostCreate(bundle);
        super.onPostCreate(bundle);
    }
    
    @Override
    protected void onPostResume() {
        super.onPostResume();
        this.getSherlock().dispatchPostResume();
    }
    
    public final boolean onPrepareOptionsMenu(final Menu menu) {
        return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(final com.actionbarsherlock.view.Menu menu) {
        return true;
    }
    
    @Override
    public final boolean onPreparePanel(final int n, final View view, final Menu menu) {
        if (n == 0 && !this.mIgnoreNativePrepare) {
            this.mIgnoreNativePrepare = true;
            final boolean dispatchPrepareOptionsMenu = this.getSherlock().dispatchPrepareOptionsMenu(menu);
            this.mIgnoreNativePrepare = false;
            return dispatchPrepareOptionsMenu;
        }
        return super.onPreparePanel(n, view, menu);
    }
    
    protected void onRestoreInstanceState(final Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.getSherlock().dispatchRestoreInstanceState(bundle);
    }
    
    @Override
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.getSherlock().dispatchSaveInstanceState(bundle);
    }
    
    @Override
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
    
    @Override
    public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }
}
