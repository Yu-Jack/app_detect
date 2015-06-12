// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ThemeFragmentActivity extends FragmentActivity
{
    yd F;
    
    public final void a(final int n, final ye d) {
        this.F.d = d;
        this.F.a(n);
    }
    
    public final void l() {
        this.F.a();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.F = new yd(this);
    }
    
    protected void onResume() {
        super.onResume();
        this.F.a();
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        final o b = super.b;
        while (true) {
            final Fragment a = b.a("dialog");
            if (a == null) {
                break;
            }
            final u a2 = b.a();
            a2.a(a);
            a2.b();
            b.b();
        }
        super.onSaveInstanceState(bundle);
    }
    
    protected void onStart() {
        super.onStart();
        eg.a((Context)this, "7WTGHNWSX5PSDGSHN65D");
    }
    
    protected void onStop() {
        super.onStop();
        eg.a((Context)this);
    }
}
