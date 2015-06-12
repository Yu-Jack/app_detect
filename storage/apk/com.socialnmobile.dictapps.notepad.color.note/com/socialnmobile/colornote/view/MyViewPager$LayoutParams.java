// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.graphics.Rect;
import android.view.View$MeasureSpec;
import android.util.Log;
import android.graphics.Canvas;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import java.util.List;
import java.util.Collections;
import android.view.ViewParent;
import android.os.Build$VERSION;
import android.view.ViewConfiguration;
import android.view.SoundEffectConstants;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.widget.Scroller;
import android.os.Parcelable;
import java.util.ArrayList;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;
import java.util.Comparator;
import android.view.ViewGroup;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$LayoutParams;

public class MyViewPager$LayoutParams extends ViewGroup$LayoutParams
{
    public boolean a;
    public int b;
    
    public MyViewPager$LayoutParams() {
        super(-1, -1);
    }
    
    public MyViewPager$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, MyViewPager.a);
        this.b = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
    }
}
