// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.support.v4.view.a.j;
import android.view.View;

class d extends b
{
    @Override
    public j a(final Object o, final View view) {
        final Object a = h.a(o, view);
        if (a != null) {
            return new j(a);
        }
        return null;
    }
    
    @Override
    public Object a(final a a) {
        return h.a(new i() {
            @Override
            public Object a(final View view) {
                final j a = a.a(view);
                if (a != null) {
                    return a.a();
                }
                return null;
            }
            
            @Override
            public void a(final View view, final int n) {
                a.a(view, n);
            }
            
            @Override
            public void a(final View view, final Object o) {
                a.a(view, new android.support.v4.view.a.a(o));
            }
            
            @Override
            public boolean a(final View view, final int n, final Bundle bundle) {
                return a.a(view, n, bundle);
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
    public boolean a(final Object o, final View view, final int n, final Bundle bundle) {
        return h.a(o, view, n, bundle);
    }
}
