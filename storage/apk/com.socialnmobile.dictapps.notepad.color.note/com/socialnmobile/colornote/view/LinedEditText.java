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

public class LinedEditText extends MyEditText
{
    Runnable a;
    private Rect b;
    private Paint c;
    private int d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private zk i;
    private GestureDetector j;
    private boolean k;
    
    public LinedEditText(final Context context, final AttributeSet set) {
        super(context, set);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.k = false;
        this.a = new zi(this);
        this.b = new Rect();
        (this.c = new Paint()).setStyle(Paint$Style.STROKE);
        this.e = "";
        this.setMovementMethod((MovementMethod)new zj(this));
        this.j = new GestureDetector(context, (GestureDetector$OnGestureListener)new GestureDetector$SimpleOnGestureListener());
    }
    
    private String a(final CharSequence charSequence, int g, final boolean h) {
        int length = charSequence.length();
        if (this.i == null) {
            return "";
        }
        if (g < 0) {
            return "";
        }
        String string = null;
        int n4 = 0;
        int n5 = 0;
        Label_0063: {
            if (charSequence.length() != 0 && g < length && Character.isLetterOrDigit(charSequence.charAt(g))) {
                while (true) {
                    for (int i = g; i >= 0; --i) {
                        if (!Character.isLetterOrDigit(Character.valueOf(charSequence.charAt(i)))) {
                            int n = i + 1;
                            if (i < 0) {
                                n = 0;
                            }
                            int j = g;
                            while (true) {
                                while (j < length) {
                                    if (!Character.isLetterOrDigit(Character.valueOf(charSequence.charAt(j)))) {
                                        final int n2 = j;
                                        if (j < length) {
                                            length = n2;
                                        }
                                        string = charSequence.subSequence(n, length).toString();
                                        if (string == null) {
                                            string = "";
                                            final int n3 = length;
                                            n4 = n;
                                            n5 = n3;
                                            break Label_0063;
                                        }
                                        final int n6 = length;
                                        n4 = n;
                                        n5 = n6;
                                        break Label_0063;
                                    }
                                    else {
                                        ++j;
                                    }
                                }
                                final int n2 = g;
                                continue;
                            }
                        }
                    }
                    int n = g;
                    continue;
                }
            }
            string = "";
            n5 = g;
            n4 = g;
        }
        String s;
        int f;
        if (n4 > n5) {
            s = "";
            f = g;
        }
        else {
            g = n5;
            f = n4;
            s = string;
        }
        if (!this.e.equals(s) || this.f != f) {
            this.e = s;
            this.f = f;
            this.g = g;
            this.h = h;
            if (this.getHandler() != null) {
                this.getHandler().removeCallbacks(this.a);
                this.getHandler().postDelayed(this.a, 100L);
            }
        }
        return this.e;
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
    
    public final void a(final int n) {
        this.a((CharSequence)this.getText(), n, false);
        this.setSelection(this.f, this.g);
    }
    
    protected void onDraw(final Canvas canvas) {
        int i = 0;
        final int lineCount = this.getLineCount();
        final Rect b = this.b;
        final Paint c = this.c;
        int lineBounds;
        for (int j = 0; j < lineCount; ++j, i = lineBounds) {
            lineBounds = this.getLineBounds(j, b);
            canvas.drawLine((float)b.left, (float)(lineBounds + 1), (float)b.right, (float)(lineBounds + 1), c);
        }
        while (i < this.getHeight()) {
            final int n = i + this.getLineHeight();
            canvas.drawLine((float)b.left, (float)(n + 1), (float)b.right, (float)(n + 1), c);
            i = n;
        }
        super.onDraw(canvas);
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (!this.k) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        if (!(parcelable instanceof TextView$SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((TextView$SavedState)parcelable).getSuperState());
    }
    
    protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
        super.onScrollChanged(n, n2, n3, n4);
        if (n2 > 0) {
            this.requestLayout();
        }
    }
    
    protected void onSelectionChanged(final int n, final int n2) {
        super.onSelectionChanged(n, n2);
        if (n != n2) {
            return;
        }
        this.a((CharSequence)this.getText(), n, false);
    }
    
    @Override
    protected void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        this.a(charSequence, n, true);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.j.onTouchEvent(motionEvent)) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }
    
    public void setColor(final int d) {
        this.d = d;
        this.c.setColor(gr.a(this.getContext()).d(d));
        this.setBackgroundColor(gr.a(this.getContext()).b(d));
    }
    
    public void setDoNotRestore(final boolean k) {
        this.k = k;
    }
    
    public void setOnDoubleTapListener(final GestureDetector$OnDoubleTapListener onDoubleTapListener) {
        this.j.setOnDoubleTapListener(onDoubleTapListener);
    }
    
    public void setOnWordChangedListener(final zk i) {
        this.i = i;
    }
}
