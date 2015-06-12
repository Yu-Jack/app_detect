// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.os.Bundle;
import com.actionbarsherlock.view.MenuInflater;
import android.view.Menu;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.annotation.TargetApi;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ogqcorp.bgh.item.Backgrounds;
import android.os.AsyncTask;
import com.ogqcorp.bgh.system.l;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.ogqcorp.bgh.system.g;
import android.view.View;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.m;

@m(a = "FAVORITES")
public final class k extends d
{
    private static ArrayList<Background> a;
    private static Background b;
    
    public k() {
        this.setHasOptionsMenu(true);
    }
    
    private void a(final View view, final boolean b) {
        final View viewById = view.findViewById(2131099814);
        int visibility;
        if (b) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        viewById.setVisibility(visibility);
    }
    
    private void h() {
        if (k.b == null) {
            return;
        }
        g.a().d(k.b);
        k.b = null;
        this.a();
    }
    
    private void i() {
        final DialogInterface$OnClickListener dialogInterface$OnClickListener = (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                k.this.j();
            }
        };
        try {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.getActivity());
            alertDialog$Builder.setTitle(2131427432).setMessage(2131427431);
            alertDialog$Builder.setPositiveButton(17039379, (DialogInterface$OnClickListener)dialogInterface$OnClickListener).setNegativeButton(17039369, (DialogInterface$OnClickListener)null);
            alertDialog$Builder.show();
        }
        catch (Exception ex) {
            l.b(ex);
        }
    }
    
    private void j() {
        ((com.ogqcorp.commons.d<Object, Progress, Result>)new com.ogqcorp.commons.d<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                g.a().c();
                return null;
            }
            
            @Override
            protected void onPostExecute(final Object o) {
                super.onPostExecute(o);
                k.this.a();
            }
        }).a((Context)this.getActivity(), 2131427454, new Object[0]);
    }
    
    @Override
    protected void a() {
        if (this.getActivity() == null) {
            return;
        }
        new AsyncTask<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                try {
                    final Backgrounds backgrounds = new Backgrounds();
                    backgrounds.setBackgroundsList((ArrayList)g.a().b());
                    return backgrounds;
                }
                catch (Exception ex) {
                    return ex;
                }
            }
            
            protected void onPostExecute(final Object o) {
                if (o instanceof Exception) {
                    k.this.a((Exception)o);
                    return;
                }
                k.this.a((Backgrounds)o);
            }
        }.execute(new Object[0]);
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
        this.a(this.getView(), k.a.size() == 0);
    }
    
    @Override
    protected void a(final ArrayList<Background> a) {
        k.a = a;
    }
    
    @Override
    protected ArrayList<Background> b() {
        if (g.a().d()) {
            g.a().a(false);
            k.a = null;
        }
        return k.a;
    }
    
    @Override
    protected int c() {
        return 2130903081;
    }
    
    public boolean onContextItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 2131099861) {
            this.h();
        }
        else if (menuItem.getItemId() == 2131099862) {
            this.i();
        }
        return false;
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        if (contextMenu$ContextMenuInfo instanceof AdapterView$AdapterContextMenuInfo) {
            k.b = k.a.get(((AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo).position);
            contextMenu.setHeaderTitle(2131427488);
            this.getSherlockActivity().getMenuInflater().inflate(2131623939, (Menu)contextMenu);
        }
    }
    
    public void onCreateOptionsMenu(final com.actionbarsherlock.view.Menu menu, final MenuInflater menuInflater) {
        if (k.a != null && k.a.size() != 0) {
            menuInflater.inflate(2131623943, menu);
        }
    }
    
    public boolean onOptionsItemSelected(final com.actionbarsherlock.view.MenuItem menuItem) {
        if (menuItem.getItemId() == 2131099862) {
            this.i();
        }
        return false;
    }
    
    @Override
    public void onResume() {
        if (g.a().d()) {
            g.a().a(false);
            this.a();
        }
        super.onResume();
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.registerForContextMenu((View)this.f());
        if (k.a != null) {
            this.a(view, k.a.size() == 0);
        }
    }
}
