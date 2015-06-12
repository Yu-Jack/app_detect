// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import com.ogqcorp.bgh.system.g;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.ViewGroup;
import com.ogqcorp.bgh.c.a;
import com.ogqcorp.bgh.system.l;
import android.view.View;
import android.view.animation.Animation;
import android.content.Context;
import android.view.animation.AnimationUtils;
import com.ogqcorp.bgh.system.q;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.item.Backgrounds;
import com.actionbarsherlock.widget.SearchView$OnQueryTextListener;
import android.widget.AdapterView$OnItemClickListener;
import com.ogqcorp.bgh.b.a.b;

public abstract class d extends b implements AdapterView$OnItemClickListener, SearchView$OnQueryTextListener, com.ogqcorp.commons.b<Object, Backgrounds>
{
    private ArrayList<Background> a;
    private com.ogqcorp.bgh.c.b<Background> b;
    private q c;
    
    public d() {
        this.b = new com.ogqcorp.bgh.c.b<Background>();
    }
    
    private void a(final boolean b) {
        if (this.getView() == null) {
            return;
        }
        final View viewById = this.getView().findViewById(2131099763);
        if (b) {
            viewById.startAnimation(AnimationUtils.loadAnimation((Context)this.getActivity(), 2130968576));
            viewById.setVisibility(0);
            return;
        }
        viewById.setAnimation((Animation)null);
        viewById.setVisibility(8);
    }
    
    protected void a() {
        this.a(true);
    }
    
    public void a(final Backgrounds backgrounds) {
        if (this.getActivity() == null) {
            return;
        }
        this.a(false);
        this.a(this.a = backgrounds.getBackgroundsList());
        try {
            this.g().notifyDataSetChanged();
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    public void a(final Exception ex) {
        if (this.getActivity() == null) {
            return;
        }
        this.a(false);
    }
    
    protected abstract void a(final ArrayList<Background> p0);
    
    protected abstract ArrayList<Background> b();
    
    @Override
    protected int c() {
        return 2130903078;
    }
    
    @Override
    protected a d() {
        return new a() {
            final /* synthetic */ Context a = this.getActivity();
            
            @Override
            public View a(final int index, final View view, final ViewGroup viewGroup, final boolean b) {
                return d.this.a.get(index).a(this.a, view, viewGroup, b);
            }
            
            public int getCount() {
                if (d.this.a == null) {
                    return 0;
                }
                return d.this.a.size();
            }
            
            public Object getItem(final int index) {
                if (d.this.a == null) {
                    return null;
                }
                return d.this.a.get(index);
            }
            
            public long getItemId(final int n) {
                return n;
            }
        };
    }
    
    protected q e() {
        if (this.c == null) {
            this.c = new q();
        }
        return this.c;
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.a == null) {
            this.a();
        }
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = this.b();
    }
    
    @Override
    public void onDestroy() {
        if (this.c != null) {
            this.c.a(true);
            this.c = null;
        }
        super.onDestroy();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        try {
            ((e)this.getActivity()).a(this.a, n);
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    public boolean onQueryTextChange(final String s) {
        final ArrayList<Background> a = this.b.a(s, this.a);
        if (a != null) {
            this.a = a;
            this.g().notifyDataSetChanged();
        }
        return true;
    }
    
    public boolean onQueryTextSubmit(final String s) {
        return false;
    }
    
    public void onResume() {
        if (g.a().d()) {
            g.a().a(false);
            this.f().a();
        }
        super.onResume();
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f().setOnItemClickListener((AdapterView$OnItemClickListener)this);
    }
}
