// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.util.SparseArray;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.FrameLayout;

final class p extends FrameLayout
{
    private p(final Context context) {
        super(context);
    }
    
    static ViewGroup a(final View view) {
        final p p = new p(view.getContext());
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            p.setLayoutParams(layoutParams);
        }
        view.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        p.addView(view);
        return (ViewGroup)p;
    }
    
    protected final void dispatchRestoreInstanceState(final SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }
    
    protected final void dispatchSaveInstanceState(final SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }
}
