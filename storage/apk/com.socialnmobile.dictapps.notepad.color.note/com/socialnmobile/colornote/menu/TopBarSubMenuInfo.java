// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.menu;

import java.util.Iterator;
import java.util.List;
import android.widget.SimpleAdapter;
import java.util.HashMap;
import android.widget.ListAdapter;
import android.view.View;
import android.support.v4.app.Fragment;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.content.Context;
import java.util.ArrayList;

public final class TopBarSubMenuInfo
{
    qq a;
    public ArrayList b;
    String c;
    int d;
    public rg e;
    
    public TopBarSubMenuInfo(final Context context, final String c, final rg e) {
        int d = 1;
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final int n = (int)(displayMetrics.widthPixels / displayMetrics.density);
        if ((gv.a(context) > 400 || !gw.b(context)) && n >= 400) {
            d = 2;
        }
        this.d = d;
        this.b = new ArrayList();
        this.c = c;
        this.e = e;
    }
    
    public final Dialog a(final Context context) {
        return new TopBarSubMenuInfo$SubMenuDialogFragment(this).a(context);
    }
    
    public final void a(final int n, final int n2, final int n3) {
        this.b.add(new rf(n, n2, n3));
    }
    
    public final void a(final int n, final int n2, final String s) {
        this.b.add(new rf(0, n, n2, s));
    }
    
    public final void a(final Fragment fragment, final m m, final View view, final boolean b) {
        if (!fragment.m()) {
            return;
        }
        if (this.d == 1 || b) {
            fragment.h();
            new TopBarSubMenuInfo$SubMenuDialogFragment(this).a(m, "dialog");
            return;
        }
        (this.a = new qq(view.getContext(), view, this.b, this.e)).a();
    }
    
    public final ListAdapter b(final Context context) {
        final ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (final rf rf : this.b) {
            final HashMap<String, String> e = new HashMap<String, String>();
            e.put("ICON", (String)rf.b);
            e.put("TEXT", context.getString(rf.c));
            list.add(e);
        }
        return (ListAdapter)new SimpleAdapter(context, (List)list, 2130903085, new String[] { "ICON", "TEXT" }, new int[] { 2131624093, 2131624033 });
    }
}
