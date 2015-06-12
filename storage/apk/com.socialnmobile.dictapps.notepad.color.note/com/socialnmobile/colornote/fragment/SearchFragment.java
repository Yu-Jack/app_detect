// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.widget.ListAdapter;
import android.database.Cursor;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.widget.ListView;

public class SearchFragment extends ScreenFragment implements w
{
    String a;
    private ListView b;
    private abh c;
    
    public SearchFragment() {
        this.c = new abh();
    }
    
    private void O() {
        final yc a = gr.a((Context)super.C);
        this.b.setBackgroundColor(a.n(3));
        final TextView textView = (TextView)super.R.findViewById(2131624052);
        textView.setBackgroundColor(a.n(3));
        textView.setTextColor(a.n(8));
        this.c.b();
    }
    
    public static final SearchFragment a(final String s) {
        final SearchFragment searchFragment = new SearchFragment();
        final Bundle bundle = new Bundle();
        bundle.putString("QUERY", s);
        searchFragment.e(bundle);
        return searchFragment;
    }
    
    private void b() {
        this.aq.a(super.ap);
    }
    
    @Override
    public final int I() {
        return 5;
    }
    
    @Override
    public final void J() {
        this.O();
    }
    
    @Override
    public final void K() {
    }
    
    @Override
    public final void L() {
        if (this.l()) {
            super.a((Context)super.C);
            this.b();
        }
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903065, (ViewGroup)null);
        (this.b = (ListView)inflate.findViewById(2131623939)).setEmptyView(inflate.findViewById(2131624052));
        this.c.a(inflate, this);
        this.c.a(1);
        this.c.a((View$OnClickListener)null);
        this.c.a("\"" + this.a + "\"");
        this.b.setOnItemClickListener((AdapterView$OnItemClickListener)new ps(this));
        if (this.a == null || "".equals(this.a)) {
            super.C.onSearchRequested();
            return inflate;
        }
        final String a = this.a;
        final Bundle bundle2 = new Bundle();
        bundle2.putString("QUERY", a);
        this.q().a(0, bundle2, this);
        return inflate;
    }
    
    @Override
    public final void a(final ae ae) {
    }
    
    @Override
    public final void a(final Activity activity) {
        super.a(activity);
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        if (super.q != null) {
            this.a = super.q.getString("QUERY");
        }
    }
    
    @Override
    public final void a(final rc rc) {
        rc.f = this.a(2131230781);
        rc.b(2131624155, 2130837613, 2131230781);
    }
    
    public final boolean a(final int n, final String s) {
        switch (n) {
            default: {
                return false;
            }
            case 2131624155: {
                super.C.onSearchRequested();
                return true;
            }
        }
    }
    
    @Override
    public final ae a_(final Bundle bundle) {
        return new pt((Context)super.C, bundle.getString("QUERY"));
    }
    
    @Override
    public final void b(final rc rc) {
    }
    
    @Override
    public final void v() {
        super.v();
        this.O();
        if (this.aq.a(this)) {
            this.b();
        }
    }
}
