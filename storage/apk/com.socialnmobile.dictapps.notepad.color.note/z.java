import android.util.SparseArray;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.widget.FrameLayout;

// 
// Decompiled by Procyon v0.5.29
// 

final class z extends FrameLayout
{
    private z(final Context context) {
        super(context);
    }
    
    static ViewGroup a(final View view) {
        final z z = new z(view.getContext());
        final ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            z.setLayoutParams(layoutParams);
        }
        view.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(-1, -1));
        z.addView(view);
        return (ViewGroup)z;
    }
    
    protected final void dispatchRestoreInstanceState(final SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }
    
    protected final void dispatchSaveInstanceState(final SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }
}
