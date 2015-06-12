// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity.a;

import android.os.Bundle;
import java.util.Iterator;
import android.widget.CompoundButton;
import android.view.View;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import java.util.ArrayList;
import android.view.View$OnClickListener;

public abstract class d extends b implements View$OnClickListener
{
    private int a;
    private ArrayList<Integer> b;
    
    public d() {
        this.a = -1;
        this.b = new ArrayList<Integer>();
    }
    
    private void a(final FragmentManager fragmentManager) {
        final Fragment fragmentByTag = fragmentManager.findFragmentByTag("TAG_FRAGMENT");
        if (fragmentByTag != null) {
            final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.detach(fragmentByTag);
            beginTransaction.remove(fragmentByTag);
            beginTransaction.commit();
            fragmentManager.executePendingTransactions();
        }
    }
    
    private void a(final FragmentManager fragmentManager, final Fragment fragment) {
        this.a(fragmentManager);
        final FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this.b(), fragment, "TAG_FRAGMENT");
        beginTransaction.commit();
        fragmentManager.executePendingTransactions();
    }
    
    protected abstract int a();
    
    protected abstract Fragment a(final int p0);
    
    protected abstract int b();
    
    protected void b(final int i) {
        this.b.add(i);
        this.findViewById(i).setOnClickListener((View$OnClickListener)this);
    }
    
    protected int c() {
        return this.a;
    }
    
    public void onClick(final View view) {
        final Iterator<Integer> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ((CompoundButton)this.findViewById(iterator.next())).setChecked(false);
        }
        final CompoundButton compoundButton = (CompoundButton)view;
        compoundButton.setChecked(true);
        if (this.getSupportFragmentManager().findFragmentByTag("TAG_FRAGMENT") == null || compoundButton.getId() != this.a) {
            this.a = compoundButton.getId();
            final Fragment a = this.a(this.a);
            if (a != null) {
                this.a(this.getSupportFragmentManager(), a);
            }
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("m_currentTab", -1);
        }
        if (this.a == -1) {
            this.a = this.a();
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("m_currentTab", this.a);
    }
}
