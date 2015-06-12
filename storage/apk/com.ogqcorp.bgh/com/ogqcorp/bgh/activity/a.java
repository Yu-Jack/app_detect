// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.commons.x;
import java.io.File;
import com.ogqcorp.commons.u;
import android.support.v4.app.FragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.commons.t;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.system.ac;
import com.actionbarsherlock.view.Menu;
import android.view.View;
import android.app.Activity;
import com.ogqcorp.bgh.a.a;
import android.support.v4.view.bl;
import android.support.v4.view.af;
import android.os.Bundle;
import java.util.Collection;
import android.content.Intent;
import android.content.Context;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.system.d;
import android.view.ViewGroup;
import com.ogqcorp.bgh.b.b;
import com.ogqcorp.bgh.item.Background;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class a extends FragmentStatePagerAdapter
{
    final /* synthetic */ BackgroundActivity a;
    
    public a(final BackgroundActivity a, final FragmentManager fragmentManager) {
        this.a = a;
        super(fragmentManager);
    }
    
    @Override
    public int getCount() {
        return this.a.a.size();
    }
    
    @Override
    public Fragment getItem(final int index) {
        return b.b(this.a.a.get(index));
    }
    
    @Override
    public void setPrimaryItem(final ViewGroup viewGroup, final int n, final Object o) {
        super.setPrimaryItem(viewGroup, n, o);
        if (!(o instanceof b)) {
            return;
        }
        this.a.f = (b)o;
        this.a.b = this.a.e.getCurrentItem();
        if (this.a.c == this.a.b) {
            return;
        }
        while (true) {
            try {
                d.c(this.a.a.get(this.a.b).getId());
                this.a.d++;
                this.a.c = this.a.b;
            }
            catch (Exception ex) {
                l.a(ex);
                continue;
            }
            break;
        }
    }
}
