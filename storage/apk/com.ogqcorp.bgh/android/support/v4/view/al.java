// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.os.Build$VERSION;

public class al
{
    static final au a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            a = new at();
            return;
        }
        if (sdk_INT >= 17) {
            a = new as();
            return;
        }
        if (sdk_INT >= 16) {
            a = new ar();
            return;
        }
        if (sdk_INT >= 14) {
            a = new aq();
            return;
        }
        if (sdk_INT >= 11) {
            a = new ap();
            return;
        }
        if (sdk_INT >= 9) {
            a = new ao();
            return;
        }
        a = new am();
    }
    
    public static int a(final View view) {
        return al.a.a(view);
    }
    
    public static void a(final View view, final int n, final int n2, final int n3, final int n4) {
        al.a.a(view, n, n2, n3, n4);
    }
    
    public static void a(final View view, final int n, final Paint paint) {
        al.a.a(view, n, paint);
    }
    
    public static void a(final View view, final Paint paint) {
        al.a.a(view, paint);
    }
    
    public static void a(final View view, final a a) {
        al.a.a(view, a);
    }
    
    public static void a(final View view, final Runnable runnable) {
        al.a.a(view, runnable);
    }
    
    public static boolean a(final View view, final int n) {
        return al.a.a(view, n);
    }
    
    public static void b(final View view) {
        al.a.b(view);
    }
    
    public static void b(final View view, final int n) {
        al.a.b(view, n);
    }
    
    public static int c(final View view) {
        return al.a.c(view);
    }
    
    public static int d(final View view) {
        return al.a.d(view);
    }
    
    public static int e(final View view) {
        return al.a.e(view);
    }
    
    public static boolean f(final View view) {
        return al.a.f(view);
    }
}
