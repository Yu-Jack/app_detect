// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View$AccessibilityDelegate;
import android.view.View;

class am extends al
{
    @Override
    public final void a(final View view, final a a) {
        view.setAccessibilityDelegate((View$AccessibilityDelegate)a.a());
    }
    
    @Override
    public final boolean a(final View view) {
        return view.canScrollVertically(-1);
    }
    
    @Override
    public final boolean a(final View view, final int n) {
        return view.canScrollHorizontally(n);
    }
}
