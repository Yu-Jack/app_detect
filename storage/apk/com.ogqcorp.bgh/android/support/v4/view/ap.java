// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ap extends ao
{
    @Override
    long a() {
        return ax.a();
    }
    
    @Override
    public void a(final View view, final int n, final Paint paint) {
        ax.a(view, n, paint);
    }
    
    @Override
    public void a(final View view, final Paint paint) {
        this.a(view, this.d(view), paint);
        view.invalidate();
    }
    
    @Override
    public int d(final View view) {
        return ax.a(view);
    }
}
