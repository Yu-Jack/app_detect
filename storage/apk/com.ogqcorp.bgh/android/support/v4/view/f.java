// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.View$AccessibilityDelegate;

class f
{
    public static Object a() {
        return new View$AccessibilityDelegate();
    }
    
    public static Object a(final g g) {
        return new View$AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                return g.a(view, accessibilityEvent);
            }
            
            public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                g.b(view, accessibilityEvent);
            }
            
            public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfo accessibilityNodeInfo) {
                g.a(view, accessibilityNodeInfo);
            }
            
            public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                g.c(view, accessibilityEvent);
            }
            
            public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
                return g.a(viewGroup, view, accessibilityEvent);
            }
            
            public void sendAccessibilityEvent(final View view, final int n) {
                g.a(view, n);
            }
            
            public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
                g.d(view, accessibilityEvent);
            }
        };
    }
    
    public static void a(final Object o, final View view, final int n) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEvent(view, n);
    }
    
    public static void a(final Object o, final View view, final Object o2) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo)o2);
    }
    
    public static boolean a(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static boolean a(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return ((View$AccessibilityDelegate)o).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public static void b(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static void c(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static void d(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        ((View$AccessibilityDelegate)o).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
