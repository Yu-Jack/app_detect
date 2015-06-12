// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View;

class az
{
    public static void a(final View view) {
        view.postInvalidateOnAnimation();
    }
    
    public static void a(final View view, final int importantForAccessibility) {
        view.setImportantForAccessibility(importantForAccessibility);
    }
    
    public static void a(final View view, final int n, final int n2, final int n3, final int n4) {
        view.postInvalidate(n, n2, n3, n4);
    }
    
    public static void a(final View view, final Runnable runnable) {
        view.postOnAnimation(runnable);
    }
    
    public static int b(final View view) {
        return view.getImportantForAccessibility();
    }
}
