// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.animation.Interpolator;
import android.content.Context;
import android.os.Build$VERSION;

public class o
{
    static final p b;
    Object a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 14) {
            b = new s();
            return;
        }
        if (sdk_INT >= 9) {
            b = new r();
            return;
        }
        b = new q();
    }
    
    o(final Context context, final Interpolator interpolator) {
        this.a = o.b.a(context, interpolator);
    }
    
    public static o a(final Context context) {
        return a(context, null);
    }
    
    public static o a(final Context context, final Interpolator interpolator) {
        return new o(context, interpolator);
    }
    
    public void a(final int n, final int n2, final int n3, final int n4, final int n5) {
        o.b.a(this.a, n, n2, n3, n4, n5);
    }
    
    public void a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        o.b.a(this.a, n, n2, n3, n4, n5, n6, n7, n8);
    }
    
    public boolean a() {
        return o.b.a(this.a);
    }
    
    public int b() {
        return o.b.b(this.a);
    }
    
    public int c() {
        return o.b.c(this.a);
    }
    
    public int d() {
        return o.b.g(this.a);
    }
    
    public int e() {
        return o.b.h(this.a);
    }
    
    public float f() {
        return o.b.d(this.a);
    }
    
    public boolean g() {
        return o.b.e(this.a);
    }
    
    public void h() {
        o.b.f(this.a);
    }
}
