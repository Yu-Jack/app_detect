// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.view.accessibility.AccessibilityRecord;

class r extends v
{
    @Override
    public final Object a() {
        return AccessibilityRecord.obtain();
    }
    
    @Override
    public final void a(final Object o, final int fromIndex) {
        ((AccessibilityRecord)o).setFromIndex(fromIndex);
    }
    
    @Override
    public final void a(final Object o, final boolean scrollable) {
        ((AccessibilityRecord)o).setScrollable(scrollable);
    }
    
    @Override
    public final void b(final Object o, final int itemCount) {
        ((AccessibilityRecord)o).setItemCount(itemCount);
    }
    
    @Override
    public final void c(final Object o, final int toIndex) {
        ((AccessibilityRecord)o).setToIndex(toIndex);
    }
}
