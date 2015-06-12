import android.text.format.Time;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.KeyEvent;
import android.text.format.DateUtils;
import android.graphics.Paint$Align;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import java.util.Calendar;
import android.preference.PreferenceManager;
import java.util.Iterator;
import android.graphics.ColorFilter;
import android.graphics.PathEffect;
import android.graphics.Typeface;
import android.graphics.Paint$Style;
import android.graphics.Bitmap$Config;
import android.view.GestureDetector$OnGestureListener;
import android.util.AttributeSet;
import android.content.Context;
import android.util.SparseArray;
import android.graphics.RectF;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.widget.PopupWindow;
import java.util.ArrayList;
import android.graphics.Rect;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.graphics.Path;
import android.graphics.Paint;
import android.view.View$OnCreateContextMenuListener;
import android.view.View;

public final class zl extends GestureDetector$SimpleOnGestureListener
{
    final /* synthetic */ MonthView a;
    
    public zl(final MonthView a) {
        this.a = a;
    }
    
    private void a(final MotionEvent motionEvent) {
        MonthView.e(this.a).a(this.a.a((int)motionEvent.getY()), this.a.b((int)motionEvent.getX()));
    }
    
    public final boolean onDown(final MotionEvent motionEvent) {
        MonthView.a(this.a, true);
        return true;
    }
    
    public final boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        MonthView.a(this.a, false);
        MonthView.a(this.a, 0);
        final int abs = Math.abs((int)motionEvent2.getX() - (int)motionEvent.getX());
        final int abs2 = Math.abs((int)motionEvent2.getY() - (int)motionEvent.getY());
        if (abs2 < MonthView.g() || abs2 < abs) {
            return false;
        }
        final Time b = MonthView.b(this.a);
        b.set(MonthView.c(this.a));
        if (n2 < 0.0f) {
            ++b.month;
        }
        else {
            --b.month;
        }
        jk.a(b);
        MonthView.d(this.a).a(b);
        return true;
    }
    
    public final void onLongPress(final MotionEvent motionEvent) {
        if (MonthView.f(this.a) != 0) {
            MonthView.a(this.a, 0);
            MonthView.b(this.a, 1);
            this.a.invalidate();
        }
        final int n = (int)motionEvent.getX();
        final int a = this.a.a((int)motionEvent.getY());
        final int b = this.a.b(n);
        if (MonthView.e(this.a).isWithinCurrentMonth(a, b) && MonthView.g(this.a) != null) {
            MonthView.e(this.a).a(a, b);
            MonthView.g(this.a).b(this.a.d());
        }
    }
    
    public final boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        MonthView.a(this.a, false);
        if (MonthView.f(this.a) != 0) {
            MonthView.a(this.a, 0);
            MonthView.b(this.a, 1);
            this.a.invalidate();
        }
        return true;
    }
    
    public final void onShowPress(final MotionEvent motionEvent) {
        this.a(motionEvent);
        MonthView.a(this.a, 1);
        MonthView.b(this.a, 2);
        this.a.invalidate();
    }
    
    public final boolean onSingleTapUp(final MotionEvent motionEvent) {
        if (MonthView.h(this.a)) {
            this.a(motionEvent);
            MonthView.a(this.a, false);
            final int n = (int)motionEvent.getX();
            final int a = this.a.a((int)motionEvent.getY());
            final int b = this.a.b(n);
            MonthView.e(this.a).a(a, b);
            if (MonthView.e(this.a).isWithinCurrentMonth(a, b)) {
                MonthView.a(this.a, 1);
                MonthView.b(this.a, 1);
                this.a.invalidate();
                if (MonthView.g(this.a) != null) {
                    MonthView.g(this.a).a(this.a.d());
                }
            }
            else if (!MonthView.e(this.a).isWithinCurrentMonth(a, b) && MonthView.g(this.a) != null) {
                MonthView.g(this.a);
                this.a.d();
            }
            this.a.postDelayed((Runnable)new zm(this), 100L);
        }
        return true;
    }
}
