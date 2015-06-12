// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.n;
import android.view.KeyEvent;
import android.support.v4.view.s;
import android.view.ViewGroup$MarginLayoutParams;
import android.graphics.Canvas;
import android.view.ViewGroup$LayoutParams;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.support.v4.view.j;
import android.support.v4.view.av;
import android.support.v4.view.ah;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.view.View;
import android.support.v4.view.a;

final class c extends a
{
    final /* synthetic */ DrawerLayout b;
    
    c(final DrawerLayout b) {
        this.b = b;
    }
    
    @Override
    public final void a(final View view, final android.support.v4.view.a.a a) {
        super.a(view, a);
        if (!DrawerLayout.f(view)) {
            a.c((View)null);
        }
    }
}
