// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.support.v4.view.n;
import android.view.KeyEvent;
import android.support.v4.view.s;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.support.v4.view.j;
import android.support.v4.view.av;
import android.support.v4.view.a;
import android.view.View;
import android.support.v4.view.ah;
import android.graphics.drawable.Drawable;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewGroup$MarginLayoutParams;

public class DrawerLayout$LayoutParams extends ViewGroup$MarginLayoutParams
{
    public int a;
    float b;
    boolean c;
    boolean d;
    
    public DrawerLayout$LayoutParams() {
        super(-1, -1);
        this.a = 0;
    }
    
    public DrawerLayout$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = 0;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, DrawerLayout.a);
        this.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }
    
    public DrawerLayout$LayoutParams(final DrawerLayout$LayoutParams drawerLayout$LayoutParams) {
        super((ViewGroup$MarginLayoutParams)drawerLayout$LayoutParams);
        this.a = 0;
        this.a = drawerLayout$LayoutParams.a;
    }
    
    public DrawerLayout$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.a = 0;
    }
    
    public DrawerLayout$LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.a = 0;
    }
}
