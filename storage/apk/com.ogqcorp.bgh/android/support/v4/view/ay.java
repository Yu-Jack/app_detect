// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View$AccessibilityDelegate;
import android.view.View;

class ay
{
    public static void a(final View view, final Object o) {
        view.setAccessibilityDelegate((View$AccessibilityDelegate)o);
    }
    
    public static boolean a(final View view, final int n) {
        return view.canScrollHorizontally(n);
    }
}
