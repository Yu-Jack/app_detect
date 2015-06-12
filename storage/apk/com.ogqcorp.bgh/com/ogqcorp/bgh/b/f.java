// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.widget.AdapterView;
import android.os.Bundle;
import android.view.ViewGroup;
import com.ogqcorp.bgh.c.a;
import com.ogqcorp.bgh.system.l;
import java.util.List;
import java.util.Collections;
import android.support.v4.app.FragmentActivity;
import com.ogqcorp.commons.c;
import com.ogqcorp.bgh.system.r;
import com.ogqcorp.bgh.system.o;
import android.view.View;
import android.view.animation.Animation;
import android.content.Context;
import android.view.animation.AnimationUtils;
import com.ogqcorp.bgh.system.q;
import com.ogqcorp.bgh.item.Category;
import java.util.ArrayList;
import com.ogqcorp.bgh.system.m;
import com.ogqcorp.bgh.item.Categories;
import android.widget.AdapterView$OnItemClickListener;
import com.ogqcorp.bgh.b.a.b;

@m(a = "CATEGORIES")
public final class f extends b implements AdapterView$OnItemClickListener, com.ogqcorp.commons.b<Object, Categories>
{
    private static ArrayList<Category> a;
    private q b;
    
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
    
    private void e() {
        this.a(true);
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        c.a(activity, 0, "CATEGORIES", 43200000L, o.b().f((Context)activity), this.a(), r.f, this);
    }
    
    protected q a() {
        if (this.b == null) {
            this.b = new q();
        }
        return this.b;
    }
    
    public void a(final Categories categories) {
        if (this.getActivity() == null) {
            return;
        }
        this.a(false);
        Collections.sort(f.a = categories.getCategoriesList());
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
    
    @Override
    protected int c() {
        return 2130903079;
    }
    
    @Override
    protected a d() {
        return new a() {
            final /* synthetic */ Context a = this.getActivity();
            
            @Override
            public View a(final int index, final View view, final ViewGroup viewGroup, final boolean b) {
                return f.a.get(index).a(this.a, view, viewGroup, b);
            }
            
            public int getCount() {
                if (f.a == null) {
                    return 0;
                }
                return f.a.size();
            }
            
            public Object getItem(final int index) {
                if (f.a == null) {
                    return null;
                }
                return f.a.get(index);
            }
            
            public long getItemId(final int n) {
                return n;
            }
        };
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        if (f.a == null) {
            this.e();
        }
    }
    
    @Override
    public void onDestroy() {
        if (this.b != null) {
            this.b.a(true);
            this.b = null;
        }
        super.onDestroy();
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int index, final long n) {
        try {
            ((g)this.getActivity()).a(f.a.get(index));
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f().setOnItemClickListener((AdapterView$OnItemClickListener)this);
    }
}
