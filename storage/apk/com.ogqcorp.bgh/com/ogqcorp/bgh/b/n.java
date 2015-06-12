// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.view.View$OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import com.ogqcorp.bgh.activity.MyCuratorFlickrCoverActivity;
import java.util.List;
import java.util.Collections;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView$OnQueryTextListener;
import com.ogqcorp.bgh.system.a;
import com.ogqcorp.bgh.system.ac;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import android.annotation.TargetApi;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.item.Backgrounds;
import android.support.v4.app.FragmentActivity;
import com.ogqcorp.commons.c;
import com.ogqcorp.bgh.system.r;
import com.ogqcorp.bgh.system.o;
import com.ogqcorp.commons.f;
import android.content.Context;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.m;

@m(a = "RECENT")
public final class n extends d
{
    private static ArrayList<Background> a;
    
    public n() {
        this.setHasOptionsMenu(true);
    }
    
    public static void a(final Context context) {
        new f().a(context, "RECENT");
    }
    
    @Override
    protected void a() {
        super.a();
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        com.ogqcorp.commons.c.a(activity, 0, "RECENT", 3600000L, o.b().a((Context)activity), this.e(), r.d, this);
    }
    
    @TargetApi(11)
    @Override
    public void a(final Backgrounds backgrounds) {
        super.a(backgrounds);
        final SherlockFragmentActivity sherlockActivity = this.getSherlockActivity();
        if (sherlockActivity != null) {
            sherlockActivity.invalidateOptionsMenu();
            if (n.a != null && n.a.size() > 0) {
                v.a().a((Context)this.getActivity(), n.a.get(0).getId());
            }
        }
    }
    
    @Override
    protected void a(final ArrayList<Background> a) {
        n.a = a;
    }
    
    @Override
    protected ArrayList<Background> b() {
        return n.a;
    }
    
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        if (n.a != null) {
            if (ac.f((Context)this.getActivity())) {
                menuInflater.inflate(2131623947, menu);
            }
            else {
                menuInflater.inflate(2131623946, menu);
            }
            com.ogqcorp.bgh.system.a.a(menu, 2131099867, (Context)this.getActivity(), 2131427473, this);
        }
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 2131099868) {
            this.a();
        }
        else if (menuItem.getItemId() == 2131099869) {
            Collections.shuffle(n.a);
            this.g().notifyDataSetChanged();
        }
        else if (menuItem.getItemId() == 2131099870) {
            this.startActivity(new Intent((Context)this.getActivity(), (Class)MyCuratorFlickrCoverActivity.class));
        }
        return false;
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        final View viewById = view.findViewById(2131099794);
        viewById.setVisibility(0);
        viewById.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            public void onClick(final View view) {
                n.this.startActivity(new Intent((Context)n.this.getActivity(), (Class)MyCuratorFlickrCoverActivity.class));
            }
        });
    }
}
