// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.support.v4.view.a;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.graphics.Paint;
import android.support.v4.view.ah;
import android.view.View;

final class p implements Runnable
{
    final View a;
    final /* synthetic */ SlidingPaneLayout b;
    
    p(final SlidingPaneLayout b, final View a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.getParent() == this.b) {
            ah.a(this.a, 0, null);
            this.b.c(this.a);
        }
        this.b.u.remove(this);
    }
}
