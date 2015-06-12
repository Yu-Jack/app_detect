// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.View$AccessibilityDelegate;

class b extends e
{
    @Override
    public final Object a() {
        return new View$AccessibilityDelegate();
    }
    
    @Override
    public Object a(final a a) {
        return new View$AccessibilityDelegate() {
            final /* synthetic */ g a;
            
            public final boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                return this.a.a(view, accessibilityEvent);
            }
            
            public final void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                this.a.b(view, accessibilityEvent);
            }
            
            public final void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfo accessibilityNodeInfo) {
                this.a.a(view, accessibilityNodeInfo);
            }
            
            public final void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                this.a.c(view, accessibilityEvent);
            }
            
            public final boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
                return this.a.a(viewGroup, view, accessibilityEvent);
            }
            
            public final void sendAccessibilityEvent(final View view, final int n) {
                this.a.a(view, n);
            }
            
            public final void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
                this.a.d(view, accessibilityEvent);
            }
        };
    }
    
    @Override
    public final void a(final Object o, final View view, final int n) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEvent(view, n);
    }
    
    @Override
    public final void a(final Object o, final View view, final android.support.v4.view.a.a a) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)a.a());
    }
    
    @Override
    public final boolean a(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public final boolean a(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    @Override
    public final void b(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public final void c(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public final void d(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
