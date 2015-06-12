// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.View;

final class e extends aa
{
    final /* synthetic */ DrawerLayout a;
    private final int b;
    private z c;
    private final Runnable d;
    
    public e(final DrawerLayout a, final int b) {
        this.a = a;
        this.d = new Runnable() {
            @Override
            public final void run() {
                e.a(e.this);
            }
        };
        this.b = b;
    }
    
    static /* synthetic */ void a(final e e) {
        final int b = e.c.b();
        boolean b2;
        if (e.b == 3) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        View view;
        int n3;
        if (b2) {
            final View b3 = e.a.b(3);
            int n = 0;
            if (b3 != null) {
                n = -b3.getWidth();
            }
            final int n2 = n + b;
            view = b3;
            n3 = n2;
        }
        else {
            final View b4 = e.a.b(5);
            final int n4 = e.a.getWidth() - b;
            view = b4;
            n3 = n4;
        }
        if (view != null && ((b2 && view.getLeft() < n3) || (!b2 && view.getLeft() > n3)) && e.a.a(view) == 0) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            e.c.a(view, n3, view.getTop());
            drawerLayout$LayoutParams.c = true;
            e.a.invalidate();
            e.c();
            e.a.a();
        }
    }
    
    private void c() {
        int n = 3;
        if (this.b == n) {
            n = 5;
        }
        final View b = this.a.b(n);
        if (b != null) {
            this.a.e(b);
        }
    }
    
    public final void a() {
        this.a.removeCallbacks(this.d);
    }
    
    @Override
    public final void a(final int n) {
        final DrawerLayout a = this.a;
        final int b = this.b;
        a.a(n, this.c.c());
    }
    
    @Override
    public final void a(final int n, final int n2) {
        View view;
        if ((n & 0x1) == 0x1) {
            view = this.a.b(3);
        }
        else {
            view = this.a.b(5);
        }
        if (view != null && this.a.a(view) == 0) {
            this.c.a(view, n2);
        }
    }
    
    public final void a(final z c) {
        this.c = c;
    }
    
    @Override
    public final void a(final View view, final float n) {
        final DrawerLayout a = this.a;
        final float b = DrawerLayout.b(view);
        final int width = view.getWidth();
        int width2;
        if (this.a.a(view, 3)) {
            if (n > 0.0f || (n == 0.0f && b > 0.5f)) {
                width2 = 0;
            }
            else {
                width2 = -width;
            }
        }
        else {
            width2 = this.a.getWidth();
            if (n < 0.0f || (n == 0.0f && b > 0.5f)) {
                width2 -= width;
            }
        }
        this.c.a(width2, view.getTop());
        this.a.invalidate();
    }
    
    @Override
    public final void a(final View view, final int n) {
        final int width = view.getWidth();
        float n2;
        if (this.a.a(view, 3)) {
            n2 = (width + n) / width;
        }
        else {
            n2 = (this.a.getWidth() - n) / width;
        }
        this.a.a(view, n2);
        int visibility;
        if (n2 == 0.0f) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        view.setVisibility(visibility);
        this.a.invalidate();
    }
    
    @Override
    public final boolean a(final View view) {
        final DrawerLayout a = this.a;
        return DrawerLayout.d(view) && this.a.a(view, this.b) && this.a.a(view) == 0;
    }
    
    @Override
    public final int b(final View view, final int n) {
        if (this.a.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        final int width = this.a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(n, width));
    }
    
    @Override
    public final void b() {
        this.a.postDelayed(this.d, 160L);
    }
    
    @Override
    public final void b(final View view) {
        ((DrawerLayout$LayoutParams)view.getLayoutParams()).c = false;
        this.c();
    }
    
    @Override
    public final int c(final View view) {
        return view.getWidth();
    }
    
    @Override
    public final int d(final View view) {
        return view.getTop();
    }
}
