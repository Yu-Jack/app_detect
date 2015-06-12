// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build$VERSION;

public class a
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
    
    private static String b(final int n) {
        switch (n) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 1: {
                return "ACTION_FOCUS";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
        }
    }
    
    public Object a() {
        return this.b;
    }
    
    public void a(final int n) {
        android.support.v4.view.a.a.a.a(this.b, n);
    }
    
    public void a(final Rect rect) {
        android.support.v4.view.a.a.a.a(this.b, rect);
    }
    
    public void a(final CharSequence charSequence) {
        android.support.v4.view.a.a.a.a(this.b, charSequence);
    }
    
    public void a(final boolean b) {
        android.support.v4.view.a.a.a.a(this.b, b);
    }
    
    public int b() {
        return android.support.v4.view.a.a.a.a(this.b);
    }
    
    public void b(final Rect rect) {
        android.support.v4.view.a.a.a.b(this.b, rect);
    }
    
    public boolean c() {
        return android.support.v4.view.a.a.a.f(this.b);
    }
    
    public boolean d() {
        return android.support.v4.view.a.a.a.g(this.b);
    }
    
    public boolean e() {
        return android.support.v4.view.a.a.a.j(this.b);
    }
    
    @Override
    public boolean equals(final Object o) {
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
    
    public boolean f() {
        return android.support.v4.view.a.a.a.k(this.b);
    }
    
    public boolean g() {
        return android.support.v4.view.a.a.a.o(this.b);
    }
    
    public boolean h() {
        return android.support.v4.view.a.a.a.h(this.b);
    }
    
    @Override
    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }
    
    public boolean i() {
        return android.support.v4.view.a.a.a.l(this.b);
    }
    
    public boolean j() {
        return android.support.v4.view.a.a.a.i(this.b);
    }
    
    public boolean k() {
        return android.support.v4.view.a.a.a.m(this.b);
    }
    
    public boolean l() {
        return android.support.v4.view.a.a.a.n(this.b);
    }
    
    public CharSequence m() {
        return android.support.v4.view.a.a.a.d(this.b);
    }
    
    public CharSequence n() {
        return android.support.v4.view.a.a.a.b(this.b);
    }
    
    public CharSequence o() {
        return android.support.v4.view.a.a.a.e(this.b);
    }
    
    public CharSequence p() {
        return android.support.v4.view.a.a.a.c(this.b);
    }
    
    public String q() {
        return android.support.v4.view.a.a.a.p(this.b);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        final Rect rect = new Rect();
        this.a(rect);
        sb.append("; boundsInParent: " + rect);
        this.b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ").append(this.m());
        sb.append("; className: ").append(this.n());
        sb.append("; text: ").append(this.o());
        sb.append("; contentDescription: ").append(this.p());
        sb.append("; viewId: ").append(this.q());
        sb.append("; checkable: ").append(this.c());
        sb.append("; checked: ").append(this.d());
        sb.append("; focusable: ").append(this.e());
        sb.append("; focused: ").append(this.f());
        sb.append("; selected: ").append(this.g());
        sb.append("; clickable: ").append(this.h());
        sb.append("; longClickable: ").append(this.i());
        sb.append("; enabled: ").append(this.j());
        sb.append("; password: ").append(this.k());
        sb.append("; scrollable: " + this.l());
        sb.append("; [");
        int i = this.b();
        while (i != 0) {
            final int n = 1 << Integer.numberOfTrailingZeros(i);
            i &= ~n;
            sb.append(b(n));
            if (i != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
