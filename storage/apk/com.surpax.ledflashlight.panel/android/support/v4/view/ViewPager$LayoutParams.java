// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import java.util.List;
import java.util.Collections;
import android.content.res.Resources$NotFoundException;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.View;
import android.view.ViewConfiguration;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import java.util.ArrayList;
import android.support.v4.widget.f;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;

public class ViewPager$LayoutParams extends ViewGroup$LayoutParams
{
    public boolean a;
    public int b;
    float c;
    boolean d;
    int e;
    int f;
    
    public ViewPager$LayoutParams() {
        super(-1, -1);
        this.c = 0.0f;
    }
    
    public ViewPager$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = 0.0f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ViewPager.a);
        this.b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
