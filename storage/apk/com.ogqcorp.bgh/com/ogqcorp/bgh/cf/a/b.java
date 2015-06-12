// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.a;

import com.ogqcorp.bgh.cf.c.b.e;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v4.view.af;
import com.ogqcorp.bgh.cf.d;
import java.util.Arrays;
import android.content.Context;
import com.ogqcorp.bgh.cf.f;
import com.a.a.x;
import java.util.regex.Matcher;
import java.util.Random;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.HashSet;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import com.a.a.r;
import com.a.a.s;
import com.ogqcorp.bgh.cf.b.b;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class b extends FragmentStatePagerAdapter
{
    final /* synthetic */ a a;
    
    public b(final a a, final FragmentManager fragmentManager) {
        this.a = a;
        super(fragmentManager);
    }
    
    @Override
    public int getCount() {
        return this.a.c.size();
    }
    
    @Override
    public Fragment getItem(final int index) {
        final String o = this.a.c.get(index);
        return com.ogqcorp.bgh.cf.b.a.a(o, this.a.f.contains(o));
    }
    
    @Override
    public void setPrimaryItem(final ViewGroup viewGroup, final int index, final Object o) {
        super.setPrimaryItem(viewGroup, index, o);
        this.a.g = this.a.c.get(index);
    }
}
