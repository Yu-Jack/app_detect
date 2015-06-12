// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.View;

class h extends ad
{
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private ac c;
    private final Runnable d;
    
    private void b() {
        int n = 3;
        if (this.b == n) {
            n = 5;
        }
        final View a = this.a.a(n);
        if (a != null) {
            this.a.i(a);
        }
    }
    
    @Override
    public int a(final View view) {
        return view.getWidth();
    }
    
    @Override
    public int a(final View view, final int n, final int n2) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        final int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(n, width));
    }
    
    public void a() {
        this.a.removeCallbacks(this.d);
    }
    
    @Override
    public void a(final int n) {
        this.a.a(this.b, n, this.c.c());
    }
    
    @Override
    public void a(final int n, final int n2) {
        this.a.postDelayed(this.d, 160L);
    }
    
    @Override
    public void a(final View view, final float n, final float n2) {
        final float d = this.a.d(view);
        final int width = view.getWidth();
        int width2;
        if (this.a.a(view, 3)) {
            if (n > 0.0f || (n == 0.0f && d > 0.5f)) {
                width2 = 0;
            }
            else {
                width2 = -width;
            }
        }
        else {
            width2 = this.a.getWidth();
            if (n < 0.0f || (n == 0.0f && d > 0.5f)) {
                width2 -= width;
            }
        }
        this.c.a(width2, view.getTop());
        this.a.invalidate();
    }
    
    @Override
    public void a(final View view, final int n, final int n2, final int n3, final int n4) {
        final int width = view.getWidth();
        float n5;
        if (this.a.a(view, 3)) {
            n5 = (width + n) / width;
        }
        else {
            n5 = (this.a.getWidth() - n) / width;
        }
        this.a.b(view, n5);
        int visibility;
        if (n5 == 0.0f) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        view.setVisibility(visibility);
        this.a.invalidate();
    }
    
    @Override
    public boolean a(final View view, final int n) {
        return this.a.g(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }
    
    @Override
    public int b(final View view, final int n, final int n2) {
        return view.getTop();
    }
    
    @Override
    public void b(final int n, final int n2) {
        View view;
        if ((n & 0x1) == 0x1) {
            view = this.a.a(3);
        }
        else {
            view = this.a.a(5);
        }
        if (view != null && this.a.a(view) == 0) {
            this.c.a(view, n2);
        }
    }
    
    @Override
    public void b(final View view, final int n) {
        ((g)view.getLayoutParams()).c = false;
        this.b();
    }
    
    @Override
    public boolean b(final int n) {
        return false;
    }
}
