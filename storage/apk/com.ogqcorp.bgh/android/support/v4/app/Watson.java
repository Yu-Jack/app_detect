// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.view.View;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import java.util.ArrayList;
import com.actionbarsherlock.ActionBarSherlock$OnPreparePanelListener;
import com.actionbarsherlock.ActionBarSherlock$OnMenuItemSelectedListener;
import com.actionbarsherlock.ActionBarSherlock$OnCreatePanelMenuListener;

public abstract class Watson extends FragmentActivity implements ActionBarSherlock$OnCreatePanelMenuListener, ActionBarSherlock$OnMenuItemSelectedListener, ActionBarSherlock$OnPreparePanelListener
{
    private static final String TAG = "Watson";
    private ArrayList<Fragment> mCreatedMenus;
    
    public abstract MenuInflater getSupportMenuInflater();
    
    public abstract boolean onCreateOptionsMenu(final Menu p0);
    
    @Override
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        boolean b = false;
        if (n == 0) {
            final boolean onCreateOptionsMenu = this.onCreateOptionsMenu(menu);
            final MenuInflater supportMenuInflater = this.getSupportMenuInflater();
            ArrayList<Fragment> mCreatedMenus = null;
            boolean b2;
            if (this.mFragments.mAdded != null) {
                int i = 0;
                b2 = false;
                while (i < this.mFragments.mAdded.size()) {
                    final Fragment e = this.mFragments.mAdded.get(i);
                    boolean b3;
                    if (e != null && !e.mHidden && e.mHasMenu && e.mMenuVisible && e instanceof Watson$OnCreateOptionsMenuListener) {
                        ((Watson$OnCreateOptionsMenuListener)e).onCreateOptionsMenu(menu, supportMenuInflater);
                        ArrayList<Fragment> list;
                        if (mCreatedMenus == null) {
                            list = new ArrayList<Fragment>();
                        }
                        else {
                            list = mCreatedMenus;
                        }
                        list.add(e);
                        mCreatedMenus = list;
                        b3 = true;
                    }
                    else {
                        b3 = b2;
                    }
                    ++i;
                    b2 = b3;
                }
            }
            else {
                b2 = false;
            }
            final ArrayList<Fragment> mCreatedMenus2 = this.mCreatedMenus;
            int j = 0;
            if (mCreatedMenus2 != null) {
                while (j < this.mCreatedMenus.size()) {
                    final Fragment o = this.mCreatedMenus.get(j);
                    if (mCreatedMenus == null || !mCreatedMenus.contains(o)) {
                        o.onDestroyOptionsMenu();
                    }
                    ++j;
                }
            }
            this.mCreatedMenus = mCreatedMenus;
            b = (onCreateOptionsMenu | b2);
        }
        return b;
    }
    
    @Override
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        boolean b = false;
        if (n == 0) {
            if (this.onOptionsItemSelected(menuItem)) {
                b = true;
            }
            else {
                final ArrayList<Fragment> mAdded = this.mFragments.mAdded;
                b = false;
                if (mAdded != null) {
                    int index = 0;
                    while (true) {
                        final int size = this.mFragments.mAdded.size();
                        b = false;
                        if (index >= size) {
                            return b;
                        }
                        final Fragment fragment = this.mFragments.mAdded.get(index);
                        if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && fragment instanceof Watson$OnOptionsItemSelectedListener && ((Watson$OnOptionsItemSelectedListener)fragment).onOptionsItemSelected(menuItem)) {
                            break;
                        }
                        ++index;
                    }
                    return true;
                }
            }
        }
        return b;
    }
    
    public abstract boolean onOptionsItemSelected(final MenuItem p0);
    
    public abstract boolean onPrepareOptionsMenu(final Menu p0);
    
    @Override
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        boolean b = false;
        if (n == 0) {
            final boolean onPrepareOptionsMenu = this.onPrepareOptionsMenu(menu);
            boolean b2;
            if (this.mFragments.mAdded != null) {
                int i = 0;
                b2 = false;
                while (i < this.mFragments.mAdded.size()) {
                    final Fragment fragment = this.mFragments.mAdded.get(i);
                    if (fragment != null && !fragment.mHidden && fragment.mHasMenu && fragment.mMenuVisible && fragment instanceof Watson$OnPrepareOptionsMenuListener) {
                        b2 = true;
                        ((Watson$OnPrepareOptionsMenuListener)fragment).onPrepareOptionsMenu(menu);
                    }
                    ++i;
                }
            }
            else {
                b2 = false;
            }
            b = ((onPrepareOptionsMenu | b2) & menu.hasVisibleItems());
        }
        return b;
    }
}
