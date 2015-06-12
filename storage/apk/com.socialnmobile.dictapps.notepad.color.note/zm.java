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

final class zm implements Runnable
{
    final /* synthetic */ zl a;
    
    zm(final zl a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        MonthView.a(this.a.a, 0);
        MonthView.b(this.a.a, 1);
        this.a.a.invalidate();
    }
}
