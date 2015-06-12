import android.view.View;
import android.support.v4.widget.DrawerLayout$LayoutParams;

// 
// Decompiled by Procyon v0.5.29
// 

final class dh implements Runnable
{
    final /* synthetic */ dg a;
    
    dh(final dg a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final dg a = this.a;
        final int b = a.b.b();
        boolean b2;
        if (a.a == 3) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        View view;
        int n3;
        if (b2) {
            final View a2 = a.c.a(3);
            int n = 0;
            if (a2 != null) {
                n = -a2.getWidth();
            }
            final int n2 = n + b;
            view = a2;
            n3 = n2;
        }
        else {
            final View a3 = a.c.a(5);
            final int n4 = a.c.getWidth() - b;
            view = a3;
            n3 = n4;
        }
        if (view != null && ((b2 && view.getLeft() < n3) || (!b2 && view.getLeft() > n3)) && a.c.a(view) == 0) {
            final DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            a.b.a(view, n3, view.getTop());
            drawerLayout$LayoutParams.c = true;
            a.c.invalidate();
            a.b();
            a.c.c();
        }
    }
}
