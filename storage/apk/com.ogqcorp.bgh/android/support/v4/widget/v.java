// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.view.MotionEvent;
import android.view.ViewGroup$MarginLayoutParams;
import android.util.AttributeSet;
import android.graphics.Bitmap;
import android.util.Log;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuff$Mode;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.graphics.Paint;
import android.support.v4.view.al;
import android.view.View;

class v implements Runnable
{
    final View a;
    final /* synthetic */ SlidingPaneLayout b;
    
    v(final SlidingPaneLayout b, final View a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public void run() {
        if (this.a.getParent() == this.b) {
            al.a(this.a, 0, null);
            this.b.d(this.a);
        }
        this.b.t.remove(this);
    }
}
