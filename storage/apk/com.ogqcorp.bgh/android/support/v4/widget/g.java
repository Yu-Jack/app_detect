// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.t;
import android.view.KeyEvent;
import android.support.v4.view.aa;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.support.v4.view.o;
import android.support.v4.view.al;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public class g extends ViewGroup$MarginLayoutParams
{
    public int a;
    float b;
    boolean c;
    boolean d;
    
    public g(final int n, final int n2) {
        super(n, n2);
        this.a = 0;
    }
    
    public g(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, DrawerLayout.a);
        this.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }
    
    public g(final g g) {
        super((ViewGroup$MarginLayoutParams)g);
        this.a = 0;
        this.a = g.a;
    }
    
    public g(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.a = 0;
    }
    
    public g(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.a = 0;
    }
}
