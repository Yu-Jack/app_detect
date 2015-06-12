// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewParent;
import android.view.View;

class an extends am
{
    @Override
    public final void a(final View view, final int n, final int n2, final int n3, final int n4) {
        view.postInvalidate(n, n2, n3, n4);
    }
    
    @Override
    public final void a(final View view, final Runnable runnable) {
        view.postOnAnimation(runnable);
    }
    
    @Override
    public void b(final View view, int importantForAccessibility) {
        if (importantForAccessibility == 4) {
            importantForAccessibility = 2;
        }
        view.setImportantForAccessibility(importantForAccessibility);
    }
    
    @Override
    public final void c(final View view) {
        view.postInvalidateOnAnimation();
    }
    
    @Override
    public final int d(final View view) {
        return view.getImportantForAccessibility();
    }
    
    @Override
    public final ViewParent g(final View view) {
        return view.getParentForAccessibility();
    }
}
