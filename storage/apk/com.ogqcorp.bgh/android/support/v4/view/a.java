// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.support.v4.view.a.a;
import android.support.v4.view.a.j;
import android.view.View;
import android.os.Build$VERSION;

public class a
{
    private static final c b;
    private static final Object c;
    final Object a;
    
    static {
        if (Build$VERSION.SDK_INT >= 16) {
            b = new d();
        }
        else if (Build$VERSION.SDK_INT >= 14) {
            b = new b();
        }
        else {
            b = new e();
        }
        c = a.b.a();
    }
    
    public a() {
        this.a = android.support.v4.view.a.b.a(this);
    }
    
    public j a(final View view) {
        return android.support.v4.view.a.b.a(android.support.v4.view.a.c, view);
    }
    
    Object a() {
        return this.a;
    }
    
    public void a(final View view, final int n) {
        android.support.v4.view.a.b.a(android.support.v4.view.a.c, view, n);
    }
    
    public void a(final View view, final android.support.v4.view.a.a a) {
        a.b.a(a.c, view, a);
    }
    
    public void a(final View view, final AccessibilityEvent accessibilityEvent) {
        android.support.v4.view.a.b.d(android.support.v4.view.a.c, view, accessibilityEvent);
    }
    
    public boolean a(final View view, final int n, final Bundle bundle) {
        return android.support.v4.view.a.b.a(android.support.v4.view.a.c, view, n, bundle);
    }
    
    public boolean a(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return android.support.v4.view.a.b.a(android.support.v4.view.a.c, viewGroup, view, accessibilityEvent);
    }
    
    public boolean b(final View view, final AccessibilityEvent accessibilityEvent) {
        return android.support.v4.view.a.b.a(android.support.v4.view.a.c, view, accessibilityEvent);
    }
    
    public void c(final View view, final AccessibilityEvent accessibilityEvent) {
        android.support.v4.view.a.b.c(android.support.v4.view.a.c, view, accessibilityEvent);
    }
    
    public void d(final View view, final AccessibilityEvent accessibilityEvent) {
        android.support.v4.view.a.b.b(android.support.v4.view.a.c, view, accessibilityEvent);
    }
}
