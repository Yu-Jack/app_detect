// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class b extends e
{
    @Override
    public Object a() {
        return f.a();
    }
    
    @Override
    public Object a(final a a) {
        return f.a(new g() {
            @Override
            public void a(final View view, final int n) {
                a.a(view, n);
            }
            
            @Override
            public void a(final View view, final Object o) {
                a.a(view, new android.support.v4.view.a.a(o));
            }
            
            @Override
            public boolean a(final View view, final AccessibilityEvent accessibilityEvent) {
                return a.b(view, accessibilityEvent);
            }
            
            @Override
            public boolean a(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
                return a.a(viewGroup, view, accessibilityEvent);
            }
            
            @Override
            public void b(final View view, final AccessibilityEvent accessibilityEvent) {
                a.d(view, accessibilityEvent);
            }
            
            @Override
            public void c(final View view, final AccessibilityEvent accessibilityEvent) {
                a.c(view, accessibilityEvent);
            }
            
            @Override
            public void d(final View view, final AccessibilityEvent accessibilityEvent) {
                a.a(view, accessibilityEvent);
            }
        });
    }
    
    @Override
    public void a(final Object o, final View view, final int n) {
        f.a(o, view, n);
    }
    
    @Override
    public void a(final Object o, final View view, final android.support.v4.view.a.a a) {
        f.a(o, view, a.a());
    }
    
    @Override
    public boolean a(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return f.a(o, view, accessibilityEvent);
    }
    
    @Override
    public boolean a(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return f.a(o, viewGroup, view, accessibilityEvent);
    }
    
    @Override
    public void b(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        f.b(o, view, accessibilityEvent);
    }
    
    @Override
    public void c(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        f.c(o, view, accessibilityEvent);
    }
    
    @Override
    public void d(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        f.d(o, view, accessibilityEvent);
    }
}
