import android.support.v4.widget.DrawerLayout$LayoutParams;
import android.view.View;
import android.support.v4.widget.DrawerLayout;

// 
// Decompiled by Procyon v0.5.29
// 

public final class dg extends dw
{
    final int a;
    public dt b;
    final /* synthetic */ DrawerLayout c;
    private final Runnable d;
    
    public dg(final DrawerLayout c, final int a) {
        this.c = c;
        this.d = new dh(this);
        this.a = a;
    }
    
    public final void a() {
        this.c.removeCallbacks(this.d);
    }
    
    @Override
    public final void a(final int n) {
        final DrawerLayout c = this.c;
        final int a = this.a;
        c.a(n, this.b.c());
    }
    
    @Override
    public final void a(final int n, final int n2) {
        View view;
        if ((n & 0x1) == 0x1) {
            view = this.c.a(3);
        }
        else {
            view = this.c.a(5);
        }
        if (view != null && this.c.a(view) == 0) {
            this.b.a(view, n2);
        }
    }
    
    @Override
    public final void a(final View view, final float n) {
        final DrawerLayout c = this.c;
        final float b = DrawerLayout.b(view);
        final int width = view.getWidth();
        int width2;
        if (this.c.a(view, 3)) {
            if (n > 0.0f || (n == 0.0f && b > 0.5f)) {
                width2 = 0;
            }
            else {
                width2 = -width;
            }
        }
        else {
            width2 = this.c.getWidth();
            if (n < 0.0f || (n == 0.0f && b > 0.5f)) {
                width2 -= width;
            }
        }
        this.b.a(width2, view.getTop());
        this.c.invalidate();
    }
    
    @Override
    public final void a(final View view, final int n) {
        final int width = view.getWidth();
        float n2;
        if (this.c.a(view, 3)) {
            n2 = (width + n) / width;
        }
        else {
            n2 = (this.c.getWidth() - n) / width;
        }
        this.c.a(view, n2);
        int visibility;
        if (n2 == 0.0f) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        view.setVisibility(visibility);
        this.c.invalidate();
    }
    
    @Override
    public final boolean a(final View view) {
        final DrawerLayout c = this.c;
        return DrawerLayout.c(view) && this.c.a(view, this.a) && this.c.a(view) == 0;
    }
    
    @Override
    public final int b(final View view, final int n) {
        if (this.c.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(n, 0));
        }
        final int width = this.c.getWidth();
        return Math.max(width - view.getWidth(), Math.min(n, width));
    }
    
    final void b() {
        int n = 3;
        if (this.a == n) {
            n = 5;
        }
        final View a = this.c.a(n);
        if (a != null) {
            this.c.d(a);
        }
    }
    
    @Override
    public final void b(final View view) {
        ((DrawerLayout$LayoutParams)view.getLayoutParams()).c = false;
        this.b();
    }
    
    @Override
    public final int c(final View view) {
        return view.getWidth();
    }
    
    @Override
    public final void c() {
        this.c.postDelayed(this.d, 160L);
    }
    
    @Override
    public final int d(final View view) {
        return view.getTop();
    }
}
