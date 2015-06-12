// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Paint;
import android.view.ViewGroup$MarginLayoutParams;

public class SlidingPaneLayout$LayoutParams extends ViewGroup$MarginLayoutParams
{
    private static final int[] e;
    public float a;
    boolean b;
    boolean c;
    Paint d;
    
    static {
        e = new int[] { 16843137 };
    }
    
    public SlidingPaneLayout$LayoutParams() {
        super(-1, -1);
        this.a = 0.0f;
    }
    
    public SlidingPaneLayout$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = 0.0f;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, SlidingPaneLayout$LayoutParams.e);
        this.a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }
    
    public SlidingPaneLayout$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.a = 0.0f;
    }
    
    public SlidingPaneLayout$LayoutParams(final ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams) {
        super(viewGroup$MarginLayoutParams);
        this.a = 0.0f;
    }
}
