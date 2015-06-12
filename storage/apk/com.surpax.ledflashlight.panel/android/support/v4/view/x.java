// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.ViewParent;
import android.view.View$MeasureSpec;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.text.TextUtils$TruncateAt;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.widget.TextView;
import android.view.ViewGroup;
import android.database.DataSetObserver;

final class x extends DataSetObserver implements be, bf
{
    final /* synthetic */ PagerTitleStrip a;
    private int b;
    
    private x(final PagerTitleStrip a) {
        this.a = a;
    }
    
    public final void a() {
        if (this.b == 0) {
            final PagerTitleStrip a = this.a;
            final int b = this.a.a.b();
            this.a.a.a();
            a.b(b);
            final float n = fcmpl(this.a.g, 0.0f);
            float a2 = 0.0f;
            if (n >= 0) {
                a2 = this.a.g;
            }
            this.a.a(this.a.a.b(), a2, true);
        }
    }
    
    public final void a(final int b) {
        this.b = b;
    }
    
    public final void a(int n, final float n2) {
        if (n2 > 0.5f) {
            ++n;
        }
        this.a.a(n, n2, false);
    }
    
    public final void onChanged() {
        final PagerTitleStrip a = this.a;
        final int b = this.a.a.b();
        this.a.a.a();
        a.b(b);
        final float n = fcmpl(this.a.g, 0.0f);
        float a2 = 0.0f;
        if (n >= 0) {
            a2 = this.a.g;
        }
        this.a.a(this.a.a.b(), a2, true);
    }
}
