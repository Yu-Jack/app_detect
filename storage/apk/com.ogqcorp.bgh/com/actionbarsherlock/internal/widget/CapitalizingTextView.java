// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import java.util.Locale;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.widget.TextView;

public class CapitalizingTextView extends TextView
{
    private static final boolean IS_GINGERBREAD;
    private static final int[] R_styleable_TextView;
    private static final int R_styleable_TextView_textAllCaps;
    private static final boolean SANS_ICE_CREAM;
    private boolean mAllCaps;
    
    static {
        SANS_ICE_CREAM = (Build$VERSION.SDK_INT < 14);
        IS_GINGERBREAD = (Build$VERSION.SDK_INT >= 9);
        R_styleable_TextView = new int[] { 16843660 };
    }
    
    public CapitalizingTextView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public CapitalizingTextView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, CapitalizingTextView.R_styleable_TextView, n, 0);
        this.mAllCaps = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }
    
    public void setTextCompat(final CharSequence text) {
        if (CapitalizingTextView.SANS_ICE_CREAM && this.mAllCaps && text != null) {
            if (CapitalizingTextView.IS_GINGERBREAD) {
                try {
                    this.setText((CharSequence)text.toString().toUpperCase(Locale.ROOT));
                    return;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    this.setText((CharSequence)text.toString().toUpperCase());
                    return;
                }
            }
            this.setText((CharSequence)text.toString().toUpperCase());
            return;
        }
        this.setText(text);
    }
}
