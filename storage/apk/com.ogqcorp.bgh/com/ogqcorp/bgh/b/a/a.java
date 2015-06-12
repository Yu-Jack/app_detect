// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b.a;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.ogqcorp.commons.b;
import com.actionbarsherlock.app.SherlockFragment;

public abstract class a<T> extends SherlockFragment implements b<Object, T>
{
    private T a;
    private boolean b;
    
    public a() {
        this.b = false;
    }
    
    private void b(final View view) {
        this.a(view);
    }
    
    private void c(final View view) {
        if (view == null || this.a == null || this.b) {
            return;
        }
        this.b = true;
        this.a(view, this.a);
    }
    
    protected abstract int a();
    
    protected void a(final View view) {
    }
    
    protected void a(final View view, final T t) {
    }
    
    @Override
    public void a(final Exception ex) {
    }
    
    @Override
    public void a(final T a) {
        this.a = a;
        this.c(this.getView());
    }
    
    public T d() {
        return this.a;
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        return layoutInflater.inflate(this.a(), viewGroup, false);
    }
    
    @Override
    public void onDestroy() {
        this.a = null;
        super.onDestroy();
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.b(view);
        this.c(view);
    }
}
