// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.View$AccessibilityDelegate;
import android.support.v4.view.a.h;
import android.view.View;

final class d extends b
{
    @Override
    public final h a(final Object o, final View view) {
        final AccessibilityNodeProvider accessibilityNodeProvider = ((View$AccessibilityDelegate)o).getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new h(accessibilityNodeProvider);
        }
        return null;
    }
    
    @Override
    public final Object a(final a a) {
        return new View$AccessibilityDelegate() {
            final /* synthetic */ i a;
            
            public final boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                return this.a.a(view, accessibilityEvent);
            }
            
            public final AccessibilityNodeProvider getAccessibilityNodeProvider(final View view) {
                return (AccessibilityNodeProvider)this.a.a(view);
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
            
            public final boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
                return this.a.a(view, n, bundle);
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
    public final boolean a(final Object o, final View view, final int n, final Bundle bundle) {
        return ((View$AccessibilityDelegate)o).performAccessibilityAction(view, n, bundle);
    }
}
