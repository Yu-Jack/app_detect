// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.activity.SyncStatus;
import android.app.Activity;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.util.HashMap;
import android.content.Context;
import android.widget.ListAdapter;
import java.util.ArrayList;
import com.socialnmobile.colornote.activity.Main;
import android.widget.TextView;
import android.view.View;
import android.widget.ListView;
import android.support.v4.app.Fragment;

public class SideMenuFragment extends Fragment
{
    private static int i;
    ListView a;
    View b;
    View c;
    View d;
    TextView e;
    public Main f;
    public ArrayList g;
    public py h;
    
    static {
        SideMenuFragment.i = 50;
    }
    
    private ListAdapter J() {
        this.g = new ArrayList();
        this.a(2130837545, 2131230785, 1, 20);
        this.a(2130837543, 2131230786, 2, 20);
        this.a(2130837542, 2131230779, 4, 20);
        this.a(2130837550, 2131230777, 3, 20);
        this.a(2130837547, 2131230781, 5, 20);
        this.a(0, 0, 0, 20);
        this.a(2130837549, 2131230778, 11, 20);
        this.a(2130837546, 2131230933, 12, 20);
        this.a(2130837544, 2131231070, 13, 16);
        return (ListAdapter)new px(this, (Context)super.C, this.g);
    }
    
    private void a(final int i, final int n, final int j, final int k) {
        final HashMap<String, Integer> e = new HashMap<String, Integer>();
        if (i != 0) {
            e.put("ICON", i);
        }
        if (n != 0) {
            e.put("TEXT", (Integer)super.C.getString(n));
        }
        e.put("MENUID", j);
        e.put("TEXTSIZE", k);
        this.g.add(e);
    }
    
    public final void I() {
        if (this.a != null) {
            this.a.invalidateViews();
        }
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2130903066, (ViewGroup)null);
        this.c = inflate.findViewById(2131623959);
        this.b = inflate.findViewById(2131623936);
        this.d = inflate.findViewById(2131624030);
        this.e = (TextView)inflate.findViewById(2131624002);
        (this.a = (ListView)inflate.findViewById(2131623939)).setAdapter(this.J());
        this.a.setOnItemClickListener((AdapterView$OnItemClickListener)new pu(this));
        inflate.findViewById(2131624054).setOnClickListener((View$OnClickListener)new pv(this));
        inflate.findViewById(2131624053).setOnClickListener((View$OnClickListener)new pw(this));
        return inflate;
    }
    
    @Override
    public final void a(final Activity activity) {
        super.a(activity);
        this.f = (Main)activity;
        this.h = (py)activity;
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
    }
    
    public final void b() {
        final yc a = gr.a((Context)super.C);
        this.c.setBackgroundColor(a.a(0));
        this.a.setBackgroundColor(a.a(0));
        this.b.setBackgroundColor(a.a(0));
        this.d.setBackgroundColor(a.a(1));
        this.e.setTextColor(a.a(3));
        final px px = (px)this.a.getAdapter();
        if (px != null) {
            px.notifyDataSetChanged();
        }
    }
    
    @Override
    public final void v() {
        super.v();
        this.a.setAdapter(this.J());
        this.b();
        if (rt.a((Context)this.f)) {
            this.e.setText((CharSequence)SyncStatus.a(rt.c((Context)this.f)));
            return;
        }
        this.e.setText((CharSequence)this.f.getString(2131231023));
    }
}
