// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b.a;

import com.ogqcorp.bgh.system.StackScrollView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.os.Bundle;
import com.ogqcorp.bgh.c.a;
import com.ogqcorp.bgh.system.StackView;
import com.actionbarsherlock.app.SherlockFragment;

public abstract class b extends SherlockFragment
{
    private StackView a;
    private a b;
    
    public void a(final a adapter) {
        this.f().setAdapter(adapter);
    }
    
    protected abstract int c();
    
    protected abstract a d();
    
    public StackView f() {
        return this.a;
    }
    
    public a g() {
        return this.b;
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        this.a(this.b = this.d());
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(this.c(), viewGroup, false);
    }
    
    @Override
    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        (this.a = (StackView)view.findViewById(16908298)).setScrollView((StackScrollView)view.findViewById(2131099793));
    }
}
