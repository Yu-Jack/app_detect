// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.Menu;
import android.os.Bundle;
import android.content.Context;
import android.app.Activity;
import android.support.v4.app.Fragment;

public abstract class ScreenFragment extends Fragment implements nc, pr, ra
{
    rc ap;
    rb aq;
    
    @Override
    public boolean M() {
        return false;
    }
    
    @Override
    public boolean N() {
        return false;
    }
    
    @Override
    public void a(final Activity activity) {
        super.a(activity);
        this.aq = (rb)activity;
    }
    
    @Override
    public final void a(final Context context) {
        if (this.l()) {
            final int c = gv.c(context);
            if (this.ap == null || this.ap.g != c) {
                if (this.ap != null) {
                    this.ap.c();
                }
                this.a(this.ap = new rc(this, c));
            }
        }
    }
    
    @Override
    public void a(final Bundle bundle) {
        super.a(bundle);
        this.a((Context)super.C);
    }
    
    @Override
    public final void a(final Menu menu) {
        this.b(this.ap);
        this.ap.a(menu);
    }
    
    @Override
    public final boolean a(final MenuItem menuItem) {
        return this.a(menuItem.getItemId(), null) || super.a(menuItem);
    }
    
    @Override
    public final rc ab() {
        return this.ap;
    }
    
    @Override
    public final ra ae() {
        return this;
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
    
    @Override
    public void w() {
        super.w();
        this.ap.c();
    }
}
