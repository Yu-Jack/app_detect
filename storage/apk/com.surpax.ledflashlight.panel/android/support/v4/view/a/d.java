// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.view.accessibility.AccessibilityNodeInfo;

class d extends b
{
    @Override
    public final void b(final Object o, final int movementGranularities) {
        ((AccessibilityNodeInfo)o).setMovementGranularities(movementGranularities);
    }
    
    @Override
    public final void h(final Object o, final boolean visibleToUser) {
        ((AccessibilityNodeInfo)o).setVisibleToUser(visibleToUser);
    }
    
    @Override
    public final void i(final Object o, final boolean accessibilityFocused) {
        ((AccessibilityNodeInfo)o).setAccessibilityFocused(accessibilityFocused);
    }
    
    @Override
    public final int r(final Object o) {
        return ((AccessibilityNodeInfo)o).getMovementGranularities();
    }
    
    @Override
    public final boolean s(final Object o) {
        return ((AccessibilityNodeInfo)o).isVisibleToUser();
    }
    
    @Override
    public final boolean t(final Object o) {
        return ((AccessibilityNodeInfo)o).isAccessibilityFocused();
    }
}
