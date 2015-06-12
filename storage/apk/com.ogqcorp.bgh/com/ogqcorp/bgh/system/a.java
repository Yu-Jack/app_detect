// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import com.actionbarsherlock.view.MenuItem$OnActionExpandListener;
import com.actionbarsherlock.widget.SearchView;
import com.actionbarsherlock.widget.SearchView$OnQueryTextListener;
import android.view.View;
import com.actionbarsherlock.internal.widget.IcsAdapterView;
import com.actionbarsherlock.internal.widget.IcsAdapterView$OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;
import com.actionbarsherlock.internal.widget.IcsSpinner;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.app.ActionBar$OnNavigationListener;
import android.content.Context;
import com.actionbarsherlock.view.Menu;

public final class a
{
    public static final MenuItem a(final Menu menu, final int n, final Context context, final int n2, final ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        final MenuItem item = menu.findItem(n);
        final View actionView = item.getActionView();
        if (!(actionView instanceof IcsSpinner)) {
            return item;
        }
        final IcsSpinner icsSpinner = (IcsSpinner)actionView;
        icsSpinner.setBackgroundResource(2130837598);
        final ArrayAdapter fromResource = ArrayAdapter.createFromResource(context, n2, 2130903095);
        fromResource.setDropDownViewResource(2130903095);
        icsSpinner.setAdapter((SpinnerAdapter)fromResource);
        icsSpinner.setOnItemSelectedListener(new IcsAdapterView$OnItemSelectedListener() {
            @Override
            public void onItemSelected(final IcsAdapterView<?> icsAdapterView, final View view, final int n, final long n2) {
                actionBar$OnNavigationListener.onNavigationItemSelected(n, n2);
            }
            
            @Override
            public void onNothingSelected(final IcsAdapterView<?> icsAdapterView) {
            }
        });
        return item;
    }
    
    public static final MenuItem a(final Menu menu, final int n, final Context context, final int n2, final SearchView$OnQueryTextListener onQueryTextListener) {
        final MenuItem item = menu.findItem(n);
        final View actionView = item.getActionView();
        if (!(actionView instanceof SearchView)) {
            return item;
        }
        item.setOnActionExpandListener(new MenuItem$OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
                ((SearchView)menuItem.getActionView()).setQuery("", true);
                return true;
            }
            
            @Override
            public boolean onMenuItemActionExpand(final MenuItem menuItem) {
                return true;
            }
        });
        final SearchView searchView = (SearchView)actionView;
        searchView.setQueryHint(context.getString(n2));
        searchView.setOnQueryTextListener(onQueryTextListener);
        return item;
    }
}
