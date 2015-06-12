// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import java.util.Iterator;
import java.util.Collection;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import android.annotation.TargetApi;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.ogqcorp.bgh.item.Backgrounds;
import android.support.v4.app.FragmentActivity;
import com.ogqcorp.commons.c;
import com.ogqcorp.bgh.system.r;
import android.content.Context;
import com.ogqcorp.bgh.system.o;
import android.os.Bundle;

public final class o extends d
{
    private String a;
    
    public static o a(final String s) {
        final o o = new o();
        final Bundle arguments = new Bundle();
        arguments.putString("KEY_TAG", s);
        o.setArguments(arguments);
        return o;
    }
    
    @Override
    protected void a() {
        super.a();
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        com.ogqcorp.commons.c.a(activity, 0, "TAG", 43200000L, com.ogqcorp.bgh.system.o.b().a((Context)activity), this.e(), r.d, this);
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
    protected void a(final ArrayList<Background> list) {
        final ArrayList<Background> c = new ArrayList<Background>();
        final String string = " " + this.a + " ";
        for (final Background e : list) {
            if ((" " + e.getTags() + " ").indexOf(string) != -1) {
                c.add(e);
            }
        }
        list.clear();
        list.addAll(c);
    }
    
    @Override
    protected ArrayList<Background> b() {
        return null;
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = this.getArguments().getString("KEY_TAG");
    }
}
