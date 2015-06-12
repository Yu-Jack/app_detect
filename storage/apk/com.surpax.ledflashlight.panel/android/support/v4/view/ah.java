// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewParent;
import android.graphics.Paint;
import android.view.View;
import android.os.Build$VERSION;

public final class ah
{
    static final aq a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            a = new ap();
            return;
        }
        if (sdk_INT >= 17) {
            a = new ao();
            return;
        }
        if (sdk_INT >= 16) {
            a = new an();
            return;
        }
        if (sdk_INT >= 14) {
            a = new am();
            return;
        }
        if (sdk_INT >= 11) {
            a = new al();
            return;
        }
        if (sdk_INT >= 9) {
            a = new ak();
            return;
        }
        a = new ai();
    }
    
    public static void a(final View view, final int n, final int n2, final int n3, final int n4) {
        ah.a.a(view, n, n2, n3, n4);
    }
    
    public static void a(final View view, final int n, final Paint paint) {
        ah.a.a(view, n, paint);
    }
    
    public static void a(final View view, final Paint paint) {
        ah.a.a(view, paint);
    }
    
    public static void a(final View view, final a a) {
        ah.a.a(view, a);
    }
    
    public static void a(final View view, final Runnable runnable) {
        ah.a.a(view, runnable);
    }
    
    public static boolean a(final View view) {
        return ah.a.a(view);
    }
    
    public static boolean a(final View view, final int n) {
        return ah.a.a(view, n);
    }
    
    public static int b(final View view) {
        return ah.a.b(view);
    }
    
    public static void b(final View view, final int n) {
        ah.a.b(view, n);
    }
    
    public static void c(final View view) {
        ah.a.c(view);
    }
    
    public static int d(final View view) {
        return ah.a.d(view);
    }
    
    public static int e(final View view) {
        return ah.a.e(view);
    }
    
    public static int f(final View view) {
        return ah.a.f(view);
    }
    
    public static ViewParent g(final View view) {
        return ah.a.g(view);
    }
    
    public static boolean h(final View view) {
        return ah.a.h(view);
    }
}
