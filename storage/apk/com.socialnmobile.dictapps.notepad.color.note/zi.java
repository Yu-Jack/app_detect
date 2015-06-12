// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.TextView$SavedState;
import android.os.Parcelable;
import android.graphics.Canvas;
import android.text.Layout;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.text.method.MovementMethod;
import android.graphics.Paint$Style;
import android.util.AttributeSet;
import android.content.Context;
import android.view.GestureDetector;
import android.graphics.Paint;
import android.graphics.Rect;

public final class zi implements Runnable
{
    final /* synthetic */ LinedEditText a;
    
    public zi(final LinedEditText a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (LinedEditText.a(this.a) != null) {
            final zk a = LinedEditText.a(this.a);
            final String b = LinedEditText.b(this.a);
            final int c = LinedEditText.c(this.a);
            final int d = LinedEditText.d(this.a);
            LinedEditText.e(this.a);
            a.a(b, c, d);
        }
    }
}
