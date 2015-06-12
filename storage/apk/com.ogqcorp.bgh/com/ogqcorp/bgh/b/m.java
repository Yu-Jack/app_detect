// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import com.ogqcorp.bgh.system.l;
import com.actionbarsherlock.internal.widget.IcsSpinner;
import com.ogqcorp.commons.f;
import com.ogqcorp.bgh.system.a;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import java.util.Iterator;
import com.ogqcorp.bgh.system.ac;
import android.annotation.TargetApi;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ogqcorp.bgh.item.Backgrounds;
import com.ogqcorp.commons.c;
import com.ogqcorp.bgh.system.r;
import android.support.v4.app.FragmentActivity;
import com.ogqcorp.bgh.system.o;
import android.content.Context;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.m;
import com.actionbarsherlock.app.ActionBar$OnNavigationListener;

@com.ogqcorp.bgh.system.m(a = "POPULAR")
public final class m extends d implements ActionBar$OnNavigationListener
{
    private static ArrayList<Background> a;
    
    public m() {
        this.setHasOptionsMenu(true);
    }
    
    private String h() {
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return "";
        }
        switch (v.a().c((Context)activity)) {
            default: {
                return o.b().b((Context)activity);
            }
            case 1: {
                return o.b().c((Context)activity);
            }
            case 2: {
                return o.b().d((Context)activity);
            }
            case 3: {
                return o.b().e((Context)activity);
            }
        }
    }
    
    @Override
    protected void a() {
        super.a();
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        com.ogqcorp.commons.c.a(activity, 0, "POPULAR", 3600000L, this.h(), this.e(), r.d, this);
    }
    
    @TargetApi(11)
    @Override
    public void a(final Backgrounds backgrounds) {
        super.a(backgrounds);
        final SherlockFragmentActivity sherlockActivity = this.getSherlockActivity();
        if (sherlockActivity == null) {
            return;
        }
        sherlockActivity.invalidateOptionsMenu();
    }
    
    @Override
    protected void a(final ArrayList<Background> a) {
        m.a = a;
        for (final Background background : m.a) {
            background.setExtra(ac.a((Object)background.getScore()));
        }
    }
    
    @Override
    protected ArrayList<Background> b() {
        return m.a;
    }
    
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        if (m.a != null) {
            menuInflater.inflate(2131623945, menu);
            com.ogqcorp.bgh.system.a.a(menu, 2131099866, (Context)this.getActivity(), 2131558400, (ActionBar$OnNavigationListener)this);
        }
    }
    
    @Override
    public boolean onNavigationItemSelected(final int n, final long n2) {
        final FragmentActivity activity = this.getActivity();
        if (v.a().c((Context)activity) == n) {
            return true;
        }
        v.a().b((Context)activity, n);
        new f().a((Context)activity, "POPULAR");
        this.a();
        return true;
    }
    
    public void onPrepareOptionsMenu(final Menu menu) {
        if (m.a == null) {
            return;
        }
        try {
            final int c = v.a().c((Context)this.getActivity());
            if (c >= 0 && c <= 3) {
                ((IcsSpinner)menu.findItem(2131099866).getActionView()).setSelection(c);
            }
        }
        catch (Exception ex) {
            l.b(ex);
        }
    }
}
