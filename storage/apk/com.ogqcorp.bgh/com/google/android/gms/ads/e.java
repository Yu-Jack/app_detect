// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.ads;

import android.view.View;
import android.content.Context;
import com.google.android.gms.internal.ab;
import android.view.ViewGroup;

public final class e extends ViewGroup
{
    private final ab a;
    
    public e(final Context context) {
        super(context);
        this.a = new ab(this);
    }
    
    public void a() {
        this.a.a();
    }
    
    public void a(final b b) {
        this.a.a(b.a());
    }
    
    public void b() {
        this.a.f();
    }
    
    public void c() {
        this.a.g();
    }
    
    public a getAdListener() {
        return this.a.b();
    }
    
    public d getAdSize() {
        return this.a.c();
    }
    
    public String getAdUnitId() {
        return this.a.d();
    }
    
    public com.google.android.gms.ads.d.b getInAppPurchaseListener() {
        return this.a.e();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        final View child = this.getChildAt(0);
        if (child != null && child.getVisibility() != 8) {
            final int measuredWidth = child.getMeasuredWidth();
            final int measuredHeight = child.getMeasuredHeight();
            final int n5 = (n3 - n - measuredWidth) / 2;
            final int n6 = (n4 - n2 - measuredHeight) / 2;
            child.layout(n5, n6, measuredWidth + n5, measuredHeight + n6);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        final View child = this.getChildAt(0);
        final d adSize = this.getAdSize();
        int a;
        int a2;
        if (child != null && child.getVisibility() != 8) {
            this.measureChild(child, n, n2);
            a = child.getMeasuredWidth();
            a2 = child.getMeasuredHeight();
        }
        else if (adSize != null) {
            final Context context = this.getContext();
            a = adSize.b(context);
            a2 = adSize.a(context);
        }
        else {
            a2 = 0;
            a = 0;
        }
        this.setMeasuredDimension(View.resolveSize(Math.max(a, this.getSuggestedMinimumWidth()), n), View.resolveSize(Math.max(a2, this.getSuggestedMinimumHeight()), n2));
    }
    
    public void setAdListener(final a a) {
        this.a.a(a);
    }
    
    public void setAdSize(final d d) {
        this.a.a(d);
    }
    
    public void setAdUnitId(final String s) {
        this.a.a(s);
    }
    
    public void setInAppPurchaseListener(final com.google.android.gms.ads.d.b b) {
        this.a.a(b);
    }
}
