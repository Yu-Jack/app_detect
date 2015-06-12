// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.GestureDetector$OnDoubleTapListener;
import android.content.ActivityNotFoundException;
import android.widget.Toast;
import android.view.MotionEvent;
import android.widget.TextView$SavedState;
import android.os.Parcelable;
import android.graphics.Canvas;
import android.text.Layout;
import android.view.GestureDetector$OnGestureListener;
import android.view.GestureDetector$SimpleOnGestureListener;
import android.graphics.Paint$Style;
import android.util.AttributeSet;
import android.content.Context;
import android.view.GestureDetector;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.TextView;

public class LinedTextView extends TextView
{
    private Rect a;
    private Paint b;
    private int c;
    private GestureDetector d;
    private boolean e;
    
    public LinedTextView(final Context context, final AttributeSet set) {
        super(context, set);
        this.e = false;
        this.a = new Rect();
        (this.b = new Paint()).setStyle(Paint$Style.STROKE);
        this.d = new GestureDetector(context, (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener());
        jf.a(this, new zu().a(this));
    }
    
    public final int a(final int n, final int n2) {
        int n3 = n - this.getTotalPaddingLeft();
        final int n4 = n2 - this.getTotalPaddingTop();
        if (n3 < 0) {
            n3 = 0;
        }
        else if (n3 >= this.getWidth() - this.getTotalPaddingRight()) {
            n3 = -1 + (this.getWidth() - this.getTotalPaddingRight());
        }
        int n5 = 0;
        if (n4 >= 0) {
            if (n4 >= this.getHeight() - this.getTotalPaddingBottom()) {
                n5 = -1 + (this.getHeight() - this.getTotalPaddingBottom());
            }
            else {
                n5 = n4;
            }
        }
        final int n6 = n3 + this.getScrollX();
        final int n7 = n5 + this.getScrollY();
        final Layout layout = this.getLayout();
        return layout.getOffsetForHorizontal(layout.getLineForVertical(n7), (float)n6);
    }
    
    protected void onDraw(final Canvas canvas) {
        int i = 0;
        final int lineCount = this.getLineCount();
        final Rect a = this.a;
        final Paint b = this.b;
        int lineBounds;
        for (int j = 0; j < lineCount; ++j, i = lineBounds) {
            lineBounds = this.getLineBounds(j, a);
            canvas.drawLine((float)a.left, (float)(lineBounds + 1), (float)a.right, (float)(lineBounds + 1), b);
        }
        while (i < this.getHeight()) {
            final int n = i + this.getLineHeight();
            canvas.drawLine((float)a.left, (float)(n + 1), (float)a.right, (float)(n + 1), b);
            i = n;
        }
        super.onDraw(canvas);
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!this.e) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        if (!(parcelable instanceof TextView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((TextView$SavedState)parcelable).getSuperState());
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        this.d.onTouchEvent(motionEvent);
        try {
            super.onTouchEvent(motionEvent);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            Toast.makeText(this.getContext(), 2131230839, 0).show();
            return true;
        }
    }
    
    public void setColor(final int c) {
        this.c = c;
        this.b.setColor(gr.a(this.getContext()).d(c));
        this.setBackgroundColor(gr.a(this.getContext()).b(c));
    }
    
    public void setDoNotRestore(final boolean e) {
        this.e = e;
    }
    
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener onDoubleTapListener) {
        this.d.setOnDoubleTapListener(onDoubleTapListener);
    }
}
