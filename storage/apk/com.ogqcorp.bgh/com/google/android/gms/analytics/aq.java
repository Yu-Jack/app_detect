// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.util.Log;

class aq implements i
{
    private int a;
    
    aq() {
        this.a = 1;
    }
    
    private String e(final String str) {
        return Thread.currentThread().toString() + ": " + str;
    }
    
    @Override
    public int a() {
        return this.a;
    }
    
    @Override
    public void a(final int a) {
        this.a = a;
    }
    
    @Override
    public void a(final String s) {
        if (this.a <= 0) {
            Log.v("GAV4", this.e(s));
        }
    }
    
    @Override
    public void b(final String s) {
        if (this.a <= 1) {
            Log.i("GAV4", this.e(s));
        }
    }
    
    @Override
    public void c(final String s) {
        if (this.a <= 2) {
            Log.w("GAV4", this.e(s));
        }
    }
    
    @Override
    public void d(final String s) {
        if (this.a <= 3) {
            Log.e("GAV4", this.e(s));
        }
    }
}
