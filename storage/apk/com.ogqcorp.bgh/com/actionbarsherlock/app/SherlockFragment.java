// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import android.view.MenuItem;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import android.view.MenuInflater;
import android.view.Menu;
import android.app.Activity;
import android.support.v4.app.Watson$OnPrepareOptionsMenuListener;
import android.support.v4.app.Watson$OnOptionsItemSelectedListener;
import android.support.v4.app.Watson$OnCreateOptionsMenuListener;
import android.support.v4.app.Fragment;

public class SherlockFragment extends Fragment implements Watson$OnCreateOptionsMenuListener, Watson$OnOptionsItemSelectedListener, Watson$OnPrepareOptionsMenuListener
{
    private SherlockFragmentActivity mActivity;
    
    public SherlockFragmentActivity getSherlockActivity() {
        return this.mActivity;
    }
    
    @Override
    public void onAttach(final Activity activity) {
        if (!(activity instanceof SherlockFragmentActivity)) {
            throw new IllegalStateException(this.getClass().getSimpleName() + " must be attached to a SherlockFragmentActivity.");
        }
        this.mActivity = (SherlockFragmentActivity)activity;
        super.onAttach(activity);
    }
    
    @Override
    public final void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        this.onCreateOptionsMenu(new MenuWrapper(menu), this.mActivity.getSupportMenuInflater());
    }
    
    @Override
    public void onCreateOptionsMenu(final com.actionbarsherlock.view.Menu menu, final com.actionbarsherlock.view.MenuInflater menuInflater) {
    }
    
    @Override
    public void onDetach() {
        this.mActivity = null;
        super.onDetach();
    }
    
    @Override
    public final boolean onOptionsItemSelected(final MenuItem menuItem) {
        return this.onOptionsItemSelected(new MenuItemWrapper(menuItem));
    }
    
    @Override
    public boolean onOptionsItemSelected(final com.actionbarsherlock.view.MenuItem menuItem) {
        return false;
    }
    
    @Override
    public final void onPrepareOptionsMenu(final Menu menu) {
        this.onPrepareOptionsMenu(new MenuWrapper(menu));
    }
    
    @Override
    public void onPrepareOptionsMenu(final com.actionbarsherlock.view.Menu menu) {
    }
}
