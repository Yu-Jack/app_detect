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
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.Locale;
import android.annotation.TargetApi;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ogqcorp.bgh.item.Backgrounds;
import android.os.AsyncTask;
import com.ogqcorp.bgh.system.l;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.ogqcorp.bgh.system.i;
import android.view.View;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.m;

@m(a = "HISTORY")
public final class l extends d
{
    private static ArrayList<Background> a;
    private static Background b;
    
    public l() {
        this.setHasOptionsMenu(true);
    }
    
    private void a(final View view, final boolean b) {
        final View viewById = view.findViewById(2131099815);
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
        if (l.b == null) {
            return;
        }
        i.a().c(l.b);
        l.b = null;
        this.a();
    }
    
    private void i() {
        final DialogInterface$OnClickListener dialogInterface$OnClickListener = (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                l.this.j();
            }
        };
        try {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.getActivity());
            alertDialog$Builder.setTitle(2131427434).setMessage(2131427433);
            alertDialog$Builder.setPositiveButton(17039379, (DialogInterface$OnClickListener)dialogInterface$OnClickListener).setNegativeButton(17039369, (DialogInterface$OnClickListener)null);
            alertDialog$Builder.show();
        }
        catch (Exception ex) {
            com.ogqcorp.bgh.system.l.b(ex);
        }
    }
    
    private void j() {
        ((com.ogqcorp.commons.d<Object, Progress, Result>)new com.ogqcorp.commons.d<Object, Object, Object>() {
            protected Object doInBackground(final Object... array) {
                i.a().c();
                return null;
            }
            
            @Override
            protected void onPostExecute(final Object o) {
                super.onPostExecute(o);
                l.this.a();
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
                    backgrounds.setBackgroundsList((ArrayList)i.a().b());
                    return backgrounds;
                }
                catch (Exception ex) {
                    return ex;
                }
            }
            
            protected void onPostExecute(final Object o) {
                if (o instanceof Exception) {
                    l.this.a((Exception)o);
                    return;
                }
                l.this.a((Backgrounds)o);
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
        this.a(this.getView(), l.a.size() == 0);
    }
    
    @Override
    protected void a(final ArrayList<Background> a) {
        l.a = a;
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        for (final Background background : l.a) {
            background.setExtra(simpleDateFormat.format(background.getHistoryDate()));
        }
    }
    
    @Override
    protected ArrayList<Background> b() {
        if (i.a().d()) {
            i.a().a(false);
            l.a = null;
        }
        return l.a;
    }
    
    @Override
    protected int c() {
        return 2130903082;
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
            l.b = l.a.get(((AdapterView$AdapterContextMenuInfo)contextMenu$ContextMenuInfo).position);
            contextMenu.setHeaderTitle(2131427489);
            this.getSherlockActivity().getMenuInflater().inflate(2131623940, (Menu)contextMenu);
        }
    }
    
    public void onCreateOptionsMenu(final com.actionbarsherlock.view.Menu menu, final MenuInflater menuInflater) {
        if (l.a != null && l.a.size() != 0) {
            menuInflater.inflate(2131623944, menu);
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
        if (i.a().d()) {
            i.a().a(false);
            this.a();
        }
        super.onResume();
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.registerForContextMenu((View)this.f());
        if (l.a != null) {
            this.a(view, l.a.size() == 0);
        }
    }
}
