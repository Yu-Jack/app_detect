// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.database.DataSetObserver;
import android.view.View$MeasureSpec;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.util.Log;
import android.os.Build$VERSION;
import android.view.KeyEvent;
import android.content.res.Resources$NotFoundException;
import android.view.ViewConfiguration;
import java.util.List;
import java.util.Collections;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.lang.reflect.Method;
import android.support.v4.widget.i;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;

public class bi extends ViewGroup$LayoutParams
{
    public boolean a;
    public int b;
    float c;
    boolean d;
    int e;
    int f;
    
    public bi() {
        super(-1, -1);
        this.c = 0.0f;
    }
    
    public bi(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = 0.0f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ViewPager.a);
        this.b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
