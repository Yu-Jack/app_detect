// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.view.View;
import android.graphics.Rect;
import android.os.Build$VERSION;

public final class a
{
    private static final c a;
    private final Object b;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            a = new f();
            return;
        }
        if (Build$VERSION.SDK_INT >= 18) {
            a = new e();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            a = new d();
            return;
        }
        if (Build$VERSION.SDK_INT >= 14) {
            a = new b();
            return;
        }
        a = new g();
    }
    
    public a(final Object b) {
        this.b = b;
    }
    
    public static a a(final a a) {
        final Object a2 = a.a.a(a.b);
        if (a2 != null) {
            return new a(a2);
        }
        return null;
    }
    
    public final Object a() {
        return this.b;
    }
    
    public final void a(final int n) {
        android.support.v4.view.a.a.a.a(this.b, n);
    }
    
    public final void a(final Rect rect) {
        android.support.v4.view.a.a.a.a(this.b, rect);
    }
    
    public final void a(final View view) {
        android.support.v4.view.a.a.a.c(this.b, view);
    }
    
    public final void a(final CharSequence charSequence) {
        android.support.v4.view.a.a.a.c(this.b, charSequence);
    }
    
    public final void a(final boolean b) {
        android.support.v4.view.a.a.a.c(this.b, b);
    }
    
    public final int b() {
        return android.support.v4.view.a.a.a.b(this.b);
    }
    
    public final void b(final int n) {
        android.support.v4.view.a.a.a.b(this.b, n);
    }
    
    public final void b(final Rect rect) {
        android.support.v4.view.a.a.a.c(this.b, rect);
    }
    
    public final void b(final View view) {
        android.support.v4.view.a.a.a.a(this.b, view);
    }
    
    public final void b(final CharSequence charSequence) {
        android.support.v4.view.a.a.a.a(this.b, charSequence);
    }
    
    public final void b(final boolean b) {
        android.support.v4.view.a.a.a.d(this.b, b);
    }
    
    public final int c() {
        return android.support.v4.view.a.a.a.r(this.b);
    }
    
    public final void c(final Rect rect) {
        android.support.v4.view.a.a.a.b(this.b, rect);
    }
    
    public final void c(final View view) {
        android.support.v4.view.a.a.a.b(this.b, view);
    }
    
    public final void c(final CharSequence charSequence) {
        android.support.v4.view.a.a.a.b(this.b, charSequence);
    }
    
    public final void c(final boolean b) {
        android.support.v4.view.a.a.a.h(this.b, b);
    }
    
    public final void d(final Rect rect) {
        android.support.v4.view.a.a.a.d(this.b, rect);
    }
    
    public final void d(final boolean b) {
        android.support.v4.view.a.a.a.i(this.b, b);
    }
    
    public final boolean d() {
        return android.support.v4.view.a.a.a.k(this.b);
    }
    
    public final void e(final boolean b) {
        android.support.v4.view.a.a.a.g(this.b, b);
    }
    
    public final boolean e() {
        return android.support.v4.view.a.a.a.l(this.b);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final a a = (a)o;
            if (this.b == null) {
                if (a.b != null) {
                    return false;
                }
            }
            else if (!this.b.equals(a.b)) {
                return false;
            }
        }
        return true;
    }
    
    public final void f(final boolean b) {
        android.support.v4.view.a.a.a.a(this.b, b);
    }
    
    public final boolean f() {
        return android.support.v4.view.a.a.a.s(this.b);
    }
    
    public final void g(final boolean b) {
        android.support.v4.view.a.a.a.e(this.b, b);
    }
    
    public final boolean g() {
        return android.support.v4.view.a.a.a.t(this.b);
    }
    
    public final void h(final boolean b) {
        android.support.v4.view.a.a.a.b(this.b, b);
    }
    
    public final boolean h() {
        return android.support.v4.view.a.a.a.p(this.b);
    }
    
    @Override
    public final int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }
    
    public final void i(final boolean b) {
        android.support.v4.view.a.a.a.f(this.b, b);
    }
    
    public final boolean i() {
        return android.support.v4.view.a.a.a.i(this.b);
    }
    
    public final boolean j() {
        return android.support.v4.view.a.a.a.m(this.b);
    }
    
    public final boolean k() {
        return android.support.v4.view.a.a.a.j(this.b);
    }
    
    public final CharSequence l() {
        return android.support.v4.view.a.a.a.e(this.b);
    }
    
    public final CharSequence m() {
        return android.support.v4.view.a.a.a.c(this.b);
    }
    
    public final CharSequence n() {
        return android.support.v4.view.a.a.a.d(this.b);
    }
    
    public final void o() {
        android.support.v4.view.a.a.a.q(this.b);
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        final Rect rect = new Rect();
        this.a(rect);
        sb.append("; boundsInParent: " + rect);
        this.c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(this.l());
        sb.append("; className: ").append(this.m());
        sb.append("; text: ").append(android.support.v4.view.a.a.a.f(this.b));
        sb.append("; contentDescription: ").append(this.n());
        sb.append("; viewId: ").append(android.support.v4.view.a.a.a.u(this.b));
        sb.append("; checkable: ").append(android.support.v4.view.a.a.a.g(this.b));
        sb.append("; checked: ").append(android.support.v4.view.a.a.a.h(this.b));
        sb.append("; focusable: ").append(this.d());
        sb.append("; focused: ").append(this.e());
        sb.append("; selected: ").append(this.h());
        sb.append("; clickable: ").append(this.i());
        sb.append("; longClickable: ").append(this.j());
        sb.append("; enabled: ").append(this.k());
        sb.append("; password: ").append(android.support.v4.view.a.a.a.n(this.b));
        sb.append("; scrollable: " + android.support.v4.view.a.a.a.o(this.b));
        sb.append("; [");
        int n2;
        for (int i = this.b(); i != 0; i = n2) {
            final int n = 1 << Integer.numberOfTrailingZeros(i);
            n2 = (i & ~n);
            String str = null;
            switch (n) {
                default: {
                    str = "ACTION_UNKNOWN";
                    break;
                }
                case 1: {
                    str = "ACTION_FOCUS";
                    break;
                }
                case 2: {
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                }
                case 4: {
                    str = "ACTION_SELECT";
                    break;
                }
                case 8: {
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                }
                case 16: {
                    str = "ACTION_CLICK";
                    break;
                }
                case 32: {
                    str = "ACTION_LONG_CLICK";
                    break;
                }
                case 64: {
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                }
                case 128: {
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                }
                case 256: {
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                }
                case 512: {
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                }
                case 1024: {
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                }
                case 2048: {
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                }
                case 4096: {
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                }
                case 8192: {
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                }
                case 65536: {
                    str = "ACTION_CUT";
                    break;
                }
                case 16384: {
                    str = "ACTION_COPY";
                    break;
                }
                case 32768: {
                    str = "ACTION_PASTE";
                    break;
                }
                case 131072: {
                    str = "ACTION_SET_SELECTION";
                    break;
                }
            }
            sb.append(str);
            if (n2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
